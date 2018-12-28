package com.myspringApp.ithakaDao;

import java.util.List;

import com.myspringApp.ithakaModel.Transaction;

public interface transcationDao {
	
	public List<Transaction> listActivityByID(String setupNo);
	public void loggTaskInDB(Transaction transcation);
	
	

}
