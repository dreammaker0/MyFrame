package com.example.lcy.myframe.base;

import com.example.lcy.myframe.entity.CommonEntity;

import java.util.List;

/**
 * Created by lcy on 2016/2/16.
 */
public interface IBaseView {

    void setListData(List<CommonEntity.ResultsBean> results);

    void showProgressDialog();

    void hideProgressDialog();

    void showErrorMsg(String msg);

    /*void showProgress();

    void hideProgress();

    void showFailedError(String error);

    void showEmpty();

    void showNetError();*/
}
