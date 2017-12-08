package com.buskstop.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.PremiumStageReservationService;
import com.buskstop.vo.PremiumStageOption;
import com.buskstop.vo.PremiumStageTime;

@Controller
public class PremiumStageReservationController {

	@Autowired 
	PremiumStageReservationService service;
	
	@RequestMapping("/enterPremiumStageOption")
	public ModelAndView enterPremiumStageOption(@ModelAttribute PremiumStageOption premiumStageOption) {
		service.createPremiumStageOption(premiumStageOption);
		return new ModelAndView("redirect:/readPremiumStageReservation.do","establishNo",premiumStageOption.getEstablishNo());
	}
	
	@RequestMapping("/addPremiumStageOptionBasket")
	public @ResponseBody String addPremiumStageOptionBasket(@RequestParam(value="reservationDate") Date reservationDate, 
															@RequestParam(value="selectTime[]") List<Integer> selectTime) {
		String result = reservationDate+" - ";
		for(Integer time : selectTime) {
			result += time;
		}
		return result;
	}
	
	@RequestMapping("/readPremiumStageOption")
	public ModelAndView readPremiumStageOption(int establishNo) {
		List<PremiumStageOption> list = service.selectPremiumStageOptionByEstablishNo(establishNo);
		return new ModelAndView("","premiumStageOption", list);
	}
	
	@RequestMapping("/readPremiumStageReservationTimeByStageRentalDate")
	public @ResponseBody List<Integer> readPremiumStageReservationTimeByStageRentalDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date stageRentalDate){
		System.out.println(service.selectPremiumStageTimeByByStageRentalDate(stageRentalDate));
		return service.selectPremiumStageTimeByByStageRentalDate(stageRentalDate);
	}
	
}
