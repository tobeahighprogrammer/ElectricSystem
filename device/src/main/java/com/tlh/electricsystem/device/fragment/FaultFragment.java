package com.tlh.electricsystem.device.fragment;


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
import com.tlh.electricsystem.device.adapter.DefectAdapter;
import com.tlh.electricsystem.device.bean.DefectBean;
import com.tlh.electricsystem.device.databinding.FragmentDefectBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * sj: 2018年9月30日10:28:40
 * name : 唐师
 * 用途： 设备详情的故障页面 主要显示缺陷设备信息
 */
public class FaultFragment extends BaseFragment<FragmentDefectBinding,BaseViewModel> {


    private List<DefectBean> mDefectBeans; //元数据
    private DefectAdapter mDefectAdapter ; //设配器

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
        mDefectBeans =  new ArrayList<>();
        mDefectBeans.add(new DefectBean());
        mDefectBeans.add(new DefectBean());
        mDefectBeans.add(new DefectBean());
        mDefectBeans.add(new DefectBean());
        mDefectBeans.add(new DefectBean());
        mDefectBeans.add(new DefectBean());
        mDefectAdapter = new DefectAdapter(R.layout.defect_device_item , mDefectBeans);
        RecyclerViewHelper.initRecyclerViewV(m_Activity ,mBinding.relDevice,mDefectAdapter);
    }
}
