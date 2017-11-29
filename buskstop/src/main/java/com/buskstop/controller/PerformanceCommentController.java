package com.buskstop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.buskstop.service.PerformanceCommentService;
import com.buskstop.vo.PerformanceComment;

@Controller
public class PerformanceCommentController {
	@Autowired
	private PerformanceCommentService service;
	
	@RequestMapping("/performanceList")
	public List<PerformanceComment> performanceCommentList(@RequestParam int performanceNo, HttpServletRequest request) throws Exception {
		List<PerformanceComment> list = performanceCommentList(performanceNo, request);
		return list;
	}
	
	@RequestMapping("/performanceCommentInsert")
	public void insertPerformanceComment(@ModelAttribute PerformanceComment performanceComment, HttpServletRequest request) throws Exception {
		System.out.println("퍼포먼스"+performanceComment);
		int performanceNo = performanceComment.getPerformanceNo();
		System.out.println("퍼포먼스 번호"+performanceNo);
		performanceComment.setPerformanceNo(performanceNo);
		service.insertPerformanceComment(performanceComment);
	}
	
	
}
