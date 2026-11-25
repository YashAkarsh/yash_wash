package com.google.common.collect;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class nb {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f20746g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f20747h = 4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int f20748i = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f20749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f20750b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f20751c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    ob.q f20752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ob.q f20753e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    com.google.common.base.l<Object> f20754f;

    enum a {
        VALUE
    }

    @u1.a
    public nb a(int i7) {
        int i8 = this.f20751c;
        com.google.common.base.e0.n0(i8 == -1, "concurrency level was already set to %s", i8);
        com.google.common.base.e0.d(i7 > 0);
        this.f20751c = i7;
        return this;
    }

    int b() {
        int i7 = this.f20751c;
        if (i7 == -1) {
            return 4;
        }
        return i7;
    }

    int c() {
        int i7 = this.f20750b;
        if (i7 == -1) {
            return 16;
        }
        return i7;
    }

    com.google.common.base.l<Object> d() {
        return (com.google.common.base.l) com.google.common.base.x.a(this.f20754f, e().a());
    }

    ob.q e() {
        return (ob.q) com.google.common.base.x.a(this.f20752d, ob.q.f20842a);
    }

    ob.q f() {
        return (ob.q) com.google.common.base.x.a(this.f20753e, ob.q.f20842a);
    }

    @u1.a
    public nb g(int i7) {
        int i8 = this.f20750b;
        com.google.common.base.e0.n0(i8 == -1, "initial capacity was already set to %s", i8);
        com.google.common.base.e0.d(i7 >= 0);
        this.f20750b = i7;
        return this;
    }

    @u1.a
    @s1.c
    nb h(com.google.common.base.l<Object> lVar) {
        com.google.common.base.l<Object> lVar2 = this.f20754f;
        com.google.common.base.e0.x0(lVar2 == null, "key equivalence was already set to %s", lVar2);
        this.f20754f = (com.google.common.base.l) com.google.common.base.e0.E(lVar);
        this.f20749a = true;
        return this;
    }

    public <K, V> ConcurrentMap<K, V> i() {
        return !this.f20749a ? new ConcurrentHashMap(c(), 0.75f, b()) : ob.c(this);
    }

    nb j(ob.q qVar) {
        ob.q qVar2 = this.f20752d;
        com.google.common.base.e0.x0(qVar2 == null, "Key strength was already set to %s", qVar2);
        this.f20752d = (ob.q) com.google.common.base.e0.E(qVar);
        if (qVar != ob.q.f20842a) {
            this.f20749a = true;
        }
        return this;
    }

    nb k(ob.q qVar) {
        ob.q qVar2 = this.f20753e;
        com.google.common.base.e0.x0(qVar2 == null, "Value strength was already set to %s", qVar2);
        this.f20753e = (ob.q) com.google.common.base.e0.E(qVar);
        if (qVar != ob.q.f20842a) {
            this.f20749a = true;
        }
        return this;
    }

    @u1.a
    @s1.c
    public nb l() {
        return j(ob.q.f20843b);
    }

    @u1.a
    @s1.c
    public nb m() {
        return k(ob.q.f20843b);
    }

    public String toString() {
        com.google.common.base.x.b bVarC = com.google.common.base.x.c(this);
        int i7 = this.f20750b;
        if (i7 != -1) {
            bVarC.d("initialCapacity", i7);
        }
        int i8 = this.f20751c;
        if (i8 != -1) {
            bVarC.d("concurrencyLevel", i8);
        }
        ob.q qVar = this.f20752d;
        if (qVar != null) {
            bVarC.f("keyStrength", com.google.common.base.c.g(qVar.toString()));
        }
        ob.q qVar2 = this.f20753e;
        if (qVar2 != null) {
            bVarC.f("valueStrength", com.google.common.base.c.g(qVar2.toString()));
        }
        if (this.f20754f != null) {
            bVarC.p("keyEquivalence");
        }
        return bVarC.toString();
    }
}
