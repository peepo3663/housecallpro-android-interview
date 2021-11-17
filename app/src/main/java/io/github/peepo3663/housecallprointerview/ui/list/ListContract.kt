package io.github.peepo3663.housecallprointerview.ui.list

import io.github.peepo3663.housecallprointerview.api.ApiService
import io.github.peepo3663.housecallprointerview.models.User
import io.github.peepo3663.housecallprointerview.ui.base.BaseContract

class ListContract {
    interface View: BaseContract.View {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String?)
        fun loadUserListDataSuccess(users: List<User>)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun loadData()
    }
}