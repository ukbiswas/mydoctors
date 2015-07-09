package com.mydoctors.domain;

/**
 * @author ukb
 *
 */
public class Message {
	private String message;
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
