package com.buskstop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.PerformanceCommentService;
import com.buskstop.vo.PerformanceComment;

@Controller
public class PerformanceCommentController {
	@Autowired
	private PerformanceCommentService service;
	
	@RequestMapping("/performanceCommentList")
	@ResponseBody
	public List<PerformanceComment> performanceCommentList(@RequestParam int performanceNo) throws Exception {
//		System.out.println("들어오냐?");
		List<PerformanceComment> list = service.listComment(performanceNo);
//		System.out.println("컨트롤러 나오긴하냐");
		return list;
	}
	
//	@RequestMapping("/performanceCommentList")
//	public ModelAndView performanceCommentList(@RequestParam int performanceNo,@ModelAttribute PerformanceComment performanceComment, HttpServletRequest request) throws Exception {
//		System.out.println("들어오냐?");
//		List<PerformanceComment> list = service.listComment(performanceNo);
//		return new ModelAndView("performance/performanceDetailView.tiles","performanceCommentList",list);
//	}
	
	
	@RequestMapping("/performanceCommentInsert")
	public ModelAndView insertPerformanceComment(@ModelAttribute PerformanceComment performanceComment) throws Exception {
		int performanceNo = performanceComment.getPerformanceNo();
		performanceComment.setPerformanceNo(performanceNo);
		
		System.out.println(performanceNo);
		
		
		service.insertPerformanceComment(performanceComment);
		return new ModelAndView("performance/performanceDetailView.tiles","performanceComment",performanceComment);
	}
//	System.out.println("퍼포먼스"+performanceComment);
//	System.out.println("퍼포먼스 번호"+performanceNo);
	
	
}
