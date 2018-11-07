package android.robnetwork.org.fofi.ui.fragment

import android.robnetwork.org.fofi.R
import android.robnetwork.org.fofi.databinding.FragmentSearchBinding
import android.robnetwork.org.fofi.ui.BaseFragment

class SearchFragment: BaseFragment<FragmentSearchBinding>() {
    override val layoutRes = R.layout.fragment_search

    override fun setupUI(binding: FragmentSearchBinding) {
        super.setupUI(binding)
        binding.colorSelector()?.radioBoth?.isChecked = true
    }

    override fun invalidate() {}
}