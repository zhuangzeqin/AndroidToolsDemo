package com.eeepay.zzq.androidtoolsdemo;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.eeepay.zzq.androidtoolsdemo.adapter.DividerItemDecoration;
import com.eeepay.zzq.androidtoolsdemo.adapter.TestAdapter;
import com.eeepay.zzq.androidtoolsdemo.bean.MultipleItem;
import com.eeepay.zzq.androidtoolsdemo.bean.OneBean;
import com.eeepay.zzq.androidtoolsdemo.bean.ThreeBean;
import com.eeepay.zzq.androidtoolsdemo.bean.TwoBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity3 extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout swipeLayout;
    private Unbinder bind;
    private List<MultipleItem> datas;

    private TestAdapter testAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);
//        initData();
//        MultiDelegateAdapter multiDelegateAdapter = new MultiDelegateAdapter(datas);
        testAdapter = new TestAdapter(new ArrayList<MultiItemEntity>());
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        //设置布局方式
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //解决数据加载不完的问题
//        recyclerView.setNestedScrollingEnabled(false);
//        //当知道Adapter内Item的改变不会影响RecyclerView宽高的时候，可以设置为true让RecyclerView避免重新计算大小
//        recyclerView.setHasFixedSize(true);
//        //解决数据加载完成后, 没有停留在顶部的问题
//        recyclerView.setFocusable(false);
        //添加分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
//        recyclerView.addItemDecoration(new CommonItemDecoration(0,50));
        recyclerView.setAdapter(testAdapter);
        initData();

    }

    private void initData() {
        List<MultiItemEntity> multiItemEntityList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            OneBean oneBean = new OneBean("一级标题" + i);
            for (int j = 0; j < 3; j++) {
                TwoBean twoBean = new TwoBean("二级标题" + j);
                for (int k = 0; k < 4; k++) {
                    twoBean.addSubItem(new ThreeBean("三级标题" + k));
                }
                oneBean.addSubItem(twoBean);
            }
            multiItemEntityList.add(oneBean);
        }
        testAdapter.setNewData(multiItemEntityList);
        testAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        if (bind != null)
            bind.unbind();
        super.onDestroy();
    }
}
