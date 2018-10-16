package com.tlh.electricsystem.desk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.databinding.ActivityOperationTicketDetailBinding;
import com.tlh.electricsystem.desk.databinding.ActivityOperationTicketListBinding;
import com.tlh.electricsystem.desk.widget.CommonWithImageView;
import com.tlh.electricsystem.desk.widget.CommonWithLeaderView;
import com.tlh.electricsystem.desk.widget.CommonWithNextView;
import com.tlh.electricsystem.desk.widget.CommonWithTextView;
import com.tlh.electricsystem.desk.widget.OperationTicketMembersView;
import com.tlh.electricsystem.desk.widget.OperationTicketTaskView;

/**
 * 操作票详情页面
 */
public class OperationTicketDetailActivity extends BaseActivity<ActivityOperationTicketDetailBinding,BaseViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_operation_ticket_detail;
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

        CommonWithNextView commonWithNextView1 = new CommonWithNextView(this);
        commonWithNextView1.setName("调度令内容");
        commonWithNextView1.setValue("查看详情");
        mBinding.llOperationItemContainer.addView(commonWithNextView1);

        mBinding.llOperationItemContainer.addView(new OperationTicketTaskView(this));

        CommonWithLeaderView commonWithLeaderView1 = new CommonWithLeaderView(this);
        commonWithLeaderView1.setName("操作人");
        commonWithLeaderView1.setValue("Trevor Hansen");
        mBinding.llOperationItemContainer.addView(commonWithLeaderView1);

        CommonWithLeaderView commonWithLeaderView2 = new CommonWithLeaderView(this);
        commonWithLeaderView2.setName("监护人");
        commonWithLeaderView2.setValue("Trevor Hansen");
        mBinding.llOperationItemContainer.addView(commonWithLeaderView2);

        CommonWithTextView commonWithTextView = new CommonWithTextView(this);
        commonWithTextView.setName("操作步骤");
        commonWithTextView.setValue("");
        mBinding.llOperationItemContainer.addView(commonWithTextView);

        CommonWithImageView commonWithImageView = new CommonWithImageView(this);
        commonWithImageView.setName("变电站名称");
        mBinding.llOperationItemContainer.addView(commonWithImageView);

        mBinding.btnOperationTicketDetailSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OperationTicketDetailActivity.this,OperationTicketProcessActivity.class));
            }
        });
    }
}
