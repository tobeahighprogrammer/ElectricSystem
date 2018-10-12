package com.tlh.electricsystem.device.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tlh.electricsystem.base.base.BaseFragment;
import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.base.utils.RecyclerViewHelper;
import com.tlh.electricsystem.device.R;
import com.tlh.electricsystem.device.adapter.DynamicAdapter;
import com.tlh.electricsystem.device.adapter.LedgerAdapter;
import com.tlh.electricsystem.device.bean.DynamicBean;
import com.tlh.electricsystem.device.bean.LedgerBean;
import com.tlh.electricsystem.device.databinding.FragmentDefectBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LedgerFragment extends BaseFragment<FragmentDefectBinding,BaseViewModel> {
    private LedgerAdapter mLedgerAdapter; //设配器
    private List<LedgerBean> mLedgerBeans; //数据源

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_defect;
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
        mLedgerBeans = new ArrayList<>();
        mLedgerBeans.add(new LedgerBean(0 ,"设备id" ,"000000001x"));
        mLedgerBeans.add(new LedgerBean(1,"设备名称" ,"啊啊啊啊"));
        mLedgerBeans.add(new LedgerBean(1,"设备类型" ,"设备类型"));
        mLedgerBeans.add(new LedgerBean(1,"设备编码" ,"设备编码"));
        mLedgerBeans.add(new LedgerBean(1,"电压等级" ,"电压等级"));
        mLedgerBeans.add(new LedgerBean(1,"投运日期" ,"投运日期"));
        mLedgerBeans.add(new LedgerBean(3,"设备信息" ,""));
        mLedgerBeans.add(new LedgerBean(1,"设备型号" ,"设备型号"));
        mLedgerBeans.add(new LedgerBean(2,"设备图片" ,""));
        mLedgerBeans.add(new LedgerBean(1,"生产厂家" ,"生产厂家"));
        mLedgerBeans.add(new LedgerBean(1,"出厂DATE" ,"出厂DATE"));
        mLedgerBeans.add(new LedgerBean(1,"设备状态" ,"设备状态"));
        mLedgerBeans.add(new LedgerBean(1,"专业分类" ,"专业分类"));
        mLedgerBeans.add(new LedgerBean(1,"资产性质" ,"资产性质"));
        mLedgerBeans.add(new LedgerBean(1,"资产单位" ,"资产单位"));

        mLedgerBeans.add(new LedgerBean(3,"维护班组信息" ,""));
        mLedgerBeans.add(new LedgerBean(1,"维护班组" ,"维护班组"));
        mLedgerBeans.add(new LedgerBean(1,"班组ID" ,"班组ID"));
        mLedgerBeans.add(new LedgerBean(1,"所在地市" ,"所在地市"));

        mLedgerBeans.add(new LedgerBean(3,"设备数据" ,""));
        mLedgerBeans.add(new LedgerBean(1,"额定电压" ,"额定电压"));
        mLedgerBeans.add(new LedgerBean(1,"额定电流" ,"额定电流"));
        mLedgerBeans.add(new LedgerBean(1,"额定熔断电流（kA)" ,"额定熔断电流"));
        mLedgerBeans.add(new LedgerBean(1,"额定频率" ,"额定频率"));
        mLedgerBeans.add(new LedgerBean(1,"额定电流比" ,"额定电流比"));
        mLedgerBeans.add(new LedgerBean(1,"额定电压比" ,"额定电压比"));
        mLedgerBeans.add(new LedgerBean(1,"动稳定电流" ,"动稳定电流"));
        mLedgerBeans.add(new LedgerBean(1,"热稳定电流" ,"热稳定电流"));
        mLedgerBeans.add(new LedgerBean(1,"空载电流" ,"33"));
        mLedgerBeans.add(new LedgerBean(1,"短路损耗（kW)" ,"33"));
        mLedgerBeans.add(new LedgerBean(1,"总重（t)" ,"33"));
        mLedgerBeans.add(new LedgerBean(1,"器身重（t)" ,"33"));
        mLedgerBeans.add(new LedgerBean(1,"空载损耗（kW)" ,"33"));
        mLedgerBeans.add(new LedgerBean(1,"额定短路持续时间（s)" ,"33"));
        mLedgerBeans.add(new LedgerBean(1,"额定短路开短电流（kA)" ,"33"));
        mLedgerBeans.add(new LedgerBean(1,"二次绕组总数量（个）" ,"33"));
        mLedgerBeans.add(new LedgerBean(1,"SF6气体额定压力" ,"33"));
        mLedgerBeans.add(new LedgerBean(1,"SF6气体额定压力" ,"33"));

        mLedgerAdapter = new LedgerAdapter(mLedgerBeans);
        RecyclerViewHelper.initRecyclerViewV( m_Activity , mBinding.relDevice , mLedgerAdapter );
    }

}
