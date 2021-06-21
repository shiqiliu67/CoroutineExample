package com.shiqiliu.coroutineexample.di.components

import android.app.Activity
import com.shiqiliu.coroutineexample.di.modules.MyModule
import dagger.Component

@Component(modules = [MyModule::class])
interface MyComponent {
    fun inject(activity: Activity)
}