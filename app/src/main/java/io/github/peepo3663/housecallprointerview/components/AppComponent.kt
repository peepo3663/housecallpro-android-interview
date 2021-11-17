package io.github.peepo3663.housecallprointerview.components

import dagger.Component
import io.github.peepo3663.housecallprointerview.application.MyApplication
import io.github.peepo3663.housecallprointerview.modules.AppModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent  {
    fun inject(application: MyApplication)
}