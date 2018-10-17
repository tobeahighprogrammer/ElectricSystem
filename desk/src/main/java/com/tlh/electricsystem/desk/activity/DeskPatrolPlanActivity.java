package com.tlh.electricsystem.desk.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.base.common.ARouterPath;
import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.databinding.ActivityDeskPatrolPlanBinding;

/**
 * 巡视内容页面
 */
//@Route(path = ARouterPath.DeskPatrolPlanActivity)
public class DeskPatrolPlanActivity extends BaseActivity<ActivityDeskPatrolPlanBinding,BaseViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_desk_patrol_plan;
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
        mBinding.includePatrolPlanItem1.tvPatrolPlanName.setText("变电站名称");
        mBinding.includePatrolPlanItem2.tvPatrolPlanName.setText("查看巡视路线");
        mBinding.includePatrolPlanItem3.tvPatrolPlanName.setText("合并计划");
        mBinding.includePatrolPlanItem4.tvPatrolPlanName.setText("巡视内容");
        mBinding.includePatrolPlanItem5.tvPatrolPlanName.setText("备注");

        mBinding.includePatrolPlanItem1.tvPatrolPlanValue.setText("200V");
        mBinding.includePatrolPlanItem2.tvPatrolPlanValue.setText("详情");
        mBinding.includePatrolPlanItem3.tvPatrolPlanValue.setText("否");
        mBinding.includePatrolPlanItem4.tvPatrolPlanValue.setText("详情");
        mBinding.includePatrolPlanItem5.tvPatrolPlanValue.setText("详情");

        mBinding.includePatrolPlanItem1.tvPatrolPlanValue.setTextColor(getResources().getColor(R.color.color_text_grey));
        mBinding.includePatrolPlanItem2.tvPatrolPlanValue.setTextColor(getResources().getColor(R.color.color_theme_green));
        mBinding.includePatrolPlanItem3.tvPatrolPlanValue.setTextColor(getResources().getColor(R.color.color_text_grey));
        mBinding.includePatrolPlanItem4.tvPatrolPlanValue.setTextColor(getResources().getColor(R.color.color_theme_green));
        mBinding.includePatrolPlanItem5.tvPatrolPlanValue.setTextColor(getResources().getColor(R.color.color_theme_green));

        mBinding.includePatrolPlanItem4.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DeskPatrolPlanActivity.this,DeskPatrolContentActivity.class));
            }
        });
    }

}
