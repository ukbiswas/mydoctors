package com.mydoctors.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mydoctors.dao.DoctorDAO;
import com.mydoctors.domain.Doctor;
import com.mydoctors.services.DoctorService;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	DoctorDAO doctorDAO;

	public void saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		doctorDAO.saveDoctor(doctor);
	}

	public void updateUser() {
		// TODO Auto-generated method stub

	}

	public void deleteUser() {
		// TODO Auto-generated method stub

	}

	public Doctor getDoctor(String id) {
		// TODO Auto-generated method stub
		System.out.println("in service :"+id);
		return doctorDAO.getDoctor(id);
	}

}
