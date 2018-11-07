package android.robnetwork.org.fofi.ui.view

import android.content.Context
import android.databinding.DataBindingUtil
import android.robnetwork.org.fofi.R
import android.robnetwork.org.fofi.databinding.ThreewayButtonBinding
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RadioGroup

class ColorSelector(context: Context, attrs: AttributeSet?) : RadioGroup(context, attrs) {
    constructor(context: Context): this(context, null)

    private val binding: ThreewayButtonBinding? =
        DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.threeway_button, this, true)

    operator fun invoke() = binding
}