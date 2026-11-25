package m4;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    public static void a(Context context, String str) {
        SharedPreferences.Editor editorE = e(context, str);
        editorE.clear();
        editorE.commit();
    }

    public static void b(SharedPreferences.Editor editor) {
        editor.clear();
        editor.commit();
    }

    public static boolean c(Context context, String str, String str2, boolean z7) {
        return j(context, str).getBoolean(str2, z7);
    }

    public static boolean d(SharedPreferences sharedPreferences, String str, boolean z7) {
        return sharedPreferences.getBoolean(str, z7);
    }

    public static SharedPreferences.Editor e(Context context, String str) {
        return j(context, str).edit();
    }

    public static int f(Context context, String str, String str2, int i7) {
        return j(context, str).getInt(str2, i7);
    }

    public static int g(SharedPreferences sharedPreferences, String str, int i7) {
        return sharedPreferences.getInt(str, i7);
    }

    public static Long h(Context context, String str, String str2, Long l7) {
        return Long.valueOf(j(context, str).getLong(str2, l7.longValue()));
    }

    public static Long i(SharedPreferences sharedPreferences, String str, Long l7) {
        return Long.valueOf(sharedPreferences.getLong(str, l7.longValue()));
    }

    public static SharedPreferences j(Context context, String str) {
        return context.getSharedPreferences(str, 0);
    }

    public static String k(Context context, String str, String str2, String str3) {
        return j(context, str).getString(str2, str3);
    }

    public static String l(SharedPreferences sharedPreferences, String str, String str2) {
        return sharedPreferences.getString(str, str2);
    }

    public static void m(Context context, String str, String str2, int i7) {
        SharedPreferences.Editor editorE = e(context, str);
        editorE.putInt(str2, i7);
        editorE.commit();
    }

    public static void n(Context context, String str, String str2, long j7) {
        SharedPreferences.Editor editorE = e(context, str);
        editorE.putLong(str2, j7);
        editorE.commit();
    }

    public static void o(Context context, String str, String str2, String str3) {
        SharedPreferences.Editor editorE = e(context, str);
        editorE.putString(str2, str3);
        editorE.commit();
    }

    public static void p(Context context, String str, String str2, boolean z7) {
        SharedPreferences.Editor editorE = e(context, str);
        editorE.putBoolean(str2, z7);
        editorE.commit();
    }

    public static void q(SharedPreferences.Editor editor, String str, int i7) {
        editor.putInt(str, i7);
        editor.commit();
    }

    public static void r(SharedPreferences.Editor editor, String str, long j7) {
        editor.putLong(str, j7);
        editor.commit();
    }

    public static void s(SharedPreferences.Editor editor, String str, String str2) {
        editor.putString(str, str2);
        editor.commit();
    }

    public static void t(SharedPreferences.Editor editor, String str, boolean z7) {
        editor.putBoolean(str, z7);
        editor.commit();
    }
}
