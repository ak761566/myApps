package com.myspringApp.ithakaController;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
		/*
		 * List<Inventory> inventorylist = projectdao.listProjects();
		 * model.addObject("inventorylist", inventorylist);
		 */
		
		return model;
	}
	
	@RequestMapping(value="/admin/newStream/save", method = RequestMethod.POST)
	public ModelAndView saveNewStream(@RequestParam Map<String, String> inventory) {
		ModelAndView model = new ModelAndView("newStream");
		
		  System.out.println(inventory.get("setupNo"));
		
		/*
		 * try { if(projectdao.getProjectById(inventory.getSetupNo()) != null) {
		 * //Stream all ready present in the DataBase; } } catch(Exception e) {
		 * 
		 * projectdao.addNewProject(inventory); }
		 * 
		 * List<Inventory> inventorylist = projectdao.listProjects();
		 * model.addObject("inventorylist", inventorylist);
		 */
		 
		return model;
	}
	
	@RequestMapping(value="/admin/project/save", method = RequestMethod.POST)
	//public ModelAndView  saveProject(@ModelAttribute("inventory") Inventory inventory)
	public ModelAndView  saveProject()
	{
		ModelAndView model = new ModelAndView("newStream");
		
		/*
		 * System.out.println(inventory.getSetupNo() + " " + inventory.getStreamName() +
		 * " " + inventory.getStreamType() + " " + inventory.getComplexity() + " " +
		 * inventory.getBatchCount() + " " + inventory.getKickOffDate() + " " +
		 * inventory.getDueDate());
		 */
		
		/*
		 * try { if(projectdao.getProjectById(inventory.getSetupNo()) != null) {
		 * 
		 * //Stream all ready present in the DataBase; } }catch(Exception e) {
		 * 
		 * projectdao.addNewProject(inventory); }
		 * 
		 * List<Inventory> inventorylist = projectdao.listProjects();
		 * model.addObject("inventorylist", inventorylist);
		 */
		return model;
	}
	
}
