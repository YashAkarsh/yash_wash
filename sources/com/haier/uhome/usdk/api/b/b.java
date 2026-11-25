package com.haier.uhome.usdk.api.b;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f30452a;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f30453a = new b();

        private a() {
        }
    }

    public static b a() {
        return a.f30453a;
    }

    private b() {
        this.f30452a = new Handler(Looper.getMainLooper());
    }

    public void a(Runnable runnable) {
        a(runnable, 0L);
    }

    public void a(Runnable runnable, long j7) {
        if (runnable == null) {
            return;
        }
        this.f30452a.postDelayed(runnable, j7);
    }
}
