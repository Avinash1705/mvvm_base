package com.avi.base_mvvm.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.viewModelScope
import com.avi.base_mvvm.Repositary
import com.avi.base_mvvm.models.register.registerReqModel
import kotlinx.coroutines.launch

class RegisterViewModel(val repo: Repositary) :
    ViewModel() {
     var email = MutableLiveData<String>()
    val emailLiveData: LiveData<String> = email

     var password = MutableLiveData<String>()
    val passwordLiveData: LiveData<String> = password


     fun setRegisterUser(){
         Log.d("rawawt", "setRegisterUser: ")
      viewModelScope.launch {
          repo.registerUser(registerReqModel(email.value.toString(),password.value.toString()))
      }
    }
}