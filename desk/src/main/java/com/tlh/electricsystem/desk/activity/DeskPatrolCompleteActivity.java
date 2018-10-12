package com.tlh.electricsystem.desk.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.databinding.ActivityDeskPatrolCompleteBinding;

/**
 * 巡视完成页面
 */
public class DeskPatrolCompleteActivity extends BaseActivity<ActivityDeskPatrolCompleteBinding,BaseViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_desk_patrol_complete;
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
    }
}
