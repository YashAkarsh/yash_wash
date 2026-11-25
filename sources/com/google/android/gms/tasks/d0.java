package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
final class d0<TResult> implements m0<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f16784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f16785b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("mLock")
    @Nullable
    private e f16786c;

    public d0(@c.m0 Executor executor, @c.m0 e eVar) {
        this.f16784a = executor;
        this.f16786c = eVar;
    }

    @Override // com.google.android.gms.tasks.m0
    public final void b(@c.m0 m<TResult> mVar) {
        if (mVar.t()) {
            synchronized (this.f16785b) {
                if (this.f16786c == null) {
                    return;
                }
                this.f16784a.execute(new c0(this));
            }
        }
    }

    @Override // com.google.android.gms.tasks.m0
    public final void t() {
        synchronized (this.f16785b) {
            this.f16786c = null;
        }
    }
}
