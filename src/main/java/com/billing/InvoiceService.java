package com.billing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.billing.pojos.Invoice;
import com.billing.pojos.response.InvoiceResponse;
import com.fasterxml.jackson.databind.util.JSONPObject;

@Service
public class InvoiceService {

	private List<Invoice> invoiceList = new ArrayList<>(Arrays.asList());

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

		clearInvoice(invoiceList);

		return new InvoiceResponse(userId, total);
	}

	public void clearInvoice(List<Invoice> invoiceList) {

		invoiceList.clear();

	}

	public Invoice verifyPayment(Invoice invoice) {

		final String uri = "http://localhost:8282/api/payment-processing/verify-payment";

		RestTemplate restTemplate = new RestTemplate();

		Invoice result = restTemplate.postForObject(uri, invoice.getPaymentMethod(), Invoice.class);

		System.out.println(result);

		return result;

	}

}
