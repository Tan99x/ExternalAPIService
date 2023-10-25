package com.ext.apiservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalAPIController {

	@RequestMapping(value = "/processCard", method = RequestMethod.POST)
	public String processCard() {
		return "login";
	}

}
