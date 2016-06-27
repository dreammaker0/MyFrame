package com.example.lcy.myframe.util;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-6-16.
 */
public class NetworkImageHolderView implements Holder<String> {
    private ImageView mImageView;

    public static NetworkImageHolderView newInstance() {
        return new NetworkImageHolderView();
    }

    @Override
    public View createView(Context context) {
        mImageView = new ImageView(context);
        mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return mImageView;
    }

    @Override
    public void UpdateUI(Context context, int position, String data) {
        ImageManager.getInstance().loadUrlImage(context, data, mImageView);
    }
}
