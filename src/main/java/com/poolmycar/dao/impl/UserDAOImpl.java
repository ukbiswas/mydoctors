package com.poolmycar.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.poolmycar.dao.UserDAO;
import com.poolmycar.domain.User;
//import org.springframework.data.mongodb.core.MongoOperations;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	public static String INSERT_USER = "insert into users (email, password, firstname, lastname, phone, profession, driver, description) "
			+ "values (:email, :password, :firstName, :lastName, :phone, :profession, :driver, :description)";
	public static String SELECT_USER = "SELECT id, firstname, lastname, email, password,  phone, profession, driver, description FROM users "
			+ "WHERE id=:id";
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	//private MongoOperations mongoOps;
	//private MongoTemplate mongoTemplate;
	
	
	public User getUser(String id) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("id", id);
		System.out.println("in dao id="+id);
		List<User> userList = namedParameterJdbcTemplate.query(SELECT_USER, paramMap, mapperUser);
		System.out.println("userList="+userList);
		User user = null;
		if(userList != null && !userList.isEmpty()) {
			user = userList.get(0);
		}
		return user;
	}

	public void saveUser(User user) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("email", user.getEmail());
		paramMap.put("password", user.getPassword());
		paramMap.put("firstName", user.getFirstName());
		paramMap.put("lastName", user.getLastName());
		paramMap.put("phone", user.getPhone());
		paramMap.put("profession", user.getProfession());
		paramMap.put("driver", user.getDriver());
		paramMap.put("description", user.getDescription());
		namedParameterJdbcTemplate.update(INSERT_USER, paramMap);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	RowMapper<User> mapperUser = new RowMapper<User>(){
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			System.out.println("id="+rs.getString("id"));
			user.setId(rs.getString("id"));
			user.setFirstName(rs.getString("firstname"));
			System.out.println("firstname="+rs.getString("firstname"));
			user.setLastName(rs.getString("lastname"));
			user.setEmail(rs.getString("email"));
			user.setPhone(rs.getString("phone"));
			user.setPassword(rs.getString("password"));
			user.setProfession(rs.getString("profession"));
			user.setDescription(rs.getString("description"));
			user.setDriver(rs.getString("driver"));
			
            return user;
        }
	};
}
