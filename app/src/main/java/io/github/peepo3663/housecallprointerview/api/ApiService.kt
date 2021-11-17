package io.github.peepo3663.housecallprointerview.api

import io.github.peepo3663.housecallprointerview.models.User
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUsersList(): Observable<List<User>>
}