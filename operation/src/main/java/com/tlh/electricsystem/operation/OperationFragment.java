package com.tlh.electricsystem.operation;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tlh.electricsystem.base.base.BaseFragment;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.base.utils.RecyclerViewHelper;
import com.tlh.electricsystem.operation.adapter.OperationAdapter;
import com.tlh.electricsystem.operation.bean.OperationBean;
import com.tlh.electricsystem.operation.bean.OperationItemBean;
import com.tlh.electricsystem.operation.databinding.FragmentOperationBinding;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class OperationFragment extends BaseFragment<FragmentOperationBinding ,BaseViewModel> {
    private OperationAdapter mOperationAdapter ; //适配器列表
    private List<OperationBean> mOperationBeans ; //数据源
    private List<OperationItemBean> operationItemBeans1;
    private List<OperationItemBean> operationItemBeans2;
    private List<OperationItemBean> operationItemBeans3;
    @Override
    public int initContentView( LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        return R.layout.fragment_operation;
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
        mOperationBeans = new ArrayList<>();
        operationItemBeans1 = new ArrayList<>();
        operationItemBeans2 = new ArrayList<>();
        operationItemBeans3 = new ArrayList<>();
        addData1();
        addData2();
        addData3();
        OperationBean operationBean1 = new OperationBean("工作" ,operationItemBeans1);
        OperationBean operationBean2 = new OperationBean("运维" ,operationItemBeans2);
        OperationBean operationBean3 = new OperationBean("学习" ,operationItemBeans3);
        mOperationBeans.add(operationBean1);
        mOperationBeans.add(operationBean2);
        mOperationBeans.add(operationBean3);
        mOperationAdapter = new OperationAdapter(R.layout.operation_item_layout,mOperationBeans);
        RecyclerViewHelper.initRecyclerViewV(m_Activity,mBinding.operationRecyclerView ,mOperationAdapter);
    }

    private void addData3() {
        OperationItemBean operationItemBean1 = new OperationItemBean("" ,"设备知识");
        OperationItemBean operationItemBean2 = new OperationItemBean("","专业知识");
        OperationItemBean operationItemBean3 = new OperationItemBean("","操作规范");
        OperationItemBean operationItemBean4 = new OperationItemBean("","业务文档");
        operationItemBeans3.add(operationItemBean1);
        operationItemBeans3.add(operationItemBean2);
        operationItemBeans3.add(operationItemBean3);
        operationItemBeans3.add(operationItemBean4);
    }

    private void addData2() {
        OperationItemBean operationItemBean1 = new OperationItemBean("" ,"任务分配");
        OperationItemBean operationItemBean2 = new OperationItemBean("","路线规划");
        OperationItemBean operationItemBean3 = new OperationItemBean("","班组管理");
        OperationItemBean operationItemBean4 = new OperationItemBean("","数据报表");
        operationItemBeans2.add(operationItemBean1);
        operationItemBeans2.add(operationItemBean2);
        operationItemBeans2.add(operationItemBean3);
        operationItemBeans2.add(operationItemBean4);
    }

    private void addData1() {
        OperationItemBean operationItemBean1 = new OperationItemBean("" ,"缺陷上报");
        OperationItemBean operationItemBean2 = new OperationItemBean("","缺陷设备");
        OperationItemBean operationItemBean3 = new OperationItemBean("","隐患上报");
        OperationItemBean operationItemBean4 = new OperationItemBean("","隐患设备");
        OperationItemBean operationItemBean5 = new OperationItemBean("","操作票");
        OperationItemBean operationItemBean6 = new OperationItemBean("","工作票");
        OperationItemBean operationItemBean7 = new OperationItemBean("","计划任务");
        OperationItemBean operationItemBean8 = new OperationItemBean("","待我审核");
        operationItemBeans1.add(operationItemBean1);
        operationItemBeans1.add(operationItemBean2);
        operationItemBeans1.add(operationItemBean3);
        operationItemBeans1.add(operationItemBean4);
        operationItemBeans1.add(operationItemBean5);
        operationItemBeans1.add(operationItemBean6);
        operationItemBeans1.add(operationItemBean7);
        operationItemBeans1.add(operationItemBean8);
    }
}
