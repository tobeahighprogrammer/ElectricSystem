package com.tlh.electricsystem.device.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tlh.electricsystem.base.base.BaseFragment;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.base.utils.RecyclerViewHelper;
import com.tlh.electricsystem.device.R;
import com.tlh.electricsystem.device.adapter.DynamicAdapter;
import com.tlh.electricsystem.device.bean.DynamicBean;
import com.tlh.electricsystem.device.databinding.FragmentDefectBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/12 0012.
 */

public class DynamicFragment extends BaseFragment<FragmentDefectBinding,BaseViewModel> {
    private DynamicAdapter mDynamicAdapter; //设配器
    private List<DynamicBean> mDynamicBeans; //数据源

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
        mDynamicBeans = new ArrayList<>();
        mDynamicBeans.add(new DynamicBean());
        mDynamicBeans.add(new DynamicBean());
        mDynamicBeans.add(new DynamicBean());
        mDynamicBeans.add(new DynamicBean());
        mDynamicBeans.add(new DynamicBean());
        mDynamicBeans.add(new DynamicBean());
        mDynamicAdapter = new DynamicAdapter(R.layout.item_trace ,mDynamicBeans);
        RecyclerViewHelper.initRecyclerViewV(m_Activity ,mBinding.relDevice , mDynamicAdapter);
    }
}
