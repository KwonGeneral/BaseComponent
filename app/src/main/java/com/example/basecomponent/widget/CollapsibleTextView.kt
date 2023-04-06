package com.example.basecomponent.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.basecomponent.R
import com.example.basecomponent.databinding.CollapsibleTextViewBinding

class CollapsibleTextView(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {

    private val binding: CollapsibleTextViewBinding
    private var isCollapsed = true

    init {
        val inflater = LayoutInflater.from(context)
        binding = CollapsibleTextViewBinding.inflate(inflater, this, true)

        binding.toggleButton.setOnClickListener {
            toggleCollapse()
        }
    }

    private fun toggleCollapse() {
        if (isCollapsed) {
            binding.contentTextView.maxLines = Integer.MAX_VALUE
            binding.toggleButton.setImageResource(R.drawable.icon_expand_less)
        } else {
            binding.contentTextView.maxLines = 3
            binding.toggleButton.setImageResource(R.drawable.icon_expand_more)
        }
        isCollapsed = !isCollapsed
    }

    fun setText(text: CharSequence) {
        binding.contentTextView.text = text
    }

    fun getText(): CharSequence {
        return binding.contentTextView.text
    }
}