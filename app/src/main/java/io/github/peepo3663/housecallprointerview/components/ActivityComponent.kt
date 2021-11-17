package io.github.peepo3663.housecallprointerview.components

import dagger.Component
import io.github.peepo3663.housecallprointerview.modules.ActivityModule
import io.github.peepo3663.housecallprointerview.modules.NetworkModule
import io.github.peepo3663.housecallprointerview.ui.main.MainActivity

@Component(modules = [ActivityModule::class, NetworkModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}