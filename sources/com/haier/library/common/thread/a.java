package com.haier.library.common.thread;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f26458a;

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f26459a = new a();

        private b() {
        }
    }

    public static a b() {
        return b.f26459a;
    }

    public void a() {
        this.f26458a.removeCallbacksAndMessages(null);
    }

    public void c(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        this.f26458a.post(runnable);
    }

    private a() {
        this.f26458a = new Handler(Looper.getMainLooper());
    }
}
