package com.mydoctors.dao;

import com.mydoctors.domain.Doctor;

public interface DoctorDAO {
	public Doctor getDoctor(String id);
	public void saveDoctor(Doctor doctor);
	public void updateDoctor(Doctor doctor);
}
