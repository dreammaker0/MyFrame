package com.example.lcy.myframe.ui.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lcy.myframe.R;
import com.example.lcy.myframe.entity.CommonEntity;
import com.example.lcy.myframe.util.ColorUtils;
import com.example.lcy.myframe.util.ImageManager;

import java.util.List;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-6-29.
 */
public class CommonAdapter extends BaseMultiItemQuickAdapter<CommonEntity.ResultsBean> {
    public static final int TEXT = 1;
    public static final int IMG = 2;

    public CommonAdapter(List<CommonEntity.ResultsBean> data) {
        super(data);
        addItemType(TEXT, R.layout.item_common);
        addItemType(IMG, R.layout.item_pictures);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, CommonEntity.ResultsBean resultsBean) {

        switch (baseViewHolder.getItemViewType()) {
            case TEXT:
                baseViewHolder.setText(R.id.tv_title, resultsBean.getDesc())
                        .setText(R.id.tv_type, resultsBean.getType())
                        .setTextColor(R.id.tv_type, ColorUtils.randomColor())
                        //.linkify(R.id.tv_title)
                        .setText(R.id.tv_date, resultsBean.getPublishedAt())
                        .setText(R.id.tv_author, resultsBean.getWho());
                break;
            case IMG:
                ImageManager.getInstance().loadUrlImage(mContext, resultsBean.getUrl(), (ImageView) baseViewHolder.getView(R.id.imageView));
                break;
        }
    }
}
