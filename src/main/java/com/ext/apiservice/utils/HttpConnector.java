package com.ext.apiservice.utils;

import java.util.Map;
import java.util.Optional;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import io.micrometer.common.util.StringUtils;

@Component
public class HttpConnector {

	public HttpConnectorResponse getApiCall(String serviceUrl, Map<String, String> headeMap) {
		HttpConnectorResponse httpConnectorResponse = new HttpConnectorResponse();
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			HttpGet request = new HttpGet(serviceUrl);
			request.addHeader("content-type", "application/json");
			if (!CollectionUtils.isEmpty(headeMap)) {
				headeMap.forEach((k, v) -> {
					request.addHeader(k, v);
				});
			}
			CloseableHttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			EntityUtils.consume(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return httpConnectorResponse;
	}

	public HttpConnectorResponse postApiCall(String serviceUrl, Map<String, String> headeMap, String body) {
		HttpConnectorResponse httpConnectorResponse = new HttpConnectorResponse();
		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
			HttpPost request = new HttpPost(serviceUrl);
			StringEntity requestEntity = new StringEntity(body);
			request.setEntity(requestEntity);
			if (!CollectionUtils.isEmpty(headeMap)) {
				headeMap.forEach((k, v) -> {
					request.addHeader(k, v);
				});
			}
			CloseableHttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			String responseObj = EntityUtils.toString(entity, Consts.UTF_8);
			httpConnectorResponse.setResponse(responseObj);
			httpConnectorResponse.setErrorCode(response.getStatusLine().getStatusCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return httpConnectorResponse;
	}

	public static boolean isResponseExist(HttpConnectorResponse httpConnectorResponse) {
		return Optional.ofNullable(httpConnectorResponse)
				.filter(p -> p.getErrorCode() == 200 && StringUtils.isNotBlank(p.getResponse())).map(p -> true)
				.orElse(false);
	}
}
