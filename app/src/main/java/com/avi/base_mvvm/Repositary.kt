package com.avi.base_mvvm

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.avi.base_mvvm.models.login.reqLoginModel
import com.avi.base_mvvm.models.login.responseLoginModel
import com.avi.base_mvvm.models.register.registerReqModel
import com.avi.base_mvvm.models.register.registerResponseModel
import com.avi.base_mvvm.models.users.userModel
import com.avi.base_mvvm.result.Response
import kotlin.coroutines.coroutineContext

class Repositary(private val userService: UserInterface) {
    //for employees
    private var employees = MutableLiveData<Response<userModel>>()

    //    val employeesLiveData = employees
    val employeesLiveData: LiveData<Response<userModel>>
        get() = employees
    //for login
    private var loginToken = MutableLiveData<Response<responseLoginModel>>()
    val loginTokenLiveData: LiveData<Response<responseLoginModel>> = loginToken

    //for register
    private var registerToken = MutableLiveData<Response<registerResponseModel>>()
    val registerTokenLiveData: LiveData<Response<registerResponseModel>> = registerToken

    suspend fun getEmployees(page: Int) {
        val result = userService.getUser(page)
        if (result.isSuccessful) {
            employees.postValue(Response.Success(result.body()))
            Log.d("rawat", "getEmployees:${result.body()!!.data} ")
        }
        else
            Response.Error<String>(result.errorBody().toString())
    }
    suspend fun loginUser(body:reqLoginModel) {
        val result = userService.loginUser(body)
        if (result.isSuccessful) {
            Log.d("rawat", "successLogin:${result.body()!!.token} ")
            loginToken.postValue(Response.Success(result.body()))
        }
        else
            Response.Error<String>(result.errorBody().toString())
    }
    suspend fun registerUser(body:registerReqModel) {
        Log.d("rawat", "registerUser: repo")
        val result = userService.registerUser(body)
        Log.d("rawat", "registerUser: repo Body $result")
        if (result.isSuccessful) {
            Log.d("rawat", "successRegister:${result.body()!!.token} ")
            registerToken.postValue(Response.Success(result.body()))
        }
        else
            Response.Error<String>(result.errorBody().toString())
    }
}