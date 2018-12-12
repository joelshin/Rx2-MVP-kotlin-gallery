package com.joel.archtecture.rxjava.photogallery.ui.photos

import com.joel.archtecture.rxjava.photogallery.data.PhotoData
import com.joel.archtecture.rxjava.photogallery.ui.IView

interface PhotoView: IView {

    fun showAllPosts(photoList: List<PhotoData>)
}