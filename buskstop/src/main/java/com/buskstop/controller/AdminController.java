package com.buskstop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.UserService;
import com.buskstop.vo.User;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	/********************************* 회원관리 *********************************/
	
	@RequestMapping("member")
	public ModelAndView goMemberManagement() {
		return new ModelAndView("admin/memberManagementView.tiles","list",userService.selectAllUser());
	}
	
	@RequestMapping("searchMember")
	public ModelAndView searchMemberManagement(String authority, String search) {
		return new ModelAndView("admin/memberManagementView.tiles","list", userService.searchMemberManagement(authority,search));
	}
	
	@RequestMapping("dropUser")
	public ModelAndView dropUserManagement(String userId) {
		List<User> list = userService.dropAndSelectUser(userId);
		return new ModelAndView("admin/memberManagementView.tiles","list",list);
	}
	
	/********************************* 공연장관리 *********************************/
	
	@RequestMapping("stage")
	public ModelAndView goStageManagement() {
		return new ModelAndView("","",null);
	}
}
