package com.tlh.electricsystem.base.base;

import android.app.Activity;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tlh.electricsystem.base.R;
import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * Created by Administrator on 2018/9/27 0027.
 */

public abstract class BaseFragment<V extends ViewDataBinding, VM extends BaseViewModel> extends RxFragment implements IBaseActivity {

    protected V mBinding;
    protected VM mViewModel;
    protected Activity m_Activity;
    protected int BR_ID;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        m_Activity = activity;
    }

    @Override
    public void initParam() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParam();

    }

    /**
     * 注入绑定
     */
    private void initViewDataBinding(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //DataBindingUtil类需要在project的build中配置 dataBinding {enabled true }, 同步后会自动关联android.databinding包
        mBinding = DataBindingUtil.inflate(inflater, initContentView(inflater, container, savedInstanceState), container, false);
        BR_ID = initVariableId();
        mViewModel = initViewModel();
        if (BR_ID != 0) {
            mBinding.setVariable(initVariableId() ,mViewModel );
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mViewModel != null) {
            if (mViewModel.mFragment != null) {
                mViewModel.mFragment = null;
            }
            if (mViewModel.mContext != null) {
                mViewModel.mContext = null;
            }
            mViewModel = null;
        }
        mBinding.unbind();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initViewDataBinding(inflater, container, savedInstanceState);
        return mBinding.getRoot();
    }

    //初始化数据
    @Override
    public void initData() {
    }

    @Override
    public void initListener() {
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        initListener();
    }


    /**
     * 初始化根布局
     *
     * @return 布局layout的id
     */
    public abstract int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    //初始化布局ID
    public abstract int initVariableId();

    //初始化viewModel
    public abstract VM initViewModel();

    //返回
    public boolean onBackPressed() {
        return false;
    }

}
