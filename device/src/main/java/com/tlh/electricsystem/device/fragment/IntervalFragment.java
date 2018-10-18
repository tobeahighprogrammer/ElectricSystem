package com.tlh.electricsystem.device.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.tlh.electricsystem.base.base.BaseFragment;
import com.tlh.electricsystem.base.utils.RecyclerViewHelper;
import com.tlh.electricsystem.device.BR;
import com.tlh.electricsystem.device.R;
import com.tlh.electricsystem.device.adapter.IntervalAdapter;
import com.tlh.electricsystem.device.bean.DeviceInfoBean;
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
public class IntervalFragment extends BaseFragment<FragmentIntervalBinding , IntervalViewModel> {
    private List<IntervalBean> mIntervalBeans ;
    private IntervalAdapter mIntervalAdapter ;

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
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
        mIntervalBeans = new ArrayList<>();
        mIntervalBeans.add(new IntervalBean());
        mIntervalBeans.add(new IntervalBean());
        mIntervalBeans.add(new IntervalBean());
        mIntervalBeans.add(new IntervalBean());
        mIntervalBeans.add(new IntervalBean());
        mIntervalAdapter = new IntervalAdapter( R.layout.device_interval_item , mIntervalBeans ) ;
        RecyclerViewHelper.initRecyclerViewV( m_Activity , mBinding.intervalInfoRecyclerView , mIntervalAdapter ) ;
    }

    @Override
    public void initListener() {
        mViewModel.addOnItemTouchListener(mBinding.intervalInfoRecyclerView);
        mViewModel.addOnItemChildTouchListener(mBinding.intervalInfoRecyclerView);
    }
}
