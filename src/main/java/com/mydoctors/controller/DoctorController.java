package com.mydoctors.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mongodb.util.JSON;
import com.mydoctors.domain.Doctor;
import com.mydoctors.domain.Message;
import com.mydoctors.services.DoctorService;


@Controller
@RequestMapping(value="/doctor")
public class DoctorController {
	
	
	@Autowired
	DoctorService doctorService;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Doctor getDoctor(@PathVariable String id) {
		System.out.println("in controller : id="+id);
		Doctor doctor = doctorService.getDoctor(id);
		System.out.println("user="+doctor);
		return doctor;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public Message saveDoctor(@RequestBody String doctorData) {
		System.out.println("in controller : doctorData="+doctorData);
		Doctor doctor = (Doctor) JSON.parse(doctorData);
		System.out.println("doctor="+doctor);
		doctorService.saveDoctor(doctor);
		
		Message message = new Message();
		message.setMessage("Doctor added successfully");
		return message;
	}

}
