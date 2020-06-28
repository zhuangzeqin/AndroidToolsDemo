package com.eeepay.zzq.androidtoolsdemo.adapter;

import android.support.annotation.NonNull;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.eeepay.zzq.androidtoolsdemo.R;
import com.eeepay.zzq.androidtoolsdemo.bean.MultipleItem;
import com.eeepay.zzq.androidtoolsdemo.bean.TestModel;

import java.util.List;

/*
 * 描述：更便捷的多布局为 BaseQuickAdapter 设置代理
 * 作者：zhuangzeqin
 * 时间: 2020/6/19-17:19
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public final class MultiDelegateAdapter extends BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder> {
    public MultiDelegateAdapter(List<MultipleItem> data) {
        super(data);
        addItemType(MultipleItem.TEXT, R.layout.text_view);
        addItemType(MultipleItem.IMG, R.layout.item_rv);
    }


    @Override
    protected void convert(@NonNull BaseViewHolder helper, MultipleItem item) {
        TestModel model = item.getModel();
        switch (helper.getItemViewType()) {
            case MultipleItem.TEXT:
                helper.setText(R.id.tv_msg, model.getContent());
                break;
            case MultipleItem.IMG:
                //可链式调用赋值
                helper.setText(R.id.tv_title, model.getName()).
                        setText(R.id.tv_content, model.getContent()).
                        setImageResource(R.id.iv_img, R.mipmap.ic_launcher).addOnClickListener(R.id.iv_img);
                break;
        }
    }
}
