package com.google.common.util.concurrent;

import com.google.common.collect.d7;
import com.google.common.collect.ma;
import com.google.common.collect.nb;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
@s1.c
public abstract class g2<L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f22680a = 1024;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.google.common.base.p0<ReadWriteLock> f22681b = new e();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.google.common.base.p0<ReadWriteLock> f22682c = new f();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f22683d = -1;

    static class a implements com.google.common.base.p0<Lock> {
        a() {
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Lock get() {
            return new i();
        }
    }

    static class b implements com.google.common.base.p0<Lock> {
        b() {
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Lock get() {
            return new ReentrantLock(false);
        }
    }

    static class c implements com.google.common.base.p0<Semaphore> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f22684a;

        c(int i7) {
            this.f22684a = i7;
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Semaphore get() {
            return new j(this.f22684a);
        }
    }

    static class d implements com.google.common.base.p0<Semaphore> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f22685a;

        d(int i7) {
            this.f22685a = i7;
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Semaphore get() {
            return new Semaphore(this.f22685a, false);
        }
    }

    static class e implements com.google.common.base.p0<ReadWriteLock> {
        e() {
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReadWriteLock get() {
            return new ReentrantReadWriteLock();
        }
    }

    static class f implements com.google.common.base.p0<ReadWriteLock> {
        f() {
        }

        @Override // com.google.common.base.p0, java.util.function.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReadWriteLock get() {
            return new o();
        }
    }

    private static class g<L> extends k<L> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Object[] f22686f;

        /* synthetic */ g(int i7, com.google.common.base.p0 p0Var, a aVar) {
            this(i7, p0Var);
        }

        @Override // com.google.common.util.concurrent.g2
        public L g(int i7) {
            return (L) this.f22686f[i7];
        }

        @Override // com.google.common.util.concurrent.g2
        public int p() {
            return this.f22686f.length;
        }

        private g(int i7, com.google.common.base.p0<L> p0Var) {
            super(i7);
            int i8 = 0;
            com.google.common.base.e0.e(i7 <= 1073741824, "Stripes must be <= 2^30)");
            this.f22686f = new Object[this.f22696e + 1];
            while (true) {
                Object[] objArr = this.f22686f;
                if (i8 >= objArr.length) {
                    return;
                }
                objArr[i8] = p0Var.get();
                i8++;
            }
        }
    }

    @s1.d
    static class h<L> extends k<L> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final ConcurrentMap<Integer, L> f22687f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final com.google.common.base.p0<L> f22688g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final int f22689h;

        h(int i7, com.google.common.base.p0<L> p0Var) {
            super(i7);
            int i8 = this.f22696e;
            this.f22689h = i8 == -1 ? Integer.MAX_VALUE : i8 + 1;
            this.f22688g = p0Var;
            this.f22687f = new nb().m().i();
        }

        @Override // com.google.common.util.concurrent.g2
        public L g(int i7) {
            if (this.f22689h != Integer.MAX_VALUE) {
                com.google.common.base.e0.C(i7, p());
            }
            L l7 = this.f22687f.get(Integer.valueOf(i7));
            if (l7 != null) {
                return l7;
            }
            L l8 = this.f22688g.get();
            return (L) com.google.common.base.x.a(this.f22687f.putIfAbsent(Integer.valueOf(i7), l8), l8);
        }

        @Override // com.google.common.util.concurrent.g2
        public int p() {
            return this.f22689h;
        }
    }

    private static class i extends ReentrantLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f22690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f22691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f22692c;

        i() {
            super(false);
        }
    }

    private static class j extends Semaphore {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f22693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f22694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f22695c;

        j(int i7) {
            super(i7, false);
        }
    }

    private static abstract class k<L> extends g2<L> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f22696e;

        k(int i7) {
            super(null);
            com.google.common.base.e0.e(i7 > 0, "Stripes must be positive");
            this.f22696e = i7 > 1073741824 ? -1 : g2.d(i7) - 1;
        }

        @Override // com.google.common.util.concurrent.g2
        public final L f(Object obj) {
            return g(h(obj));
        }

        @Override // com.google.common.util.concurrent.g2
        final int h(Object obj) {
            return g2.q(obj.hashCode()) & this.f22696e;
        }
    }

    @s1.d
    static class l<L> extends k<L> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final AtomicReferenceArray<a<? extends L>> f22697f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final com.google.common.base.p0<L> f22698g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final int f22699h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final ReferenceQueue<L> f22700i;

        private static final class a<L> extends WeakReference<L> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final int f22701a;

            a(L l7, int i7, ReferenceQueue<L> referenceQueue) {
                super(l7, referenceQueue);
                this.f22701a = i7;
            }
        }

        l(int i7, com.google.common.base.p0<L> p0Var) {
            super(i7);
            this.f22700i = new ReferenceQueue<>();
            int i8 = this.f22696e;
            int i9 = i8 == -1 ? Integer.MAX_VALUE : i8 + 1;
            this.f22699h = i9;
            this.f22697f = new AtomicReferenceArray<>(i9);
            this.f22698g = p0Var;
        }

        private void r() {
            while (true) {
                Reference<? extends L> referencePoll = this.f22700i.poll();
                if (referencePoll == null) {
                    return;
                }
                a aVar = (a) referencePoll;
                h2.a(this.f22697f, aVar.f22701a, aVar, null);
            }
        }

        @Override // com.google.common.util.concurrent.g2
        public L g(int i7) {
            if (this.f22699h != Integer.MAX_VALUE) {
                com.google.common.base.e0.C(i7, p());
            }
            a<? extends L> aVar = this.f22697f.get(i7);
            L l7 = aVar == null ? null : aVar.get();
            if (l7 != null) {
                return l7;
            }
            L l8 = this.f22698g.get();
            a aVar2 = new a(l8, i7, this.f22700i);
            while (!h2.a(this.f22697f, i7, aVar, aVar2)) {
                aVar = this.f22697f.get(i7);
                L l9 = aVar == null ? null : aVar.get();
                if (l9 != null) {
                    return l9;
                }
            }
            r();
            return l8;
        }

        @Override // com.google.common.util.concurrent.g2
        public int p() {
            return this.f22699h;
        }
    }

    private static final class m extends w0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Condition f22702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final o f22703b;

        m(Condition condition, o oVar) {
            this.f22702a = condition;
            this.f22703b = oVar;
        }

        @Override // com.google.common.util.concurrent.w0
        Condition a() {
            return this.f22702a;
        }
    }

    private static final class n extends c1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Lock f22704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final o f22705b;

        n(Lock lock, o oVar) {
            this.f22704a = lock;
            this.f22705b = oVar;
        }

        @Override // com.google.common.util.concurrent.c1
        Lock a() {
            return this.f22704a;
        }

        @Override // com.google.common.util.concurrent.c1, java.util.concurrent.locks.Lock
        public Condition newCondition() {
            return new m(this.f22704a.newCondition(), this.f22705b);
        }
    }

    private static final class o implements ReadWriteLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ReadWriteLock f22706a = new ReentrantReadWriteLock();

        o() {
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock readLock() {
            return new n(this.f22706a.readLock(), this);
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock writeLock() {
            return new n(this.f22706a.writeLock(), this);
        }
    }

    /* synthetic */ g2(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(int i7) {
        return 1 << com.google.common.math.d.p(i7, RoundingMode.CEILING);
    }

    static <L> g2<L> e(int i7, com.google.common.base.p0<L> p0Var) {
        return new g(i7, p0Var, null);
    }

    private static <L> g2<L> i(int i7, com.google.common.base.p0<L> p0Var) {
        return i7 < 1024 ? new l(i7, p0Var) : new h(i7, p0Var);
    }

    public static g2<Lock> j(int i7) {
        return i(i7, new b());
    }

    public static g2<ReadWriteLock> k(int i7) {
        return i(i7, f22682c);
    }

    public static g2<Semaphore> l(int i7, int i8) {
        return i(i7, new d(i8));
    }

    public static g2<Lock> m(int i7) {
        return e(i7, new a());
    }

    public static g2<ReadWriteLock> n(int i7) {
        return e(i7, f22681b);
    }

    public static g2<Semaphore> o(int i7, int i8) {
        return e(i7, new c(i8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int q(int i7) {
        int i8 = i7 ^ ((i7 >>> 20) ^ (i7 >>> 12));
        return (i8 >>> 4) ^ ((i8 >>> 7) ^ i8);
    }

    public Iterable<L> c(Iterable<?> iterable) {
        Object[] objArrO = ma.O(iterable, Object.class);
        if (objArrO.length == 0) {
            return d7.x();
        }
        int[] iArr = new int[objArrO.length];
        for (int i7 = 0; i7 < objArrO.length; i7++) {
            iArr[i7] = h(objArrO[i7]);
        }
        Arrays.sort(iArr);
        int i8 = iArr[0];
        objArrO[0] = g(i8);
        for (int i9 = 1; i9 < objArrO.length; i9++) {
            int i10 = iArr[i9];
            if (i10 == i8) {
                objArrO[i9] = objArrO[i9 - 1];
            } else {
                objArrO[i9] = g(i10);
                i8 = i10;
            }
        }
        return Collections.unmodifiableList(Arrays.asList(objArrO));
    }

    public abstract L f(Object obj);

    public abstract L g(int i7);

    abstract int h(Object obj);

    public abstract int p();

    private g2() {
    }
}
