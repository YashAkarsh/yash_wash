package com.airbnb.lottie.parser.moshi;

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

/* JADX INFO: loaded from: classes.dex */
final class f<K, V> extends AbstractMap<K, V> implements Serializable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Comparator<Comparable> f12256i = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final /* synthetic */ boolean f12257j = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Comparator<? super K> f12258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    g<K, V>[] f12259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final g<K, V> f12260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f12261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f12262e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f12263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private f<K, V>.d f12264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private f<K, V>.e f12265h;

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
        private g<K, V> f12266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f12267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f12268c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f12269d;

        b() {
        }

        void a(g<K, V> gVar) {
            gVar.f12281c = null;
            gVar.f12279a = null;
            gVar.f12280b = null;
            gVar.f12287i = 1;
            int i7 = this.f12267b;
            if (i7 > 0) {
                int i8 = this.f12269d;
                if ((i8 & 1) == 0) {
                    this.f12269d = i8 + 1;
                    this.f12267b = i7 - 1;
                    this.f12268c++;
                }
            }
            gVar.f12279a = this.f12266a;
            this.f12266a = gVar;
            int i9 = this.f12269d + 1;
            this.f12269d = i9;
            int i10 = this.f12267b;
            if (i10 > 0 && (i9 & 1) == 0) {
                this.f12269d = i9 + 1;
                this.f12267b = i10 - 1;
                this.f12268c++;
            }
            int i11 = 4;
            while (true) {
                int i12 = i11 - 1;
                if ((this.f12269d & i12) != i12) {
                    return;
                }
                int i13 = this.f12268c;
                if (i13 == 0) {
                    g<K, V> gVar2 = this.f12266a;
                    g<K, V> gVar3 = gVar2.f12279a;
                    g<K, V> gVar4 = gVar3.f12279a;
                    gVar3.f12279a = gVar4.f12279a;
                    this.f12266a = gVar3;
                    gVar3.f12280b = gVar4;
                    gVar3.f12281c = gVar2;
                    gVar3.f12287i = gVar2.f12287i + 1;
                    gVar4.f12279a = gVar3;
                    gVar2.f12279a = gVar3;
                } else if (i13 == 1) {
                    g<K, V> gVar5 = this.f12266a;
                    g<K, V> gVar6 = gVar5.f12279a;
                    this.f12266a = gVar6;
                    gVar6.f12281c = gVar5;
                    gVar6.f12287i = gVar5.f12287i + 1;
                    gVar5.f12279a = gVar6;
                    this.f12268c = 0;
                } else if (i13 == 2) {
                    this.f12268c = 0;
                }
                i11 *= 2;
            }
        }

        void b(int i7) {
            this.f12267b = ((Integer.highestOneBit(i7) * 2) - 1) - i7;
            this.f12269d = 0;
            this.f12268c = 0;
            this.f12266a = null;
        }

        g<K, V> c() {
            g<K, V> gVar = this.f12266a;
            if (gVar.f12279a == null) {
                return gVar;
            }
            throw new IllegalStateException();
        }
    }

    static class c<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private g<K, V> f12270a;

        c() {
        }

        public g<K, V> a() {
            g<K, V> gVar = this.f12270a;
            if (gVar == null) {
                return null;
            }
            g<K, V> gVar2 = gVar.f12279a;
            gVar.f12279a = null;
            g<K, V> gVar3 = gVar.f12281c;
            while (true) {
                g<K, V> gVar4 = gVar2;
                gVar2 = gVar3;
                if (gVar2 == null) {
                    this.f12270a = gVar4;
                    return gVar;
                }
                gVar2.f12279a = gVar4;
                gVar3 = gVar2.f12280b;
            }
        }

        void b(g<K, V> gVar) {
            g<K, V> gVar2 = null;
            while (gVar != null) {
                gVar.f12279a = gVar2;
                gVar2 = gVar;
                gVar = gVar.f12280b;
            }
            this.f12270a = gVar2;
        }
    }

    final class d extends AbstractSet<Map.Entry<K, V>> {

        class a extends f<K, V>.AbstractC0145f<Map.Entry<K, V>> {
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
            f.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && f.this.e((Map.Entry) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            g<K, V> gVarE;
            if (!(obj instanceof Map.Entry) || (gVarE = f.this.e((Map.Entry) obj)) == null) {
                return false;
            }
            f.this.i(gVarE, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return f.this.f12261d;
        }
    }

    final class e extends AbstractSet<K> {

        class a extends f<K, V>.AbstractC0145f<K> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().f12284f;
            }
        }

        e() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            f.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return f.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return f.this.k(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return f.this.f12261d;
        }
    }

    /* JADX INFO: renamed from: com.airbnb.lottie.parser.moshi.f$f, reason: collision with other inner class name */
    abstract class AbstractC0145f<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        g<K, V> f12275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        g<K, V> f12276b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f12277c;

        AbstractC0145f() {
            this.f12275a = f.this.f12260c.f12282d;
            this.f12277c = f.this.f12262e;
        }

        final g<K, V> a() {
            g<K, V> gVar = this.f12275a;
            f fVar = f.this;
            if (gVar == fVar.f12260c) {
                throw new NoSuchElementException();
            }
            if (fVar.f12262e != this.f12277c) {
                throw new ConcurrentModificationException();
            }
            this.f12275a = gVar.f12282d;
            this.f12276b = gVar;
            return gVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f12275a != f.this.f12260c;
        }

        @Override // java.util.Iterator
        public final void remove() {
            g<K, V> gVar = this.f12276b;
            if (gVar == null) {
                throw new IllegalStateException();
            }
            f.this.i(gVar, true);
            this.f12276b = null;
            this.f12277c = f.this.f12262e;
        }
    }

    f() {
        this(null);
    }

    private void a() {
        g<K, V>[] gVarArrB = b(this.f12259b);
        this.f12259b = gVarArrB;
        this.f12263f = (gVarArrB.length / 2) + (gVarArrB.length / 4);
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
                    if ((gVarA.f12285g & length) == 0) {
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
                    if ((gVarA2.f12285g & length) == 0) {
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
            g<K, V> gVar2 = gVar.f12280b;
            g<K, V> gVar3 = gVar.f12281c;
            int i7 = gVar2 != null ? gVar2.f12287i : 0;
            int i8 = gVar3 != null ? gVar3.f12287i : 0;
            int i9 = i7 - i8;
            if (i9 == -2) {
                g<K, V> gVar4 = gVar3.f12280b;
                g<K, V> gVar5 = gVar3.f12281c;
                int i10 = (gVar4 != null ? gVar4.f12287i : 0) - (gVar5 != null ? gVar5.f12287i : 0);
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
                g<K, V> gVar6 = gVar2.f12280b;
                g<K, V> gVar7 = gVar2.f12281c;
                int i11 = (gVar6 != null ? gVar6.f12287i : 0) - (gVar7 != null ? gVar7.f12287i : 0);
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
                gVar.f12287i = i7 + 1;
                if (z7) {
                    return;
                }
            } else {
                gVar.f12287i = Math.max(i7, i8) + 1;
                if (!z7) {
                    return;
                }
            }
            gVar = gVar.f12279a;
        }
    }

    private void l(g<K, V> gVar, g<K, V> gVar2) {
        g<K, V> gVar3 = gVar.f12279a;
        gVar.f12279a = null;
        if (gVar2 != null) {
            gVar2.f12279a = gVar3;
        }
        if (gVar3 == null) {
            int i7 = gVar.f12285g;
            g<K, V>[] gVarArr = this.f12259b;
            gVarArr[i7 & (gVarArr.length - 1)] = gVar2;
        } else if (gVar3.f12280b == gVar) {
            gVar3.f12280b = gVar2;
        } else {
            gVar3.f12281c = gVar2;
        }
    }

    private void m(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f12280b;
        g<K, V> gVar3 = gVar.f12281c;
        g<K, V> gVar4 = gVar3.f12280b;
        g<K, V> gVar5 = gVar3.f12281c;
        gVar.f12281c = gVar4;
        if (gVar4 != null) {
            gVar4.f12279a = gVar;
        }
        l(gVar, gVar3);
        gVar3.f12280b = gVar;
        gVar.f12279a = gVar3;
        int iMax = Math.max(gVar2 != null ? gVar2.f12287i : 0, gVar4 != null ? gVar4.f12287i : 0) + 1;
        gVar.f12287i = iMax;
        gVar3.f12287i = Math.max(iMax, gVar5 != null ? gVar5.f12287i : 0) + 1;
    }

    private void n(g<K, V> gVar) {
        g<K, V> gVar2 = gVar.f12280b;
        g<K, V> gVar3 = gVar.f12281c;
        g<K, V> gVar4 = gVar2.f12280b;
        g<K, V> gVar5 = gVar2.f12281c;
        gVar.f12280b = gVar5;
        if (gVar5 != null) {
            gVar5.f12279a = gVar;
        }
        l(gVar, gVar2);
        gVar2.f12281c = gVar;
        gVar.f12279a = gVar2;
        int iMax = Math.max(gVar3 != null ? gVar3.f12287i : 0, gVar5 != null ? gVar5.f12287i : 0) + 1;
        gVar.f12287i = iMax;
        gVar2.f12287i = Math.max(iMax, gVar4 != null ? gVar4.f12287i : 0) + 1;
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
        Arrays.fill(this.f12259b, (Object) null);
        this.f12261d = 0;
        this.f12262e++;
        g<K, V> gVar = this.f12260c;
        g<K, V> gVar2 = gVar.f12282d;
        while (gVar2 != gVar) {
            g<K, V> gVar3 = gVar2.f12282d;
            gVar2.f12283e = null;
            gVar2.f12282d = null;
            gVar2 = gVar3;
        }
        gVar.f12283e = gVar;
        gVar.f12282d = gVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return f(obj) != null;
    }

    g<K, V> d(K k7, boolean z7) {
        int iCompareTo;
        g<K, V> gVar;
        Comparator<? super K> comparator = this.f12258a;
        g<K, V>[] gVarArr = this.f12259b;
        int iO = o(k7.hashCode());
        int length = (gVarArr.length - 1) & iO;
        g<K, V> gVar2 = gVarArr[length];
        if (gVar2 != null) {
            Comparable comparable = comparator == f12256i ? (Comparable) k7 : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(gVar2.f12284f) : comparator.compare(k7, gVar2.f12284f);
                if (iCompareTo == 0) {
                    return gVar2;
                }
                g<K, V> gVar3 = iCompareTo < 0 ? gVar2.f12280b : gVar2.f12281c;
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
        g<K, V> gVar5 = this.f12260c;
        if (gVar4 != null) {
            gVar = new g<>(gVar4, k7, iO, gVar5, gVar5.f12283e);
            if (i7 < 0) {
                gVar4.f12280b = gVar;
            } else {
                gVar4.f12281c = gVar;
            }
            g(gVar4, true);
        } else {
            if (comparator == f12256i && !(k7 instanceof Comparable)) {
                throw new ClassCastException(k7.getClass().getName() + " is not Comparable");
            }
            gVar = new g<>(gVar4, k7, iO, gVar5, gVar5.f12283e);
            gVarArr[length] = gVar;
        }
        int i8 = this.f12261d;
        this.f12261d = i8 + 1;
        if (i8 > this.f12263f) {
            a();
        }
        this.f12262e++;
        return gVar;
    }

    g<K, V> e(Map.Entry<?, ?> entry) {
        g<K, V> gVarF = f(entry.getKey());
        if (gVarF != null && c(gVarF.f12286h, entry.getValue())) {
            return gVarF;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        f<K, V>.d dVar = this.f12264g;
        if (dVar != null) {
            return dVar;
        }
        f<K, V>.d dVar2 = new d();
        this.f12264g = dVar2;
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
            return gVarF.f12286h;
        }
        return null;
    }

    void i(g<K, V> gVar, boolean z7) {
        int i7;
        if (z7) {
            g<K, V> gVar2 = gVar.f12283e;
            gVar2.f12282d = gVar.f12282d;
            gVar.f12282d.f12283e = gVar2;
            gVar.f12283e = null;
            gVar.f12282d = null;
        }
        g<K, V> gVar3 = gVar.f12280b;
        g<K, V> gVar4 = gVar.f12281c;
        g<K, V> gVar5 = gVar.f12279a;
        int i8 = 0;
        if (gVar3 == null || gVar4 == null) {
            if (gVar3 != null) {
                l(gVar, gVar3);
                gVar.f12280b = null;
            } else if (gVar4 != null) {
                l(gVar, gVar4);
                gVar.f12281c = null;
            } else {
                l(gVar, null);
            }
            g(gVar5, false);
            this.f12261d--;
            this.f12262e++;
            return;
        }
        g<K, V> gVarB = gVar3.f12287i > gVar4.f12287i ? gVar3.b() : gVar4.a();
        i(gVarB, false);
        g<K, V> gVar6 = gVar.f12280b;
        if (gVar6 != null) {
            i7 = gVar6.f12287i;
            gVarB.f12280b = gVar6;
            gVar6.f12279a = gVarB;
            gVar.f12280b = null;
        } else {
            i7 = 0;
        }
        g<K, V> gVar7 = gVar.f12281c;
        if (gVar7 != null) {
            i8 = gVar7.f12287i;
            gVarB.f12281c = gVar7;
            gVar7.f12279a = gVarB;
            gVar.f12281c = null;
        }
        gVarB.f12287i = Math.max(i7, i8) + 1;
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
        f<K, V>.e eVar = this.f12265h;
        if (eVar != null) {
            return eVar;
        }
        f<K, V>.e eVar2 = new e();
        this.f12265h = eVar2;
        return eVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k7, V v7) {
        if (k7 == null) {
            throw new NullPointerException("key == null");
        }
        g<K, V> gVarD = d(k7, true);
        V v8 = gVarD.f12286h;
        gVarD.f12286h = v7;
        return v8;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        g<K, V> gVarK = k(obj);
        if (gVarK != null) {
            return gVarK.f12286h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f12261d;
    }

    f(Comparator<? super K> comparator) {
        this.f12261d = 0;
        this.f12262e = 0;
        this.f12258a = comparator == null ? f12256i : comparator;
        this.f12260c = new g<>();
        g<K, V>[] gVarArr = new g[16];
        this.f12259b = gVarArr;
        this.f12263f = (gVarArr.length / 2) + (gVarArr.length / 4);
    }

    static final class g<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        g<K, V> f12279a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        g<K, V> f12280b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        g<K, V> f12281c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        g<K, V> f12282d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        g<K, V> f12283e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final K f12284f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f12285g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        V f12286h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f12287i;

        g() {
            this.f12284f = null;
            this.f12285g = -1;
            this.f12283e = this;
            this.f12282d = this;
        }

        public g<K, V> a() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f12280b; gVar2 != null; gVar2 = gVar2.f12280b) {
                gVar = gVar2;
            }
            return gVar;
        }

        public g<K, V> b() {
            g<K, V> gVar = this;
            for (g<K, V> gVar2 = this.f12281c; gVar2 != null; gVar2 = gVar2.f12281c) {
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
            K k7 = this.f12284f;
            if (k7 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k7.equals(entry.getKey())) {
                return false;
            }
            V v7 = this.f12286h;
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
            return this.f12284f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f12286h;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k7 = this.f12284f;
            int iHashCode = k7 == null ? 0 : k7.hashCode();
            V v7 = this.f12286h;
            return iHashCode ^ (v7 != null ? v7.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v7) {
            V v8 = this.f12286h;
            this.f12286h = v7;
            return v8;
        }

        public String toString() {
            return this.f12284f + "=" + this.f12286h;
        }

        g(g<K, V> gVar, K k7, int i7, g<K, V> gVar2, g<K, V> gVar3) {
            this.f12279a = gVar;
            this.f12284f = k7;
            this.f12285g = i7;
            this.f12287i = 1;
            this.f12282d = gVar2;
            this.f12283e = gVar3;
            gVar3.f12282d = this;
            gVar2.f12283e = this;
        }
    }
}
