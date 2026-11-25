package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a.b;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class u<A extends com.google.android.gms.common.api.a.b, L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c1.a
    @c.m0
    public final t<A, L> f15415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.m0
    public final c0<A, L> f15416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.m0
    public final Runnable f15417c;

    @c1.a
    public static class a<A extends com.google.android.gms.common.api.a.b, L> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private v<A, com.google.android.gms.tasks.n<Void>> f15418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private v<A, com.google.android.gms.tasks.n<Boolean>> f15419b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private n<L> f15421d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Feature[] f15422e;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f15424g;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Runnable f15420c = o2.f15362a;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f15423f = true;

        private a() {
        }

        @c1.a
        @c.m0
        public u<A, L> a() {
            com.google.android.gms.common.internal.u.b(this.f15418a != null, "Must set register function");
            com.google.android.gms.common.internal.u.b(this.f15419b != null, "Must set unregister function");
            com.google.android.gms.common.internal.u.b(this.f15421d != null, "Must set holder");
            return new u<>(new p2(this, this.f15421d, this.f15422e, this.f15423f, this.f15424g), new q2(this, (n.a) com.google.android.gms.common.internal.u.l(this.f15421d.b(), "Key must not be null")), this.f15420c, null);
        }

        @c1.a
        @c.m0
        public a<A, L> b(@c.m0 Runnable runnable) {
            this.f15420c = runnable;
            return this;
        }

        @c1.a
        @c.m0
        public a<A, L> c(@c.m0 v<A, com.google.android.gms.tasks.n<Void>> vVar) {
            this.f15418a = vVar;
            return this;
        }

        @c1.a
        @c.m0
        public a<A, L> d(boolean z7) {
            this.f15423f = z7;
            return this;
        }

        @c1.a
        @c.m0
        public a<A, L> e(@c.m0 Feature... featureArr) {
            this.f15422e = featureArr;
            return this;
        }

        @c1.a
        @c.m0
        public a<A, L> f(int i7) {
            this.f15424g = i7;
            return this;
        }

        @c1.a
        @c.m0
        public a<A, L> g(@c.m0 v<A, com.google.android.gms.tasks.n<Boolean>> vVar) {
            this.f15419b = vVar;
            return this;
        }

        @c1.a
        @c.m0
        public a<A, L> h(@c.m0 n<L> nVar) {
            this.f15421d = nVar;
            return this;
        }

        /* synthetic */ a(r2 r2Var) {
        }
    }

    /* synthetic */ u(t tVar, c0 c0Var, Runnable runnable, s2 s2Var) {
        this.f15415a = tVar;
        this.f15416b = c0Var;
        this.f15417c = runnable;
    }

    @c1.a
    @c.m0
    public static <A extends com.google.android.gms.common.api.a.b, L> a<A, L> a() {
        return new a<>(null);
    }
}
