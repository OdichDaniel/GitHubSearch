package com.safeboda.android.di.modules

import com.safeboda.android.ui.fragments.FollowersFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class])
    abstract fun contributeFollowersFragment(): FollowersFragment
}