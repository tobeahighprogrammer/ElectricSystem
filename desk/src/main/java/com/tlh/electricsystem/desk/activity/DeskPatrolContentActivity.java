package com.tlh.electricsystem.desk.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.base.common.ARouterPath;
import com.tlh.electricsystem.base.widget.ViewPagerAdapter;
import com.tlh.electricsystem.desk.R;
import com.tlh.electricsystem.desk.databinding.ActivityPatrolContentBinding;
import com.tlh.electricsystem.desk.fragment.DeskPatrolContentFragment;
import com.tlh.electricsystem.desk.fragment.DeskPatrolDeviceFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 巡视内容页面
 */
@Route(path = ARouterPath.DeskPatrolContentActivity)
public class DeskPatrolContentActivity extends BaseActivity<ActivityPatrolContentBinding, BaseViewModel> {

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
        mBinding.includePatrolContentTitle.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build(ARouterPath.DeviceContentActivity).navigation();
            }
        });
        mBinding.tlPatrolContent.setupWithViewPager(mBinding.vpPatrolContent);

        String[] mTitles = {"巡视内容", "巡视设备"};
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new DeskPatrolContentFragment());
        fragments.add(new DeskPatrolDeviceFragment());
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mTitles, fragments);
        mBinding.vpPatrolContent.setAdapter(viewPagerAdapter);
    }
}
