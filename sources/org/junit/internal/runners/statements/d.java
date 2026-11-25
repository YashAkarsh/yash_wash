package org.junit.internal.runners.statements;

import org.junit.runners.model.j;

/* JADX INFO: loaded from: classes3.dex */
public class d extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.junit.runners.model.d f39905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f39906b;

    public d(org.junit.runners.model.d dVar, Object obj) {
        this.f39905a = dVar;
        this.f39906b = obj;
    }

    @Override // org.junit.runners.model.j
    public void a() throws Throwable {
        this.f39905a.m(this.f39906b, new Object[0]);
    }
}
