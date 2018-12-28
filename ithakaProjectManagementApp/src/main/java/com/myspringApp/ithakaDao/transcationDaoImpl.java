package com.myspringApp.ithakaDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.myspringApp.ithakaModel.Transaction;

public class transcationDaoImpl implements transcationDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Transaction> listActivityByID(String setupNo) {
		
		//String sql = "select * from transaction where setupNo = ?";
		
		String sql = "select transaction.setupNo, transaction.userId, users.userName, inventory.streamName, "
				+ "transaction.activity, transaction.activity_status, transaction.activity_comment from "
				+ "transaction JOIN inventory on transaction.setupNo = inventory.setupNo JOIN users on"
				+ " transaction.userId = users.userId where transaction.setupNo = ?  group by transaction.activity";
		
		List<Transaction> listTransaction = new ArrayList<Transaction>();
		
		listTransaction = jdbcTemplate.query(sql, new Object[] {setupNo}, new ResultSetExtractor<List<Transaction>>() {

			public List<Transaction> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Transaction> list = new ArrayList<Transaction>();
					while(rs.next()) {
					Transaction transaction = new Transaction();
					transaction.setSetupNo(rs.getString(1));
					transaction.setUserId(rs.getString(2));
					transaction.setUserName(rs.getString(3));
					transaction.setStreamName(rs.getString(4));
					transaction.setActivity(rs.getString(5));
					transaction.setActivity_status(rs.getString(6));
					transaction.setActivity_comment(rs.getString(7));
					
					list.add(transaction);
							/*
							 * System.out.println("listActivityByID(String setupNo)" +
							 * transaction.getSetupNo() + " " + transaction.getStreamName() + " " +
							 * transaction.getUserName());
							 */
					}
				
				return list;
			}
		});
		
		
		return listTransaction;
	}//end of method

	public void loggTaskInDB(Transaction transaction) {
		String sql = "insert into transaction(setupNo, userId, activity, activity_start_date, activity_comment)"
				+ " values (?, ?, ?, ?, CONCAT('[', now(), '] ', ?, ' '))";
		
		jdbcTemplate.update(sql, new Object[] {
				transaction.getSetupNo(),
				transaction.getUserId(),
				transaction.getActivity(),
				transaction.getActivity_start_date(),
				transaction.getActivity_comment()
		});
		
	}


	

}
