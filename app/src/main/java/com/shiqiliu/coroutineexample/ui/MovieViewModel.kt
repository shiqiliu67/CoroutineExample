package com.shiqiliu.coroutineexample.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shiqiliu.coroutineexample.data.model.NowPlayingResponse
import com.shiqiliu.coroutineexample.data.responsitory.MovieResponsitory
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

class MovieViewModel @Inject constructor(var movieResponsitory: MovieResponsitory):ViewModel(){
    val playingMovieResonse = MutableLiveData<NowPlayingResponse>()
    val msg = MutableLiveData<String>()

    //coroutine
    fun getMoviePlaying():MutableLiveData<NowPlayingResponse>{
      viewModelScope.launch(IO) {
         try {
             val response = movieResponsitory.getPlayingMovie()
            // val response = ApiService.invoke().getPlayingMovie()
             if (response.isSuccessful) {
                playingMovieResonse.postValue(response.body())
                 Log.d("abc","Load data successful! data is ${response.body()}")
             } else {
                 msg.postValue("Error data")
                 Log.d("abc","error here")
             }
         }
         catch (e:Exception){
             Log.d("abc","exception here $e")
         }
      }
        return playingMovieResonse
    }
}