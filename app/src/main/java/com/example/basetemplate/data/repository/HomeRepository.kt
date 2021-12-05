package com.example.basetemplate.data.repository

import android.annotation.SuppressLint
import com.example.basetemplate.data.model.ItuneResponse.Result
import com.example.basetemplate.data.remote.NetworkService
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class HomeRepository @Inject constructor(val networkService: NetworkService) {

    @SuppressLint("CheckResult")
    fun getAddresses(title:String): Observable<List<Result>> {
        val observable = Observable.create<List<Result>> { emitter ->
            networkService
                .getAddress(title)
                .map {
                    it.results
                }
                .subscribeOn(Schedulers.io())
                .subscribe({
                    emitter.onNext(it)
                }, {

                })
        }
        return observable

    }
}