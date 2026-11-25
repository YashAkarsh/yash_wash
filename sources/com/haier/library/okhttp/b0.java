package com.haier.library.okhttp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final /* synthetic */ boolean f27493h = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private Runnable f27496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private ExecutorService f27497d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f27494a = 64;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f27495b = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Deque<e.b> f27498e = new ArrayDeque();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Deque<e.b> f27499f = new ArrayDeque();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Deque<e> f27500g = new ArrayDeque();

    public b0(ExecutorService executorService) {
        this.f27497d = executorService;
    }

    private <T> void f(Deque<T> deque, T t7) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t7)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.f27496c;
        }
        if (r() || runnable == null) {
            return;
        }
        runnable.run();
    }

    private int l(e.b bVar) {
        int i7 = 0;
        for (e.b bVar2 : this.f27499f) {
            if (!bVar2.o().f27528f && bVar2.l().equals(bVar.l())) {
                i7++;
            }
        }
        return i7;
    }

    private boolean r() {
        int i7;
        boolean z7;
        if (!f27493h && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<e.b> it = this.f27498e.iterator();
            while (it.hasNext()) {
                e.b next = it.next();
                if (this.f27499f.size() >= this.f27494a) {
                    break;
                }
                if (l(next) < this.f27495b) {
                    it.remove();
                    arrayList.add(next);
                    this.f27499f.add(next);
                }
            }
            z7 = q() > 0;
        }
        int size = arrayList.size();
        for (i7 = 0; i7 < size; i7++) {
            ((e.b) arrayList.get(i7)).m(a());
        }
        return z7;
    }

    public synchronized ExecutorService a() {
        if (this.f27497d == null) {
            this.f27497d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), n.d.p("OkHttp Dispatcher", false));
        }
        return this.f27497d;
    }

    public void b(int i7) {
        if (i7 >= 1) {
            synchronized (this) {
                this.f27494a = i7;
            }
            r();
        } else {
            throw new IllegalArgumentException("max < 1: " + i7);
        }
    }

    void c(e.b bVar) {
        synchronized (this) {
            this.f27498e.add(bVar);
        }
        r();
    }

    synchronized void d(e eVar) {
        this.f27500g.add(eVar);
    }

    public synchronized void e(@Nullable Runnable runnable) {
        this.f27496c = runnable;
    }

    public synchronized int g() {
        return this.f27494a;
    }

    public void h(int i7) {
        if (i7 >= 1) {
            synchronized (this) {
                this.f27495b = i7;
            }
            r();
        } else {
            throw new IllegalArgumentException("max < 1: " + i7);
        }
    }

    void i(e.b bVar) {
        f(this.f27499f, bVar);
    }

    void j(e eVar) {
        f(this.f27500g, eVar);
    }

    public synchronized int k() {
        return this.f27495b;
    }

    public synchronized void m() {
        Iterator<e.b> it = this.f27498e.iterator();
        while (it.hasNext()) {
            it.next().o().c();
        }
        Iterator<e.b> it2 = this.f27499f.iterator();
        while (it2.hasNext()) {
            it2.next().o().c();
        }
        Iterator<e> it3 = this.f27500g.iterator();
        while (it3.hasNext()) {
            it3.next().c();
        }
    }

    public synchronized List<q> n() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<e.b> it = this.f27498e.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().o());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized List<q> o() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f27500g);
        Iterator<e.b> it = this.f27499f.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().o());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public synchronized int p() {
        return this.f27498e.size();
    }

    public synchronized int q() {
        return this.f27499f.size() + this.f27500g.size();
    }

    public b0() {
    }
}
