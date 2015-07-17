package com.mydoctors.services;


import java.util.List;

import com.mydoctors.common.exceptions.BusinessException;
import com.mydoctors.domain.Dispensary;

public interface DispensaryService {
	public void saveDispensary(String dispensaryData) throws BusinessException, Exception;
	public void updateUser();
	public void deleteUser();
	/**
	 * This method returns list of dispensary for a particular registration number of a doctor.
	 * @param registration
	 * @return a list of dispensary. a sample dispensary is like :
	 *       {
				"registration" : "008",
				"days": "SAT-SUN",
				"timing" : "10AM-7PM",
				"visit": 450,		
				"phone": "9775213029",
				"address": "howrah",
				"pin": 700081
			 }
	 * @throws BusinessException
	 * @throws Exception
	 */
	public List<Dispensary> getDispensary(String registration) throws BusinessException, Exception;
}
