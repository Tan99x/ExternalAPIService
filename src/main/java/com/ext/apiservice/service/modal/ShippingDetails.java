package com.ext.apiservice.service.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShippingDetails {

	@JsonProperty("recipientFirstName")
	private String recipientFirstName;
	@JsonProperty("recipientLastName")
	private String recipientLastName;
	@JsonProperty("shippingAddress1")
	private String shippingAddress1;
	@JsonProperty("shippingCity")
	private String shippingCity;
	@JsonProperty("shippingCountry")
	private String shippingCountry;
	@JsonProperty("shippingAddress2")
	private String shippingAddress2;
	@JsonProperty("shippingAddress3")
	private String shippingAddress3;
	@JsonProperty("shippingPostalCode")
	private String shippingPostalCode;

	@JsonProperty("recipientFirstName")
	public String getRecipientFirstName() {
		return recipientFirstName;
	}

	@JsonProperty("recipientFirstName")
	public void setRecipientFirstName(String recipientFirstName) {
		this.recipientFirstName = recipientFirstName;
	}

	@JsonProperty("recipientLastName")
	public String getRecipientLastName() {
		return recipientLastName;
	}

	@JsonProperty("recipientLastName")
	public void setRecipientLastName(String recipientLastName) {
		this.recipientLastName = recipientLastName;
	}

	@JsonProperty("shippingAddress1")
	public String getShippingAddress1() {
		return shippingAddress1;
	}

	@JsonProperty("shippingAddress1")
	public void setShippingAddress1(String shippingAddress1) {
		this.shippingAddress1 = shippingAddress1;
	}

	@JsonProperty("shippingCity")
	public String getShippingCity() {
		return shippingCity;
	}

	@JsonProperty("shippingCity")
	public void setShippingCity(String shippingCity) {
		this.shippingCity = shippingCity;
	}

	@JsonProperty("shippingCountry")
	public String getShippingCountry() {
		return shippingCountry;
	}

	@JsonProperty("shippingCountry")
	public void setShippingCountry(String shippingCountry) {
		this.shippingCountry = shippingCountry;
	}

	@JsonProperty("shippingAddress2")
	public String getShippingAddress2() {
		return shippingAddress2;
	}

	@JsonProperty("shippingAddress2")
	public void setShippingAddress2(String shippingAddress2) {
		this.shippingAddress2 = shippingAddress2;
	}

	@JsonProperty("shippingAddress3")
	public String getShippingAddress3() {
		return shippingAddress3;
	}

	@JsonProperty("shippingAddress3")
	public void setShippingAddress3(String shippingAddress3) {
		this.shippingAddress3 = shippingAddress3;
	}

	@JsonProperty("shippingPostalCode")
	public String getShippingPostalCode() {
		return shippingPostalCode;
	}

	@JsonProperty("shippingPostalCode")
	public void setShippingPostalCode(String shippingPostalCode) {
		this.shippingPostalCode = shippingPostalCode;
	}

}
