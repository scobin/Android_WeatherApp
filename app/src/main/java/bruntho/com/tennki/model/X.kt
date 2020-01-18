package bruntho.com.tennki.model

data class X(
    val clouds: Clouds,
    val dt: Long,
    val dt_txt: String,
    val main: Main,
    val snow: Snow,
    val sys: Sys,
    val weather: List<Weather>,
    val wind: Wind
)