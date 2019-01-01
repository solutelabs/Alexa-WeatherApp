package com.stllpt

import com.amazon.speech.speechlet.*
import com.amazon.speech.ui.PlainTextOutputSpeech
import com.amazon.speech.ui.Reprompt
import com.amazon.speech.ui.SsmlOutputSpeech
import com.stllpt.model.WeatherReponses.WeatherData
import com.stllpt.util.*
import java.lang.reflect.Method
import kotlin.coroutines.experimental.EmptyCoroutineContext.plus

/**
 * Created by stllpt031 on 8/8/17.
 */
class WeatherSpeechlet : Speechlet {
    private var weatherDataUtils: WeatherDataUtils? = null
    private var weatherData: WeatherData? = null
    private var weatherByDate: WeatherByDate? = null
    private val moreParams = ". You can ask for other parameter such as humidity, " +
            "maximum temperature or change city or " +
            "day by saying change to city name or change to day."

    @Throws(SpeechletException::class)
    override fun onSessionStarted(sessionStartedRequest: SessionStartedRequest, session: Session) {
        weatherDataUtils = WeatherDataUtils()
        initMap()
    }

    @Throws(SpeechletException::class)
    override fun onLaunch(launchRequest: LaunchRequest, session: Session): SpeechletResponse? {
        return getWelcomeReponse()
    }

    private fun getWelcomeReponse(): SpeechletResponse? {
        val welcomeSpeech = "hey buddy! welcome to weather api , you can ask for weather at any city today"
        return getAskResponse(welcomeSpeech)
    }

    private fun getAskResponse(message: String): SpeechletResponse? {
        val speech = PlainTextOutputSpeech()
        speech.text = message

        val reprompt = Reprompt()
        reprompt.outputSpeech = speech

        return SpeechletResponse.newAskResponse(speech, reprompt)
    }

    private fun getSpeechResponse(message: String): SpeechletResponse? {
        val speech = PlainTextOutputSpeech()
        speech.text = message
        return SpeechletResponse.newTellResponse(speech)
    }

    /**
     * Method to get data accodring to city hour and time
     * Date will be fetched in form of yyyy-MM-dd and Time will fetch in form of HH:mm
     */
    @Throws(SpeechletException::class)
    override fun onIntent(intentRequest: IntentRequest, session: Session): SpeechletResponse? {
        val intent = intentRequest.intent
        val intentName = intent?.name
        if (intentName == null) {
            throw SpeechletException("Invalid Intent")
        } else {
            try {
                when (intentName) {
                    INTENT_CITY_WEATHER, INTENT_CHANGE_CITY -> {
                        val city = intent.getSlot(SLOT_CITY)
                        weatherData = weatherDataUtils!!.fetchWeahterData(city.value)
                        return getAskResponse("On which date you want weather updates? ")
                    }
                    INTENT_REQUESTED_DAY, INTENT_CHANGE_DAY -> {
                        val day = intent.getSlot(SLOT_DAY)
                        weatherByDate = WeatherByDate(day.value, weatherData!!)
                        var response: String = weatherByDate!!.summeryByDate()
                        return getAskResponse(response + moreParams)
                    }
                    INTENT_ASK_WEATHER_PARAM -> {
                        val weatherParams = intent.getSlot(SLOT_WEATHER_PARAMS)
                        val weatherParamKey = weatherParamMap.get(weatherParams.value)
                        var method: Method = WeatherByDate::class.java.getMethod(weatherParamKey + "ByDate")
                        var methodResponse = method.invoke(weatherByDate) as String
                        return getAskResponse(methodResponse + moreParams)
                    }
                    INTENT_DAY_CITY_WEATHER -> {
                        val city = intent.getSlot(SLOT_CITY)
                        val day = intent.getSlot(SLOT_DAY)
                        val weatherData = weatherDataUtils!!.fetchWeahterData(city.value)
                        var text = """ "There'll be "${weatherData!!.hourly.summary}
                        " " ${day.value}" " """
                        return getSpeechResponse(text)
                    }
                    INTENT_TIME_CITY_WEATHER -> {
                        val city = intent.getSlot(SLOT_CITY)
                        val day = intent.getSlot(SLOT_DAY)
                        val time = intent.getSlot(SLOT_TIME)
                        val weatherData = weatherDataUtils!!.fetchWeahterData(city.value)
                        var text = """ "There'll be "${weatherData!!.hourly.summary}
                        " " ${day.value}" " ${time.value}"""
                        return getSpeechResponse(text)
                    }
                }
            } catch (e: Exception) {
                val speech = PlainTextOutputSpeech()
                speech.text = e.message

                return SpeechletResponse.newTellResponse(speech)
            }

        }
        return null
    }

    @Throws(SpeechletException::class)
    override fun onSessionEnded(sessionEndedRequest: SessionEndedRequest, session: Session) {
        weatherParamMap = null!!
    }


}