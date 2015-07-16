package com.mydoctors.controller;


import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import com.mydoctors.common.MessageConstant;
import com.mydoctors.common.exceptions.BusinessException;
import com.mydoctors.domain.Doctor;
import com.mydoctors.domain.Message;
import com.mydoctors.services.DoctorService;


@Controller
@RequestMapping(value="/doctor")
public class DoctorController {
	
	
	@Autowired
	DoctorService doctorService;
	
	/**
	 * to get all the doctors one need to call /api/doctor url.
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Doctor> getAllDoctor() {
		System.out.println("in controller : getting all doctors");
		List<Doctor> allDoctor = doctorService.getAllDoctor();
		System.out.println("doctors="+allDoctor);
		return allDoctor;
	}

	/**
	 * to get all the doctors one need to call /api/doctor/registration url.
	 * sample json :
	  {
		"name":"ukbiswas",
		"city" : "Burdwan",
		"specialization": "skin"
	  }
	 * @param registration
	 * @return
	 */
	@RequestMapping(value="/{searchJson}",method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Doctor> getDoctor(@PathVariable String searchJson) {
		System.out.println("in controller : id="+searchJson);
		List<Doctor> doctors = doctorService.getDoctor(searchJson);
		return doctors;
	}
	
	/**
	 * {
		"registration" : "007",
		"days": "MON-FRI",
		"timing" : "10AM-7PM",
		"visit": 150,		
		"phone": "9775213029",
		"address": "Burdwan",
		"pin": "713141",
		
		}
	 * @param dispensaryData
	 * @return
	 */
	@RequestMapping(value="/dispensary", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public Message addDispensary(@RequestBody String dispensaryData) {
		Message message = new Message();
		System.out.println("in controller : doctorData="+dispensaryData);
		try {
			doctorService.addDispensary(dispensaryData);
			message.setStatus(HttpStatus.OK.value());
			message.setMessage("Dispensary added successfully");
		} catch (BusinessException businessException) {
			message.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			message.setMessage(businessException.getMessage());
		} catch (Exception exception) {
			message.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			message.setMessage(MessageConstant.ERROR_500_MESSAGE);
		}
		return message;
	}
	/**
	 * {
	 	"registration" : "007",
	 	"name":"uttam kumar biswas",		
		"degree": "MBBS(cal)",
		"phone": "9775213029",
		"email": "uttamkumarbiswas@gmail.com",
		"city" : "burdwan",
		"specialization": "skin",
		"description": "blah blah",
		}
	 * @param doctorData
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public Message saveDoctor(@RequestBody String doctorData) {
		Message message = new Message();
		System.out.println("in controller : doctorData="+doctorData);
		try {
			doctorService.saveDoctor(doctorData);			
			message.setStatus(HttpStatus.OK.value());
			message.setMessage("Doctor added successfully");
		} catch (BusinessException businessException) {
			message.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			message.setMessage(businessException.getMessage());
		} catch (Exception exception) {
			message.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			message.setMessage(MessageConstant.ERROR_500_MESSAGE);
		}
		return message;
	}

}
