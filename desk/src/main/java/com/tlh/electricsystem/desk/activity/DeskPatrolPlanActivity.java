package com.tlh.electricsystem.desk.activity;

import android.os.Bundle;

import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.databinding.ActivityDeskPatrolPlanBinding;

/**
 * 巡视内容页面
 */
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
}
