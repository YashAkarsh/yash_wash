package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static synchronized String a(Context context, String str) {
        String strA = q0.e.a(context, "openapi_file_pri", "openApi" + str, "");
        if (o0.a.d(strA)) {
            return "";
        }
        String strE = p0.c.e(p0.c.a(), strA);
        return o0.a.d(strE) ? "" : strE;
    }

    public static synchronized void a() {
    }

    public static synchronized void a(Context context) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("openapi_file_pri", 0).edit();
        if (editorEdit != null) {
            editorEdit.clear();
            editorEdit.commit();
        }
    }

    public static synchronized void a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("openapi_file_pri", 0).edit();
            if (editorEdit != null) {
                editorEdit.putString("openApi" + str, p0.c.b(p0.c.a(), str2));
                editorEdit.commit();
            }
        } catch (Throwable unused) {
        }
    }
}
