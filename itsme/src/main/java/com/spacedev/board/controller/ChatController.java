package com.spacedev.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class ChatController {

	@GetMapping("/chat")
	public void getChat(HttpServletRequest request) {
		System.out.println("sessionId 값 출력 : " + request.getSession().getAttribute("sessionId"));
		

		log.info("@ChatController, getChat()");
	}
}
