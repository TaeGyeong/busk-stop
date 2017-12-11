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
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.ArtistService;
import com.buskstop.service.AuthorityService;
import com.buskstop.service.FollowService;
import com.buskstop.service.PerformanceLikeService;
import com.buskstop.service.PremiumStageService;
import com.buskstop.service.UserService;
import com.buskstop.service.VideoService;
import com.buskstop.vo.Artist;
import com.buskstop.vo.Performance;
import com.buskstop.vo.PremiumStage;
import com.buskstop.vo.User;
import com.buskstop.vo.Video;

@Controller
public class MyPageController {

	@Autowired
	private UserService userService;

	@Autowired
	private ArtistService artistService;

	@Autowired
	private AuthorityService authorityService;

	@Autowired
	private PremiumStageService stageService;
	
	@Autowired
	private FollowService followService;
	
	@Autowired
	private PerformanceLikeService performanceLikeService;
	
	@Autowired
	private VideoService videoService;
	

	/**************************************
	 * 아티스트 & 공급자 권한 조회 controller
	 **************************************/
	@RequestMapping("/registerSupplierView")
	public String premiumAuthorityCheck() {
		if (authorityService.checkStageAuthorityByUserId(getUserId())) {
			return "/myPageView.do";
		}

		return "user/registerSupplierView.tiles";
	}

	@RequestMapping("/registerArtistView")
	public String artistAuthorityCheck() {
		if (authorityService.readArtistAutoritiesByUserId(getUserId())) {
			return "/myPageView.do";
		}
		return "user/registerArtistView.tiles";
	}

	/**************************************
	 * 아티스트 & 공급자 등록 controller
	 **************************************/
	
	@RequestMapping("/member/registArtist")
	public String registArtist(@ModelAttribute Artist artist, HttpServletRequest request)
			throws IllegalStateException, IOException {

		// artist 권한 정보 수정 용도.
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();

		// 파일 업로드 처리
		MultipartFile multiImage = artist.getMultiImage();
		if (multiImage != null && !multiImage.isEmpty()) {
			// 디렉토리 지정
			String dir = request.getServletContext().getRealPath("/artistImage");
			String fileName = UUID.randomUUID().toString();
			File upImage = new File(dir, fileName + ".jpg");
			multiImage.transferTo(upImage);
			artist.setArtistImage(fileName + ".jpg");
		}
		// 사용자의 id 조회
		artist.setArtistId(getUserId());

		// business logic
		artistService.registerArtist(artist);

		// 권한정보수정
		List<GrantedAuthority> list = (List<GrantedAuthority>) authentication.getAuthorities();

		// token 재생성 및 권한정보 재수정
		UsernamePasswordAuthenticationToken newAuthentication = new UsernamePasswordAuthenticationToken(
				userService.selectMemberById(getUserId()), null, list);

		context.setAuthentication(null);

		// response
		return "redirect:/registerSuccessView.do";
	}

	/***************************************
	 * 대관공급자로 등록한다.
	 * 
	 * @param supplier
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 ***************************************/

	@RequestMapping("/member/registSupplier")
	public ModelAndView registSupplier(@ModelAttribute PremiumStage supplier, HttpServletRequest request)
			throws IllegalStateException, IOException {
		
		// 권한 조회하자.
		if (authorityService.checkStageAuthorityByUserId(supplier.getOperatorUserId())) {
			return new ModelAndView("/myPageView.do", "errorMsg", "이미 공급자로 등록하셨네요~");
		}
		
		// Image 설정
		List<MultipartFile> list = supplier.getMultiImage();
		
		// 공연장 사진테이블에 넣을 사진의 directory를 저장하는 list
		List<String> imageList = new ArrayList<>();

		// 반복문으로 여러개의 이미지를 업로드 시킨다. 이미지는 suppierImage 폴더에 저장
		for (MultipartFile image : list) {
			int i = 0; // 첫번째 사진은 VO에 설정할 stageImage 파일명. (대표사진)
			String dir = request.getServletContext().getRealPath("/supplierImage");
			String fileName = UUID.randomUUID().toString();
			File upImage = new File(dir, fileName + ".jpg");
			image.transferTo(upImage);
			if (i == 0) {
				// 첫번째 사진은 premium supplier의 대표사진으로 등록한다.
				supplier.setStageImage(fileName + ".jpg");
				i = 1;
			}
			imageList.add(fileName + ".jpg");
		}

		// 프리미엄 공연장 사진을 등록
		// 매개변수로는 사진의 파일명 list, 사업장 번호. (사진번호는 sequence로 보낸다)
		// business service
		supplier.setOperatorUserId(getUserId());
		stageService.registerSupplier(supplier, imageList);

		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		
		// 권한정보수정
		List<GrantedAuthority> list2 = (List<GrantedAuthority>) authentication.getAuthorities();
		System.out.println(list2);
		// token 재생성 및 권한정보 재수정
		UsernamePasswordAuthenticationToken newAuthentication = new UsernamePasswordAuthenticationToken(
				userService.selectMemberById(getUserId()), null, list2);
		
		context.setAuthentication(null);

		// ModelAndView 로 보낼 map
		Map<String, Object> map = new HashMap<>();
		map.put("premiumStage", supplier);
		map.put("imageList", imageList);
		
		// response
		return new ModelAndView("stage/premiumStageDetailView.tiles", "map", map);
	}

