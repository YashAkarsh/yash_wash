package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
final class n0<TResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f16808a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("mLock")
    private Queue<m0<TResult>> f16809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("mLock")
    private boolean f16810c;

    n0() {
    }

    public final void a(@c.m0 m0<TResult> m0Var) {
        synchronized (this.f16808a) {
            if (this.f16809b == null) {
                this.f16809b = new ArrayDeque();
            }
            this.f16809b.add(m0Var);
        }
    }

    public final void b(@c.m0 m<TResult> mVar) {
        m0<TResult> m0VarPoll;
        synchronized (this.f16808a) {
            if (this.f16809b != null && !this.f16810c) {
                this.f16810c = true;
                while (true) {
                    synchronized (this.f16808a) {
                        m0VarPoll = this.f16809b.poll();
                        if (m0VarPoll == null) {
                            this.f16810c = false;
                            return;
                        }
                    }
                    m0VarPoll.b(mVar);
                }
            }
        }
    }
}
