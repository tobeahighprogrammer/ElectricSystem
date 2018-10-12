package com.tlh.electricsystem.desk.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tlh.electricsystem.base.base.BaseFragment;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.base.utils.RecyclerViewHelper;
import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.adapter.DeskMenuAdapter;
import com.tlh.electricsystem.desk.adapter.DeskTaskAdapter;
import com.tlh.electricsystem.desk.adapter.PatrolContentAdapter;
import com.tlh.electricsystem.desk.databinding.FragmentDeskBinding;
import com.tlh.electricsystem.desk.databinding.FragmentRecyclerViewBinding;
import com.tlh.electricsystem.desk.viewModel.DeskViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 巡视内容列表页
 * A simple {@link Fragment} subclass.
 */
public class DeskPatrolContentFragment extends BaseFragment<FragmentRecyclerViewBinding,BaseViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_recycler_view;
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

        mBinding.rvFragmentList.setLayoutManager(new LinearLayoutManager(m_Activity));

        List<String> dataList = new ArrayList<>();
        dataList.add("");
        dataList.add("");
        dataList.add("");
        PatrolContentAdapter patrolContentAdapter = new PatrolContentAdapter(m_Activity,dataList);
        mBinding.rvFragmentList.setAdapter(patrolContentAdapter);
    }
}
