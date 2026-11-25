package com.haier.library.json;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes2.dex */
public class b extends a implements Serializable, Cloneable, List<Object>, RandomAccess {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List<Object> f26651h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected transient Object f26652i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected transient Type f26653j;

    public b() {
        this.f26651h = new ArrayList(10);
    }

    public byte A0(int i7) {
        Object obj = get(i7);
        if (obj == null) {
            return (byte) 0;
        }
        return i3.d.g(obj).byteValue();
    }

    public Type B0() {
        return this.f26653j;
    }

    public Date C0(int i7) {
        return i3.d.j(get(i7));
    }

    public Double D0(int i7) {
        return i3.d.k(get(i7));
    }

    public double E0(int i7) {
        Object obj = get(i7);
        if (obj == null) {
            return 0.0d;
        }
        return i3.d.k(obj).doubleValue();
    }

    public Float F0(int i7) {
        return i3.d.m(get(i7));
    }

    public float G0(int i7) {
        Object obj = get(i7);
        if (obj == null) {
            return 0.0f;
        }
        return i3.d.m(obj).floatValue();
    }

    public int H0(int i7) {
        Object obj = get(i7);
        if (obj == null) {
            return 0;
        }
        return i3.d.n(obj).intValue();
    }

    public Integer I0(int i7) {
        return i3.d.n(get(i7));
    }

    public b J0(int i7) {
        Object obj = this.f26651h.get(i7);
        return obj instanceof b ? (b) obj : (b) a.P(obj);
    }

    public e K0(int i7) {
        Object obj = this.f26651h.get(i7);
        return obj instanceof e ? (e) obj : (e) a.P(obj);
    }

    public Long L0(int i7) {
        return i3.d.q(get(i7));
    }

    public long M0(int i7) {
        Object obj = get(i7);
        if (obj == null) {
            return 0L;
        }
        return i3.d.q(obj).longValue();
    }

    public <T> T N0(int i7, Class<T> cls) {
        return (T) i3.d.o(this.f26651h.get(i7), cls);
    }

    public Object O0() {
        return this.f26652i;
    }

    public Short P0(int i7) {
        return i3.d.r(get(i7));
    }

    public short Q0(int i7) {
        Object obj = get(i7);
        if (obj == null) {
            return (short) 0;
        }
        return i3.d.r(obj).shortValue();
    }

    public String R0(int i7) {
        return i3.d.s(get(i7));
    }

    public void S0(Type type) {
        this.f26653j = type;
    }

    public void T0(Object obj) {
        this.f26652i = obj;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        return this.f26651h.add(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends Object> collection) {
        return this.f26651h.addAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        this.f26651h.clear();
    }

    public Object clone() {
        return new b(new ArrayList(this.f26651h));
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return this.f26651h.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return this.f26651h.containsAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return this.f26651h.equals(obj);
    }

    @Override // java.util.List
    public Object get(int i7) {
        return this.f26651h.get(i7);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f26651h.hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return this.f26651h.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f26651h.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return this.f26651h.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return this.f26651h.lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator() {
        return this.f26651h.listIterator();
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        return this.f26651h.remove(obj);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return this.f26651h.removeAll(collection);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return this.f26651h.retainAll(collection);
    }

    @Override // java.util.List
    public Object set(int i7, Object obj) {
        return this.f26651h.set(i7, obj);
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.f26651h.size();
    }

    @Override // java.util.List
    public List<Object> subList(int i7, int i8) {
        return this.f26651h.subList(i7, i8);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return this.f26651h.toArray();
    }

    public BigDecimal u0(int i7) {
        return i3.d.d(get(i7));
    }

    public BigInteger w0(int i7) {
        return i3.d.e(get(i7));
    }

    public Boolean x0(int i7) {
        Object obj = get(i7);
        if (obj == null) {
            return null;
        }
        return i3.d.f(obj);
    }

    public boolean y0(int i7) {
        Object obj = get(i7);
        if (obj == null) {
            return false;
        }
        return i3.d.f(obj).booleanValue();
    }

    public Byte z0(int i7) {
        return i3.d.g(get(i7));
    }

    @Override // java.util.List
    public void add(int i7, Object obj) {
        this.f26651h.add(i7, obj);
    }

    @Override // java.util.List
    public boolean addAll(int i7, Collection<? extends Object> collection) {
        return this.f26651h.addAll(i7, collection);
    }

    @Override // java.util.List
    public ListIterator<Object> listIterator(int i7) {
        return this.f26651h.listIterator(i7);
    }

    @Override // java.util.List
    public Object remove(int i7) {
        return this.f26651h.remove(i7);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.f26651h.toArray(tArr);
    }

    public b(List<Object> list) {
        this.f26651h = list;
    }

    public b(int i7) {
        this.f26651h = new ArrayList(i7);
    }
}
