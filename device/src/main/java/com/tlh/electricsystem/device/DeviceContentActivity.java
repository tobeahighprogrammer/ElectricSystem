package com.tlh.electricsystem.device;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.base.common.ARouterPath;
import com.tlh.electricsystem.base.utils.CommonPopupWindow;
import com.tlh.electricsystem.base.utils.RecyclerViewHelper;
import com.tlh.electricsystem.device.adapter.ScreenAdapter;
import com.tlh.electricsystem.device.bean.ScreenBean;
import com.tlh.electricsystem.device.bean.ScreenItemBean;
import com.tlh.electricsystem.device.databinding.ActivityDeviceContentBinding;
import com.tlh.electricsystem.device.fragment.DefectFragment;
import com.tlh.electricsystem.device.fragment.DynamicFragment;
import com.tlh.electricsystem.device.fragment.FaultFragment;
import com.tlh.electricsystem.device.fragment.HiddenFragment;
import com.tlh.electricsystem.device.fragment.LedgerFragment;
import com.tlh.electricsystem.device.fragment.TaskFragment;
import com.tlh.electricsystem.device.viewModel.DeviceContentViewModel;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARouterPath.DeviceContentActivity)
public class DeviceContentActivity extends BaseActivity<ActivityDeviceContentBinding, DeviceContentViewModel> implements CommonPopupWindow.ViewInterface {
    private ArrayList<Fragment>  mFragments; // 承装Fragment 集合
    private String[] titles = { "缺陷" ,"隐患" ,"任务" ,"台账" ,"故障" , "动态" }; //设置指示栏名称
    //子页面
    private DefectFragment mDefectFragment; //缺陷页面
    private HiddenFragment mHiddenFragment; //隐患页面
    private TaskFragment mTaskFragment; //任务页面
    private LedgerFragment mLedgerFragment ; //台账页面
    private FaultFragment mFaultFragment ; //故障页面
    private DynamicFragment mDynamicFragment; //动态页面
    private ScreenAdapter mScreenAdapter ;
    private List<ScreenBean> mScreenBeans;

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
        //1.初始化title
        initToolbar(mBinding.mToolbar);
        //2.初始化抽屉布局
        mScreenBeans = new ArrayList<>();
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;         // 屏幕宽度（像素）
        //设置抽屉的宽度
        DrawerLayout.LayoutParams params = (DrawerLayout.LayoutParams) mBinding.rightDrawer.getRoot().getLayoutParams();
        params.width =width / 3 * 2;
        params.height = RelativeLayout.LayoutParams.MATCH_PARENT;
        mBinding.rightDrawer.getRoot().setLayoutParams(params);
        setDate1();
        setDate2();
        setDate3();
        setDate4();
        setDate5();
        mScreenAdapter = new ScreenAdapter(R.layout.screen_item_layout , mScreenBeans);
        RecyclerViewHelper.initRecyclerViewV(this ,mBinding.rightDrawer.mScreenRecyclerView ,mScreenAdapter);
        //3.初始化子页面
        mFragments = new ArrayList<>();
        mDefectFragment = new DefectFragment();
        mHiddenFragment = new HiddenFragment();
        mTaskFragment = new TaskFragment();
        mLedgerFragment = new LedgerFragment();
        mFaultFragment = new FaultFragment();
        mDynamicFragment = new DynamicFragment();
        //4.添加到数据集合
        mFragments.add( mDefectFragment ) ;
        mFragments.add( mHiddenFragment ) ;
        mFragments.add( mTaskFragment ) ;
        mFragments.add( mLedgerFragment ) ;
        mFragments.add( mFaultFragment ) ;
        mFragments.add( mDynamicFragment ) ;
        //5.设置tab
        mBinding.tabDeviceContent.setViewPager( mBinding.vpDeviceContent , titles ,this , mFragments );
        mBinding.tabDeviceContent.showMsg(3,3);
        mBinding.tabDeviceContent.setMsgMargin(3 , 15 , 10 );
    }

    private void setDate1() {
        ScreenBean screenBean = new ScreenBean();
        List<ScreenItemBean> screenItemBeans = new ArrayList<>();
        ScreenItemBean screenItemBean1 = new ScreenItemBean();
        ScreenItemBean screenItemBean2 = new ScreenItemBean();
        ScreenItemBean screenItemBean3 = new ScreenItemBean();
        screenBean.setName("设备状态");
        screenItemBean1.setValue("设备状态");
        screenItemBean2.setValue("设备状态");
        screenItemBean3.setValue("设备状态");
        screenItemBeans.add(screenItemBean1);
        screenItemBeans.add(screenItemBean2);
        screenItemBeans.add(screenItemBean3);
        screenBean.setScreenItemBeans(screenItemBeans);
        mScreenBeans.add(screenBean);
    }
    private void setDate2() {
        ScreenBean screenBean = new ScreenBean();
        List<ScreenItemBean> screenItemBeans = new ArrayList<>();
        ScreenItemBean screenItemBean1 = new ScreenItemBean();
        ScreenItemBean screenItemBean2 = new ScreenItemBean();
        screenBean.setName("缺陷登记时间周期");
        screenItemBean1.setValue("开始时间");
        screenItemBean2.setValue("结束时间");
        screenItemBeans.add(screenItemBean1);
        screenItemBeans.add(screenItemBean2);
        screenBean.setScreenItemBeans(screenItemBeans);
        mScreenBeans.add(screenBean);
    }
    private void setDate3() {
        ScreenBean screenBean = new ScreenBean();
        List<ScreenItemBean> screenItemBeans = new ArrayList<>();
        ScreenItemBean screenItemBean1 = new ScreenItemBean();
        ScreenItemBean screenItemBean2 = new ScreenItemBean();
        screenBean.setName("是否消缺");
        screenItemBean1.setValue("是");
        screenItemBean2.setValue("否");
        screenItemBeans.add(screenItemBean1);
        screenItemBeans.add(screenItemBean2);
        screenBean.setScreenItemBeans(screenItemBeans);
        mScreenBeans.add(screenBean);
    }

    private void setDate4() {
        ScreenBean screenBean = new ScreenBean();
        List<ScreenItemBean> screenItemBeans = new ArrayList<>();
        ScreenItemBean screenItemBean1 = new ScreenItemBean();
        ScreenItemBean screenItemBean2 = new ScreenItemBean();
        ScreenItemBean screenItemBean3 = new ScreenItemBean();
        screenItemBean1.setValue("设备状态");
        screenItemBean2.setValue("设备状态");
        screenItemBean3.setValue("设备状态");
        screenItemBeans.add(screenItemBean1);
        screenItemBeans.add(screenItemBean2);
        screenItemBeans.add(screenItemBean3);
        screenBean.setName("缺陷性质");
        screenBean.setScreenItemBeans(screenItemBeans);
        mScreenBeans.add(screenBean);
    }

    private void setDate5() {
        ScreenBean screenBean = new ScreenBean();
        List<ScreenItemBean> screenItemBeans = new ArrayList<>();
        ScreenItemBean screenItemBean1 = new ScreenItemBean();
        ScreenItemBean screenItemBean2 = new ScreenItemBean();
        screenBean.setName("验收情况");
        screenBean.setScreenItemBeans(screenItemBeans);
        screenItemBean1.setValue("验收情况");
        screenItemBean2.setValue("验收情况");
        screenItemBeans.add(screenItemBean1);
        screenItemBeans.add(screenItemBean2);
        mScreenBeans.add(screenBean);
    }

    @Override
    public void initListener() {
        //筛选的监听
        mBinding.tvScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 按钮按下，将抽屉打开
                mBinding.mDrawerLayout.openDrawer(Gravity.RIGHT);
            }
        });
        mBinding.tvDefectState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mViewModel.showUpPop(mBinding.tvDefectState,mContext,DeviceContentActivity.this);
            }
        });
        //抽屉重置的监听
        mBinding.rightDrawer.tvReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.mDrawerLayout.closeDrawer(Gravity.RIGHT);
            }
        });
        //抽屉确定的监听
        mBinding.rightDrawer.tvSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.mDrawerLayout.closeDrawer(Gravity.RIGHT);
            }
        });
    }

    @Override
    public void getChildView( View view, int layoutResId ) {
        view.findViewById(R.id.photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.dissPop();
            }
        });
        view.findViewById(R.id.vedio).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.dissPop();
            }
        });
        view.findViewById(R.id.vedio2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.dissPop();
            }
        });
        view.findViewById(R.id.vedio3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.dissPop();
            }
        });
    }
}
