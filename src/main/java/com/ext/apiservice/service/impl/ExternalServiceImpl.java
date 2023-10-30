package com.ext.apiservice.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ext.apiservice.configutation.ConfigProperties;
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
	
	@Autowired
	ConfigProperties configProperties;

	@Override
	public String processCard(CardInfoRequest cardInfoRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Gson gson = new Gson();
		String sessionKeyApiUrl = configProperties.getSessionKeyApiUrl();
		String cardIdentifierApiUrl = "https://pi-test.sagepay.com/api/v1/card-identifiers";
		String cardTxnApiUrl = "https://pi-test.sagepay.com/api/v1/card-identifiers";
		String authorizeTxnApiUrl = "https://pi-test.sagepay.com/api/v1/card-identifiers";

		MerchantKeyRequest merchantKeyRequest = new MerchantKeyRequest();
		Map<String, String> header = new HashMap<>();
		header.put("Content-Type", "application/json");
		String auth = "Bearer "
				+ "aEpZeHN3N0hMYmo0MGNCOHVkRVM4Q0RSRkxodUo4RzU0TzZyRHBVWHZFNmhZRHJyaWE6bzJpSFNyRnliWU1acG1XT1FNdWhzWFA1MlY0ZkJ0cHVTRHNocktEU1dzQlkxT2lONmh3ZDlLYjEyejRqNVVzNXU=";
		header.put("Authorization", auth);
		merchantKeyRequest.setVendorName("sandbox");
		String body = CommonUtils.dumpObject(merchantKeyRequest);
		HttpConnectorResponse httpResponse = httpConnector.postApiCall(sessionKeyApiUrl, header, body);
		if (HttpConnector.isResponseExist(httpResponse)) {
			MerchantKeyResponse res = gson.fromJson(httpResponse.getResponse(), MerchantKeyResponse.class);
			System.out.println(res.getExpiry());
			System.out.println(res.getMerchantSessionKey());

			String reqBody = CommonUtils.dumpObject(cardInfoRequest);

			auth = "Bearer " + res.getMerchantSessionKey();

			Map<String, String> headerMap = new HashMap<>();
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
