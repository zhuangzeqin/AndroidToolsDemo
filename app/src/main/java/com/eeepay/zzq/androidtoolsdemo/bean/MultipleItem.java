package com.eeepay.zzq.androidtoolsdemo.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/*
 * 描述：多布局 实体类必须实现MultiItemEntity，在设置数据的时候，需要给每一个数据设置itemType
 * 作者：zhuangzeqin
 * 时间: 2020/6/19-17:42
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class MultipleItem implements MultiItemEntity {
    public static final int TEXT = 1;
    public static final int IMG = 2;
    private int itemType;
    private TestModel model;

    public MultipleItem(int itemType, TestModel model) {
        this.itemType = itemType;
        this.model = model;
    }

    @Override
    public int getItemType() {
        return itemType;
    }

    public TestModel getModel() {
        return model;
    }
}
