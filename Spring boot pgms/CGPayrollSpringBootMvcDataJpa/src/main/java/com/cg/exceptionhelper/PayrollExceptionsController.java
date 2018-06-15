package com.cg.exceptionhelper;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import com.cg.beans.Associate;
import com.cg.exception.AssociateDetailsNotFoundException;
import com.cg.exception.PayrollServicesDownException;
@ControllerAdvice(basePackages="com.cg.controllers")
public class PayrollExceptionsController {
	@ExceptionHandler(PayrollServicesDownException.class)
	public String handleServicesDownException(){
		return "errorPage";
	}
	@ExceptionHandler(AssociateDetailsNotFoundException.class)
	public ModelAndView handleUserNotFoundException(){
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("loginPage");
		modelAndView.addObject("associate", new Associate());
		return modelAndView;
	}
}
