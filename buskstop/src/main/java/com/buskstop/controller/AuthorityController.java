package com.buskstop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.AuthorityService;

@Controller
public class AuthorityController {

	@Autowired
	AuthorityService service;
	
	@RequestMapping("/readArtistAuthorityByUserId")
	public ModelAndView readArtistAuthorityByUserId(@RequestParam String userId) {
		boolean flag = service.readArtistAutoritiesByUserId(userId);
		return new ModelAndView("/video/videoArtistRegisterView.tiles", "videoArtistCategory", flag);
	}
	
	
}
