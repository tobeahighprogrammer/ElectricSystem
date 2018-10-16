package com.tlh.electricsystem.desk.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tlh.electricsystem.base.base.BaseFragment;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.adapter.PatrolContentAdapter;
import com.tlh.electricsystem.desk.databinding.FragmentOperationTicketProcessBinding;
import com.tlh.electricsystem.desk.databinding.FragmentRecyclerViewBinding;
import com.tlh.electricsystem.desk.widget.CommonWithImageView;
import com.tlh.electricsystem.desk.widget.CommonWithLeaderView;
import com.tlh.electricsystem.desk.widget.CommonWithNextView;
import com.tlh.electricsystem.desk.widget.CommonWithTextView;

import java.util.ArrayList;
import java.util.List;


/**
 * 操作票提交流程
 * A simple {@link Fragment} subclass.
 */
public class OperationTicketProcessFragment extends BaseFragment<FragmentOperationTicketProcessBinding,BaseViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_operation_ticket_process;
    }

    @Override
    public int initVariableId() {
        return 0;
    }

    @Override
    public BaseViewModel initViewModel() {
        return new BaseViewModel(m_Activity);
    }

    @Override
    public void initData() {
        super.initData();

        CommonWithImageView commonWithImageView = new CommonWithImageView(m_Activity);
        commonWithImageView.setName("变电站名称");
        mBinding.llOperationItemContainer.addView(commonWithImageView);

        CommonWithLeaderView commonWithLeaderView1 = new CommonWithLeaderView(m_Activity);
        commonWithLeaderView1.setName("操作人");
        commonWithLeaderView1.setValue("Trevor Hansen");
        mBinding.llOperationItemContainer.addView(commonWithLeaderView1);

        CommonWithLeaderView commonWithLeaderView2 = new CommonWithLeaderView(m_Activity);
        commonWithLeaderView2.setName("监护人");
        commonWithLeaderView2.setValue("Trevor Hansen");
        mBinding.llOperationItemContainer.addView(commonWithLeaderView2);

        CommonWithTextView commonWithTextView = new CommonWithTextView(m_Activity);
        commonWithTextView.setName("操作步骤");
        commonWithTextView.setValue("");
        mBinding.llOperationItemContainer.addView(commonWithTextView);

        CommonWithNextView commonWithNextView = new CommonWithNextView(m_Activity);
        commonWithNextView.setName("操作时间");
        commonWithNextView.setValue("10月9日  10:35");
        mBinding.llOperationItemContainer.addView(commonWithNextView);

        CommonWithNextView commonWithNextView1 = new CommonWithNextView(m_Activity);
        commonWithNextView1.setName("操作关键项次");
        commonWithNextView1.setValue("添加一项");
        mBinding.llOperationItemContainer.addView(commonWithNextView1);

        mBinding.btnOperationTicketDetailSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
