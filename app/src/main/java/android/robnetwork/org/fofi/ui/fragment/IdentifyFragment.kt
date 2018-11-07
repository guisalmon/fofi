package android.robnetwork.org.fofi.ui.fragment

import android.robnetwork.org.fofi.ui.BaseFragment
import android.robnetwork.org.fofi.R
import android.robnetwork.org.fofi.databinding.FragmentIdentifyBinding

class IdentifyFragment: BaseFragment<FragmentIdentifyBinding>() {
    override val layoutRes: Int
        get() = R.layout.fragment_identify

    override fun invalidate() {}
}