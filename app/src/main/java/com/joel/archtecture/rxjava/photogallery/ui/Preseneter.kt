package com.joel.archtecture.rxjava.photogallery.ui

import android.support.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


/*
 Primary Constructor Variables and their purpose

@Volatile var view: V
Volatile make sure the variable can  be accessed cross different threads

*/

open class Preseneter<V>(@Volatile var view: V? ){


    companion object {

        /*
        모든 Presenter 레이어의 메소드는 CompositeDisposable 클래스의 일부로 존재하게 되므로, 더이상 사요하지 않을시에
        한번에 dispose 할수(날려버릴 수) 있음

        */
        var compositeDisposables: CompositeDisposable=CompositeDisposable()

    }


    init {


    }


    protected fun view(): V? {
        return view
    }

    @CallSuper
    fun unbindView() {
        if (compositeDisposables != null) {
            compositeDisposables.clear()
            compositeDisposables.dispose()
        }
        this.view = null
    }

    fun addDisposable(disposable: Disposable) {
        compositeDisposables.add(disposable)
    }


}