package com.mydoctors.dao.impl;

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

import com.mydoctors.dao.UserDAO;
import com.mydoctors.domain.User;
//import org.springframework.data.mongodb.core.MongoOperations;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	@Autowired
	//private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	//private MongoOperations mongoOps;
	private MongoTemplate mongoTemplate;
	
	
	public User getUser(String username) {
		// TODO Auto-generated method stub
		Query query = query(where("username").is(username));
		return mongoTemplate.findOne(query, User.class);
	}

	public void saveUser(User user) {
		// TODO Auto-generated method stub
		//mongoOps.save(user);
		mongoTemplate.insert(user);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}
}
