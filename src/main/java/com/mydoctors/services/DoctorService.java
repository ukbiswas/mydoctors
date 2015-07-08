package com.mydoctors.services;


import com.mydoctors.domain.Doctor;

public interface DoctorService {
	public void saveDoctor(Doctor doctor);
	public void updateUser();
	public void deleteUser();
	public Doctor getDoctor(String Id);
}
