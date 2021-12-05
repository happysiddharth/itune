package com.example.basetemplate.ui.main

import androidx.lifecycle.MutableLiveData
import com.example.basetemplate.data.model.ItuneResponse.Result
import com.example.basetemplate.data.repository.HomeRepository
import com.example.basetemplate.ui.base.BaseViewModel
import com.example.basetemplate.util.log.Logger
import com.mindorks.bootcamp.instagram.utils.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class HomeViewModel (networkHelper: NetworkHelper,
                     val homeRepository: HomeRepository,
                    val compositeDisposable: CompositeDisposable)
    : BaseViewModel(networkHelper,compositeDisposable) {


    val address :MutableLiveData<ArrayList<Result>> = MutableLiveData()
    private val searchObserver :PublishSubject<String> =  PublishSubject.create()

    override fun onCreate() {
        compositeDisposable.addAll(
            searchObserver
                .skip(1)
                .filter {
                    it.isNotEmpty()
                }
                .debounce(500,TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .switchMap {name->
                    homeRepository
                        .getAddresses(name)
                }
                .subscribeOn(Schedulers.io())
                .subscribe ({
                        address.postValue(it as ArrayList<Result>)
                },{
                    Logger.e("Android",it.fillInStackTrace().toString())
                })
        )

    }

    fun pushCity(city:String){
        searchObserver.onNext(city)
    }




}