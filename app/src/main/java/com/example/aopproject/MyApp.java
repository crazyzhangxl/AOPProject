package com.example.aopproject;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;

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
       if (BuildConfig.DEBUG) {
           ARouter.openLog();
           ARouter.openDebug();
       }
        // 尽可能早，推荐在Application中初始化
        ARouter.init(this);
    }

    public static Context getmContext() {
        return mContext;
    }

    public static void setmContext(Context mContext) {
        MyApp.mContext = mContext;
    }
}
