package com.tlh.electricsystem.device.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.tlh.electricsystem.base.base.BaseFragment;
import com.tlh.electricsystem.base.utils.RecyclerViewHelper;
import com.tlh.electricsystem.device.BR;
import com.tlh.electricsystem.device.R;
import com.tlh.electricsystem.device.adapter.DeviceAdapter;
import com.tlh.electricsystem.device.bean.DeviceBean;
import com.tlh.electricsystem.device.databinding.FragmentDeviceBinding;
import com.tlh.electricsystem.device.viewModel.DeviceViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 * sj :2018年9月29日10:48:09
 * name : ts
 * 用途：设备的主页面
 */
public class DeviceFragment extends BaseFragment< FragmentDeviceBinding , DeviceViewModel> {
    private DeviceAdapter mDeviceAdapter ; //设备的设配器
    private List<DeviceBean> mDeviceBean ; //数据源

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_device;
    }

    @Override
    public int initVariableId() {
        return BR.ViewModel;
    }

    //数据控制器
    @Override
    public DeviceViewModel initViewModel() {
        return new DeviceViewModel(this);
    }

    //初始化逻辑业务
    @Override
    public void initData() {
        super.initData();
        mDeviceBean= new ArrayList<>();
        mDeviceBean.add(new DeviceBean(1));
        mDeviceBean.add(new DeviceBean(2));
        mDeviceBean.add(new DeviceBean(2));
        mDeviceBean.add(new DeviceBean(2));
        mDeviceBean.add(new DeviceBean(2));
        mDeviceAdapter = new DeviceAdapter( mDeviceBean );
        RecyclerViewHelper.initRecyclerViewV( m_Activity ,mBinding.deviceRecyclerView ,mDeviceAdapter );
    }

    @Override
    public void initListener() {
        mBinding.deviceRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (mViewModel != null) {
                    mViewModel.startContainerActivity(DeviceInfoFragment.class.getCanonicalName());
                }
            }
        });
    }
}
