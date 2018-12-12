package com.joel.archtecture.rxjava.photogallery.ui.login

import com.joel.archtecture.rxjava.photogallery.ui.IView

interface LoginView: IView {

    fun navigateToHome()

    fun onBackPress()

    fun onPasswordError()
}