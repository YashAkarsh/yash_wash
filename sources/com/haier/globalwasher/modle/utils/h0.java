package com.haier.globalwasher.modle.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public class h0 {
    public static void a(Context context, String str) {
        if (androidx.core.content.d.a(context, "android.permission.CALL_PHONE") != 0) {
            androidx.core.app.b.G((Activity) context, new String[]{"android.permission.CALL_PHONE"}, 1);
            return;
        }
        context.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)));
    }
}
