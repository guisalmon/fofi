package android.robnetwork.org.fofi.ui.fragment

import android.robnetwork.org.fofi.R
import android.robnetwork.org.fofi.databinding.FragmentAddFilm2Binding
import android.robnetwork.org.fofi.ui.BaseFragment

class AddFilm2Fragment: BaseFragment<FragmentAddFilm2Binding>() {
    override val layoutRes = R.layout.fragment_add_film_2

    override fun setupUI(binding: FragmentAddFilm2Binding) {
        super.setupUI(binding)
        binding.saveFilm.setOnClickListener { activity?.finish() }
    }

    override fun invalidate() {
    }
}