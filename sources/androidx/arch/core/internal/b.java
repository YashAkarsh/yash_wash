package androidx.arch.core.internal;

import c.m0;
import c.x0;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public class b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    c<K, V> f2040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c<K, V> f2041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakHashMap<f<K, V>, Boolean> f2042c = new WeakHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2043d = 0;

    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // androidx.arch.core.internal.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f2047d;
        }

        @Override // androidx.arch.core.internal.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f2046c;
        }
    }

    /* JADX INFO: renamed from: androidx.arch.core.internal.b$b, reason: collision with other inner class name */
    private static class C0027b<K, V> extends e<K, V> {
        C0027b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // androidx.arch.core.internal.b.e
        c<K, V> b(c<K, V> cVar) {
            return cVar.f2046c;
        }

        @Override // androidx.arch.core.internal.b.e
        c<K, V> c(c<K, V> cVar) {
            return cVar.f2047d;
        }
    }

    static class c<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        final K f2044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m0
        final V f2045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        c<K, V> f2046c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        c<K, V> f2047d;

        c(@m0 K k7, @m0 V v7) {
            this.f2044a = k7;
            this.f2045b = v7;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f2044a.equals(cVar.f2044a) && this.f2045b.equals(cVar.f2045b);
        }

        @Override // java.util.Map.Entry
        @m0
        public K getKey() {
            return this.f2044a;
        }

        @Override // java.util.Map.Entry
        @m0
        public V getValue() {
            return this.f2045b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f2044a.hashCode() ^ this.f2045b.hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v7) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f2044a + "=" + this.f2045b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public class d implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private c<K, V> f2048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2049b = true;

        d() {
        }

        @Override // androidx.arch.core.internal.b.f
        public void a(@m0 c<K, V> cVar) {
            c<K, V> cVar2 = this.f2048a;
            if (cVar == cVar2) {
                c<K, V> cVar3 = cVar2.f2047d;
                this.f2048a = cVar3;
                this.f2049b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (this.f2049b) {
                this.f2049b = false;
                this.f2048a = b.this.f2040a;
            } else {
                c<K, V> cVar = this.f2048a;
                this.f2048a = cVar != null ? cVar.f2046c : null;
            }
            return this.f2048a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f2049b) {
                return b.this.f2040a != null;
            }
            c<K, V> cVar = this.f2048a;
            return (cVar == null || cVar.f2046c == null) ? false : true;
        }
    }

    private static abstract class e<K, V> implements Iterator<Map.Entry<K, V>>, f<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        c<K, V> f2051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        c<K, V> f2052b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f2051a = cVar2;
            this.f2052b = cVar;
        }

        private c<K, V> e() {
            c<K, V> cVar = this.f2052b;
            c<K, V> cVar2 = this.f2051a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // androidx.arch.core.internal.b.f
        public void a(@m0 c<K, V> cVar) {
            if (this.f2051a == cVar && cVar == this.f2052b) {
                this.f2052b = null;
                this.f2051a = null;
            }
            c<K, V> cVar2 = this.f2051a;
            if (cVar2 == cVar) {
                this.f2051a = b(cVar2);
            }
            if (this.f2052b == cVar) {
                this.f2052b = e();
            }
        }

        abstract c<K, V> b(c<K, V> cVar);

        abstract c<K, V> c(c<K, V> cVar);

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f2052b;
            this.f2052b = e();
            return cVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2052b != null;
        }
    }

    interface f<K, V> {
        void a(@m0 c<K, V> cVar);
    }

    public Map.Entry<K, V> a() {
        return this.f2040a;
    }

    protected c<K, V> b(K k7) {
        c<K, V> cVar = this.f2040a;
        while (cVar != null && !cVar.f2044a.equals(k7)) {
            cVar = cVar.f2046c;
        }
        return cVar;
    }

    public b<K, V>.d d() {
        b<K, V>.d dVar = new d();
        this.f2042c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        C0027b c0027b = new C0027b(this.f2041b, this.f2040a);
        this.f2042c.put(c0027b, Boolean.FALSE);
        return c0027b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public Map.Entry<K, V> f() {
        return this.f2041b;
    }

    protected c<K, V> g(@m0 K k7, @m0 V v7) {
        c<K, V> cVar = new c<>(k7, v7);
        this.f2043d++;
        c<K, V> cVar2 = this.f2041b;
        if (cVar2 == null) {
            this.f2040a = cVar;
            this.f2041b = cVar;
            return cVar;
        }
        cVar2.f2046c = cVar;
        cVar.f2047d = cVar2;
        this.f2041b = cVar;
        return cVar;
    }

    public V h(@m0 K k7, @m0 V v7) {
        c<K, V> cVarB = b(k7);
        if (cVarB != null) {
            return cVarB.f2045b;
        }
        g(k7, v7);
        return null;
    }

    public int hashCode() {
        Iterator<Map.Entry<K, V>> it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += it.next().hashCode();
        }
        return iHashCode;
    }

    @Override // java.lang.Iterable
    @m0
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f2040a, this.f2041b);
        this.f2042c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public V j(@m0 K k7) {
        c<K, V> cVarB = b(k7);
        if (cVarB == null) {
            return null;
        }
        this.f2043d--;
        if (!this.f2042c.isEmpty()) {
            Iterator<f<K, V>> it = this.f2042c.keySet().iterator();
            while (it.hasNext()) {
                it.next().a(cVarB);
            }
        }
        c<K, V> cVar = cVarB.f2047d;
        if (cVar != null) {
            cVar.f2046c = cVarB.f2046c;
        } else {
            this.f2040a = cVarB.f2046c;
        }
        c<K, V> cVar2 = cVarB.f2046c;
        if (cVar2 != null) {
            cVar2.f2047d = cVar;
        } else {
            this.f2041b = cVar;
        }
        cVarB.f2046c = null;
        cVarB.f2047d = null;
        return cVarB.f2045b;
    }

    public int size() {
        return this.f2043d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
