package com.ext.apiservice.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
		Properties prop = new Properties();

		InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
		try {
			prop.load(stream);
			String sessionKeyApiUrl = prop.getProperty("sessionKeyApiUrl");
			String cardIdentifierApiUrl = prop.getProperty("cardIdentifierApiUrl");
			String cardTxnApiUrl = prop.getProperty("cardTxnApiUrl");

			MerchantKeyRequest merchantKeyRequest = new MerchantKeyRequest();
			Map<String, String> header = new HashMap<>();
			header.put("Content-Type", "application/json");
			String auth = "Basic " + prop.getProperty("authToken");
			header.put("Authorization", auth);
			merchantKeyRequest.setVendorName(prop.getProperty("vendorType"));
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
						HttpConnectorResponse authResp = httpConnector.postApiCall(cardTxnApiUrl, headerMap,
								authReqBody);
						if (HttpConnector.isResponseExist(authResp)) {

						}
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}

}
