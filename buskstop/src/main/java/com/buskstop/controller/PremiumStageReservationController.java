package com.buskstop.controller;


import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.PremiumStageReservationService;
import com.buskstop.vo.PremiumStage;
import com.buskstop.vo.PremiumStageOption;
import com.buskstop.vo.PremiumStageTime;

@Controller
public class PremiumStageReservationController {

	@Autowired 
	PremiumStageReservationService service;
	
	/**
	 * 마이페이지 프리미엄 공연장 상세보기에서 옵션 추가페이지로 이동
	 * .do 처리 했지만 단순 페이지 이동임.
	 * @param establishNo
	 * @return
	 */
	@RequestMapping("/producer/goPremiumStageEnterDate")
	public ModelAndView goPremiumStageEnterDate (@RequestParam int establishNo) {
		List<PremiumStageOption> optionList = service.selectPremiumStageOptionByEstablishNo(establishNo);
		List<PremiumStageTime> timeList = null;
		for(PremiumStageOption o : optionList) {
			timeList = service.selectPremiumStageTimeByOptionNo(o.getOptionNo());
		}
		HashMap<String, Object> map = new HashMap<>();
		map.put("optionList", optionList);
		map.put("timeList", timeList);
//		System.out.println(optionList+" - "+timeList);
		return new ModelAndView("premiumStage/premiumStageEnterDate.tiles", "map", map);
	}
	
	/**
	 * 대관일 옵션 추가
	 * @param dateList
	 * @param timeList
	 * @param establishNo
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/producer/enterPremiumStageOption")
	public ModelAndView enterPremiumStageOption(@RequestParam String[] dateList,
												@RequestParam(value="timeList") List<List<Integer>> timeList,
												@RequestParam(value="costList") List costList,
												@RequestParam int establishNo,
												BindingResult r) throws ParseException {
		System.out.println(r);
		System.out.println(r.getErrorCount());
		
		for(int i=0; i<dateList.length; i++) {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateList[i]);
			System.out.println(costList);
/*//			int cost = Integer.parseInt() ;
			PremiumStageOption option = new PremiumStageOption(0, date, 0, costList.get(i), establishNo);
			int j = service.createPremiumStageOption(option);
			System.out.println("confirm addoption - "+j);*/
		}
		for(List<Integer> list : timeList) {
			for(Integer t : list) {
				PremiumStageTime time = new PremiumStageTime(0, t);
				service.createPremiumStageTime(time);
			}
		}
		
		return new ModelAndView("redirect:/producer/goPremiumStageEnterDate.do","establishNo",establishNo);
	}
	
	/**
	 * 프리미엄 공연장 대관일 추가할때 날짜 선택하면 그 날짜에 이미 추가되어있는 시간코드를 읽어온다.
	 * jsp에서 추가되어있는 시간코드인지 확인하고 추가되어있다면 아예 뿌려주지 않는다.
	 * @param stageRentalDate
	 * @return
	 */
	@RequestMapping("/producer/readPremiumStageReservationTimeByStageRentalDate")
	public @ResponseBody List<Integer> readPremiumStageReservationTimeByStageRentalDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date reservationDate){
		Date stageRentalDate = reservationDate;
		/*System.out.println("선택한 대관일 - "+stageRentalDate);
		System.out.println(service.selectPremiumStageTimeByByStageRentalDate(stageRentalDate)+" - premiumReservationController");*/
		return service.selectPremiumStageTimeByByStageRentalDate(stageRentalDate);
	}
	
	@RequestMapping("/producer/deletePremiumStageOption")
	public ModelAndView deletePremiumStageOption(@RequestParam int optionNo, @RequestParam int establishNo) {
		service.removePremiumStageOption(optionNo);
		return new ModelAndView("redirect:/producer/goPremiumStageEnterDate.do","establishNo",establishNo);
	}
	
	@RequestMapping("/producer/changePremiumStageStateToZero")
	public @ResponseBody void updatePremiumStageOptionStageState(@ModelAttribute PremiumStageOption option){
		service.updatePremiumStageOptionStageState(option);
	}
	
}
