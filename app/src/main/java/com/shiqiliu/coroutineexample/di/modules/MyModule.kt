package com.shiqiliu.coroutineexample.di.modules

import androidx.lifecycle.ViewModelProvider
import com.shiqiliu.coroutineexample.ui.MovieViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class MyModule {
    @Binds
    abstract fun bindsViewModelFactory(factory: MovieViewModelFactory): ViewModelProvider.Factory

}