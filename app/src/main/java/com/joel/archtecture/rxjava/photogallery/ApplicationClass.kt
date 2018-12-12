package com.joel.archtecture.rxjava.photogallery

import android.app.Application
import com.joel.archtecture.rxjava.photogallery.di.component.ApplicationComponent
import com.joel.archtecture.rxjava.photogallery.di.component.DaggerApplicationComponent
import com.joel.archtecture.rxjava.photogallery.di.module.NetModule

open class ApplicationClass : Application() {


    public lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .netModule(NetModule())
                .build()

        applicationComponent.inject(this)
    }
}