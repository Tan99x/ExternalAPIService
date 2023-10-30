package com.ext.apiservice.service;

import com.ext.apiservice.service.modal.CardInfoRequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ExternalService {
	public String processCard(CardInfoRequest cardInfoRequest, HttpServletRequest request,
			HttpServletResponse response);

}
