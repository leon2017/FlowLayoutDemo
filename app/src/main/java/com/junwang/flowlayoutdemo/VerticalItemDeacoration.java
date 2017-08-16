package com.junwang.flowlayoutdemo;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 当前类注释:ItemDeacoration
 * <p>
 * Author : junwang <p>
 * Created: 2017/8/16.上午9:31 <P>
 * Description:
 * <p>
 * E-mail:lijiawangjun@gmail.com
 */

public class VerticalItemDeacoration extends RecyclerView.ItemDecoration {

    private int mLeft = 0;
    private int mTop = 0;
    private int mRight = 0;
    private int mBottom = 0;

    public VerticalItemDeacoration(Context context,
                                   float left, float top, float right, float bottom) {
        mLeft = dp2px(context, left);
        mTop = dp2px(context, top);
        mRight = dp2px(context, right);
        mBottom = dp2px(context, bottom);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = mLeft;
        outRect.top = mTop;
        outRect.right = mRight;
        outRect.bottom = mBottom;
    }

    private int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    private int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
