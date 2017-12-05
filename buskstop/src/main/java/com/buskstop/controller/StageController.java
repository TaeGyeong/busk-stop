package com.buskstop.controller;

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
	
	private String getUseId() {
		return ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
	}
	
	@RequestMapping("/stageReservation")
	public ModelAndView selectStage(@ModelAttribute Stage stage) {
		
		return new ModelAndView("stageView.do","stage",stage);
	}
	
	
	
}
