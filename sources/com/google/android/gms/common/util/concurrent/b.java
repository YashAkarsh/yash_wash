package com.google.android.gms.common.util.concurrent;

import c.m0;
import com.google.android.gms.common.internal.u;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class b implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadFactory f15990b = Executors.defaultThreadFactory();

    @c1.a
    public b(@m0 String str) {
        u.l(str, "Name must not be null");
        this.f15989a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    @m0
    public final Thread newThread(@m0 Runnable runnable) {
        Thread threadNewThread = this.f15990b.newThread(new d(runnable, 0));
        threadNewThread.setName(this.f15989a);
        return threadNewThread;
    }
}
