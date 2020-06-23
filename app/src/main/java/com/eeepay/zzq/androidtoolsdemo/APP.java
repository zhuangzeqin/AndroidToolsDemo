package com.eeepay.zzq.androidtoolsdemo;

import android.app.Application;

import com.eeepay.zzq.androidtoolsdemo.utils.FastSharedPreferencesTools;

/**
 * 描述：class describe
 * 作者：zhuangzeqin
 * 时间: 2020/6/23-13:50
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class APP extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        /* ------注释说明----初始化操作---- */
        FastSharedPreferencesTools.getInstance().init(this);
    }
}
