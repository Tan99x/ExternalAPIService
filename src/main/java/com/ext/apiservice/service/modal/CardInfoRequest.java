/**
 * 
 */
package com.ext.apiservice.service.modal;

/**
 * 
 */
public class CardInfoRequest {

	private CardDetails cardDetails;

	private String amount;

	public CardDetails getCardDetails() {
		return cardDetails;
	}

	public void setCardDetails(CardDetails cardDetails) {
		this.cardDetails = cardDetails;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

}
