package com.google.common.collect;

import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
class je<E> extends p8<E> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final p8<Object> f20494j = T(d7.x());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @s1.d
    static final double f20495k = 1.0d;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @s1.d
    static final double f20496l = 0.001d;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @s1.d
    static final int f20497m = 9;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final transient md.k<E>[] f20498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient md.k<E>[] f20499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient int f20500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient int f20501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @v1.b
    private transient u8<E> f20502i;

    private static final class a<E> extends md.k<E> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final md.k<E> f20503d;

        a(E e8, int i7, md.k<E> kVar) {
            super(e8, i7);
            this.f20503d = kVar;
        }

        @Override // com.google.common.collect.md.k
        public md.k<E> a() {
            return this.f20503d;
        }
    }

    private je(md.k<E>[] kVarArr, md.k<E>[] kVarArr2, int i7, int i8, u8<E> u8Var) {
        this.f20498e = kVarArr;
        this.f20499f = kVarArr2;
        this.f20500g = i7;
        this.f20501h = i8;
        this.f20502i = u8Var;
    }

    static <E> p8<E> T(Collection<? extends hd.a<? extends E>> collection) {
        int size = collection.size();
        md.k[] kVarArr = new md.k[size];
        if (size == 0) {
            return new je(kVarArr, null, 0, 0, u8.A());
        }
        int iA = s6.a(size, 1.0d);
        int i7 = iA - 1;
        md.k[] kVarArr2 = new md.k[iA];
        long j7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (hd.a<? extends E> aVar : collection) {
            Object objE = com.google.common.base.e0.E(aVar.getElement());
            int count = aVar.getCount();
            int iHashCode = objE.hashCode();
            int iC = s6.c(iHashCode) & i7;
            md.k kVar = kVarArr2[iC];
            md.k kVar2 = kVar == null ? (aVar instanceof md.k) && !(aVar instanceof a) ? (md.k) aVar : new md.k(objE, count) : new a(objE, count, kVar);
            i8 += iHashCode ^ count;
            kVarArr[i9] = kVar2;
            kVarArr2[iC] = kVar2;
            j7 += (long) count;
            i9++;
        }
        return U(kVarArr2) ? za.T(d7.k(kVarArr)) : new je(kVarArr, kVarArr2, com.google.common.primitives.c0.x(j7), i8, null);
    }

    private static boolean U(md.k<?>[] kVarArr) {
        for (md.k<?> kVarA : kVarArr) {
            int i7 = 0;
            for (; kVarA != null; kVarA = kVarA.a()) {
                i7++;
                if (i7 > 9) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.p8
    hd.a<E> A(int i7) {
        return this.f20498e[i7];
    }

    @Override // com.google.common.collect.x6
    boolean h() {
        return false;
    }

    @Override // com.google.common.collect.p8, java.util.Collection, com.google.common.collect.hd
    public int hashCode() {
        return this.f20501h;
    }

    @Override // com.google.common.collect.hd
    public int l0(Object obj) {
        md.k<E>[] kVarArr = this.f20499f;
        if (obj != null && kVarArr != null) {
            for (md.k<E> kVarA = kVarArr[s6.d(obj) & (kVarArr.length - 1)]; kVarA != null; kVarA = kVarA.a()) {
                if (com.google.common.base.y.a(obj, kVarA.getElement())) {
                    return kVarA.getCount();
                }
            }
        }
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.hd
    public int size() {
        return this.f20500g;
    }

    @Override // com.google.common.collect.p8, com.google.common.collect.hd
    /* JADX INFO: renamed from: x */
    public u8<E> e() {
        u8<E> u8Var = this.f20502i;
        if (u8Var != null) {
            return u8Var;
        }
        p8.c cVar = new p8.c(Arrays.asList(this.f20498e), this);
        this.f20502i = cVar;
        return cVar;
    }
}
