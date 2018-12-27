package com.myspringApp.ithakaController;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myspringApp.ithakaDao.projectDao;
import com.myspringApp.ithakaModel.Inventory;
import com.myspringApp.ithakaModel.Users;

@Controller
public class projectController {
	
	@Autowired
	private projectDao projectdao;
	
	@RequestMapping(value="/admin/project", method = RequestMethod.GET)
	public ModelAndView  projectPage(Principal principal) {
			ModelAndView model = new ModelAndView("newStream");
		  List<Inventory> inventorylist = projectdao.listProjects();
		  model.addObject("inventorylist", inventorylist);
		return model;
	}//end of method
	
	@RequestMapping(value="/admin/newStream/save", method = RequestMethod.POST)
	public ModelAndView saveNewStream(@RequestParam Map<String, String> inven,
			@ModelAttribute("inventory") Inventory inventory) {
		
		ModelAndView model = new ModelAndView("newStream");
		
		String dateFormat = "dd/MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date kickoffdate = null;
		Date duedate = null;
		
		try {
			kickoffdate = sdf.parse(inven.get("kickOffDate"));
			duedate = sdf.parse(inven.get("dueDate"));
			
			inventory.setKickOffDate(kickoffdate);
			inventory.setDueDate(duedate);
			
			} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		   //System.out.println("Map " + inven.get("kickOffDate"));
		  //System.out.println("Object " + inventory.getKickOffDate());
		 
		/*
		 * System.out.println(inventory.getSetupNo() + " " + inventory.getStreamName() +
		 * " " + inventory.getStreamType() + " " + inventory.getComplexity() + " " +
		 * inventory.getBatchCount() + " " + inventory.getKickOffDate() + " " +
		 * inventory.getDueDate());
		 */
		  
		try 
			{ if(projectdao.getProjectById(inventory.getSetupNo()) != null)
				{
					//Stream all ready present in the DataBase; 
				} 
			} catch(Exception e) {
		  
		  projectdao.addNewProject(inventory); 
		  }
		  
		  List<Inventory> inventorylist = projectdao.listProjects();
		  model.addObject("inventorylist", inventorylist);

		  return model;
	}//end of method
	
	
	@RequestMapping(value="/user/assignStream")
	public ModelAndView assignStream() {
		ModelAndView model = new ModelAndView("streamAssignPage");
		List<Inventory> inventorylist = projectdao.listProjects();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String loggedUserName  = auth.getName();
		
		model.addObject("inventorylist", inventorylist);
		model.addObject("loggedUserName", loggedUserName);
		return model;
	}
	
}
