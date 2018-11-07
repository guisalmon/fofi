package android.robnetwork.org.fofi.ui

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.Parcelable
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.MvRx

abstract class BaseFragment<B: ViewDataBinding>: BaseMvRxFragment() {
    @get:LayoutRes
    abstract val layoutRes: Int

    var binding: B? = null
        private set

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding?.let { setupUI(it) }
        return binding?.root
    }

    open fun setupUI(binding: B) {}

    protected fun navigateTo(navId: Int, args: Parcelable) {
        val  bundle = Bundle()
        bundle.putParcelable(MvRx.KEY_ARG, args)
        NavHostFragment.findNavController(this).navigate(navId, bundle)
    }

    protected fun navigateTo(navId: Int) {
        NavHostFragment.findNavController(this).navigate(navId)
    }
}