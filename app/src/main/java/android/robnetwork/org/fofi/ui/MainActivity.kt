package android.robnetwork.org.fofi.ui

import android.robnetwork.org.fofi.R
import android.robnetwork.org.fofi.databinding.ActivityMainBinding
import android.robnetwork.org.fofi.databinding.ToolbarBinding
import android.view.View

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutRes = R.layout.activity_main

    override fun setupUI(binding: ActivityMainBinding) {
        super.setupUI(binding)
        binding.toolbar.toolbarTitle.visibility = View.GONE
    }

    fun toolbar(): ToolbarBinding? = binding?.toolbar
}
