package com.billing.pojos.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.billing.pojos.Item;
import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "userId", "totalAmount", "paymentReceived" })
public class InvoiceResponse {

	public InvoiceResponse(String userId, int totalAmount, Boolean paymentReceived) {
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.paymentReceived = paymentReceived;
 
    }

	@JsonProperty("userId")
	private String userId;
	
	@JsonProperty("totalAmount")
	private Integer totalAmount;
	
	@JsonProperty("paymentReceived")
	private Boolean paymentReceived;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("userId")
	public String getUserId() {
		return userId;
	}

	@JsonProperty("userId")
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@JsonProperty("totalAmount")
	public Integer getTotalAmount() {
		return totalAmount;
	}

	@JsonProperty("totalAmount")
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
	
	@JsonProperty("paymentReceived")
	public Boolean getPaymentReceived() {
		return paymentReceived;
	}

	@JsonProperty("paymentReceived")
	public void setPaymentReceived(Boolean paymentReceived) {
		this.paymentReceived = paymentReceived;
	}


}
