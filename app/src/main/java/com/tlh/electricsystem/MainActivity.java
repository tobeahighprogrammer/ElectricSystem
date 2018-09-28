package com.tlh.electricsystem;

import android.os.Bundle;

import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.databinding.ActivityMainBinding;
import com.tlh.electricsystem.viewModel.MainViewModel;


public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() { return com.tlh.electricsystem.BR.ViewModel ; }

    @Override
    public MainViewModel initViewModel() {
        return new MainViewModel(this);
    }

    //初始化数据
    @Override
    public void initData() {
        mViewModel.initTabHost(mBinding.mainTabHost);
    }
}
