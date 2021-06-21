package com.shiqiliu.coroutineexample.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.shiqiliu.coroutineexample.data.responsitory.MovieResponsitory
import javax.inject.Inject

class MovieViewModelFactory @Inject constructor(val movieResponsitory: MovieResponsitory):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return MovieViewModel(movieResponsitory) as T
    }

}