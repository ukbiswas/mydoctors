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
	@RequestMapping(value="/{registration}", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Doctor getDoctor(@PathVariable String registration) {
		System.out.println("in controller : getting doctor with registration="+registration);
		Doctor doctor = null;
		try{
			doctor = doctorService.getDoctor(registration);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return doctor;
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
	@RequestMapping(value="/search/{searchString}", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public List<Doctor> searchDoctors(@PathVariable String searchString) {
		System.out.println("in controller : searchString="+searchString);
		List<Doctor> doctors = null;
		try {
			doctors = doctorService.searchDoctors(searchString);
		} catch (BusinessException businessException) {
			businessException.printStackTrace();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return doctors;
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
			businessException.printStackTrace();
			message.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			message.setMessage(businessException.getMessage());
		} catch (Exception exception) {
			exception.printStackTrace();
			message.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			message.setMessage(MessageConstant.ERROR_500_MESSAGE);
		}
		System.out.println("message="+message.toString());
		return message;
	}

}
