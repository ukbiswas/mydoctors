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
	
	private static final String INSERT_DOCTOTS = "INSERT INTO doctors(registration, name, degree, specialization, phone, email, city, address, description) "
												+ "values(:registration, :name, :degree, :specialization, :phone, :email, :city, :address, :description)"; 
	
	private static final String SEARCH_DOCTORS = "SELECT registration, name, degree, specialization, phone, email, city, address, description "
												+ "FROM doctors WHERE MATCH(name, city, specialization) AGAINST ( :searchString IN BOOLEAN MODE)";
	private static final String SELECT_DOCTOR_BY_REGISTRATION = "SELECT registration, name, degree, specialization, phone, email, city, address, description FROM doctors WHERE registration = :registration";
	
	/**
	 * 
	 */
	public List<Doctor> searchDoctors(String searchString) throws DataAccessException {
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
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("registration", doctor.getRegistration());
		paramMap.put("name", doctor.getName());
		paramMap.put("degree", doctor.getDegree());
		paramMap.put("specialization", doctor.getSpecialization());
		
		paramMap.put("phone", doctor.getPhone());
		paramMap.put("email", doctor.getEmail());
		paramMap.put("city", doctor.getCity());
		paramMap.put("address", doctor.getAddress());
		paramMap.put("description", doctor.getDescription());
		namedParameterJdbcTemplate.update(INSERT_DOCTOTS, paramMap);
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
			doctor.setSpecialization(rs.getString("specialization"));
			
			doctor.setPhone(rs.getString("phone"));
			doctor.setEmail(rs.getString("email"));
			doctor.setCity(rs.getString("city"));
			doctor.setAddress(rs.getString("address"));
			doctor.setDescription(rs.getString("description"));
            return doctor;
        }
	};
}
