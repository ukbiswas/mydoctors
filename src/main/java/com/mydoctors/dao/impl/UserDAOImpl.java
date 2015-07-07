package com.mydoctors.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
		Query query = new Query(Criteria.where("username").is(username));
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
