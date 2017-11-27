package com.buskstop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buskstop.service.UserService;
import com.buskstop.vo.Authority;
import com.buskstop.vo.User;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	
	/**
	 * 회원가입 컨트롤러
	 * @param user
	 * @return
	 */
	@RequestMapping("/join_member")
	public String joinMember(@ModelAttribute User user) {
		System.out.println(user);
		service.joinMember(user, new Authority(user.getUserId(), "ROLE_MEMBER"));
		return "index.tiles";
	}
}
