package com.alipay.apmobilesecuritysdk.f;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f13529a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Thread f13530b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinkedList<Runnable> f13531c = new LinkedList<>();

    public static b a() {
        return f13529a;
    }

    static /* synthetic */ Thread b(b bVar) {
        bVar.f13530b = null;
        return null;
    }

    public final synchronized void a(Runnable runnable) {
        this.f13531c.add(runnable);
        if (this.f13530b == null) {
            Thread thread = new Thread(new c(this));
            this.f13530b = thread;
            thread.start();
        }
    }
}
