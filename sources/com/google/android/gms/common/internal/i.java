package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public abstract class i<T extends IInterface> extends e<T> implements com.google.android.gms.common.api.a.f, q0 {

    @c.o0
    private static volatile Executor N;
    private final f K;
    private final Set<Scope> L;

    @c.o0
    private final Account M;

    @g1.d0
    @c1.a
    protected i(@c.m0 Context context, @c.m0 Handler handler, int i7, @c.m0 f fVar) {
        super(context, handler, j.d(context), com.google.android.gms.common.g.x(), i7, null, null);
        this.K = (f) u.k(fVar);
        this.M = fVar.b();
        this.L = t0(fVar.e());
    }

    private final Set<Scope> t0(@c.m0 Set<Scope> set) {
        Set<Scope> setS0 = s0(set);
        Iterator<Scope> it = setS0.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return setS0;
    }

    @Override // com.google.android.gms.common.internal.e
    @c.o0
    public final Account C() {
        return this.M;
    }

    @Override // com.google.android.gms.common.internal.e
    @c.o0
    protected final Executor E() {
        return null;
    }

    @Override // com.google.android.gms.common.internal.e
    @c1.a
    @c.m0
    protected final Set<Scope> L() {
        return this.L;
    }

    @Override // com.google.android.gms.common.api.a.f
    @c1.a
    @c.m0
    public Set<Scope> g() {
        return w() ? this.L : Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.a.f
    @c1.a
    @c.m0
    public Feature[] n() {
        return new Feature[0];
    }

    @c1.a
    @c.m0
    protected final f r0() {
        return this.K;
    }

    @c1.a
    @c.m0
    protected Set<Scope> s0(@c.m0 Set<Scope> set) {
        return set;
    }

    @c1.a
    protected i(@c.m0 Context context, @c.m0 Looper looper, int i7, @c.m0 f fVar) {
        this(context, looper, j.d(context), com.google.android.gms.common.g.x(), i7, fVar, null, null);
    }

    @c1.a
    @Deprecated
    protected i(@c.m0 Context context, @c.m0 Looper looper, int i7, @c.m0 f fVar, @c.m0 com.google.android.gms.common.api.k.b bVar, @c.m0 com.google.android.gms.common.api.k.c cVar) {
        this(context, looper, i7, fVar, (com.google.android.gms.common.api.internal.f) bVar, (com.google.android.gms.common.api.internal.q) cVar);
    }

    @c1.a
    protected i(@c.m0 Context context, @c.m0 Looper looper, int i7, @c.m0 f fVar, @c.m0 com.google.android.gms.common.api.internal.f fVar2, @c.m0 com.google.android.gms.common.api.internal.q qVar) {
        this(context, looper, j.d(context), com.google.android.gms.common.g.x(), i7, fVar, (com.google.android.gms.common.api.internal.f) u.k(fVar2), (com.google.android.gms.common.api.internal.q) u.k(qVar));
    }

    @g1.d0
    protected i(@c.m0 Context context, @c.m0 Looper looper, @c.m0 j jVar, @c.m0 com.google.android.gms.common.g gVar, int i7, @c.m0 f fVar, @c.o0 com.google.android.gms.common.api.internal.f fVar2, @c.o0 com.google.android.gms.common.api.internal.q qVar) {
        super(context, looper, jVar, gVar, i7, fVar2 == null ? null : new o0(fVar2), qVar == null ? null : new p0(qVar), fVar.m());
        this.K = fVar;
        this.M = fVar.b();
        this.L = t0(fVar.e());
    }
}
