package com.example.aopproject;

import android.app.Application;
import android.content.Context;

/**
 * @author crazyZhangxl on 2019/1/28.
 * Describe:
 */
public class MyApp extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getmContext() {
        return mContext;
    }

    public static void setmContext(Context mContext) {
        MyApp.mContext = mContext;
    }
}
