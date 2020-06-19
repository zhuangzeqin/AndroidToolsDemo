package com.eeepay.zzq.androidtoolsdemo.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.eeepay.zzq.androidtoolsdemo.R;
import com.eeepay.zzq.androidtoolsdemo.bean.TestModel;

import java.util.List;

/**
 * 描述：普通RV 的adapter 使用
 * 作者：zhuangzeqin
 * 时间: 2020/6/19-15:30
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public final class QuickAdapter extends BaseQuickAdapter<TestModel, BaseViewHolder> {
    public QuickAdapter(int layoutResId, @Nullable List<TestModel> data) {
        super(layoutResId, data);
    }

    public QuickAdapter(@Nullable List<TestModel> data) {
        super(data);
    }

    public QuickAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, TestModel testModel) {
        //可链式调用赋值
        baseViewHolder.setText(R.id.tv_title, testModel.getName()).
                setText(R.id.tv_content, testModel.getContent()).
                setImageResource(R.id.iv_img, R.mipmap.ic_launcher);
        //   // 加载网络图片
        //      Glide.with(mContext).load(item.getUserAvatar()).crossFade().into((ImageView) helper.getView(R.id.iv_img));
        //获取当前条目position
        //int position = helper.getLayoutPosition();
    }
}
