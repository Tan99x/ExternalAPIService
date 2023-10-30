package com.ext.apiservice.service.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionRequestDTO {
	@JsonProperty("transactionType")
	private String transactionType;
	@JsonProperty("vendorName")
	private String vendorName;
	@JsonProperty("paymentMethod")
	private PaymentMethod paymentMethod;
	@JsonProperty("vendorTxCode")
	private String vendorTxCode;
	@JsonProperty("amount")
	private Double amount;
	@JsonProperty("currency")
	private String currency;
	@JsonProperty("description")
	private String description;
	@JsonProperty("settlementReferenceText")
	private String settlementReferenceText;
	@JsonProperty("customerFirstName")
	private String customerFirstName;
	@JsonProperty("customerLastName")
	private String customerLastName;
	@JsonProperty("billingAddress")
	private BillingAddress billingAddress;
	@JsonProperty("entryMethod")
	private String entryMethod;
	@JsonProperty("giftAid")
	private Boolean giftAid;
	@JsonProperty("apply3DSecure")
	private String apply3DSecure;
	@JsonProperty("applyAvsCvcCheck")
	private String applyAvsCvcCheck;
	@JsonProperty("customerEmail")
	private String customerEmail;
	@JsonProperty("customerPhone")
	private String customerPhone;
	@JsonProperty("shippingDetails")
	private ShippingDetails shippingDetails;
	@JsonProperty("referrerId")
	private String referrerId;
	@JsonProperty("customerMobilePhone")
	private String customerMobilePhone;
	@JsonProperty("customerWorkPhone")
	private String customerWorkPhone;
	@JsonProperty("credentialType")
	private CredentialType credentialType;

	private StrongCustomerAuthentication strongCustomerAuthentication;

	@JsonProperty("transactionType")
	public String getTransactionType() {
		return transactionType;
	}

	@JsonProperty("transactionType")
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	@JsonProperty("vendorName")
	public String getVendorName() {
		return vendorName;
	}

	@JsonProperty("vendorName")
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	@JsonProperty("paymentMethod")
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	@JsonProperty("paymentMethod")
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
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

	@JsonProperty("currency")
	public String getCurrency() {
		return currency;
	}

	@JsonProperty("currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("settlementReferenceText")
	public String getSettlementReferenceText() {
		return settlementReferenceText;
	}

	@JsonProperty("settlementReferenceText")
	public void setSettlementReferenceText(String settlementReferenceText) {
		this.settlementReferenceText = settlementReferenceText;
	}

	@JsonProperty("customerFirstName")
	public String getCustomerFirstName() {
		return customerFirstName;
	}

	@JsonProperty("customerFirstName")
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}

	@JsonProperty("customerLastName")
	public String getCustomerLastName() {
		return customerLastName;
	}

	@JsonProperty("customerLastName")
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}

	@JsonProperty("billingAddress")
	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	@JsonProperty("billingAddress")
	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	@JsonProperty("entryMethod")
	public String getEntryMethod() {
		return entryMethod;
	}

	@JsonProperty("entryMethod")
	public void setEntryMethod(String entryMethod) {
		this.entryMethod = entryMethod;
	}

	@JsonProperty("giftAid")
	public Boolean getGiftAid() {
		return giftAid;
	}

	@JsonProperty("giftAid")
	public void setGiftAid(Boolean giftAid) {
		this.giftAid = giftAid;
	}

	@JsonProperty("apply3DSecure")
	public String getApply3DSecure() {
		return apply3DSecure;
	}

	@JsonProperty("apply3DSecure")
	public void setApply3DSecure(String apply3DSecure) {
		this.apply3DSecure = apply3DSecure;
	}

	@JsonProperty("applyAvsCvcCheck")
	public String getApplyAvsCvcCheck() {
		return applyAvsCvcCheck;
	}

	@JsonProperty("applyAvsCvcCheck")
	public void setApplyAvsCvcCheck(String applyAvsCvcCheck) {
		this.applyAvsCvcCheck = applyAvsCvcCheck;
	}

	@JsonProperty("customerEmail")
	public String getCustomerEmail() {
		return customerEmail;
	}

	@JsonProperty("customerEmail")
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	@JsonProperty("customerPhone")
	public String getCustomerPhone() {
		return customerPhone;
	}

	@JsonProperty("customerPhone")
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	@JsonProperty("shippingDetails")
	public ShippingDetails getShippingDetails() {
		return shippingDetails;
	}

	@JsonProperty("shippingDetails")
	public void setShippingDetails(ShippingDetails shippingDetails) {
		this.shippingDetails = shippingDetails;
	}

	@JsonProperty("referrerId")
	public String getReferrerId() {
		return referrerId;
	}

	@JsonProperty("referrerId")
	public void setReferrerId(String referrerId) {
		this.referrerId = referrerId;
	}

	@JsonProperty("customerMobilePhone")
	public String getCustomerMobilePhone() {
		return customerMobilePhone;
	}

	@JsonProperty("customerMobilePhone")
	public void setCustomerMobilePhone(String customerMobilePhone) {
		this.customerMobilePhone = customerMobilePhone;
	}

	@JsonProperty("customerWorkPhone")
	public String getCustomerWorkPhone() {
		return customerWorkPhone;
	}

	@JsonProperty("customerWorkPhone")
	public void setCustomerWorkPhone(String customerWorkPhone) {
		this.customerWorkPhone = customerWorkPhone;
	}

	@JsonProperty("credentialType")
	public CredentialType getCredentialType() {
		return credentialType;
	}

	@JsonProperty("credentialType")
	public void setCredentialType(CredentialType credentialType) {
		this.credentialType = credentialType;
	}

	public StrongCustomerAuthentication getStrongCustomerAuthentication() {
		return strongCustomerAuthentication;
	}

	public void setStrongCustomerAuthentication(StrongCustomerAuthentication strongCustomerAuthentication) {
		this.strongCustomerAuthentication = strongCustomerAuthentication;
	}

}
