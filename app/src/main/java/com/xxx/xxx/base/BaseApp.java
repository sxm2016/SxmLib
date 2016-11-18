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

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        System.gc();
    }

}

