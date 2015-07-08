package com.mydoctors.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mydoctors.dao.DoctorDAO;
import com.mydoctors.domain.Doctor;


@Repository("doctorDAO")
public class DoctorDAOImpl implements DoctorDAO {

	@Autowired
	//private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	//private MongoOperations mongoOps;
	private MongoTemplate mongoTemplate;
	
	
	public Doctor getDoctor(String id) {
		// TODO Auto-generated method stub
		Query query = new Query(Criteria.where("_id").is(id));
		return mongoTemplate.findOne(query, Doctor.class);
	}

	public void saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		//mongoOps.save(user);
		mongoTemplate.insert(doctor);
	}

	public void updateDoctor(Doctor user) {
		// TODO Auto-generated method stub

	}
}
