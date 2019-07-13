package com.jms.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jms.spring.endpoint.MessageSender;

@RestController
public class MyFirstController {
	
	@Autowired
	private MessageSender sender;
	
	
	@RequestMapping("/test")
	public String test() {
		return "test";
	}
	
	@RequestMapping("/produce")
	public void producer() {
		sender.send();
	}
}
