package com.ext.apiservice.service.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RefundTxnRequestDTO {
	@JsonProperty("transactionType")
	private String transactionType;
	@JsonProperty("referenceTransactionId")
	private String referenceTransactionId;
	@JsonProperty("vendorTxCode")
	private String vendorTxCode;
	@JsonProperty("amount")
	private Integer amount;
	@JsonProperty("description")
	private String description;

	@JsonProperty("transactionType")
	public String getTransactionType() {
		return transactionType;
	}

	@JsonProperty("transactionType")
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@JsonProperty("referenceTransactionId")
	public String getReferenceTransactionId() {
		return referenceTransactionId;
	}

	@JsonProperty("referenceTransactionId")
	public void setReferenceTransactionId(String referenceTransactionId) {
		this.referenceTransactionId = referenceTransactionId;
	}

	@JsonProperty("vendorTxCode")
	public String getVendorTxCode() {
		return vendorTxCode;
	}

	@JsonProperty("vendorTxCode")
	public void setVendorTxCode(String vendorTxCode) {
		this.vendorTxCode = vendorTxCode;
	}

	@JsonProperty("amount")
	public Integer getAmount() {
		return amount;
	}

	@JsonProperty("amount")
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

}
