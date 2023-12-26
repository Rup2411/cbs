package com.busybox.cbs.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.busybox.cbs.model.enums.NamePrefix;

@RestController
@RequestMapping("cbs/demo")
public class HelloWorldController {

	@GetMapping("hello")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping("NamePrefix")
	public List<NamePrefix> name() {
		return NamePrefix.listOfNamePrefix();
	}
}
