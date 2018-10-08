package com.tlh.electricsystem.device;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.device.databinding.ActivityDeviceContentBinding;
import com.tlh.electricsystem.device.fragment.DefectFragment;
import com.tlh.electricsystem.device.fragment.FaultFragment;
import com.tlh.electricsystem.device.fragment.HiddenFragment;
import com.tlh.electricsystem.device.fragment.LedgerFragment;
import com.tlh.electricsystem.device.fragment.TaskFragment;
import com.tlh.electricsystem.device.viewModel.DeviceContentViewModel;

import java.util.ArrayList;

public class DeviceContentActivity extends BaseActivity<ActivityDeviceContentBinding, DeviceContentViewModel> {
    private ArrayList<Fragment>  mFragments; // 承装Fragment 集合
    private String[] titles = { "缺陷" ,"隐患" ,"任务" ,"台账" ,"故障" }; //设置指示栏名称
    //子页面
    private DefectFragment mDefectFragment; //缺陷页面
    private HiddenFragment mHiddenFragment; //隐患页面
    private TaskFragment mTaskFragment; //任务页面
    private LedgerFragment mLedgerFragment ; //台账页面
    private FaultFragment mFaultFragment ; //故障页面

    @Override
    public int initContentView( Bundle savedInstanceState ) {
        return R.layout.activity_device_content;
    }

    @Override
    public int initVariableId() {
        return BR.DeviceContentViewModel;
    }

    @Override
    public DeviceContentViewModel initViewModel() {
        return new DeviceContentViewModel(this);
    }

    @Override
    public void initData() {
        super.initData();
        mFragments = new ArrayList<>();
        mDefectFragment = new DefectFragment();
        mHiddenFragment = new HiddenFragment();
        mTaskFragment = new TaskFragment();
        mLedgerFragment = new LedgerFragment();
        mFaultFragment = new FaultFragment();
        //添加到数据集合
        mFragments.add(mDefectFragment);
        mFragments.add(mHiddenFragment);
        mFragments.add(mTaskFragment);
        mFragments.add(mLedgerFragment);
        mFragments.add(mFaultFragment);
        //设置tab
        mBinding.tabDeviceContent.setViewPager(mBinding.vpDeviceContent,titles ,this ,mFragments);
        mFragments.clear(); //清空数据释放内存
    }
}
