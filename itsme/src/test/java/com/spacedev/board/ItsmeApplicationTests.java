package com.spacedev.board;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
		System.out.println("========= 현재시간 출력 =========");
		System.out.println(LocalDateTime.now());
		LocalDateTime time = LocalDateTime.now();
		String result = time.format(DateTimeFormatter.ofPattern( "E, hh:mm a"));
		System.out.println(result);
	}

}
