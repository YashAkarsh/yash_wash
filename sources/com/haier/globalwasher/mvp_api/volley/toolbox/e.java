package com.haier.globalwasher.mvp_api.volley.toolbox;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes2.dex */
public class e<T> extends com.haier.globalwasher.mvp_api.volley.n<T> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final com.haier.globalwasher.mvp_api.volley.b f24970r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Runnable f24971s;

    public e(com.haier.globalwasher.mvp_api.volley.b bVar, Runnable runnable) {
        super(0, null, null);
        this.f24970r = bVar;
        this.f24971s = runnable;
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    public boolean H() {
        this.f24970r.clear();
        if (this.f24971s == null) {
            return true;
        }
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(this.f24971s);
        return true;
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    protected com.haier.globalwasher.mvp_api.volley.p<T> L(com.haier.globalwasher.mvp_api.volley.j jVar) {
        return null;
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    protected void g(T t7) {
    }

    @Override // com.haier.globalwasher.mvp_api.volley.n
    public com.haier.globalwasher.mvp_api.volley.n.c z() {
        return com.haier.globalwasher.mvp_api.volley.n.c.IMMEDIATE;
    }
}
