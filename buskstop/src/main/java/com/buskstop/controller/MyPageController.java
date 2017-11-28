package com.buskstop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buskstop.service.ArtistService;
import com.buskstop.service.StageService;
import com.buskstop.vo.Artist;
import com.buskstop.vo.StageSupplier;
import com.buskstop.vo.User;

@Controller
public class MyPageController {
	
	@Autowired
	private ArtistService artistService;
	
	@Autowired
	private StageService stageService;
	
	/*

	@RequestMapping("/member/modify")
	public ModelAndView memberModify() {
		
	return null;
	}
	
	*/
	
	
	@RequestMapping("/member/registArtist")
	public String registArtist(String artistName, String performance, String profile,String artistImage,String artistMembers, String sns) {
		
		// 사용자의 id 조회
		String id = getUserId();
		
		// business logic
		artistService.registerArtist(new Artist(id, artistName, performance, profile, artistImage, artistMembers, sns));
		
		// response
		return "redirect:/registerSuccessView.do";
	}
	
	@RequestMapping("/member/registSupplier")
	public String registSupplier(String establishNum, String operatorNum, String stageName, String stageLocation, String stageArea, String stageImage) {
		// supplier id 조회
		String id = getUserId();
		
		// business service
		stageService.registerSupplier(new StageSupplier(Integer.parseInt(establishNum),Integer.parseInt(operatorNum),stageName,stageLocation,Integer.parseInt(stageArea),stageImage,id));
		
		// response
		return "redirect:/registerSuccessView.do";
	}
	
	// Security context 값을 받아서 userId 를 받는 method
	private String getUserId() {
		return ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
	}
}
