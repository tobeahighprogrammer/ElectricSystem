package com.tlh.electricsystem.base.utils;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.TextView;

/**
 * drawable圆角渐变等效果生成工具类
 */

public class DrawableUtil {

    private DrawableUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 得到实心的drawable, 一般作为选中，点中的效果
     *
     * @param cornerRadius 圆角半径
     * @param solidColor   实心颜色
     * @return 得到实心效果
     */
    public static GradientDrawable getSolidRectDrawable(int cornerRadius, int solidColor) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        // 设置矩形的圆角半径
        gradientDrawable.setCornerRadius(cornerRadius);
        // 设置绘画图片色值
        gradientDrawable.setColor(solidColor);
        // 绘画的是矩形
        gradientDrawable.setGradientType(GradientDrawable.RADIAL_GRADIENT);
        return gradientDrawable;
    }

    /**
     * 得到实心的drawable, 一般作为选中，点中的效果
     *
     * @param solidColor        实心颜色
     * @return 得到实心效果
     */
    public static GradientDrawable getSolidRectDrawable(int topLeftRadius, int topRightRadius, int bottomLeftRadius, int bottomRightRadius, int solidColor) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        // 设置矩形的圆角半径
        gradientDrawable.setCornerRadii(new float[]{topLeftRadius, topLeftRadius, topRightRadius, topRightRadius, bottomLeftRadius, bottomLeftRadius, bottomRightRadius, bottomRightRadius});
        // 设置绘画图片色值
        gradientDrawable.setColor(solidColor);
        // 绘画的是矩形
        gradientDrawable.setGradientType(GradientDrawable.RADIAL_GRADIENT);
        return gradientDrawable;
    }

    /**
     * 得到空心的效果，一般作为默认的效果
     *
     * @param cornerRadius 圆角半径
     * @param solidColor   实心颜色
     * @param strokeColor  边框颜色
     * @param strokeWidth  边框宽度
     * @return 得到空心效果
     */
    public static GradientDrawable getStrokeRectDrawable(int cornerRadius, int solidColor, int strokeColor, int strokeWidth) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(strokeWidth, strokeColor);
        gradientDrawable.setColor(solidColor);
        gradientDrawable.setCornerRadius(cornerRadius);
        gradientDrawable.setGradientType(GradientDrawable.RADIAL_GRADIENT);
        return gradientDrawable;
    }

    /**
     * 得到空心的效果，一般作为默认的效果
     *
     * @param solidColor        实心颜色
     * @param strokeColor       边框颜色
     * @param strokeWidth       边框宽度
     * @return 得到空心效果
     */
    public static GradientDrawable getStrokeRectDrawable(int topLeftRadius, int topRightRadius, int bottomLeftRadius, int bottomRightRadius
            , int solidColor, int strokeColor, int strokeWidth) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(strokeWidth, strokeColor);
        gradientDrawable.setColor(solidColor);
        gradientDrawable.setCornerRadii(new float[]{topLeftRadius, topLeftRadius, topRightRadius, topRightRadius, bottomLeftRadius, bottomLeftRadius, bottomRightRadius, bottomRightRadius});
        gradientDrawable.setGradientType(GradientDrawable.RADIAL_GRADIENT);
        return gradientDrawable;
    }

    /**
     * 背景选择器
     *
     * @param pressedDrawable 按下状态的Drawable
     * @param normalDrawable  正常状态的Drawable
     * @return 状态选择器
     */
    public static StateListDrawable getStateListDrawable(Drawable pressedDrawable, Drawable normalDrawable) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_pressed}, pressedDrawable);
        stateListDrawable.addState(new int[]{android.R.attr.state_enabled}, normalDrawable);
        //设置不能用的状态
        //默认其他状态背景
        stateListDrawable.addState(new int[]{}, normalDrawable);
        return stateListDrawable;
    }

    /**
     * 实心  状态选择器
     *
     * @param cornerRadius 圆角半径
     * @param pressedColor 按下颜色
     * @param normalColor  正常的颜色
     * @return 状态选择器
     */
    public static StateListDrawable getDrawable(int cornerRadius, int pressedColor, int normalColor) {
        return getStateListDrawable(getSolidRectDrawable(cornerRadius, pressedColor), getSolidRectDrawable(cornerRadius, normalColor));
    }

    /**
     * 得到 正常空心， 按下实心的状态选择器
     *
     * @param cornerRadiusPX 圆角半径
     * @param strokeWidthPX  边框宽度
     * @param subColor       表框颜色
     * @param mainColor      实心颜色
     * @return 状态选择器
     */
    public static StateListDrawable getStrokeSolidDrawable(int cornerRadiusPX, int strokeWidthPX, int subColor, int mainColor) {
        //一般solidColor 为透明
        return getStateListDrawable(
                //实心
                getSolidRectDrawable(cornerRadiusPX, subColor),
                //空心
                getStrokeRectDrawable(cornerRadiusPX, mainColor, subColor, strokeWidthPX));
    }

    /**
     * 得到 正常空心， 按下实心的状态选择器
     *
     * @param cornerRadiusPX 圆角半径
     * @param strokeWidthPX  边框宽度
     * @param subColor       表框颜色
     * @param mainColor      实心颜色
     * @return 状态选择器
     */
    public static StateListDrawable getSolidStrokeDrawable(int cornerRadiusPX, int strokeWidthPX, int subColor, int mainColor) {
        //一般solidColor 为透明
        return getStateListDrawable(
                //空心
                getStrokeRectDrawable(cornerRadiusPX, subColor, mainColor, strokeWidthPX),
                //实心
                getSolidRectDrawable(cornerRadiusPX, mainColor));
    }

    /**
     * 实心 按下的颜色加深
     *
     * @param cornerRadius 圆角半径
     * @param normalColor  正常的颜色
     * @return 状态选择器
     */

    public static StateListDrawable getDrawable(int cornerRadius, int normalColor) {
        return getDrawable(cornerRadius, colorDeep(normalColor), normalColor);
    }

    /**
     * 设置TextView 选择器
     *
     * @param textView     textView
     * @param drawable
     * @param pressedColor 按下的颜色
     * @param normalColor  正常的颜色
     */
    public static void setTextTheme(TextView textView, Drawable drawable, int pressedColor, int normalColor) {
        textView.setBackground(drawable);
        setTextTheme(textView, pressedColor, normalColor);
    }

    /**
     * 设置TextView 选择器
     *
     * @param textView     textView
     * @param pressedColor 按下的颜色
     * @param normalColor  正常的颜色
     */
    public static void setTextTheme(TextView textView, int pressedColor, int normalColor) {
        textView.setTextColor(getColorStateList(pressedColor, normalColor));
        textView.getPaint().setFlags(Paint.FAKE_BOLD_TEXT_FLAG);
    }

    /**
     * 颜色选择器
     *
     * @param pressedColor 按下的颜色
     * @param normalColor  正常的颜色
     * @return 颜色选择器
     */
    public static ColorStateList getColorStateList(int pressedColor, int normalColor) {
        //其他状态默认为白色
        return new ColorStateList(
                new int[][]{{android.R.attr.state_enabled, android.R.attr.state_pressed}, {android.R.attr.state_enabled}, {}},
                new int[]{pressedColor, normalColor, Color.WHITE});
    }

    /**
     * 加深颜色
     *
     * @param color 原色
     * @return 加深后的
     */
    public static int colorDeep(int color) {

        int alpha = Color.alpha(color);
        int red = Color.red(color);
        int green = Color.green(color);
        int blue = Color.blue(color);

        float ratio = 0.8F;

        red = (int) (red * ratio);
        green = (int) (green * ratio);
        blue = (int) (blue * ratio);

        return Color.argb(alpha, red, green, blue);
    }
}
