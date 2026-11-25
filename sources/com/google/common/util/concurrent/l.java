package com.google.common.util.concurrent;

import com.google.common.collect.af;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@y1.f(y1.f.a.FULL)
@s1.b(emulated = true)
abstract class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final b f22812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Logger f22813d = Logger.getLogger(l.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Set<Throwable> f22814a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile int f22815b;

    private static abstract class b {
        private b() {
        }

        abstract void a(l lVar, Set<Throwable> set, Set<Throwable> set2);

        abstract int b(l lVar);
    }

    private static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater<l, Set<Throwable>> f22816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicIntegerFieldUpdater<l> f22817b;

        c(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.f22816a = atomicReferenceFieldUpdater;
            this.f22817b = atomicIntegerFieldUpdater;
        }

        @Override // com.google.common.util.concurrent.l.b
        void a(l lVar, Set<Throwable> set, Set<Throwable> set2) {
            androidx.concurrent.futures.b.a(this.f22816a, lVar, set, set2);
        }

        @Override // com.google.common.util.concurrent.l.b
        int b(l lVar) {
            return this.f22817b.decrementAndGet(lVar);
        }
    }

    private static final class d extends b {
        private d() {
            super();
        }

        @Override // com.google.common.util.concurrent.l.b
        void a(l lVar, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (lVar) {
                if (lVar.f22814a == set) {
                    lVar.f22814a = set2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.l.b
        int b(l lVar) {
            int i7;
            synchronized (lVar) {
                l.d(lVar);
                i7 = lVar.f22815b;
            }
            return i7;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        b dVar;
        Throwable th = null;
        Object[] objArr = 0;
        try {
            dVar = new c(AtomicReferenceFieldUpdater.newUpdater(l.class, Set.class, "a"), AtomicIntegerFieldUpdater.newUpdater(l.class, "b"));
        } catch (Throwable th2) {
            dVar = new d();
            th = th2;
        }
        f22812c = dVar;
        if (th != null) {
            f22813d.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    l(int i7) {
        this.f22815b = i7;
    }

    static /* synthetic */ int d(l lVar) {
        int i7 = lVar.f22815b;
        lVar.f22815b = i7 - 1;
        return i7;
    }

    abstract void e(Set<Throwable> set);

    final int f() {
        return f22812c.b(this);
    }

    final Set<Throwable> g() {
        Set<Throwable> set = this.f22814a;
        if (set != null) {
            return set;
        }
        Set<Throwable> setP = af.p();
        e(setP);
        f22812c.a(this, null, setP);
        return this.f22814a;
    }
}
