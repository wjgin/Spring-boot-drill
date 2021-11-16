package com.spacedev.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spacedev.board.entity.Contact;
import com.spacedev.board.repository.ContactRepository;
import com.spacedev.board.service.ContactService;


@RestController
public class ContactController {
	
	@Autowired
	ContactRepository repository;
	
	@Autowired
	ContactService service;
	
	@PostMapping("/contact")
	@ResponseBody
	public Contact getContact(@RequestBody Contact param) {	//JSON으로 받은 param parsing 
		
//		System.out.println(param);
		
		Contact data = repository.findTop1ByEmailOrderByWdateDesc(param.getEmail());
		
		if(data == null) {
			// need insert
			return null;
		} else {
			return data;
		}
		
	}
	
}