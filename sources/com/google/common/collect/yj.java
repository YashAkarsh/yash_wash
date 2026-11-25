package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.ObjIntConsumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class yj<E> extends e0<E> implements Serializable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @s1.c
    private static final long f21451h = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final transient g<f<E>> f21452e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient k6<E> f21453f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient f<E> f21454g;

    class a extends md.f<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f21455a;

        a(f fVar) {
            this.f21455a = fVar;
        }

        @Override // com.google.common.collect.hd.a
        public int getCount() {
            int iX = this.f21455a.x();
            return iX == 0 ? yj.this.l0(getElement()) : iX;
        }

        @Override // com.google.common.collect.hd.a
        public E getElement() {
            return (E) this.f21455a.y();
        }
    }

    class b implements Iterator<hd.a<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        f<E> f21457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        hd.a<E> f21458b;

        b() {
            this.f21457a = yj.this.D();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public hd.a<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            hd.a<E> aVarJ = yj.this.J(this.f21457a);
            this.f21458b = aVarJ;
            if (((f) this.f21457a).f21475i == yj.this.f21454g) {
                this.f21457a = null;
            } else {
                this.f21457a = ((f) this.f21457a).f21475i;
            }
            return aVarJ;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f21457a == null) {
                return false;
            }
            if (!yj.this.f21453f.p(this.f21457a.y())) {
                return true;
            }
            this.f21457a = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            f2.e(this.f21458b != null);
            yj.this.setCount(this.f21458b.getElement(), 0);
            this.f21458b = null;
        }
    }

    class c implements Iterator<hd.a<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        f<E> f21460a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        hd.a<E> f21461b = null;

        c() {
            this.f21460a = yj.this.F();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public hd.a<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            hd.a<E> aVarJ = yj.this.J(this.f21460a);
            this.f21461b = aVarJ;
            if (((f) this.f21460a).f21474h == yj.this.f21454g) {
                this.f21460a = null;
            } else {
                this.f21460a = ((f) this.f21460a).f21474h;
            }
            return aVarJ;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f21460a == null) {
                return false;
            }
            if (!yj.this.f21453f.q(this.f21460a.y())) {
                return true;
            }
            this.f21460a = null;
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            f2.e(this.f21461b != null);
            yj.this.setCount(this.f21461b.getElement(), 0);
            this.f21461b = null;
        }
    }

    static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f21463a;

        static {
            int[] iArr = new int[s0.values().length];
            f21463a = iArr;
            try {
                iArr[s0.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21463a[s0.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f21464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f21465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ e[] f21466c;

        static enum a extends e {
            a(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.collect.yj.e
            int a(f<?> fVar) {
                return ((f) fVar).f21468b;
            }

            @Override // com.google.common.collect.yj.e
            long b(f<?> fVar) {
                if (fVar == null) {
                    return 0L;
                }
                return ((f) fVar).f21470d;
            }
        }

        static enum b extends e {
            b(String str, int i7) {
                super(str, i7, null);
            }

            @Override // com.google.common.collect.yj.e
            int a(f<?> fVar) {
                return 1;
            }

            @Override // com.google.common.collect.yj.e
            long b(f<?> fVar) {
                if (fVar == null) {
                    return 0L;
                }
                return ((f) fVar).f21469c;
            }
        }

        static {
            a aVar = new a("SIZE", 0);
            f21464a = aVar;
            b bVar = new b("DISTINCT", 1);
            f21465b = bVar;
            f21466c = new e[]{aVar, bVar};
        }

        private e(String str, int i7) {
            super(str, i7);
        }

        public static e valueOf(String str) {
            return (e) Enum.valueOf(e.class, str);
        }

        public static e[] values() {
            return (e[]) f21466c.clone();
        }

        abstract int a(f<?> fVar);

        abstract long b(f<?> fVar);

        /* synthetic */ e(String str, int i7, a aVar) {
            this(str, i7);
        }
    }

    private static final class f<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final E f21467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f21468b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f21469c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f21470d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f21471e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private f<E> f21472f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private f<E> f21473g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private f<E> f21474h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private f<E> f21475i;

        f(E e8, int i7) {
            com.google.common.base.e0.d(i7 > 0);
            this.f21467a = e8;
            this.f21468b = i7;
            this.f21470d = i7;
            this.f21469c = 1;
            this.f21471e = 1;
            this.f21472f = null;
            this.f21473g = null;
        }

        private f<E> A() {
            int iS = s();
            if (iS == -2) {
                if (this.f21473g.s() > 0) {
                    this.f21473g = this.f21473g.I();
                }
                return H();
            }
            if (iS != 2) {
                C();
                return this;
            }
            if (this.f21472f.s() < 0) {
                this.f21472f = this.f21472f.H();
            }
            return I();
        }

        private void B() {
            D();
            C();
        }

        private void C() {
            this.f21471e = Math.max(z(this.f21472f), z(this.f21473g)) + 1;
        }

        private void D() {
            this.f21469c = yj.B(this.f21472f) + 1 + yj.B(this.f21473g);
            this.f21470d = ((long) this.f21468b) + L(this.f21472f) + L(this.f21473g);
        }

        private f<E> F(f<E> fVar) {
            f<E> fVar2 = this.f21473g;
            if (fVar2 == null) {
                return this.f21472f;
            }
            this.f21473g = fVar2.F(fVar);
            this.f21469c--;
            this.f21470d -= (long) fVar.f21468b;
            return A();
        }

        private f<E> G(f<E> fVar) {
            f<E> fVar2 = this.f21472f;
            if (fVar2 == null) {
                return this.f21473g;
            }
            this.f21472f = fVar2.G(fVar);
            this.f21469c--;
            this.f21470d -= (long) fVar.f21468b;
            return A();
        }

        private f<E> H() {
            com.google.common.base.e0.g0(this.f21473g != null);
            f<E> fVar = this.f21473g;
            this.f21473g = fVar.f21472f;
            fVar.f21472f = this;
            fVar.f21470d = this.f21470d;
            fVar.f21469c = this.f21469c;
            B();
            fVar.C();
            return fVar;
        }

        private f<E> I() {
            com.google.common.base.e0.g0(this.f21472f != null);
            f<E> fVar = this.f21472f;
            this.f21472f = fVar.f21473g;
            fVar.f21473g = this;
            fVar.f21470d = this.f21470d;
            fVar.f21469c = this.f21469c;
            B();
            fVar.C();
            return fVar;
        }

        private static long L(f<?> fVar) {
            if (fVar == null) {
                return 0L;
            }
            return ((f) fVar).f21470d;
        }

        private f<E> q(E e8, int i7) {
            f<E> fVar = new f<>(e8, i7);
            this.f21472f = fVar;
            yj.I(this.f21474h, fVar, this);
            this.f21471e = Math.max(2, this.f21471e);
            this.f21469c++;
            this.f21470d += (long) i7;
            return this;
        }

        private f<E> r(E e8, int i7) {
            f<E> fVar = new f<>(e8, i7);
            this.f21473g = fVar;
            yj.I(this, fVar, this.f21475i);
            this.f21471e = Math.max(2, this.f21471e);
            this.f21469c++;
            this.f21470d += (long) i7;
            return this;
        }

        private int s() {
            return z(this.f21472f) - z(this.f21473g);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public f<E> t(Comparator<? super E> comparator, E e8) {
            int iCompare = comparator.compare(e8, this.f21467a);
            if (iCompare < 0) {
                f<E> fVar = this.f21472f;
                return fVar == null ? this : (f) com.google.common.base.x.a(fVar.t(comparator, e8), this);
            }
            if (iCompare == 0) {
                return this;
            }
            f<E> fVar2 = this.f21473g;
            if (fVar2 == null) {
                return null;
            }
            return fVar2.t(comparator, e8);
        }

        private f<E> v() {
            int i7 = this.f21468b;
            this.f21468b = 0;
            yj.H(this.f21474h, this.f21475i);
            f<E> fVar = this.f21472f;
            if (fVar == null) {
                return this.f21473g;
            }
            f<E> fVar2 = this.f21473g;
            if (fVar2 == null) {
                return fVar;
            }
            if (fVar.f21471e >= fVar2.f21471e) {
                f<E> fVar3 = this.f21474h;
                fVar3.f21472f = fVar.F(fVar3);
                fVar3.f21473g = this.f21473g;
                fVar3.f21469c = this.f21469c - 1;
                fVar3.f21470d = this.f21470d - ((long) i7);
                return fVar3.A();
            }
            f<E> fVar4 = this.f21475i;
            fVar4.f21473g = fVar2.G(fVar4);
            fVar4.f21472f = this.f21472f;
            fVar4.f21469c = this.f21469c - 1;
            fVar4.f21470d = this.f21470d - ((long) i7);
            return fVar4.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public f<E> w(Comparator<? super E> comparator, E e8) {
            int iCompare = comparator.compare(e8, this.f21467a);
            if (iCompare > 0) {
                f<E> fVar = this.f21473g;
                return fVar == null ? this : (f) com.google.common.base.x.a(fVar.w(comparator, e8), this);
            }
            if (iCompare == 0) {
                return this;
            }
            f<E> fVar2 = this.f21472f;
            if (fVar2 == null) {
                return null;
            }
            return fVar2.w(comparator, e8);
        }

        private static int z(f<?> fVar) {
            if (fVar == null) {
                return 0;
            }
            return ((f) fVar).f21471e;
        }

        /* JADX WARN: Multi-variable type inference failed */
        f<E> E(Comparator<? super E> comparator, E e8, int i7, int[] iArr) {
            int iCompare = comparator.compare(e8, this.f21467a);
            if (iCompare < 0) {
                f<E> fVar = this.f21472f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f21472f = fVar.E(comparator, e8, i7, iArr);
                int i8 = iArr[0];
                if (i8 > 0) {
                    if (i7 >= i8) {
                        this.f21469c--;
                        this.f21470d -= (long) i8;
                    } else {
                        this.f21470d -= (long) i7;
                    }
                }
                return i8 == 0 ? this : A();
            }
            if (iCompare <= 0) {
                int i9 = this.f21468b;
                iArr[0] = i9;
                if (i7 >= i9) {
                    return v();
                }
                this.f21468b = i9 - i7;
                this.f21470d -= (long) i7;
                return this;
            }
            f<E> fVar2 = this.f21473g;
            if (fVar2 == null) {
                iArr[0] = 0;
                return this;
            }
            this.f21473g = fVar2.E(comparator, e8, i7, iArr);
            int i10 = iArr[0];
            if (i10 > 0) {
                if (i7 >= i10) {
                    this.f21469c--;
                    this.f21470d -= (long) i10;
                } else {
                    this.f21470d -= (long) i7;
                }
            }
            return A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        f<E> J(Comparator<? super E> comparator, E e8, int i7, int i8, int[] iArr) {
            int iCompare = comparator.compare(e8, this.f21467a);
            if (iCompare < 0) {
                f<E> fVar = this.f21472f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return (i7 != 0 || i8 <= 0) ? this : q(e8, i8);
                }
                this.f21472f = fVar.J(comparator, e8, i7, i8, iArr);
                int i9 = iArr[0];
                if (i9 == i7) {
                    if (i8 == 0 && i9 != 0) {
                        this.f21469c--;
                    } else if (i8 > 0 && i9 == 0) {
                        this.f21469c++;
                    }
                    this.f21470d += (long) (i8 - i9);
                }
                return A();
            }
            if (iCompare <= 0) {
                int i10 = this.f21468b;
                iArr[0] = i10;
                if (i7 == i10) {
                    if (i8 == 0) {
                        return v();
                    }
                    this.f21470d += (long) (i8 - i10);
                    this.f21468b = i8;
                }
                return this;
            }
            f<E> fVar2 = this.f21473g;
            if (fVar2 == null) {
                iArr[0] = 0;
                return (i7 != 0 || i8 <= 0) ? this : r(e8, i8);
            }
            this.f21473g = fVar2.J(comparator, e8, i7, i8, iArr);
            int i11 = iArr[0];
            if (i11 == i7) {
                if (i8 == 0 && i11 != 0) {
                    this.f21469c--;
                } else if (i8 > 0 && i11 == 0) {
                    this.f21469c++;
                }
                this.f21470d += (long) (i8 - i11);
            }
            return A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        f<E> K(Comparator<? super E> comparator, E e8, int i7, int[] iArr) {
            int iCompare = comparator.compare(e8, this.f21467a);
            if (iCompare < 0) {
                f<E> fVar = this.f21472f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return i7 > 0 ? q(e8, i7) : this;
                }
                this.f21472f = fVar.K(comparator, e8, i7, iArr);
                if (i7 == 0 && iArr[0] != 0) {
                    this.f21469c--;
                } else if (i7 > 0 && iArr[0] == 0) {
                    this.f21469c++;
                }
                this.f21470d += (long) (i7 - iArr[0]);
                return A();
            }
            if (iCompare <= 0) {
                int i8 = this.f21468b;
                iArr[0] = i8;
                if (i7 == 0) {
                    return v();
                }
                this.f21470d += (long) (i7 - i8);
                this.f21468b = i7;
                return this;
            }
            f<E> fVar2 = this.f21473g;
            if (fVar2 == null) {
                iArr[0] = 0;
                return i7 > 0 ? r(e8, i7) : this;
            }
            this.f21473g = fVar2.K(comparator, e8, i7, iArr);
            if (i7 == 0 && iArr[0] != 0) {
                this.f21469c--;
            } else if (i7 > 0 && iArr[0] == 0) {
                this.f21469c++;
            }
            this.f21470d += (long) (i7 - iArr[0]);
            return A();
        }

        /* JADX WARN: Multi-variable type inference failed */
        f<E> p(Comparator<? super E> comparator, E e8, int i7, int[] iArr) {
            int iCompare = comparator.compare(e8, this.f21467a);
            if (iCompare < 0) {
                f<E> fVar = this.f21472f;
                if (fVar == null) {
                    iArr[0] = 0;
                    return q(e8, i7);
                }
                int i8 = fVar.f21471e;
                f<E> fVarP = fVar.p(comparator, e8, i7, iArr);
                this.f21472f = fVarP;
                if (iArr[0] == 0) {
                    this.f21469c++;
                }
                this.f21470d += (long) i7;
                return fVarP.f21471e == i8 ? this : A();
            }
            if (iCompare <= 0) {
                int i9 = this.f21468b;
                iArr[0] = i9;
                long j7 = i7;
                com.google.common.base.e0.d(((long) i9) + j7 <= 2147483647L);
                this.f21468b += i7;
                this.f21470d += j7;
                return this;
            }
            f<E> fVar2 = this.f21473g;
            if (fVar2 == null) {
                iArr[0] = 0;
                return r(e8, i7);
            }
            int i10 = fVar2.f21471e;
            f<E> fVarP2 = fVar2.p(comparator, e8, i7, iArr);
            this.f21473g = fVarP2;
            if (iArr[0] == 0) {
                this.f21469c++;
            }
            this.f21470d += (long) i7;
            return fVarP2.f21471e == i10 ? this : A();
        }

        public String toString() {
            return md.m(y(), x()).toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int u(Comparator<? super E> comparator, E e8) {
            int iCompare = comparator.compare(e8, this.f21467a);
            if (iCompare < 0) {
                f<E> fVar = this.f21472f;
                if (fVar == null) {
                    return 0;
                }
                return fVar.u(comparator, e8);
            }
            if (iCompare <= 0) {
                return this.f21468b;
            }
            f<E> fVar2 = this.f21473g;
            if (fVar2 == null) {
                return 0;
            }
            return fVar2.u(comparator, e8);
        }

        int x() {
            return this.f21468b;
        }

        E y() {
            return this.f21467a;
        }
    }

    private static final class g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private T f21476a;

        private g() {
        }

        public void a(T t7, T t8) {
            if (this.f21476a != t7) {
                throw new ConcurrentModificationException();
            }
            this.f21476a = t8;
        }

        void b() {
            this.f21476a = null;
        }

        public T c() {
            return this.f21476a;
        }

        /* synthetic */ g(a aVar) {
            this();
        }
    }

    yj(g<f<E>> gVar, k6<E> k6Var, f<E> fVar) {
        super(k6Var.b());
        this.f21452e = gVar;
        this.f21453f = k6Var;
        this.f21454g = fVar;
    }

    public static <E> yj<E> A(Comparator<? super E> comparator) {
        return comparator == null ? new yj<>(td.A()) : new yj<>(comparator);
    }

    static int B(f<?> fVar) {
        if (fVar == null) {
            return 0;
        }
        return ((f) fVar).f21469c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f<E> D() {
        f<E> fVarT;
        if (this.f21452e.c() == null) {
            return null;
        }
        if (this.f21453f.j()) {
            E eG = this.f21453f.g();
            fVarT = this.f21452e.c().t(comparator(), eG);
            if (fVarT == null) {
                return null;
            }
            if (this.f21453f.f() == s0.OPEN && comparator().compare(eG, fVarT.y()) == 0) {
                fVarT = ((f) fVarT).f21475i;
            }
        } else {
            fVarT = ((f) this.f21454g).f21475i;
        }
        if (fVarT == this.f21454g || !this.f21453f.c(fVarT.y())) {
            return null;
        }
        return fVarT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f<E> F() {
        f<E> fVarW;
        if (this.f21452e.c() == null) {
            return null;
        }
        if (this.f21453f.k()) {
            E eI = this.f21453f.i();
            fVarW = this.f21452e.c().w(comparator(), eI);
            if (fVarW == null) {
                return null;
            }
            if (this.f21453f.h() == s0.OPEN && comparator().compare(eI, fVarW.y()) == 0) {
                fVarW = ((f) fVarW).f21474h;
            }
        } else {
            fVarW = ((f) this.f21454g).f21474h;
        }
        if (fVarW == this.f21454g || !this.f21453f.c(fVarW.y())) {
            return null;
        }
        return fVarW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void H(f<T> fVar, f<T> fVar2) {
        ((f) fVar).f21475i = fVar2;
        ((f) fVar2).f21474h = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void I(f<T> fVar, f<T> fVar2, f<T> fVar3) {
        H(fVar, fVar2);
        H(fVar2, fVar3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public hd.a<E> J(f<E> fVar) {
        return new a(fVar);
    }

    @s1.c
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        se.a(e0.class, "comparator").b(this, comparator);
        se.a(yj.class, "range").b(this, k6.a(comparator));
        se.a(yj.class, "rootReference").b(this, new g(null));
        f fVar = new f(null, 1);
        se.a(yj.class, "header").b(this, fVar);
        H(fVar, fVar);
        se.f(this, objectInputStream);
    }

    private long u(e eVar, f<E> fVar) {
        long jB;
        long jU;
        if (fVar == null) {
            return 0L;
        }
        int iCompare = comparator().compare(this.f21453f.i(), ((f) fVar).f21467a);
        if (iCompare > 0) {
            return u(eVar, ((f) fVar).f21473g);
        }
        if (iCompare == 0) {
            int i7 = d.f21463a[this.f21453f.h().ordinal()];
            if (i7 != 1) {
                if (i7 == 2) {
                    return eVar.b(((f) fVar).f21473g);
                }
                throw new AssertionError();
            }
            jB = eVar.a(fVar);
            jU = eVar.b(((f) fVar).f21473g);
        } else {
            jB = eVar.b(((f) fVar).f21473g) + ((long) eVar.a(fVar));
            jU = u(eVar, ((f) fVar).f21472f);
        }
        return jB + jU;
    }

    private long v(e eVar, f<E> fVar) {
        long jB;
        long jV;
        if (fVar == null) {
            return 0L;
        }
        int iCompare = comparator().compare(this.f21453f.g(), ((f) fVar).f21467a);
        if (iCompare < 0) {
            return v(eVar, ((f) fVar).f21472f);
        }
        if (iCompare == 0) {
            int i7 = d.f21463a[this.f21453f.f().ordinal()];
            if (i7 != 1) {
                if (i7 == 2) {
                    return eVar.b(((f) fVar).f21472f);
                }
                throw new AssertionError();
            }
            jB = eVar.a(fVar);
            jV = eVar.b(((f) fVar).f21472f);
        } else {
            jB = eVar.b(((f) fVar).f21472f) + ((long) eVar.a(fVar));
            jV = v(eVar, ((f) fVar).f21473g);
        }
        return jB + jV;
    }

    private long w(e eVar) {
        f<E> fVarC = this.f21452e.c();
        long jB = eVar.b(fVarC);
        if (this.f21453f.j()) {
            jB -= v(eVar, fVarC);
        }
        return this.f21453f.k() ? jB - u(eVar, fVarC) : jB;
    }

    @s1.c
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(e().comparator());
        se.k(this, objectOutputStream);
    }

    public static <E extends Comparable> yj<E> x() {
        return new yj<>(td.A());
    }

    public static <E extends Comparable> yj<E> z(Iterable<? extends E> iterable) {
        yj<E> yjVarX = x();
        ma.a(yjVarX, iterable);
        return yjVarX;
    }

    @Override // com.google.common.collect.e0, com.google.common.collect.wf
    public /* bridge */ /* synthetic */ wf C() {
        return super.C();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    @u1.a
    public boolean E(E e8, int i7, int i8) {
        f2.b(i8, "newCount");
        f2.b(i7, "oldCount");
        com.google.common.base.e0.d(this.f21453f.c(e8));
        f<E> fVarC = this.f21452e.c();
        if (fVarC != null) {
            int[] iArr = new int[1];
            this.f21452e.a(fVarC, fVarC.J(comparator(), e8, i7, i8, iArr));
            return iArr[0] == i7;
        }
        if (i7 != 0) {
            return false;
        }
        if (i8 > 0) {
            add(e8, i8);
        }
        return true;
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    @u1.a
    public int add(E e8, int i7) {
        f2.b(i7, "occurrences");
        if (i7 == 0) {
            return l0(e8);
        }
        com.google.common.base.e0.d(this.f21453f.c(e8));
        f<E> fVarC = this.f21452e.c();
        if (fVarC != null) {
            int[] iArr = new int[1];
            this.f21452e.a(fVarC, fVarC.p(comparator(), e8, i7, iArr));
            return iArr[0];
        }
        comparator().compare(e8, e8);
        f<E> fVar = new f<>(e8, i7);
        f<E> fVar2 = this.f21454g;
        I(fVar2, fVar, fVar2);
        this.f21452e.a(fVarC, fVar);
        return 0;
    }

    @Override // com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.f21453f.j() || this.f21453f.k()) {
            ua.h(g());
            return;
        }
        f<E> fVar = ((f) this.f21454g).f21475i;
        while (true) {
            f<E> fVar2 = this.f21454g;
            if (fVar == fVar2) {
                H(fVar2, fVar2);
                this.f21452e.b();
                return;
            }
            f<E> fVar3 = ((f) fVar).f21475i;
            ((f) fVar).f21468b = 0;
            ((f) fVar).f21472f = null;
            ((f) fVar).f21473g = null;
            ((f) fVar).f21474h = null;
            ((f) fVar).f21475i = null;
            fVar = fVar3;
        }
    }

    @Override // com.google.common.collect.e0, com.google.common.collect.wf, com.google.common.collect.qf
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.y
    int d() {
        return com.google.common.primitives.c0.x(w(e.f21465b));
    }

    @Override // com.google.common.collect.e0, com.google.common.collect.y, com.google.common.collect.hd
    public /* bridge */ /* synthetic */ NavigableSet e() {
        return super.e();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.y
    Iterator<E> f() {
        return md.j(g());
    }

    @Override // com.google.common.collect.e0, com.google.common.collect.wf
    public /* bridge */ /* synthetic */ hd.a firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.y
    Iterator<hd.a<E>> g() {
        return new b();
    }

    @Override // com.google.common.collect.wf
    public wf<E> g0(E e8, s0 s0Var) {
        return new yj(this.f21452e, this.f21453f.l(k6.r(comparator(), e8, s0Var)), this.f21454g);
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    public void h0(ObjIntConsumer<? super E> objIntConsumer) {
        com.google.common.base.e0.E(objIntConsumer);
        for (f<E> fVarD = D(); fVarD != this.f21454g && fVarD != null && !this.f21453f.p(fVarD.y()); fVarD = ((f) fVarD).f21475i) {
            objIntConsumer.accept(fVarD.y(), fVarD.x());
        }
    }

    @Override // com.google.common.collect.y, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.hd
    public Iterator<E> iterator() {
        return md.p(this);
    }

    @Override // com.google.common.collect.e0
    Iterator<hd.a<E>> k() {
        return new c();
    }

    @Override // com.google.common.collect.hd
    public int l0(Object obj) {
        try {
            f<E> fVarC = this.f21452e.c();
            if (this.f21453f.c(obj) && fVarC != null) {
                return fVarC.u(comparator(), obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.e0, com.google.common.collect.wf
    public /* bridge */ /* synthetic */ hd.a lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.wf
    public wf<E> o0(E e8, s0 s0Var) {
        return new yj(this.f21452e, this.f21453f.l(k6.d(comparator(), e8, s0Var)), this.f21454g);
    }

    @Override // com.google.common.collect.e0, com.google.common.collect.wf
    public /* bridge */ /* synthetic */ hd.a pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.e0, com.google.common.collect.wf
    public /* bridge */ /* synthetic */ hd.a pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    @u1.a
    public int remove(Object obj, int i7) {
        f2.b(i7, "occurrences");
        if (i7 == 0) {
            return l0(obj);
        }
        f<E> fVarC = this.f21452e.c();
        int[] iArr = new int[1];
        try {
            if (this.f21453f.c(obj) && fVarC != null) {
                this.f21452e.a(fVarC, fVarC.E(comparator(), obj, i7, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.y, com.google.common.collect.hd
    @u1.a
    public int setCount(E e8, int i7) {
        f2.b(i7, "count");
        if (!this.f21453f.c(e8)) {
            com.google.common.base.e0.d(i7 == 0);
            return 0;
        }
        f<E> fVarC = this.f21452e.c();
        if (fVarC == null) {
            if (i7 > 0) {
                add(e8, i7);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.f21452e.a(fVarC, fVarC.K(comparator(), e8, i7, iArr));
        return iArr[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
    public int size() {
        return com.google.common.primitives.c0.x(w(e.f21464a));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.e0, com.google.common.collect.wf
    public /* bridge */ /* synthetic */ wf v0(Object obj, s0 s0Var, Object obj2, s0 s0Var2) {
        return super.v0(obj, s0Var, obj2, s0Var2);
    }

    yj(Comparator<? super E> comparator) {
        super(comparator);
        this.f21453f = k6.a(comparator);
        f<E> fVar = new f<>(null, 1);
        this.f21454g = fVar;
        H(fVar, fVar);
        this.f21452e = new g<>(null);
    }
}
