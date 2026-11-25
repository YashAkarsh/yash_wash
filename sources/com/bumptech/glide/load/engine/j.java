package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.p;

/* JADX INFO: loaded from: classes.dex */
class j implements Runnable, com.bumptech.glide.load.engine.executor.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f14414f = "EngineRunnable";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f14415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f14416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.b<?, ?, ?> f14417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f14418d = b.CACHE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f14419e;

    interface a extends com.bumptech.glide.request.g {
        void f(j jVar);
    }

    private enum b {
        CACHE,
        SOURCE
    }

    public j(a aVar, com.bumptech.glide.load.engine.b<?, ?, ?> bVar, p pVar) {
        this.f14416b = aVar;
        this.f14417c = bVar;
        this.f14415a = pVar;
    }

    private m<?> c() throws Exception {
        return f() ? d() : e();
    }

    private m<?> d() throws Exception {
        m<?> mVarF;
        try {
            mVarF = this.f14417c.f();
        } catch (Exception e8) {
            if (Log.isLoggable(f14414f, 3)) {
                Log.d(f14414f, "Exception decoding result from cache: " + e8);
            }
            mVarF = null;
        }
        return mVarF == null ? this.f14417c.h() : mVarF;
    }

    private m<?> e() throws Exception {
        return this.f14417c.d();
    }

    private boolean f() {
        return this.f14418d == b.CACHE;
    }

    private void g(m mVar) {
        this.f14416b.b(mVar);
    }

    private void h(Exception exc) {
        if (!f()) {
            this.f14416b.d(exc);
        } else {
            this.f14418d = b.SOURCE;
            this.f14416b.f(this);
        }
    }

    @Override // com.bumptech.glide.load.engine.executor.b
    public int a() {
        return this.f14415a.ordinal();
    }

    public void b() {
        this.f14419e = true;
        this.f14417c.c();
    }

    @Override // java.lang.Runnable
    public void run() throws Exception {
        Exception kVar;
        if (this.f14419e) {
            return;
        }
        m<?> mVarC = null;
        try {
            mVarC = c();
            kVar = null;
        } catch (Exception e8) {
            if (Log.isLoggable(f14414f, 2)) {
                Log.v(f14414f, "Exception decoding", e8);
            }
            kVar = e8;
        } catch (OutOfMemoryError e9) {
            if (Log.isLoggable(f14414f, 2)) {
                Log.v(f14414f, "Out Of Memory Error decoding", e9);
            }
            kVar = new k(e9);
        }
        if (this.f14419e) {
            if (mVarC != null) {
                mVarC.a();
            }
        } else if (mVarC == null) {
            h(kVar);
        } else {
            g(mVarC);
        }
    }
}
