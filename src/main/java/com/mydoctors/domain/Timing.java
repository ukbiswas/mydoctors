package com.mydoctors.domain;

import java.util.List;

/**
 * @author ukb
 *
 */
public class Timing {
	private List<String> days;
	private List<String> hours;
	private Double visit;
	private Address address;
	
	public List<String> getDays() {
		return days;
	}
	public void setDays(List<String> days) {
		this.days = days;
	}
	public List<String> getHours() {
		return hours;
	}
	public void setHours(List<String> hours) {
		this.hours = hours;
	}
	public Double getVisit() {
		return visit;
	}
	public void setVisit(Double visit) {
		this.visit = visit;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
