package com.safeboda.android.di

import com.safeboda.android.core.di.CoreComponent
import com.safeboda.android.di.modules.ActivityBuildersModule
import com.safeboda.android.di.modules.AppModule
import com.safeboda.android.di.modules.ViewModelModule
import com.safeboda.android.di.scope.TestScope
import com.safeboda.android.search.Base
import dagger.Component
import dagger.android.AndroidInjectionModule

@TestScope
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuildersModule::class, ViewModelModule::class], dependencies = [CoreComponent::class])
interface TestComponent {

    fun inject(base: Base)
}