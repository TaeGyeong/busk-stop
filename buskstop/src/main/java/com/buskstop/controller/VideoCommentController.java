package com.buskstop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.VideoCommentService;
import com.buskstop.vo.User;
import com.buskstop.vo.VideoComment;

@Controller
public class VideoCommentController {

	@Autowired
	private VideoCommentService service;
	
	@RequestMapping("/member/enterVideoComment")
	public void enterVideoComment(@ModelAttribute VideoComment videoComment) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		videoComment.setVideoCommentUserId(((User)authentication.getPrincipal()).getUserId());
		service.insertVideoComment(videoComment);
	}
	
	@RequestMapping("/readVideoComment")
	public List<VideoComment> readVideoComment(@RequestParam int videoNo){
		List<VideoComment> list = service.selectVideoCommentByVideoNo(videoNo);
		return list;
	}
}
