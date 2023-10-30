package com.ext.apiservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ext.apiservice.service.modal.CardInfoRequest;
import com.ext.apiservice.service.modal.MerchantKeyRequest;
import com.ext.apiservice.service.modal.MerchantKeyResponse;
import com.ext.apiservice.utils.CommonUtils;
import com.ext.apiservice.utils.HttpConnector;
import com.ext.apiservice.utils.HttpConnectorResponse;
import com.google.gson.Gson;

@RestController
public class ExternalAPIController {

	@Autowired
	HttpConnector httpConnector;

	@RequestMapping(value = "/processCard", method = RequestMethod.POST)
	public String processCard() {
		return "login";
	}

	@RequestMapping(value = "/processCard1", method = RequestMethod.GET)
	public String processCard1(@RequestBody CardInfoRequest cardInfoRequest) {
		Gson gson = new Gson();
		MerchantKeyRequest merchantKeyRequest = new MerchantKeyRequest();
		Map<String, String> header = new HashMap<>();
		header.put("Content-Type", "application/json");
		String body = CommonUtils.dumpObject(merchantKeyRequest);
		HttpConnectorResponse response = httpConnector
				.postApiCall("https://pi-test.sagepay.com/api/v1/merchant-session-keys", header, body);

		MerchantKeyResponse res = gson.fromJson(response.getResponse(), MerchantKeyResponse.class);
		System.out.println(res.getExpiry());
		System.out.println(res.getMerchantSessionKey());

		String reqBody = CommonUtils.dumpObject(cardInfoRequest);

		String auth = "Bearer " + res.getMerchantSessionKey();

		String cardIdentifierUrl = "https://pi-test.sagepay.com/api/v1/card-identifiers";
		Map<String, String> headerMap = new HashMap<>();
		header.put("Content-Type", "application/json");
		header.put("Authorization", auth);

		HttpConnectorResponse cardResp = null;
		cardResp = httpConnector.postApiCall(cardIdentifierUrl, headerMap, reqBody);

		return cardResp.getResponse();

	}

}
