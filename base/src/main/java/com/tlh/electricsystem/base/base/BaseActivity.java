package com.tlh.electricsystem.base.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.tlh.electricsystem.base.R;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;


/**
 * Created by Administrator on 2018/9/27 0027.
 */

public abstract class BaseActivity<V extends ViewDataBinding, VM extends BaseViewModel>
        extends RxAppCompatActivity implements IBaseActivity , ItitleClickListener {

    protected V mBinding;
    protected VM mViewModel;
    protected int BR_ID;
    protected Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        //获取传递的参数
        initParam();
        initViewDataBinding(savedInstanceState);
        //初始化数据
        initData();
        initListener();
    }

    /**
     * 注入绑定
     */
    private void initViewDataBinding(Bundle savedInstanceState) {
        //DataBindingUtil类需要在project的build中配置 dataBinding {enabled true }, 同步后会自动关联android.databinding包
        Resources res = getResources();
        Drawable drawable = res.getDrawable(R.color.bkcolor);
        getWindow().setBackgroundDrawable(drawable);
        mBinding = DataBindingUtil.setContentView(this, initContentView(savedInstanceState));
        BR_ID = initVariableId();
        mViewModel = initViewModel();
        if (BR_ID != 0 && mViewModel != null) {
            mBinding.setVariable(initVariableId(), mViewModel);
        }
    }

    //初始化title
    protected void initToolbar(Toolbar mToolbar) {
        mToolbar.setNavigationIcon(R.mipmap.btn_sort);
        //设置导航Button点击事件
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onNavigationClick();
            }
        });
        //填充menu
        mToolbar.inflateMenu(R.menu.toolbar_menu);
        //设置点击事件
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int mItemId = item.getItemId();
                if ( mItemId == R.id.action_message ) {
                    onMessageClick();
                } else if ( mItemId == R.id.action_more ) {
                    onMoreClick();
                } else {

                }
                return false;
            }
        });
    }

    //初始化title
    protected void initToolbar(Toolbar mToolbar , int ResId ) {
        initToolbar(mToolbar);
        mToolbar.setNavigationIcon(ResId);
    }

    //初始化title
    protected void initToolbar(Toolbar mToolbar , String  mTitle ) {
        mToolbar.setSubtitle(mTitle);
        initToolbar(mToolbar);
    }

    //加载toolbar的菜单选项
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mViewModel != null) {
            if (mViewModel.mContext != null) {
                mViewModel.mContext = null;
            }
            if (mViewModel.mFragment != null) {
                mViewModel.mFragment = null;
            }
            mViewModel = null;
        }
        mBinding.unbind();
    }

    //设置布局的ID
    public abstract int initContentView(Bundle savedInstanceState);

    //初始化布局ID
    public abstract int initVariableId();

    //初始化viewModel
    public abstract VM initViewModel();

    //初始化数据
    @Override
    public void initData() { }

    //初始化参数
    @Override
    public void initParam() { }

    @Override
    public void initListener() { }

    @Override
    public void onNavigationClick() { }

    @Override
    public void onMessageClick() { }

    @Override
    public void onMoreClick() { }
}
