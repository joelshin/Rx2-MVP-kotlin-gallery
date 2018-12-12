package com.joel.archtecture.rxjava.photogallery.ui.login

import android.os.Bundle
import android.widget.Toast
import com.joel.archtecture.rxjava.photogallery.ui.BaseActivity

import com.joel.archtecture.rxjava.photogallery.R;


class LoginActivity : BaseActivity(), LoginView {

    var loginPresenter: LoginPresenterImpl?=null

    override fun setLayout(): Int {
       return  R.layout.activity_login
    }


    override fun init(savedInstanceState: Bundle?) {
        getPresenter()?.let {
            it.validateUser("hammad", "")
        }
    }


    fun getPresenter(): LoginPresenterImpl?{
       loginPresenter = LoginPresenterImpl(this, application)
        return loginPresenter
    }


    override fun onStartScreen() {

    }

    override fun stopScreen() {
        loginPresenter?.let {
            loginPresenter!!.unbindView()
            loginPresenter = null
        }
     }


    override fun onPasswordError() {

    }

    override fun onBackPress() {
    }

    override fun navigateToHome() {
        Toast.makeText(this, "Hello MVP", Toast.LENGTH_SHORT).show()
    }

}
