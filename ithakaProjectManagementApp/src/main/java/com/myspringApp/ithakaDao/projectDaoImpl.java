package com.myspringApp.ithakaDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.myspringApp.ithakaModel.Inventory;

public class projectDaoImpl implements projectDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void addNewProject(Inventory inventory) {
	  String sql = "insert into inventory(setupNo, streamName, StreamType, Complexity, batchCount, kickOffDate, dueDate)"
	  		+ "values (?, ?, ?, ?, ?, ?, ?)";
	   jdbcTemplate.update(sql, new Object[] {
			   inventory.getSetupNo(),
			   inventory.getStreamName(),
			   inventory.getStreamType(),
			   inventory.getComplexity(),
			   inventory.getBatchCount(),
			   inventory.getKickOffDate(),
			   inventory.getDueDate()
			   });
		
	}

	public Inventory getProjectById(String setupNo) {
		String sql = "select * from inventory wdhere setupNo=?";
		Inventory inventory = jdbcTemplate.queryForObject(sql, new Object[] {setupNo}, new RowMapper<Inventory>(){

			public Inventory mapRow(ResultSet rs, int rowNum) throws SQLException {
				Inventory inventory = new Inventory();
				
				inventory.setSetupNo(rs.getString(1));
				inventory.setStreamName(rs.getString(2));
				inventory.setStreamType(rs.getString(3));
				inventory.setComplexity(rs.getString(4));
				inventory.setBatchCount(rs.getInt(5));
				inventory.setKickOffDate(rs.getDate(6));
				inventory.setDueDate(rs.getDate(7));
				
				return inventory;
			} } );
		
		return inventory;
	}

	public List<Inventory> listProjects() {
		String sql = "select * from inventory";
		
		List<Inventory> listInventory = new ArrayList<Inventory>();
		
		listInventory = jdbcTemplate.query(sql, new ResultSetExtractor<List<Inventory>>() {

			public List<Inventory> extractData(ResultSet rs) throws SQLException, DataAccessException {
					List<Inventory> list = new ArrayList<Inventory>();
					
					while(rs.next())
						{
							Inventory inventory = new Inventory();
							inventory.setSetupNo(rs.getString(1));
							inventory.setStreamName(rs.getString(2));
							inventory.setComplexity(rs.getString(3));
							inventory.setStreamType(rs.getString(4));
							inventory.setBatchCount(rs.getInt(5));
							inventory.setKickOffDate(rs.getDate(6));
							inventory.setDueDate(rs.getDate(7));
							
							list.add(inventory);
						}
								
				
				return list;
			}
			
		}
		);
		
		return listInventory;
	}
	
	

}
