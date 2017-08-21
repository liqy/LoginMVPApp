package com.bwie.loginmvpapp.presenter;

import android.text.TextUtils;

import com.bwie.loginmvpapp.view.LoginMvpView;

/**
 * Created by liqy on 8/21/2017.
 */

public class LoginPresenter implements Presenter<LoginMvpView> {

    LoginMvpView loginMvpView;

    @Override
    public void attachView(LoginMvpView view) {
        loginMvpView = view;
    }


    @Override
    public void detachView() {
        loginMvpView = null;
        //TODO 停止所有异步操作
    }


    public void login(String name,String pwd){
        if (TextUtils.isEmpty(name)){
            loginMvpView.showMessage("请填写用户名");
        }else if (TextUtils.isEmpty(pwd)){
            loginMvpView.showMessage("请填写密码");
        }else {
            loginMvpView.loginOK();
        }
    }

}
