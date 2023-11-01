package com.ext.apiservice.service;

import com.ext.apiservice.service.modal.CardInfoRequest;
import com.ext.apiservice.service.modal.Response;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ExternalService {
	public Response processCard(CardInfoRequest cardInfoRequest, HttpServletRequest request,
			HttpServletResponse response);

	public Response processRefund(CardInfoRequest cardInfoRequest, HttpServletRequest request,
			HttpServletResponse response);

}
