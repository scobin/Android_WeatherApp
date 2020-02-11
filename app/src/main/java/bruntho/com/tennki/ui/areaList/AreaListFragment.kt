package bruntho.com.tennki.ui.areaList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import bruntho.com.tennki.R

class AreaListFragment : Fragment() {

    companion object {
        fun newInstance() = AreaListFragment()
    }

    private lateinit var viewModel: AreaListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.area_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AreaListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
