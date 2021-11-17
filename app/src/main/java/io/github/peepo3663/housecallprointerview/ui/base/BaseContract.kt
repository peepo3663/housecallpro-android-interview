package io.github.peepo3663.housecallprointerview.ui.base

import io.github.peepo3663.housecallprointerview.api.ApiService

class BaseContract {
    interface Presenter<in T> {
        fun subscribe()
        fun unsubscribe()
        fun attach(view: T, api: ApiService)
    }

    interface View { }
}