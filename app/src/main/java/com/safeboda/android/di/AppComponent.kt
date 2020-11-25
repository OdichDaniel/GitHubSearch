package com.safeboda.android.di

import com.safeboda.android.core.di.CoreComponent
import com.safeboda.android.di.modules.ActivityBuildersModule
import com.safeboda.android.di.modules.ViewModelModule
import com.safeboda.android.di.scope.AppScope
import com.safeboda.android.ui.activities.MainActivity
import dagger.Component
import dagger.android.AndroidInjectionModule

@AppScope
@Component(modules = [AndroidInjectionModule::class, ActivityBuildersModule::class, ViewModelModule::class], dependencies = [CoreComponent::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}