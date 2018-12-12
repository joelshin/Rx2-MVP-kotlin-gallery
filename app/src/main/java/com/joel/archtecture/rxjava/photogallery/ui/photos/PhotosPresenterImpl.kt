package com.joel.archtecture.rxjava.photogallery.ui.photos

import android.app.Application
import com.joel.archtecture.rxjava.photogallery.ApplicationClass
import com.joel.archtecture.rxjava.photogallery.network.INetworkApi
import com.joel.archtecture.rxjava.photogallery.ui.Preseneter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import javax.inject.Inject

class PhotosPresenterImpl(var postView: PhotoView, var applicationComponent: Application) : PhotosPresenter, Preseneter<PhotoView>(postView) {

    @Inject
    lateinit var mNetworkApi: INetworkApi

    init {
        (applicationComponent as ApplicationClass).applicationComponent.inject(this)
    }

    override fun getAllPosts() {


        var view=view()

        view?.let {
           // it.showLoading()
            var allPosts = mNetworkApi.getAllPosts()
            addDisposable(allPosts.subscribeOn(IoScheduler()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            { result ->
                                view?.let {
                                    it.hideLoading()
                                    postView.showAllPosts(result)

                                }
                            },
                            { error ->
                                view?.let {
                                  //  it.hideLoading()
                                }
                            }
                    ) ) }

        var allPosts = mNetworkApi.getAllPosts()
        allPosts.subscribeOn(IoScheduler()).observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    postView.showAllPosts(it)
                }

    }


}