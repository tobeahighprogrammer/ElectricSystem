package com.tlh.electricsystem.base.utils;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/1/19 0019.
 * name ： ts
 * 用途：Edtext的工具类
 */

public class EditTextUtils {

    private static EditTextUtils editTextUtils;

    public static EditTextUtils getEditTextUtils() {
        return editTextUtils == null ? editTextUtils = new EditTextUtils() : editTextUtils;
    }


    /**
     * 禁止EditText输入空格
     *
     * @param editText
     */
    public static void setEditTextInhibitInputSpace(EditText editText) {
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source.equals(" "))
                    return "";
                else
                    return null;
            }
        };
        editText.setFilters(new InputFilter[]{filter});
    }

    /**
     * 禁止EditText输入特殊字符 和空格及回车
     * @param editText
     */
    public static void setEditTextInhibitInputSpeChat(EditText editText) {
        InputFilter filter=new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                //限制特殊字符
                String speChat = "[`\\[\\]/~￥（）——+|{}【】‘；：”“’#*]";
                Pattern pattern = Pattern.compile(speChat);
                Matcher matcher = pattern.matcher(source.toString());
                if (matcher.find()) return "";
                if(source.equals(" ")||source.toString().contentEquals("\n"))return ""; //限制空格和回车
                else return null;
            }
        };
        //这里是限制回车！
        editText.setFilters(new InputFilter[]{filter});
    }

    /**
     * 限制字数和空格
     * @param mEditext
     * @param num
     */
    public static boolean setEditTextInputLength(final EditText mEditext, final int num ,CharSequence s ) {
        Editable editable = mEditext.getText();
        int len = editable.length();
        if (len > num ) {
            int selEndIndex = Selection.getSelectionEnd(editable);
            String str = editable.toString();
            //截取新字符串
            String newStr = str.substring(0, num);
            mEditext.setText(newStr);
            editable = mEditext.getText();
            //新字符串的长度
            int newLen = editable.length();
            //旧光标位置超过字符串长度
            if (selEndIndex > newLen) {
                selEndIndex = editable.length();
            }
            //设置新光标所在的位置
            Selection.setSelection(editable, selEndIndex);
            return true;
        }else{
            return false;
        }
    }

    /**
     * 强制隐藏输入法
     * @param view 监听的那个view
     */
    public static void hideInput(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm.isActive()) {
            imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
        }
    }



    /**
     * 弹出软键盘！
     * @param editText
     */
    public static void showInput(final EditText editText) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                InputMethodManager m = (InputMethodManager) editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                m.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }, 300);
    }

}
