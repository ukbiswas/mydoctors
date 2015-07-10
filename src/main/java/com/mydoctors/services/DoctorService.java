package com.mydoctors.services;


import java.util.List;

import com.mydoctors.common.exceptions.BusinessException;
import com.mydoctors.domain.Doctor;

public interface DoctorService {
	public void saveDoctor(String doctorData) throws BusinessException, Exception;
	public void updateUser();
	public void deleteUser();
	public List<Doctor> getDoctor(String Id);
	public List<Doctor> getAllDoctor();
}
