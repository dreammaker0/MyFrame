package com.example.lcy.myframe.ui.adapter;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lcy.myframe.R;
import com.example.lcy.myframe.entity.CommonEntity;
import com.example.lcy.myframe.util.ImageManager;

import java.util.List;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-6-29.
 */
public class PicturesAdapter extends BaseQuickAdapter<CommonEntity.ResultsBean> {


    public PicturesAdapter(View contentView, List<CommonEntity.ResultsBean> data) {
        super(contentView, data);
    }

    public PicturesAdapter(List<CommonEntity.ResultsBean> data) {
        super(data);
    }

    public PicturesAdapter(int layoutResId, List<CommonEntity.ResultsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, CommonEntity.ResultsBean resultsBean) {
        ImageManager.getInstance().loadUrlImage(mContext, resultsBean.getUrl(), (ImageView) baseViewHolder.getView(R.id.imageView));
    }

}
