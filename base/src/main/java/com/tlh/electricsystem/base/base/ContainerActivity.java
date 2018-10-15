package com.tlh.electricsystem.base.base;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.tlh.electricsystem.base.R;
import com.tlh.electricsystem.base.base.BaseFragment;
import com.tlh.electricsystem.base.databinding.ContainerLayoutBinding;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import java.lang.ref.WeakReference;

import static android.view.View.generateViewId;

/**
 * 盛装Fragment的一个容器(代理)Activity
 * 普通界面只需要编写Fragment,使用此Activity盛装,这样就不需要每个界面都在AndroidManifest中注册一遍
 */
public class ContainerActivity extends BaseActivity<ContainerLayoutBinding,BaseViewModel> {

    public static final String FRAGMENT = "fragment";
    public static final String TITLE = "title";
    public static final String BUNDLE = "bundle";
    protected WeakReference<BaseFragment> mFragment;


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
//        super.onCreate(savedInstanceState);
//        Resources res = getResources();
//        Drawable drawable = res.getDrawable(R.color.bkcolor);
//        getWindow().setBackgroundDrawable(drawable);
//        mianLayout = new LinearLayout(this);
//        mianLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
//        //generateViewId()生成不重复的id
//        mianLayout.setId(generateViewId());
//        setContentView(mianLayout);
//        FragmentManager fm = getSupportFragmentManager();
//        Fragment fragment = fm.findFragmentById(mianLayout.getId());
//        if ( fragment == null ) {
//            initFromIntent(getIntent());
//        }
//    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.container_layout;
    }

    @Override
    public int initVariableId() {
        return 0;
    }

    @Override
    public BaseViewModel initViewModel() {
        return new BaseViewModel(this);
    }

    //初始化数据
    @Override
    public void initData() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fl_container);
        if ( fragment == null ) {
            initFromIntent(getIntent());
        }
    }

    protected void initFromIntent(Intent data) {
        if (data == null) {
            throw new RuntimeException(
                    "you must provide a page info to display");
        }
        try {
            String title = data.getStringExtra(TITLE);
            if (!TextUtils.isEmpty(title)){
                initToolbar(mBinding.mToolbar , title);
            }else{
                initToolbar( mBinding.mToolbar , "");
            }
            String fragmentName = data.getStringExtra(FRAGMENT);
            if (fragmentName == null || "".equals(fragmentName)) {
                throw new IllegalArgumentException("can not find page fragmentName");
            }
            Class<?> fragmentClass = Class.forName(fragmentName);
            BaseFragment fragment = (BaseFragment) fragmentClass.newInstance();

            Bundle args = data.getBundleExtra(BUNDLE);
            if (args != null) {
                fragment.setArguments(args);
            }
            FragmentTransaction trans = getSupportFragmentManager()
                    .beginTransaction();
            trans.replace(R.id.fl_container , fragment);
            trans.commitAllowingStateLoss();
            mFragment = new WeakReference<>(fragment);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fl_container);
        if (fragment instanceof BaseFragment) {
            if (!((BaseFragment) fragment).onBackPressed()) {
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }
}
