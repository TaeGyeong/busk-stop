package com.buskstop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.VideoCommentService;
import com.buskstop.vo.User;
import com.buskstop.vo.VideoComment;

@Controller
public class VideoCommentController {

	@Autowired
	private VideoCommentService service;
	
	@RequestMapping("/member/enterVideoComment")
	public @ResponseBody List<VideoComment> enterVideoComment(int videoNo,String videoComment){
		// 댓글 객체 생성
		VideoComment comment = new VideoComment(videoNo, videoComment);
		
		// 권한정보에서 id 이용해서 객체값 setting
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		comment.setVideoCommentUserId(((User)authentication.getPrincipal()).getUserId());
		
		// businesslogic (댓글정보 insert)
		service.insertVideoComment(comment);
		
		//response
		return service.selectVideoCommentByVideoNo(videoNo);
	}
	
	@RequestMapping("/readVideoComment")
	public @ResponseBody List<VideoComment> readVideoComment(@RequestParam int videoNo){
		List<VideoComment> list = service.selectVideoCommentByVideoNo(videoNo);
		return list;
	}
}
