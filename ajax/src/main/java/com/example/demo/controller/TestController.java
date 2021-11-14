package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	@ResponseBody
	public String ajaxTest() {
		
		return "ajax 통신 성공!";
	}
}
