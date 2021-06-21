package com.shiqiliu.coroutineexample.data.responsitory

import com.shiqiliu.coroutineexample.data.network.ApiService

class MovieResponsitory (){
 suspend fun getPlayingMovie() = ApiService.invoke().getPlayingMovie()
}