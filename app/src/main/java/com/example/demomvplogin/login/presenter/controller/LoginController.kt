package com.example.demomvplogin.login.presenter.controller


import com.example.demomvplogin.login.thread.ThreadUtil

object LoginController {

    interface LoginControllerDeglate {
        fun onSuccess(response : String)
        fun onFail()
    }

    fun requestLogin(id:String, password:String, deglate: LoginControllerDeglate) {

        ThreadUtil.startThread {
            Thread.sleep(3000)

            deglate.onSuccess("Response from server, user info is a jsonObjectString, you need parsing it.")
        }
    }
}