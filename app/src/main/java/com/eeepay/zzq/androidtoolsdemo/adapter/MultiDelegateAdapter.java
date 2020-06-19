package com.eeepay.zzq.androidtoolsdemo.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.eeepay.zzq.androidtoolsdemo.bean.MultipleItem;

/*
 * 描述：更便捷的多布局为 BaseQuickAdapter 设置代理
 * 作者：zhuangzeqin
 * 时间: 2020/6/19-17:19
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public final class MultiDelegateAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {
    public MultiDelegateAdapter() {
        super(null);
//        //Step.1
//        setMultiTypeDelegate(new MultiTypeDelegate<TestModel>() {
//            @Override
//            protected int getItemType(TestModel entity) {
//                //根据你的实体类来判断布局类型
//                return entity.getItemType();
//            }
//        });
//        //Step.2
//        getMultiTypeDelegate()
//                .registerItemType(Entity.TEXT, R.layout.item_text_view)
//                .registerItemType(Entity.IMG, R.layout.item_image_view);
    }


    @Override
    protected void convert(@NonNull BaseViewHolder helper, MultipleItem item) {

    }
}
