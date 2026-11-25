package com.alipay.security.mobile.module.d;

/* JADX INFO: loaded from: classes.dex */
final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f13916a;

    c(b bVar) {
        this.f13916a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f13916a.d();
        } catch (Exception e8) {
            d.c(e8);
        }
    }
}
