package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
public class xj<K, V> extends d0<K, V> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @s1.c
    private static final long f21421m = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private transient Comparator<? super K> f21422k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private transient Comparator<? super V> f21423l;

    xj(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        super(new TreeMap(comparator));
        this.f21422k = comparator;
        this.f21423l = comparator2;
    }

    public static <K extends Comparable, V extends Comparable> xj<K, V> d0() {
        return new xj<>(td.A(), td.A());
    }

    public static <K extends Comparable, V extends Comparable> xj<K, V> e0(tc<? extends K, ? extends V> tcVar) {
        return new xj<>(td.A(), td.A(), tcVar);
    }

    public static <K, V> xj<K, V> f0(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        return new xj<>((Comparator) com.google.common.base.e0.E(comparator), (Comparator) com.google.common.base.e0.E(comparator2));
    }

    @s1.c
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f21422k = (Comparator) com.google.common.base.e0.E((Comparator) objectInputStream.readObject());
        this.f21423l = (Comparator) com.google.common.base.e0.E((Comparator) objectInputStream.readObject());
        O(new TreeMap(this.f21422k));
        se.d(this, objectInputStream);
    }

    @s1.c
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(h0());
        objectOutputStream.writeObject(valueComparator());
        se.j(this, objectOutputStream);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.q
    Collection<V> A(K k7) {
        if (k7 == 0) {
            h0().compare(k7, k7);
        }
        return super.A(k7);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    @u1.a
    public /* bridge */ /* synthetic */ boolean H(tc tcVar) {
        return super.H(tcVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.f0, com.google.common.collect.c0, com.google.common.collect.q
    /* JADX INFO: renamed from: V */
    public SortedSet<V> z() {
        return new TreeSet(this.f21423l);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ boolean W(Object obj, Object obj2) {
        return super.W(obj, obj2);
    }

    @Override // com.google.common.collect.f0, com.google.common.collect.c0, com.google.common.collect.q, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    public /* bridge */ /* synthetic */ SortedSet a(Object obj) {
        return super.a(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.f0, com.google.common.collect.c0, com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    public /* bridge */ /* synthetic */ SortedSet b(Object obj, Iterable iterable) {
        return super.b(obj, iterable);
    }

    @Override // com.google.common.collect.q, com.google.common.collect.x
    Map<K, Collection<V>> c() {
        return B();
    }

    @Override // com.google.common.collect.d0, com.google.common.collect.f0, com.google.common.collect.c0, com.google.common.collect.x, com.google.common.collect.tc
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public NavigableMap<K, Collection<V>> asMap() {
        return (NavigableMap) super.asMap();
    }

    @Override // com.google.common.collect.q, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.q, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.c0, com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.ue
    /* JADX INFO: renamed from: entries */
    public /* bridge */ /* synthetic */ Set y() {
        return super.y();
    }

    @Override // com.google.common.collect.c0, com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.ue
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ void forEach(BiConsumer biConsumer) {
        super.forEach(biConsumer);
    }

    @Override // com.google.common.collect.f0, com.google.common.collect.c0, com.google.common.collect.q, com.google.common.collect.tc, com.google.common.collect.hb
    @s1.c
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public NavigableSet<V> get(K k7) {
        return (NavigableSet) super.get((Object) k7);
    }

    @Deprecated
    public Comparator<? super K> h0() {
        return this.f21422k;
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.d0, com.google.common.collect.x, com.google.common.collect.tc
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public NavigableSet<K> keySet() {
        return (NavigableSet) super.keySet();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ hd keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.c0, com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc
    @u1.a
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.x, com.google.common.collect.tc
    @u1.a
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    @u1.a
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.q, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.x
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.bg
    public Comparator<? super V> valueComparator() {
        return this.f21423l;
    }

    @Override // com.google.common.collect.f0, com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    private xj(Comparator<? super K> comparator, Comparator<? super V> comparator2, tc<? extends K, ? extends V> tcVar) {
        this(comparator, comparator2);
        H(tcVar);
    }
}