	/**************************************
	 * 회원정보 수정 controller
	 **************************************/

	@RequestMapping("/member/updatePage")
	public ModelAndView updateMemberForm() {
		// id 를 매개변수로 User 객체를 가져온다.
		User user = userService.selectMemberById(getUserId());

		// User 객체정보를 request에 담아 page 에서 조회한다.
		return new ModelAndView("/updateMemberView.do", "user", user);
	}

	@RequestMapping("/member/updateMember")
	public String updateMember(@ModelAttribute User user, String newpassword) {

		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();

		// 유저정보 업데이트
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(newpassword));
		System.out.println(user);
		userService.updateMember(user);

		// 권한정보수정
		List<GrantedAuthority> list = (List<GrantedAuthority>) authentication.getAuthorities();

		// token 재생성 및 권한정보 재수정
		UsernamePasswordAuthenticationToken newAuthentication = new UsernamePasswordAuthenticationToken(
				userService.selectMemberById(getUserId()), null, list);

		System.out.println(newAuthentication);
		context.setAuthentication(newAuthentication);

		return "redirect:/updateSuccess.do";
	}

	/**************************************
	 *	 아티스트정보 수정 controller
	 **************************************/

	@RequestMapping("/artist/updateArtist")
	public String updateArtist(@ModelAttribute Artist artist, HttpServletRequest request)
			throws IllegalStateException, IOException {

		// 파일처리.
		MultipartFile multiImage = artist.getMultiImage();
		if (multiImage != null && !multiImage.isEmpty()) {
			
			// 디렉토리 지정
			String dir = request.getServletContext().getRealPath("/artistImage");
			String fileName = UUID.randomUUID().toString();
			File upImage = new File(dir, fileName + ".jpg");
			multiImage.transferTo(upImage);
			artist.setArtistImage(fileName + ".jpg");
		}

		// 아티스트 서비스를 통해 정보를 update 해준다.
		artistService.updateArtist(artist);
	
		// response.
		return "redirect:/updateSuccess.do";
	}

	/**************************************
	 * 대관공급자 정보 수정 controller
	 * 
	 * @throws IOException
	 * @throws IllegalStateException
	 **************************************/

	@RequestMapping("/producer/updateSupplier")
	public String updateSupplier(@ModelAttribute PremiumStage supplier, HttpServletRequest request)
			throws IllegalStateException, IOException {

		// 파일처리.
		List<MultipartFile> multiImage = supplier.getMultiImage();

		if (multiImage != null && !multiImage.isEmpty()) {
			// 디렉토리 지정
			String dir = request.getServletContext().getRealPath("/supplierImage");
			String fileName = UUID.randomUUID().toString();
			File upImage = new File(dir, fileName + ".jpg");
			((MultipartFile) multiImage).transferTo(upImage);
			supplier.setStageImage(fileName + ".jpg");
		}
		stageService.updateSupplier(supplier);
		return "redirect:/updateSuccess.do";
	}


	/*******************************************
	 * 		팔로우한 아티스트 Controller
	 *******************************************/
	
	@RequestMapping("/member/myFollowInfo")
	public ModelAndView myFollow() {
		
		// userId를 입력해서 follow정보를 가져온다.(artist정보)
		List<Artist> list = followService.followArtistList(getUserId());
		
		return new ModelAndView("myPage/myFollowingView.tiles","list",list);
	}
	
	/******************************************
	 *		좋아요 누른 글 정보 controller 	
	 ******************************************/
	@RequestMapping("/member/myLikeInfo")
	public ModelAndView myLike() {
		// 좋아요를 누른 공연정보와 영상정보를 가져온다. (map) performancelike, videolike
		List<Performance> list = performanceLikeService.performanceByLikeId(getUserId());
		List<Video> videoList = videoService.selectVideoByVideoLikeId(getUserId()); 
		
		//test
		for(Performance p : list) {
			System.out.println(list);
		}
		for(Video v : videoList) {
			System.out.println(v);
		}
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("performanceList", list);
		map.put("videoList", videoList);
		return new ModelAndView("myPage/myLikeView.tiles","map",map);
		
	}
	
	// Security context 값을 받아서 userId 를 받는 method
	private String getUserId() {
		return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
	}

}
