package io.github.peepo3663.housecallprointerview.ui.main

import io.github.peepo3663.housecallprointerview.ui.base.BaseContract

class MainContract {
    interface View: BaseContract.View {
        fun showUserListFragment()
    }

    interface Presenter: BaseContract.Presenter<MainContract.View> {
        fun onDrawerOptionClick()
    }
}