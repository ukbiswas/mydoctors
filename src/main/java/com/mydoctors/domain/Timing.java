package com.mydoctors.domain;

/**
 * @author ukb
 *
 */
public class Timing {
	private String[] days;
	private String[] hours;
	private Double visit;
	private Address address;
	public String[] getDays() {
		return days;
	}
	public void setDays(String[] days) {
		this.days = days;
	}
	
	public String[] getHours() {
		return hours;
	}
	public void setHours(String[] hours) {
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
