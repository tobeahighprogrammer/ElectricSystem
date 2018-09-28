package com.tlh.electricsystem.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;


/**
 * Created by Administrator on 2018/9/27 0027.
 */

public abstract class BaseActivity< V extends ViewDataBinding , VM extends BaseViewModel>
        extends RxAppCompatActivity implements IBaseActivity {

    protected V mBinding ;
    protected VM mViewModel ;

    @Override
    protected void onCreate( @Nullable Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        //获取传递的参数
        initParam();
        initViewDataBinding( savedInstanceState );
        //初始化数据
        initData();
    }

    /**
     * 注入绑定
     */
    private void initViewDataBinding(Bundle savedInstanceState) {
        //DataBindingUtil类需要在project的build中配置 dataBinding {enabled true }, 同步后会自动关联android.databinding包
        mBinding = DataBindingUtil.setContentView(this, initContentView(savedInstanceState));
        mBinding.setVariable( initVariableId() , mViewModel = initViewModel());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if ( mViewModel != null ) {
            if ( mViewModel.mContext != null ) {
                 mViewModel.mContext = null;
            }
            if ( mViewModel.mFragment != null ) {
                 mViewModel.mFragment = null;
            }
            mViewModel = null;
        }
        mBinding.unbind();
    }

    //设置布局的ID
    public abstract int initContentView( Bundle savedInstanceState );
    //初始化布局ID
    public abstract int initVariableId();
    //初始化viewModel
    public abstract VM initViewModel();

    //初始化数据
    @Override
    public void initData() { }
    //初始化参数
    @Override
    public void initParam() { }
}
