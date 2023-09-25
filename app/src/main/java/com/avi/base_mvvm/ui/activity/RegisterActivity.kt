package com.avi.base_mvvm.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.avi.base_mvvm.Application
import com.avi.base_mvvm.R
import com.avi.base_mvvm.databinding.ActivityRegisterBinding
import com.avi.base_mvvm.viewModel.RegisterViewModel
import com.avi.base_mvvm.viewModel.RegisterViewModelFactory

class RegisterActivity : AppCompatActivity() {
     var binding: ActivityRegisterBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_register)
        setContentView(binding!!.root)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        val repo = (application as Application).repositary
        val registerViewModel =
            ViewModelProvider(this, RegisterViewModelFactory(repo))[RegisterViewModel::class.java]

        binding!!.lifecycleOwner = this
        binding!!.registerViewModel = registerViewModel

    }
}