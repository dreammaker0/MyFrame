package com.example.lcy.myframe.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-6-28.
 */
public abstract class BaseFragment extends Fragment {
    protected Context mContext;
    public View mRootView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView  = inflater.inflate(getContentViewLayoutID(), container, false);
        ButterKnife.bind(this, mRootView);
        initViewsAndEvents(mRootView);
        initDatas();
        return mRootView;
    }
    public View getRootView(){
        return mRootView;
    }

    /**
     * 加载 layout布局
     *
     * @return id of layout resource
     */
    protected abstract int getContentViewLayoutID();

    /**
     * 初始化view
     */
    protected abstract void initViewsAndEvents(View view);

    /**
     * 初始化data
     */
    protected abstract void initDatas();

}
