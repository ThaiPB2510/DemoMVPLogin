package com.example.demomvplogin.login.view

interface ILoginView {
    fun onClear()
    fun onShowProgress()
    fun onHideProgress()
    fun onUpdateLoginResultInfo(nickname:String, age : Int)
}