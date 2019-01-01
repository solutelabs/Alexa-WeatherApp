package com.stllpt.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.stllpt.model.LocationResponses.AddressData
import com.stllpt.model.LocationResponses.Location
import com.stllpt.model.WeatherReponses.WeatherData
import com.stllpt.network.exceptions.DeviceAddressClientException
import com.stllpt.network.exceptions.UnauthorizedException
import org.apache.http.HttpStatus
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import java.io.IOException

/**
 * Created by stllpt031 on 9/8/17.
 */
class WeatherDataUtils {
    var latLng: Location? = null

    fun addressToLatLng(address : String) : Location? {
        val httpClient : CloseableHttpClient = HttpClients.createDefault()
        val httpGet = HttpGet(LOCATION_URL+"?address="+address+"&sensor=false")
        val addressData : AddressData
        try {
            val addressResponse = httpClient.execute(httpGet)
            val statusCode = addressResponse.statusLine.statusCode


            if (statusCode == HttpStatus.SC_OK) {
                val httpEntity = addressResponse.entity
                val responseBody = EntityUtils.toString(httpEntity)
                val objectMapper = ObjectMapper()
                addressData = objectMapper.readValue(responseBody, AddressData::class.java)
                println(addressData)
                return addressData.results[0].geometry.location
            } else if (statusCode == HttpStatus.SC_FORBIDDEN) {
                throw UnauthorizedException("Failed to authorize.")
            } else {
                val errorMessage = "Device Address API query failed with status code of " + statusCode
                throw DeviceAddressClientException(errorMessage)
            }
        } catch (ie: IOException) {
            throw DeviceAddressClientException(ie)
        }
        return null
    }

    fun fetchWeahterData(address: String) : WeatherData?{
        val httpClient : CloseableHttpClient = HttpClients.createDefault()
        val location = addressToLatLng(address)
        val baseUrl = BASE_URL+ API_KEY+"/"+location!!.lat+","+location!!.lng
        println(baseUrl)
        val httpGet = HttpGet(baseUrl)
        val weatherData : WeatherData
        try {
            val addressResponse = httpClient.execute(httpGet)
            val statusCode = addressResponse.statusLine.statusCode


            if (statusCode == HttpStatus.SC_OK) {
                val httpEntity = addressResponse.entity
                val responseBody = EntityUtils.toString(httpEntity)
                val objectMapper = ObjectMapper()

                weatherData = objectMapper.readValue(responseBody, WeatherData::class.java)
                println(responseBody)
                return weatherData
            } else if (statusCode == HttpStatus.SC_FORBIDDEN) {
                throw UnauthorizedException("Failed to authorize.")
            } else {
                val errorMessage = "Device Address API query failed with status code of " + statusCode
                throw DeviceAddressClientException(errorMessage)
            }
        } catch (ie: IOException) {
            throw DeviceAddressClientException(ie)
        }

        return null;
    }

}