package com.haier.library.common.util;

import java.io.Serializable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class b0 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ScheduledFuture f26562a;

    public b0(ScheduledFuture scheduledFuture) {
        this.f26562a = scheduledFuture;
    }

    public long a(TimeUnit timeUnit) {
        return this.f26562a.getDelay(timeUnit);
    }

    public boolean b() {
        return !this.f26562a.isDone();
    }

    public boolean c() {
        return this.f26562a.isDone();
    }

    public boolean d() {
        return this.f26562a.isCancelled();
    }

    public long e() {
        return this.f26562a.getDelay(TimeUnit.SECONDS);
    }

    public void f() {
        this.f26562a.cancel(true);
    }
}
