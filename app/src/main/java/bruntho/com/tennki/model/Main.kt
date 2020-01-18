package bruntho.com.tennki.model

data class Main(
    val grnd_level: Int,
    val humidity: Int,
    val pressure: Int,
    val sea_level: Double,
    val temp: Double,
    val temp_kf: Double,
    val temp_max: Double,
    val temp_min: Double
) {
    fun getTempC(): Int = temp.toInt()
}