package com.avi.base_mvvm.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.avi.base_mvvm.Repositary
import kotlinx.coroutines.launch

class UserViewModel(val repo:Repositary) : ViewModel() {
        init {
                viewModelScope.launch {
                        repo.getEmployees(1)
                }
        }
        val  userLiveData  = repo.employeesLiveData
}