package com.mydoctors.services;


import java.util.List;

import com.mydoctors.common.exceptions.BusinessException;
import com.mydoctors.domain.Doctor;

public interface DoctorService {
	public void saveDoctor(String doctorData) throws BusinessException, Exception;
	public void addDispensary(String doctorData) throws BusinessException, Exception;
	public void updateUser();
	public void deleteUser();
	public List<Doctor> searchDoctors(String searchString) throws BusinessException, Exception;
	public Doctor getDoctor(String registration) throws Exception;
}
