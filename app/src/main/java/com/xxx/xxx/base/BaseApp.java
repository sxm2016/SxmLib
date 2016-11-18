package com.xxx.xxx.base;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;

/**
 * App基类
 * Create by shixm on 2016/11/16
 */
public class BaseApp extends Application {

    private final static String TAG = "BaseApp";

    private ArrayList<Activity> activitiesList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

    public void finishActivity() {
        for (Activity activity : activitiesList) {
            if (null != activity) {
                activity.finish();
            }
        }
    }

    public boolean isActivityListEmpty() {
        return activitiesList.size() == 0;
    }
}

