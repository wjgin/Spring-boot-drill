package com.spacedev.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spacedev.board.repository.ContactRepository;
import com.spacedev.board.service.ContactService;

@SpringBootTest
class ItsmeApplicationTests {

	@Autowired
	ContactRepository repository;
	
	@Autowired
	ContactService service;
	
	@Test
	void contextLoads() {
	}

}
