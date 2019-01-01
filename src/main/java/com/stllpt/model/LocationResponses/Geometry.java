
package com.stllpt.model.LocationResponses;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geometry implements Serializable
{

    @SerializedName("bounds")
    @Expose
    @JsonProperty
    private Bounds bounds;
    @SerializedName("location")
    @Expose
    @JsonProperty
    private Location location;
    @SerializedName("location_type")
    @Expose
    @JsonProperty
    private String location_type;
    @SerializedName("viewport")
    @Expose
    @JsonProperty
    private Viewport viewport;
    private final static long serialVersionUID = 2955094319717583047L;

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }

}
