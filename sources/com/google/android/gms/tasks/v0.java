package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class v0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ s0 f16830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Callable f16831b;

    v0(s0 s0Var, Callable callable) {
        this.f16830a = s0Var;
        this.f16831b = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f16830a.z(this.f16831b.call());
        } catch (Exception e8) {
            this.f16830a.y(e8);
        } catch (Throwable th) {
            this.f16830a.y(new RuntimeException(th));
        }
    }
}
