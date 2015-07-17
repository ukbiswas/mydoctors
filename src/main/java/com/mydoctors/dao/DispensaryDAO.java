package com.mydoctors.dao;


import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mydoctors.domain.Dispensary;
import com.mydoctors.domain.Doctor;

public interface DispensaryDAO {
	public List<Dispensary> getDispensary(String registration) throws DataAccessException;
	public void addDispensary(Dispensary dispensary) throws DataAccessException;
	public void updateDoctor(Doctor doctor);
}
