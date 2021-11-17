package io.github.peepo3663.housecallprointerview.ui.list

import io.github.peepo3663.housecallprointerview.api.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class UserListPresenter: ListContract.Presenter {
    private val subscriptions = CompositeDisposable()
    private lateinit var view: ListContract.View
    private lateinit var api: ApiService

    override fun loadData() {
        val sub = api.getUsersList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({users ->
                view.showProgress(false)
                view.loadUserListDataSuccess(users)
            }, { error ->
                view.showProgress(false)
                view.showErrorMessage(error.localizedMessage)
            })

        subscriptions.add(sub)
    }

    override fun subscribe() {
        // to do: subscribe to outer Disposable??
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: ListContract.View, apiService: ApiService) {
        this.view = view
        this.api = apiService
    }
}