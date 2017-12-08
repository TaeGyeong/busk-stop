package com.buskstop.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.PremiumStageReservationService;
import com.buskstop.vo.PremiumStageTime;

@Controller
public class PremiumStageReservationController {

	@Autowired 
	PremiumStageReservationService service;
	
	@RequestMapping("/producer/enterPremiumStageReservation")
	public ModelAndView enterPremiumStageReservation() {
		//TODO
		return new ModelAndView("redirect:/readPremiumStageReservation.do","","" );
	}
	
	@RequestMapping("/readPremiumStageReservationTimeByStageRentalDate")
	public @ResponseBody List<Integer> readPremiumStageReservationTimeByStageRentalDate(Date date){
		return service.selectPremiumStageTimeByByStageRentalDate(date);
	}
}
