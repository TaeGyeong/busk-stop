package com.buskstop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.PremiumStageService;

@Controller
public class PremiumStageController {
	
	@Autowired
	PremiumStageService service;
	
	@RequestMapping("/producer/menu")
	public String goPremiumStageEdit() {
		// 프리미엄 대관공급자 선택메뉴로 이동하는 controller
		return "premiumStage/premiumStageEditCategory.tiles";
	}
	
	@RequestMapping("/producer/selectViewPremiumStage")
	public ModelAndView selectPremiumStageView(String userId) {
		/*
		 * 	premiumStageEditCategory.jsp --> 수정 셀렉트
		 */
		
		
		return null;
	}
	
	@RequestMapping("/producer/selectEditPremiumStage")
	public ModelAndView selectPremiumStageEdit(String userId) {
		return null;
	}
	
	@RequestMapping("/producer/selectDeletePremiumStage")
	public ModelAndView selectPremiumStageDelete(String userId) {
		return null;
	}
}
