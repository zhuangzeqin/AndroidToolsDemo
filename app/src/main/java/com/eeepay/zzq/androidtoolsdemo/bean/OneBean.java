package com.eeepay.zzq.androidtoolsdemo.bean;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.eeepay.zzq.androidtoolsdemo.adapter.TestAdapter;

/*
 * 描述：一级菜单内容
 * 作者：zhuangzeqin
 * 时间: 2020/6/29-12:24
 * 邮箱：zzq@eeepay.cn
 * 备注: 注：AbstractExpandableItem<T> 泛型填入的是二级菜单的实体类
 */
public class OneBean extends AbstractExpandableItem<TwoBean> implements MultiItemEntity {
    public OneBean(String content) {
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
        return TestAdapter.TYPE_ONE;
    }

    @Override
    public int getLevel() {
        return 0;
    }
}
