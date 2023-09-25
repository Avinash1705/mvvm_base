package com.avi.base_mvvm.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avi.base_mvvm.Repositary
import com.avi.base_mvvm.models.login.reqLoginModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(val repositary: Repositary,body:reqLoginModel) :ViewModel(){

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repositary.loginUser(body)
        }
    }
    val loginResLiveData = repositary.loginTokenLiveData
}