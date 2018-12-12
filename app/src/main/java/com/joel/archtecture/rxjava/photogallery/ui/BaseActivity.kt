package com.joel.archtecture.rxjava.photogallery.ui

import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.widget.Toast


abstract class BaseActivity : AppCompatActivity(), IView {


    protected var mProgressDialog: ProgressDialog?=null

    companion object {
        const val IMAGE_TRANSITION_NAME = "activity_image_transition"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
        initialzeProgressDialoge()
        init(savedInstanceState)

    }

    fun initialzeProgressDialoge(){

        if(mProgressDialog==null) {

            mProgressDialog = ProgressDialog(this)
            mProgressDialog!!.isIndeterminate = true
            mProgressDialog!!.setCancelable(false)
        }

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        System.gc()
        System.runFinalization()
        dismissProgress()
        mProgressDialog=null
    }



    @LayoutRes
    abstract fun setLayout():Int
    abstract fun init(savedInstanceState: Bundle?)
    abstract fun onStartScreen()
    abstract fun stopScreen()


    fun showProgress(msgResId: Int,
                     keyListener: DialogInterface.OnKeyListener?) {
        if (isFinishing)
            return

        if (mProgressDialog!!.isShowing) {
            return
        }

        if (msgResId != 0) {
            mProgressDialog?.setMessage(resources.getString(msgResId))
        }

        if (keyListener != null) {
            mProgressDialog?.setOnKeyListener(keyListener)

        } else {
            mProgressDialog?.setCancelable(false)
        }
        mProgressDialog?.show()
    }

    /**
     * @param isCancel
     */
    fun setCancelableProgress(isCancel: Boolean) {
        if (mProgressDialog != null) {
            mProgressDialog?.setCancelable(true)
        }
    }

    /**
     * cancel progress dialog.
     */
    fun dismissProgress() {
        if (mProgressDialog != null && mProgressDialog!!.isShowing) {
            mProgressDialog?.dismiss()
        }
    }


    override fun hideLoading() {
        dismissProgress()
    }

    override fun showLoading() {
    //    showProgress(R.string.loading, null)
    }

    override fun loadError(e: Throwable) {
        showHttpError(e)
    }

    override fun loadError(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
    }


    protected fun showHttpError(e: Throwable) {
      loadError(e.localizedMessage)
    }

    override fun onStop() {
        super.onStop()
        stopScreen()
    }



}