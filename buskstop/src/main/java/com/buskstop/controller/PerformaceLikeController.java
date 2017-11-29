package com.buskstop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.PerformanceLikeService;
import com.buskstop.vo.PerformanceLike;
import com.buskstop.vo.User;

@Controller
public class PerformaceLikeController {

	@Autowired
	private PerformanceLikeService service;
	
	@RequestMapping("/performanceLike")
	public ModelAndView performanceLike(@RequestParam int num) {
		PerformanceLike like = new PerformanceLike(num, getUserId());
		List<PerformanceLike> list = service.selectperformanceLikeByPerformanceLikeNo(num);
		for(PerformanceLike fl : list) {
			if(fl.getPerformanceLikeUserId().equals(getUserId())) { //있다면 삭제
				service.deletePerformanceLike(like);
				System.out.println("삭제됨");
				return new ModelAndView("allSelectPerformance.tiles");
			}
		}
	//없다면 추가한다
	service.insertPerformanceLike(like);
	System.out.println("추가됨");
	return new ModelAndView("allSelectPerformance.tiles");
	}
	
	
	
	private String getUserId() {
		return ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
	}
}
