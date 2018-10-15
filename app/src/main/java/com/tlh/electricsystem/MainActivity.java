package com.tlh.electricsystem;

import android.os.Bundle;
import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.databinding.ActivityMainBinding;
import com.tlh.electricsystem.viewModel.MainViewModel;

/**
 * sj: 2018年10月15日15:27:24
 * name: ts
 * 用途：app主页面
 */
public class MainActivity extends BaseActivity< ActivityMainBinding , MainViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() { return com.tlh.electricsystem.BR.ViewModel; }

    @Override
    public MainViewModel initViewModel() {
        return new MainViewModel(this );
    }

    //初始化数据
    @Override
    public void initData() {
        //初始化title栏
        initToolbar(mBinding.toolbar);
        //初始化页面
        mViewModel.initTabHost( mBinding.mainTabHost );
    }

    @Override
    public void initListener() {
        mViewModel.setTabHostlistener(mBinding.mainTabHost , mBinding.toolbar);
    }
}
