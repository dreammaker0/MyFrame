package com.example.lcy.myframe.ui.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lcy.myframe.R;
import com.example.lcy.myframe.entity.CommonEntity;

import java.util.List;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-6-29.
 */
public class CommonAdapter extends BaseQuickAdapter<CommonEntity.ResultsBean> {


    public CommonAdapter(View contentView, List<CommonEntity.ResultsBean> data) {
        super(contentView, data);
    }

    public CommonAdapter(List<CommonEntity.ResultsBean> data) {
        super(data);
    }

    public CommonAdapter(int layoutResId, List<CommonEntity.ResultsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, CommonEntity.ResultsBean resultsBean) {
        baseViewHolder.setText(R.id.tv_title, resultsBean.getDesc())
                      //.linkify(R.id.tv_title)
                      .setText(R.id.tv_date, resultsBean.getPublishedAt())
                      .setText(R.id.tv_author, resultsBean.getWho());
    }

}
