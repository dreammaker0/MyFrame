package com.example.lcy.myframe.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.lcy.myframe.R;
import com.example.lcy.myframe.base.BaseFragment;
import com.example.lcy.myframe.entity.CommonEntity;
import com.example.lcy.myframe.ui.MainActivity;
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
        BaseQuickAdapter.OnRecyclerViewItemClickListener, BaseQuickAdapter.RequestLoadMoreListener {
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

    private int mCurrentCounter = 0;

    private int mPageNo = 1;

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
        mPresenter = new CommonPresenter(this);
        mSwipeRefreshLayout.setColorSchemeColors(ColorUtils.randomColor(),
                ColorUtils.randomColor(),
                ColorUtils.randomColor(),
                ColorUtils.randomColor());
        mSwipeRefreshLayout.setOnRefreshListener(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mCommonAdapter = new CommonAdapter(mDatas);
        mRecyclerView.setAdapter(mCommonAdapter);
        mCommonAdapter.setOnRecyclerViewItemClickListener(this);
        mCommonAdapter.setOnLoadMoreListener(this);
        mCurrentCounter = mCommonAdapter.getData().size();
        mCommonAdapter.openLoadMore(PAGE_SIZE, true);

        View customLoading = LayoutInflater.from(mContext).inflate(R.layout.custom_loading, (ViewGroup) mRecyclerView.getParent(), false);
        mCommonAdapter.setLoadingView(customLoading);

        ((MainActivity) mContext).findViewById(R.id.toolBar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecyclerView.smoothScrollToPosition(0);
            }
        });
    }

    @Override
    protected void initDatas() {
        mType = getArguments().getString("type");
        mPresenter.requestData(mType, PAGE_SIZE, 1, true);

    }

    @Override
    public void setListData(List<CommonEntity.ResultsBean> results) {
        for (CommonEntity.ResultsBean resultsBean : results) {
            if (TextUtils.equals("福利", resultsBean.getType())) {
                resultsBean.setItemType(CommonAdapter.IMG);
            } else {
                resultsBean.setItemType(CommonAdapter.TEXT);
            }
        }
        if (mPageNo == 1) {// 刷新的
            mDatas.clear();
            if (mSwipeRefreshLayout.isRefreshing()) {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }
        mCommonAdapter.notifyDataChangedAfterLoadMore(results, true);

    }

    @Override
    public void showProgressDialog() {
        mShapeLoadingDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        if (mShapeLoadingDialog != null && mShapeLoadingDialog.isShowing()) {
            mShapeLoadingDialog.dismiss();
        }
    }

    @Override
    public void showErrorMsg(String msg) {
        if (mSwipeRefreshLayout.isRefreshing()) {
            mSwipeRefreshLayout.setRefreshing(false);
        }
        mCommonAdapter.notifyDataChangedAfterLoadMore(new ArrayList<CommonEntity.ResultsBean>(), true);
        ToastUtil.showShortToast(msg);
    }

    @Override
    public void onRefresh() {
        mPageNo = 1;
        mPresenter.requestData(mType, PAGE_SIZE, 1, false);

    }

    @Override
    public void onItemClick(View view, int i) {
        Intent intent = new Intent(mContext, WebViewActivity.class);
        intent.putExtra("url", mDatas.get(i).getUrl());
        intent.putExtra("title", mType);
        startActivity(intent);
    }

    @Override
    public void onLoadMoreRequested() {
        mCurrentCounter = mCommonAdapter.getData().size();
        mPageNo = Math.ceil(mCurrentCounter / PAGE_SIZE) == 0 ? 1 : (int) Math.ceil(mCurrentCounter / PAGE_SIZE);
        mPresenter.requestData(mType, PAGE_SIZE, ++mPageNo, false);
    }
}
