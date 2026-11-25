package androidx.core.provider;

import android.os.Handler;
import android.os.Looper;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
class b {
    private b() {
    }

    @m0
    static Handler a() {
        return Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
    }
}
