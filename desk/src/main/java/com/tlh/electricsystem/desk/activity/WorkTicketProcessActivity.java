package com.tlh.electricsystem.desk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.databinding.ActivityWorkTicketDetailBinding;
import com.tlh.electricsystem.desk.databinding.ActivityWorkTicketProcessBinding;
import com.tlh.electricsystem.desk.widget.CommonWithImageView;
import com.tlh.electricsystem.desk.widget.CommonWithLeaderView;
import com.tlh.electricsystem.desk.widget.CommonWithListView;
import com.tlh.electricsystem.desk.widget.CommonWithTextView;
import com.tlh.electricsystem.desk.widget.OperationTicketMembersView;
import com.tlh.electricsystem.desk.widget.OperationTicketTaskView;

import java.util.Arrays;

/**
 * 工作票变更页面
 */
public class WorkTicketProcessActivity extends BaseActivity<ActivityWorkTicketProcessBinding,BaseViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_work_ticket_process;
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

        CommonWithImageView commonWithImageView = new CommonWithImageView(this);
        commonWithImageView.setName("变电站名称");
        mBinding.llOperationItemContainer.addView(commonWithImageView);

        CommonWithLeaderView commonWithLeaderView1 = new CommonWithLeaderView(this);
        commonWithLeaderView1.setName("工作负责人");
        commonWithLeaderView1.setValue("Trevor Hansen");
        mBinding.llOperationItemContainer.addView(commonWithLeaderView1);

        CommonWithTextView commonWithTextView = new CommonWithTextView(this);
        commonWithTextView.setName("工作班组");
        commonWithTextView.setValue("班组名称");
        mBinding.llOperationItemContainer.addView(commonWithTextView);

        CommonWithTextView commonWithTextView1 = new CommonWithTextView(this);
        commonWithTextView1.setName("工作单位");
        commonWithTextView1.setValue("工作单位名称");
        mBinding.llOperationItemContainer.addView(commonWithTextView1);

        CommonWithLeaderView commonWithLeaderView2 = new CommonWithLeaderView(this);
        commonWithLeaderView2.setName("工作签发人");
        commonWithLeaderView2.setValue("Trevor Hansen");
        mBinding.llOperationItemContainer.addView(commonWithLeaderView2);

        mBinding.btnWorkTicketProcessSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
