package com.buskstop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buskstop.service.PerformanceCommentService;
import com.buskstop.vo.PerformanceComment;
import com.buskstop.vo.User;

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
//		System.out.println(list);
		return list;
	}
	
	@RequestMapping("/performanceCommentInsert")
	@ResponseBody
	public void insertPerformanceComment(int performanceNo, String performanceComment) throws Exception {
		PerformanceComment pComment = new PerformanceComment(performanceNo,performanceComment);
		
		// 인증해서 아이디값 세팅
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		pComment.setPerformanceCommentUserId(((User)authentication.getPrincipal()).getUserId());
		
		service.insertPerformanceComment(pComment);
	}
	
	@RequestMapping("/performanceCommentUpdate")
	@ResponseBody
	public void updatePerformanceComment(int performanceCommentNo ,String UpdatePerformanceComment) {
//		System.out.println(UpdatePerformanceComment);
		PerformanceComment pComment2 = new PerformanceComment();
		pComment2.setPerformanceCommentNo(performanceCommentNo);
		pComment2.setPerformanceComment(UpdatePerformanceComment);
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		pComment2.setPerformanceCommentUserId(((User)authentication.getPrincipal()).getUserId());
		
		service.updatePerformanceComment(pComment2);
//		System.out.println(pComment2);
	}
	
	@RequestMapping("/performanceCommentDelete")
	@ResponseBody
	public void deletePerformanceComment(int performanceCommentNo) {
//		System.out.println(performanceCommentNo);
		service.deletePerformanceCommentByPerformanceCommentNo(performanceCommentNo);
//		System.out.println("완료됨 ?");
	}
}
