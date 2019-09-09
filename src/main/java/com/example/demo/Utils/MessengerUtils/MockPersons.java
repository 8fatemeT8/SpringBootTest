package com.example.demo.Utils.MessengerUtils;

import java.util.ArrayList;

public class MockPersons {
	private ArrayList<Persons> persons = new ArrayList<>();

	public MockPersons() {
		this.persons.add(new Persons(0,"Hamed","hamedfarahi1","09114399223"));
		this.persons.add(new Persons(1,"Amir","amir1","09364548452"));
		this.persons.add(new Persons(2,"Farhad","farhad1","09375856694"));
		this.persons.add(new Persons(3,"Shayan","shayan1","09125487756"));
		this.persons.add(new Persons(4,"Raha","raha1","0919541233"));
		this.persons.add(new Persons(5,"Fateme","fateme8","09214548896"));
		this.persons.add(new Persons(6	,"Mehdi","mehdi9","09123236654"));
	}

	public ArrayList<Persons> getPersons() {
		return persons;
	}
}
