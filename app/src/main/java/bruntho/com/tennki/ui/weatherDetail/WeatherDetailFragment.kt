package bruntho.com.tennki.ui.weatherDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import bruntho.com.tennki.R
import bruntho.com.tennki.databinding.WeatherDetailFragmentBinding

class WeatherDetailFragment : Fragment() {

    companion object {
        fun newInstance() = WeatherDetailFragment()
    }

    private lateinit var viewModel: WeatherDetailViewModel
    private lateinit var binding: WeatherDetailFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.weather_detail_fragment, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WeatherDetailViewModel::class.java)
        val adapter = WeatherDetailRecyclerAdapter(arrayListOf())
        binding.list.apply {
            this.adapter = adapter
        }
        binding.collapsingtoolbarlayout.setCollapsedTitleTextColor(resources.getColor(R.color.white, null))
        binding.collapsingtoolbarlayout.setExpandedTitleColor(resources.getColor(R.color.white, null))
        viewModel.weather.observe(viewLifecycleOwner, Observer {
            adapter.updateData(it)
            if (it.list.isNotEmpty()) {
                binding.weatherDescription.text = "${it.list[0].main.getTempC()}℃ ${it.list[0].weather[0].description}"
            }

        })
    }

}
