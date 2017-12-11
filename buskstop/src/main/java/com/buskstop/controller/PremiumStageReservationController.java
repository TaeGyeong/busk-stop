package com.buskstop.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
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
	
	/**
	 * 마이페이지 프리미엄 공연장 상세보기에서 옵션 추가페이지로 이동
	 * .do 처리 했지만 단순 페이지 이동임.
	 * @param establishNo
	 * @return
	 */
	@RequestMapping("/goPremiumStageEnterDate")
	public ModelAndView goPremiumStageEnterDate (@RequestParam int establishNo) {
		return new ModelAndView("premiumStageEnterDate.do", "establishNo", establishNo);
	}
	
	/**
	 * 대관일 옵션 추가
	 * @param dateList
	 * @param timeList
	 * @param establishNo
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping("/enterPremiumStageOption")
	public ModelAndView enterPremiumStageOption(@RequestParam String[] dateList,
												@RequestParam(value="timeList") List<List<Integer>> timeList,
												@RequestParam int establishNo) throws ParseException {
		
		for(String d : dateList) {
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
			PremiumStageOption option = new PremiumStageOption(0, date, 0, establishNo);
			int i = service.createPremiumStageOption(option);
			System.out.println("confirm addoption - "+i);
		}
		for(List<Integer> list : timeList) {
			for(Integer t : list) {
				PremiumStageTime time = new PremiumStageTime(0, t);
				service.createPremiumStageTime(time);
			}
		}
		
		return new ModelAndView("redirect:/producer/myStageDetail.do","establishNum",establishNo);
	}
	
	@RequestMapping("/addPremiumStageOptionBasket")
	public @ResponseBody Map<String, Object> addPremiumStageOptionBasket(
					@RequestParam(value="reservationDate") @DateTimeFormat(pattern="yyyy-MM-dd") Date reservationDate, 
					@RequestParam(value="timeCode[]") List<Integer> timeCode) {
		/*System.out.println(reservationDate+" - "+timeCode+" - test");*/
		HashMap<String, Object> map = new HashMap<>();
		map.put("reservationDate",new SimpleDateFormat("yyyy-MM-dd").format(reservationDate));
		map.put("timeCode", timeCode);
		return map;
	}
	
	/**
	 * 사업장 번호로 옵션과 해당 시간코드까지 조회
	 * @param establishNo
	 * @return
	 */
	@RequestMapping("/readPremiumStageOption")
	public ModelAndView readPremiumStageOption(int establishNo) {
		List<PremiumStageOption> dateList = service.selectPremiumStageOptionByEstablishNo(establishNo);
		List<PremiumStageTime> timeList = null;
		for(PremiumStageOption o : dateList) {
			timeList = service.selectPremiumStageTimeByOptionNo(o.getOptionNo());
		}
		HashMap<String, Object> map = new HashMap<>();
		map.put("dateList", dateList);
		map.put("timeList", timeList);
		return new ModelAndView("","map", map);
	}
	
	/**
	 * 프리미엄 공연장 대관일 추가할때 날짜 선택하면 그 날짜에 이미 추가되어있는 시간코드를 읽어온다.
	 * jsp에서 추가되어있는 시간코드인지 확인하고 추가되어있다면 아예 뿌려주지 않는다.
	 * @param stageRentalDate
	 * @return
	 */
	@RequestMapping("/readPremiumStageReservationTimeByStageRentalDate")
	public @ResponseBody List<Integer> readPremiumStageReservationTimeByStageRentalDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date reservationDate){
		Date stageRentalDate = reservationDate;
		System.out.println("선택한 대관일 - "+stageRentalDate);
		System.out.println(service.selectPremiumStageTimeByByStageRentalDate(stageRentalDate)+" - premiumReservationController");
		return service.selectPremiumStageTimeByByStageRentalDate(stageRentalDate);
	}
	
}
