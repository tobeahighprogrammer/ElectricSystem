package com.tlh.electricsystem.device;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tlh.electricsystem.base.base.BaseFragment;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.base.utils.RecyclerViewHelper;
import com.tlh.electricsystem.device.BR;
import com.tlh.electricsystem.device.adapter.DeviceInfoAdapter;
import com.tlh.electricsystem.device.bean.DeviceBean;
import com.tlh.electricsystem.device.bean.DeviceInfoBean;
import com.tlh.electricsystem.device.databinding.FragmentDeviceInfoBinding;
import com.tlh.electricsystem.device.viewModel.DeviceInfoViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeviceInfoFragment extends BaseFragment<FragmentDeviceInfoBinding ,DeviceInfoViewModel > {

    private List<DeviceInfoBean> mDeviceInfoBeans;
    private DeviceInfoAdapter mDeviceInfoAdapter ;
    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.fragment_device_info;
    }

    @Override
    public int initVariableId() {
        return BR.DeviceInfoViewModel;
    }

    @Override
    public DeviceInfoViewModel initViewModel() {
        return new DeviceInfoViewModel(this);
    }

    @Override
    public void initData() {
        super.initData();
        mDeviceInfoBeans = new ArrayList<>();
        mDeviceInfoAdapter = new DeviceInfoAdapter( R.layout.device_item , mDeviceInfoBeans );
        RecyclerViewHelper.initRecyclerViewH(m_Activity , mBinding.deviceInfoRecyclerView , mDeviceInfoAdapter ) ;
    }
}
