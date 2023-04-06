package com.example.basecomponent.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.example.basecomponent.R
import com.example.basecomponent.databinding.MultiStateToggleButtonBinding

class MultiStateToggleButton(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private val binding: MultiStateToggleButtonBinding
    private var stateDrawables: List<Drawable>
    private var currentStateIndex: Int = 0

    init {
        val inflater = LayoutInflater.from(context)
        binding = MultiStateToggleButtonBinding.inflate(inflater, this, true)

        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MultiStateToggleButton)
        val drawableResArrayId = typedArray.getResourceId(R.styleable.MultiStateToggleButton_state_drawables, 0)
        stateDrawables = if (drawableResArrayId != 0) {
            val resArray = resources.obtainTypedArray(drawableResArrayId)
            val drawables = mutableListOf<Drawable>()
            for (i in 0 until resArray.length()) {
                drawables.add(ResourcesCompat.getDrawable(resources, resArray.getResourceId(i, 0), null)!!)
            }
            resArray.recycle()
            drawables
        } else {
            emptyList()
        }
        typedArray.recycle()

        if (stateDrawables.isNotEmpty()) {
            binding.toggleButton.setImageDrawable(stateDrawables[currentStateIndex])
        }

        binding.toggleButton.setOnClickListener {
            toggleState()
        }
    }

    private fun toggleState() {
        currentStateIndex = (currentStateIndex + 1) % stateDrawables.size
        binding.toggleButton.setImageDrawable(stateDrawables[currentStateIndex])
    }

    fun getCurrentStateIndex(): Int {
        return currentStateIndex
    }
}
