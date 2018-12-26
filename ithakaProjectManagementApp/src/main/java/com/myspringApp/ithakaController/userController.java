package com.myspringApp.ithakaController;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspringApp.ithakaDao.userDao;
import com.myspringApp.ithakaModel.Users;

@Controller
public class userController {
	@Autowired
	private userDao userdao;

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
	
		/* User Controller */
	
	@RequestMapping(value="/user/dashboard", method = RequestMethod.GET)
	public ModelAndView userPage(Principal principal) {
		ModelAndView model = new ModelAndView("userDashboard");
		model.addObject("name", principal.getName());
		return model;
	}
	
	@RequestMapping(value="/admin/dashboard", method = RequestMethod.GET)
	public ModelAndView adminPage(Principal principal) {
		ModelAndView model = new ModelAndView("adminDashboard");
		model.addObject("name", principal.getName());
		return model;
		
	}

	@RequestMapping(value="/admin/newStream", method = RequestMethod.GET)
	public ModelAndView newStream(Principal principal) {
		ModelAndView model = new ModelAndView("newStream");
		model.addObject("name", principal.getName());
		return model;
		
	}
	
	@RequestMapping(value="/admin/newUser", method = RequestMethod.GET)
	public ModelAndView newUser(Principal principal) {
		ModelAndView model = new ModelAndView("NewUser");
		List<Users> userslist = userdao.getAllUsers();
		
		model.addObject("name", principal.getName());
		model.addObject("usersList", userslist);
		return model;
		
	}
	
	@RequestMapping(value="/admin/newUser/save", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("user") Users user, Principal principal) {
		ModelAndView model = new ModelAndView("NewUser");
		List<Users> userslist = userdao.getAllUsers();
		
		model.addObject("name", principal.getName());
		model.addObject("usersList", userslist);
		
		  try { 
			    if(userdao.getUserById(user.getUserId()) != null) 
				  { 
					  System.out.println(2); 
					  userdao.updateUser(user);
					  model.addObject("message", "User Record has been updated successfuly"); 
				 }
			 }catch(EmptyResultDataAccessException e) 
		        { 
		  userdao.addUser(user); 
		  model.addObject("message", "New User Record has been added successfuly"); 
		  }
		 
 		return model;
	}
	
	@RequestMapping(value="/logoutSuccess", method = RequestMethod.GET)
	public ModelAndView logoutPage() {
		ModelAndView model = new ModelAndView("logoutSeccess");
		model.addObject("title", "Admin Dashboard !");
		return model;
		
	}
}
