package com.safeboda.android.di.modules

import com.safeboda.android.ui.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributesMainActivity(): MainActivity
}