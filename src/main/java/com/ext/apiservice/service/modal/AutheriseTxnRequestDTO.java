package com.ext.apiservice.service.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AutheriseTxnRequestDTO {
	@JsonProperty("transactionType")
	private String transactionType;
	@JsonProperty("referenceTransactionId")
	private String referenceTransactionId;
	@JsonProperty("vendorTxCode")
	private String vendorTxCode;
	@JsonProperty("amount")
	private Double amount;
	@JsonProperty("description")
	private String description;
	@JsonProperty("applyAvsCvcCheck")
	private String applyAvsCvcCheck;
	@JsonProperty("cv2")
	private String cv2;

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
	public Double getAmount() {
		return amount;
	}

	@JsonProperty("amount")
	public void setAmount(Double amount) {
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

	@JsonProperty("applyAvsCvcCheck")
	public String getApplyAvsCvcCheck() {
		return applyAvsCvcCheck;
	}

	@JsonProperty("applyAvsCvcCheck")
	public void setApplyAvsCvcCheck(String applyAvsCvcCheck) {
		this.applyAvsCvcCheck = applyAvsCvcCheck;
	}

	@JsonProperty("cv2")
	public String getCv2() {
		return cv2;
	}

	@JsonProperty("cv2")
	public void setCv2(String cv2) {
		this.cv2 = cv2;
	}
}
