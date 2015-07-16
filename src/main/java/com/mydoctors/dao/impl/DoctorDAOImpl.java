package com.mydoctors.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.jdbc.core.RowMapper;
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
	private static final String SEARCH_DOCTORS = "SELECT * FROM doctors WHERE MATCH(name, city, specialization) AGAINST ( :searchString IN BOOLEAN MODE)";
	private static final String SELECT_DOCTOR_BY_REGISTRATION = "SELECT registration, name, degree, phone, email, city, specialization, description FROM doctors WHERE registration = :registration";
	
	/**
	 * 
	 */
	public List<Doctor> searchDoctors(String searchString) throws DataAccessException {
		//TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny("some key word");
		//Query query = new Query(Criteria.where(KeyConstants.LOCATION).regex(searchJson.getString(KeyConstants.LOCATION)).and(KeyConstants.NAME).is(searchJson.get(KeyConstants.NAME)));
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("searchString", searchString);
		return namedParameterJdbcTemplate.query(SEARCH_DOCTORS, paramMap, rowMapperDoctor);
	}
	
	public Doctor getDoctor(String registration) throws DataAccessException {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("registration", registration);
		List<Doctor> doctors = namedParameterJdbcTemplate.query(SELECT_DOCTOR_BY_REGISTRATION, paramMap, rowMapperDoctor);
		Doctor doctor = null;
		if(doctors != null && !doctors.isEmpty()) {
			doctor = doctors.get(0);
		}
		return doctor;
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
	
	RowMapper<Doctor> rowMapperDoctor = new RowMapper<Doctor>(){
		public Doctor mapRow(ResultSet rs, int rowNum) throws SQLException {
			Doctor doctor = new Doctor();
			doctor.setRegistration(rs.getString("registration"));
			doctor.setName(rs.getString("name"));
			doctor.setDegree(rs.getString("degree"));
			doctor.setPhone(rs.getString("phone"));
			doctor.setEmail(rs.getString("email"));
			doctor.setCity(rs.getString("city"));
			doctor.setSpecialization(rs.getString("specialization"));
			doctor.setDescription(rs.getString("description"));
            return doctor;
        }
	};
}
