package com.mydoctors.services.impl;

import java.util.List;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.mydoctors.common.MessageConstant;
import com.mydoctors.common.exceptions.BusinessException;
import com.mydoctors.dao.DispensaryDAO;
import com.mydoctors.domain.Dispensary;
import com.mydoctors.services.DispensaryService;


@Service("dispensaryService")
public class DispensaryServiceImpl implements DispensaryService {
	
	@Autowired
	DispensaryDAO dispensaryDAO;

	@Override
	public void saveDispensary(String dispensaryData) throws BusinessException, Exception {
		if(!StringUtils.hasText(dispensaryData)) {
			throw new BusinessException(MessageConstant.NULL_EMPTY_DATA);
		}
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Dispensary dispensary = objectMapper.readValue(dispensaryData, Dispensary.class);
			dispensaryDAO.addDispensary(dispensary);
			System.out.println("dispensaryData="+dispensaryData);
		} catch (JsonMappingException jmEx) {
			throw new BusinessException(MessageConstant.DATA_MALFORMED);
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException(MessageConstant.FAILED_TO_CREATE);
		}
	}

	@Override
	public void updateUser() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Dispensary> getDispensary(String registration) throws BusinessException, Exception {
		// TODO Auto-generated method stub
		return dispensaryDAO.getDispensary(registration);
	}

}
