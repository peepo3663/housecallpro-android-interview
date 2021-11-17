package io.github.peepo3663.housecallprointerview.modules

import dagger.Module
import dagger.Provides
import io.github.peepo3663.housecallprointerview.api.ApiService
import io.github.peepo3663.housecallprointerview.ui.list.ListContract
import io.github.peepo3663.housecallprointerview.ui.list.UserListPresenter
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class FragmentModule {
    @Provides
    fun provideUserListPresenter(): ListContract.Presenter {
        return UserListPresenter()
    }
}