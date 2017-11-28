package com.buskstop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.buskstop.service.AuthorityService;
import com.buskstop.vo.Authority;

@Controller
public class AuthorityController {

	@Autowired
	AuthorityService service;
	
	@RequestMapping("/readArtistAuthorityByUserId")
	public boolean readArtistAuthorityByUserId(@RequestParam String userId) {
		boolean flag = service.readArtistAutoritiesByUserId(userId);
		return false;
	}
	
	
}
