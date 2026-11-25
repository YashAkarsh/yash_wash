package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class t4<K extends Enum<K>, V extends Enum<V>> extends c<K, V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @s1.c
    private static final long f21102i = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient Class<K> f21103g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient Class<V> f21104h;

    private t4(Class<K> cls, Class<V> cls2) {
        super(gk.t0(new EnumMap(cls)), gk.t0(new EnumMap(cls2)));
        this.f21103g = cls;
        this.f21104h = cls2;
    }

    public static <K extends Enum<K>, V extends Enum<V>> t4<K, V> K0(Class<K> cls, Class<V> cls2) {
        return new t4<>(cls, cls2);
    }

    public static <K extends Enum<K>, V extends Enum<V>> t4<K, V> L0(Map<K, V> map) {
        t4<K, V> t4VarK0 = K0(M0(map), N0(map));
        t4VarK0.putAll(map);
        return t4VarK0;
    }

    static <K extends Enum<K>> Class<K> M0(Map<K, ?> map) {
        if (map instanceof t4) {
            return ((t4) map).O0();
        }
        if (map instanceof u4) {
            return ((u4) map).M0();
        }
        com.google.common.base.e0.d(!map.isEmpty());
        return map.keySet().iterator().next().getDeclaringClass();
    }

    private static <V extends Enum<V>> Class<V> N0(Map<?, V> map) {
        if (map instanceof t4) {
            return ((t4) map).f21104h;
        }
        com.google.common.base.e0.d(!map.isEmpty());
        return map.values().iterator().next().getDeclaringClass();
    }

    @s1.c
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f21103g = (Class) objectInputStream.readObject();
        this.f21104h = (Class) objectInputStream.readObject();
        F0(gk.t0(new EnumMap(this.f21103g)), gk.t0(new EnumMap(this.f21104h)));
        se.b(this, objectInputStream);
    }

    @s1.c
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f21103g);
        objectOutputStream.writeObject(this.f21104h);
        se.i(this, objectOutputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public K y0(K k7) {
        return (K) com.google.common.base.e0.E(k7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public V z0(V v7) {
        return (V) com.google.common.base.e0.E(v7);
    }

    public Class<K> O0() {
        return this.f21103g;
    }

    public Class<V> P0() {
        return this.f21104h;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.r0
    public /* bridge */ /* synthetic */ r0 T() {
        return super.T();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.u5, java.util.Map
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.u5, java.util.Map
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.u5, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.u5, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.c, com.google.common.collect.u5, java.util.Map, com.google.common.collect.r0
    public /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    @Override // com.google.common.collect.c, java.util.Map
    public /* bridge */ /* synthetic */ void replaceAll(BiFunction biFunction) {
        super.replaceAll(biFunction);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.u5, java.util.Map, com.google.common.collect.r0
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }
}
