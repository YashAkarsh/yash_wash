package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"PrivateConstructorForUtilityClass"})
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5459a = "android.support.AppLaunchChecker";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5460b = "startedFromLauncher";

    @Deprecated
    public o() {
    }

    public static boolean a(@c.m0 Context context) {
        return context.getSharedPreferences(f5459a, 0).getBoolean(f5460b, false);
    }

    public static void b(@c.m0 Activity activity) {
        Intent intent;
        SharedPreferences sharedPreferences = activity.getSharedPreferences(f5459a, 0);
        if (sharedPreferences.getBoolean(f5460b, false) || (intent = activity.getIntent()) == null || !"android.intent.action.MAIN".equals(intent.getAction())) {
            return;
        }
        if (intent.hasCategory("android.intent.category.LAUNCHER") || intent.hasCategory(androidx.core.content.l.f5636e)) {
            sharedPreferences.edit().putBoolean(f5460b, true).apply();
        }
    }
}
