package bruntho.com.tennki.repository

import android.content.Context
import bruntho.com.tennki.model.CityListResponse
import bruntho.com.tennki.model.WeatherResponse
import bruntho.com.tennki.service.AssetService
import bruntho.com.tennki.service.WeatherAPIService
import com.google.gson.Gson

class WeatherRepo {
    private val weatherAPIService = WeatherAPIService()
    private val assetService = AssetService()

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

    fun loadCityList(context: Context): CityListResponse? {
        val json = assetService.loadJSONFromAsset(context)
        return Gson().fromJson(json, CityListResponse::class.java)
    }
}