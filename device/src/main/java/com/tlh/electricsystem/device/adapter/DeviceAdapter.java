package com.tlh.electricsystem.device.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tlh.electricsystem.device.R;
import com.tlh.electricsystem.device.bean.DeviceBean;

import java.util.List;

/**
 * Created by Administrator on 2018/9/29 0029.
 */

public class DeviceAdapter extends BaseMultiItemQuickAdapter<DeviceBean ,BaseViewHolder> {
    public static final int ITEM_TYPE_DEVICE_1 = 1;
    public static final int ITEM_TYPE_DEVICE_2 = 2;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     * @param data A new list is created out of this one to avoid mutable list
     */
    public DeviceAdapter( List<DeviceBean> data ) {
        super(data);
        addItemType( ITEM_TYPE_DEVICE_1 , R.layout.device_type_item );
        addItemType( ITEM_TYPE_DEVICE_2 , R.layout.device_info_item );
    }

    @Override
    protected void convert( BaseViewHolder helper, DeviceBean item ) {

    }
}
