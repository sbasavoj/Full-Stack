package com.cg.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.beans.Associate;
@Controller
public class URLController {
	@RequestMapping(value="/")
	public String getIndexPage(){
		return "indexPage";
	}
	@RequestMapping(value="/login")
	public String getLoginPage(){
		return "loginPage";
	}
	@RequestMapping(value="/registeration")
	public String getRegisterationPage(){
		return "registrationPage";
	}
	@ModelAttribute("associate")
	public Associate getAssociate(){
		return new Associate();
	}
}