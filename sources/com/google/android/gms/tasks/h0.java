package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
final class h0<TResult> implements m0<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f16794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f16795b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("mLock")
    @Nullable
    private g f16796c;

    public h0(@c.m0 Executor executor, @c.m0 g gVar) {
        this.f16794a = executor;
        this.f16796c = gVar;
    }

    @Override // com.google.android.gms.tasks.m0
    public final void b(@c.m0 m<TResult> mVar) {
        if (mVar.v() || mVar.t()) {
            return;
        }
        synchronized (this.f16795b) {
            if (this.f16796c == null) {
                return;
            }
            this.f16794a.execute(new g0(this, mVar));
        }
    }

    @Override // com.google.android.gms.tasks.m0
    public final void t() {
        synchronized (this.f16795b) {
            this.f16796c = null;
        }
    }
}
