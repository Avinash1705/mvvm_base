package com.avi.base_mvvm



import com.avi.base_mvvm.models.login.reqLoginModel
import com.avi.base_mvvm.models.login.responseLoginModel
import com.avi.base_mvvm.models.register.registerReqModel
import com.avi.base_mvvm.models.register.registerResponseModel
import com.avi.base_mvvm.models.users.userModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserInterface {

    @GET("users")
    suspend fun getUser(@Query("page") page: Int): Response<userModel>

    @POST("login")
    suspend fun loginUser(@Body loginUser: reqLoginModel) :Response<responseLoginModel>

    @POST("register")
    suspend fun registerUser(@Body registerUser:registerReqModel):Response<registerResponseModel>
}