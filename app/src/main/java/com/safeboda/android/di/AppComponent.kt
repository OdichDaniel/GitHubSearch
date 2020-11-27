package com.safeboda.android.di

import com.safeboda.android.core.di.CoreComponent
import com.safeboda.android.di.modules.ActivityBuildersModule
import com.safeboda.android.di.modules.AppModule
import com.safeboda.android.di.modules.FragmentBuildersModule
import com.safeboda.android.di.modules.ViewModelModule
import com.safeboda.android.di.scope.AppScope
import com.safeboda.android.ui.activities.MainActivity
import com.safeboda.android.ui.activities.SearchActivity
import com.safeboda.android.ui.fragments.FollowersFragment
import dagger.Component
import dagger.android.AndroidInjectionModule

@AppScope
@Component(modules = [AndroidInjectionModule::class, AppModule::class, FragmentBuildersModule::class, ActivityBuildersModule::class, ViewModelModule::class], dependencies = [CoreComponent::class])
interface AppComponent {

    fun inject(searchActivity: SearchActivity)

    fun inject(followersFragment: FollowersFragment)
}