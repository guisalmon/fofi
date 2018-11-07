package android.robnetwork.org.fofi.ui

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import com.airbnb.mvrx.BaseMvRxActivity

abstract class BaseActivity<B : ViewDataBinding> : BaseMvRxActivity() {
    @get:LayoutRes
    abstract val layoutRes: Int

    var binding: B? = null
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        binding?.let { setupUI(it) }
    }

    open fun setupUI(binding: B) {}
}