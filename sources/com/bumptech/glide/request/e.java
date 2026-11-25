package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.bumptech.glide.request.target.k;
import com.bumptech.glide.util.i;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class e<T, R> implements com.bumptech.glide.request.a<R>, Runnable {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final a f14855l = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f14856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f14858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f14859d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f14860e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private R f14861f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private c f14862g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f14863h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Exception f14864i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f14865j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f14866k;

    static class a {
        a() {
        }

        public void a(Object obj) {
            obj.notifyAll();
        }

        public void b(Object obj, long j7) throws InterruptedException {
            obj.wait(j7);
        }
    }

    public e(Handler handler, int i7, int i8) {
        this(handler, i7, i8, true, f14855l);
    }

    private synchronized R i(Long l7) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.f14859d) {
            i.a();
        }
        if (this.f14863h) {
            throw new CancellationException();
        }
        if (this.f14866k) {
            throw new ExecutionException(this.f14864i);
        }
        if (this.f14865j) {
            return this.f14861f;
        }
        if (l7 == null) {
            this.f14860e.b(this, 0L);
        } else if (l7.longValue() > 0) {
            this.f14860e.b(this, l7.longValue());
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.f14866k) {
            throw new ExecutionException(this.f14864i);
        }
        if (this.f14863h) {
            throw new CancellationException();
        }
        if (!this.f14865j) {
            throw new TimeoutException();
        }
        return this.f14861f;
    }

    @Override // com.bumptech.glide.request.target.m
    public void a(c cVar) {
        this.f14862g = cVar;
    }

    @Override // com.bumptech.glide.request.target.m
    public synchronized void b(R r7, com.bumptech.glide.request.animation.e<? super R> eVar) {
        this.f14865j = true;
        this.f14861f = r7;
        this.f14860e.a(this);
    }

    @Override // com.bumptech.glide.request.target.m
    public synchronized void c(Exception exc, Drawable drawable) {
        this.f14866k = true;
        this.f14864i = exc;
        this.f14860e.a(this);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean cancel(boolean z7) {
        if (this.f14863h) {
            return true;
        }
        boolean z8 = !isDone();
        if (z8) {
            this.f14863h = true;
            if (z7) {
                clear();
            }
            this.f14860e.a(this);
        }
        return z8;
    }

    @Override // com.bumptech.glide.request.a
    public void clear() {
        this.f14856a.post(this);
    }

    @Override // com.bumptech.glide.request.target.m
    public void d(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.m
    public c e() {
        return this.f14862g;
    }

    @Override // com.bumptech.glide.request.target.m
    public void f(Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.h
    public void g() {
    }

    @Override // java.util.concurrent.Future
    public R get() throws ExecutionException, InterruptedException {
        try {
            return i(null);
        } catch (TimeoutException e8) {
            throw new AssertionError(e8);
        }
    }

    @Override // com.bumptech.glide.request.target.m
    public void h(k kVar) {
        kVar.e(this.f14857b, this.f14858c);
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isCancelled() {
        return this.f14863h;
    }

    @Override // java.util.concurrent.Future
    public synchronized boolean isDone() {
        return this.f14863h || this.f14865j;
    }

    @Override // com.bumptech.glide.manager.h
    public void k() {
    }

    @Override // com.bumptech.glide.manager.h
    public void onStart() {
    }

    @Override // java.lang.Runnable
    public void run() {
        c cVar = this.f14862g;
        if (cVar != null) {
            cVar.clear();
            cancel(false);
        }
    }

    e(Handler handler, int i7, int i8, boolean z7, a aVar) {
        this.f14856a = handler;
        this.f14857b = i7;
        this.f14858c = i8;
        this.f14859d = z7;
        this.f14860e = aVar;
    }

    @Override // java.util.concurrent.Future
    public R get(long j7, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return i(Long.valueOf(timeUnit.toMillis(j7)));
    }
}
