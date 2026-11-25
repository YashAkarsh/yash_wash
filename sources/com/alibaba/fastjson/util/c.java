package com.alibaba.fastjson.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class c<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final int f13260j = 16;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final int f13261k = 1073741824;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final float f13262l = 0.75f;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final int f13263m = -2023358765;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final int f13264n = -2128831035;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final int f13265o = 16777619;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final long f13266p = 362498820763181265L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile transient Set<K> f13267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile transient Collection<V> f13268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    transient b<K, V>[] f13269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    transient int f13270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f13271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final float f13272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    volatile transient int f13273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f13274h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private transient Set<Map.Entry<K, V>> f13275i;

    static class b<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f13276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        V f13277b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        b<K, V> f13278c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f13279d;

        b(int i7, K k7, V v7, b<K, V> bVar) {
            this.f13277b = v7;
            this.f13278c = bVar;
            this.f13276a = k7;
            this.f13279d = i7;
        }

        void a(c<K, V> cVar) {
        }

        void b(c<K, V> cVar) {
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K key = getKey();
            Object key2 = entry.getKey();
            if (key == key2 || (key != null && key.equals(key2))) {
                V value = getValue();
                Object value2 = entry.getValue();
                if (value == value2) {
                    return true;
                }
                if (value != null && value.equals(value2)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f13276a;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f13277b;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            K k7 = this.f13276a;
            int iHashCode = k7 == null ? 0 : k7.hashCode();
            V v7 = this.f13277b;
            return iHashCode ^ (v7 != null ? v7.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v7) {
            V v8 = this.f13277b;
            this.f13277b = v7;
            return v8;
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* JADX INFO: renamed from: com.alibaba.fastjson.util.c$c, reason: collision with other inner class name */
    private final class C0153c extends c<K, V>.e<Map.Entry<K, V>> {
        private C0153c() {
            super();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            return a();
        }
    }

    private final class d extends AbstractSet<Map.Entry<K, V>> {
        private d() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            c.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            b<K, V> bVarM = c.this.m(entry.getKey());
            return bVarM != null && bVarM.equals(entry);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return c.this.w();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return c.this.H(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return c.this.f13270d;
        }
    }

    private abstract class e<E> implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        b<K, V> f13282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f13283b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f13284c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        b<K, V> f13285d;

        e() {
            b<K, V> bVar;
            this.f13283b = c.this.f13273g;
            if (c.this.f13270d > 0) {
                b<K, V>[] bVarArr = c.this.f13269c;
                do {
                    int i7 = this.f13284c;
                    if (i7 >= bVarArr.length) {
                        return;
                    }
                    this.f13284c = i7 + 1;
                    bVar = bVarArr[i7];
                    this.f13282a = bVar;
                } while (bVar == null);
            }
        }

        final b<K, V> a() {
            b<K, V> bVar;
            if (c.this.f13273g != this.f13283b) {
                throw new ConcurrentModificationException();
            }
            b<K, V> bVar2 = this.f13282a;
            if (bVar2 == null) {
                throw new NoSuchElementException();
            }
            b<K, V> bVar3 = bVar2.f13278c;
            this.f13282a = bVar3;
            if (bVar3 == null) {
                b<K, V>[] bVarArr = c.this.f13269c;
                do {
                    int i7 = this.f13284c;
                    if (i7 >= bVarArr.length) {
                        break;
                    }
                    this.f13284c = i7 + 1;
                    bVar = bVarArr[i7];
                    this.f13282a = bVar;
                } while (bVar == null);
            }
            this.f13285d = bVar2;
            return bVar2;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f13282a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f13285d == null) {
                throw new IllegalStateException();
            }
            if (c.this.f13273g != this.f13283b) {
                throw new ConcurrentModificationException();
            }
            K k7 = this.f13285d.f13276a;
            this.f13285d = null;
            c.this.E(k7);
            this.f13283b = c.this.f13273g;
        }
    }

    private final class f extends c<K, V>.e<K> {
        private f() {
            super();
        }

        @Override // java.util.Iterator
        public K next() {
            return a().getKey();
        }
    }

    private final class g extends AbstractSet<K> {
        private g() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            c.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return c.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return c.this.y();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return c.this.E(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return c.this.f13270d;
        }
    }

    private final class h extends c<K, V>.e<V> {
        private h() {
            super();
        }

        @Override // java.util.Iterator
        public V next() {
            return a().f13277b;
        }
    }

    private final class i extends AbstractCollection<V> {
        private i() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            c.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return c.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return c.this.z();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return c.this.f13270d;
        }
    }

    public c(int i7, float f8) {
        this.f13267a = null;
        this.f13268b = null;
        this.f13274h = new Random().nextInt(99999);
        this.f13275i = null;
        if (i7 < 0) {
            throw new IllegalArgumentException("Illegal initial capacity: " + i7);
        }
        i7 = i7 > 1073741824 ? 1073741824 : i7;
        if (f8 <= 0.0f || Float.isNaN(f8)) {
            throw new IllegalArgumentException("Illegal load factor: " + f8);
        }
        int i8 = 1;
        while (i8 < i7) {
            i8 <<= 1;
        }
        this.f13272f = f8;
        this.f13271e = (int) (i8 * f8);
        this.f13269c = new b[i8];
        t();
    }

    private void B(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            C(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void C(K k7, V v7) {
        K k8;
        int iO = k7 == 0 ? 0 : k7 instanceof String ? o(q((String) k7)) : o(k7.hashCode());
        int iR = r(iO, this.f13269c.length);
        for (b<K, V> bVar = this.f13269c[iR]; bVar != null; bVar = bVar.f13278c) {
            if (bVar.f13279d == iO && ((k8 = bVar.f13276a) == k7 || (k7 != 0 && k7.equals(k8)))) {
                bVar.f13277b = v7;
                return;
            }
        }
        k(iO, k7, v7, iR);
    }

    private V D(V v7) {
        for (b<K, V> bVar = this.f13269c[0]; bVar != null; bVar = bVar.f13278c) {
            if (bVar.f13276a == null) {
                V v8 = bVar.f13277b;
                bVar.f13277b = v7;
                bVar.a(this);
                return v8;
            }
        }
        this.f13273g++;
        a(0, null, v7, 0);
        return null;
    }

    private boolean i() {
        for (b<K, V> bVar : this.f13269c) {
            for (; bVar != null; bVar = bVar.f13278c) {
                if (bVar.f13277b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    private Set<Map.Entry<K, V>> l() {
        Set<Map.Entry<K, V>> set = this.f13275i;
        if (set != null) {
            return set;
        }
        d dVar = new d();
        this.f13275i = dVar;
        return dVar;
    }

    private V n() {
        for (b<K, V> bVar = this.f13269c[0]; bVar != null; bVar = bVar.f13278c) {
            if (bVar.f13276a == null) {
                return bVar.f13277b;
            }
        }
        return null;
    }

    static int o(int i7) {
        int i8 = i7 * i7;
        int i9 = i8 ^ ((i8 >>> 20) ^ (i8 >>> 12));
        return (i9 >>> 4) ^ ((i9 >>> 7) ^ i9);
    }

    private int q(String str) {
        int iCharAt = this.f13274h * f13264n;
        for (int i7 = 0; i7 < str.length(); i7++) {
            iCharAt = (iCharAt * f13265o) ^ str.charAt(i7);
        }
        return ((iCharAt >> 1) ^ iCharAt) & f13263m;
    }

    static int r(int i7, int i8) {
        return i7 & (i8 - 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f13269c = new b[objectInputStream.readInt()];
        t();
        int i7 = objectInputStream.readInt();
        for (int i8 = 0; i8 < i7; i8++) {
            C(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Iterator<Map.Entry<K, V>> it = this.f13270d > 0 ? l().iterator() : null;
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f13269c.length);
        objectOutputStream.writeInt(this.f13270d);
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                objectOutputStream.writeObject(next.getKey());
                objectOutputStream.writeObject(next.getValue());
            }
        }
    }

    final b<K, V> E(Object obj) {
        int iO;
        K k7;
        if (obj == null) {
            iO = 0;
        } else {
            iO = obj instanceof String ? o(q((String) obj)) : o(obj.hashCode());
        }
        int iR = r(iO, this.f13269c.length);
        b<K, V> bVar = this.f13269c[iR];
        b<K, V> bVar2 = bVar;
        while (bVar != null) {
            b<K, V> bVar3 = bVar.f13278c;
            if (bVar.f13279d == iO && ((k7 = bVar.f13276a) == obj || (obj != null && obj.equals(k7)))) {
                this.f13273g++;
                this.f13270d--;
                if (bVar2 == bVar) {
                    this.f13269c[iR] = bVar3;
                } else {
                    bVar2.f13278c = bVar3;
                }
                bVar.b(this);
                return bVar;
            }
            bVar2 = bVar;
            bVar = bVar3;
        }
        return bVar;
    }

    final b<K, V> H(Object obj) {
        int iO;
        if (!(obj instanceof Map.Entry)) {
            return null;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        if (key == null) {
            iO = 0;
        } else {
            iO = key instanceof String ? o(q((String) key)) : o(key.hashCode());
        }
        int iR = r(iO, this.f13269c.length);
        b<K, V> bVar = this.f13269c[iR];
        b<K, V> bVar2 = bVar;
        while (bVar != null) {
            b<K, V> bVar3 = bVar.f13278c;
            if (bVar.f13279d == iO && bVar.equals(entry)) {
                this.f13273g++;
                this.f13270d--;
                if (bVar2 == bVar) {
                    this.f13269c[iR] = bVar3;
                } else {
                    bVar2.f13278c = bVar3;
                }
                bVar.b(this);
                return bVar;
            }
            bVar2 = bVar;
            bVar = bVar3;
        }
        return bVar;
    }

    void I(int i7) {
        if (this.f13269c.length == 1073741824) {
            this.f13271e = Integer.MAX_VALUE;
            return;
        }
        b<K, V>[] bVarArr = new b[i7];
        J(bVarArr);
        this.f13269c = bVarArr;
        this.f13271e = (int) (i7 * this.f13272f);
    }

    void J(b[] bVarArr) {
        b<K, V>[] bVarArr2 = this.f13269c;
        int length = bVarArr.length;
        for (int i7 = 0; i7 < bVarArr2.length; i7++) {
            b<K, V> bVar = bVarArr2[i7];
            if (bVar != null) {
                bVarArr2[i7] = null;
                while (true) {
                    b<K, V> bVar2 = bVar.f13278c;
                    int iR = r(bVar.f13279d, length);
                    bVar.f13278c = bVarArr[iR];
                    bVarArr[iR] = bVar;
                    if (bVar2 == null) {
                        break;
                    } else {
                        bVar = bVar2;
                    }
                }
            }
        }
    }

    void a(int i7, K k7, V v7, int i8) {
        b<K, V>[] bVarArr = this.f13269c;
        bVarArr[i8] = new b<>(i7, k7, v7, bVarArr[i8]);
        int i9 = this.f13270d;
        this.f13270d = i9 + 1;
        if (i9 >= this.f13271e) {
            I(this.f13269c.length * 2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f13273g++;
        b<K, V>[] bVarArr = this.f13269c;
        for (int i7 = 0; i7 < bVarArr.length; i7++) {
            bVarArr[i7] = null;
        }
        this.f13270d = 0;
    }

    @Override // java.util.AbstractMap
    public Object clone() {
        c cVar;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException unused) {
            cVar = null;
        }
        cVar.f13269c = new b[this.f13269c.length];
        cVar.f13275i = null;
        cVar.f13273g = 0;
        cVar.f13270d = 0;
        cVar.t();
        cVar.B(this);
        return cVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return m(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        if (obj == null) {
            return i();
        }
        for (b<K, V> bVar : this.f13269c) {
            for (; bVar != null; bVar = bVar.f13278c) {
                if (obj.equals(bVar.f13277b)) {
                    return true;
                }
            }
        }
        return false;
    }

    int e() {
        return this.f13269c.length;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return l();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        K k7;
        if (obj == null) {
            return n();
        }
        int iO = obj instanceof String ? o(q((String) obj)) : o(obj.hashCode());
        b<K, V>[] bVarArr = this.f13269c;
        for (b<K, V> bVar = bVarArr[r(iO, bVarArr.length)]; bVar != null; bVar = bVar.f13278c) {
            if (bVar.f13279d == iO && ((k7 = bVar.f13276a) == obj || obj.equals(k7))) {
                return bVar.f13277b;
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return this.f13270d == 0;
    }

    void k(int i7, K k7, V v7, int i8) {
        b<K, V>[] bVarArr = this.f13269c;
        bVarArr[i8] = new b<>(i7, k7, v7, bVarArr[i8]);
        this.f13270d++;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        Set<K> set = this.f13267a;
        if (set != null) {
            return set;
        }
        g gVar = new g();
        this.f13267a = gVar;
        return gVar;
    }

    final b<K, V> m(Object obj) {
        K k7;
        int iO = obj == null ? 0 : obj instanceof String ? o(q((String) obj)) : o(obj.hashCode());
        for (b<K, V> bVar = r1[r(iO, this.f13269c.length)]; bVar != null; bVar = bVar.f13278c) {
            if (bVar.f13279d == iO && ((k7 = bVar.f13276a) == obj || (obj != null && obj.equals(k7)))) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k7, V v7) {
        K k8;
        if (k7 == 0) {
            return D(v7);
        }
        int iO = k7 instanceof String ? o(q((String) k7)) : o(k7.hashCode());
        int iR = r(iO, this.f13269c.length);
        for (b<K, V> bVar = this.f13269c[iR]; bVar != null; bVar = bVar.f13278c) {
            if (bVar.f13279d == iO && ((k8 = bVar.f13276a) == k7 || k7.equals(k8))) {
                V v8 = bVar.f13277b;
                bVar.f13277b = v7;
                bVar.a(this);
                return v8;
            }
        }
        this.f13273g++;
        a(iO, k7, v7, iR);
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        int size = map.size();
        if (size == 0) {
            return;
        }
        if (size > this.f13271e) {
            int i7 = (int) ((size / this.f13272f) + 1.0f);
            if (i7 > 1073741824) {
                i7 = 1073741824;
            }
            int length = this.f13269c.length;
            while (length < i7) {
                length <<= 1;
            }
            if (length > this.f13269c.length) {
                I(length);
            }
        }
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        b<K, V> bVarE = E(obj);
        if (bVarE == null) {
            return null;
        }
        return bVarE.f13277b;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f13270d;
    }

    void t() {
    }

    float u() {
        return this.f13272f;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        Collection<V> collection = this.f13268b;
        if (collection != null) {
            return collection;
        }
        i iVar = new i();
        this.f13268b = iVar;
        return iVar;
    }

    Iterator<Map.Entry<K, V>> w() {
        return new C0153c();
    }

    Iterator<K> y() {
        return new f();
    }

    Iterator<V> z() {
        return new h();
    }

    public c(int i7) {
        this(i7, 0.75f);
    }

    public c() {
        this.f13267a = null;
        this.f13268b = null;
        this.f13274h = new Random().nextInt(99999);
        this.f13275i = null;
        this.f13272f = 0.75f;
        this.f13271e = 12;
        this.f13269c = new b[16];
        t();
    }

    public c(Map<? extends K, ? extends V> map) {
        this(Math.max(((int) (map.size() / 0.75f)) + 1, 16), 0.75f);
        B(map);
    }
}
