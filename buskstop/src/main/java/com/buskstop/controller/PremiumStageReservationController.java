package com.buskstop.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.PremiumStageReservationService;

@Controller
public class PremiumStageReservationController {

	@Autowired 
	PremiumStageReservationService service;
	
	@RequestMapping("/producer/enterPremiumStageReservation")
	public ModelAndView enterPremiumStageReservation() {
		//TODO
		return new ModelAndView("redirect:/readPremiumStageReservation.do","","" );
	}
	
	/*@RequestMapping("/readPremiumStageReservationOptionCode")*/
}
