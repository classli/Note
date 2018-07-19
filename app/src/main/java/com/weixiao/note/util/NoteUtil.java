package com.weixiao.note.util;

import android.content.Context;

/**
 * Created by weixiao on 18/7/18.
 */

public class NoteUtil {

    public static int dp2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }
}
