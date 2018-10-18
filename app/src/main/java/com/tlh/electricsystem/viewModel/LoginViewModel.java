package com.tlh.electricsystem.viewModel;

import android.content.Context;
import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.tlh.electricsystem.LoginActivity;
import com.tlh.electricsystem.MainActivity;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.base.utils.EditTextUtils;
import com.tlh.electricsystem.base.utils.ToastUtil;
import com.tlh.electricsystem.databinding.ActivityLoginBinding;

/**
 * sj: 2018年10月18日10:29:32
 * name : ts
 * 用途： 登录的罗积类
 */

public class LoginViewModel extends BaseViewModel<ActivityLoginBinding> {
    //存储账号的字符串
    public ObservableField<String> userName = new ObservableField<>("123456");
    //存储密码的字符串
    public ObservableField<String> userPass = new ObservableField<>("admin");

    public LoginViewModel( ActivityLoginBinding mBinding, Context mContext ) {
        super(mBinding, mContext);
    }

    //登录的监听
    public void login( View view ){
        if (!userName.get().equals("123456") || !userPass.get().equals("admin") ){
            ToastUtil.showShortToast( mContext.getApplicationContext() , "账号密码不匹配!请输入正确.." );
        } else {
            if (mBinding.meloginEtPhone.isFocusable()) {
                EditTextUtils.hideInput(mBinding.meloginEtPhone);
            } else {
                EditTextUtils.hideInput(mBinding.meloginEtPass);
            }
            startActivity(MainActivity.class); //跳转
            ((LoginActivity)mContext).finish();
        }
    }

    //账号的输入监听
    public  final TextWatcher OnUserNameChange = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            userName.set(s.toString());
            mBinding.meloginEtPhone.setSelection(s.length());
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    //密码的输入监听
    public final TextWatcher OnUserPassChange = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

        @Override
        public void onTextChanged( CharSequence s, int start, int before, int count ) {
            userPass.set(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) { }
    };
}
