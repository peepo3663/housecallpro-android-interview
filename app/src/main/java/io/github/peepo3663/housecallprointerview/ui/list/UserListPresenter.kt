package io.github.peepo3663.housecallprointerview.ui.list

import javax.inject.Inject

class UserListPresenter: ListContract.Presenter {
    private lateinit var view: ListContract.View
    override fun loadData() {
        TODO("Not yet implemented")
    }

    override fun subscribe() {
        TODO("Not yet implemented")
    }

    override fun unsubscribe() {
        TODO("Not yet implemented")
    }

    override fun attach(view: ListContract.View) {
        this.view = view
    }
}