package android.robnetwork.org.fofi.ui

import android.robnetwork.org.fofi.R
import android.robnetwork.org.fofi.databinding.ActivityAddFilmBinding
import android.support.v4.app.NavUtils
import android.view.View

class AddFilmActivity: BaseActivity<ActivityAddFilmBinding>() {
    override val layoutRes = R.layout.activity_add_film

    override fun setupUI(binding: ActivityAddFilmBinding) {
        super.setupUI(binding)
        binding.toolbar.toolbarSearch.visibility = View.GONE
        binding.toolbar.toolbarLeftAction.setImageResource(R.drawable.arrow_left)
        binding.toolbar.toolbarLeftAction.setOnClickListener { NavUtils.navigateUpFromSameTask(this) }
    }
}