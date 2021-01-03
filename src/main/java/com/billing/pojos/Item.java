package com.billing.pojos;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "itemName",
    "itemPrice"
})
public class Item {

	   @JsonProperty("itemName")
	    private String itemName;
	    @JsonProperty("itemPrice")
	    private Integer itemPrice;
	    @JsonIgnore
	    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	    @JsonProperty("itemName")
	    public String getItemName() {
	        return itemName;
	    }

	    @JsonProperty("itemName")
	    public void setItemName(String itemName) {
	        this.itemName = itemName;
	    }

	    @JsonProperty("itemPrice")
	    public Integer getItemPrice() {
	        return itemPrice;
	    }

	    @JsonProperty("itemPrice")
	    public void setItemPrice(Integer itemPrice) {
	        this.itemPrice = itemPrice;
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
