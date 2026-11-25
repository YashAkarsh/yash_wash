package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f14425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f14426b = new Handler(Looper.getMainLooper(), new b());

    private static class b implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f14427a = 1;

        private b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((m) message.obj).a();
            return true;
        }
    }

    n() {
    }

    public void a(m<?> mVar) {
        com.bumptech.glide.util.i.b();
        if (this.f14425a) {
            this.f14426b.obtainMessage(1, mVar).sendToTarget();
            return;
        }
        this.f14425a = true;
        mVar.a();
        this.f14425a = false;
    }
}
