package androidx.core.app;

import android.app.ActivityManager;

/* JADX INFO: loaded from: classes.dex */
public final class h {
    private h() {
    }

    public static boolean a(@c.m0 ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
