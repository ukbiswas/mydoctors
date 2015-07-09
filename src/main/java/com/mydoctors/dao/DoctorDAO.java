package com.mydoctors.dao;


import java.util.List;

import com.mydoctors.domain.Doctor;

public interface DoctorDAO {
	public Doctor getDoctor(String id);
	public List<Doctor> getAllDoctor();
	public void saveDoctor(Doctor doctor);
	public void updateDoctor(Doctor doctor);
}
