package com.baway.zhangyuanyang1503a20170522;

import android.app.Application;
import android.os.Build;

import org.xutils.DbManager;
import org.xutils.x;

import java.io.File;

/**
 * Created by 张芫阳 on 2017/5/22.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);


    }
}
