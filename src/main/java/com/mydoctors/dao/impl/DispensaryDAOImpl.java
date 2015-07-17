package com.mydoctors.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mydoctors.dao.DispensaryDAO;
import com.mydoctors.domain.Dispensary;
import com.mydoctors.domain.Doctor;

@Repository("dispensaryDAO")
public class DispensaryDAOImpl implements DispensaryDAO {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private static final String INSERT_DISPENSARY = "INSERT INTO dispensaries(registration, days, timing, visit, phone, address, pin) "
													+ "values(:registration, :days, :timing, :visit, :phone, :address, :pin)";
	private static final String SELECT_DISPENSARY = "SELECT registration, days, timing, visit, phone, address, pin FROM dispensaries WHERE registration = :registration";

	@Override
	public List<Dispensary> getDispensary(String registration) throws DataAccessException {
		Map<String, String> paramMap = new HashMap<String, String>();
		System.out.println("in DispensaryDAOImpl : registration="+registration);
		paramMap.put("registration", registration);
		return namedParameterJdbcTemplate.query(SELECT_DISPENSARY, paramMap, rowMapperDispensary);
	}

	@Override
	public void addDispensary(Dispensary dispensary) throws DataAccessException {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("registration", dispensary.getRegistration());
		paramMap.put("days", dispensary.getDays());
		paramMap.put("timing", dispensary.getTiming());
		paramMap.put("visit", dispensary.getVisit());
		paramMap.put("phone", dispensary.getPhone());
		paramMap.put("address", dispensary.getAddress());
		paramMap.put("pin", dispensary.getPin());
		namedParameterJdbcTemplate.update(INSERT_DISPENSARY, paramMap);
	}

	@Override
	public void updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub

	}
	
	RowMapper<Dispensary> rowMapperDispensary = new RowMapper<Dispensary>(){
		public Dispensary mapRow(ResultSet rs, int rowNum) throws SQLException {
			Dispensary dispensary = new Dispensary();
			dispensary.setRegistration(rs.getString("registration"));
			dispensary.setTiming(rs.getString("timing"));
			dispensary.setVisit(rs.getInt("visit"));
			
			dispensary.setPhone(rs.getString("phone"));
			dispensary.setAddress(rs.getString("address"));
			dispensary.setPin(rs.getInt("pin"));
            return dispensary;
        }
	};

}
