package com.tlh.electricsystem.base.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences缓存工具类
 */

public class PrefrenceUtil {

    private static SharedPreferences mSharedPreferences = null;
    private static SharedPreferences.Editor mEditor = null;

    /**
     * 初始化默认SharePreferences
     */
    public static void init(Context context) {
        if (null == mSharedPreferences) {
            String pageName = "default_preference";
            mSharedPreferences =
                    context.getSharedPreferences(pageName,
                            Context.MODE_PRIVATE);
        }
    }

    /**
     * 删除数据
     *
     * @param key 键
     */
    public static void removeKey(String key) {
        mEditor = mSharedPreferences.edit();
        mEditor.remove(key);
        mEditor.apply();
    }

    /**
     * 删除所有数据
     */
    public static void removeAll() {
        mEditor = mSharedPreferences.edit();
        mEditor.clear();
        mEditor.apply();
    }

    /**
     * 提交字符串数据
     *
     * @param key   键
     * @param value 值
     */
    public static void commitString(String key, String value) {
        mEditor = mSharedPreferences.edit();
        mEditor.putString(key, value);
        mEditor.apply();
    }

    /**
     * 获取字符串
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 当前键对应的值
     */
    public static String getString(String key, String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

    /**
     * 提交整型
     *
     * @param key   键
     * @param value 值
     */
    public static void commitInt(String key, int value) {
        mEditor = mSharedPreferences.edit();
        mEditor.putInt(key, value);
        mEditor.apply();
    }

    /**
     * 获取整型
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 当前键对应的值
     */
    public static int getInt(String key, int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }

    /**
     * 提交长整型
     *
     * @param key   键
     * @param value 值
     */
    public static void commitLong(String key, long value) {
        mEditor = mSharedPreferences.edit();
        mEditor.putLong(key, value);
        mEditor.apply();
    }

    /**
     * 获取整型
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 当前键对应的值
     */
    public static long getLong(String key, long defaultValue) {
        return mSharedPreferences.getLong(key, defaultValue);
    }

    /**
     * 提交长整型
     *
     * @param key   键
     * @param value 值
     */
    public static void commitBoolean(String key, boolean value) {
        mEditor = mSharedPreferences.edit();
        mEditor.putBoolean(key, value);
        mEditor.apply();
    }

    /**
     * 获取整型
     *
     * @param key          键
     * @param defaultValue 默认值
     * @return 当前键对应的值
     */
    public static Boolean getBoolean(String key, boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }
}
