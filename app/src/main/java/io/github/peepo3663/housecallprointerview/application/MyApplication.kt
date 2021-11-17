package io.github.peepo3663.housecallprointerview.application

import android.app.Application
import io.github.peepo3663.housecallprointerview.components.AppComponent
import io.github.peepo3663.housecallprointerview.components.DaggerAppComponent
import io.github.peepo3663.housecallprointerview.modules.AppModule

class MyApplication: Application() {

    companion object {
        lateinit var instance: MyApplication
        private set
    }

    lateinit var appComponent: AppComponent
    private set

    override fun onCreate() {
        super.onCreate()

        instance = this

        appComponent = initDagger(this)
        appComponent.inject(this)
    }

    private fun initDagger(app: MyApplication): AppComponent = DaggerAppComponent.builder().appModule(AppModule(app)).build()
}