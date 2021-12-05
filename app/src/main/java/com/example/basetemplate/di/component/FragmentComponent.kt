package com.example.basetemplate.di.component

import com.example.basetemplate.di.FragmentScope
import com.example.basetemplate.di.module.FragmentModule
import dagger.Component

@FragmentScope
@Component(
    modules = [
        FragmentModule::class,
    ],
    dependencies = [
        ApplicationComponent::class,
    ]
)
interface FragmentComponent {
}