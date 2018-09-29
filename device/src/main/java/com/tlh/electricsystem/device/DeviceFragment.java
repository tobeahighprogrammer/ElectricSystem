package com.tlh.electricsystem.device;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.tlh.electricsystem.base.base.BaseFragment;
import com.tlh.electricsystem.base.utils.RecyclerViewHelper;
import com.tlh.electricsystem.device.adapter.DeviceAdapter;
import com.tlh.electricsystem.device.bean.DeviceBean;
import com.tlh.electricsystem.device.databinding.FragmentDeviceBinding;
import com.tlh.electricsystem.device.viewModel.DeviceViewModel;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * SJ:2018年9月29日10:48:09
 * name : ts
 * 用途：设备的主页面
 */
public class DeviceFragment extends BaseFragment< FragmentDeviceBinding , DeviceViewModel> {
    private DeviceAdapter mDeviceAdapter ; //设备的设配器
    private List<DeviceBean> mDeviceBean ; //数据源
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.fragment_device;
    }

    @Override
    public int initVariableId() {
        return com.tlh.electricsystem.device.BR.ViewModel;
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
        mDeviceAdapter = new DeviceAdapter(mDeviceBean);
        RecyclerViewHelper.initRecyclerViewV(m_Activity,mBinding.deviceRecyclerView,mDeviceAdapter);
    }
}
