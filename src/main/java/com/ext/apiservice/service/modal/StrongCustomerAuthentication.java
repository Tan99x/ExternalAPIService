package com.ext.apiservice.service.modal;

public class StrongCustomerAuthentication {

	private String notificationURL;
	private String browserIP;
	private String browserAcceptHeader;
	private boolean browserJavascriptEnabled;
	private String browserUserAgent;
	private String challengeWindowSize;
	private String transType;
	private String browserLanguage;
	private boolean browserJavaEnabled;
	private String browserColorDepth;
	private String browserScreenHeight;
	private String browserScreenWidth;
	private String browserTZ;
	private String acctID;
	private String website;
	private String threeDSExemptionIndicator;

	
	public String getNotificationURL() {
		return notificationURL;
	}

	public String getThreeDSExemptionIndicator() {
		return threeDSExemptionIndicator;
	}

	public void setThreeDSExemptionIndicator(String threeDSExemptionIndicator) {
		this.threeDSExemptionIndicator = threeDSExemptionIndicator;
	}

	public void setNotificationURL(String notificationURL) {
		this.notificationURL = notificationURL;
	}

	public String getBrowserIP() {
		return browserIP;
	}

	public void setBrowserIP(String browserIP) {
		this.browserIP = browserIP;
	}

	public String getBrowserAcceptHeader() {
		return browserAcceptHeader;
	}

	public void setBrowserAcceptHeader(String browserAcceptHeader) {
		this.browserAcceptHeader = browserAcceptHeader;
	}

	public boolean isBrowserJavascriptEnabled() {
		return browserJavascriptEnabled;
	}

	public void setBrowserJavascriptEnabled(boolean browserJavascriptEnabled) {
		this.browserJavascriptEnabled = browserJavascriptEnabled;
	}

	public String getBrowserUserAgent() {
		return browserUserAgent;
	}

	public void setBrowserUserAgent(String browserUserAgent) {
		this.browserUserAgent = browserUserAgent;
	}

	public String getChallengeWindowSize() {
		return challengeWindowSize;
	}

	public void setChallengeWindowSize(String challengeWindowSize) {
		this.challengeWindowSize = challengeWindowSize;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getBrowserLanguage() {
		return browserLanguage;
	}

	public void setBrowserLanguage(String browserLanguage) {
		this.browserLanguage = browserLanguage;
	}

	public boolean isBrowserJavaEnabled() {
		return browserJavaEnabled;
	}

	public void setBrowserJavaEnabled(boolean browserJavaEnabled) {
		this.browserJavaEnabled = browserJavaEnabled;
	}

	public String getBrowserColorDepth() {
		return browserColorDepth;
	}

	public void setBrowserColorDepth(String browserColorDepth) {
		this.browserColorDepth = browserColorDepth;
	}

	public String getBrowserScreenHeight() {
		return browserScreenHeight;
	}

	public void setBrowserScreenHeight(String browserScreenHeight) {
		this.browserScreenHeight = browserScreenHeight;
	}

	public String getBrowserScreenWidth() {
		return browserScreenWidth;
	}

	public void setBrowserScreenWidth(String browserScreenWidth) {
		this.browserScreenWidth = browserScreenWidth;
	}

	public String getBrowserTZ() {
		return browserTZ;
	}

	public void setBrowserTZ(String browserTZ) {
		this.browserTZ = browserTZ;
	}

	public String getAcctID() {
		return acctID;
	}

	public void setAcctID(String acctID) {
		this.acctID = acctID;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
