package com.tlh.electricsystem.viewModel;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;
import com.tlh.electricsystem.R;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.desk.fragment.DeskFragment;
import com.tlh.electricsystem.device.fragment.DeviceFragment;
import com.tlh.electricsystem.my.UserFragment;
import com.tlh.electricsystem.operation.OperationFragment;


/**
 * Created by Administrator on 2018/9/27 0027.
 * sj:2018年9月28日15:39:08
 * name: ts
 * 用途：首页的VM 层！
 */

public class MainViewModel extends BaseViewModel {

    private View tabView;

    public MainViewModel( Context mContext ) {
        super(mContext);
    }

    //初始化TabHost
    public void initTabHost(FragmentTabHost tabHost ){
        FragmentManager fragmentManager = ((FragmentActivity)mContext).getSupportFragmentManager();
        tabHost.setup(mContext, fragmentManager, R.id.main_real_tab);
        tabHost.getTabWidget().setDividerDrawable(null);
        tabHost.getTabWidget().setMinimumHeight(mContext.getResources().getDimensionPixelOffset(R.dimen.tab_height));
        initFragment(tabHost);
    }

    //初始化Fragment
    private void initFragment(FragmentTabHost tabHost) {
        setFragment(tabHost,"desk", "工作", R.mipmap.course_view_now , DeskFragment.class);
        setFragment(tabHost,"device", "设备", R.mipmap.course_view_now , DeviceFragment.class);
        setFragment(tabHost,"operation", "运维", R.mipmap.course_view_now , OperationFragment.class);
        setFragment(tabHost,"user", "我的", R.mipmap.course_view_now , UserFragment.class);
        tabHost.setCurrentTab(0);
    }

    //设置底部tab的数据
    private void setFragment( FragmentTabHost tabHost ,String tag , String name , int selector , Class  fragment ) {
        View indicator = getIndicatorView( name , mContext.getResources().getDrawable(selector));
        tabHost.addTab( tabHost.newTabSpec(tag).setIndicator(indicator) , fragment, null);
    }

    //设置底部导航栏的内容
    private View  getIndicatorView(String name , Drawable drawable ) {
        drawable.setBounds(0 , 0 , drawable.getMinimumWidth() , drawable.getMinimumHeight() );
        tabView = ((Activity)mContext ).getLayoutInflater().inflate( R.layout.tab_main_item , null);
        TextView text = tabView.findViewById(R.id.tab_text);
        text.setCompoundDrawables(null, drawable, null, null);
        text.setText(name);
        return tabView;
    }

    //修改标题
    public void setTabHostlistener( FragmentTabHost mTabHost ,Toolbar mToolbar){
        mTabHost.setOnTabChangedListener(tabId -> {
         switch (tabId){
             case "desk":
                 mToolbar.setSubtitle("工作台");
                 break;
             case "device":
                 mToolbar.setSubtitle("设备");
                 break;
             case "operation":
                 mToolbar.setSubtitle("运维");
                 break;
             case "user":
                 mToolbar.setSubtitle("我的");
                 break;
         }
        });
    }

}
