package com.mydoctors.dao;


import java.util.List;

import org.json.JSONObject;
import org.springframework.dao.DataAccessException;

import com.mydoctors.domain.Dispensary;
import com.mydoctors.domain.Doctor;

public interface DoctorDAO {
	public List<Doctor> searchDoctors(String searchString) throws DataAccessException;
	public Doctor getDoctor(String registration) throws DataAccessException;
	public void saveDoctor(Doctor doctor);
	public void addDispensary(Dispensary dispensary);
	public void updateDoctor(Doctor doctor);
}
