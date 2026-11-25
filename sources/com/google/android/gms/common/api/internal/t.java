package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.a.b;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public abstract class t<A extends com.google.android.gms.common.api.a.b, L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n<L> f15405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.o0
    private final Feature[] f15406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f15407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f15408d;

    @c1.a
    protected t(@c.m0 n<L> nVar, @c.o0 Feature[] featureArr, boolean z7, int i7) {
        this.f15405a = nVar;
        this.f15406b = featureArr;
        this.f15407c = z7;
        this.f15408d = i7;
    }

    @c1.a
    public void a() {
        this.f15405a.a();
    }

    @c.o0
    @c1.a
    public n.a<L> b() {
        return this.f15405a.b();
    }

    @c.o0
    @c1.a
    public Feature[] c() {
        return this.f15406b;
    }

    @c1.a
    protected abstract void d(@c.m0 A a8, @c.m0 com.google.android.gms.tasks.n<Void> nVar) throws RemoteException;

    public final int e() {
        return this.f15408d;
    }

    public final boolean f() {
        return this.f15407c;
    }

    @c1.a
    protected t(@c.m0 n<L> nVar) {
        this(nVar, null, false, 0);
    }

    @c1.a
    protected t(@c.m0 n<L> nVar, @c.m0 Feature[] featureArr, boolean z7) {
        this(nVar, featureArr, z7, 0);
    }
}
