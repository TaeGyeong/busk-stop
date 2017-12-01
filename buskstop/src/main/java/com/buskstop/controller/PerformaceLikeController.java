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
import com.buskstop.service.PerformanceService;
import com.buskstop.vo.Performance;
import com.buskstop.vo.PerformanceLike;
import com.buskstop.vo.User;

@Controller
public class PerformaceLikeController {

	@Autowired
	private PerformanceService service;
	
	@Autowired
	private PerformanceLikeService likeService;
	
	@RequestMapping("/performanceLike")
	@ResponseBody
	public String performanceLike(@RequestParam String num) {
		int Cnum = Integer.parseInt(num);
		int findNum = 0;
		String findStr = null;
		
		PerformanceLike like = new PerformanceLike(Cnum, getUserId());
		List<PerformanceLike> list = likeService.selectperformanceLikeByPerformanceLikeNo(Cnum);
		for(PerformanceLike fl : list) {
			if(fl.getPerformanceLikeUserId().equals(getUserId())) { //있다면 삭제
				likeService.deletePerformanceLike(like);
				System.out.println("삭제됨");
				
				findNum = findLikeCount(Cnum);
				findStr = Integer.toString(findNum);
				System.out.println(findStr);
				
				return findStr;
			}
		}
	//없다면 추가한다
	likeService.insertPerformanceLike(like);
	System.out.println("추가됨");
	
	findNum = findLikeCount(Cnum);
	findStr = Integer.toString(findNum);
	System.out.println(findStr);
	
	return findStr;
	}
	
	private String getUserId() {
		return ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
	}
	
	
	public int findLikeCount(int num) {
		List<Performance> list2 = service.selectAllPerfor();
		List<PerformanceLike> likeList = likeService.selectAllPerformanceLike();
		int sendNum = 0;
		
		int count = 0;
		for(Performance pf : list2) {
			for(PerformanceLike pl : likeList) {
				if(pf.getPerformanceNo() == pl.getPerformanceLikeNo()) {
					count ++;
					pf.setLikeCount(count);
				}
			}
			count = 0;
		}
		for(Performance pf : list2) {
			if(pf.getPerformanceNo() == num) {
				sendNum = pf.getLikeCount();
			}
		}
		
		return sendNum;
	}
}
