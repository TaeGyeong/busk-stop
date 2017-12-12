package com.buskstop.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.StageService;
import com.buskstop.vo.Stage;
import com.buskstop.vo.StageImage;
import com.buskstop.vo.StageReservation;
import com.buskstop.vo.User;

@Controller
public class StageController {

	@Autowired
	private StageService service;
	
	@Autowired(required=true)
	private HttpServletRequest request;
	
	private String getUserId() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		
		return ((User)authentication.getPrincipal()).getUserId();
	}
	
	
	@RequestMapping("/stageReservation")
	public ModelAndView selectStage(@ModelAttribute Stage stage) {
		
		return new ModelAndView("stageView.do","stage",stage);
	}
	//공연장 등록
	@RequestMapping("/stageRegister")
	public ModelAndView insertStage(@ModelAttribute Stage stage, MultipartHttpServletRequest mhsq, HttpServletRequest request) throws IllegalStateException, IOException {
//		System.out.println("넘어오냐"+stage.getStageStartTime());
//		System.out.println("넘어오냐"+stage.getStageEndTime());
		stage.setStageReservation(0);
		service.insertStage(stage);
		//파일 경로
		String dir = request.getServletContext().getRealPath("/stageImage");
		
		//넘어온 파일을 리스트로 저장
		List<MultipartFile> mf = mhsq.getFiles("imgs");
		if(mf.size()==1 && mf.get(0).getOriginalFilename().equals("")) {
		}else {	for(int i=0; i< mf.size(); i++) {
				//파일 중복명 처리, 저장되는 파일 이름
				String fileName = UUID.randomUUID().toString();
				//파일 저장
				File upImage = new File(dir, fileName+".jpg");
				mf.get(i).transferTo(upImage);
				StageImage uploadImage = new StageImage(0, fileName, stage.getStageNo());
				service.insertStageImage(uploadImage);
			}
		}

		return new ModelAndView("redirect:/selectAllStage.do");
	}
	
	@RequestMapping("/selectAllStage")
	public ModelAndView selectAllStage(@RequestParam(required=false) String locationSearch, 
									   @RequestParam(required=false) String idSearch,
									   @RequestParam(required=false) String nameSearch, 
									   @RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate, 
									   @RequestParam(required=false) @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) throws Exception{
		List<Stage> list = null;
		Map<String, Object> map = null;
		int page=1;
		
		try {
			page = Integer.parseInt(request.getParameter("page"));
		}catch (Exception e) {
			
		}
		if(locationSearch==null && nameSearch==null && startDate==null && endDate==null && idSearch==null ) {
			map = service.selectAllStage(page);
			locationSearch="";
			nameSearch="";
			startDate=null;
			endDate=null;
			idSearch="";
		}
		else {
		if(locationSearch=="" && nameSearch=="" && startDate!=null && endDate!=null && idSearch=="" ) {
			map = service.selectStageByStageDate(page,startDate,endDate);
		} /* 날짜 없이 2개 검색 */
		else if(locationSearch!="" && nameSearch!="" && startDate==null && endDate==null && idSearch=="") {
			map = service.selectStageByLocationAndNameNoDate(page,locationSearch,nameSearch);
		} else if(locationSearch!="" && nameSearch=="" && startDate==null && endDate==null && idSearch!="") {
			map = service.selectStageByLocationAndIDNoDate(page,locationSearch,idSearch);
		}else if(locationSearch=="" && nameSearch!="" && startDate==null && endDate==null && idSearch!="") {
			map = service.selectStageByNameAndIdNoDate(page,nameSearch,idSearch);
		}	/* 날짜 있이 2개 검색 */ 
		else if(locationSearch=="" && nameSearch!="" && startDate!=null && endDate!=null && idSearch=="") {
			map = service.selectStageByName(page,nameSearch,startDate,endDate);
		} else if(locationSearch!="" && nameSearch=="" && startDate!=null && endDate!=null && idSearch=="") {
			map = service.selectStageByStageLocation(page,locationSearch,startDate,endDate);
		} else if(locationSearch=="" && nameSearch=="" && startDate!=null && endDate!=null && idSearch!="") {
			map = service.selectStageByStageSellerId(page,idSearch,startDate,endDate);
		} /* 위는 중복 검색 아래는 단일 검색 */
		  else if(idSearch!="" && locationSearch=="" && nameSearch=="" && startDate==null && endDate==null) {
			map = service.selectStageOnlyId(page,idSearch);
		} else if(idSearch=="" && locationSearch!="" && nameSearch=="" && startDate==null && endDate==null) {
			map = service.selectStageOnlyLocation(page,locationSearch);
		} else if(idSearch=="" && locationSearch=="" && nameSearch!="" && startDate==null && endDate==null) {
			map = service.selectStageOnlyName(page,nameSearch);
		} /* 3개 검색 */
		  else if(locationSearch!="" && nameSearch!="" && startDate!=null && endDate!=null && idSearch==""){
			map = service.selectStageByLocationAndName(page,locationSearch,startDate,endDate,nameSearch);
		}	}
		
		
		list = (List<Stage>)map.get("list");
		System.out.println("나오는 리스트 "+list);
		map.put("list", list);
		
		map.put("stageLocation", locationSearch);
		map.put("stageName", nameSearch);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("stageSellerId", idSearch);
		
		return new ModelAndView("stage/stageView.tiles","map",map);
		
	}
	
	// 공연장 정보 공연장 수정에 빼와서 뿌려주기
	@RequestMapping("/updateStage")
	public ModelAndView updateStageByStageNo(@RequestParam int stageNo) {
		Stage stage = service.selectStageByStageNo(stageNo);
		List<StageImage> stageImage = service.selectStageImageByStageNo(stageNo);
		stage.setStageImage(stageImage);
		return new ModelAndView("stageUpdateView.do", "stage", stage);
	}
	

	
	//공연정보 받아서 수정
	@RequestMapping("/updateStageChange")
	public ModelAndView updateStageChange(@ModelAttribute Stage stage, MultipartHttpServletRequest mhsq, HttpServletRequest request) throws IllegalStateException, IOException {
		//공연장 변경
		service.updateStage(stage);
		
		//파일 경로
		String dir = request.getServletContext().getRealPath("/stageImage");
		
		//넘어온 파일을 리스트로 저장
		List<MultipartFile> mf = mhsq.getFiles("imgs");
		if(mf.size()==1 && mf.get(0).getOriginalFilename().equals("")) {
		}else {	for(int i=0; i< mf.size(); i++) {
				//파일 중복명 처리, 저장되는 파일 이름
				String fileName = UUID.randomUUID().toString();
				//파일 저장
				File upImage = new File(dir, fileName+".jpg");
				mf.get(i).transferTo(upImage);
				StageImage uploadImage = new StageImage(0, fileName, stage.getStageNo());
				service.insertStageImage(uploadImage);
			}
		}
		
		int delImageInt = 0;
		//삭제한 이미지 삭제
		String[] delImage = request.getParameterValues("delImage");
		if(delImage!=null) {
			for(int i=0; i<delImage.length; i++) {
				delImageInt = Integer.parseInt(delImage[i]);
				service.deleteStageImageByStageImageNo(delImageInt);
			}
		}
		
		return new ModelAndView("redirect:/selectAllStage.do");
	}
	
	@RequestMapping("/deleteStage")
	public ModelAndView deleteStage(@RequestParam int stageNo) {
		service.deleteStageImageByStageNo(stageNo);
		service.deleteStageByStageNo(stageNo);
		
		return new ModelAndView("redirect:/selectAllStage.do");
	}
	
	@RequestMapping("/stageDetail")
	public ModelAndView stageDetail(@RequestParam int stageNo) {
		Stage stage = service.selectStageByStageNo(stageNo);
		List<StageImage> stageImage = service.selectStageImageByStageNo(stageNo);
		
		String id = null;
		String rentalUserId = null;
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("stage", stage);
		map.put("stageImage", stageImage);
		
		try {
			StageReservation stageReservation = service.selectStageReservationByStageNoforRentalStateCode(stageNo);
			rentalUserId = stageReservation.getRentalUserId();
		}catch(Exception e){
			rentalUserId = "0";
		}finally {
			map.put("rentalUserId", rentalUserId);
		}
		
		try {
			SecurityContext context = SecurityContextHolder.getContext();
			Authentication authentication = context.getAuthentication();
			id = ((User)authentication.getPrincipal()).getUserId();
		}catch (Exception e) {
			id = "0";
		}finally {
			map.put("userId", id);
		}
		
		return new ModelAndView("stage/stageDetailView.tiles", "map", map);
	}
	
	@RequestMapping(value="/insertStageRservation", produces = "application/text; charset=utf8")
	public @ResponseBody String insertStageReservation(@ModelAttribute StageReservation stageReservation) {
		
		int stageNo = stageReservation.getStageNo();
		
		String msg = null;
		
		Stage stage = service.selectStageByStageNo(stageNo);
		Date rentalD = stage.getStageRentalDate();
		
		stageReservation.setRentalDate(rentalD);
		
		if(!stageReservation.getRentalUserId().equals("0")) {
			// 예약진행중이지 않다면
			if(service.selectStageReservationByStageNoforRentalStateCode(stageNo) == null) {
				service.insertStageReservation(stageReservation);
				service.updateStageForStageReservation(0, stageNo);
				msg = "예약이 성공적으로 완료되었습니다";
			}else { //진행중인 예약이 있다면
				msg = "이미 진행중인 예약이 있는 공연장입니다.";
			}
		}else {//로그인한 회원이 아닐 경우
			msg = "로그인 후 사용가능한 기능 입니다.";
		}
		
		return msg;
	}
	
	@RequestMapping(value="/cancelStageReservation", produces="application/text; charset=utf8")
	public @ResponseBody String cancelStageReservation(@RequestParam int stageNo) {
		service.cancelStageReservation(stageNo);
		service.updateStageForStageReservation(1, stageNo);
		return "예약이 취소되었습니다";
	}
	
}
