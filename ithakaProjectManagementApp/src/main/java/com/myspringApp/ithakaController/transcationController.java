package com.myspringApp.ithakaController;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class transcationController {
	
	@RequestMapping(value="user/task/{setupNo}", method = RequestMethod.GET)
	public ModelAndView taskAssignPage(@PathVariable String setupNo) {
		ModelAndView model = new ModelAndView("taskAssignPage");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedUserName = auth.getName();
		
		model.addObject("loggedUserName", loggedUserName);
		model.addObject("setupNo", setupNo);
		
		return model;
	}
	
	@RequestMapping(value="/user/assignTask")
	public ModelAndView AssignTask(@PathVariable String setupNo) {
		ModelAndView model = new ModelAndView("taskAssignPage");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedUserName = auth.getName();
		
		model.addObject("loggedUserName", loggedUserName);
		
		return model;
	}

}
