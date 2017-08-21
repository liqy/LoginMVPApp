package com.bwie.loginmvpapp.presenter;

/**
 * Created by liqy on 8/21/2017.
 */

public interface Presenter<T> {

    void attachView(T view);

    void detachView();
}
