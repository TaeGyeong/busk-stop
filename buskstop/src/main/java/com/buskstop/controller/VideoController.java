package com.buskstop.controller;

import java.util.Date;
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
	
	/**
	 * 영상 번호로 영상 상세보기
	 * @param videoNo
	 * @return
	 */
	@RequestMapping("/readVideoByVideoNo")
	public ModelAndView readVideoByVideoNo(@RequestParam int videoNo) {
		Video video = service.selectVideoByVideoNo(videoNo);
		return new ModelAndView("video/videoDetailView.tiles", "video", video);
	}
	
	
	/**
	 * 영상등록에사 공연영상 카테고리 선택
	 * @return
	 */
	@RequestMapping("/member/selectPerformanceVideoCategory")
	public ModelAndView selectPerformanceVideoCategory() {
		SecurityContext context = SecurityContextHolder.getContext();
		// SecurityContext 객체에서 Authentication(인증내용)을 받아온다.
		Authentication authentication = context.getAuthentication();
		String userId = ((User)authentication.getPrincipal()).getUserId();
		return new ModelAndView("video/videoRegisterPerformanceView.tiles", "userId", userId);
	}
	
	/**
	 * 영상등록에서 개인연습영상 카테고리 선택
	 * @return
	 */
	@RequestMapping("/member/selectMemberVideoCategory")
	public ModelAndView selectMemberVideoCategory() {
		SecurityContext context = SecurityContextHolder.getContext();
		// SecurityContext 객체에서 Authentication(인증내용)을 받아온다.
		Authentication authentication = context.getAuthentication();
		String userId = ((User)authentication.getPrincipal()).getUserId();
		return new ModelAndView("video/videoRegisterPracticeView.tiles", "userId", userId);
	}
	
	/**
	 * 영상등록에서 아티스트 카테고리 선택
	 * @return
	 */
	@RequestMapping("/artist/selectArtistVideoCategory")
	public ModelAndView selectArtistVideoCategory() {
		SecurityContext context = SecurityContextHolder.getContext();
		// SecurityContext 객체에서 Authentication(인증내용)을 받아온다.
		Authentication authentication = context.getAuthentication();
		
		String userId = ((User)authentication.getPrincipal()).getUserId();
		return new ModelAndView("video/videoRegisterArtistView.tiles", "userId", userId);
	}
	
	@RequestMapping("/videoListCategory")
	public ModelAndView videoList(@RequestParam String category) {
		// category를 매개변수로 받아서 해당 카테고리의 Video 객체를 list로 받아온다.
		List<Video> list = service.viewAllVideo(category);
		System.out.println("category - "+category);
		// response
		if(category.equals("performance")) {
			System.out.println("list - "+category);
			return new ModelAndView("video/userPerformanceVideoListView.tiles","list",list);
		}else if (category.equals("artist")) {
			return new ModelAndView("video/artistVideoListView.tiles","list",list);
		}else {
			return new ModelAndView("video/userVideoListView.tiles","list",list);
		}
	}
	
	@RequestMapping("/videoChangeInfoView")
	public ModelAndView changeInfoView(int videoNo) {
		Video video = service.selectVideoByVideoNo(videoNo);
		return new ModelAndView("video/videoChangeInfoView.tiles","video",video);
	}
	
	
	@RequestMapping("/updateVideoInfo")
	public ModelAndView updateArtistVideo(@ModelAttribute Video video) {
		// Artist 공연영상일 경우에는 artistVideo 정보수정 controller 로 보낸다.
		if(video.getVideoCategory().equals("artist")) {
			return new ModelAndView("redirect:/artist/updateVideoInfo.do","video",video);
		}
		
		// test용 출력
		System.out.println(video);
		
		// video정보를 수정하는 update service
		service.updateVideo(video);
		video = service.selectVideoByVideoNo(video.getVideoNo());
		
		// response
		return new ModelAndView("redirect:/readVideoByVideoNo.do", "videoNo",video.getVideoNo());
	}
	
	@RequestMapping("/artist/updateVideoInfo")
	public ModelAndView updatePerformanceVideo(@ModelAttribute Video video) {
		service.updateVideo(video);
		video = service.selectVideoByVideoNo(video.getVideoNo());
		return new ModelAndView("video/videoDetailView.tiles", "video",video);
	}
	
	@RequestMapping("/deleteVideo")
	public String deleteVideo(int videoNo) {
		service.deleteVideoByVideoNum(videoNo);
		return "index.tiles";
	}
	
}
