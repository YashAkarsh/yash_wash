package com.google.android.gms.tasks;

import java.util.concurrent.ExecutionException;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
final class w implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f16832a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s0<Void> f16834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("mLock")
    private int f16835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("mLock")
    private int f16836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("mLock")
    private int f16837f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy("mLock")
    private Exception f16838g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @GuardedBy("mLock")
    private boolean f16839h;

    public w(int i7, s0<Void> s0Var) {
        this.f16833b = i7;
        this.f16834c = s0Var;
    }

    @GuardedBy("mLock")
    private final void b() {
        if (this.f16835d + this.f16836e + this.f16837f == this.f16833b) {
            if (this.f16838g == null) {
                if (this.f16839h) {
                    this.f16834c.A();
                    return;
                } else {
                    this.f16834c.z(null);
                    return;
                }
            }
            s0<Void> s0Var = this.f16834c;
            int i7 = this.f16836e;
            int i8 = this.f16833b;
            StringBuilder sb = new StringBuilder(54);
            sb.append(i7);
            sb.append(" out of ");
            sb.append(i8);
            sb.append(" underlying tasks failed");
            s0Var.y(new ExecutionException(sb.toString(), this.f16838g));
        }
    }

    @Override // com.google.android.gms.tasks.e
    public final void a() {
        synchronized (this.f16832a) {
            this.f16837f++;
            this.f16839h = true;
            b();
        }
    }

    @Override // com.google.android.gms.tasks.g
    public final void c(@c.m0 Exception exc) {
        synchronized (this.f16832a) {
            this.f16836e++;
            this.f16838g = exc;
            b();
        }
    }

    @Override // com.google.android.gms.tasks.h
    public final void onSuccess(Object obj) {
        synchronized (this.f16832a) {
            this.f16835d++;
            b();
        }
    }
}
