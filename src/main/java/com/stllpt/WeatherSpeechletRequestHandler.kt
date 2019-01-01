package com.stllpt

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler

import java.util.HashSet

/**
 * Created by stllpt031 on 8/8/17.
 */
    class WeatherSpeechletRequestHandler : SpeechletRequestStreamHandler(WeatherSpeechlet(), WeatherSpeechletRequestHandler.supportedApplicationIds) {
    companion object {
        private val supportedApplicationIds = HashSet<String>()

        init {
            supportedApplicationIds.add("INSERT_APPLICATION_ID_HERE")
        }
    }

}