package org.chromium.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.provider.Settings;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f38845a = "/data/local";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f38846b = "/data/local/tmp";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final /* synthetic */ boolean f38847c = false;

    private n() {
    }

    @SuppressLint({"NewApi"})
    private static String a(Context context) {
        if (Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) == 1) {
            return Settings.Global.getString(context.getContentResolver(), "debug_app");
        }
        return null;
    }

    private static String b(Context context) {
        if (Settings.System.getInt(context.getContentResolver(), "adb_enabled", 0) == 1) {
            return Settings.System.getString(context.getContentResolver(), "debug_app");
        }
        return null;
    }

    public static void c(String str) {
        d(str, null);
    }

    public static void d(String str, @c.o0 n0<Boolean> n0Var) {
        File file = new File(f38846b, str);
        if (!file.exists() || !e(n0Var)) {
            file = new File(f38845a, str);
        }
        CommandLine.s(file.getPath());
    }

    private static boolean e(@c.o0 n0<Boolean> n0Var) {
        if (n0Var != null && n0Var.get().booleanValue()) {
            return true;
        }
        Context contextE = o.e();
        return contextE.getPackageName().equals(a(contextE)) || BuildInfo.d();
    }
}
