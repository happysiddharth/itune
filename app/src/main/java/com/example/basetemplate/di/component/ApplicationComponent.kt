package com.example.basetemplate.di.component

import com.example.basetemplate.data.remote.NetworkService
import com.example.basetemplate.di.ApplicationScope
import com.example.basetemplate.di.module.ApplicationModule
import com.example.basetemplate.util.common.Permissions
import com.mindorks.bootcamp.instagram.utils.network.NetworkHelper
import dagger.Component
import io.reactivex.disposables.CompositeDisposable


@ApplicationScope
@Component(
    modules = [
        ApplicationModule::class
    ]
)
interface ApplicationComponent {
    fun getNetworkHelper(): NetworkHelper
    fun getNetworkService(): NetworkService
    fun getPermissions(): Permissions
    fun getCompositeDisposable(): CompositeDisposable

}