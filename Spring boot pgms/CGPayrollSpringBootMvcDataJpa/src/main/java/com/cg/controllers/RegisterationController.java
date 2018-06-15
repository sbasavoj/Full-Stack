package com.cg.controllers;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.cg.beans.Associate;
import com.cg.exception.AssociateDetailsNotFoundException;
import com.cg.exception.PayrollServicesDownException;
import com.cg.services.PayrollServices;
@Controller
public class RegisterationController {
	@Autowired PayrollServices payrollServices;
	@RequestMapping(value="/registerUser")
	public String registerUser(@Valid @ModelAttribute("associate")Associate associate, BindingResult result ) throws PayrollServicesDownException{
		if(result.hasErrors()) return "registrationPage";
		payrollServices.acceptAssociateDetails(associate);
		return "successPage";
	}
	@RequestMapping(value="/authUser")
	public ModelAndView authUser(@Valid @ModelAttribute("associate")Associate associate, BindingResult result ) throws AssociateDetailsNotFoundException, PayrollServicesDownException {
		ModelAndView modelAndView=new ModelAndView();
		if(result.hasFieldErrors("associateId")||result.hasFieldErrors("password"))
			modelAndView.setViewName("loginPage");
		else{
			Associate associate2=payrollServices.getAssociateDetails(associate.getAssociateId());
			if(associate.getPassword().equals(associate2.getPassword()))
			modelAndView.setViewName("loginSuccessPage");
			modelAndView.addObject("associate", associate2);
		}
		return modelAndView;

	}
}