package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a.b;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public abstract class a0<A extends com.google.android.gms.common.api.a.b, ResultT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.o0
    private final Feature[] f15137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f15138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f15139c;

    @c1.a
    public static class a<A extends com.google.android.gms.common.api.a.b, ResultT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private v<A, com.google.android.gms.tasks.n<ResultT>> f15140a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Feature[] f15142c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f15141b = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f15143d = 0;

        private a() {
        }

        @c1.a
        @c.m0
        public a0<A, ResultT> a() {
            com.google.android.gms.common.internal.u.b(this.f15140a != null, "execute parameter required");
            return new a3(this, this.f15142c, this.f15141b, this.f15143d);
        }

        @c1.a
        @c.m0
        @Deprecated
        public a<A, ResultT> b(@c.m0 final g1.d<A, com.google.android.gms.tasks.n<ResultT>> dVar) {
            this.f15140a = new v() { // from class: com.google.android.gms.common.api.internal.z2
                @Override // com.google.android.gms.common.api.internal.v
                public final void accept(Object obj, Object obj2) {
                    dVar.accept((com.google.android.gms.common.api.a.b) obj, (com.google.android.gms.tasks.n) obj2);
                }
            };
            return this;
        }

        @c1.a
        @c.m0
        public a<A, ResultT> c(@c.m0 v<A, com.google.android.gms.tasks.n<ResultT>> vVar) {
            this.f15140a = vVar;
            return this;
        }

        @c1.a
        @c.m0
        public a<A, ResultT> d(boolean z7) {
            this.f15141b = z7;
            return this;
        }

        @c1.a
        @c.m0
        public a<A, ResultT> e(@c.m0 Feature... featureArr) {
            this.f15142c = featureArr;
            return this;
        }

        @c1.a
        @c.m0
        public a<A, ResultT> f(int i7) {
            this.f15143d = i7;
            return this;
        }

        /* synthetic */ a(b3 b3Var) {
        }
    }

    @c1.a
    @Deprecated
    public a0() {
        this.f15137a = null;
        this.f15138b = false;
        this.f15139c = 0;
    }

    @c1.a
    @c.m0
    public static <A extends com.google.android.gms.common.api.a.b, ResultT> a<A, ResultT> a() {
        return new a<>(null);
    }

    @c1.a
    protected abstract void b(@c.m0 A a8, @c.m0 com.google.android.gms.tasks.n<ResultT> nVar) throws RemoteException;

    @c1.a
    public boolean c() {
        return this.f15138b;
    }

    public final int d() {
        return this.f15139c;
    }

    @c.o0
    public final Feature[] e() {
        return this.f15137a;
    }

    @c1.a
    protected a0(@c.o0 Feature[] featureArr, boolean z7, int i7) {
        this.f15137a = featureArr;
        boolean z8 = false;
        if (featureArr != null && z7) {
            z8 = true;
        }
        this.f15138b = z8;
        this.f15139c = i7;
    }
}
