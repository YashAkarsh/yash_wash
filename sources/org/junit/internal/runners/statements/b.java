package org.junit.internal.runners.statements;

import org.junit.runners.model.j;

/* JADX INFO: loaded from: classes3.dex */
public class b extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Throwable f39894a;

    public b(Throwable th) {
        this.f39894a = th;
    }

    @Override // org.junit.runners.model.j
    public void a() throws Throwable {
        throw this.f39894a;
    }
}
