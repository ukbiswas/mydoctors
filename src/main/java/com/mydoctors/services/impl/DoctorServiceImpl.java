package com.mydoctors.services.impl;

import java.util.List;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mongodb.DBObject;
import com.mydoctors.common.MessageConstant;
import com.mydoctors.common.exceptions.BusinessException;
import com.mydoctors.dao.DoctorDAO;
import com.mydoctors.domain.Doctor;
import com.mydoctors.services.DoctorService;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	DoctorDAO doctorDAO;
	
	@Override
	public void saveDoctor(String doctorData) throws BusinessException, Exception {
		if(!StringUtils.hasText(doctorData)) {
			throw new BusinessException(MessageConstant.NULL_EMPTY_DATA);
		}
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Doctor doctor = objectMapper.readValue(doctorData, Doctor.class);
			doctorDAO.saveDoctor(doctor);
			System.out.println("docdotJson="+doctor.getName());
		} catch (JsonMappingException jmEx) {
			throw new BusinessException(MessageConstant.DATA_MALFORMED);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(MessageConstant.FAILED_TO_CREATE);
		}
	}

	public void updateUser() {
		// TODO Auto-generated method stub

	}

	public void deleteUser() {
		// TODO Auto-generated method stub

	}
	
	public List<Doctor> getDoctor(String searchData) {
		// TODO Auto-generated method stub
		System.out.println("in service searchData=:"+searchData);
		JSONObject searchJson = new JSONObject(searchData);
		return doctorDAO.getDoctor(searchJson);
	}
	
	public List<Doctor> getAllDoctor() {
		return doctorDAO.getAllDoctor();
	}

}
