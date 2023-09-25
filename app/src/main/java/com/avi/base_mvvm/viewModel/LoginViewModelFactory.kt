package com.avi.base_mvvm.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.avi.base_mvvm.Repositary
import com.avi.base_mvvm.models.login.reqLoginModel

class LoginViewModelFactory(val repositary: Repositary,val context: Context,val body:reqLoginModel) :ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(repositary , body) as T
    }
}