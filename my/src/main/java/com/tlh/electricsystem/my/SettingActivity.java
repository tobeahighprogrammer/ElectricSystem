package com.tlh.electricsystem.my;

import android.os.Bundle;
import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.my.databinding.ActivitySettingBinding;

public class SettingActivity extends BaseActivity<ActivitySettingBinding,BaseViewModel> {

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_setting;
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
