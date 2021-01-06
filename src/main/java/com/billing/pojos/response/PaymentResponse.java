package com.billing.pojos.response;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "status" })
public class PaymentResponse {

	public PaymentResponse() {

	}

	public PaymentResponse(Boolean status) {
		this.status = status;
	}

	@JsonProperty("status")
	private Boolean status;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("status")
	public Boolean getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(Boolean status) {
		this.status = status;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
