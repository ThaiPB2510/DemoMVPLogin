package com.example.demomvplogin.login.presenter

import android.util.Log
import com.example.demomvplogin.login.model.UserModelInfo
import com.example.demomvplogin.login.presenter.controller.LoginController
import com.example.demomvplogin.login.thread.ThreadUtil
import com.example.demomvplogin.login.view.ILoginView

class LoginPresenter (var iLoginView: ILoginView):ILoginPresenter {
    override fun clear() {
        iLoginView.onClear()
    }

    override fun showProgress() {
        iLoginView.onShowProgress()
    }

    override fun hideProgress() {
        iLoginView.onHideProgress()
    }

    override fun login(id: String, password: String) {
        clear()
        showProgress()
        LoginController.requestLogin(id = id, password = password, object :LoginController.LoginControllerDeglate{
            override fun onSuccess(response: String) {
                Log.d("???", "onSuccess $response")

                val userModelInfo = UserModelInfo()
                userModelInfo.nickname = "Vincenzo"
                userModelInfo.age = 22

                ThreadUtil.startUIThread(0) {
                    hideProgress()
                    iLoginView.onUpdateLoginResultInfo(nickname = userModelInfo.nickname, age = userModelInfo.age)

                }
            }

            override fun onFail() {
                Log.d("???", "onFailed")

                hideProgress()
            }
        })
    }
}