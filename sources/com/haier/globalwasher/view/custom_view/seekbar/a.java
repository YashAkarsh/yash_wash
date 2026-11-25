package com.haier.globalwasher.view.custom_view.seekbar;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static int a(Context context, float f8) {
        return (int) ((f8 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context, float f8) {
        return (int) ((f8 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
