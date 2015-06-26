package com.poolmycar.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ukb
 * 
 */
@Document(collection = "cars")
public class Car {
	@Id
	private String id;
	private String	number;
	private String	model;
	private int		seattingCapacity;
	private User	ownerName;
	private String	description;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getSeattingCapacity() {
		return seattingCapacity;
	}
	public void setSeattingCapacity(int seattingCapacity) {
		this.seattingCapacity = seattingCapacity;
	}
	public User getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(User ownerName) {
		this.ownerName = ownerName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
