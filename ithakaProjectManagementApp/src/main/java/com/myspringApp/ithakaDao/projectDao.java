package com.myspringApp.ithakaDao;

import java.util.List;

import com.myspringApp.ithakaModel.Inventory;

public interface projectDao {

	public void addNewProject(Inventory inventory);
	public Inventory getProjectById(String setupNo);
	public List<Inventory> listProjects();
	
}
