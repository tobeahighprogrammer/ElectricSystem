package com.tlh.electricsystem;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tlh.electricsystem.base.base.BaseActivity;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.databinding.ActivitySplashBinding;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, BaseViewModel> {
    private Disposable mdDisposable;
    private SplashHander splashHander;

    //计时器
    private static class SplashHander extends Handler {
        private SoftReference<SplashActivity> softReference;

        public SplashHander(SplashActivity softReference) {
            this.softReference = new SoftReference<>(softReference);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            SplashActivity splashActivity = softReference.get();
            if (splashActivity != null) {
                splashActivity.mdDisposable = Flowable.intervalRange(0, 4, 0, 1, TimeUnit.SECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnNext(aLong -> {
                            splashActivity.setTextMiss(aLong);
                        })
                        .doOnComplete(() -> {
                            //倒计时完毕置为可点击状态
                            splashActivity.startAct();
                        })
                        .subscribe();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        return R.layout.activity_splash;
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
        mBinding.timerText.setEnabled(false);
        splashHander = new SplashHander(this);
        splashHander.sendEmptyMessageDelayed(0, 1000);
//        Glide.with(this).load("https://myimage.immouo.com//o_1cbejc2kogol1pgddlub5r16o0cs.jpg").into(imageView);
    }

    //设置计数时间
    public void setTextMiss(Long aLong) {
        mBinding.timerText.setEnabled(true);
        mBinding.timerText.setText("跳过 " + (3 - aLong));
    }

    //跳转登录页面
    public void startAct() {
        if (mdDisposable != null) {
            mdDisposable.dispose();
        }
        mBinding.timerText.setVisibility(View.GONE);
//        if (PreferenceHelper.getBoolean("isLogin" , false)){
//            ActivityUtil.switchTo( mActivity , new Intent( mActivity , MainActivity.class ));
//        }else{
//            ActivityUtil.switchTo( mActivity , new Intent( mActivity , MainActivity.class ));
//        }
        mViewModel.startActivity(LoginActivity.class);
        SplashActivity.this.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mdDisposable != null) {
            mdDisposable.dispose();
        }
    }
}
