package com.joel.archtecture.rxjava.photogallery.di.component

import com.joel.archtecture.rxjava.photogallery.ApplicationClass
import com.joel.archtecture.rxjava.photogallery.di.module.AppModule
import com.joel.archtecture.rxjava.photogallery.di.module.NetModule
import com.joel.archtecture.rxjava.photogallery.ui.login.LoginPresenterImpl
import com.joel.archtecture.rxjava.photogallery.ui.photos.PhotosPresenterImpl
import dagger.Component

@Component(modules = [AppModule::class, NetModule::class])
interface ApplicationComponent {

    fun inject(mewApplication: ApplicationClass)
    fun inject(mLoginPresenterImpl: LoginPresenterImpl)
    fun inject(mPostPresenterImpl: PhotosPresenterImpl)

}