package android.robnetwork.org.fofi.ui.fragment

import android.content.Intent
import android.robnetwork.org.fofi.ui.BaseFragment
import android.robnetwork.org.fofi.R
import android.robnetwork.org.fofi.databinding.FragmentIdentifyBinding
import android.robnetwork.org.fofi.ui.AddFilmActivity

class IdentifyFragment: BaseFragment<FragmentIdentifyBinding>() {
    override val layoutRes = R.layout.fragment_identify

    override fun setupUI(binding: FragmentIdentifyBinding) {
        super.setupUI(binding)
        binding.addFab.setOnClickListener { startActivity(Intent(requireContext(), AddFilmActivity::class.java)) }
    }

    override fun invalidate() {}
}