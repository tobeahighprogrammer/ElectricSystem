package com.tlh.electricsystem.desk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.databinding.ActivityOperationTicketDetailBinding;
import com.tlh.electricsystem.desk.databinding.ActivityWorkTicketDetailBinding;
import com.tlh.electricsystem.desk.widget.CommonWithImageView;
import com.tlh.electricsystem.desk.widget.CommonWithLeaderView;
import com.tlh.electricsystem.desk.widget.CommonWithListView;
import com.tlh.electricsystem.desk.widget.CommonWithNextView;
import com.tlh.electricsystem.desk.widget.CommonWithTextView;
import com.tlh.electricsystem.desk.widget.OperationTicketMembersView;
import com.tlh.electricsystem.desk.widget.OperationTicketTaskView;

import java.util.Arrays;

/**
 * 工作票详情页面
 */
public class WorkTicketDetailActivity extends BaseActivity<ActivityWorkTicketDetailBinding,BaseViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_work_ticket_detail;
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

        mBinding.llOperationItemContainer.addView(new OperationTicketMembersView(this));

        CommonWithImageView commonWithImageView = new CommonWithImageView(this);
        commonWithImageView.setName("变电站名称");
        mBinding.llOperationItemContainer.addView(commonWithImageView);

        mBinding.llOperationItemContainer.addView(new OperationTicketTaskView(this));

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

        CommonWithListView commonWithListView = new CommonWithListView(this);
        commonWithListView.setName("工作班组成员");
        commonWithListView.setList(Arrays.asList("Trevor Hansen","Trevor Hansen","Trevor Hansen","Trevor Hansen"));
        mBinding.llOperationItemContainer.addView(commonWithListView);

        CommonWithLeaderView commonWithLeaderView2 = new CommonWithLeaderView(this);
        commonWithLeaderView2.setName("工作签发人");
        commonWithLeaderView2.setValue("Trevor Hansen");
        mBinding.llOperationItemContainer.addView(commonWithLeaderView2);

        mBinding.btnWorkTicketDetailChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkTicketDetailActivity.this,WorkTicketProcessActivity.class));
            }
        });
        mBinding.btnWorkTicketDetailAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WorkTicketDetailActivity.this,WorkTicketProcessActivity.class));
            }
        });
    }
}
