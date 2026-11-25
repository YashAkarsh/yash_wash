package org.junit.internal.builders;

import org.junit.runner.l;

/* JADX INFO: loaded from: classes3.dex */
public class d extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<?> f39840a;

    public d(Class<?> cls) {
        this.f39840a = cls;
    }

    @Override // org.junit.runner.l
    public void a(org.junit.runner.notification.c cVar) {
        cVar.i(b());
    }

    @Override // org.junit.runner.l, org.junit.runner.b
    public org.junit.runner.c b() {
        return org.junit.runner.c.c(this.f39840a);
    }
}
