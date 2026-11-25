package com.google.common.collect;

import java.lang.reflect.Array;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@u1.j(containerOf = {"R", "C", "V"})
@s1.b
final class l4<R, C, V> extends ne<R, C, V> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v7<R, Integer> f20566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final v7<C, Integer> f20567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final v7<R, v7<C, V>> f20568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final v7<C, v7<R, V>> f20569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int[] f20570g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int[] f20571h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final V[][] f20572i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int[] f20573j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int[] f20574k;

    private final class b extends d<R, V> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f20575g;

        b(int i7) {
            super(l4.this.f20571h[i7]);
            this.f20575g = i7;
        }

        @Override // com.google.common.collect.l4.d
        V N(int i7) {
            return (V) l4.this.f20572i[i7][this.f20575g];
        }

        @Override // com.google.common.collect.l4.d
        v7<R, Integer> O() {
            return l4.this.f20566c;
        }

        @Override // com.google.common.collect.v7
        boolean r() {
            return true;
        }
    }

    private final class c extends d<C, v7<R, V>> {
        @Override // com.google.common.collect.l4.d
        v7<C, Integer> O() {
            return l4.this.f20567d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.l4.d
        /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
        public v7<R, V> N(int i7) {
            return new b(i7);
        }

        @Override // com.google.common.collect.v7
        boolean r() {
            return false;
        }

        private c() {
            super(l4.this.f20571h.length);
        }
    }

    private static abstract class d<K, V> extends v7.c<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f20578f;

        class a extends com.google.common.collect.e<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f20579c = -1;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final int f20580d;

            a() {
                this.f20580d = d.this.O().size();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.e
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> a() {
                int i7 = this.f20579c;
                while (true) {
                    this.f20579c = i7 + 1;
                    int i8 = this.f20579c;
                    if (i8 >= this.f20580d) {
                        return b();
                    }
                    Object objN = d.this.N(i8);
                    if (objN != null) {
                        return wb.T(d.this.M(this.f20579c), objN);
                    }
                    i7 = this.f20579c;
                }
            }
        }

        d(int i7) {
            this.f20578f = i7;
        }

        private boolean isFull() {
            return this.f20578f == O().size();
        }

        @Override // com.google.common.collect.v7.c
        ck<Map.Entry<K, V>> K() {
            return new a();
        }

        K M(int i7) {
            return O().keySet().a().get(i7);
        }

        abstract V N(int i7);

        abstract v7<K, Integer> O();

        @Override // com.google.common.collect.v7, java.util.Map
        public V get(Object obj) {
            Integer num = O().get(obj);
            if (num == null) {
                return null;
            }
            return N(num.intValue());
        }

        @Override // com.google.common.collect.v7.c, com.google.common.collect.v7
        u8<K> l() {
            return isFull() ? O().keySet() : super.l();
        }

        @Override // java.util.Map
        public int size() {
            return this.f20578f;
        }
    }

    private final class e extends d<C, V> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f20582g;

        e(int i7) {
            super(l4.this.f20570g[i7]);
            this.f20582g = i7;
        }

        @Override // com.google.common.collect.l4.d
        V N(int i7) {
            return (V) l4.this.f20572i[this.f20582g][i7];
        }

        @Override // com.google.common.collect.l4.d
        v7<C, Integer> O() {
            return l4.this.f20567d;
        }

        @Override // com.google.common.collect.v7
        boolean r() {
            return true;
        }
    }

    private final class f extends d<R, v7<C, V>> {
        @Override // com.google.common.collect.l4.d
        v7<R, Integer> O() {
            return l4.this.f20566c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.l4.d
        /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
        public v7<C, V> N(int i7) {
            return new e(i7);
        }

        @Override // com.google.common.collect.v7
        boolean r() {
            return false;
        }

        private f() {
            super(l4.this.f20570g.length);
        }
    }

    l4(d7<oj.a<R, C, V>> d7Var, u8<R> u8Var, u8<C> u8Var2) {
        this.f20572i = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, u8Var.size(), u8Var2.size()));
        v7<R, Integer> v7VarV = wb.V(u8Var);
        this.f20566c = v7VarV;
        v7<C, Integer> v7VarV2 = wb.V(u8Var2);
        this.f20567d = v7VarV2;
        this.f20570g = new int[v7VarV.size()];
        this.f20571h = new int[v7VarV2.size()];
        int[] iArr = new int[d7Var.size()];
        int[] iArr2 = new int[d7Var.size()];
        for (int i7 = 0; i7 < d7Var.size(); i7++) {
            oj.a<R, C, V> aVar = d7Var.get(i7);
            R rB = aVar.b();
            C cA = aVar.a();
            int iIntValue = this.f20566c.get(rB).intValue();
            int iIntValue2 = this.f20567d.get(cA).intValue();
            com.google.common.base.e0.y(this.f20572i[iIntValue][iIntValue2] == null, "duplicate key: (%s, %s)", rB, cA);
            this.f20572i[iIntValue][iIntValue2] = aVar.getValue();
            int[] iArr3 = this.f20570g;
            iArr3[iIntValue] = iArr3[iIntValue] + 1;
            int[] iArr4 = this.f20571h;
            iArr4[iIntValue2] = iArr4[iIntValue2] + 1;
            iArr[i7] = iIntValue;
            iArr2[i7] = iIntValue2;
        }
        this.f20573j = iArr;
        this.f20574k = iArr2;
        this.f20568e = new f();
        this.f20569f = new c();
    }

    @Override // com.google.common.collect.ca, com.google.common.collect.oj
    /* JADX INFO: renamed from: D */
    public v7<C, Map<R, V>> S() {
        return v7.g(this.f20569f);
    }

    @Override // com.google.common.collect.ca
    ca.e I() {
        return ca.e.a(this, this.f20573j, this.f20574k);
    }

    @Override // com.google.common.collect.ca, com.google.common.collect.oj
    /* JADX INFO: renamed from: d0 */
    public v7<R, Map<C, V>> f() {
        return v7.g(this.f20568e);
    }

    @Override // com.google.common.collect.ca, com.google.common.collect.h0, com.google.common.collect.oj
    public V k(Object obj, Object obj2) {
        Integer num = this.f20566c.get(obj);
        Integer num2 = this.f20567d.get(obj2);
        if (num == null || num2 == null) {
            return null;
        }
        return this.f20572i[num.intValue()][num2.intValue()];
    }

    @Override // com.google.common.collect.ne
    oj.a<R, C, V> l0(int i7) {
        int i8 = this.f20573j[i7];
        int i9 = this.f20574k[i7];
        return ca.z(g().a().get(i8), L().a().get(i9), this.f20572i[i8][i9]);
    }

    @Override // com.google.common.collect.ne
    V m0(int i7) {
        return this.f20572i[this.f20573j[i7]][this.f20574k[i7]];
    }

    @Override // com.google.common.collect.oj
    public int size() {
        return this.f20573j.length;
    }
}
