package com.tlh.electricsystem.viewModel;

import android.content.Context;
import android.view.View;

import com.tlh.electricsystem.MainActivity;
import com.tlh.electricsystem.base.base.BaseViewModel;

/**
 * Created by Administrator on 2018/9/29 0029.
 */

public class LoginViewModel extends BaseViewModel {

    public LoginViewModel(Context mContext) {
        super(mContext);
    }

    public void login(View view){
        //跳转
        startActivity(MainActivity.class);

    }

}
