package com.buskstop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.VideoService;
import com.buskstop.vo.User;
import com.buskstop.vo.Video;
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
	
	@RequestMapping("/createVideo")
	public ModelAndView createVideo(@ModelAttribute Video video) {
		service.insertVideo(video);
		return new ModelAndView("redirect:/readVideoByVideoNo.do", "videoNo", video.getVideoNo());
		
	}
	
	@RequestMapping("/readVideoByVideoNo")
	public ModelAndView readVideoByVideoNo(@RequestParam int videoNo) {
		Video video = service.selectVideoByVideoNo(videoNo);
		return new ModelAndView("video/videoDetailView.tiles", "readVideoByVideoNo", video);
	}
	
	@RequestMapping("/videoSelectCategory")
	public ModelAndView videoSelectCategory(@RequestParam String videoCategory) {
		SecurityContext context = SecurityContextHolder.getContext();
		// SecurityContext 객체에서 Authentication(인증내용)을 받아온다.
		Authentication authentication = context.getAuthentication();
		String userId = ((User)authentication.getPrincipal()).getUserId();
		System.out.println(userId);
		if(videoCategory.matches("user")) {
			return new ModelAndView("video/videoRegisterView.tiles", "userId", userId);
		}else {
			//사용자 권한 확인하러 AuthorityController한테 보냄
			return new ModelAndView("/artist/readArtist.do");
		}
	}
	
	@RequestMapping("/videoListCategory")
	public ModelAndView videoList(@RequestParam String category) {
		// category를 매개변수로 받아서 해당 카테고리의 Video 객체를 list로 받아온다.
		List<Video> list = service.viewAllVideo(category);
	
		// response
		if(category.equals("user")) {
			return new ModelAndView("video/userVideoListView.tiles","list",list);
		}else {
			return new ModelAndView("video/artistVideoListView.tiles","list",list);
		}
	}
	
	@RequestMapping("/detailView")
	public ModelAndView videoDetail(@RequestParam int videoNumber) {
		Video video = service.selectVideoByVideoNo(videoNumber);
		return new ModelAndView("video/videoDetailView.tiles","video",video);
	}
	
}
