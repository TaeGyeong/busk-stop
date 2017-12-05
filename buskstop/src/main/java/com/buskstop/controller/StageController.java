package com.buskstop.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.StageService;
import com.buskstop.vo.Stage;
import com.buskstop.vo.User;

@Controller
public class StageController {

	@Autowired
	private StageService service;
	
	private String getUserId() {
		return ((User) SecurityContextHolder.getContext().getAuthentication()).getUserId();
	}
	
	//공연장 등록
	@RequestMapping("/stageRegister")
	public ModelAndView insertStage(@ModelAttribute Stage stage) throws IllegalStateException, IOException {
		service.insertStage(stage);
		
		return new ModelAndView("redirect:/");
	}
}
