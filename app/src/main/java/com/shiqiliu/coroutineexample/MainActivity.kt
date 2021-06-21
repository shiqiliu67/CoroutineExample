package com.shiqiliu.coroutineexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.shiqiliu.coroutineexample.adapter.MovieAdapter
import com.shiqiliu.coroutineexample.data.model.NowPlayingResult
import com.shiqiliu.coroutineexample.data.responsitory.MovieResponsitory
import com.shiqiliu.coroutineexample.databinding.ActivityMainBinding
import com.shiqiliu.coroutineexample.ui.MovieViewModel
import com.shiqiliu.coroutineexample.ui.MovieViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var movieAdapter: MovieAdapter
    lateinit var mainBinding: ActivityMainBinding
    lateinit var mList:ArrayList<NowPlayingResult>
    lateinit var viewMovieResponsitory: MovieResponsitory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        var view = mainBinding.root
        setContentView(view)
        //adapter
        movieAdapter = MovieAdapter(this)
        recycler_view.adapter = movieAdapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        init()
    }

    private fun init(){
        viewMovieResponsitory = MovieResponsitory()
        var viewModel = ViewModelProvider(this,MovieViewModelFactory(viewMovieResponsitory)).get(MovieViewModel::class.java)
        viewModel.getMoviePlaying().observe(this, Observer {
            it
            Log.d("abc","observe value :$it")
            mList = it.results
            movieAdapter.setData(mList)
        })
    }

}