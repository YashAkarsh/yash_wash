package com.alibaba.fastjson;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
public class b extends a implements List<Object>, Cloneable, RandomAccess, Serializable {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final long f12651n = 1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List<Object> f12652k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected transient Object f12653l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected transient Type f12654m;

    public b() {
        this.f12652k = new ArrayList();
    }

    public Short A1(int i7) {
        return com.alibaba.fastjson.util.l.w(get(i7));
    }

    public short B1(int i7) {
        Object obj = get(i7);
        if (obj == null) {
            return (short) 0;
        }
        return com.alibaba.fastjson.util.l.w(obj).shortValue();
    }

    public Date C1(int i7) {
        return com.alibaba.fastjson.util.l.x(get(i7));
    }

    public String D1(int i7) {
        return com.alibaba.fastjson.util.l.z(get(i7));
    }

    public Timestamp E1(int i7) {
        return com.alibaba.fastjson.util.l.A(get(i7));
    }

    public void F1(Type type) {
        this.f12654m = type;
    }

    public void G1(Object obj) {
        this.f12653l = obj;
    }

    public <T> List<T> H1(Class<T> cls) {
        ArrayList arrayList = new ArrayList(size());
        com.alibaba.fastjson.parser.j jVarQ = com.alibaba.fastjson.parser.j.q();
        Iterator<Object> it = iterator();
        while (it.hasNext()) {
            arrayList.add(com.alibaba.fastjson.util.l.e(it.next(), cls, jVarQ));
        }
        return arrayList;
    }

    public b V0(int i7, Object obj) {
        this.f12652k.add(i7, obj);
        return this;
    }

    public b W0(Object obj) {
        this.f12652k.add(obj);
        return this;
    }

    public b X0(int i7, Collection<? extends Object> collection) {
        this.f12652k.addAll(i7, collection);
        return this;
    }

    public b Y0(Collection<? extends Object> collection) {
        this.f12652k.addAll(collection);
        return this;
    }

    public b Z0() {
        this.f12652k.clear();
        return this;
    }

    public b a1(int i7) {
        this.f12652k.remove(i7);
        return this;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        return this.f12652k.add(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Object> collection) {
        return this.f12652k.addAll(collection);
    }

    public b b1(Object obj) {
        this.f12652k.remove(obj);
        return this;
    }

    public b c1(Collection<?> collection) {
        this.f12652k.removeAll(collection);
        return this;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f12652k.clear();
    }

    public Object clone() {
        return new b(new ArrayList(this.f12652k));
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f12652k.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.f12652k.containsAll(collection);
    }

    public b d1(Collection<?> collection) {
        this.f12652k.retainAll(collection);
        return this;
    }

    public b e1(int i7, Object obj) {
        set(i7, obj);
        return this;
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return this.f12652k.equals(obj);
    }

    public BigDecimal f1(int i7) {
        return com.alibaba.fastjson.util.l.h(get(i7));
    }

    public BigInteger g1(int i7) {
        return com.alibaba.fastjson.util.l.i(get(i7));
    }

    @Override // java.util.List
    public Object get(int i7) {
        return this.f12652k.get(i7);
    }

    public Boolean h1(int i7) {
        Object obj = get(i7);
        if (obj == null) {
            return null;
        }
        return com.alibaba.fastjson.util.l.j(obj);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f12652k.hashCode();
    }

    public boolean i1(int i7) {
        Object obj = get(i7);
        if (obj == null) {
            return false;
        }
        return com.alibaba.fastjson.util.l.j(obj).booleanValue();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f12652k.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f12652k.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return this.f12652k.iterator();
    }

    public Byte j1(int i7) {
        return com.alibaba.fastjson.util.l.k(get(i7));
    }

    public byte k1(int i7) {
        Object obj = get(i7);
        if (obj == null) {
            return (byte) 0;
        }
        return com.alibaba.fastjson.util.l.k(obj).byteValue();
    }

    public Type l1() {
        return this.f12654m;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f12652k.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator() {
        return this.f12652k.listIterator();
    }

    public java.util.Date m1(int i7) {
        return com.alibaba.fastjson.util.l.n(get(i7));
    }

    public Double n1(int i7) {
        return com.alibaba.fastjson.util.l.p(get(i7));
    }

    public double o1(int i7) {
        Object obj = get(i7);
        if (obj == null) {
            return 0.0d;
        }
        return com.alibaba.fastjson.util.l.p(obj).doubleValue();
    }

    public Float p1(int i7) {
        return com.alibaba.fastjson.util.l.r(get(i7));
    }

    public float q1(int i7) {
        Object obj = get(i7);
        if (obj == null) {
            return 0.0f;
        }
        return com.alibaba.fastjson.util.l.r(obj).floatValue();
    }

    public int r1(int i7) {
        Object obj = get(i7);
        if (obj == null) {
            return 0;
        }
        return com.alibaba.fastjson.util.l.s(obj).intValue();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.f12652k.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.f12652k.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return this.f12652k.retainAll(collection);
    }

    public Integer s1(int i7) {
        return com.alibaba.fastjson.util.l.s(get(i7));
    }

    @Override // java.util.List
    public Object set(int i7, Object obj) {
        if (i7 == -1) {
            this.f12652k.add(obj);
            return null;
        }
        if (this.f12652k.size() > i7) {
            return this.f12652k.set(i7, obj);
        }
        for (int size = this.f12652k.size(); size < i7; size++) {
            this.f12652k.add(null);
        }
        this.f12652k.add(obj);
        return null;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f12652k.size();
    }

    @Override // java.util.List
    public List<Object> subList(int i7, int i8) {
        return this.f12652k.subList(i7, i8);
    }

    public b t1(int i7) {
        Object obj = this.f12652k.get(i7);
        return obj instanceof b ? (b) obj : (b) a.i0(obj);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f12652k.toArray();
    }

    public e u1(int i7) {
        Object obj = this.f12652k.get(i7);
        return obj instanceof e ? (e) obj : (e) a.i0(obj);
    }

    public Long v1(int i7) {
        return com.alibaba.fastjson.util.l.v(get(i7));
    }

    public long w1(int i7) {
        Object obj = get(i7);
        if (obj == null) {
            return 0L;
        }
        return com.alibaba.fastjson.util.l.v(obj).longValue();
    }

    public <T> T x1(int i7, Class<T> cls) {
        return (T) com.alibaba.fastjson.util.l.t(this.f12652k.get(i7), cls);
    }

    public <T> T y1(int i7, Type type) {
        Object obj = this.f12652k.get(i7);
        return type instanceof Class ? (T) com.alibaba.fastjson.util.l.t(obj, (Class) type) : (T) a.a0(a.y0(obj), type, new com.alibaba.fastjson.parser.c[0]);
    }

    public Object z1() {
        return this.f12653l;
    }

    @Override // java.util.List
    public void add(int i7, Object obj) {
        this.f12652k.add(i7, obj);
    }

    @Override // java.util.List
    public boolean addAll(int i7, Collection<? extends Object> collection) {
        return this.f12652k.addAll(i7, collection);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator(int i7) {
        return this.f12652k.listIterator(i7);
    }

    @Override // java.util.List
    public Object remove(int i7) {
        return this.f12652k.remove(i7);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.f12652k.toArray(tArr);
    }

    public b(List<Object> list) {
        this.f12652k = list;
    }

    public b(int i7) {
        this.f12652k = new ArrayList(i7);
    }
}
