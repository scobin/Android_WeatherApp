package bruntho.com.tennki.ui.weatherDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bruntho.com.tennki.model.WeatherResponse
import bruntho.com.tennki.repository.WeatherRepo
import kotlinx.coroutines.launch

class WeatherDetailViewModel(
    cityId: String? = "7280291",
    val cityName: String? = "Taiwan"
) : ViewModel() {

    private val weatherRepo = WeatherRepo()

    val weather: LiveData<WeatherResponse> get() = _weather
    private var _weather = MutableLiveData<WeatherResponse>()

    init {
        cityId?.let {
            viewModelScope.launch {
                weatherRepo.loadWeather(it)?.let {
                    _weather.value = it
                }
            }
        }

    }
}
