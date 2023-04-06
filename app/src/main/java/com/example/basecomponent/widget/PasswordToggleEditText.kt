package com.example.basecomponent.widget

import android.content.Context
import android.text.InputType
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.AppCompatEditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import com.example.basecomponent.R
import com.example.basecomponent.databinding.PasswordToggleEditTextBinding

class PasswordToggleEditText(context: Context, attrs: AttributeSet) : ConstraintLayout(context, attrs) {
    private val binding: PasswordToggleEditTextBinding

    init {
        val inflater = LayoutInflater.from(context)
        binding = PasswordToggleEditTextBinding.inflate(inflater, this, true)

        binding.togglePasswordVisibilityButton.setOnClickListener {
            togglePasswordVisibility()
        }
    }

    private fun togglePasswordVisibility() {
        val isPasswordVisible = binding.passwordEditText.inputType != InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        binding.passwordEditText.inputType = if (isPasswordVisible) {
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        } else {
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        }

        binding.passwordEditText.setSelection(binding.passwordEditText.text!!.length)

        val drawableId = if (isPasswordVisible) R.drawable.icon_visibility_off else R.drawable.icon_visibility
        binding.togglePasswordVisibilityButton.setImageDrawable(ContextCompat.getDrawable(context, drawableId))
    }

    fun addTextChangedListener(listener: (text: CharSequence?) -> Unit) {
        binding.passwordEditText.addTextChangedListener {
            listener(it)
        }
    }

    fun getPasswordEditText(): AppCompatEditText {
        return binding.passwordEditText
    }
}
