package com.ext.apiservice.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ext.apiservice.service.ExternalService;
import com.ext.apiservice.service.modal.AutheriseTxnRequestDTO;
import com.ext.apiservice.service.modal.AutheriseTxnResponseDTO;
import com.ext.apiservice.service.modal.BillingAddress;
import com.ext.apiservice.service.modal.Card;
import com.ext.apiservice.service.modal.CardIdentifierResponse;
import com.ext.apiservice.service.modal.CardInfoRequest;
import com.ext.apiservice.service.modal.CredentialType;
import com.ext.apiservice.service.modal.Data;
import com.ext.apiservice.service.modal.MerchantKeyRequest;
import com.ext.apiservice.service.modal.MerchantKeyResponse;
import com.ext.apiservice.service.modal.PaymentMethod;
import com.ext.apiservice.service.modal.RefundRequestDTO;
import com.ext.apiservice.service.modal.RefundTxnRequestDTO;
import com.ext.apiservice.service.modal.RefundTxnResponseDTO;
import com.ext.apiservice.service.modal.Response;
import com.ext.apiservice.service.modal.ShippingDetails;
import com.ext.apiservice.service.modal.StrongCustomerAuthentication;
import com.ext.apiservice.service.modal.TransactionRequestDTO;
import com.ext.apiservice.service.modal.TransactionResponseDTO;
import com.ext.apiservice.utils.CommonUtils;
import com.ext.apiservice.utils.Constants;
import com.ext.apiservice.utils.HttpConnector;
import com.ext.apiservice.utils.HttpConnectorResponse;
import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ExternalServiceImpl implements ExternalService {

	private static final Log LOG = LogFactory.getLog(ExternalService.class);

	@Autowired
	HttpConnector httpConnector;

	@Override
	public Response processCard(CardInfoRequest cardInfoRequest, HttpServletRequest request,
			HttpServletResponse response) {
		Gson gson = new Gson();
		Properties prop = new Properties();
		Response finalRes = new Response();
		finalRes.setErrorCode("500");
		finalRes.setDetails("Autherisation failed.");
		finalRes.setErrorMsg("FAILED");
		InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
		try {
			prop.load(stream);
			String sessionKeyApiUrl = prop.getProperty("sessionKeyApiUrl");
			String cardIdentifierApiUrl = prop.getProperty("cardIdentifierApiUrl");
			String cardTxnApiUrl = prop.getProperty("cardTxnApiUrl");

			MerchantKeyRequest merchantKeyRequest = new MerchantKeyRequest();
			Map<String, String> header = new HashMap<>();
			header.put("Content-Type", "application/json");
			String auth = "Basic " + prop.getProperty("authToken");
			header.put("Authorization", auth);
			merchantKeyRequest.setVendorName(prop.getProperty("vendorType"));
			String body = CommonUtils.dumpObject(merchantKeyRequest);
			HttpConnectorResponse httpResponse = httpConnector.postApiCall(sessionKeyApiUrl, header, body);
			if (HttpConnector.isResponseExist(httpResponse)) {
				MerchantKeyResponse res = gson.fromJson(httpResponse.getResponse(), MerchantKeyResponse.class);
				String reqBody = CommonUtils.dumpObject(cardInfoRequest);
				auth = "Bearer " + res.getMerchantSessionKey();
				header.put("Authorization", auth);
				HttpConnectorResponse cardResp = httpConnector.postApiCall(cardIdentifierApiUrl, header, reqBody);
				if (HttpConnector.isResponseExist(httpResponse)) {
					CardIdentifierResponse cardRes = gson.fromJson(cardResp.getResponse(),
							CardIdentifierResponse.class);
					TransactionRequestDTO transactionRequestDTO = getTransactionRequestDTO(prop, res, cardRes,
							cardInfoRequest, Constants.TXN_TYPE_AUTHENTICATE);
					String txnReqBody = CommonUtils.dumpObject(transactionRequestDTO);
					auth = "Basic " + prop.getProperty("authToken");
					header.put("Authorization", auth);
					HttpConnectorResponse txnResp = httpConnector.postApiCall(cardTxnApiUrl, header, txnReqBody);
					if (HttpConnector.isResponseExist(txnResp)) {
						TransactionResponseDTO txnRes = gson.fromJson(txnResp.getResponse(),
								TransactionResponseDTO.class);
						AutheriseTxnRequestDTO autheriseTxnRequestDTO = new AutheriseTxnRequestDTO();
						autheriseTxnRequestDTO.setAmount(Integer.parseInt(cardInfoRequest.getAmount()));
						autheriseTxnRequestDTO.setApplyAvsCvcCheck(prop.getProperty("applyAvsCvcCheck"));
						autheriseTxnRequestDTO.setCv2(cardInfoRequest.getCardDetails().getSecurityCode());
						autheriseTxnRequestDTO.setDescription(prop.getProperty("authDescription"));
						autheriseTxnRequestDTO.setReferenceTransactionId(txnRes.getTransactionId());
						autheriseTxnRequestDTO.setTransactionType(Constants.TXN_TYPE_AUTHORISE);
						autheriseTxnRequestDTO.setVendorTxCode(UUID.randomUUID().toString());
						String authReqBody = CommonUtils.dumpObject(autheriseTxnRequestDTO);
						HttpConnectorResponse authResp = httpConnector.postApiCall(cardTxnApiUrl, header, authReqBody);
						if (HttpConnector.isResponseExist(authResp)) {
							AutheriseTxnResponseDTO authRes = gson.fromJson(authResp.getResponse(),
									AutheriseTxnResponseDTO.class);
							finalRes.setDetails("Autherised successfully");
							finalRes.setErrorCode("200");
							finalRes.setErrorMsg("SUCCESS");
							Data data = new Data();
							data.setTransactionId(authRes.getTransactionId());
							data.setTransactionType(authRes.getTransactionType());
							finalRes.setData(data);
							return finalRes;
						}
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return finalRes;
	}

	@Override
	public Response processRefund(RefundRequestDTO refundRequestDTO, HttpServletRequest request,
			HttpServletResponse response) {
		Gson gson = new Gson();
		Properties prop = new Properties();
		Response finalRes = new Response();
		finalRes.setErrorCode("500");
		finalRes.setDetails("Refund failed.");
		finalRes.setErrorMsg("FAILED");
		InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties");
		try {
			prop.load(stream);
			String cardTxnApiUrl = prop.getProperty("cardTxnApiUrl");
			Map<String, String> header = new HashMap<>();
			header.put("Content-Type", "application/json");
			String auth = "Basic " + prop.getProperty("authToken");
			header.put("Authorization", auth);
			RefundTxnRequestDTO refundTxnRequestDTO = new RefundTxnRequestDTO();
			refundTxnRequestDTO.setAmount(Integer.parseInt(refundRequestDTO.getAmount()));
			refundTxnRequestDTO.setDescription(refundRequestDTO.getDesc());
			refundTxnRequestDTO.setReferenceTransactionId(refundRequestDTO.getTransactionId());
			refundTxnRequestDTO.setTransactionType(Constants.TXN_TYPE_REFUND);
			refundTxnRequestDTO.setVendorTxCode(UUID.randomUUID().toString());
			String authReqBody = CommonUtils.dumpObject(refundTxnRequestDTO);
			HttpConnectorResponse authResp = httpConnector.postApiCall(cardTxnApiUrl, header, authReqBody);
			if (HttpConnector.isResponseExist(authResp)) {
				RefundTxnResponseDTO authRes = gson.fromJson(authResp.getResponse(), RefundTxnResponseDTO.class);
				finalRes.setDetails("Refund completed successfully.");
				finalRes.setErrorCode("200");
				finalRes.setErrorMsg("SUCCESS");
				return finalRes;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return finalRes;
	}

	private TransactionRequestDTO getTransactionRequestDTO(Properties prop, MerchantKeyResponse res,
			CardIdentifierResponse cardRes, CardInfoRequest cardInfoRequest, String txnType) {
		Gson gson = new Gson();

		TransactionRequestDTO transactionRequestDTO = new TransactionRequestDTO();
		transactionRequestDTO.setTransactionType(txnType);
		transactionRequestDTO.setVendorName(prop.getProperty("vendorType"));
		PaymentMethod paymentMethod = new PaymentMethod();
		Card card = getCard(res, cardRes);
		paymentMethod.setCard(card);
		transactionRequestDTO.setPaymentMethod(paymentMethod);
		transactionRequestDTO.setVendorTxCode(UUID.randomUUID().toString());
		ShippingDetails shippingDetails = gson.fromJson(
				"{\r\n" + "        \"recipientFirstName\": \"shippingFname\",\r\n"
						+ "        \"recipientLastName\": \"shippingLName\",\r\n"
						+ "        \"shippingAddress1\": \"shipaddress1\",\r\n"
						+ "        \"shippingCity\": \"shipcity\",\r\n" + "        \"shippingCountry\": \"GB\",\r\n"
						+ "        \"shippingAddress2\": \"shipaddress2\",\r\n"
						+ "        \"shippingAddress3\": \"shipaddress3\",\r\n"
						+ "        \"shippingPostalCode\": \"PC1 8DE\"\r\n" + "  \r\n" + "    }",
				ShippingDetails.class);
		transactionRequestDTO.setShippingDetails(shippingDetails);

		StrongCustomerAuthentication strongCustomerAuthentication = gson.fromJson("{\r\n"
				+ "        \"notificationURL\": \"https://www.opayolabs.co.uk/OpayoDemo/pi_callback\",\r\n"
				+ "        \"browserIP\": \"158.175.142.169\",\r\n"
				+ "        \"browserAcceptHeader\": \"text/html, application/json\",\r\n"
				+ "        \"browserJavascriptEnabled\": true,\r\n"
				+ "        \"browserUserAgent\": \"Mozilla/5.0 (Macintosh; Intel Mac OS X 10.14; rv:67.0) Gecko/20100101 Firefox/67.0\",\r\n"
				+ "        \"challengeWindowSize\": \"Small\",\r\n"
				+ "        \"transType\": \"GoodsAndServicePurchase\",\r\n"
				+ "        \"browserLanguage\": \"en-GB\",\r\n" + "        \"browserJavaEnabled\": true,\r\n"
				+ "        \"browserColorDepth\": \"16\",\r\n" + "        \"browserScreenHeight\": \"768\",\r\n"
				+ "        \"browserScreenWidth\": \"1200\",\r\n" + "        \"browserTZ\": \"+300\",\r\n"
				+ "        \"acctID\": \"Additional information\",\r\n"
				+ "        \"threeDSExemptionIndicator\": \"LowValue\",\r\n"
				+ "        \"website\": \"https://www.opayolabs.co.uk\"\r\n" + "    }",
				StrongCustomerAuthentication.class);
		transactionRequestDTO.setStrongCustomerAuthentication(strongCustomerAuthentication);

		BillingAddress billingAddress = gson.fromJson("{\r\n" + "        \"address1\": \"address1\",\r\n"
				+ "        \"city\": \"billingcity\",\r\n" + "        \"country\": \"GB\",\r\n"
				+ "        \"address2\": \"addressline2\",\r\n" + "        \"address3\": \"addressline3\",\r\n"
				+ "        \"postalCode\": \"PC1 8DE\"\r\n" + "        \r\n" + "    }", BillingAddress.class);
		transactionRequestDTO.setBillingAddress(billingAddress);

		CredentialType credentialType = gson
				.fromJson("{\r\n" + "        \"cofUsage\": \"First\",\r\n" + "        \"initiatedType\": \"CIT\",\r\n"
						+ "        \"mitType\": \"Unscheduled\"\r\n" + "\r\n" + "    }", CredentialType.class);
		transactionRequestDTO.setCredentialType(credentialType);
		transactionRequestDTO.setAmount(Integer.parseInt(cardInfoRequest.getAmount()));
		transactionRequestDTO.setCurrency(prop.getProperty("currency"));
		transactionRequestDTO.setDescription(prop.getProperty("description"));
		transactionRequestDTO.setSettlementReferenceText(prop.getProperty("settlementReferenceText"));
		transactionRequestDTO.setCustomerFirstName(prop.getProperty("customerFirstName"));
		transactionRequestDTO.setCustomerLastName(prop.getProperty("customerLastName"));
		transactionRequestDTO.setCustomerEmail(prop.getProperty("customerEmail"));
		transactionRequestDTO.setCustomerMobilePhone(prop.getProperty("customerMobilePhone"));
		transactionRequestDTO.setCustomerPhone(prop.getProperty("customerPhone"));
		transactionRequestDTO.setCustomerWorkPhone(prop.getProperty("customerPhone"));
		transactionRequestDTO.setEntryMethod(prop.getProperty("entryMethod"));
		transactionRequestDTO.setGiftAid(Boolean.parseBoolean(prop.getProperty("giftAid")));
		transactionRequestDTO.setApply3DSecure(prop.getProperty("apply3DSecure"));
		transactionRequestDTO.setApplyAvsCvcCheck(prop.getProperty("applyAvsCvcCheck"));
		transactionRequestDTO.setReferrerId(UUID.randomUUID().toString());
		return transactionRequestDTO;
	}

	private Card getCard(MerchantKeyResponse res, CardIdentifierResponse cardRes) {
		Card card = new Card();
		card.setMerchantSessionKey(res.getMerchantSessionKey());
		card.setCardIdentifier(cardRes.getCardIdentifier());
		card.setReusable(false);
		card.setSave(true);
		return card;
	}

}
