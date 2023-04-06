package com.example.basecomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.basecomponent.databinding.ActivityMainBinding
import com.example.basecomponent.widget.CircularProgressButton
import com.example.basecomponent.widget.StepperInput

class MainActivity : AppCompatActivity() {
    lateinit var binder: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)

        binder.apply {
            passwordToggleEditText.addTextChangedListener {
                KLog.d("password: $it")
            }

            collapsibleText.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec lacinia nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec lacinia nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec lacinia nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec lacinia nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec lacinia nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec lacinia nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec lacinia nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec lacinia nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec lacinia nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec lacinia nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec lacinia nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec lacinia nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec lacinia nisl nisl nec nisl. Sed euismod, nisl nec ultricies lacinia, nisl nisl aliquet nisl, nec lacinia nisl nisl nec nisl")
            collapsibleText.getText()

            stepperInput.addValueChangeListener(object : StepperInput.ValueChangeListener {
                override fun onValueChanged(newValue: Int) {
                    KLog.d("value: $newValue")
                }
            })

            circularProgressButton.setOnClickListener {
                // 버튼이 클릭되었을 때 수행할 작업을 처리합니다.
                circularProgressButton.showProgress(true)

                // 작업이 완료되면 진행률 표시기를 숨깁니다.
                // 예: Coroutine, AsyncTask 또는 다른 비동기 작업에서 호출할 수 있습니다.
//                circularProgressButton.showProgress(false)
            }

        }
    }
}