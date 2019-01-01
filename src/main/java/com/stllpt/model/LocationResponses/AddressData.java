
package com.stllpt.model.LocationResponses;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddressData implements Serializable
{

    @SerializedName("results")
    @Expose
    @JsonProperty
    private List<Result> results = null;
    @SerializedName("status")
    @Expose
    @JsonProperty
    private String status;
    private final static long serialVersionUID = -7034482392440626969L;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
