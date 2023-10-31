package com.ext.apiservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ext.apiservice.service.ExternalService;
import com.ext.apiservice.service.modal.CardInfoRequest;
import com.ext.apiservice.service.modal.Response;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ExternalAPIController {

	@Autowired
	ExternalService externalService;

	@RequestMapping(value = "/processCard", method = RequestMethod.POST)
	public ResponseEntity<Response> processCard(@RequestBody CardInfoRequest cardInfoRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Response resp = externalService.processCard(cardInfoRequest, request, response);
		return new ResponseEntity<Response>(resp, HttpStatus.OK);
	}

}
