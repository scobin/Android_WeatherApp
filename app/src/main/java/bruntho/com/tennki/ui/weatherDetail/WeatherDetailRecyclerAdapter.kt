package bruntho.com.tennki.ui.weatherDetail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bruntho.com.tennki.R
import bruntho.com.tennki.model.WeatherResponse
import bruntho.com.tennki.model.X
import kotlinx.android.synthetic.main.weather_detail_item.view.*
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*

class WeatherDetailRecyclerAdapter(
    var data: MutableList<X>
): RecyclerView.Adapter<WeatherDetailRecyclerAdapter.WeatherDetailRecyclerHolder>() {
    class WeatherDetailRecyclerHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherDetailRecyclerHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.weather_detail_item, parent, false)
        return WeatherDetailRecyclerHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: WeatherDetailRecyclerHolder, position: Int) {
        val weather = data[position]
        holder.itemView.temperature.text = weather.main.getTempC().toString() + "℃"
        val date = Date(weather.dt * 1000)
        val localDateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())
        holder.itemView.time.text = "${localDateTime.hour}時"
        if (localDateTime.hour == 0) {
            holder.itemView.date.text = "${localDateTime.month.value}/${localDateTime.dayOfMonth}"
        } else {
            holder.itemView.date.text = ""
        }
    }

    fun updateData(response: WeatherResponse?) {
        response?.let {
            data = response.list as MutableList<X>
            notifyDataSetChanged()
        }
    }
}