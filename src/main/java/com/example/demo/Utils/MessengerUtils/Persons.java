package com.example.demo.Utils.MessengerUtils;

public class Persons {
	private long id;
	private String name;
	private String username;
	private String phoneNumber;

	public Persons(long id, String name, String username, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.phoneNumber = phoneNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
