package com.ext.apiservice.service.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentMethod {

	@JsonProperty("card")
	private Card card;

	@JsonProperty("card")
	public Card getCard() {
		return card;
	}

	@JsonProperty("card")
	public void setCard(Card card) {
		this.card = card;
	}
}
