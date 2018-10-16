package com.tlh.electricsystem.desk.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.base.common.ARouterPath;
import com.tlh.electricsystem.base.widget.ViewPagerAdapter;
import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.databinding.ActivityPatrolContentBinding;
import com.tlh.electricsystem.desk.fragment.DeskPatrolContentFragment;
import com.tlh.electricsystem.desk.fragment.DeskPatrolDeviceFragment;
import com.tlh.electricsystem.desk.fragment.OperationTicketProcessFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 操作票提交流程页面
 */
public class OperationTicketProcessActivity extends BaseActivity<ActivityPatrolContentBinding, BaseViewModel> {

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

    @Override
    public void initData() {
        super.initData();
        mBinding.tlPatrolContent.setupWithViewPager(mBinding.vpPatrolContent);
        mBinding.toolbar.setSubtitle("操作票");

        String[] mTitles = {"操作过程", "倒闸操作"};
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new OperationTicketProcessFragment());
        fragments.add(new OperationTicketProcessFragment());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mTitles, fragments);
        mBinding.vpPatrolContent.setAdapter(viewPagerAdapter);
    }
}
