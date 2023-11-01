package com.ext.apiservice.service.modal;

public class RefundTxnResponseDTO {

	private String statusCode;
	private String statusDetail;
	private String transactionId;
	private String transactionType;
	private float retrievalReference;
	private String bankAuthorisationCode;
	private PaymentMethod PaymentMethodObject;
	private Amount AmountObject;
	private String currency;
	private String settlementReferenceText;
	private String status;

	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the statusDetail
	 */
	public String getStatusDetail() {
		return statusDetail;
	}

	/**
	 * @param statusDetail the statusDetail to set
	 */
	public void setStatusDetail(String statusDetail) {
		this.statusDetail = statusDetail;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the retrievalReference
	 */
	public float getRetrievalReference() {
		return retrievalReference;
	}

	/**
	 * @param retrievalReference the retrievalReference to set
	 */
	public void setRetrievalReference(float retrievalReference) {
		this.retrievalReference = retrievalReference;
	}

	/**
	 * @return the bankAuthorisationCode
	 */
	public String getBankAuthorisationCode() {
		return bankAuthorisationCode;
	}

	/**
	 * @param bankAuthorisationCode the bankAuthorisationCode to set
	 */
	public void setBankAuthorisationCode(String bankAuthorisationCode) {
		this.bankAuthorisationCode = bankAuthorisationCode;
	}

	/**
	 * @return the paymentMethodObject
	 */
	public PaymentMethod getPaymentMethodObject() {
		return PaymentMethodObject;
	}

	/**
	 * @param paymentMethodObject the paymentMethodObject to set
	 */
	public void setPaymentMethodObject(PaymentMethod paymentMethodObject) {
		PaymentMethodObject = paymentMethodObject;
	}

	/**
	 * @return the amountObject
	 */
	public Amount getAmountObject() {
		return AmountObject;
	}

	/**
	 * @param amountObject the amountObject to set
	 */
	public void setAmountObject(Amount amountObject) {
		AmountObject = amountObject;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the settlementReferenceText
	 */
	public String getSettlementReferenceText() {
		return settlementReferenceText;
	}

	/**
	 * @param settlementReferenceText the settlementReferenceText to set
	 */
	public void setSettlementReferenceText(String settlementReferenceText) {
		this.settlementReferenceText = settlementReferenceText;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
