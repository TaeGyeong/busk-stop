package com.buskstop.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public @ResponseBody Map<String, Object> addPremiumStageOptionBasket(
					@RequestParam(value="reservationDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date reservationDate, 
					@RequestParam(value="timeCode[]") List<Integer> timeCode) {
		System.out.println(reservationDate+" - "+timeCode+" - test");
		/*ModelAndView view = new ModelAndView();
		view.setViewName("/premiumStage/premiumStageEnterDate.tiles");
		view.addObject("reservationDate", reservationDate);
		view.addObject("timeCode", timeCode);*/
		HashMap<String, Object> map = new HashMap<>();
		map.put("reservationDate", reservationDate);
		map.put("timeCode", timeCode);
		return map;
	}
	
	@RequestMapping("/readPremiumStageOption")
	public ModelAndView readPremiumStageOption(int establishNo) {
		List<PremiumStageOption> list = service.selectPremiumStageOptionByEstablishNo(establishNo);
		return new ModelAndView("","premiumStageOption", list);
	}
	
	@RequestMapping("/readPremiumStageReservationTimeByStageRentalDate")
	public @ResponseBody List<Integer> readPremiumStageReservationTimeByStageRentalDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date stageRentalDate){
		System.out.println(service.selectPremiumStageTimeByByStageRentalDate(stageRentalDate)+" - premiumReservationController");
		return service.selectPremiumStageTimeByByStageRentalDate(stageRentalDate);
	}
	
}
