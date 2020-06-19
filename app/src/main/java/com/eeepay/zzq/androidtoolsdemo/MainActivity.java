package com.eeepay.zzq.androidtoolsdemo;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.eeepay.zzq.androidtoolsdemo.adapter.CommonItemDecoration;
import com.eeepay.zzq.androidtoolsdemo.adapter.QuickAdapter;
import com.eeepay.zzq.androidtoolsdemo.bean.TestModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipeLayout)
    SwipeRefreshLayout swipeLayout;
    private List<TestModel> datas;
    private QuickAdapter adapter;

    private Unbinder bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bind = ButterKnife.bind(this);
        initData();
        //创建布局管理
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        //设置布局方式
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //解决数据加载不完的问题
        recyclerView.setNestedScrollingEnabled(false);
        //当知道Adapter内Item的改变不会影响RecyclerView宽高的时候，可以设置为true让RecyclerView避免重新计算大小
        recyclerView.setHasFixedSize(true);
        //解决数据加载完成后, 没有停留在顶部的问题
        recyclerView.setFocusable(false);
        //添加分割线
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerView.addItemDecoration(new CommonItemDecoration(0,50));
        //创建适配器
        adapter = new QuickAdapter(R.layout.item_rv);
        //** --------------------------- 动画效果 --------------------------- **/
        //开启动画效果
        adapter.openLoadAnimation();
        //设置动画效果
        /**
         * 渐显 ALPHAIN
         * 缩放 SCALEIN
         * 从下到上 SLIDEIN_BOTTOM
         * 从左到右 SLIDEIN_LEFT
         * 从右到左 SLIDEIN_RIGHT
         */
        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        adapter.setNewData(datas);//填充数据
        //给RecyclerView设置适配器
        recyclerView.setAdapter(adapter);

        /** --------------------------- 点击事件 --------------------------- **/
        //设置Item点击事件
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                ToastUitl.showShort("onItemClick：" + position);
            }
        });
        //设置Item长按事件
        adapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
//                ToastUitl.showShort("onItemLongClick：" + position);
                return false;
            }
        });
        //设置Item中子控件点击事件
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                //判断子控件
                if (view.getId() == R.id.tv_content) {
//                    ToastUitl.showShort("onItemChildClick：" + position);
                }
            }
        });
        /**
         * 刷新的操作
         */
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //刷新的时候禁止加载更多
                adapter.setEnableLoadMore(false);
                initData();
                //更新数据
                adapter.setNewData(datas);
                //刷新完成取消刷新动画
                swipeLayout.setRefreshing(false);
                //刷新完成重新开启加载更多
                adapter.setEnableLoadMore(true);
            }
        });

        /** --------------------------- 加载更多 --------------------------- **/
        //设置加载更多
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                //模拟的数据（实际开发中一般是从网络获取的）
                ArrayList datas = new ArrayList<>();
                TestModel model;
                for (int i = 0; i < 5; i++) {
                    model = new TestModel();
                    model.setName("我是第" + i + "条标题");
                    model.setContent("第" + i + "条内容");
                    datas.add(model);
                }
                if (datas.size() <= 5) {
                    adapter.addData(datas);
                    //数据加载完成
                    adapter.loadMoreComplete();
                } else {
                    //数据加载完毕
                    adapter.loadMoreEnd();
                }
            }
        }, recyclerView);
        //默认第一次加载会进入回调，如果不需要可以配置
        adapter.disableLoadMoreIfNotFullPage();
        //当列表滑动到倒数第N个Item的时候(默认是1)回调onLoadMoreRequested方法
        adapter.setPreLoadNumber(1);

        /** --------------------------- 添加头部尾部 --------------------------- **/
//        View item_head = LayoutInflater.from(getContext()).inflate(R.layout.item_head, (ViewGroup) mRecyclerView.getParent(), false);
//        adapter.addHeaderView(item_head);
//        View item_footer = LayoutInflater.from(getContext()).inflate(R.layout.item_footer, (ViewGroup) mRecyclerView.getParent(), false);
//        adapter.addFooterView(item_footer);

    }

    private void initData() {
        //模拟的数据（实际开发中一般是从网络获取的）
        datas = new ArrayList<>();
        TestModel model;
        for (int i = 0; i < 15; i++) {
            model = new TestModel();
            model.setName("我是第" + i + "条标题");
            model.setContent("第" + i + "条内容");
            datas.add(model);
        }
    }

    @Override
    protected void onDestroy() {
        if (bind != null)
            bind.unbind();
        super.onDestroy();
    }
}
