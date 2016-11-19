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
    private ArrayList<Activity> lstActivity = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void addActivity(Activity a) {
        lstActivity.add(a);
    }

    public void removeActivity(Activity a) {
        lstActivity.remove(a);
    }
}

