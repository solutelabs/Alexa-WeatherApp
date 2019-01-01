
package com.stllpt.model.LocationResponses;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result implements Serializable
{

    @SerializedName("address_components")
    @Expose
    @JsonProperty
    private List<AddressComponent> address_components = null;
    @SerializedName("formatted_address")
    @Expose
    @JsonProperty
    private String formatted_address;
    @SerializedName("geometry")
    @Expose
    @JsonProperty
    private Geometry geometry;
    @SerializedName("place_id")
    @Expose
    @JsonProperty
    private String place_id;
    @SerializedName("types")
    @Expose
    @JsonProperty
    private List<String> types = null;
    private final static long serialVersionUID = 4043343285704333825L;

    public List<AddressComponent> getAddressComponents() {
        return address_components;
    }

    public void setAddressComponents(List<AddressComponent> addressComponents) {
        this.address_components = addressComponents;
    }

    public String getFormattedAddress() {
        return formatted_address;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formatted_address = formattedAddress;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

}
