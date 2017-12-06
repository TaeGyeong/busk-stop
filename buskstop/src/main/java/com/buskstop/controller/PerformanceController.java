package com.buskstop.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

//github.com/um006500/busk-stop.git
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.buskstop.vo.User;

@Controller
public class PerformanceController {
	
	@Autowired
	private PerformanceService service;
	
	@Autowired
	private PerformanceLikeService likeService;
	
	@Autowired(required=true)
	private HttpServletRequest request;
	
	private String getUserId() {
		return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
	}
	
	// 공연 정보 입력
	@RequestMapping("/performanceRegister")
	public ModelAndView insertPerformance(@ModelAttribute Performance performance, HttpServletRequest request) throws IllegalStateException, IOException {
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
	// 이건 수정 화면에서 그 전에 입력 했던 내용들 불러오는거고
	@RequestMapping("/performanceUpdate3")
	public ModelAndView updatePerformance2(@RequestParam int performanceNo) {
			if(service.getPerformanceByPerformanceNo(performanceNo).getPerformanceUserId().equals(getUserId())) {
			Performance performance = service.getPerformanceByPerformanceNo(performanceNo);
			return new ModelAndView("update_performance.do","Performance",performance);
		} else return new ModelAndView("performanceDetailView.do?performanceNo="+performanceNo);
			
	}
	
	// 이건 수정하는 부분
	@RequestMapping("/performanceUpdate2")
	public ModelAndView updatePerformance(@ModelAttribute Performance performance, HttpServletRequest request) throws Exception {
		MultipartFile multiImage = performance.getMultiImage();
		if(multiImage!=null && !multiImage.isEmpty()) {
			//디렉토리
			String dir = request.getServletContext().getRealPath("/performanceImage");
			String fileName = UUID.randomUUID().toString();
			File upImage = new File(dir, fileName+".jpg");
			multiImage.transferTo(upImage);
			performance.setPerformanceImage(fileName+".jpg");
		}
		service.updatePerformance(performance);
		int performanceNo = performance.getPerformanceNo();
		return new ModelAndView("performanceDetailView.do?performanceNo="+performanceNo,"performance",performance);
		
	}
	
	@RequestMapping("/deletePerformance")
	public String deletePerformance(@RequestParam int performanceNo) {
		if(service.getPerformanceByPerformanceNo(performanceNo).getPerformanceUserId().equals(getUserId())) {
			service.deletePerformanceByPerformance(performanceNo);
			return "allSelectPerformance.do";
			} else {
				String error="performanceDetailView.do?performanceNo="+performanceNo; 
				return error;
			}
	}
	
	// 공연정보 목록 조회
	@RequestMapping("/allSelectPerformance")
	public ModelAndView selectAllPerformance(@RequestParam(required=false) String category, @RequestParam(required=false) String search, @RequestParam(required=false) String sDate, @RequestParam(required=false) String eDate) throws ParseException ,IOException, ServletException{
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
			}else if(category.equals("date")) {
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

				Date startDate = transFormat.parse(sDate);
				Date endDate = transFormat.parse(eDate);

				map = service.selectPerformanceByPerformanceDate(page, startDate, endDate);
			}
		}else {
			map = service.selectAllPerformance(page);
			category = "title";
			search = "";
			sDate = "";
			eDate = "";
		}
		list = (List<Performance>)map.get("list");
		list = likeCounter(list);
	
		map.put("list", list);
		map.put("search", search);
		map.put("category", category);
		map.put("sDate", sDate);
		map.put("eDate", eDate);
		
		return new ModelAndView("performance/performanceView.tiles", "map", map);
	}
	
	
	// 좋아요 갯수 조회하는 메서드
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
		List<Performance> list =  new ArrayList<Performance>();
		list.add(performance);
		list = likeCounter(list);
		performance = list.get(0);
		return new ModelAndView("performance/performanceDetailView.tiles","performance", performance);
	}

}
