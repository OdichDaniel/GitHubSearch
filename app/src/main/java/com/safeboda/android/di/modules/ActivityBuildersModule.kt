package com.safeboda.android.di.modules

import com.safeboda.android.ui.activities.SearchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributesSearchActivity(): SearchActivity
}