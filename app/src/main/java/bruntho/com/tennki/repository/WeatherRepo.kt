package bruntho.com.tennki.repository

import bruntho.com.tennki.model.WeatherResponse
import bruntho.com.tennki.service.WeatherAPIService

class WeatherRepo {
    private val weatherAPIService = WeatherAPIService()

    suspend fun loadWeather(cityId: String): WeatherResponse? {
        return runCatching { weatherAPIService.getForecast(cityId) }.fold(
            onSuccess = {
                if (it.isSuccessful) {
                    var body = it.body()
                    if (body == null || body.cod != "200") {
                        return null
                    }
                    return body
                } else {
                    return null
                }
            },
            onFailure = { null }
        )

    }
}