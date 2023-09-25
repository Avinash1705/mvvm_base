package com.avi.base_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.avi.base_mvvm.result.Response
import com.avi.base_mvvm.viewModel.UserViewModel
import com.avi.base_mvvm.viewModel.UserViewModelFactory
import com.avi.userAdapter

class MainActivity : AppCompatActivity() {
//    lateinit var application: Application
    lateinit var userViewModel: UserViewModel
    lateinit var tvMain: TextView
    lateinit var myAdapter:userAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvMain = findViewById(R.id.tvMain)
        val recyclerView :RecyclerView = findViewById(R.id.recyclerViewMain)
        val repo = (application as Application).repositary
        userViewModel =
            ViewModelProvider(this, UserViewModelFactory(this, repo))[UserViewModel::class.java]

        userViewModel.userLiveData.observe(this) {
            when (it) {
                is Response.Error -> Toast.makeText(
                    this,
                    userViewModel.userLiveData.value!!.errorMessage,
                    Toast.LENGTH_SHORT
                )
                is Response.Loading -> ProgressBar(this)
                is Response.Success -> {

                    myAdapter = userAdapter(userViewModel.userLiveData.value!!.data!!.data,this)

                    recyclerView.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)
                    recyclerView.adapter = myAdapter
                    tvMain.text = userViewModel.userLiveData.value!!.data!!.data.toString()

                }
            }
        }
    }
}