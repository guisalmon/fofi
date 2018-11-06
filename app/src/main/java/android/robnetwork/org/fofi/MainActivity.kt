package android.robnetwork.org.fofi

import android.robnetwork.org.fofi.databinding.ActivityMainBinding
import android.robnetwork.org.fofi.databinding.ToolbarBinding
import android.view.View

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutRes = R.layout.activity_main

    override fun setupUI(binding: ActivityMainBinding) {
        binding.toolbar.toolbarTitle.visibility = View.GONE
    }

    fun toolbar(): ToolbarBinding? = binding?.toolbar
}
