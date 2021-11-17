package io.github.peepo3663.housecallprointerview.modules

import android.app.Activity
import dagger.Module
import dagger.Provides
import io.github.peepo3663.housecallprointerview.ui.main.MainContract
import io.github.peepo3663.housecallprointerview.ui.main.MainPresenter

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }
}