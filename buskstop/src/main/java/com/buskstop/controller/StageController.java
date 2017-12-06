package com.buskstop.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
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
		List<MultipartFile> mf = mhsq.getFiles("imgs");
		if(mf.size()==1 && mf.get(0).getOriginalFilename().equals("")) {
		}else {
			for(int i=0; i< mf.size(); i++) {
				//파일 중복명 처리, 저장되는 파일 이름
				String fileName = UUID.randomUUID().toString();
				
				//파일 저장
				File upImage = new File(dir, fileName+".jpg");
				mf.get(i).transferTo(upImage);
				
				StageImage uploadImage = new StageImage(0, fileName, stage.getStageNo());
				
				service.insertStageImage(uploadImage);
			}
		}

		return new ModelAndView("redirect:/stageView.do");
	}
	
	@RequestMapping("selectAllStage")
	public ModelAndView selectAllStage(@RequestParam String category, @RequestParam String search, @RequestParam String stageDate) throws Exception{
		List<Stage> list = null;
		Map<String, Object> map = null;
		int page=1;
		
//		try {
//			page = Integer.parseInt(request.getParameter("page"));
//		}catch (Exception e) {
//			
//		}
		
		map = service.selectAllStage(page);
		category="title";
		search="";
		stageDate = "";
		
		list = (List<Stage>)map.get("list");
		
		map.put("list", list);
		map.put("search", search);
		
		return new ModelAndView("stage/stageView.tiles","map",map);
		
	}
	
	// 공연장 정보 공연장 수정에 빼와서 뿌려주기
	@RequestMapping("updateStage")
	public ModelAndView updateStageByStageNo(@RequestParam int stageNo) {
		Stage stage = null;
		
		stage = service.selectStageByStageNo(stageNo);
		List<StageImage> stageImage = service.selectStageImageByStageNo(stageNo);
		stage.setStageImage(stageImage);
		return new ModelAndView("/stageUpdateView.do", "stage", stage);
		
	}
	
	//공연정보 받아서 수정
	@RequestMapping("updateStageChange")
	public ModelAndView updateStageChange(@ModelAttribute Stage stage, MultipartHttpServletRequest mhsq, HttpServletRequest request) throws IllegalStateException, IOException {
		//공연장 변경
		service.updateStage(stage);
		//기존에 공연장 번호를 가진 공연장사진 제거
		int stageNo = stage.getStageNo();
		service.deleteStageImageByStageNo(stageNo);
		//업데이트된 공연장 사진 업로드
		
		//파일 경로
		String dir = request.getServletContext().getRealPath("/stageImage");
		
		//넘어온 파일을 리스트로 저장
		List<MultipartFile> mf = mhsq.getFiles("imgs");
		if(mf.size()==1 && mf.get(0).getOriginalFilename().equals("")) {
		}else {
			for(int i=0; i< mf.size(); i++) {
				//파일 중복명 처리, 저장되는 파일 이름
				String fileName = UUID.randomUUID().toString();
				
				//파일 저장
				File upImage = new File(dir, fileName+".jpg");
				mf.get(i).transferTo(upImage);
				
				StageImage uploadImage = new StageImage(0, fileName, stage.getStageNo());
				
				service.insertStageImage(uploadImage);
			}
		}
		return new ModelAndView("redirect:/stageView.do");
	}
}
