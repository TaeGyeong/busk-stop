package com.buskstop.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.ArtistService;
import com.buskstop.service.PremiumStageService;
import com.buskstop.service.UserService;
import com.buskstop.vo.Artist;
import com.buskstop.vo.PremiumStage;
import com.buskstop.vo.User;

@Controller
public class MyPageController {

	@Autowired
	private UserService userService;

	@Autowired
	private ArtistService artistService;

	@Autowired
	private PremiumStageService stageService;

	/**************************************
	 * 아티스트 & 공급자 등록 controller
	 **************************************/

	@RequestMapping("/member/registArtist")
	public String registArtist(@ModelAttribute Artist artist, HttpServletRequest request)
			throws IllegalStateException, IOException {
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

		// response
		return "redirect:/registerSuccessView.do";
	}

	@RequestMapping("/member/registSupplier")
	public String registSupplier(@ModelAttribute PremiumStage supplier, BindingResult r, HttpServletRequest request)
			throws IllegalStateException, IOException {
		System.out.println(r);
		System.out.println(r.getErrorCount());

		System.out.println(supplier);
		// Image 설정
		MultipartFile multiImage = supplier.getMultiImage();
		if (multiImage != null && !multiImage.isEmpty()) {
			// 디렉토리 지정
			String dir = request.getServletContext().getRealPath("/supplierImage");
			String fileName = UUID.randomUUID().toString();
			File upImage = new File(dir, fileName + ".jpg");
			multiImage.transferTo(upImage);
			supplier.setPremiumStageImage(fileName + ".jpg");
		}

		System.out.println(supplier);

		// business service
		stageService.registerSupplier(supplier);

		// response
		return "redirect:/registerSuccessView.do";
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
		// test
		for (GrantedAuthority authority : list) {
			System.out.println(authority);
		}
		// token 재생성 및 권한정보 재수정
		UsernamePasswordAuthenticationToken newAuthentication = new UsernamePasswordAuthenticationToken(
				userService.selectMemberById(getUserId()), null, list);

		System.out.println(newAuthentication);
		context.setAuthentication(newAuthentication);

		return "redirect:/updateSuccess.do";
	}

	/**************************************
	 * 아티스트정보 수정 controller
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
	 * @throws IOException 
	 * @throws IllegalStateException 
	 **************************************/

	@RequestMapping("/producer/updateSupplier")
	public String updateSupplier(@ModelAttribute PremiumStage supplier, HttpServletRequest request) throws IllegalStateException, IOException {
		// 파일처리.
		MultipartFile multiImage = supplier.getMultiImage();
		if (multiImage != null && !multiImage.isEmpty()) {
			// 디렉토리 지정
			String dir = request.getServletContext().getRealPath("/supplierImage");
			String fileName = UUID.randomUUID().toString();
			File upImage = new File(dir, fileName + ".jpg");
			multiImage.transferTo(upImage);
			supplier.setPremiumStageImage(fileName+".jpg");
		}
		
		stageService.updateSupplier(supplier);
		return "redirect:/updateSuccess.do";
	}

	// Security context 값을 받아서 userId 를 받는 method
	private String getUserId() {
		return ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
	}

}
