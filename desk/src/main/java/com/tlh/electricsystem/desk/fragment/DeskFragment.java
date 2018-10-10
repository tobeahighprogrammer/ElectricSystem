package com.tlh.electricsystem.desk.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.tlh.electricsystem.base.base.BaseFragment;
import com.tlh.electricsystem.base.utils.RecyclerViewHelper;
import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.adapter.DeskMenuAdapter;
import com.tlh.electricsystem.desk.adapter.DeskTaskAdapter;
import com.tlh.electricsystem.desk.databinding.FragmentDeskBinding;
import com.tlh.electricsystem.desk.viewModel.DeskViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 工作台首页
 * A simple {@link Fragment} subclass.
 */
public class DeskFragment extends BaseFragment<FragmentDeskBinding,DeskViewModel> {

    private List<String> menuList = new ArrayList<>();
    private static String[] menuNames = {"缺陷上报","隐患上报","待我审核","操作票","工作票"};

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_desk;
    }

    @Override
    public int initVariableId() {
        return com.tlh.electricsystem.desk.BR.ViewModel;
    }

    @Override
    public DeskViewModel initViewModel() {
        return new DeskViewModel(this);
    }

    @Override
    public void initData() {
        super.initData();
        List<String> menuList = new ArrayList<>();
        menuList.addAll(Arrays.asList(menuNames));
        DeskMenuAdapter deskMenuAdapter = new DeskMenuAdapter(m_Activity,menuList);
        RecyclerViewHelper.initRecyclerViewG(m_Activity,mBinding.rvDeskMenu,deskMenuAdapter,menuList.size());

        List<String> taskList = new ArrayList<>();
        taskList.add("");
        taskList.add("");
        taskList.add("");
        DeskTaskAdapter deskTaskAdapter = new DeskTaskAdapter(m_Activity,taskList);
        mBinding.rvDeskTask.setNestedScrollingEnabled(false);
        RecyclerViewHelper.initRecyclerViewV(m_Activity,mBinding.rvDeskTask,deskTaskAdapter);
    }
}
