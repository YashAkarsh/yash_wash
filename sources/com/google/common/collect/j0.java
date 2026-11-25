package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
public final class j0<K, V> extends k0<K, V> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f20460k = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @s1.c
    private static final long f20461l = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @s1.d
    transient int f20462j;

    private j0() {
        this(12, 3);
    }

    public static <K, V> j0<K, V> V() {
        return new j0<>();
    }

    public static <K, V> j0<K, V> X(int i7, int i8) {
        return new j0<>(i7, i8);
    }

    public static <K, V> j0<K, V> Y(tc<? extends K, ? extends V> tcVar) {
        return new j0<>(tcVar);
    }

    @s1.c
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f20462j = 3;
        int iH = se.h(objectInputStream);
        O(wb.i0());
        se.e(this, objectInputStream, iH);
    }

    @s1.c
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        se.j(this, objectOutputStream);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    @u1.a
    public /* bridge */ /* synthetic */ boolean H(tc tcVar) {
        return super.H(tcVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.f, com.google.common.collect.q
    /* JADX INFO: renamed from: T */
    public List<V> z() {
        return new ArrayList(this.f20462j);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ boolean W(Object obj, Object obj2) {
        return super.W(obj, obj2);
    }

    @Deprecated
    public void Z() {
        Iterator<Collection<V>> it = y().values().iterator();
        while (it.hasNext()) {
            ((ArrayList) it.next()).trimToSize();
        }
    }

    @Override // com.google.common.collect.f, com.google.common.collect.q, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    public /* bridge */ /* synthetic */ List a(Object obj) {
        return super.a(obj);
    }

    @Override // com.google.common.collect.f, com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.f, com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.hb
    @u1.a
    public /* bridge */ /* synthetic */ List b(Object obj, Iterable iterable) {
        return super.b(obj, iterable);
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

    @Override // com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.ue
    /* JADX INFO: renamed from: entries */
    public /* bridge */ /* synthetic */ Collection y() {
        return super.y();
    }

    @Override // com.google.common.collect.f, com.google.common.collect.x, com.google.common.collect.tc, com.google.common.collect.ue
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ void forEach(BiConsumer biConsumer) {
        super.forEach(biConsumer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.f, com.google.common.collect.q, com.google.common.collect.tc, com.google.common.collect.hb
    public /* bridge */ /* synthetic */ List get(Object obj) {
        return super.get(obj);
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ hd keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.f, com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc
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

    @Override // com.google.common.collect.q, com.google.common.collect.x, com.google.common.collect.tc
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    private j0(int i7, int i8) {
        super(vd.c(i7));
        f2.b(i8, "expectedValuesPerKey");
        this.f20462j = i8;
    }

    private j0(tc<? extends K, ? extends V> tcVar) {
        this(tcVar.keySet().size(), tcVar instanceof j0 ? ((j0) tcVar).f20462j : 3);
        H(tcVar);
    }
}
