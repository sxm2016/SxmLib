package com.xxx.xxx.base;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xxx.commonlib.util.ViewUtil;

/**
 * Activity基类
 * 约定所有Activity继承该类
 * Create by shixm on 2016/11/19
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ((BaseApp) getApplication()).addActivity(this);
        initVariable();
        initView(savedInstanceState);
        loadData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ((BaseApp) getApplication()).removeActivity(this);
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        Configuration config=new Configuration();
        config.setToDefaults();
        res.updateConfiguration(config,res.getDisplayMetrics() );
        return res;
    }

    /**
     * 初始化变量，包括获取Intent带的数据和Acivity内的变量
     */
    protected void initVariable() {
    }

    /**
     * 加载layout布局，初始化控件，为控件添加监听事件
     * @param savedInstanceState
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 加载数据
     */
    protected void loadData() {
    }

    /**
     * 得到控件
     * @param resId 控件ID
     * @param <T> 控件
     * @return
     */
    public <T extends View> T $(int resId){
        return ViewUtil.findViewById(this, resId);
    }
}
