package com.ext.apiservice.service.modal;

public class AutheriseTxnResponseDTO {
	public String statusCode;
	public String statusDetail;
	public String transactionId;
	public String transactionType;
	public String acsTransId;
	public String dsTransId;
	public String status;
	public String cReq;

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

	public void getTransactionType(String v) {
		this.transactionType = transactionType;
	}

	public String getAcsTransId() {
		return acsTransId;
	}

	public void setAcsTransId(String acsTransId) {
		this.acsTransId = acsTransId;
	}

	public String getDsTransId() {
		return dsTransId;
	}

	public void setDsTransId(String dsTransId) {
		this.dsTransId = dsTransId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getcReq() {
		return cReq;
	}

	public void setcReq(String cReq) {
		this.cReq = cReq;
	}

}
