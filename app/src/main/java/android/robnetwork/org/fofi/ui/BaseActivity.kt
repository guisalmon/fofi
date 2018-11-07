package android.robnetwork.org.fofi.ui

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import com.airbnb.mvrx.BaseMvRxActivity

abstract class BaseActivity<B : ViewDataBinding> : BaseMvRxActivity() {
    @get:LayoutRes
    abstract val layoutRes: Int

    protected var binding: B? = null
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil.setContentView<B>(this, layoutRes)?.apply { setupUI(this) }
    }

    @CallSuper
    protected open fun setupUI(binding: B) {
        this.binding = binding
    }
}