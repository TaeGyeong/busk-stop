package com.buskstop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.VideoService;
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
	public ModelAndView readVideoByVideoNo(@ModelAttribute int videoNo) {
		Video video = service.selectVideoByVideoNo(videoNo);
		return new ModelAndView("/video/videoDetail.tiles", "readVideoByVideoNo", video);
	}
	
}
