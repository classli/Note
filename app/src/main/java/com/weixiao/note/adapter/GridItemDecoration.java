package com.weixiao.note.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.weixiao.note.util.NoteUtil;

/**
 * Created by weixiao on 18/7/18.
 */

public class GridItemDecoration extends RecyclerView.ItemDecoration {
    private final static String TAG = "GridItemDecoration";
    private int spanCount;
    private int dividerWidth;
    private int dividerWidthTop;
    private int dividerWidthBot;
    private int width;
    private Paint dividerPaint;

    public GridItemDecoration(Context context, int spanCount, int dividerWidthDp) {
        this.spanCount = spanCount;

        this.dividerPaint = new Paint();
        this.dividerPaint.setColor(Color.BLUE);

        this.dividerWidth = NoteUtil.dp2px(context, dividerWidthDp);
        this.dividerWidthTop = dividerWidth / 2;
        this.dividerWidthBot = dividerWidth - dividerWidthTop;

        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(metrics);
        width = (metrics.widthPixels - (spanCount + 1) * NoteUtil.dp2px(context, dividerWidthDp)) / spanCount;
        Log.d(TAG, "width =" + width + "metrics.widthPixels=" + metrics.widthPixels);
    }

    @Override
    public void getItemOffsets(Rect outRect, View child, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, child, parent, state);
        int pos = parent.getChildAdapterPosition(child);
        int column = (pos) % spanCount;// 计算这个child 处于第几列

        if (pos < spanCount) {
            outRect.top = dividerWidth;
        } else {
            outRect.top = dividerWidthTop;
        }
        outRect.bottom = dividerWidthBot;

        if (column == 0) {
            outRect.left = dividerWidth;
            outRect.right = dividerWidth - (column + 1) * dividerWidth / spanCount;
        } else if (column + 1 == spanCount) {
            outRect.left = (column * dividerWidth / spanCount);
            outRect.right = dividerWidth;
        } else {
            outRect.left = (column * dividerWidth / spanCount);
            outRect.right = dividerWidth - (column + 1) * dividerWidth / spanCount;
        }
        child.getLayoutParams().height = 532;
        Log.d(TAG, "pos=" + pos + ", column=" + column + " , left=" + outRect.left + ", right="
                + outRect.right + ", dividerWidth=" + dividerWidth);
    }

}
