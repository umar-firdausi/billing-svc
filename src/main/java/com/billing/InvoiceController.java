package com.billing;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.billing.pojos.Invoice;
import com.billing.pojos.response.InvoiceResponse;

@RestController
public class InvoiceController {

	@Autowired
	private InvoiceService invoiceService;
	
	
	@RequestMapping(method = RequestMethod.POST,value="/api/bill-processing/generate-invoice")
	public InvoiceResponse calculateTotalAmount(@RequestBody Invoice invoice) {
		return invoiceService.calcTotal(invoice);
		
	}
}
