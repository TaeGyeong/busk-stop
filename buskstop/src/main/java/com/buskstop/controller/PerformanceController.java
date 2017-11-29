package com.buskstop.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.PerformanceService;
import com.buskstop.vo.Performance;

@Controller
public class PerformanceController {
	
	@Autowired
	private PerformanceService service;
	
	@RequestMapping("/performanceRegister")
	public ModelAndView insertPerformance(@ModelAttribute Performance performance,  HttpServletRequest request) throws IllegalStateException, IOException {
		//파일 업로드 처리
		MultipartFile multiImage = performance.getMultiImage();
		if(multiImage!=null && !multiImage.isEmpty()) {
			//디렉토리
			String dir = request.getServletContext().getRealPath("/performanceImage");
			String fileName = multiImage.getOriginalFilename();
			File upImage = new File(dir, fileName);
			multiImage.transferTo(upImage);
			performance.setPerformanceImage(fileName);
		}
		
		service.insertPerformance(performance);
		return new ModelAndView("redirect:/allSelectPerformance.do");
	}
	@RequestMapping("/performanceUpdate")
	public ModelAndView updatePerformance(@ModelAttribute Performance performance, HttpServletRequest request) {
		service.updatePerformance(performance);	
		return new ModelAndView("redirect:/performance/performanceView.tiles","performanceNo",performance.getPerformanceNo());
	}
	
	@RequestMapping("/deletePerformance")
	public String deletePerformance(@RequestParam int performanceNo) {
		service.deletePerformanceByPerformance(performanceNo);
		return "performance/performanceView.tiles";
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
		
		Performance performance = service.getPerformanceByPerformanceNo(performanceNo);
		
		System.out.println("컨트롤러 리턴");
		System.out.println(performance);
		return new ModelAndView("performance/performanceDetailView.tiles","performance", performance);
			
	}
	

	// 카테고리로 검색
	@RequestMapping("/performanceSearch")
	public ModelAndView selectPerformanceByCategory(@RequestParam String category, @RequestParam String search) throws ParseException {
		if(category.equals("title")) {
			List<Performance> list = service.selectPerformanceByPerformanceTitle(search);
			return new ModelAndView("performance/performanceView.tiles", "list", list);
		}else if(category.equals("user")){
			List<Performance> list = service.selectPerformanceByPerformanceUserId(search);
			return new ModelAndView("performance/performanceView.tiles", "list", list);
		}else if(category.equals("location")) {
			List<Performance> list = service.selectPerformanceByPerformanceLocation(search);
			return new ModelAndView("performance/performanceView.tiles", "list", list);
		}else if(category.equals("name")) {
			List<Performance> list = service.selectPerformanceByPerformanceName(search);
			return new ModelAndView("performance/performanceView.tiles", "list", list);
		}else if(category.equals("content")) {
			List<Performance> list = service.selectPerformanceByPerformanceContent(search);
			return new ModelAndView("performance/performanceView.tiles", "list", list);
		}
		return null;
	}

}
