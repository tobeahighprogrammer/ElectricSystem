package com.tlh.electricsystem.device.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tlh.electricsystem.base.base.BaseFragment;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.base.utils.RecyclerViewHelper;
import com.tlh.electricsystem.device.R;
import com.tlh.electricsystem.device.adapter.DeviceTaskAdapter;
import com.tlh.electricsystem.device.bean.DeviceTaskBean;
import com.tlh.electricsystem.device.databinding.FragmentDefectBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * sj: 2018年9月30日10:28:40
 * name : 唐师
 * 用途： 设备详情的任务页面 主要显示任务信息
 */
public class TaskFragment extends BaseFragment<FragmentDefectBinding , BaseViewModel> {
    private List<DeviceTaskBean> mDeviceTaskBeans; //任务列表数据源
    private DeviceTaskAdapter mDeviceTaskAdapter; //任务列表适配器

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_defect;
    }

    @Override
    public int initVariableId() {
        return 0;
    }

    @Override
    public BaseViewModel initViewModel() {
        return new BaseViewModel(this);
    }

    @Override
    public void initData() {
        super.initData();
        mDeviceTaskBeans = new ArrayList<>();
        mDeviceTaskBeans.add(new DeviceTaskBean());
        mDeviceTaskBeans.add(new DeviceTaskBean());
        mDeviceTaskBeans.add(new DeviceTaskBean());
        mDeviceTaskBeans.add(new DeviceTaskBean());
        mDeviceTaskBeans.add(new DeviceTaskBean());
        mDeviceTaskBeans.add(new DeviceTaskBean());
        mDeviceTaskAdapter = new DeviceTaskAdapter( R.layout.device_task_item , mDeviceTaskBeans);
        RecyclerViewHelper.initRecyclerViewV(m_Activity , mBinding.relDevice, mDeviceTaskAdapter);
    }
}
