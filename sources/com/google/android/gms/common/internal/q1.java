package com.google.android.gms.common.internal;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public abstract class q1<TListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.o0
    private TListener f15773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15774b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ e f15775c;

    public q1(e eVar, TListener tlistener) {
        this.f15775c = eVar;
        this.f15773a = tlistener;
    }

    protected abstract void a(TListener tlistener);

    protected abstract void b();

    public final void c() {
        TListener tlistener;
        synchronized (this) {
            tlistener = this.f15773a;
            if (this.f15774b) {
                String string = toString();
                StringBuilder sb = new StringBuilder(string.length() + 47);
                sb.append("Callback proxy ");
                sb.append(string);
                sb.append(" being reused. This is not safe.");
                Log.w("GmsClient", sb.toString());
            }
        }
        if (tlistener != null) {
            a(tlistener);
        }
        synchronized (this) {
            this.f15774b = true;
        }
        e();
    }

    public final void d() {
        synchronized (this) {
            this.f15773a = null;
        }
    }

    public final void e() {
        d();
        synchronized (this.f15775c.f15696r) {
            this.f15775c.f15696r.remove(this);
        }
    }
}
