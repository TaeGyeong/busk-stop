package com.buskstop.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.HelpService;
import com.buskstop.vo.Help;

@Controller
public class HelpController {
	
	@Autowired
	private HelpService service;
	
	/*
	@RequestMapping("/helpRegister")
	public ModelAndView insertPerformance(@ModelAttribute Help help, HttpServletRequest request) throws IllegalStateException, IOException {
		//파일 업로드 처리
		MultipartFile multiImage = help.getMultiImage();
		if(multiImage!=null && !multiImage.isEmpty()) {
			//디렉토리
			String dir = request.getServletContext().getRealPath("/helpImage");
			String fileName = UUID.randomUUID().toString();
			File upImage = new File(dir, fileName+".jpg");
			multiImage.transferTo(upImage);
			help.setHelpImage(fileName+".jpg");
		}
		help.setHelpCode(0);
		service.insertPerformance(help);
		
		return new ModelAndView("redirect:/selectPerformance.do");
	}
	*/
	
	@RequestMapping("/helpRegister")
	public ModelAndView insertHelp(@ModelAttribute Help help, HttpServletRequest request) throws IllegalStateException, IOException {
		System.out.println("Log: @RequestMapping(\"/helpRegister\") public ModelAndView insertHelp() 호출");
		System.out.println("Log: HelpController.java -> service.insertHelp(); 호출");
		service.insertHelp();
		return null;
	}	
}
