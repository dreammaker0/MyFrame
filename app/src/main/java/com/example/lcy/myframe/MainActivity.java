package com.example.lcy.myframe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.example.lcy.myframe.base.BaseAppCompatActivity;
import com.example.lcy.myframe.callback.DialogCallback;
import com.example.lcy.myframe.util.ImageManager;
import com.example.lcy.myframe.util.NetworkImageHolderView;
import com.example.lcy.myframe.view.MarqueeView;
import com.lzy.okhttputils.OkHttpUtils;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends BaseAppCompatActivity {


    /**
     * 包结构
     * com.futurice.project
     ├─ network
     ├─ models
     ├─ managers
     ├─ utils
     ├─ fragments
     └─ views
        ├─ adapters
        ├─ actionbar
        ├─ widgets
        └─ notifications
     */

    @BindView(R.id.image)
    ImageView mImageView;

    @BindView(R.id.convenientBanner)
    ConvenientBanner mBanner;

    private List<String> mUrls = new ArrayList<>();

    private int[] mIndicators = new int[]{R.mipmap.ic_page_indicator, R.mipmap.ic_page_indicator_focused};

    @Override
    protected void getBundleExtras(Bundle extras) {

    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViewsAndEvents() {
        ImageManager.getInstance().loadRoundImage(this, "http://e.hiphotos.baidu.com/zhidao/pic/item/314e251f95cad1c8233cf9167a3e6709c93d517f.jpg", mImageView);
        MarqueeView marqueeView = (MarqueeView) findViewById(R.id.marqueeView);
        marqueeView.startWithList(mUrls);

        mBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return NetworkImageHolderView.newInstance();
            }
        }, mUrls)
                .setPageIndicator(mIndicators)
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Logger.e(position + "");
                    }
                });

    }

    @Override
    protected void initDatas() {
        mUrls.add("http://e.hiphotos.baidu.com/zhidao/pic/item/314e251f95cad1c8233cf9167a3e6709c93d517f.jpg");
        mUrls.add("http://img2.imgtn.bdimg.com/it/u=96448386,3373724456&fm=21&gp=0.jpg");
        mUrls.add("http://img4.duitang.com/uploads/item/201309/08/20130908105107_JGeJe.thumb.600_0.jpeg");
        mUrls.add("http://img2.imgtn.bdimg.com/it/u=4136880442,2080285592&fm=21&gp=0.jpg");
        mUrls.add("http://img0.imgtn.bdimg.com/it/u=3559894347,2039663083&fm=21&gp=0.jpg");
        mUrls.add("http://img2.imgtn.bdimg.com/it/u=1564408545,3521311227&fm=21&gp=0.jpg");

        OkHttpUtils.post("http://www.baidu.com")//
                .tag(this)//
                .headers("header1", "headerValue1")//
                .headers("header2", "headerValue2")//
                .params("param1", "paramValue1")//
                .params("param2", "paramValue2")//
                .execute(new DialogCallback<String>(MainActivity.this, MainActivity.class) {

                    @Override
                    public void onResponse(boolean isFromCache, String s, Request request, @Nullable Response response) {

                    }
                });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBanner.startTurning(3000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBanner.stopTurning();
    }
}
