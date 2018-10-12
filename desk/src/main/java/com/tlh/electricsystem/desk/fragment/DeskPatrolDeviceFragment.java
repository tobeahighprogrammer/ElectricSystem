package com.tlh.electricsystem.desk.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tlh.electricsystem.base.base.BaseFragment;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.adapter.PatrolDeviceAdapter;
import com.tlh.electricsystem.desk.databinding.FragmentPatrolDeviceBinding;
import com.tlh.electricsystem.desk.databinding.FragmentRecyclerViewBinding;

import java.util.ArrayList;
import java.util.List;


/**
 * 巡视设备列表页
 * A simple {@link Fragment} subclass.
 */
public class DeskPatrolDeviceFragment extends BaseFragment<FragmentPatrolDeviceBinding,BaseViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_patrol_device;
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
        mBinding.rvPatrolDeviceList.setLayoutManager(new LinearLayoutManager(m_Activity));

        List<String> dataList = new ArrayList<>();
        dataList.add("");
        dataList.add("");
        dataList.add("");
        PatrolDeviceAdapter patrolDeviceAdapter = new PatrolDeviceAdapter(m_Activity,dataList);
        mBinding.rvPatrolDeviceList.setAdapter(patrolDeviceAdapter);
    }
}
