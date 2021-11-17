package com.spacedev.board.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

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
	
	// get contact
	@PostMapping("/contact")
	@ResponseBody
	public Contact getOne(@RequestBody Contact param) {	//JSON으로 받은 param parsing 
		
		Contact data = repository.findTop1ByEmailOrderByWdateDesc(param.getEmail());
		
		if(data == null) {
			service.insert(param);
			return null;
		} else {
			System.out.println("==============현재 날짜 확인 ===========");
			System.out.println(data.getWdate());
			return data;
		}
	}
	
	// inser DB
	@PostMapping("/contact/insert")
	@ResponseBody
	public void save(@RequestBody Contact param) {
		service.insert(param);
	}
}