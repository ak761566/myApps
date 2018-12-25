package com.myspringApp.ithakaDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.myspringApp.ithakaModel.Users;

public class userDaoImpl implements userDao {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void addUser(Users user) {
		
		String sql = "insert into users(userName, userId, password, enabled, emailId) values (?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, new Object[] {
			user.getUserName(),	
			user.getUserId(),
			user.getPassword(),
			user.getEnabled(),
			user.getEmailId() });
		
	}

	public List<Users> getAllUsers() {
		String sql = "select * from users";
		
		List<Users> userList = jdbcTemplate.query(sql, new ResultSetExtractor<List<Users>>() {

			public List<Users> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Users> list = new ArrayList<Users>();
				
				while(rs.next()) {
					
					Users user = new Users();
					user.setUserName(rs.getString(1));
					user.setUserId(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setEnabled(rs.getInt(4));
					user.setEmailId(rs.getString(5));
					list.add(user);
				}
				return list;
			}//end of extractData method
		});//end of jdbcTemplate method
		
		return userList;
	}

	public Users getUserById(String userId) {
		String sql = "select * from users where userId = ?";
		Users user = jdbcTemplate.queryForObject(sql, new Object[] {userId}, new RowMapper<Users>() {

			public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
				Users user = new Users();
				
				user.setUserName(rs.getString(1));
				user.setUserId(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setEnabled(rs.getInt(4));
				user.setEmailId(rs.getString(5));
				
				return user;
			}
			
			
		});
		return user;
	}

	public void updateUser(Users user) {
		String sql = "Update users set userName=?, password=?, enabled=?, emailId=? where userId=?";
		
		jdbcTemplate.update(sql, new Object[] {user.getUserName(), user.getPassword(),
				user.getEnabled(), user.getEmailId(), user.getUserId()});
		
	}

	
}//end of userDemoImpl class
