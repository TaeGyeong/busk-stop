package com.buskstop.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	private String getUserId() {
		return ((User) SecurityContextHolder.getContext().getAuthentication()).getUserId();
	}
	
	//공연장 등록
	@RequestMapping("/stageRegister")
	public ModelAndView insertStage(@ModelAttribute Stage stage, MultipartHttpServletRequest mhsq, HttpServletRequest request) throws IllegalStateException, IOException {
		service.insertStage(stage);
		//파일 경로
		String dir = request.getServletContext().getRealPath("/stageImage");
		
		//넘어온 파일을 리스트로 저장
		List<MultipartFile> mf = mhsq.getFiles("stageImage");
		if(mf.size()==1 && mf.get(0).getOriginalFilename().equals("")) {
		}else {
			for(int i=0; i< mf.size(); i++) {
				//파일 중복명 처리, 저장되는 파일 이름
				String fileName = UUID.randomUUID().toString();
				
				//파일 저장
				String savePath = dir + fileName;
				mf.get(i).transferTo(new File(savePath));
				
				StageImage uploadImage = new StageImage(0, fileName, stage.getStageNo());
				
				service.insertStageImage(uploadImage);
			}
		}

		return new ModelAndView("redirect:/selectAllStage.do");
	}
	
	@RequestMapping("selectAllStage")
	public ModelAndView selectAllStage(@RequestParam(required=false) String locationSearch, @RequestParam(required=false) String instrumentSearch, @RequestParam(required=false) String sDate, @RequestParam(required=false) String eDate) throws Exception{
		System.out.println(sDate+eDate);
		List<Stage> list = null;
		Map<String, Object> map = null;
		int page=1;
		System.out.println(locationSearch+instrumentSearch);
		if(locationSearch==null && instrumentSearch==null) {
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = transFormat.parse(sDate);
			Date endDate = transFormat.parse(eDate);
			map = service.selectStageByStageLocation(page,locationSearch,sDate,eDate);
			
		} else if(locationSearch==null && instrumentSearch!=null) {
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = transFormat.parse(sDate);
			Date endDate = transFormat.parse(eDate);
			map = service.selectStageByInstrument(page,instrumentSearch,sDate,eDate);
			
		} else if(locationSearch!=null && instrumentSearch==null) {
			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = transFormat.parse(sDate);
			Date endDate = transFormat.parse(eDate);
			map = service.selectStageByStageDate(page,startDate,endDate);
		}
		
		map = service.selectAllStage(page);
		
		list = (List<Stage>)map.get("list");
		
		map.put("list", list);
		map.put("stageLocation", locationSearch);
		map.put("instruemtn", instrumentSearch);
		map.put("sDate", sDate);
		map.put("eDate", eDate);
		
		return new ModelAndView("stageView.do","map",map);
		
	}
}
