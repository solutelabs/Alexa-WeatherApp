
package com.stllpt.model.LocationResponses;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddressComponent implements Serializable
{

    @SerializedName("long_name")
    @Expose
    @JsonProperty
    private String long_name;
    @SerializedName("short_name")
    @Expose
    @JsonProperty
    private String short_name;
    @SerializedName("types")
    @Expose
    @JsonProperty
    private List<String> types = null;
    private final static long serialVersionUID = -2076768554128067080L;

    public String getLong_name() {
        return long_name;
    }

    public void setLong_name(String long_name) {
        this.long_name = long_name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

}
