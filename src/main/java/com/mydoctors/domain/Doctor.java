package com.mydoctors.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * by ukb
 */
@Document(collection = "doctors")
public class Doctor {
	@Id
	private String id;
	private String registration;
	private String name;
	private String phone;
	private String email;
	private String[] degree;
	private String description;
	private String specialization;
	private Timing timing;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String[] getDegree() {
		return degree;
	}
	public void setDegree(String[] degree) {
		this.degree = degree;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public Timing getTiming() {
		return timing;
	}
	public void setTiming(Timing timing) {
		this.timing = timing;
	}
}
