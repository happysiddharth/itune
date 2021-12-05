package com.example.basetemplate.ui.main.addresses

import com.example.basetemplate.data.model.ItuneResponse
import com.example.basetemplate.ui.base.BaseItemViewModel
import com.mindorks.bootcamp.instagram.utils.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class AddressViewModel @Inject constructor(compositeDisposable: CompositeDisposable,networkHelper: NetworkHelper) :
    BaseItemViewModel<ItuneResponse.Result>(networkHelper,compositeDisposable){
    override fun onCreate() {
    }

}