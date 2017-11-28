package com.buskstop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.VideoService;
import com.buskstop.vo.User;
import com.buskstop.vo.VideoLike;

@Controller
public class VideoController {

	@Autowired
	private VideoService service;
	
	@RequestMapping("/videoLike")
	public @ResponseBody String videoLike(@RequestParam int isLike) {
		System.out.println(isLike);
		VideoLike like = new VideoLike(1, getUserId());
		if(isLike==0) {
			service.plusLike(like);
			return "1";
		} else {
			service.deleteLike(like);
			return "0";
		}
	}
	
	@RequestMapping("/likeCheck")
	public ModelAndView likeCheck() {
		// 좋아요한 회원정보 조회
		List<VideoLike> list = service.selectLikeUserByNum(1); // 1은 영상번호
		String num="0";
		
		
		// user-check
		for(VideoLike vl : list) {
			System.out.println(vl);
			if(vl.getVideoLikeUserId().equals(getUserId())) {
				num="1";
			}
		}
		
		return new ModelAndView("testpage.tiles","userLike",num);
	}
	
	
	private String getUserId() {
		return ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
	}
}
