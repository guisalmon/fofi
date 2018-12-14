package android.robnetwork.org.fofi.ui.fragment

import android.app.AlertDialog
import android.content.Context
import android.robnetwork.org.fofi.R
import android.robnetwork.org.fofi.databinding.FragmentAddFilm1Binding
import android.robnetwork.org.fofi.datasource.Datasource
import android.robnetwork.org.fofi.model.Film
import android.robnetwork.org.fofi.model.Iso
import android.robnetwork.org.fofi.ui.BaseFragment
import android.robnetwork.org.fofi.ui.BaseFragmentVM
import android.robnetwork.org.fofi.ui.Utils.safeAccess
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.navigation.fragment.findNavController
import com.airbnb.mvrx.*
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView

class AddFilm1Fragment : BaseFragment<FragmentAddFilm1Binding>() {
    override val layoutRes = R.layout.fragment_add_film_1

    private val viewModel by fragmentViewModel(AddFilm1VM::class)

    override fun setupUI(binding: FragmentAddFilm1Binding) {
        super.setupUI(binding)
        binding.addContinue.setOnClickListener { findNavController().navigate(R.id.complete_add) }
        binding.filmSelector.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) = viewModel.setFilm(null)
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) = viewModel.setFilm(position)
        }
        binding.sensibilitySelector.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) = viewModel.setIso(null)
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) = viewModel.setIso(position)
        }
        binding.calendar.setOnClickListener {
            AlertDialog.Builder(context).setView(R.layout.dialog_calendar).show().let { dialog ->
                dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
                dialog.window?.decorView?.findViewById<MaterialCalendarView>(R.id.calendar_view)?.let { calendarView ->
                    calendarView.setOnRangeSelectedListener { _, dateList ->
                        viewModel.setDateRange(dateList)
                    }
                }
            }
        }
    }

    override fun invalidate() {
        context?.let { context ->
            binding?.let { binding ->
                withState(viewModel) { state ->
                    Log.w(javaClass.simpleName, "" + state.isoList + " " + state.filmList)
                    when(state.filmList) {
                        is Fail -> state.filmList.error.printStackTrace()
                        is Success -> state.filmList()?.let { fillSpinner(context, binding.filmSelector, it) }
                        else -> Log.v(javaClass.simpleName, "Film list not initialized")
                    }
                    when(state.isoList) {
                        is Fail -> state.isoList.error.printStackTrace()
                        is Success -> state.isoList()?.let { fillSpinner(context, binding.sensibilitySelector, it) }
                        else -> Log.v(javaClass.simpleName, "Film list not initialized")
                    }
                }
            }
        }
    }

    private fun fillSpinner(context: Context, spinner: Spinner, list: List<*>) {
        ArrayAdapter(context, R.layout.spinner_center_item, list).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = it
        }
    }
}

data class AddFilm1State(
    val filmList: Async<List<Film>> = Uninitialized,
    val isoList: Async<List<Iso>> = Uninitialized,
    val selectedFilm: Film? = null,
    val selectedIso: Iso? = null
) : MvRxState

class AddFilm1VM(initialState: AddFilm1State) : BaseFragmentVM<AddFilm1State>(initialState) {

    init {
        Datasource.getAll(Film::class.java).asyncRequest { setState { copy(filmList = it) } }
        Datasource.getAll(Iso::class.java).asyncRequest { setState { copy(isoList = it) } }
    }

    fun setFilm(position: Int?) {
        withState { state ->
            position?.let { position ->
                state.filmList.safeAccess { setState { copy(selectedFilm = it[position]) } }
            } ?: setState { copy(selectedFilm = null) }
        }
    }

    fun setIso(position: Int?) {
        withState { state ->
            position?.let { position ->
                state.isoList.safeAccess { setState { copy(selectedIso = it[position]) } }
            } ?: setState { copy(selectedIso = null) }
        }
    }

    fun setDateRange(list: List<CalendarDay>) {

    }
}