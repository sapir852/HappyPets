package com.sapirgolan.myapplication.activity;

import android.app.Application;

import com.sapirgolan.myapplication.activity.DataBase.DataManager;

public class myApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        DataManager.initData(this);
    }
}
