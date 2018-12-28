package com.myspringApp.ithakaController;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myspringApp.ithakaDao.transcationDao;
import com.myspringApp.ithakaDao.userDao;
import com.myspringApp.ithakaModel.Transaction;
import com.myspringApp.ithakaModel.Users;

@Controller
public class transcationController {
	
	@Autowired
	private transcationDao transcationdao;
	@Autowired
	private userDao userdao;
	
	@RequestMapping(value="/user/task/{setupNo}", method = RequestMethod.GET)
	public ModelAndView taskAssignPage(@PathVariable String setupNo) {
		ModelAndView model = new ModelAndView("taskAssignPage");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedUserName = auth.getName();
		
		List<Transaction> listTransaction = transcationdao.listActivityByID(setupNo);
		System.out.println("/user/task/{setupNo}" + listTransaction);
		
		Users user = userdao.getUserByName(loggedUserName);
		
		model.addObject("loggedUserName", loggedUserName);
		model.addObject("setupNo", setupNo);
		model.addObject("userInfo", user);
		model.addObject("listTransaction", listTransaction);
		
		return model;
	}
	
	@RequestMapping(value="/user/task/assign", method = RequestMethod.POST)
	public ModelAndView AssignTask(@ModelAttribute("transaction") Transaction transcation) {
		ModelAndView model = new ModelAndView("taskAssignPage");
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedUserName = auth.getName();
		Users user = userdao.getUserByName(loggedUserName);
		
		transcation.setActivity_start_date(new Date());
		transcation.setUserId(user.getUserId());
		
		transcationdao.loggTaskInDB(transcation);
		
		model.addObject("loggedUserName", loggedUserName);
		
		List<Transaction> listTransaction = transcationdao.listActivityByID(transcation.getSetupNo());
		model.addObject("listTransaction", listTransaction);
		model.addObject("setupNo", transcation.getSetupNo());
		model.addObject("userInfo", user);
		
		return model;
	}

}
