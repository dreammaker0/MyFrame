package com.example.lcy.myframe.ui.presenter;

import com.example.lcy.myframe.entity.CommonEntity;
import com.example.lcy.myframe.net.ApiFactory;
import com.example.lcy.myframe.ui.view.CommonView;
import com.example.lcy.myframe.util.ToastUtil;
import com.orhanobut.logger.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-6-28.
 */
public class CommonPresenter {

    private CommonView mCommonView;

    public CommonPresenter(CommonView commonView) {
        mCommonView = commonView;
    }

    public void requestData(String type, int pageSize, int pageNo, boolean showDialog) {
        if (showDialog) {
            mCommonView.showProgressDialog();
        }
        Call<CommonEntity> call = ApiFactory.INSTANCE.getAPI().getAndroid(type, pageSize, pageNo);
        call.enqueue(new Callback<CommonEntity>() {
            @Override
            public void onResponse(Call<CommonEntity> call, Response<CommonEntity> response) {
                Logger.e("url =" + call.request().url());
                mCommonView.hideProgressDialog();
                if (response.code() == 200) {
                    if (response.body().isError()) {
                        ToastUtil.showShortToast(response.message());
                    } else {
                        mCommonView.setListData(response.body().getResults());
                    }
                } else {
                        ToastUtil.showShortToast(response.message());
                }
            }

            @Override
            public void onFailure(Call<CommonEntity> call, Throwable t) {
                mCommonView.hideProgressDialog();
                mCommonView.showErrorMsg(t.getMessage());
            }
        });
    }
}
