package com.buskstop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.PerformanceService;
import com.buskstop.vo.Performance;

@Controller
public class PerformanceController {
	
	@Autowired
	private PerformanceService service;
	
	@RequestMapping("/performanceRegister")
	public ModelAndView insertPerformance(@ModelAttribute Performance performance, HttpServletRequest request) {
				service.insertPerformance(performance);
		return new ModelAndView("redirect:/peformance_success.do","performance", performance.getPerformanceNo());
	}
	
	@RequestMapping("/performance_success")
	public ModelAndView performanceSeccess(@RequestParam int performanceNo) {
		String message = "성공";
		return new ModelAndView("performance/performance.tiles", "success", message);
	}
	
	@RequestMapping("/removePerformance")
	public ModelAndView removePerformance(@RequestParam int performanceNo) {
		String message = "삭제 성공";
		return new ModelAndView("performance/performance.tiles","remove",message);
	}
	
	@RequestMapping("/allSelectPerformance")
	public ModelAndView allSelectPerformance() {
		List<Performance> list = service.selectAllPerformance();
		return new ModelAndView("performance/performanceView.tiles","list", list);	
	}
	
	@RequestMapping("/performanceDetailView")
	public ModelAndView performanceDetailView(@RequestParam int performanceNo) {
		System.out.println("컨트롤러 파라미터");
		System.out.println(performanceNo);
		
		Performance performance = service.selectPerformanceByPerformanceNo(performanceNo);
		
		System.out.println("컨트롤러 리턴");
		System.out.println(performance);
		return new ModelAndView("performance/performanceDetailView.tiles","performance", performance);
			
	}
	
}
