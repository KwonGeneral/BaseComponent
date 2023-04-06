package com.example.basecomponent.widget

import android.content.Context
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import com.example.basecomponent.R
import com.example.basecomponent.databinding.CircularProgressButtonBinding

class CircularProgressButton(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private val binding: CircularProgressButtonBinding
    private var buttonText: String
    private var progressColor: Int

    init {
        val inflater = LayoutInflater.from(context)
        binding = CircularProgressButtonBinding.inflate(inflater, this, true)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CircularProgressButton)
        buttonText = typedArray.getString(R.styleable.CircularProgressButton_buttonText) ?: ""
        progressColor = typedArray.getColor(R.styleable.CircularProgressButton_progressColor, Color.parseColor("#000000"))
        typedArray.recycle()

        binding.button.text = buttonText
        binding.progressBar.indeterminateDrawable.colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(progressColor, BlendModeCompat.SRC_IN)
    }

    fun setOnClickListener(listener: (View) -> Unit) {
        binding.button.setOnClickListener(listener)
    }

    fun showProgress(show: Boolean) {
        if (show) {
            binding.button.text = ""
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.button.text = buttonText
            binding.progressBar.visibility = View.GONE
        }
    }
}
