package com.tlh.electricsystem.device.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.tlh.electricsystem.base.base.BaseFragment;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.base.utils.RecyclerViewHelper;
import com.tlh.electricsystem.device.BR;
import com.tlh.electricsystem.device.R;
import com.tlh.electricsystem.device.adapter.DeviceInfoAdapter;
import com.tlh.electricsystem.device.bean.DeviceBean;
import com.tlh.electricsystem.device.bean.DeviceInfoBean;
import com.tlh.electricsystem.device.databinding.FragmentDeviceInfoBinding;
import com.tlh.electricsystem.device.viewModel.DeviceInfoViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 *sj: 2018年10月8日10:03:42
 * name : ts
 * 用途： 展示电站详情类别
 */
public class DeviceInfoFragment extends BaseFragment<FragmentDeviceInfoBinding ,DeviceInfoViewModel > {

    private List<DeviceInfoBean> mDeviceInfoBeans ;
    private DeviceInfoAdapter mDeviceInfoAdapter ;

    @Override
    public int initContentView(LayoutInflater inflater , @Nullable ViewGroup container , @Nullable Bundle savedInstanceState ) {
        return R.layout.fragment_device_info;
    }

    @Override
    public int initVariableId() {
        return BR.DeviceInfoViewModel ;
    }

    @Override
    public DeviceInfoViewModel initViewModel() {
        return new DeviceInfoViewModel(this);
    }

    @Override
    public void initData() {
        mDeviceInfoBeans = new ArrayList<>();
        mDeviceInfoBeans.add(new DeviceInfoBean());
        mDeviceInfoBeans.add(new DeviceInfoBean());
        mDeviceInfoBeans.add(new DeviceInfoBean());
        mDeviceInfoBeans.add(new DeviceInfoBean());
        mDeviceInfoBeans.add(new DeviceInfoBean());
        mDeviceInfoAdapter = new DeviceInfoAdapter( R.layout.device_item , mDeviceInfoBeans );
        RecyclerViewHelper.initRecyclerViewV( m_Activity , mBinding.deviceInfoRecyclerView , mDeviceInfoAdapter );
    }

    @Override
    public void initListener() {
        mViewModel.addOnItemTouchListener( mBinding.deviceInfoRecyclerView );
    }
}
