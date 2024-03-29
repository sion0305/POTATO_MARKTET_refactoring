package com.ssg.potato.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.ssg.potato.account.model.Member;
import com.ssg.potato.account.service.MemberService;
import com.ssg.potato.account.service.MemberValidator;

@Controller
@RequestMapping("/member")
public class AccountRegistController {
	private static final String FORM_VIEW = "../jsp/join";
	private static final String RESULT_VIEW = "../jsp/login";
	
	@Autowired
	private MemberService memberService;
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@ModelAttribute("member")
	public Member formBacking()  {
		Member member = new Member();
		return member;
	}   

	@RequestMapping(value="/join" ,method = RequestMethod.GET)
	public String form() {
		return FORM_VIEW;
	}
		
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String submit(
			@ModelAttribute("member") Member member,
			BindingResult result, Model model, SessionStatus sessionStatus) throws Exception {		
		
		System.out.println("command 객체: " + member);	
		new MemberValidator().validate(member, result);

		if (result.hasErrors()) {
			return FORM_VIEW;
		}
		
		memberService.memberJoin(member);	
		sessionStatus.setComplete(); // session에서 객체 삭제
		return RESULT_VIEW;
	}	
	
	
	
}

