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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.StageService;
import com.buskstop.vo.Stage;
import com.buskstop.vo.StageImage;
import com.buskstop.vo.User;

@Controller
public class StageController {

	@Autowired
	private StageService service;
	
	
	@RequestMapping("/stageReservation")
	public ModelAndView selectStage(@ModelAttribute Stage stage) {
		
		return new ModelAndView("stageView.do","stage",stage);
	}
	//공연장 등록
	@RequestMapping("/stageRegister")
	public ModelAndView insertStage(@ModelAttribute Stage stage, MultipartHttpServletRequest mhsq, HttpServletRequest request) throws IllegalStateException, IOException {
//		System.out.println("넘어오냐"+stage.getStageStartTime());
//		System.out.println("넘어오냐"+stage.getStageEndTime());
		
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
		System.out.println("컨트롤러"+idSearch+startDate+endDate+locationSearch+nameSearch);
		List<Stage> list = null;
		Map<String, Object> map = null;
		int page=1;
		
		if(locationSearch==null && nameSearch==null && startDate==null && endDate==null && idSearch==null ) {
			map = service.selectAllStage(page);
		}
		else {
		if(locationSearch=="" && nameSearch=="" && startDate!=null && endDate!=null && idSearch=="" ) {
			map = service.selectStageByStageDate(page,startDate,endDate);
		} else if(locationSearch=="" && nameSearch!="" && startDate!=null && endDate!=null && idSearch=="") {
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
		} else if(locationSearch!="" && nameSearch!="" && startDate!=null && endDate!=null && idSearch==""){
			map = service.selectStageByLocationAndName(page,locationSearch,startDate,endDate,nameSearch);
		}	}
		
		
		list = (List<Stage>)map.get("list");
		System.out.println("나오는 리스트 "+list);
		map.put("list", list);
		
		map.put("stageLocation", locationSearch);
		map.put("nameSearch", nameSearch);
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("idSearch", idSearch);
		
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
		for(int i=0; i<delImage.length; i++) {
			delImageInt = Integer.parseInt(delImage[i]);
			service.deleteStageImageByStageImageNo(delImageInt);
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
		
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		String id = ((User)authentication.getPrincipal()).getUserId();
		
		Map<String, Object> map = new HashMap<>();
		map.put("stage", stage);
		map.put("stageImage", stageImage);
		map.put("userId", id);
		
		return new ModelAndView("stage/stageDetailView.tiles", "map", map);
	}
	
}
