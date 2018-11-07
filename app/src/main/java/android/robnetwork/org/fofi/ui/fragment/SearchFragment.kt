package android.robnetwork.org.fofi.ui.fragment

import android.robnetwork.org.fofi.R
import android.robnetwork.org.fofi.databinding.FragmentSearchBinding
import android.robnetwork.org.fofi.ui.BaseFragment
import android.widget.ArrayAdapter

class SearchFragment: BaseFragment<FragmentSearchBinding>() {
    override val layoutRes = R.layout.fragment_search

    override fun setupUI(binding: FragmentSearchBinding) {
        super.setupUI(binding)
        binding.colorSelector()?.radioBoth?.isChecked = true
        context?.let { context ->
            ArrayAdapter.createFromResource(context, R.array.iso, R.layout.spinner_center_item).also {
                it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.sensibilitySelector.adapter = it
            }
            ArrayAdapter.createFromResource(context, R.array.film, R.layout.spinner_center_item).also {
                it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.filmSelector.adapter = it
            }
        }
    }

    override fun invalidate() {}
}