package com.buskstop.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

//github.com/um006500/busk-stop.git
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.PerformanceLikeService;
import com.buskstop.service.PerformanceService;
import com.buskstop.vo.Performance;
import com.buskstop.vo.PerformanceLike;

@Controller
public class PerformanceController {
	
	@Autowired
	private PerformanceService service;
	
	@Autowired
	private PerformanceLikeService likeService;
	
	@Autowired(required=true)
	private HttpServletRequest request;
	
	@RequestMapping("/performanceRegister")
	public ModelAndView insertPerformance(@ModelAttribute Performance performance,  HttpServletRequest request) throws IllegalStateException, IOException {
		//파일 업로드 처리
		MultipartFile multiImage = performance.getMultiImage();
		if(multiImage!=null && !multiImage.isEmpty()) {
			//디렉토리
			String dir = request.getServletContext().getRealPath("/performanceImage");
			String fileName = UUID.randomUUID().toString();
			File upImage = new File(dir, fileName+".jpg");
			multiImage.transferTo(upImage);
			performance.setPerformanceImage(fileName+".jpg");
		}
		
		service.insertPerformance(performance);
		return new ModelAndView("redirect:/allSelectPerformance.do");
	}
	@RequestMapping("/performanceUpdate")
	public ModelAndView updatePerformance(@ModelAttribute Performance performance, HttpServletRequest request) {
		service.updatePerformance(performance);	
		return new ModelAndView("redirect:/performanceDetailView.do","performanceNo",performance.getPerformanceNo());
	}
	
	@RequestMapping("/deletePerformance")
	public String deletePerformance(@RequestParam int performanceNo) {
		service.deletePerformanceByPerformance(performanceNo);
		return "performance/performanceView.tiles";
	}
	
	// 조회하는 메서드
	@RequestMapping("/allSelectPerformance")
	public ModelAndView selectAllPerformance(@RequestParam(required=false) String category, @RequestParam(required=false) String search) throws ParseException ,IOException, ServletException{
		List<Performance> list = null;
		Map<String, Object> map = null;
		int page = 1;
		
		
		try {
			page = Integer.parseInt(request.getParameter("page"));
		}catch (Exception e) {
			
		}
		if(category != null) { //검색 시 페이징
			if(category.equals("title")) {
				map = service.selectPerformanceByPerformanceTitle(page, search);
			}else if(category.equals("user")){
				map = service.selectPerformanceByPerformanceUserId(page, search);
			}else if(category.equals("location")) {
				map = service.selectPerformanceByPerformanceLocation(page, search);
			}else if(category.equals("name")) {
				map = service.selectPerformanceByPerformanceName(page, search);
			}else if(category.equals("content")) {
				map = service.selectPerformanceByPerformanceContent(page, search);
			}
		}else {
			map = service.selectAllPerformance(page);
			category = "title";
			search = "";
		}
		list = (List<Performance>)map.get("list");
		list = likeCounter(list);
		map.put("list", list);
		map.put("search", search);
		map.put("category", category);
		
		return new ModelAndView("performance/performanceView.tiles", "map", map);
	}
	
	
	// 좋아요 조회하는 메서드
	public List<Performance> likeCounter(List<Performance> list){
		
		 List<PerformanceLike> likeList = likeService.selectAllPerformanceLike();
		
		int count = 0;
		for(Performance pf : list) {
			for(PerformanceLike pl : likeList) {
				if(pf.getPerformanceNo() == pl.getPerformanceLikeNo()) {
					count ++;
					pf.setLikeCount(count);
				}
			}
			count = 0;
		}
		
		return list;
	}

	@RequestMapping("/performanceDetailView")
	public ModelAndView performanceDetailView(@RequestParam int performanceNo) {
		service.updatePerformanceCountByPerformanceNo(performanceNo); // 조회수+1 호출
		Performance performance = service.getPerformanceByPerformanceNo(performanceNo);
		return new ModelAndView("performance/performanceDetailView.tiles","performance", performance);
	}

}
