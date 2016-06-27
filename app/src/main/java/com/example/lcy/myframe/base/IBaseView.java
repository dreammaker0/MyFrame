package com.example.lcy.myframe.base;

/**
 * Created by lcy on 2016/2/16.
 */
public interface IBaseView {

    void requestData();

    void showLoading();

    void hideLoading();

    void showProgress();

    void hideProgress();

    void showFailedError(String error);

    void showEmpty();

    void showNetError();
}
