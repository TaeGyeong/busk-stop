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
	
	
	@RequestMapping("/member/registArtist")
	public String registArtist(String artistName, String performance, String profile,String artistImage) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String id = ((User)authentication.getPrincipal()).getUserId();
		
		artistService.registerArtist(new Artist(id, artistName, performance, profile, artistImage, artistName));
		return "user/registerSuccessView.tiles";
	}
	
	@RequestMapping("/member/registSupplier")
	public String registSupplier(String establishNum, String operatorNum, String stageName, String stageLocation, String stageArea, String stageImage) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String id = ((User)authentication.getPrincipal()).getUserId();
		stageService.registerSupplier(new StageSupplier(Integer.parseInt(establishNum),Integer.parseInt(operatorNum),stageName,stageLocation,Integer.parseInt(stageArea),stageImage,id));
		return "user/registerSuccessView.tiles";
	}
}
