package com.tlh.electricsystem.desk.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.databinding.ActivityPatrolContentBinding;

/**
 * 巡视内容页面
 */
public class DeskPatrolContentActivity extends BaseActivity<ActivityPatrolContentBinding,BaseViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_patrol_content;
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
