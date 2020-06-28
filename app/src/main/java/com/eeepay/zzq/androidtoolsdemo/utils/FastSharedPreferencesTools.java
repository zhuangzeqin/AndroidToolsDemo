package com.eeepay.zzq.androidtoolsdemo.utils;

import android.content.Context;
import android.support.annotation.Nullable;

import com.jeremy.fastsharedpreferences.EnhancedEditor;
import com.jeremy.fastsharedpreferences.FastSharedPreferences;

import java.io.Serializable;
import java.util.Set;

/*
 * 描述：FastSharedPreferences是一个Android平台的高性能key-value组件
 * 作者：zhuangzeqin
 * 时间: 2020/6/23-14:06
 * 邮箱：zzq@eeepay.cn
 * 备注:高效的写入/读取性能，读写性能相比SharedPreferences增强了200-300倍
 */
public final class FastSharedPreferencesTools {
    private static final String FSP_ID = "FastSharedPreferencesTools";//名称
    private static volatile FastSharedPreferencesTools mInstance = null;
    private static volatile FastSharedPreferences mFastSharedPreferences = null;//FastSharedPreferences 实例
    private static volatile EnhancedEditor mEdit = null;//EnhancedEditor 实例
    /* ------注释说明---私有的构造函数----- */
    private FastSharedPreferencesTools() {
//        checkFastSharedPreferences();
    }

    /**
     * 单例模式
     * @return
     */
    public static FastSharedPreferencesTools getInstance() {
        if (mInstance == null) {
            synchronized (FastSharedPreferencesTools.class) {
                if (mInstance == null) {
                    mInstance = new FastSharedPreferencesTools();
                }
            }
        }
        return mInstance;
    }

    /**
     * 存放序列化的值
     *
     * @param key
     * @param value
     */
    public void putSerializable(String key, @Nullable Serializable value) {
        checkFastSharedPreferences();
        mEdit.putSerializable(key, value).commit();
    }

    /**
     * 存放String 类型
     *
     * @param key
     * @param value
     */
    public void putString(String key, @Nullable String value) {
        checkFastSharedPreferences();
        mEdit.putString(key, value).commit();
    }

    /**
     * 存放一个boolean类型
     *
     * @param key
     * @param value
     */
    public void putBoolean(String key, boolean value) {
        checkFastSharedPreferences();
        mEdit.putBoolean(key, value).commit();
    }

    /**
     * 存放一个float
     *
     * @param key
     * @param value
     */
    public void putFloat(String key, float value) {
        checkFastSharedPreferences();
        mEdit.putFloat(key, value).commit();
    }

    /**
     * 存放一个 int 类型
     *
     * @param key
     * @param value
     */
    public void putInt(String key, int value) {
        checkFastSharedPreferences();
        mEdit.putInt(key, value).commit();
    }

    /**
     * 存放一个long 类型
     *
     * @param key
     * @param value
     */
    public void putLong(String key, long value) {
        checkFastSharedPreferences();
        mEdit.putLong(key, value).commit();
    }

    /**
     * 存放一个集合 Set<String>
     *
     * @param key
     * @param value Set<String>
     */
    public void putStringSet(String key, @Nullable Set<String> value) {
        checkFastSharedPreferences();
        mEdit.putStringSet(key, value).commit();
    }

    /**
     * 读取序列化的值
     *
     * @param key
     * @param defValue
     * @return
     */
    public Serializable getSerializable(String key, @Nullable Serializable defValue) {
        checkFastSharedPreferences();
        Serializable serializable = mFastSharedPreferences.getSerializable(key, defValue);
        return serializable;
    }

    /**
     * 获取boolean 数据
     * @param key
     * @param defValue
     * @return
     */
    public boolean getBoolean(String key, boolean defValue) {
        checkFastSharedPreferences();
        return mFastSharedPreferences.getBoolean(key, defValue);
    }

    /**
     * 获取float 数据
     * @param key
     * @param defValue
     * @return
     */
    public float getFloat(String key, float defValue) {
        checkFastSharedPreferences();
        return mFastSharedPreferences.getFloat(key, defValue);
    }

    /**
     * 获取int 数据
     * @param key
     * @param defValue
     * @return
     */
    public int getInt(String key, int defValue) {
        checkFastSharedPreferences();
        return mFastSharedPreferences.getInt(key, defValue);
    }

    /**
     * 获取long 数据
     * @param key
     * @param defValue
     * @return
     */
    public long getLong(String key, long defValue) {
        checkFastSharedPreferences();
        return mFastSharedPreferences.getLong(key, defValue);
    }

    /**
     * 获取String数据
     * @param key
     * @param defValue
     * @return
     */
    public String getString(String key, String defValue) {
        checkFastSharedPreferences();
        return mFastSharedPreferences.getString(key, defValue);
    }

    /**
     * 获取Set<String> 数据集合
     * @param key
     * @param defValue
     * @return
     */
    public Set<String> getStringSet(String key, @Nullable Set<String> defValue) {
        checkFastSharedPreferences();
        return mFastSharedPreferences.getStringSet(key, defValue);
    }

    /**
     * 移除某个key
     * @param key
     */
    public void removeKey(String key) {
        checkFastSharedPreferences();
        mEdit.remove(key).commit();
    }

    /**
     * 清空数据
     */
    public void clear() {
        checkFastSharedPreferences();
        FastSharedPreferences.clearCache();
        mEdit.clear().commit();
    }

    /**
     * 初始化
     */
    public void init(Context context) {
        //FastSharedPreferences 基本用法
        FastSharedPreferences.init(context);
        checkFastSharedPreferences();
    }

    /**
     * 获得初始化实例对象
     */
    private void checkFastSharedPreferences() {
        //如果为空重新初始化一遍
        if (mFastSharedPreferences == null || mEdit == null) {
            mFastSharedPreferences = FastSharedPreferences.get(FSP_ID);
            mEdit = mFastSharedPreferences.edit();
        }
    }
}
