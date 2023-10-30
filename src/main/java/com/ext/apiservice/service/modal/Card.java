package com.ext.apiservice.service.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Card {

	@JsonProperty("merchantSessionKey")
	private String merchantSessionKey;
	@JsonProperty("cardIdentifier")
	private String cardIdentifier;
	@JsonProperty("reusable")
	private boolean reusable;
	@JsonProperty("save")
	private boolean save;

	@JsonProperty("merchantSessionKey")
	public String getMerchantSessionKey() {
		return merchantSessionKey;
	}

	@JsonProperty("merchantSessionKey")
	public void setMerchantSessionKey(String merchantSessionKey) {
		this.merchantSessionKey = merchantSessionKey;
	}

	@JsonProperty("cardIdentifier")
	public String getCardIdentifier() {
		return cardIdentifier;
	}

	@JsonProperty("cardIdentifier")
	public void setCardIdentifier(String cardIdentifier) {
		this.cardIdentifier = cardIdentifier;
	}

	public boolean isReusable() {
		return reusable;
	}

	public void setReusable(boolean reusable) {
		this.reusable = reusable;
	}

	public boolean isSave() {
		return save;
	}

	public void setSave(boolean save) {
		this.save = save;
	}
}
