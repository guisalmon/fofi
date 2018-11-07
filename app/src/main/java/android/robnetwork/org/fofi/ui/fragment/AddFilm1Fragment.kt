package android.robnetwork.org.fofi.ui.fragment

import android.robnetwork.org.fofi.R
import android.robnetwork.org.fofi.databinding.FragmentAddFilm1Binding
import android.robnetwork.org.fofi.ui.BaseFragment
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController

class AddFilm1Fragment: BaseFragment<FragmentAddFilm1Binding>() {
    override val layoutRes = R.layout.fragment_add_film_1

    override fun setupUI(binding: FragmentAddFilm1Binding) {
        super.setupUI(binding)
        binding.addContinue.setOnClickListener { findNavController().navigate(R.id.complete_add) }
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

    override fun invalidate() {
    }
}