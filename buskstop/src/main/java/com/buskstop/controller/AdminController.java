package com.buskstop.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.buskstop.service.StageService;
import com.buskstop.service.UserService;
import com.buskstop.vo.Stage;
import com.buskstop.vo.StageImage;
import com.buskstop.vo.User;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private StageService stageService;
	
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
	
	// 관리 페이지 메인.
	@RequestMapping("stage")
	public ModelAndView goStageManagement() {
		List<Stage> list = stageService.selectStage();
		for(Stage s : list) {
			System.out.println(s);
		}
		return new ModelAndView("admin/stageManagementView.tiles","list",list);
	}
	
	// 관리자 공연 정보 수정
	@RequestMapping("updateStage")
	public ModelAndView updateAdminStageByStageNo(@RequestParam int stageNo) {
		Stage stage = stageService.selectStageByStageNo(stageNo);
		List<StageImage> stageImage = stageService.selectStageImageByStageNo(stageNo);
		stage.setStageImage(stageImage);
		return new ModelAndView("admin/adminStageUpdateView.tiles", "stage", stage);
	}
	
	// 관리자 공연정보 수정 후 관리자 공연관리 페이지로 이동.
	@RequestMapping("updateStageChange")
	public ModelAndView updateAdminStageChange(@ModelAttribute Stage stage, MultipartHttpServletRequest mhsq, HttpServletRequest request) throws IllegalStateException, IOException {
		//공연장 변경
		stageService.updateStage(stage);
		
		//파일 경로
		String dir = request.getServletContext().getRealPath("/stageImage");
		
		//넘어온 파일을 리스트로 저장
		List<MultipartFile> mf = mhsq.getFiles("imgs");
		if(mf.size()==1 && mf.get(0).getOriginalFilename().equals("")) {
		}else {	for(int i=0; i< mf.size(); i++) {
				//파일 중복명 처리, 저장되는 파일 이름
				String fileName = UUID.randomUUID().toString();
				//파일 저장
				File upImage = new File(dir, fileName+".jpg");
				mf.get(i).transferTo(upImage);
				StageImage uploadImage = new StageImage(0, fileName, stage.getStageNo());
				stageService.insertStageImage(uploadImage);
			}
		}
		
		int delImageInt = 0;
		//삭제한 이미지 삭제
		String[] delImage = request.getParameterValues("delImage");
		if(delImage!=null) {
			for(int i=0; i<delImage.length; i++) {
				delImageInt = Integer.parseInt(delImage[i]);
				stageService.deleteStageImageByStageImageNo(delImageInt);
			}
		}
		
		return new ModelAndView("redirect:/admin/stage.do");
	}
	
	// 관리자 공연장 삭제.
	@RequestMapping("deleteStage")
	public ModelAndView deleteAdminStage(@RequestParam int stageNo) {
		stageService.deleteStageImageByStageNo(stageNo);
		stageService.deleteStageByStageNo(stageNo);
		
		return new ModelAndView("redirect:/admin/stage.do");
	}
	
	// 관리자페이지 공연장 정보 조회
	@RequestMapping("stageSearch")
	public ModelAndView stageSearch(@RequestParam(value="category", required=false)String category,
									@RequestParam(value="reserve", required=false)String reserve,
									@RequestParam(value="sDate", required=false, defaultValue="1000-00-00") String sDate, 
									@RequestParam(value="eDate", required=false, defaultValue="5000-00-00")String eDate,
									@RequestParam(value="userId", required=false)String userId) throws ParseException {
		
		Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
		Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(eDate);
		
		List<Stage> list = stageService.searchStageByAdmin(reserve,startDate, endDate, userId);
		return new ModelAndView("admin/stageManagementView.tiles","list",list);
	}
	
}
