package io.github.peepo3663.housecallprointerview.modules

import dagger.Module
import dagger.Provides
import io.github.peepo3663.housecallprointerview.ui.list.ListContract
import io.github.peepo3663.housecallprointerview.ui.list.UserListPresenter

@Module
class FragmentModule {
    @Provides
    fun provideUserListPresenter(): ListContract.Presenter {
        return UserListPresenter()
    }
}