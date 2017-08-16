package com.junwang.flowlayoutdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 当前类注释:
 * <p>
 * Author : junwang <p>
 * Created: 2017/8/16.上午10:21 <P>
 * Description:
 * <p>
 * E-mail:lijiawangjun@gmail.com
 */

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestViewHolder> {

    private List<TestEntity> mDatas;
    private ItemCallBak mCallBak;

    public TestAdapter() {
        mDatas = new ArrayList<>();
    }

    public void setDatas(@NonNull List<TestEntity> datas) {
        mDatas = datas;
        notifyDataSetChanged();
    }

    @Override
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_item, parent, false);
        return new TestViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TestViewHolder holder, int position) {
        if (mDatas.size() != 0) {
            final TestEntity testEntity = mDatas.get(position);
            holder.mButton.setText(testEntity.getTitle());
            if (testEntity.isSelect()) {
                holder.mButton.setBackgroundResource(R.color.colorAccent);
            } else {
                holder.mButton.setBackgroundResource(R.color.colorPrimary);
            }
            holder.mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (null != mCallBak) {
                        mCallBak.onItemClick(testEntity);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas == null || mDatas.size() == 0 ? 0 : mDatas.size();
    }

    public void setOnItemClickLisetener(ItemCallBak callBak) {
        mCallBak = callBak;
    }

    public static class TestViewHolder extends RecyclerView.ViewHolder {

        public final AppCompatButton mButton;

        public TestViewHolder(View itemView) {
            super(itemView);
            mButton = (AppCompatButton) itemView.findViewById(R.id.bt_test);
        }
    }

}
