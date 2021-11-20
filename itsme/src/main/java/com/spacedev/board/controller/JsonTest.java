package com.spacedev.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonTest {
	
	@GetMapping("/ttt")
	@ResponseBody
	
	public Map<String, Object> test() {
		Map<String, Object> map = new HashMap<>();
		
		map.put("ttt", "zzzzz");
		map.put("asdasd", "Gggg");
		
		return map;
	}
}
