package com.tlh.electricsystem.base.utils;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;


/**
 * Created by Administrator
 * on 2017/4/5 0005.
 */

public class RecyclerViewHelper {

    private RecyclerViewHelper() {
        throw new RuntimeException("RecyclerViewHelper cannot be initialized!");
    }

    /**
     * 配置网格列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewG(Context context, RecyclerView view,
                                         RecyclerView.Adapter adapter, int column) {
        GridLayoutManager layoutManager = new GridLayoutManager( context, column , LinearLayoutManager.VERTICAL, false);
        ((DefaultItemAnimator) view.getItemAnimator()).setSupportsChangeAnimations(false);
        view.setLayoutManager(layoutManager);
        view.setAdapter(adapter);
    }
    /**
     * 配置网格列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewHG(Context context, RecyclerView view,
                                          RecyclerView.Adapter adapter, int column) {
        GridLayoutManager layoutManager = new GridLayoutManager( context, column , LinearLayoutManager.HORIZONTAL, false);
        ((DefaultItemAnimator) view.getItemAnimator()).setSupportsChangeAnimations(false);
        view.setLayoutManager(layoutManager);
        view.setAdapter(adapter);
    }


    public static void initRecyclerViewG(Context context, RecyclerView view,
                                         RecyclerView.Adapter adapter, int column,boolean b) {
        initRecyclerViewG(context,view,adapter,column);
        view.setNestedScrollingEnabled(b);
    }


    /**
     * 配置水平列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewH(Context context, RecyclerView view,
                                         RecyclerView.Adapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        ((DefaultItemAnimator) view.getItemAnimator()).setSupportsChangeAnimations(false);
        view.setLayoutManager(layoutManager);
        view.setAdapter(adapter);
    }
    /**
     * 配置水平列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewH(Context context, RecyclerView view,
                                         RecyclerView.Adapter adapter,boolean b) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context , LinearLayoutManager.HORIZONTAL , b);
        ((DefaultItemAnimator) view.getItemAnimator()).setSupportsChangeAnimations(false);
        view.setLayoutManager(layoutManager);
        view.setAdapter(adapter);
    }
    /**
     * 配置垂直列表RecyclerView
     *
     * @param view
     */
    public static void initRecyclerViewV(Context context, RecyclerView view,
                                         RecyclerView.Adapter adapter) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context.getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ((DefaultItemAnimator) view.getItemAnimator()).setSupportsChangeAnimations(false);
        view.setLayoutManager(layoutManager);
        view.setAdapter(adapter);
    }

    //设置 setNestedScrollingEnabled  b 状态
    public static void initRecyclerViewV( Context context, RecyclerView view,
                                         RecyclerView.Adapter adapter, boolean b ) {
        view.setNestedScrollingEnabled(b);
        initRecyclerViewV(context, view, adapter);
    }

    //设置 RecyclerView.ItemDecoration   itemDecoration 状态
    public static void initRecyclerViewV(Context context, RecyclerView view,
                                         RecyclerView.Adapter adapter,RecyclerView.ItemDecoration itemDecoration) {
        view.addItemDecoration(itemDecoration);
        initRecyclerViewV(context, view, adapter);
    }

}