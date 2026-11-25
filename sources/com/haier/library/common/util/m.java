package com.haier.library.common.util;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile b0 f26601a;

    protected abstract void a();

    protected void a(long j7) {
        a(j7, TimeUnit.SECONDS);
    }

    protected boolean b() {
        return this.f26601a != null && this.f26601a.b();
    }

    public boolean c() {
        return this.f26601a != null && this.f26601a.c();
    }

    protected void d() {
        if (b()) {
            this.f26601a.f();
        }
    }

    protected long e() {
        return a(TimeUnit.MILLISECONDS);
    }

    protected void a(long j7, TimeUnit timeUnit) {
        d();
        this.f26601a = a0.a(j7, timeUnit, new Runnable() { // from class: com.haier.library.common.util.l
            @Override // java.lang.Runnable
            public final void run() {
                this.f26600a.a();
            }
        });
    }

    protected long a(TimeUnit timeUnit) {
        if (this.f26601a != null) {
            return this.f26601a.a(timeUnit);
        }
        return 0L;
    }
}
