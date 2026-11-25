package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
final class f0<TResult> implements m0<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f16789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f16790b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("mLock")
    @Nullable
    private f<TResult> f16791c;

    public f0(@c.m0 Executor executor, @c.m0 f<TResult> fVar) {
        this.f16789a = executor;
        this.f16791c = fVar;
    }

    @Override // com.google.android.gms.tasks.m0
    public final void b(@c.m0 m<TResult> mVar) {
        synchronized (this.f16790b) {
            if (this.f16791c == null) {
                return;
            }
            this.f16789a.execute(new e0(this, mVar));
        }
    }

    @Override // com.google.android.gms.tasks.m0
    public final void t() {
        synchronized (this.f16790b) {
            this.f16791c = null;
        }
    }
}
