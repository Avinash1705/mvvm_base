package com.avi.base_mvvm.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.avi.base_mvvm.Application
import com.avi.base_mvvm.MainActivity
import com.avi.base_mvvm.R
import com.avi.base_mvvm.models.login.reqLoginModel
import com.avi.base_mvvm.result.Response
import com.avi.base_mvvm.viewModel.LoginViewModel
import com.avi.base_mvvm.viewModel.LoginViewModelFactory
import com.avi.base_mvvm.viewModel.UserViewModel
import com.google.android.material.progressindicator.CircularProgressIndicator

class LoginActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        name = findViewById(R.id.editTextTextPersonName)
        password = findViewById(R.id.editTextTextPersonPassword)


    }

    fun loginFn(view: View) {
        val repositary = (application as Application).repositary
        //value pass
        val reqLoginModel =  reqLoginModel(name.text.trim().toString(), password.text.trim().toString())

        val viewModel = ViewModelProvider(this,LoginViewModelFactory(repositary,this,
            reqLoginModel
        ))[LoginViewModel::class.java]

        viewModel.loginResLiveData.observe(this,{
            when (it) {
                is Response.Error -> Toast.makeText(this,it.errorMessage,Toast.LENGTH_SHORT)
                is Response.Loading -> ProgressBar(this)
                is Response.Success -> {
                    Toast.makeText(this, it.data!!.token, Toast.LENGTH_SHORT)
                    startActivity(Intent(this,MainActivity::class.java))
                }
            }
        })
    }

    fun registerFn(view: View) {
        startActivity(Intent(this,RegisterActivity::class.java))
    }
}