package android.robnetwork.org.fofi.ui

import android.robnetwork.org.fofi.R
import android.robnetwork.org.fofi.databinding.ActivityMainBinding
import android.robnetwork.org.fofi.databinding.ToolbarBinding
import android.robnetwork.org.fofi.datasource.Datasource
import android.robnetwork.org.fofi.model.Iso
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val layoutRes = R.layout.activity_main

    override fun setupUI(binding: ActivityMainBinding) {
        super.setupUI(binding)
        binding.toolbar.toolbarTitle.visibility = View.GONE
        binding.bottomNavigation.setupWithNavController(findNavController(R.id.nav_host_fragment))
        Datasource.getReference(Iso.ISO_400)?.let { isoReference ->

        }
    }

    fun toolbar(): ToolbarBinding? = binding?.toolbar
}
