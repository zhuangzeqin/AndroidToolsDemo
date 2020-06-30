package com.eeepay.zzq.androidtoolsdemo.bean;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.eeepay.zzq.androidtoolsdemo.adapter.TestAdapter;

/**
 * 描述：TwoBean
 * 作者：zhuangzeqin
 * 时间: 2020/6/29-12:27
 * 邮箱：zzq@eeepay.cn
 * 备注:若不存在第三级子菜单，二级子菜单就不用继承AbstractExpandableItem
 */
public class TwoBean extends AbstractExpandableItem<ThreeBean> implements MultiItemEntity {
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TwoBean(String content) {
        this.content = content;
    }

    private String content;
    @Override
    public int getItemType() {
        return TestAdapter.TYPE_TWO;
    }

    @Override
    public int getLevel() {
        return 1;
    }
}
