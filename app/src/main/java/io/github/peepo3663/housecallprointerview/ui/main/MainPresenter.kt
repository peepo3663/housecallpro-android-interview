package io.github.peepo3663.housecallprointerview.ui.main

import io.reactivex.disposables.CompositeDisposable

class MainPresenter: MainContract.Presenter {
    private val subscriptions = CompositeDisposable()
    private lateinit var view: MainContract.View

    override fun onDrawerOptionClick() {
    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: MainContract.View) {
        this.view = view
        view.showUserListFragment()
    }
}