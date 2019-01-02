package com.stllpt.util

import java.sql.Timestamp
import java.util.*
import java.text.DecimalFormat
import kotlin.collections.HashMap


/**
 * Created by stllpt031 on 9/8/17.
 */
val INTENT_CITY_WEATHER = "WeatherByCityIntent"

val INTENT_REQUESTED_DAY = "RequestedDay"

val INTENT_DAY_CITY_WEATHER = "WeatherByCityAndDayIntent"

val INTENT_TIME_CITY_WEATHER = "WeatherByCityAndTimeIntent"

val INTENT_ASK_WEATHER_PARAM = "AskWeatherParam"

val SLOT_WEATHER_PARAMS = "weatherParam"

val INTENT_CHANGE_CITY = "ChangeCity"

val INTENT_CHANGE_DAY = "ChangeDay"

val SLOT_DAY = "day"

val SLOT_CITY = "city"

val SLOT_TIME = "time"

val API_KEY = "INSERT_DARK_SKY_API_KEY_HERE"

val BASE_URL = "https://api.darksky.net/forecast/"

val LOCATION_URL = "http://maps.googleapis.com/maps/api/geocode/json";

val degreeC = "degree Celsius"

val kmph = "Kilo meter per hour"

var weatherParamMap = HashMap<String, String>()

fun initMap() {
    weatherParamMap.put("humidity", "humidity")
    weatherParamMap.put("sunriseTime", "sunriseTime")
    weatherParamMap.put("sunsetTime", "sunsetTime")
    weatherParamMap.put("windSpeed", "windSpeed")
    weatherParamMap.put("summery", "summery")
    weatherParamMap.put("maximum temperature", "maxTemp")
    weatherParamMap.put("minimum temperature", "minTemp")
}

fun timeStampToDate(timeStamp: Long): Date {
    val timeStamp = Timestamp(timeStamp)
    val date = Date(timeStamp.time)
    return date
}

fun fahrenheitToCelsius(temperature: Double): Double {
    return ((temperature - 32) * 5) / 9
}

fun Double.format(): Double {
    val df = DecimalFormat("00.00")
    return df.format(this).toDouble()
}