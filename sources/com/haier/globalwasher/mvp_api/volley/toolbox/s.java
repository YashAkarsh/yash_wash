package com.haier.globalwasher.mvp_api.volley.toolbox;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes2.dex */
public class s<T> implements Future<T>, com.haier.globalwasher.mvp_api.volley.p.b<T>, com.haier.globalwasher.mvp_api.volley.p.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.haier.globalwasher.mvp_api.volley.n<?> f25034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f25035b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f25036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.haier.globalwasher.mvp_api.volley.u f25037d;

    private s() {
    }

    private synchronized T d(Long l7) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f25037d != null) {
            throw new ExecutionException(this.f25037d);
        }
        if (this.f25035b) {
            return this.f25036c;
        }
        if (l7 == null) {
            wait(0L);
        } else if (l7.longValue() > 0) {
            wait(l7.longValue());
        }
        if (this.f25037d != null) {
            throw new ExecutionException(this.f25037d);
        }
        if (!this.f25035b) {
            throw new TimeoutException();
        }
        return this.f25036c;
    }

    public static <E> s<E> e() {
        return new s<>();
    }

    @Override // com.haier.globalwasher.mvp_api.volley.p.b
    public synchronized void b(T t7) {
        this.f25035b = true;
        this.f25036c = t7;
        notifyAll();
    }

    @Override // com.haier.globalwasher.mvp_api.volley.p.a
    public synchronized void c(com.haier.globalwasher.mvp_api.volley.u uVar) {
        this.f25037d = uVar;
        notifyAll();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z7) {
        if (this.f25034a == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.f25034a.c();
        return true;
    }

    public void f(com.haier.globalwasher.mvp_api.volley.n<?> nVar) {
        this.f25034a = nVar;
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        try {
            return d(null);
        } catch (TimeoutException e8) {
            throw new AssertionError(e8);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        com.haier.globalwasher.mvp_api.volley.n<?> nVar = this.f25034a;
        if (nVar == null) {
            return false;
        }
        return nVar.H();
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        return this.f25035b || this.f25037d != null || isCancelled();
    }

    @Override // java.util.concurrent.Future
    public T get(long j7, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return d(Long.valueOf(TimeUnit.MILLISECONDS.convert(j7, timeUnit)));
    }
}
