package com.myspringApp.ithakaController;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class userController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("defaultPage");
		
		return model;
		
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView model = new ModelAndView("login");
		
		return model;
		
	}
	
	@RequestMapping(value="/admin/dashboard", method = RequestMethod.GET)
	public ModelAndView adminPage(Principal principal) {
		ModelAndView model = new ModelAndView("adminDashboard");
		model.addObject("name", principal.getName());
		return model;
		
	}
	
	
	@RequestMapping(value="/logoutSuccess", method = RequestMethod.GET)
	public ModelAndView logoutPage() {
		ModelAndView model = new ModelAndView("logoutSeccess");
		model.addObject("title", "Admin Dashboard !");
		return model;
		
	}
}
