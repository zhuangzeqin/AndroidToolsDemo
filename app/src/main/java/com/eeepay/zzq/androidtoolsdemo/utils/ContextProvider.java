package com.eeepay.zzq.androidtoolsdemo.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * 描述：ContextProvider，提供全局Context的单例类，提供get()方法获取单例实例，第一次构造时才从ApplicationContextProvider中获取Context来初始化自身。
 * 作者：zhuangzeqin
 * 时间: 2020/7/1-17:58
 * 邮箱：zzq@eeepay.cn
 * 备注:使用，例如使用全局Context发送广播
 * Intent intent = new Intent("action_update_user_info");
 * ContextProvider.get().getContext().sendBroadcast(intent);
 */
public final class ContextProvider {
    @SuppressLint("StaticFieldLeak")
    private static volatile ContextProvider instance;
    private Context mContext;

    private ContextProvider(Context context) {
        mContext = context;
    }

    /**
     * 获取实例
     */
    public static ContextProvider get() {
        if (instance == null) {
            synchronized (ContextProvider.class) {
                if (instance == null) {
                    Context context = ApplicationContextProvider.mContext;
                    if (context == null) {
                        throw new IllegalStateException("context == null");
                    }
                    instance = new ContextProvider(context);
                }
            }
        }
        return instance;
    }

    /**
     * 获取上下文
     */
    public Context getContext() {
        return mContext;
    }



    public Application getApplication() {
        return (Application) mContext.getApplicationContext();
    }
}
