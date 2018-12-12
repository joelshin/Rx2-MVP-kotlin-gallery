package com.joel.archtecture.rxjava.photogallery.network

import com.joel.archtecture.rxjava.photogallery.data.PhotoData
import io.reactivex.Observable
import retrofit2.http.GET

interface INetworkApi {

    @GET(Endpoints.photos)
    fun getAllPosts(): Observable<List<PhotoData>>
}