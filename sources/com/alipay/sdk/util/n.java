package com.alipay.sdk.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f13819a = "content://com.alipay.android.app.settings.data.ServerProvider/current_server";

    public static String a(Context context) {
        if (com.alipay.sdk.app.a.b()) {
            return j0.a.f34206b;
        }
        if (context == null) {
            return j0.a.f34205a;
        }
        String str = j0.a.f34205a;
        return TextUtils.isEmpty(str) ? j0.a.f34205a : str;
    }

    private static String b(Context context) {
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse(f13819a), null, null, null, null);
        String string = null;
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("url")) : null;
            cursorQuery.close();
        }
        return string;
    }
}
