package com.safeboda.android.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.safeboda.android.core.utils.ViewModelFactory
import com.safeboda.android.di.scope.ViewModelKey
import com.safeboda.android.viewmodels.SearchActivityViewModel
import com.safeboda.android.viewmodels.UserDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelViewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SearchActivityViewModel::class)
    abstract fun bindSearchViewModel(viewModel: SearchActivityViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(UserDetailViewModel::class)
    abstract fun bindUserDetailViewModel(viewModel: UserDetailViewModel): ViewModel
}