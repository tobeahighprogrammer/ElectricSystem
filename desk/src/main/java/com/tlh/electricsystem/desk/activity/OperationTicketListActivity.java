package com.tlh.electricsystem.desk.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.adapter.OperationTicketAdapter;
import com.tlh.electricsystem.desk.databinding.ActivityDeskPatrolCompleteBinding;
import com.tlh.electricsystem.desk.databinding.ActivityOperationTicketListBinding;

import java.util.Arrays;

/**
 * 操作票列表页面
 */
public class OperationTicketListActivity extends BaseActivity<ActivityOperationTicketListBinding,BaseViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_operation_ticket_list;
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
        mBinding.toolbar.setSubtitle("操作票");

        mBinding.rvOperationTicketList.setLayoutManager(new LinearLayoutManager(this));

        OperationTicketAdapter operationTicketAdapter = new OperationTicketAdapter(this, Arrays.asList("","",""));
        mBinding.rvOperationTicketList.setAdapter(operationTicketAdapter);
    }
}
