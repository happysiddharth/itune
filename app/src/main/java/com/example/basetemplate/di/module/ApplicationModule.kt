package com.example.basetemplate.di.module

import com.example.basetemplate.MyApplication
import com.example.basetemplate.data.remote.NetworkService
import com.example.basetemplate.data.remote.Networking
import com.example.basetemplate.di.ApplicationScope
import com.example.basetemplate.di.Qualifiers
import com.example.basetemplate.util.common.Permissions
import com.mindorks.bootcamp.instagram.utils.network.NetworkHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

@Module
class ApplicationModule(private val application:MyApplication) {

    @ApplicationScope
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)

    @ApplicationScope
    @Provides
    fun provideNetworkService():NetworkService =
        Networking.create("",baseURl(),application.cacheDir,50000)


    @ApplicationScope
    fun baseURl():String = "https://itunes.apple.com/"

    @ApplicationScope
    @Qualifiers
    fun dbName():String = ""


    @ApplicationScope
    @Provides
    fun permissions(): Permissions{
        return Permissions
    }

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()







}