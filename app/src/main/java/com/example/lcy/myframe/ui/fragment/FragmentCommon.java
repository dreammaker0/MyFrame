package com.example.lcy.myframe.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.lcy.myframe.R;
import com.example.lcy.myframe.base.BaseFragment;
import com.example.lcy.myframe.entity.CommonEntity;
import com.example.lcy.myframe.ui.WebViewActivity;
import com.example.lcy.myframe.ui.adapter.CommonAdapter;
import com.example.lcy.myframe.ui.presenter.CommonPresenter;
import com.example.lcy.myframe.ui.view.CommonView;
import com.example.lcy.myframe.util.ColorUtils;
import com.example.lcy.myframe.util.ToastUtil;
import com.example.lcy.myframe.widget.ShapeLoadingDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 与其憧憬未来，不如把握现在。
 * Created by lcy on 2016-6-28.
 */
public class FragmentCommon extends BaseFragment implements CommonView, SwipeRefreshLayout.OnRefreshListener,
        BaseQuickAdapter.OnRecyclerViewItemClickListener {
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    private CommonPresenter mPresenter;

    private String mType;

    public static final int PAGE_SIZE = 10;

    private List<CommonEntity.ResultsBean> mDatas = new ArrayList<>();

    private ShapeLoadingDialog mShapeLoadingDialog;

    private CommonAdapter mCommonAdapter;

    public static FragmentCommon newInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        FragmentCommon fragmentCommon = new FragmentCommon();
        fragmentCommon.setArguments(bundle);
        return fragmentCommon;
    }

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.fragment_common;
    }

    @Override
    protected void initViewsAndEvents(View view) {
        mShapeLoadingDialog = new ShapeLoadingDialog(getContext());
        mShapeLoadingDialog.setLoadingText("加载中...");
        mPresenter= new CommonPresenter(this);
        mSwipeRefreshLayout.setColorSchemeColors(ColorUtils.randomColor(),
                ColorUtils.randomColor(),
                ColorUtils.randomColor(),
                ColorUtils.randomColor());
        //mSwipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE);
        //swipeRefreshLayout.setPadding(20, 20, 20, 20);
        //swipeRefreshLayout.setProgressViewOffset(true, 100, 200);
        //swipeRefreshLayout.setDistanceToTriggerSync(50);
        //mSwipeRefreshLayout.setProgressViewEndTarget(true, 100);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mCommonAdapter = new CommonAdapter(R.layout.item_common, mDatas);
        mRecyclerView.setAdapter(mCommonAdapter);
        mCommonAdapter.setOnRecyclerViewItemClickListener(this);
    }

    @Override
    protected void initDatas() {
        mType = getArguments().getString("type");
        mPresenter.requestData(mType, PAGE_SIZE, 1);

    }

    @Override
    public void setListData(List<CommonEntity.ResultsBean> results) {
        mCommonAdapter.notifyDataChangedAfterLoadMore(results, true);
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void showProgressDialog() {
        mShapeLoadingDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        mShapeLoadingDialog.dismiss();
    }

    @Override
    public void showErrorMsg(String msg) {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
        ToastUtil.showShortToast(msg);
    }

    @Override
    public void onRefresh() {
        mDatas.clear();
        mPresenter.requestData(mType, PAGE_SIZE, 1);
    }

    @Override
    public void onItemClick(View view, int i) {
        Intent intent = new Intent(mContext, WebViewActivity.class);
        intent.putExtra("url", mDatas.get(i).getUrl());
        intent.putExtra("title", mType);
        mContext.startActivity(intent);
    }
}
