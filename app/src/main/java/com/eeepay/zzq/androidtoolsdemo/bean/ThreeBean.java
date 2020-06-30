package com.eeepay.zzq.androidtoolsdemo.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.eeepay.zzq.androidtoolsdemo.adapter.TestAdapter;

/**
 * 描述：class describe
 * 作者：zhuangzeqin
 * 时间: 2020/6/29-13:40
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class ThreeBean implements MultiItemEntity {
    public ThreeBean(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String content;

    @Override
    public int getItemType() {
        return TestAdapter.TYPE_THREE;
    }
}
