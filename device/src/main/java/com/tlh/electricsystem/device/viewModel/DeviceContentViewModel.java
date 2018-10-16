package com.tlh.electricsystem.device.viewModel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.tlh.electricsystem.base.base.BaseViewModel;
import com.tlh.electricsystem.base.utils.CommonPopupWindow;
import com.tlh.electricsystem.device.R;

/**
 * Created by Administrator on 2018/9/30 0030.
 */

public class DeviceContentViewModel extends BaseViewModel {
    private CommonPopupWindow popupWindow;

    public DeviceContentViewModel(Context mContext) {
        super(mContext);
    }

    //向上弹出
    public void showUpPop(View view, Context mContext , CommonPopupWindow.ViewInterface viewInterface) {
        if (popupWindow != null && popupWindow.isShowing()) return;
        popupWindow = new CommonPopupWindow.Builder(mContext)
                .setView(R.layout.popup_layout)
                .setWidthAndHeight(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                .setViewOnclickListener(viewInterface)
                .create();
        popupWindow.showAsDropDown(view, 0, -(popupWindow.getHeight() + view.getMeasuredHeight()));
    }

    //取消弹窗
    public void dissPop(){
        if (popupWindow!= null && popupWindow.isShowing()){
            popupWindow.dismiss();
            popupWindow= null;
        }
    }

}
