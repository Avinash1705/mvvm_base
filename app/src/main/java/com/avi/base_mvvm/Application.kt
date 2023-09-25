package com.avi.base_mvvm

class Application : android.app.Application() {
    lateinit var repositary: Repositary
    override fun onCreate() {
        super.onCreate()
        initilize()
    }

    private fun initilize() {
        val service = RetrofitHelper.getInstance().create(UserInterface::class.java)
        repositary = Repositary(service)
    }
}