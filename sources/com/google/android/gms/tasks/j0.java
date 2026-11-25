package com.google.android.gms.tasks;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
final class j0<TResult> implements m0<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f16799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f16800b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("mLock")
    @Nullable
    private h<? super TResult> f16801c;

    public j0(@c.m0 Executor executor, @c.m0 h<? super TResult> hVar) {
        this.f16799a = executor;
        this.f16801c = hVar;
    }

    @Override // com.google.android.gms.tasks.m0
    public final void b(@c.m0 m<TResult> mVar) {
        if (mVar.v()) {
            synchronized (this.f16800b) {
                if (this.f16801c == null) {
                    return;
                }
                this.f16799a.execute(new i0(this, mVar));
            }
        }
    }

    @Override // com.google.android.gms.tasks.m0
    public final void t() {
        synchronized (this.f16800b) {
            this.f16801c = null;
        }
    }
}
