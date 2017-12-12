
package com.buskstop.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.HelpService;
import com.buskstop.vo.Help;
import com.buskstop.vo.User;

@Controller
public class HelpController {

	@Autowired
	private HelpService service;
	
	@Autowired
	private HttpServletRequest request;
	
	/*
	 * @RequestMapping("/helpRegister") public ModelAndView
	 * insertPerformance(@ModelAttribute Help help, HttpServletRequest request)
	 * throws IllegalStateException, IOException { //파일 업로드 처리 MultipartFile
	 * multiImage = help.getMultiImage(); if(multiImage!=null &&
	 * !multiImage.isEmpty()) { //디렉토리 String dir =
	 * request.getServletContext().getRealPath("/helpImage"); String fileName =
	 * UUID.randomUUID().toString(); File upImage = new File(dir, fileName+".jpg");
	 * multiImage.transferTo(upImage); help.setHelpImage(fileName+".jpg"); }
	 * help.setHelpCode(0); service.insertPerformance(help);
	 * 
	 * return new ModelAndView("redirect:/selectPerformance.do"); }
	 */

	@RequestMapping("/helpRegister")
	public ModelAndView insertHelp(@ModelAttribute Help help, BindingResult result,HttpServletRequest request) throws IllegalStateException, IOException {
		/* log */	
		//에러 로그
		System.out.println("Log: 컨트롤러 호출");
		System.out.println("Log: @RequestMapping(\"/helpRegister\") public ModelAndView insertHelp()");
		System.out.println(result);
		System.out.println(result.getErrorCount());
			
		
		System.out.println("Log: HelpController.java -> service.insertHelp(); 호출");
		System.out.println("컨트롤러 파라미터 : "+help);
		service.insertHelp(help);
		return null;
	}

	@RequestMapping("/helpDetailView")
	public ModelAndView helpDetail(@RequestParam int helpNum) {
		Help help = service.selectHelpByHelpNum(helpNum);
		String id = null;
		List<Help> list = new ArrayList<Help>();
		list.add(help);
		help = list.get(0);
		Map<String, Object> map = new HashMap<>();

		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		id = ((User) authentication.getPrincipal()).getUserId();
		map.put("help", help);
		map.put("userId", id);

		return new ModelAndView("help/helpDetailView.tiles", "map", map);
	}
	
	@RequestMapping("/deleteHelp")
	public String deleteHelp(@RequestParam int helpNum) {
		service.deleteHelpByHelpNum(helpNum);
		return "help/helpDetailView.tiles"; // 여기엔 목록으로 이동 
	}
	
	@RequestMapping("/updateHelp")
	public ModelAndView udpateHelp(@ModelAttribute Help help) throws IllegalStateException, IOException {
		
		MultipartFile multiImage = help.getMultiImage();
		if(multiImage!=null && !multiImage.isEmpty()) {
			//디렉토리
			String dir = request.getServletContext().getRealPath("/helpImage");
			String fileName = UUID.randomUUID().toString();
			File upImage = new File(dir, fileName+".jpg");
			multiImage.transferTo(upImage);
			help.setHelpImage(fileName+".jpg");
		}
		service.updateHelp(help);
		int helpNum = help.getHelpNum();
		return new ModelAndView("helpDetailView.do?helpNum"+helpNum,"help",help);
				
	}
	
	@RequestMapping("/updateHelp2")
	public ModelAndView updateHelp2(@RequestParam int helpNum) {
		Help help = service.selectHelpByHelpNum(helpNum);
		return new ModelAndView("help/helpUpdate.tiles","Help",help);
	}
	
	
	
	
	
	
	
	
	
	
	
}
