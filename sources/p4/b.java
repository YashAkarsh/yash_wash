package p4;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40077a = "rtk_mesh";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f40078b = "proxy_device";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f40079c = "preview_proxy_device";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f40080d = "disconnect_proxy_device";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f40081e;

    public static String a(Context context) {
        return context.getSharedPreferences(f40077a, 0).getString(f40080d, null);
    }

    public static String b(Context context) {
        return context.getSharedPreferences(f40077a, 0).getString(f40079c, null);
    }

    public static String c(Context context) {
        return f40081e;
    }

    public static void d(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(f40077a, 0).edit();
        editorEdit.putString(f40080d, str);
        editorEdit.apply();
    }

    public static void e(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(f40077a, 0).edit();
        editorEdit.putString(f40079c, str);
        editorEdit.apply();
    }

    public static void f(Context context, String str) {
        f40081e = str;
    }
}
