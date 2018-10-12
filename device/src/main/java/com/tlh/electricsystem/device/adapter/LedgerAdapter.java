package com.tlh.electricsystem.device.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tlh.electricsystem.device.R;
import com.tlh.electricsystem.device.bean.LedgerBean;

import java.util.List;

/**
 * Created by Administrator on 2018/10/12 0012.
 */

public class LedgerAdapter extends BaseMultiItemQuickAdapter<LedgerBean ,BaseViewHolder> {
    public static final int LEDGER_HEADER_TYPE = 0; //头部的设备id
    public static final int LEDGER_ITEM_TEXT_TYPE = 1; //字符串类型的item
    public static final int LEDGER_ITEM_IMAGE_TYPE = 2; // 图片类型的item
    public static final int LEDGER_ITEM_LINE_TYPE = 3; // 图片类型的item
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     * @param data A new list is created out of this one to avoid mutable list
     */
    public LedgerAdapter(List<LedgerBean> data) {
        super(data);
        addItemType(LEDGER_HEADER_TYPE , R.layout.ledger_header_item ) ;
        addItemType(LEDGER_ITEM_TEXT_TYPE , R.layout.ledger_layout_item );
        addItemType(LEDGER_ITEM_IMAGE_TYPE , R.layout.ledger_layout_image_item );
        addItemType(LEDGER_ITEM_LINE_TYPE , R.layout.ledger_line_item );
    }

    @Override
    protected void convert( BaseViewHolder helper , LedgerBean item ) {
        switch (helper.getItemViewType()){
            case LEDGER_HEADER_TYPE:
                helper.setText(R.id.tv_device_type , item.getValue());
                break;
            case LEDGER_ITEM_TEXT_TYPE:
                helper.setText(R.id.tv_device_type , item.getValue());
                helper.setText(R.id.tv_device_name , item.getName());
                break;
            case LEDGER_ITEM_IMAGE_TYPE:
                helper.setText(R.id.tv_device_name , item.getName());
                break;
            case LEDGER_ITEM_LINE_TYPE:
                helper.setText(R.id.tv_device_name , item.getName());
                break;
        }

    }
}
