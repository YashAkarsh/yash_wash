package com.haier.uhome.usdk.api.a;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends com.haier.library.common.util.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f30377a = new AtomicBoolean();

    protected boolean f() {
        return this.f30377a.compareAndSet(false, true);
    }

    protected boolean g() {
        return this.f30377a.get();
    }

    protected void h() {
        synchronized (this.f30377a) {
            this.f30377a.set(false);
            d();
        }
    }
}
