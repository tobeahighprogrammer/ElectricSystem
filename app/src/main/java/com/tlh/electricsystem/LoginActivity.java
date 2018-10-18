package com.tlh.electricsystem;

import android.os.Bundle;
import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.databinding.ActivityLoginBinding;
import com.tlh.electricsystem.viewModel.LoginViewModel;

public class LoginActivity extends BaseActivity<ActivityLoginBinding  , LoginViewModel> {
    @Override
    public int initContentView( Bundle savedInstanceState ) {
        return R.layout.activity_login;
    }

    @Override
    public int initVariableId() {
        return BR.LoginViewModel;
    }

    @Override
    public LoginViewModel initViewModel() {
        return new LoginViewModel(mBinding ,this);
    }
}
