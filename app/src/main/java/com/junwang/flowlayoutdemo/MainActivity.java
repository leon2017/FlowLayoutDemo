package com.junwang.flowlayoutdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemCallBak {

    private RecyclerView mRecyclerview;
    private TestAdapter mTestAdapter;
    private List<TestEntity> mTestList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        GridLayoutManager manager = new GridLayoutManager(MainActivity.this, 3);
        manager.setOrientation(GridLayoutManager.VERTICAL);
        mRecyclerview.setLayoutManager(manager);
        mRecyclerview.addItemDecoration(new VerticalItemDeacoration(this, 5, 5, 5, 5));
        mTestAdapter = new TestAdapter();
        mRecyclerview.setAdapter(mTestAdapter);
        mTestAdapter.setOnItemClickLisetener(this);
    }

    private void initData() {
        mTestList = new ArrayList();
        for (int i = 0; i < 15; i++) {
            TestEntity testEntity = new TestEntity();
            testEntity.setId(i);
            testEntity.setSelect(false);
            testEntity.setTitle("测试" + i);
            mTestList.add(testEntity);
        }
        mTestAdapter.setDatas(mTestList);
    }

    @Override
    public void onItemClick(TestEntity entity) {
        int selectId = entity.getId();
        entity.setSelect(!entity.isSelect());
        List<TestEntity> tempList = new ArrayList<>();
        for (TestEntity testEntity : mTestList) {
            if (testEntity.getId() == selectId) {
                testEntity = entity;
            }
            tempList.add(testEntity);
        }
        mTestList = tempList;
        mTestAdapter.setDatas(mTestList);
    }
}
