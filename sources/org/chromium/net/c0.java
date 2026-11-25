package org.chromium.net;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f39124a;

    public c0(Executor executor) {
        if (executor == null) {
            throw new IllegalStateException("Executor must not be null");
        }
        this.f39124a = executor;
    }

    public Executor a() {
        return this.f39124a;
    }

    public abstract void b(int i7, long j7, int i8);
}
