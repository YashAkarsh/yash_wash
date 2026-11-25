package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class h<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Comparator<Comparable> f23175i = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final /* synthetic */ boolean f23176j = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Comparator<? super K> f23177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    g<K, V>[] f23178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final g<K, V> f23179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f23180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f23181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f23182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private h<K, V>.d f23183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private h<K, V>.e f23184h;

    class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    static final class b<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private g<K, V> f23185a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f23186b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f23187c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f23188d;

        b() {
        }

        void a(g<K, V> gVar) {
            gVar.f23200c = null;
            gVar.f23198a = null;
            gVar.f23199b = null;
            gVar.f23206i = 1;
            int i7 = this.f23186b;
            if (i7 > 0) {
                int i8 = this.f23188d;
                if ((i8 & 1) == 0) {
                    this.f23188d = i8 + 1;
                    this.f23186b = i7 - 1;
                    this.f23187c++;
                }
            }
            gVar.f23198a = this.f23185a;
            this.f23185a = gVar;
            int i9 = this.f23188d + 1;
            this.f23188d = i9;
            int i10 = this.f23186b;
            if (i10 > 0 && (i9 & 1) == 0) {
                this.f23188d = i9 + 1;
                this.f23186b = i10 - 1;
                this.f23187c++;
            }
            int i11 = 4;
            while (true) {
                int i12 = i11 - 1;
                if ((this.f23188d & i12) != i12) {
                    return;
                }
                int i13 = this.f23187c;
                if (i13 == 0) {
                    g<K, V> gVar2 = this.f23185a;
                    g<K, V> gVar3 = gVar2.f23198a;
                    g<K, V> gVar4 = gVar3.f23198a;
                    gVar3.f23198a = gVar4.f23198a;
                    this.f23185a = gVar3;
                    gVar3.f23199b = gVar4;
                    gVar3.f23200c = gVar2;
                    gVar3.f23206i = gVar2.f23206i + 1;
                    gVar4.f23198a = gVar3;
                    gVar2.f23198a = gVar3;
                } else if (i13 == 1) {
                    g<K, V> gVar5 = this.f23185a;
                    g<K, V> gVar6 = gVar5.f23198a;
                    this.f23185a = gVar6;
                    gVar6.f23200c = gVar5;
                    gVar6.f23206i = gVar5.f23206i + 1;
                    gVar5.f23198a = gVar6;
                    this.f23187c = 0;
                } else if (i13 == 2) {
                    this.f23187c = 0;
                }
                i11 *= 2;
            }
        }

        void b(int i7) {
            this.f23186b = ((Integer.highestOneBit(i7) * 2) - 1) - i7;
            this.f23188d = 0;
            this.f23187c = 0;
            this.f23185a = null;
        }

        g<K, V> c() {
            g<K, V> gVar = this.f23185a;
            if (gVar.f23198a == null) {
                return gVar;
            }
            throw new IllegalStateException();
        }
    }

    static class c<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private g<K, V> f23189a;

        c() {
        }

        public g<K, V> a() {
            g<K, V> gVar = this.f23189a;
            if (gVar == null) {
                return null;
            }
            g<K, V> gVar2 = gVar.f23198a;
            gVar.f23198a = null;
            g<K, V> gVar3 = gVar.f23200c;
            while (true) {
                g<K, V> gVar4 = gVar2;
                gVar2 = gVar3;
                if (gVar2 == null) {
                    this.f23189a = gVar4;
                    return gVar;
                }
                gVar2.f23198a = gVar4;
                gVar3 = gVar2.f23199b;
            }
        }

        void b(g<K, V> gVar) {
            g<K, V> gVar2 = null;
            while (gVar != null) {
                gVar.f23198a = gVar2;
                gVar2 = gVar;
                gVar = gVar.f23199b;
            }
            this.f23189a = gVar2;
        }
    }

    final class d extends AbstractSet<Map.Entry<K, V>> {

        class a extends h<K, V>.f<Map.Entry<K, V>> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && h.this.e((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            g<K, V> gVarE;
            if (!(obj instanceof Map.Entry) || (gVarE = h.this.e((Map.Entry) obj)) == null) {
                return false;
            }
            h.this.i(gVarE, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f23180d;
        }
    }

    final class e extends AbstractSet<K> {

        class a extends h<K, V>.f<K> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f23203f;
            }
        }

        e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.k(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f23180d;
        }
    }

    private abstract class f<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        g<K, V> f23194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        g<K, V> f23195b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f23196c;

        f() {
            this.f23194a = h.this.f23179c.f23201d;
            this.f23196c = h.this.f23181e;
        }

        final g<K, V> a() {
            g<K, V> gVar = this.f23194a;
            h hVar = h.this;
            if (gVar == hVar.f23179c) {
                throw new NoSuchElementException();
            }
            if (hVar.f23181e != this.f23196c) {
                throw new ConcurrentModificationException();
            }
            this.f23194a = gVar.f23201d;
            this.f23195b = gVar;
            return gVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f23194a != h.this.f23179c;
        }

        @Override // java.util.Iterator
        public final void remove() {
            g<K, V> gVar = this.f23195b;
            if (gVar == null) {
                throw new IllegalStateException();
            }
            h.this.i(gVar, true);
            this.f23195b = null;
            this.f23196c = h.this.f23181e;
        }
    }

    public h() {
        this(f23175i);
    }

    private void a() {
        g<K, V>[] gVarArrB = b(this.f23178b);
        this.f23178b = gVarArrB;
        this.f23182f = (gVarArrB.length / 2) + (gVarArrB.length / 4);
    }

    static <K, V> g<K, V>[] b(g<K, V>[] gVarArr) {
        int length = gVarArr.length;
        g<K, V>[] gVarArr2 = new g[length * 2];
        c cVar = new c();
        b bVar = new b();
        b bVar2 = new b();
        for (int i7 = 0; i7 < length; i7++) {
            g<K, V> gVar = gVarArr[i7];
            if (gVar != null) {
                cVar.b(gVar);
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    g<K, V> gVarA = cVar.a();
                    if (gVarA == null) {
                        break;
                    }
                    if ((gVarA.f23204g & length) == 0) {
                        i8++;
                    } else {
                        i9++;
                    }
                }
                bVar.b(i8);
                bVar2.b(i9);
                cVar.b(gVar);
                while (true) {
                    g<K, V> gVarA2 = cVar.a();
                    if (gVarA2 == null) {
                        break;
                    }
                    if ((gVarA2.f23204g & length) == 0) {
                        bVar.a(gVarA2);
                    } else {
                        bVar2.a(gVarA2);
                    }
                }
                gVarArr2[i7] = i8 > 0 ? bVar.c() : null;
                gVarArr2[i7 + length] = i9 > 0 ? bVar2.c() : null;
            }
        }
        return gVarArr2;
    }

    private boolean c(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void g(g<K, V> gVar, boolean z7) {
        while (gVar != null) {
            g<K, V> gVar2 = gVar.f23199b;
            g<K, V> gVar3 = gVar.f23200c;
            int i7 = gVar2 != null ? gVar2.f23206i : 0;
            int i8 = gVar3 != null ? gVar3.f23206i : 0;
            int i9 = i7 - i8;
            if (i9 == -2) {
                g<K, V> gVar4 = gVar3.f23199b;
                g<K, V> gVar5 = gVar3.f23200c;
                int i10 = (gVar4 != null ? gVar4.f23206i : 0) - (gVar5 != null ? gVar5.f23206i : 0);
                if (i10 == -1 || (i10 == 0 && !z7)) {
                    m(gVar);
                } else {
                    n(gVar3);
                    m(gVar);
                }
                if (z7) {
                    return;
                }
            } else if (i9 == 2) {
                g<K, V> gVar6 = gVar2.f23199b;
                g<K, V> gVar7 = gVar2.f23200c;
                int i11 = (gVar6 != null ? gVar6.f23206i : 0) - (gVar7 != null ? gVar7.f23206i : 0);
                if (i11 == 1 || (i11 == 0 && !z7)) {
                    n(gVar);
                } else {
                    m(gVar2);
                    n(gVar);
                }
                if (z7) {
                    return;
                }
            } else if (i9 == 0) {
                gVar.f23206i = i7 + 1;
                if (z7) {
                    return;
                }
            } else {
                gVar.f23206i = Math.max(i7, i8) + 1;
                if (!z7) {
                    return;
                }
            }
            gVar = gVar.f23198a;
        }
    }

    private void l(g<K, V> gVar, g<K, V> gVar2) {
        g<K, V> gVar3 = gVar.f23198a;
        gVar.f23198a = null;
        if (gVar2 != null) {
            gVar2.f23198a = gVar3;
        }
        if (gVar3 == null) {
            int i7 = gVar.f23204g;
            g<K, V>[] gVarArr = this.f23178b;
            gVarArr[i7 & (gVarArr.length - 1)] = gVar2;
        } else if (gVar3.f23199b == gVar) {
            gVar3.f23199b = gVar2;
        } else {
            gVar3.f23200c = gVar2;
        }
    }

    private void m(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f23199b;
        g<K, V> gVar3 = gVar.f23200c;
        g<K, V> gVar4 = gVar3.f23199b;
        g<K, V> gVar5 = gVar3.f23200c;
        gVar.f23200c = gVar4;
        if (gVar4 != null) {
            gVar4.f23198a = gVar;
        }
        l(gVar, gVar3);
        gVar3.f23199b = gVar;
        gVar.f23198a = gVar3;
        int iMax = Math.max(gVar2 != null ? gVar2.f23206i : 0, gVar4 != null ? gVar4.f23206i : 0) + 1;
        gVar.f23206i = iMax;
        gVar3.f23206i = Math.max(iMax, gVar5 != null ? gVar5.f23206i : 0) + 1;
    }

    private void n(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f23199b;
        g<K, V> gVar3 = gVar.f23200c;
        g<K, V> gVar4 = gVar2.f23199b;
        g<K, V> gVar5 = gVar2.f23200c;
        gVar.f23199b = gVar5;
        if (gVar5 != null) {
            gVar5.f23198a = gVar;
        }
        l(gVar, gVar2);
        gVar2.f23200c = gVar;
        gVar.f23198a = gVar2;
        int iMax = Math.max(gVar3 != null ? gVar3.f23206i : 0, gVar5 != null ? gVar5.f23206i : 0) + 1;
        gVar.f23206i = iMax;
        gVar2.f23206i = Math.max(iMax, gVar4 != null ? gVar4.f23206i : 0) + 1;
    }

    private static int o(int i7) {
        int i8 = i7 ^ ((i7 >>> 20) ^ (i7 >>> 12));
        return (i8 >>> 4) ^ ((i8 >>> 7) ^ i8);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Arrays.fill(this.f23178b, (Object) null);
        this.f23180d = 0;
        this.f23181e++;
        g<K, V> gVar = this.f23179c;
        g<K, V> gVar2 = gVar.f23201d;
        while (gVar2 != gVar) {
            g<K, V> gVar3 = gVar2.f23201d;
            gVar2.f23202e = null;
            gVar2.f23201d = null;
            gVar2 = gVar3;
        }
        gVar.f23202e = gVar;
        gVar.f23201d = gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return f(obj) != null;
    }

    g<K, V> d(K k7, boolean z7) {
        int iCompareTo;
        g<K, V> gVar;
        Comparator<? super K> comparator = this.f23177a;
        g<K, V>[] gVarArr = this.f23178b;
        int iO = o(k7.hashCode());
        int length = (gVarArr.length - 1) & iO;
        g<K, V> gVar2 = gVarArr[length];
        if (gVar2 != null) {
            Comparable comparable = comparator == f23175i ? (Comparable) k7 : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(gVar2.f23203f) : comparator.compare(k7, gVar2.f23203f);
                if (iCompareTo == 0) {
                    return gVar2;
                }
                g<K, V> gVar3 = iCompareTo < 0 ? gVar2.f23199b : gVar2.f23200c;
                if (gVar3 == null) {
                    break;
                }
                gVar2 = gVar3;
            }
        } else {
            iCompareTo = 0;
        }
        g<K, V> gVar4 = gVar2;
        int i7 = iCompareTo;
        if (!z7) {
            return null;
        }
        g<K, V> gVar5 = this.f23179c;
        if (gVar4 != null) {
            gVar = new g<>(gVar4, k7, iO, gVar5, gVar5.f23202e);
            if (i7 < 0) {
                gVar4.f23199b = gVar;
            } else {
                gVar4.f23200c = gVar;
            }
            g(gVar4, true);
        } else {
            if (comparator == f23175i && !(k7 instanceof Comparable)) {
                throw new ClassCastException(k7.getClass().getName() + " is not Comparable");
            }
            gVar = new g<>(gVar4, k7, iO, gVar5, gVar5.f23202e);
            gVarArr[length] = gVar;
        }
        int i8 = this.f23180d;
        this.f23180d = i8 + 1;
        if (i8 > this.f23182f) {
            a();
        }
        this.f23181e++;
        return gVar;
    }

    g<K, V> e(Map.Entry<?, ?> entry) {
        g<K, V> gVarF = f(entry.getKey());
        if (gVarF != null && c(gVarF.f23205h, entry.getValue())) {
            return gVarF;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.d dVar = this.f23183g;
        if (dVar != null) {
            return dVar;
        }
        h<K, V>.d dVar2 = new d();
        this.f23183g = dVar2;
        return dVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    g<K, V> f(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return d(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        g<K, V> gVarF = f(obj);
        if (gVarF != null) {
            return gVarF.f23205h;
        }
        return null;
    }

    void i(g<K, V> gVar, boolean z7) {
        int i7;
        if (z7) {
            g<K, V> gVar2 = gVar.f23202e;
            gVar2.f23201d = gVar.f23201d;
            gVar.f23201d.f23202e = gVar2;
            gVar.f23202e = null;
            gVar.f23201d = null;
        }
        g<K, V> gVar3 = gVar.f23199b;
        g<K, V> gVar4 = gVar.f23200c;
        g<K, V> gVar5 = gVar.f23198a;
        int i8 = 0;
        if (gVar3 == null || gVar4 == null) {
            if (gVar3 != null) {
                l(gVar, gVar3);
                gVar.f23199b = null;
            } else if (gVar4 != null) {
                l(gVar, gVar4);
                gVar.f23200c = null;
            } else {
                l(gVar, null);
            }
            g(gVar5, false);
            this.f23180d--;
            this.f23181e++;
            return;
        }
        g<K, V> gVarB = gVar3.f23206i > gVar4.f23206i ? gVar3.b() : gVar4.a();
        i(gVarB, false);
        g<K, V> gVar6 = gVar.f23199b;
        if (gVar6 != null) {
            i7 = gVar6.f23206i;
            gVarB.f23199b = gVar6;
            gVar6.f23198a = gVarB;
            gVar.f23199b = null;
        } else {
            i7 = 0;
        }
        g<K, V> gVar7 = gVar.f23200c;
        if (gVar7 != null) {
            i8 = gVar7.f23206i;
            gVarB.f23200c = gVar7;
            gVar7.f23198a = gVarB;
            gVar.f23200c = null;
        }
        gVarB.f23206i = Math.max(i7, i8) + 1;
        l(gVar, gVarB);
    }

    g<K, V> k(Object obj) {
        g<K, V> gVarF = f(obj);
        if (gVarF != null) {
            i(gVarF, true);
        }
        return gVarF;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.e eVar = this.f23184h;
        if (eVar != null) {
            return eVar;
        }
        h<K, V>.e eVar2 = new e();
        this.f23184h = eVar2;
        return eVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k7, V v7) {
        if (k7 == null) {
            throw new NullPointerException("key == null");
        }
        g<K, V> gVarD = d(k7, true);
        V v8 = gVarD.f23205h;
        gVarD.f23205h = v7;
        return v8;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        g<K, V> gVarK = k(obj);
        if (gVarK != null) {
            return gVarK.f23205h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f23180d;
    }

    public h(Comparator<? super K> comparator) {
        this.f23180d = 0;
        this.f23181e = 0;
        this.f23177a = comparator == null ? f23175i : comparator;
        this.f23179c = new g<>();
        g<K, V>[] gVarArr = new g[16];
        this.f23178b = gVarArr;
        this.f23182f = (gVarArr.length / 2) + (gVarArr.length / 4);
    }

    static final class g<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        g<K, V> f23198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        g<K, V> f23199b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        g<K, V> f23200c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        g<K, V> f23201d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        g<K, V> f23202e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final K f23203f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f23204g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        V f23205h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f23206i;

        g() {
            this.f23203f = null;
            this.f23204g = -1;
            this.f23202e = this;
            this.f23201d = this;
        }

        public g<K, V> a() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f23199b; gVar2 != null; gVar2 = gVar2.f23199b) {
                gVar = gVar2;
            }
            return gVar;
        }

        public g<K, V> b() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f23200c; gVar2 != null; gVar2 = gVar2.f23200c) {
                gVar = gVar2;
            }
            return gVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k7 = this.f23203f;
            if (k7 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k7.equals(entry.getKey())) {
                return false;
            }
            V v7 = this.f23205h;
            if (v7 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v7.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f23203f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f23205h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k7 = this.f23203f;
            int iHashCode = k7 == null ? 0 : k7.hashCode();
            V v7 = this.f23205h;
            return iHashCode ^ (v7 != null ? v7.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v7) {
            V v8 = this.f23205h;
            this.f23205h = v7;
            return v8;
        }

        public String toString() {
            return this.f23203f + "=" + this.f23205h;
        }

        g(g<K, V> gVar, K k7, int i7, g<K, V> gVar2, g<K, V> gVar3) {
            this.f23198a = gVar;
            this.f23203f = k7;
            this.f23204g = i7;
            this.f23206i = 1;
            this.f23201d = gVar2;
            this.f23202e = gVar3;
            gVar3.f23201d = this;
            gVar2.f23202e = this;
        }
    }
}
