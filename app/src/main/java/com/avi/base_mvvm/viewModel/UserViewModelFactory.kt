package com.avi.base_mvvm.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.avi.base_mvvm.Repositary

class UserViewModelFactory(val context: Context,val repositary: Repositary) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(repositary) as T
    }
}