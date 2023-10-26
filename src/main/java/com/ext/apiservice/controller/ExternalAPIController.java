package com.ext.apiservice.controller;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ext.apiservice.service.modal.MerchantKeyResponse;
import com.google.gson.Gson;

@RestController
public class ExternalAPIController {

	@RequestMapping(value = "/processCard", method = RequestMethod.POST)
	public String processCard() {
		return "login";
	}

	@RequestMapping(value = "/processCard1", method = RequestMethod.GET)
	public String processCard1() {
		HttpRequest.BodyPublisher merchantCardRequest = HttpRequest.BodyPublishers
				.ofString("{\r\n" + "    \"vendorName\": \"sandbox\"\r\n" + "}");
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://pi-test.sagepay.com/api/v1/merchant-session-keys" + ""))
				.header("Content-Type", "application/json")
				.header("Authorization",
						"Basic aEpZeHN3N0hMYmo0MGNCOHVkRVM4Q0RSRkxodUo4RzU0TzZyRHBVWHZFNmhZRHJyaWE6bzJpSFNyRnliWU1acG1XT1FNdWhzWFA1MlY0ZkJ0cHVTRHNocktEU1dzQlkxT2lONmh3ZDlLYjEyejRqNVVzNXU=")

				.method("POST", merchantCardRequest).build();

		HttpResponse<String> response = null;
		Gson gson = new Gson();
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		MerchantKeyResponse res = gson.fromJson(response.body(), MerchantKeyResponse.class);
		System.out.println(res.getExpiry());
		System.out.println(res.getMerchantSessionKey());

		HttpRequest.BodyPublisher cardIdentifierRequest = HttpRequest.BodyPublishers
				.ofString("{\r\n" + "    \"cardDetails\": {\r\n" + "        \"cardholderName\": \"S Squarepants\",\r\n"
						+ "        \"cardNumber\": \"4929000000006\",\r\n" + "        \"expiryDate\": \"1130\",\r\n"
						+ "        \"securityCode\": \"123\"\r\n" + "    }\r\n" + "}");

		String auth = "Bearer " + res.getMerchantSessionKey();

		HttpRequest cardIdentifierReq = HttpRequest.newBuilder()
				.uri(URI.create("https://pi-test.sagepay.com/api/v1/card-identifiers" + ""))
				.header("Content-Type", "application/json").header("Authorization", auth)
				.method("POST", cardIdentifierRequest).build();

		HttpResponse<String> response1 = null;
		try {
			response1 = HttpClient.newHttpClient().send(cardIdentifierReq, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return response1.body();

	}

}
