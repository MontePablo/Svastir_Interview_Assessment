package com.example.svastirinterview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import com.example.svastirinterview.databinding.ActivityLoginPageBinding

class LoginPage : AppCompatActivity() {
    lateinit var binding:ActivityLoginPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.password.transformationMethod=HideReturnsTransformationMethod.getInstance()
        binding.hideShow.setOnClickListener(View.OnClickListener {
            if(binding.password.transformationMethod==HideReturnsTransformationMethod.getInstance()){
                binding.password.transformationMethod=PasswordTransformationMethod.getInstance()
                binding.hideShow.setImageResource(R.drawable.baseline_visibility_off_24)
            }else{
                binding.password.transformationMethod=HideReturnsTransformationMethod.getInstance()
                binding.hideShow.setImageResource(R.drawable.baseline_visibility_24)
            }
        })

        binding.login.setOnClickListener(View.OnClickListener {
            startActivity(Intent(applicationContext,MainActivity::class.java))
            finish()
        })
    }
}