package com.mydoctors.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.DBObject;
import com.mydoctors.common.KeyConstants;
import com.mydoctors.dao.DoctorDAO;
import com.mydoctors.domain.Dispensary;
import com.mydoctors.domain.Doctor;


@Repository("doctorDAO")
public class DoctorDAOImpl implements DoctorDAO {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	//private MongoOperations mongoOps;
	//private MongoTemplate mongoTemplate;
	//private String collectionName = "doctors";
	
	private static final String INSERT_DOCTOTS = "INSERT INTO doctors(registration, name, degree, phone, email, city, specialization, description) "
												+ "values(:registration, :name, :degree, :phone, :email, :city, :specialization, :description)"; 
	private static final String INSERT_DISPENSARY = "INSERT INTO dispensaries(registration, days, timing, visit, phone, address, pin) "
												+ "values(:registration, :days, :timing, :visit, :phone, :address, :pin)";
	
	/**
	 * 
	 */
	public List<Doctor> getDoctor(JSONObject searchJson) {
		//TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny("some key word");
		Query query = new Query(Criteria.where(KeyConstants.LOCATION).regex(searchJson.getString(KeyConstants.LOCATION)).and(KeyConstants.NAME).is(searchJson.get(KeyConstants.NAME)));
		return null;
	}
	
	public List<Doctor> getAllDoctor() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		//mongoOps.save(user);
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("registration", doctor.getRegistration());
		paramMap.put("name", doctor.getName());
		paramMap.put("degree", doctor.getDegree());
		paramMap.put("phone", doctor.getPhone());
		paramMap.put("email", doctor.getEmail());
		paramMap.put("city", doctor.getCity());
		paramMap.put("specialization", doctor.getSpecialization());
		paramMap.put("description", doctor.getDescription());
		namedParameterJdbcTemplate.update(INSERT_DOCTOTS, paramMap);
		//mongoTemplate.insert(doctor);
	}
	
	public void addDispensary(Dispensary dispensary) {
		// TODO Auto-generated method stub
		//mongoOps.save(user);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("registration", dispensary.getRegistration());
		paramMap.put("days", dispensary.getDays());
		paramMap.put("timing", dispensary.getTiming());
		paramMap.put("visit", dispensary.getVisit());
		paramMap.put("phone", dispensary.getPhone());
		paramMap.put("address", dispensary.getAddress());
		paramMap.put("pin", dispensary.getPin());
		namedParameterJdbcTemplate.update(INSERT_DISPENSARY, paramMap);
		//mongoTemplate.insert(doctor);
	}

	public void updateDoctor(Doctor user) {
		// TODO Auto-generated method stub

	}
}
