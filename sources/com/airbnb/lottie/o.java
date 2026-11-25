package com.airbnb.lottie;

import android.os.Handler;
import android.os.Looper;
import c.o0;
import c.x0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes.dex */
public class o<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Executor f12172e = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<j<T>> f12173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<j<Throwable>> f12174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f12175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    private volatile n<T> f12176d;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (o.this.f12176d == null) {
                return;
            }
            n nVar = o.this.f12176d;
            if (nVar.b() != null) {
                o.this.i(nVar.b());
            } else {
                o.this.g(nVar.a());
            }
        }
    }

    private class b extends FutureTask<n<T>> {
        b(Callable<n<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            if (isCancelled()) {
                return;
            }
            try {
                o.this.l(get());
            } catch (InterruptedException | ExecutionException e8) {
                o.this.l(new n(e8));
            }
        }
    }

    @x0({x0.a.LIBRARY})
    public o(Callable<n<T>> callable) {
        this(callable, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(Throwable th) {
        ArrayList arrayList = new ArrayList(this.f12174b);
        if (arrayList.isEmpty()) {
            com.airbnb.lottie.utils.f.f("Lottie encountered an error but no failure listener was added:", th);
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((j) it.next()).onResult(th);
        }
    }

    private void h() {
        this.f12175c.post(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i(T t7) {
        Iterator it = new ArrayList(this.f12173a).iterator();
        while (it.hasNext()) {
            ((j) it.next()).onResult(t7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(@o0 n<T> nVar) {
        if (this.f12176d != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f12176d = nVar;
        h();
    }

    public synchronized o<T> e(j<Throwable> jVar) {
        if (this.f12176d != null && this.f12176d.a() != null) {
            jVar.onResult(this.f12176d.a());
        }
        this.f12174b.add(jVar);
        return this;
    }

    public synchronized o<T> f(j<T> jVar) {
        if (this.f12176d != null && this.f12176d.b() != null) {
            jVar.onResult(this.f12176d.b());
        }
        this.f12173a.add(jVar);
        return this;
    }

    public synchronized o<T> j(j<Throwable> jVar) {
        this.f12174b.remove(jVar);
        return this;
    }

    public synchronized o<T> k(j<T> jVar) {
        this.f12173a.remove(jVar);
        return this;
    }

    @x0({x0.a.LIBRARY})
    o(Callable<n<T>> callable, boolean z7) {
        this.f12173a = new LinkedHashSet(1);
        this.f12174b = new LinkedHashSet(1);
        this.f12175c = new Handler(Looper.getMainLooper());
        this.f12176d = null;
        if (!z7) {
            f12172e.execute(new b(callable));
            return;
        }
        try {
            l(callable.call());
        } catch (Throwable th) {
            l(new n<>(th));
        }
    }
}
