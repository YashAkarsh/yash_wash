package com.nostra13.universalimageloader.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final e f32847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Executor f32848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Executor f32849c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<Integer, String> f32851e = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<String, ReentrantLock> f32852f = new WeakHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicBoolean f32853g = new AtomicBoolean(false);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f32854h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f32855i = new AtomicBoolean(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Object f32856j = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ExecutorService f32850d = Executors.newCachedThreadPool();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f32857a;

        a(h hVar) {
            this.f32857a = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean zExists = f.this.f32847a.f32813q.c(this.f32857a.o()).exists();
            f.this.l();
            if (zExists) {
                f.this.f32849c.execute(this.f32857a);
            } else {
                f.this.f32848b.execute(this.f32857a);
            }
        }
    }

    f(e eVar) {
        this.f32847a = eVar;
        this.f32848b = eVar.f32805i;
        this.f32849c = eVar.f32806j;
    }

    private Executor e() {
        e eVar = this.f32847a;
        return com.nostra13.universalimageloader.core.a.c(eVar.f32809m, eVar.f32810n, eVar.f32811o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (!this.f32847a.f32807k && ((ExecutorService) this.f32848b).isShutdown()) {
            this.f32848b = e();
        }
        if (this.f32847a.f32808l || !((ExecutorService) this.f32849c).isShutdown()) {
            return;
        }
        this.f32849c = e();
    }

    void d(com.nostra13.universalimageloader.core.imageaware.a aVar) {
        this.f32851e.remove(Integer.valueOf(aVar.a()));
    }

    void f(boolean z7) {
        this.f32854h.set(z7);
    }

    String g(com.nostra13.universalimageloader.core.imageaware.a aVar) {
        return this.f32851e.get(Integer.valueOf(aVar.a()));
    }

    ReentrantLock h(String str) {
        ReentrantLock reentrantLock = this.f32852f.get(str);
        if (reentrantLock != null) {
            return reentrantLock;
        }
        ReentrantLock reentrantLock2 = new ReentrantLock();
        this.f32852f.put(str, reentrantLock2);
        return reentrantLock2;
    }

    AtomicBoolean i() {
        return this.f32853g;
    }

    Object j() {
        return this.f32856j;
    }

    void k(boolean z7) {
        this.f32855i.set(z7);
    }

    boolean m() {
        return this.f32854h.get();
    }

    boolean n() {
        return this.f32855i.get();
    }

    void o() {
        this.f32853g.set(true);
    }

    void p(com.nostra13.universalimageloader.core.imageaware.a aVar, String str) {
        this.f32851e.put(Integer.valueOf(aVar.a()), str);
    }

    void q() {
        this.f32853g.set(false);
        synchronized (this.f32856j) {
            this.f32856j.notifyAll();
        }
    }

    void r() {
        if (!this.f32847a.f32807k) {
            ((ExecutorService) this.f32848b).shutdownNow();
        }
        if (!this.f32847a.f32808l) {
            ((ExecutorService) this.f32849c).shutdownNow();
        }
        this.f32851e.clear();
        this.f32852f.clear();
    }

    void s(h hVar) {
        this.f32850d.execute(new a(hVar));
    }

    void t(i iVar) {
        l();
        this.f32849c.execute(iVar);
    }
}
