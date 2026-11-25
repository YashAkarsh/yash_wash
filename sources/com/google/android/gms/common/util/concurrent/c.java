package com.google.android.gms.common.util.concurrent;

import c.m0;
import com.google.android.gms.common.internal.u;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class c implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f15991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f15992b = new AtomicInteger();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ThreadFactory f15993c = Executors.defaultThreadFactory();

    @c1.a
    public c(@m0 String str) {
        u.l(str, "Name must not be null");
        this.f15991a = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    @m0
    public final Thread newThread(@m0 Runnable runnable) {
        Thread threadNewThread = this.f15993c.newThread(new d(runnable, 0));
        String str = this.f15991a;
        int andIncrement = this.f15992b.getAndIncrement();
        StringBuilder sb = new StringBuilder(str.length() + 13);
        sb.append(str);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        threadNewThread.setName(sb.toString());
        return threadNewThread;
    }
}
