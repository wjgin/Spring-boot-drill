package com.spacedev.board.service;


import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spacedev.board.entity.Contact;
import com.spacedev.board.repository.ContactRepository;



@Service
public class ContactService {
	
	@Autowired
	ContactRepository repository;
	
	public void insert(Contact param) {
		// Date now = Date.valueOf(LocalDate.now());	// 현재시간 (Date type)
		// Timestamp now = Timestamp.valueOf(LocalDateTime.now());	// 현재시간 (Timestamp type add h,m,s)
		param.setWdate(LocalDateTime.now());	// entity에 현재간 저장 
		
		repository.save(param);	//db저장 
	}
}
