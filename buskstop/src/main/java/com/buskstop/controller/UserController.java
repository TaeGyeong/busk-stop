package com.buskstop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.ArtistService;
import com.buskstop.service.StageService;
import com.buskstop.service.UserService;
import com.buskstop.vo.Artist;
import com.buskstop.vo.Authority;
import com.buskstop.vo.StageSupplier;
import com.buskstop.vo.User;

@Controller
public class UserController {
	
	@Autowired
	UserService service;
	
	@Autowired
	ArtistService artistService;
	
	@Autowired
	StageService stageService;
	
	/**
	 * 회원가입 컨트롤러
	 * @param user
	 * @return
	 */
	@RequestMapping("/join_member")
	public String joinMember(@ModelAttribute User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		service.joinMember(user, new Authority(user.getUserId(), "ROLE_MEMBER"));
		return "index.tiles";
	}
	
	/************************ 회원수정 전 비밀번호 체크 컨트롤러 ************************/
	
	@RequestMapping("/checkUserPassword")
	public ModelAndView checkPassword(String userId, String password,@RequestParam String category) {
		
		// service로 user 객체생성 후 encoder 객체 생성
		User user = service.selectMemberById(userId);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		/*
		 *	category에 따라 switch문을 사용해서 나눈다.
		 *	user/artist/supplier
		 *	비밀번호 체크해서 가는 경로를 다르게 한다.
		 */
		
		switch(category) {
		case "user":
			if(encoder.matches(password, user.getPassword())) {
				return new ModelAndView("myPage/updateMemberView.tiles","user",user);
			}else {
				return new ModelAndView("myPage/passwordCheck.tiles","errorMsg","비밀번호를 확인해주세요.");
			}
		case "artist":
			Artist artist = artistService.readArtistByUserId(user.getUserId());
			if(encoder.matches(password, user.getPassword())) {
				return new ModelAndView("myPage/updateArtistView.tiles","artist",artist);
			}else {
				return new ModelAndView("myPage/passwordCheck.tiles","errorMsg","비밀번호를 확인해주세요.");
			}
		case "supplier":
			StageSupplier supplier = stageService.selectSupplierById(user.getUserId());
			if(encoder.matches(password, user.getPassword())) {
				return new ModelAndView("myPage/updateSupplierView.tiles","supplier",supplier);
			}else {
				return new ModelAndView("myPage/passwordCheck.tiles","errorMsg","비밀번호를 확인해주세요.");
			}
		default :
			return new ModelAndView("/index.do","",null);
		}
	}
	
	/************************ id중복체크 컨트롤러 ************************/
	
	@RequestMapping("/idDuplicatedCheck")
	public @ResponseBody String DuplicatedCheck(String id) {
		System.out.println(id);
		if(service.selectMemberById(id)==null) {
			return "new";
		} else {
			return "duplicated";
		}
	}
	
	/************************ 회원탈퇴 컨트롤러 ************************/
	
	@RequestMapping("/member/dropUser")
	public String dropUser() {
		/*
		 * 	회원탈퇴 controller
		 * 	id로 user의 회원탈퇴 여부 컬럼 넣는다.
		 * 	session 끊기
		 */
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		String id = ((User)authentication.getPrincipal()).getUserId();
		service.dropMember(id);
		context.setAuthentication(null);
		return "redirect:/index.do";
	}
}
