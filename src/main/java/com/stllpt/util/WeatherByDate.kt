package com.stllpt.util

import java.util.*

/**
 * Created by stllpt031 on 11/8/17.
 */
class WeatherByDate {

    var currentDatum_: com.stllpt.model.WeatherReponses.Datum_? = null

    constructor(date: String, weatherData: com.stllpt.model.WeatherReponses.WeatherData) {
        for (daily in weatherData.daily.data) {
            if (date.equals(timestampToDate(daily.time.toLong()))) {
                currentDatum_ = daily
            }
        }
    }

    private fun timestampToDate(timestamp: Long): String {
        var dateObj = java.util.Date(timestamp * 1000L)
        var sdf = java.text.SimpleDateFormat(TimingUtils.ALEXA_DATE_FORMAT, Locale.ENGLISH)
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        return sdf.format(dateObj)
    }

    private fun timestampToTime(timestamp: Long): String {
        var dateObj = java.util.Date(timestamp * 1000L)
        var sdf = java.text.SimpleDateFormat(TimingUtils.FORMAT_HOUR_MINUTE, Locale.ENGLISH)
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
        return sdf.format(dateObj)
    }

    fun summeryByDate(): String {
        return "The weather will be " + currentDatum_!!.summary + " "
    }

    fun sunriseTimeByDate(): String {
        return "Sunrise will be at " + timestampToTime(currentDatum_!!.sunriseTime!!.toLong())
    }

    fun sunsetTimeByDate(): String {
        return "Sunset will be at " + timestampToTime(currentDatum_!!.sunsetTime!!.toLong())
    }

    fun maxTempByDate(): String {
        var maxTempTime = timeStampToDate(currentDatum_!!.temperatureMaxTime.toLong())

        return "Maximum temperature will be " +
                "" + fahrenheitToCelsius(currentDatum_!!.temperatureMax).format()+" " + degreeC +
                " at " + TimingUtils.getLocalTime(maxTempTime)

    }

    fun minTempByDate(): String {

        var minTempTime = timeStampToDate(currentDatum_!!.temperatureMinTime.toLong())

        return "Minimum temperature will be " +
                "" + fahrenheitToCelsius(currentDatum_!!.temperatureMin).format()+" " + degreeC +
                " at " + TimingUtils.getLocalTime(minTempTime)

    }

    fun humidityByDate(): String {
        return "Humidity will be " + "" +
                "" + currentDatum_!!.humidity.format()
    }

    fun windSpeedByDate(): String {
        return "Wind speed will be " + "" +
                "" + currentDatum_!!.windSpeed.format()+" " + kmph
    }

}