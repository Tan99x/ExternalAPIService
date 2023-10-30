package com.ext.apiservice.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ext.apiservice.service.ExternalService;
import com.ext.apiservice.service.modal.AutheriseTxnRequestDTO;
import com.ext.apiservice.service.modal.CardInfoRequest;
import com.ext.apiservice.service.modal.MerchantKeyRequest;
import com.ext.apiservice.service.modal.MerchantKeyResponse;
import com.ext.apiservice.service.modal.TransactionRequestDTO;
import com.ext.apiservice.utils.CommonUtils;
import com.ext.apiservice.utils.HttpConnector;
import com.ext.apiservice.utils.HttpConnectorResponse;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ExternalServiceImpl implements ExternalService {

	@Autowired
	HttpConnector httpConnector;

	@Override
	public String processCard(CardInfoRequest cardInfoRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Gson gson = new Gson();
		String sessionKeyApiUrl = "https://pi-test.sagepay.com/api/v1/merchant-session-keys";
		String cardIdentifierApiUrl = "https://pi-test.sagepay.com/api/v1/card-identifiers";
		String cardTxnApiUrl = "https://pi-test.sagepay.com/api/v1/card-identifiers";
		String authorizeTxnApiUrl = "https://pi-test.sagepay.com/api/v1/card-identifiers";

		MerchantKeyRequest merchantKeyRequest = new MerchantKeyRequest();
		Map<String, String> header = new HashMap<>();
		header.put("Content-Type", "application/json");
		String body = CommonUtils.dumpObject(merchantKeyRequest);
		HttpConnectorResponse httpResponse = httpConnector.postApiCall(sessionKeyApiUrl, header, body);
		if (HttpConnector.isResponseExist(httpResponse)) {
			MerchantKeyResponse res = gson.fromJson(httpResponse.getResponse(), MerchantKeyResponse.class);
			System.out.println(res.getExpiry());
			System.out.println(res.getMerchantSessionKey());

			String reqBody = CommonUtils.dumpObject(cardInfoRequest);

			String auth = "Bearer " + res.getMerchantSessionKey();

			Map<String, String> headerMap = new HashMap<>();
			header.put("Content-Type", "application/json");
			header.put("Authorization", auth);

			HttpConnectorResponse cardResp = httpConnector.postApiCall(cardIdentifierApiUrl, headerMap, reqBody);
			if (HttpConnector.isResponseExist(httpResponse)) {
				cardResp.getResponse();

				TransactionRequestDTO transactionRequestDTO = new TransactionRequestDTO();
				String txnReqBody = CommonUtils.dumpObject(transactionRequestDTO);
				HttpConnectorResponse txnResp = httpConnector.postApiCall(cardTxnApiUrl, headerMap, txnReqBody);
				if (HttpConnector.isResponseExist(txnResp)) {
					AutheriseTxnRequestDTO autheriseTxnRequestDTO = new AutheriseTxnRequestDTO();
					String authReqBody = CommonUtils.dumpObject(autheriseTxnRequestDTO);
					HttpConnectorResponse authResp = httpConnector.postApiCall(authorizeTxnApiUrl, headerMap,
							authReqBody);
					if (HttpConnector.isResponseExist(authResp)) {

					}
				}
			}
		}
		return null;
	}

}
