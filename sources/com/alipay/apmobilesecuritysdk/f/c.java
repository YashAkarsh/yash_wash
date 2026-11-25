package com.alipay.apmobilesecuritysdk.f;

import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f13532a;

    c(b bVar) {
        this.f13532a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Process.setThreadPriority(0);
            while (!this.f13532a.f13531c.isEmpty()) {
                Runnable runnable = (Runnable) this.f13532a.f13531c.get(0);
                this.f13532a.f13531c.remove(0);
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            b.b(this.f13532a);
            throw th;
        }
        b.b(this.f13532a);
    }
}
