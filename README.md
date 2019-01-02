# Alexa-WeatherApp

The project contains aws lambda function to fetch weather information from [dark sky public api](https://darksky.net) and tell 
appropriate response to skill users.

## Requirement : 
- Java version >= 1.7
- kotlin version >= 1.1.3-2
- [Alexa Skills Kit](https://mvnrepository.com/artifact/com.amazon.alexa/alexa-skills-kit)
- Apache dependencies : [Commons Lang](https://mvnrepository.com/artifact/org.apache.commons/commons-lang3), [HttpClient](https://mvnrepository.com/artifact/org.apache.httpcomponents/httpclient), [HttpCore](https://mvnrepository.com/artifact/org.apache.httpcomponents/httpcore)
- AWS lambda dependencies : [java core](https://mvnrepository.com/artifact/com.amazonaws/aws-lambda-java-core), [log4j](https://mvnrepository.com/artifact/com.amazonaws/aws-lambda-java-log4j)
- [DarkSky Forecast API](https://mvnrepository.com/artifact/tk.plogitech/darksky-forecast-api)

## Implementation : 
- To get basic idea to implement AWS lambda function for java follow this alexa sample skill [Hello world](https://github.com/alexa/skill-samples-java/tree/master/helloworld)
- To target your alexa skill you need to replace your alexa skill id in [WeatherSpeechletRequestHandler.class](https://github.com/akashMehta-STL/Alexa-WeatherApp/blob/master/src/main/java/com/stllpt/WeatherSpeechletRequestHandler.kt) which you will be able to get from [alexa developer console](https://developer.amazon.com)
- In this skill we used dark sky weather api so you have to replace your dark sky api key in API_KEY constant in [Constants.kt](https://github.com/akashMehta-STL/Alexa-WeatherApp/blob/master/src/main/java/com/stllpt/util/Constants.kt)
- You can refer interaction model for MyWeather skill from [here](https://github.com/akashMehta-STL/Alexa-WeatherApp/blob/master/src/main/resources/speech_intents.json)

## Other resources.
- Build alexa skill in Java tutorial : http://thegeekettespeaketh.com/2017/02/build-an-alexa-skill-java-1/
- Dark sky api : https://github.com/200Puls/darksky-forecast-api
- Hello world sample skill : https://github.com/alexa/skill-samples-java/tree/master/helloworld
