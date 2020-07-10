package com.eeepay.zzq.androidtoolsdemo.utils;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * 描述：无侵入式获取全局Context
 * 作者：zhuangzeqin
 * 时间: 2020/7/1-17:49
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class ApplicationContextProvider extends ContentProvider{
    static Context mContext;
    @Override
    public boolean onCreate() {
        mContext = getContext();
        //初始化全局Context提供者
        ContextProvider.get();
        return false;
    }


    @Nullable
    @Override
    public Cursor query(@NonNull  Uri uri,  @Nullable String[] strings,  @Nullable String s,  @Nullable String[] strings1,@Nullable String s1) {
        return null;
    }


    @Nullable
    @Override
    public String getType(@NonNull  Uri uri) {
        return null;
    }


    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri,  @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete( @NonNull Uri uri,  @Nullable String s,  @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update( @NonNull Uri uri, @Nullable ContentValues contentValues,  @Nullable String s, @Nullable  String[] strings) {
        return 0;
    }


}
