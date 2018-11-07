package android.robnetwork.org.fofi.ui

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.Parcelable
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.MvRx

abstract class BaseFragment<B : ViewDataBinding> : BaseMvRxFragment() {
    @get:LayoutRes
    protected abstract val layoutRes: Int

    protected var binding: B? = null
        private set

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        DataBindingUtil.inflate<B>(inflater, layoutRes, container, false)?.apply { setupUI(this) }?.root

    @CallSuper
    protected open fun setupUI(binding: B) {
        this.binding = binding
    }

    protected fun navigateTo(navId: Int, args: Parcelable) = Bundle().apply { putParcelable(MvRx.KEY_ARG, args) }.let {
        NavHostFragment.findNavController(this).navigate(navId, it)
    }

    protected fun navigateTo(navId: Int) {
        NavHostFragment.findNavController(this).navigate(navId)
    }
}