package com.tlh.electricsystem.base.base;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * Created by Administrator on 2018/9/27 0027.
 */

public abstract class BaseFragment<V extends ViewDataBinding ,VM extends BaseViewModel> extends RxFragment implements IBaseActivity {

    protected V mBinding ;
    protected VM mViewMidel ;
    protected Activity m_Activity;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        m_Activity = activity;
    }

    @Override
    public void initParam() { }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParam();
    }

    /**
     * 注入绑定
     */
    private void initViewDataBinding(Bundle savedInstanceState) {
        //DataBindingUtil类需要在project的build中配置 dataBinding {enabled true }, 同步后会自动关联android.databinding包
        mBinding = DataBindingUtil.setContentView(m_Activity, initContentView(savedInstanceState));
        mBinding.setVariable(initVariableId(), mViewMidel = initViewModel());
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mViewMidel.mFragment != null) {
            mViewMidel.mFragment = null;
        }
        if (mViewMidel.mContext != null) {
            mViewMidel.mContext = null;
        }
        mViewMidel = null;
        mBinding.unbind();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        initViewDataBinding(savedInstanceState);
        return mBinding.getRoot();
    }

    //初始化数据
    @Override
    public void initData() { }

    //初始化View 完成之后
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    //设置布局的ID
    public abstract int initContentView(Bundle savedInstanceState);
    //初始化布局ID
    public abstract int initVariableId();
    //初始化viewModel
    public abstract VM initViewModel();

    //返回
    public boolean onBackPressed() {
        return false;
    }

}
