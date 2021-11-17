package io.github.peepo3663.housecallprointerview.components

import dagger.Component
import io.github.peepo3663.housecallprointerview.modules.FragmentModule
import io.github.peepo3663.housecallprointerview.ui.list.UserListFragment

@Component(modules = [FragmentModule::class])
interface FragmentComponent {
    fun inject(userListFragment: UserListFragment)
}