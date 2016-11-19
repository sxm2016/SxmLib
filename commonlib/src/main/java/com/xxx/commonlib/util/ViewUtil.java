package com.xxx.commonlib.util;

import android.app.Activity;
import android.view.View;

/**
 * View工具类
 * Created by shixm on 2016/11/19.
 */
public class ViewUtil {

    @SuppressWarnings("unchecked")
    public static <E extends View> E findViewById(Activity activity, int resId) {
        return (E) activity.findViewById(resId);
    }

    @SuppressWarnings("unchecked")
    public static <E extends View> E findViewById(View view, int resId) {
        return (E) view.findViewById(resId);
    }
}
