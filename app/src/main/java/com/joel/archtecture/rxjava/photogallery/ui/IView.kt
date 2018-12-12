package com.joel.archtecture.rxjava.photogallery.ui

interface IView{

    abstract fun showLoading()

    abstract fun hideLoading()

    abstract fun loadError(e: Throwable)

    abstract fun loadError(msg: String)


}