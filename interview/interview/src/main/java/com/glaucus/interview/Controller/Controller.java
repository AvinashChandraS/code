package com.glaucus.interview.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glaucus.interview.Service.ServiceImpl;

@RestController
@RequestMapping("/service")
public class Controller {
	@Autowired
	private ServiceImpl service;
	
	@GetMapping("/increase")
	public String Increase() {
		long res=service.increase();
		return "value :"+res;
	}

}
