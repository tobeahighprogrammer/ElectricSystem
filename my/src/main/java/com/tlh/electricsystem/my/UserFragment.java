package com.tlh.electricsystem.my;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tlh.electricsystem.base.base.BaseFragment;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.my.databinding.FragmentUserBinding;


/**
 * sj: 2018年10月15日11:06:06
 * name : ts
 * 用途：用户的个人中心页面！
 */
public class UserFragment extends BaseFragment<FragmentUserBinding , BaseViewModel> {

    @Override
    public int initContentView(LayoutInflater inflater , @Nullable ViewGroup container , @Nullable Bundle savedInstanceState ) {
        return R.layout.fragment_user;
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
    public void initListener() {
        mBinding.linSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.startActivity(SettingActivity.class);
            }
        });
    }
}
