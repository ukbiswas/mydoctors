package com.mydoctors.dao.impl;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.DBObject;
import com.mydoctors.common.KeyConstants;
import com.mydoctors.dao.DoctorDAO;
import com.mydoctors.domain.Doctor;


@Repository("doctorDAO")
public class DoctorDAOImpl implements DoctorDAO {

	@Autowired
	//private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	//private MongoOperations mongoOps;
	private MongoTemplate mongoTemplate;
	//private String collectionName = "doctors";
	
	
	/**
	 * 
	 */
	public List<Doctor> getDoctor(JSONObject searchJson) {
		//TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny("some key word");
		Query query = new Query(Criteria.where(KeyConstants.LOCATION).regex(searchJson.getString(KeyConstants.LOCATION)).and(KeyConstants.NAME).is(searchJson.get(KeyConstants.NAME)));
		return mongoTemplate.find(query, Doctor.class);
	}
	
	public List<Doctor> getAllDoctor() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(Doctor.class);
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
