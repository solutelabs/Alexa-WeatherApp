
package com.stllpt.model.WeatherReponses;

import java.io.Serializable;
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
    "time",
    "summary",
    "icon",
    "sunriseTime",
    "sunsetTime",
    "moonPhase",
    "precipIntensity",
    "precipIntensityMax",
    "precipIntensityMaxTime",
    "precipProbability",
    "precipType",
    "temperatureMin",
    "temperatureMinTime",
    "temperatureMax",
    "temperatureMaxTime",
    "apparentTemperatureMin",
    "apparentTemperatureMinTime",
    "apparentTemperatureMax",
    "apparentTemperatureMaxTime",
    "dewPoint",
    "humidityByDate",
    "windSpeedByDate",
    "windGust",
    "windGustTime",
    "windBearing",
    "cloudCover",
    "pressure",
    "ozone",
    "uvIndex",
    "uvIndexTime"
})
public class Datum_ implements Serializable
{

    @JsonProperty("time")
    private Integer time;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("sunriseTime")
    private Integer sunriseTime;
    @JsonProperty("sunsetTime")
    private Integer sunsetTime;
    @JsonProperty("moonPhase")
    private Double moonPhase;
    @JsonProperty("precipIntensity")
    private Integer precipIntensity;
    @JsonProperty("precipIntensityMax")
    private Integer precipIntensityMax;
    @JsonProperty("precipIntensityMaxTime")
    private Integer precipIntensityMaxTime;
    @JsonProperty("precipProbability")
    private Integer precipProbability;
    @JsonProperty("precipType")
    private String precipType;
    @JsonProperty("temperatureMin")
    private Double temperatureMin;
    @JsonProperty("temperatureMinTime")
    private Integer temperatureMinTime;
    @JsonProperty("temperatureMax")
    private Double temperatureMax;
    @JsonProperty("temperatureMaxTime")
    private Integer temperatureMaxTime;
    @JsonProperty("apparentTemperatureMin")
    private Double apparentTemperatureMin;
    @JsonProperty("apparentTemperatureMinTime")
    private Integer apparentTemperatureMinTime;
    @JsonProperty("apparentTemperatureMax")
    private Double apparentTemperatureMax;
    @JsonProperty("apparentTemperatureMaxTime")
    private Integer apparentTemperatureMaxTime;
    @JsonProperty("dewPoint")
    private Double dewPoint;
    @JsonProperty("humidityByDate")
    private Double humidity;
    @JsonProperty("windSpeedByDate")
    private Double windSpeed;
    @JsonProperty("windGust")
    private Double windGust;
    @JsonProperty("windGustTime")
    private Integer windGustTime;
    @JsonProperty("windBearing")
    private Integer windBearing;
    @JsonProperty("cloudCover")
    private Double cloudCover;
    @JsonProperty("pressure")
    private Double pressure;
    @JsonProperty("ozone")
    private Double ozone;
    @JsonProperty("uvIndex")
    private Integer uvIndex;
    @JsonProperty("uvIndexTime")
    private Integer uvIndexTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3590871596722804175L;

    @JsonProperty("time")
    public Integer getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(Integer time) {
        this.time = time;
    }

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("sunriseTime")
    public Integer getSunriseTime() {
        return sunriseTime;
    }

    @JsonProperty("sunriseTime")
    public void setSunriseTime(Integer sunriseTime) {
        this.sunriseTime = sunriseTime;
    }

    @JsonProperty("sunsetTime")
    public Integer getSunsetTime() {
        return sunsetTime;
    }

    @JsonProperty("sunsetTime")
    public void setSunsetTime(Integer sunsetTime) {
        this.sunsetTime = sunsetTime;
    }

    @JsonProperty("moonPhase")
    public Double getMoonPhase() {
        return moonPhase;
    }

    @JsonProperty("moonPhase")
    public void setMoonPhase(Double moonPhase) {
        this.moonPhase = moonPhase;
    }

    @JsonProperty("precipIntensity")
    public Integer getPrecipIntensity() {
        return precipIntensity;
    }

    @JsonProperty("precipIntensity")
    public void setPrecipIntensity(Integer precipIntensity) {
        this.precipIntensity = precipIntensity;
    }

    @JsonProperty("precipIntensityMax")
    public Integer getPrecipIntensityMax() {
        return precipIntensityMax;
    }

    @JsonProperty("precipIntensityMax")
    public void setPrecipIntensityMax(Integer precipIntensityMax) {
        this.precipIntensityMax = precipIntensityMax;
    }

    @JsonProperty("precipIntensityMaxTime")
    public Integer getPrecipIntensityMaxTime() {
        return precipIntensityMaxTime;
    }

    @JsonProperty("precipIntensityMaxTime")
    public void setPrecipIntensityMaxTime(Integer precipIntensityMaxTime) {
        this.precipIntensityMaxTime = precipIntensityMaxTime;
    }

    @JsonProperty("precipProbability")
    public Integer getPrecipProbability() {
        return precipProbability;
    }

    @JsonProperty("precipProbability")
    public void setPrecipProbability(Integer precipProbability) {
        this.precipProbability = precipProbability;
    }

