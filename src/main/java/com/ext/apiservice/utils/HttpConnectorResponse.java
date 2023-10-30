package com.ext.apiservice.utils;

import java.io.Serializable;

public class HttpConnectorResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3085014000443208821L;
	private int errorCode;
	private String response;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
	
}
