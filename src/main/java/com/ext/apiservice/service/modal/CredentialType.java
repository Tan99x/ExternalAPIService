package com.ext.apiservice.service.modal;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CredentialType {
	@JsonProperty("cofUsage")
	private String cofUsage;
	@JsonProperty("initiatedType")
	private String initiatedType;
	@JsonProperty("mitType")
	private String mitType;

	@JsonProperty("cofUsage")
	public String getCofUsage() {
		return cofUsage;
	}

	@JsonProperty("cofUsage")
	public void setCofUsage(String cofUsage) {
		this.cofUsage = cofUsage;
	}

	@JsonProperty("initiatedType")
	public String getInitiatedType() {
		return initiatedType;
	}

	@JsonProperty("initiatedType")
	public void setInitiatedType(String initiatedType) {
		this.initiatedType = initiatedType;
	}

	@JsonProperty("mitType")
	public String getMitType() {
		return mitType;
	}

	@JsonProperty("mitType")
	public void setMitType(String mitType) {
		this.mitType = mitType;
	}
}
