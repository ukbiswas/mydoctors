package com.mydoctors.dao;


import java.util.List;

import org.json.JSONObject;

import com.mydoctors.domain.Doctor;

public interface DoctorDAO {
	public List<Doctor> getDoctor(JSONObject searchJson);
	public List<Doctor> getAllDoctor();
	public void saveDoctor(Doctor doctor);
	public void updateDoctor(Doctor doctor);
}
