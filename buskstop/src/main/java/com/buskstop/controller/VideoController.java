package com.buskstop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.VideoService;
import com.buskstop.vo.User;
import com.buskstop.vo.Video;

@Controller
public class VideoController {

	@Autowired
	VideoService service;
	
	@RequestMapping("/createVideo")
	public ModelAndView createVideo(@ModelAttribute Video video) {
		service.insertVideo(video);
		return new ModelAndView("/readVideoByVideoNo.do", "videoNo", video.getVideoNo());
		
	}
	
	@RequestMapping("/readVideoByVideoNo")
	public ModelAndView readVideoByVideoNo(@RequestParam int videoNo) {
		Video video = service.selectVideoByVideoNo(videoNo);
		return new ModelAndView("/video/videoDetail.tiles", "readVideoByVideoNo", video);
	}
	
	@RequestMapping("videoSelectCategory")
	public ModelAndView videoSelectCategory(@RequestParam String videoCategory) {
		SecurityContext context = SecurityContextHolder.getContext();
		// SecurityContext 객체에서 Authentication(인증내용)을 받아온다.
		Authentication authentication = context.getAuthentication();
		String userId = ((User)authentication.getPrincipal()).getUserId();
		
		if(videoCategory == "user") {
			return new ModelAndView("videoRegisterView.tiles", "userId", userId);
		}else {
			//사용자 권한 확인하러 AuthorityController한테 보냄
			return new ModelAndView("readAuthorityByUserId.do", "userId", userId);
		}
	}
	
}
