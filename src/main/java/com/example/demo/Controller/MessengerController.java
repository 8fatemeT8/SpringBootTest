package com.example.demo.Controller;


import com.example.demo.Utils.MessengerUtils.MockPersons;
import com.example.demo.Utils.MessengerUtils.Persons;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/api/msg/")
public class MessengerController {

	@RequestMapping(value = "persons", method = RequestMethod.GET)
	public ArrayList<Persons> getPersons(){
		return new MockPersons().getPersons();
	}
}

