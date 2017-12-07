package com.buskstop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.PremiumStageReservationService;
import com.buskstop.vo.PremiumStageReservation;
import com.buskstop.vo.PremiumStageTime;

@Controller
public class PremiumStageReservationController {

	@Autowired 
	PremiumStageReservationService service;
	
	@RequestMapping("/producer/enterPremiumStageReservation")
	public ModelAndView enterPremiumStageReservation(@ModelAttribute PremiumStageReservation reservation,
													 @ModelAttribute List<PremiumStageTime> list) {
		service.createPremiumStageReservation(reservation);
		service.createPremiumStageTime(list);
		return new ModelAndView("redirect:/readPremiumStageReservation.do", "reservationNo", reservation.getReservationNo());
	}
}
