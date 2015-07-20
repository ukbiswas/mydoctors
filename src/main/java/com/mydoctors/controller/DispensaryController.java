package com.mydoctors.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mydoctors.common.MessageConstant;
import com.mydoctors.common.exceptions.BusinessException;
import com.mydoctors.domain.Dispensary;
import com.mydoctors.domain.Message;
import com.mydoctors.services.DispensaryService;


@Controller
@RequestMapping(value="/dispensary")
public class DispensaryController {

	@Autowired
	DispensaryService dispensaryService;
		
	/**
	 * {
		"registration" : "007",
		"days": "MON-FRI",
		"timing" : "10AM-7PM",
		"visit": 150,		
		"phone": "9775213029",
		"address": "Burdwan",
		"pin": "713141"
		}
	 * @param dispensaryData
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public Message saveDispensary(@RequestBody String dispensaryData) {
		Message message = new Message();
		System.out.println("in controller : doctorData="+dispensaryData);
		try {
			dispensaryService.saveDispensary(dispensaryData);
			message.setStatus(HttpStatus.OK.value());
			message.setMessage("Dispensary added successfully");
		} catch (BusinessException businessException) {
			message.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			message.setMessage(businessException.getMessage());
		} catch (Exception exception) {
			message.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			message.setMessage(MessageConstant.ERROR_500_MESSAGE);
		}
		System.out.println("message="+message.toString());
		return message;
	}
	/**
	 * {
	 	"registration" : "007",
	 	"name":"uttam kumar biswas",		
		"degree": "MBBS(cal)",
		"specialization": "skin",
		"phone": "9775213029",
		"email": "uttamkumarbiswas@gmail.com",
		"city" : "burdwan",
	    "address" : "Burdwan, Khosbagan",
		"description": "blah blah"
	   }
	 * @param doctorData
	 * @return
	 */
	@RequestMapping(value = "/{registration}", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Dispensary> getDispensary(@PathVariable String registration) {
		System.out.println("in DispensaryController : getting dispensary with registration="+registration);
		List<Dispensary> dispensaries = null;
		try{
			dispensaries = dispensaryService.getDispensary(registration);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return dispensaries;
	}

}
