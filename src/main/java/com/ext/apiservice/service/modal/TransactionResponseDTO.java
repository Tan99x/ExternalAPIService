package com.ext.apiservice.service.modal;

public class TransactionResponseDTO {
	public String statusCode;
	public String statusDetail;
	public String transactionId;
	public String transactionType;
	public int retrievalReference;
	public String bankResponseCode;
	public String bankAuthorisationCode;
	public PaymentMethod paymentMethod;
	public Amount amount;
	public String currency;
	public String settlementReferenceText;
	public String status;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDetail() {
		return statusDetail;
	}

	public void setStatusDetail(String statusDetail) {
		this.statusDetail = statusDetail;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getRetrievalReference() {
		return retrievalReference;
	}

	public void setRetrievalReference(int retrievalReference) {
		this.retrievalReference = retrievalReference;
	}

	public String getBankResponseCode() {
		return bankResponseCode;
	}

	public void setBankResponseCode(String bankResponseCode) {
		this.bankResponseCode = bankResponseCode;
	}

	public String getBankAuthorisationCode() {
		return bankAuthorisationCode;
	}

	public void setBankAuthorisationCode(String bankAuthorisationCode) {
		this.bankAuthorisationCode = bankAuthorisationCode;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getSettlementReferenceText() {
		return settlementReferenceText;
	}

	public void setSettlementReferenceText(String settlementReferenceText) {
		this.settlementReferenceText = settlementReferenceText;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
