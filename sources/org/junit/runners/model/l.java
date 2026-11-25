package org.junit.runners.model;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class l extends Exception {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f40059c = 31935685163547539L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TimeUnit f40060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f40061b;

    public l(long j7, TimeUnit timeUnit) {
        super(String.format("test timed out after %d %s", Long.valueOf(j7), timeUnit.name().toLowerCase()));
        this.f40060a = timeUnit;
        this.f40061b = j7;
    }

    public TimeUnit a() {
        return this.f40060a;
    }

    public long b() {
        return this.f40061b;
    }
}
