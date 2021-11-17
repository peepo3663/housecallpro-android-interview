package io.github.peepo3663.housecallprointerview.application

import android.app.Application
import io.github.peepo3663.housecallprointerview.components.AppComponent
import io.github.peepo3663.housecallprointerview.components.DaggerAppComponent
import io.github.peepo3663.housecallprointerview.modules.AppModule
import io.github.peepo3663.housecallprointerview.modules.NetworkModule
import io.github.peepo3663.housecallprointerview.util.Constants

class MyApplication: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = initDagger(this)
        appComponent.inject(this)
    }

    private fun initDagger(app: MyApplication): AppComponent = DaggerAppComponent.builder().appModule(AppModule(app)).networkModule(
        NetworkModule(Constants.baseUrl)
    ).build()
    fun getApplicationComponent(): AppComponent = appComponent
}