    @JsonProperty("precipType")
    public String getPrecipType() {
        return precipType;
    }

    @JsonProperty("precipType")
    public void setPrecipType(String precipType) {
        this.precipType = precipType;
    }

    @JsonProperty("temperatureMin")
    public Double getTemperatureMin() {
        return temperatureMin;
    }

    @JsonProperty("temperatureMin")
    public void setTemperatureMin(Double temperatureMin) {
        this.temperatureMin = temperatureMin;
    }

    @JsonProperty("temperatureMinTime")
    public Integer getTemperatureMinTime() {
        return temperatureMinTime;
    }

    @JsonProperty("temperatureMinTime")
    public void setTemperatureMinTime(Integer temperatureMinTime) {
        this.temperatureMinTime = temperatureMinTime;
    }

    @JsonProperty("temperatureMax")
    public Double getTemperatureMax() {
        return temperatureMax;
    }

    @JsonProperty("temperatureMax")
    public void setTemperatureMax(Double temperatureMax) {
        this.temperatureMax = temperatureMax;
    }

    @JsonProperty("temperatureMaxTime")
    public Integer getTemperatureMaxTime() {
        return temperatureMaxTime;
    }

    @JsonProperty("temperatureMaxTime")
    public void setTemperatureMaxTime(Integer temperatureMaxTime) {
        this.temperatureMaxTime = temperatureMaxTime;
    }

    @JsonProperty("apparentTemperatureMin")
    public Double getApparentTemperatureMin() {
        return apparentTemperatureMin;
    }

    @JsonProperty("apparentTemperatureMin")
    public void setApparentTemperatureMin(Double apparentTemperatureMin) {
        this.apparentTemperatureMin = apparentTemperatureMin;
    }

    @JsonProperty("apparentTemperatureMinTime")
    public Integer getApparentTemperatureMinTime() {
        return apparentTemperatureMinTime;
    }

    @JsonProperty("apparentTemperatureMinTime")
    public void setApparentTemperatureMinTime(Integer apparentTemperatureMinTime) {
        this.apparentTemperatureMinTime = apparentTemperatureMinTime;
    }

    @JsonProperty("apparentTemperatureMax")
    public Double getApparentTemperatureMax() {
        return apparentTemperatureMax;
    }

    @JsonProperty("apparentTemperatureMax")
    public void setApparentTemperatureMax(Double apparentTemperatureMax) {
        this.apparentTemperatureMax = apparentTemperatureMax;
    }

    @JsonProperty("apparentTemperatureMaxTime")
    public Integer getApparentTemperatureMaxTime() {
        return apparentTemperatureMaxTime;
    }

    @JsonProperty("apparentTemperatureMaxTime")
    public void setApparentTemperatureMaxTime(Integer apparentTemperatureMaxTime) {
        this.apparentTemperatureMaxTime = apparentTemperatureMaxTime;
    }

    @JsonProperty("dewPoint")
    public Double getDewPoint() {
        return dewPoint;
    }

    @JsonProperty("dewPoint")
    public void setDewPoint(Double dewPoint) {
        this.dewPoint = dewPoint;
    }

    @JsonProperty("humidityByDate")
    public Double getHumidity() {
        return humidity;
    }

    @JsonProperty("humidityByDate")
    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    @JsonProperty("windSpeedByDate")
    public Double getWindSpeed() {
        return windSpeed;
    }

    @JsonProperty("windSpeedByDate")
    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    @JsonProperty("windGust")
    public Double getWindGust() {
        return windGust;
    }

    @JsonProperty("windGust")
    public void setWindGust(Double windGust) {
        this.windGust = windGust;
    }

    @JsonProperty("windGustTime")
    public Integer getWindGustTime() {
        return windGustTime;
    }

    @JsonProperty("windGustTime")
    public void setWindGustTime(Integer windGustTime) {
        this.windGustTime = windGustTime;
    }

    @JsonProperty("windBearing")
    public Integer getWindBearing() {
        return windBearing;
    }

    @JsonProperty("windBearing")
    public void setWindBearing(Integer windBearing) {
        this.windBearing = windBearing;
    }

    @JsonProperty("cloudCover")
    public Double getCloudCover() {
        return cloudCover;
    }

    @JsonProperty("cloudCover")
    public void setCloudCover(Double cloudCover) {
        this.cloudCover = cloudCover;
    }

    @JsonProperty("pressure")
    public Double getPressure() {
        return pressure;
    }

    @JsonProperty("pressure")
    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    @JsonProperty("ozone")
    public Double getOzone() {
        return ozone;
    }

    @JsonProperty("ozone")
    public void setOzone(Double ozone) {
        this.ozone = ozone;
    }

    @JsonProperty("uvIndex")
    public Integer getUvIndex() {
        return uvIndex;
    }

    @JsonProperty("uvIndex")
    public void setUvIndex(Integer uvIndex) {
        this.uvIndex = uvIndex;
    }

    @JsonProperty("uvIndexTime")
    public Integer getUvIndexTime() {
        return uvIndexTime;
    }

    @JsonProperty("uvIndexTime")
    public void setUvIndexTime(Integer uvIndexTime) {
        this.uvIndexTime = uvIndexTime;
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
