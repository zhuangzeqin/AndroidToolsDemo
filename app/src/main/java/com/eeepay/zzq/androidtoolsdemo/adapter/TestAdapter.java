package com.eeepay.zzq.androidtoolsdemo.adapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.eeepay.zzq.androidtoolsdemo.R;
import com.eeepay.zzq.androidtoolsdemo.bean.OneBean;
import com.eeepay.zzq.androidtoolsdemo.bean.ThreeBean;
import com.eeepay.zzq.androidtoolsdemo.bean.TwoBean;

import java.util.List;

/**
 * 描述：树形列表
 * 作者：zhuangzeqin
 * 时间: 2020/6/29-12:36
 * 邮箱：zzq@eeepay.cn
 * 备注:
 */
public class TestAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    public static final int TYPE_ONE = 0;
    public static final int TYPE_TWO = 1;
    public static final int TYPE_THREE = 2;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public TestAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(TYPE_ONE, R.layout.item_one);
        addItemType(TYPE_TWO, R.layout.item_two);
        addItemType(TYPE_THREE, R.layout.item_three);
    }

    @Override
    protected void convert(@NonNull final BaseViewHolder helper, MultiItemEntity item) {
        switch (helper.getItemViewType()) {
            case TYPE_ONE:
                final OneBean oneBean = (OneBean) item;//转换为相应的实体bean 前提是实现了改接口
                helper.setText(R.id.content, oneBean.getContent());
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos = helper.getAdapterPosition();
                        if (oneBean.isExpanded()) {//isExpanded判断当前状态
                            collapse(pos);//折叠
                        } else {
                            expand(pos);//展开
                        }
                    }
                });
                break;
            case TYPE_TWO:
                final TwoBean twoBean = (TwoBean) item;
                helper.setText(R.id.content, twoBean.getContent());
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos = helper.getAdapterPosition();
                        if (twoBean.isExpanded()) {
                            collapse(pos);
                        } else {
                            expand(pos);
                        }
                    }
                });
                break;
            case TYPE_THREE:
                ThreeBean threeBean = (ThreeBean) item;
                helper.setText(R.id.content, threeBean.getContent());
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext, "三级", Toast.LENGTH_SHORT).show();
                    }
                });
                break;
        }
    }
}
