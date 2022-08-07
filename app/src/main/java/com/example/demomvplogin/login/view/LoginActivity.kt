package com.example.demomvplogin.login.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import com.example.demomvplogin.R
import com.example.demomvplogin.login.presenter.ILoginPresenter
import com.example.demomvplogin.login.presenter.LoginPresenter

class LoginActivity : AppCompatActivity(), ILoginView {
    private lateinit var tvLoginResult: TextView
    private lateinit var btnLogin: Button
    private lateinit var edtUserName : EditText
    private lateinit var edtPassWord : EditText
    private lateinit var frameLayoutProgress: FrameLayout

    lateinit var iLoginPresenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initPresenter()
        findView()
        setListener()
    }

    private fun initPresenter() {
        iLoginPresenter = LoginPresenter(iLoginView = this)
    }

    private fun findView() {
        tvLoginResult = findViewById(R.id.tvLoginResult)
        btnLogin = findViewById(R.id.btnLogin)
        edtUserName = findViewById(R.id.edtUsername)
        edtPassWord = findViewById(R.id.edtPassword)
        frameLayoutProgress = findViewById(R.id.framelayoutProgress)

    }

    private fun setListener() {
        btnLogin.setOnClickListener {
            iLoginPresenter.login(id = edtUserName.text.toString().trim(), password = edtPassWord.text.toString().trim())
        }

    }

    override fun onClear() {
        edtUserName.setText("")
        edtPassWord.setText("")
    }

    override fun onShowProgress() {
        frameLayoutProgress.visibility = View.VISIBLE
    }

    override fun onHideProgress() {
        frameLayoutProgress.visibility = View.GONE
    }

    override fun onUpdateLoginResultInfo(nickname: String, age: Int) {
        tvLoginResult.text = "Nickname: $nickname, age: $age"
    }
}

