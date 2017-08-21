package com.bwie.loginmvpapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.loginmvpapp.presenter.LoginPresenter;
import com.bwie.loginmvpapp.view.LoginMvpView;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginMvpView {


    @BindView(R.id.edit_user_name)
    EditText userName;
    @BindView(R.id.edit_user_pwd)
    EditText usePwd;
    @BindView(R.id.btn_login)
    Button btn_login;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter = new LoginPresenter();
        loginPresenter.attachView(this);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_login)
    public void login(View view) {
        String name = userName.getText().toString();
        String pwd = usePwd.getText().toString();
        loginPresenter.login(name, pwd);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void loginOK() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detachView();
    }
}
