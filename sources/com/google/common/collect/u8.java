package com.google.common.collect;

import java.io.Serializable;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.Collector;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
public abstract class u8<E> extends x6<E> implements Set<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f21171d = 1297;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f21172e = 1073741824;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final double f21173f = 0.7d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f21174g = 751619276;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final double f21175h = 0.001d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int f21176i = 12;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @y1.h
    @v1.b
    private transient d7<E> f21177c;

    public static class a<E> extends x6.a<E> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private f<E> f21178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f21179c;

        public a() {
            this(4);
        }

        @Override // com.google.common.collect.x6.a
        @u1.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public a<E> a(E e8) {
            com.google.common.base.e0.E(e8);
            n();
            this.f21178b = this.f21178b.a(e8);
            return this;
        }

        @Override // com.google.common.collect.x6.a
        @u1.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public a<E> b(E... eArr) {
            super.b(eArr);
            return this;
        }

        @Override // com.google.common.collect.x6.a
        @u1.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public a<E> c(Iterable<? extends E> iterable) {
            super.c(iterable);
            return this;
        }

        @Override // com.google.common.collect.x6.a
        @u1.a
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public a<E> d(Iterator<? extends E> it) {
            super.d(it);
            return this;
        }

        @Override // com.google.common.collect.x6.a
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public u8<E> e() {
            this.f21179c = true;
            f<E> fVarG = this.f21178b.g();
            this.f21178b = fVarG;
            return fVarG.c();
        }

        a<E> l(a<E> aVar) {
            n();
            this.f21178b = this.f21178b.d(aVar.f21178b);
            return this;
        }

        void m() {
            this.f21178b = this.f21178b.e();
        }

        final void n() {
            if (this.f21179c) {
                m();
                this.f21179c = false;
            }
        }

        @s1.d
        void o() {
            this.f21178b = new c(this.f21178b);
        }

        a(int i7) {
            this.f21178b = new d(i7);
        }

        a(boolean z7) {
            this.f21178b = null;
        }
    }

    static abstract class b<E> extends u8<E> {

        class a extends t6<E> {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.t6
            /* JADX INFO: renamed from: X, reason: merged with bridge method [inline-methods] */
            public b<E> W() {
                return b.this;
            }

            @Override // java.util.List
            public E get(int i7) {
                return (E) b.this.get(i7);
            }
        }

        b() {
        }

        @Override // com.google.common.collect.x6
        int b(Object[] objArr, int i7) {
            return a().b(objArr, i7);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> consumer) {
            com.google.common.base.e0.E(consumer);
            int size = size();
            for (int i7 = 0; i7 < size; i7++) {
                consumer.accept(get(i7));
            }
        }

        abstract E get(int i7);

        @Override // com.google.common.collect.u8, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: j */
        public ck<E> iterator() {
            return a().iterator();
        }

        @Override // com.google.common.collect.x6, java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<E> spliterator() {
            return q2.c(size(), u8.f21171d, new IntFunction() { // from class: com.google.common.collect.v8
                @Override // java.util.function.IntFunction
                public final Object apply(int i7) {
                    return this.f21284a.get(i7);
                }
            });
        }

        @Override // com.google.common.collect.u8
        d7<E> v() {
            return new a();
        }
    }

    private static final class c<E> extends f<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Set<Object> f21181c;

        c(f<E> fVar) {
            super(fVar);
            this.f21181c = af.y(this.f21189b);
            for (int i7 = 0; i7 < this.f21189b; i7++) {
                this.f21181c.add(this.f21188a[i7]);
            }
        }

        @Override // com.google.common.collect.u8.f
        f<E> a(E e8) {
            com.google.common.base.e0.E(e8);
            if (this.f21181c.add(e8)) {
                b(e8);
            }
            return this;
        }

        @Override // com.google.common.collect.u8.f
        u8<E> c() {
            int i7 = this.f21189b;
            if (i7 != 0) {
                return i7 != 1 ? new ab(this.f21181c, d7.l(this.f21188a, this.f21189b)) : u8.B(this.f21188a[0]);
            }
            return u8.A();
        }

        @Override // com.google.common.collect.u8.f
        f<E> e() {
            return new c(this);
        }
    }

    private static class e implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f21186b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object[] f21187a;

        e(Object[] objArr) {
            this.f21187a = objArr;
        }

        Object readResolve() {
            return u8.t(this.f21187a);
        }
    }

    u8() {
    }

    public static <E> u8<E> A() {
        return ke.f20555n;
    }

    public static <E> u8<E> B(E e8) {
        return new of(e8);
    }

    public static <E> u8<E> D(E e8, E e9) {
        return n(2, e8, e9);
    }

    public static <E> u8<E> F(E e8, E e9, E e10) {
        return n(3, e8, e9, e10);
    }

    public static <E> u8<E> H(E e8, E e9, E e10, E e11) {
        return n(4, e8, e9, e10, e11);
    }

    public static <E> u8<E> I(E e8, E e9, E e10, E e11, E e12) {
        return n(5, e8, e9, e10, e11, e12);
    }

    @SafeVarargs
    public static <E> u8<E> J(E e8, E e9, E e10, E e11, E e12, E e13, E... eArr) {
        com.google.common.base.e0.e(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e8;
        objArr[1] = e9;
        objArr[2] = e10;
        objArr[3] = e11;
        objArr[4] = e12;
        objArr[5] = e13;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return n(length, objArr);
    }

    static Object[] K(int i7, Object[] objArr, int i8) {
        int i9;
        Object[] objArr2 = new Object[i7];
        int i10 = i7 - 1;
        for (int i11 = 0; i11 < i8; i11++) {
            Object obj = objArr[i11];
            int iC = s6.c(obj.hashCode());
            while (true) {
                i9 = iC & i10;
                if (objArr2[i9] == null) {
                    break;
                }
                iC++;
            }
            objArr2[i9] = obj;
        }
        return objArr2;
    }

    @s1.a
    public static <E> Collector<E, ?, u8<E>> L() {
        return e2.r();
    }

    public static <E> a<E> k() {
        return new a<>();
    }

    @s1.a
    public static <E> a<E> l(int i7) {
        f2.b(i7, "expectedSize");
        return new a<>(i7);
    }

    @s1.d
    static int m(int i7) {
        int iMax = Math.max(i7, 2);
        if (iMax >= f21174g) {
            com.google.common.base.e0.e(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * f21173f < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.google.common.collect.u8$f] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    private static <E> u8<E> n(int i7, Object... objArr) {
        ?? r7;
        if (i7 == 0) {
            return A();
        }
        int i8 = 0;
        if (i7 == 1) {
            return B(objArr[0]);
        }
        d dVar = new d(4);
        while (i8 < i7) {
            r7 = dVar;
            Object objA = r7.a(com.google.common.base.e0.E(objArr[i8]));
            i8++;
            r7 = objA;
        }
        r7 = dVar;
        return r7.g().c();
    }

    public static <E> u8<E> o(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? p((Collection) iterable) : r(iterable.iterator());
    }

    public static <E> u8<E> p(Collection<? extends E> collection) {
        if ((collection instanceof u8) && !(collection instanceof SortedSet)) {
            u8<E> u8Var = (u8) collection;
            if (!u8Var.h()) {
                return u8Var;
            }
        } else if (collection instanceof EnumSet) {
            return u((EnumSet) collection);
        }
        Object[] array = collection.toArray();
        return n(array.length, array);
    }

    public static <E> u8<E> r(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return A();
        }
        E next = it.next();
        return !it.hasNext() ? B(next) : new a().a(next).d(it).e();
    }

    public static <E> u8<E> t(E[] eArr) {
        int length = eArr.length;
        if (length != 0) {
            return length != 1 ? n(eArr.length, (Object[]) eArr.clone()) : B(eArr[0]);
        }
        return A();
    }

    private static u8 u(EnumSet enumSet) {
        return b7.M(EnumSet.copyOf(enumSet));
    }

    static boolean w(Object[] objArr) {
        int iZ = z(objArr.length);
        int i7 = 0;
        while (i7 < objArr.length && objArr[i7] != null) {
            i7++;
            if (i7 > iZ) {
                return true;
            }
        }
        int length = objArr.length - 1;
        while (length > i7 && objArr[length] != null) {
            if (((objArr.length - 1) - length) + i7 > iZ) {
                return true;
            }
            length--;
        }
        int i8 = i7 + 1;
        while (i8 < length) {
            int i9 = 0;
            while (i8 < length && objArr[i8] != null) {
                i9++;
                if (i9 > iZ) {
                    return true;
                }
                i8++;
            }
            i8++;
        }
        return false;
    }

    static int z(int i7) {
        return com.google.common.math.d.p(i7, RoundingMode.UNNECESSARY) * 12;
    }

    @Override // com.google.common.collect.x6
    public d7<E> a() {
        d7<E> d7Var = this.f21177c;
        if (d7Var != null) {
            return d7Var;
        }
        d7<E> d7VarV = v();
        this.f21177c = d7VarV;
        return d7VarV;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof u8) && x() && ((u8) obj).x() && hashCode() != obj.hashCode()) {
            return false;
        }
        return af.g(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return af.k(this);
    }

    @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public abstract ck<E> iterator();

    d7<E> v() {
        return new de(this, toArray());
    }

    @Override // com.google.common.collect.x6
    Object writeReplace() {
        return new e(toArray());
    }

    boolean x() {
        return false;
    }

    private static abstract class f<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        E[] f21188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f21189b;

        f(int i7) {
            this.f21188a = (E[]) new Object[i7];
            this.f21189b = 0;
        }

        private void f(int i7) {
            E[] eArr = this.f21188a;
            if (i7 > eArr.length) {
                this.f21188a = (E[]) Arrays.copyOf(this.f21188a, x6.a.f(eArr.length, i7));
            }
        }

        abstract f<E> a(E e8);

        final void b(E e8) {
            f(this.f21189b + 1);
            E[] eArr = this.f21188a;
            int i7 = this.f21189b;
            this.f21189b = i7 + 1;
            eArr[i7] = e8;
        }

        abstract u8<E> c();

        final f<E> d(f<E> fVar) {
            f<E> fVarA = this;
            for (int i7 = 0; i7 < fVar.f21189b; i7++) {
                fVarA = fVarA.a(fVar.f21188a[i7]);
            }
            return fVarA;
        }

        abstract f<E> e();

        f<E> g() {
            return this;
        }

        f(f<E> fVar) {
            E[] eArr = fVar.f21188a;
            this.f21188a = (E[]) Arrays.copyOf(eArr, eArr.length);
            this.f21189b = fVar.f21189b;
        }
    }

    private static final class d<E> extends f<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object[] f21182c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f21183d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f21184e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f21185f;

        d(int i7) {
            super(i7);
            int iM = u8.m(i7);
            this.f21182c = new Object[iM];
            this.f21183d = u8.z(iM);
            this.f21184e = (int) (((double) iM) * u8.f21173f);
        }

        @Override // com.google.common.collect.u8.f
        f<E> a(E e8) {
            com.google.common.base.e0.E(e8);
            int iHashCode = e8.hashCode();
            int iC = s6.c(iHashCode);
            int length = this.f21182c.length - 1;
            for (int i7 = iC; i7 - iC < this.f21183d; i7++) {
                int i8 = i7 & length;
                Object obj = this.f21182c[i8];
                if (obj == null) {
                    b(e8);
                    this.f21182c[i8] = e8;
                    this.f21185f += iHashCode;
                    h(this.f21189b);
                    return this;
                }
                if (obj.equals(e8)) {
                    return this;
                }
            }
            return new c(this).a(e8);
        }

        @Override // com.google.common.collect.u8.f
        u8<E> c() {
            int i7 = this.f21189b;
            if (i7 == 0) {
                return u8.A();
            }
            if (i7 == 1) {
                return u8.B(this.f21188a[0]);
            }
            Object[] objArrCopyOf = this.f21188a;
            if (i7 != objArrCopyOf.length) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i7);
            }
            int i8 = this.f21185f;
            Object[] objArr = this.f21182c;
            return new ke(objArrCopyOf, i8, objArr, objArr.length - 1);
        }

        @Override // com.google.common.collect.u8.f
        f<E> e() {
            return new d(this);
        }

        @Override // com.google.common.collect.u8.f
        f<E> g() {
            int iM = u8.m(this.f21189b);
            if (iM * 2 < this.f21182c.length) {
                this.f21182c = u8.K(iM, this.f21188a, this.f21189b);
            }
            return u8.w(this.f21182c) ? new c(this) : this;
        }

        void h(int i7) {
            if (i7 > this.f21184e) {
                Object[] objArr = this.f21182c;
                if (objArr.length < 1073741824) {
                    int length = objArr.length * 2;
                    this.f21182c = u8.K(length, this.f21188a, this.f21189b);
                    this.f21183d = u8.z(length);
                    this.f21184e = (int) (((double) length) * u8.f21173f);
                }
            }
        }

        d(d<E> dVar) {
            super(dVar);
            Object[] objArr = dVar.f21182c;
            this.f21182c = Arrays.copyOf(objArr, objArr.length);
            this.f21183d = dVar.f21183d;
            this.f21184e = dVar.f21184e;
            this.f21185f = dVar.f21185f;
        }
    }
}
