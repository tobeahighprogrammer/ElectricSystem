package com.tlh.electricsystem.device.activity;

import android.app.Activity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.base.common.ARouterPath;
import com.tlh.electricsystem.base.utils.RecyclerViewHelper;
import com.tlh.electricsystem.device.BR;
import com.tlh.electricsystem.device.R;
import com.tlh.electricsystem.device.adapter.IntervalAdapter;
import com.tlh.electricsystem.device.bean.IntervalBean;
import com.tlh.electricsystem.device.databinding.FragmentIntervalBinding;
import com.tlh.electricsystem.device.viewModel.IntervalViewModel;
import java.util.ArrayList;
import java.util.List;

/**
 * sj: 2018年10月8日10:03:42
 * name : ts
 * 用途： 展示间隔详情列表
 */
@Route(path = ARouterPath.IntervalActivity)
public class IntervalActivity extends BaseActivity<FragmentIntervalBinding, IntervalViewModel> {
    private List<IntervalBean> mIntervalBeans ;
    private IntervalAdapter mIntervalAdapter ;

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.fragment_interval;
    }

    @Override
    public int initVariableId() {
        return BR.IntervalViewModel;
    }

    @Override
    public IntervalViewModel initViewModel() {
        return new IntervalViewModel(this);
    }

    @Override
    public void initData() {
        //初始化title
        initToolbar(mBinding.mToolbar);
        //初始化数据源
        mIntervalBeans = new ArrayList<>();
        mIntervalBeans.add(new IntervalBean());
        mIntervalBeans.add(new IntervalBean());
        mIntervalBeans.add(new IntervalBean());
        mIntervalBeans.add(new IntervalBean());
        mIntervalBeans.add(new IntervalBean());
        mIntervalAdapter = new IntervalAdapter( R.layout.device_interval_item , mIntervalBeans ) ;
        RecyclerViewHelper.initRecyclerViewV( mContext , mBinding.intervalInfoRecyclerView , mIntervalAdapter ) ;
    }

    @Override
    public void initListener() {
        mViewModel.addOnItemTouchListener(mBinding.intervalInfoRecyclerView);
        mViewModel.addOnItemChildTouchListener(mBinding.intervalInfoRecyclerView);
    }
}
