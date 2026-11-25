package org.chromium.base;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Process;
import android.preference.PreferenceManager;

/* JADX INFO: loaded from: classes3.dex */
@x6.c("base::android")
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38848a = "ContextUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Context f38849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f38850c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final /* synthetic */ boolean f38851d = false;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static SharedPreferences f38852a = o.b();

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences b() {
        return PreferenceManager.getDefaultSharedPreferences(f38849b);
    }

    public static SharedPreferences c() {
        return a.f38852a;
    }

    public static AssetManager d() {
        Context contextE = e();
        while (contextE instanceof ContextWrapper) {
            contextE = ((ContextWrapper) contextE).getBaseContext();
        }
        return contextE.getAssets();
    }

    public static Context e() {
        return f38849b;
    }

    public static String f() {
        String str = f38850c;
        if (str != null) {
            return str;
        }
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            String str2 = (String) cls.getMethod("getProcessName", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]), new Object[0]);
            f38850c = str2;
            return str2;
        } catch (Exception e8) {
            throw new RuntimeException(e8);
        }
    }

    @x6.e
    public static void g(Context context) {
        i(context);
    }

    @s0
    public static void h(Context context) {
        i(context);
        SharedPreferences unused = a.f38852a = b();
    }

    private static void i(Context context) {
        if (l.f38814b && (context instanceof Application)) {
            context = new ContextWrapper(context);
        }
        f38849b = context;
    }

    public static boolean j() {
        try {
            return ((Boolean) Process.class.getMethod("isIsolated", new Class[0]).invoke(null, new Object[0])).booleanValue();
        } catch (Exception e8) {
            throw new RuntimeException(e8);
        }
    }
}
