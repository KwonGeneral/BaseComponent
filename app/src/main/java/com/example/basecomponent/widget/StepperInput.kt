package com.example.basecomponent.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.basecomponent.R
import com.example.basecomponent.databinding.StepperInputBinding

class StepperInput(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private val binding: StepperInputBinding
    private var value: Int = 0
    private var valueChangeListener: ValueChangeListener? = null
    private var allowNegativeValues: Boolean = false

    interface ValueChangeListener {
        fun onValueChanged(newValue: Int)
    }

    init {
        val inflater = LayoutInflater.from(context)
        binding = StepperInputBinding.inflate(inflater, this, true)

        // 속성을 읽어들입니다.
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.StepperInput)
        allowNegativeValues = typedArray.getBoolean(R.styleable.StepperInput_allowNegativeValues, false)
        typedArray.recycle()

        binding.decrementButton.setOnClickListener {
            decrementValue()
        }

        binding.incrementButton.setOnClickListener {
            incrementValue()
        }
    }

    private fun decrementValue() {
        if (allowNegativeValues || value > 0) {
            value -= 1
            updateValue()
            valueChangeListener?.onValueChanged(value)
        }
    }

    private fun incrementValue() {
        value += 1
        updateValue()
        valueChangeListener?.onValueChanged(value)
    }

    private fun updateValue() {
        binding.valueTextView.text = value.toString()
    }

    fun getValue(): Int {
        return value
    }

    fun setValue(newValue: Int) {
        value = newValue
        updateValue()
    }

    fun addValueChangeListener(listener: ValueChangeListener) {
        valueChangeListener = listener
    }
}
