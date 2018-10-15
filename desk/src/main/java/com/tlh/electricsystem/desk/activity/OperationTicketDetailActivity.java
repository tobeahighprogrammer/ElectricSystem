package com.tlh.electricsystem.desk.activity;

import android.os.Bundle;

import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.databinding.ActivityOperationTicketDetailBinding;
import com.tlh.electricsystem.desk.databinding.ActivityOperationTicketListBinding;
import com.tlh.electricsystem.desk.widget.CommonWithImageView;
import com.tlh.electricsystem.desk.widget.CommonWithLeaderView;
import com.tlh.electricsystem.desk.widget.CommonWithNextView;
import com.tlh.electricsystem.desk.widget.CommonWithTextView;

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

        mBinding.llOperationItemContainer.addView(new CommonWithImageView(this));
        mBinding.llOperationItemContainer.addView(new CommonWithLeaderView(this));
        mBinding.llOperationItemContainer.addView(new CommonWithLeaderView(this));
        mBinding.llOperationItemContainer.addView(new CommonWithNextView(this));
        mBinding.llOperationItemContainer.addView(new CommonWithNextView(this));
        mBinding.llOperationItemContainer.addView(new CommonWithTextView(this));
        mBinding.llOperationItemContainer.addView(new CommonWithNextView(this));
        mBinding.llOperationItemContainer.addView(new CommonWithNextView(this));
    }
}
