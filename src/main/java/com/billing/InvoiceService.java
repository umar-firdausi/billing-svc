package com.billing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.billing.pojos.Invoice;
import com.billing.pojos.Payment;
import com.billing.pojos.response.InvoiceResponse;
import com.billing.pojos.response.PaymentResponse;
import com.fasterxml.jackson.databind.util.JSONPObject;

@Service
public class InvoiceService {

	private List<Invoice> invoiceList = new ArrayList<>(Arrays.asList());
	
	@Value("${payment-svc.hostname}")
	private String serverHost;
	
	@Value("${payment-svc.port}")
	private String serverPort;

	public void addInvoice(Invoice invoice) {

		invoiceList.add(invoice);
	}

	public InvoiceResponse calcTotal(Invoice invoice) {

		addInvoice(invoice);

		int total = 0;

		String userId = invoiceList.get(0).getUserId();

		String payment;

		boolean paymentStatus;

		for (int iterator = 0; iterator < invoiceList.get(0).getItems().size(); iterator++) {

			total += invoiceList.get(0).getItems().get(iterator).getItemPrice();

		}
		
		paymentStatus = verifyPayment(new Payment(invoiceList.get(0).getPaymentMethod())).getStatus();

		clearInvoice(invoiceList);

		return new InvoiceResponse(userId, total, paymentStatus);
	}

	public void clearInvoice(List<Invoice> invoiceList) {

		invoiceList.clear();

	}

	public PaymentResponse verifyPayment(Payment paymentObj) {
		
		final String uri = serverHost + ":" + serverPort + "/api/payment-processing/verify-payment";
		
		System.out.println("Calling Payment Svc with ->" + uri);

		RestTemplate restTemplate = new RestTemplate();

		PaymentResponse result = restTemplate.postForObject(uri, paymentObj, PaymentResponse.class);

		System.out.println(result);

		return result;

	}

}
