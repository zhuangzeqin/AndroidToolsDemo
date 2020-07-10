package com.eeepay.zzq.androidtoolsdemo;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import com.eeepay.zzq.androidtoolsdemo.adapter.DividerItemDecoration;
import com.eeepay.zzq.androidtoolsdemo.adapter.MultiDelegateAdapter;
import com.eeepay.zzq.androidtoolsdemo.bean.MultipleItem;
import com.eeepay.zzq.androidtoolsdemo.bean.TestModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity2 extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout swipeLayout;
    private Unbinder bind;
    private List<MultipleItem> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mListView ;
        bind = ButterKnife.bind(this);
        initData();
        MultiDelegateAdapter multiDelegateAdapter = new MultiDelegateAdapter(datas);
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
        recyclerView.setAdapter(multiDelegateAdapter);

    }

    private void initData() {
        //模拟的数据（实际开发中一般是从网络获取的）
        datas = new ArrayList<>();
        TestModel model;
        for (int i = 0; i < 15; i++) {
            model = new TestModel();
            model.setName("我是第" + i + "条标题");
            model.setContent("第" + i + "条内容");
            MultipleItem multipleItem;
            if (i%2==0)
            {
                multipleItem = new MultipleItem(MultipleItem.IMG,model);
            }
            else
            {
                multipleItem = new MultipleItem(MultipleItem.TEXT,model);
            }
            datas.add(multipleItem);
        }
    }

    @Override
    protected void onDestroy() {
        if (bind != null)
            bind.unbind();
        super.onDestroy();
    }
}
