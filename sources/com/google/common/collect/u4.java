package com.google.common.collect;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true)
public final class u4<K extends Enum<K>, V> extends c<K, V> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @s1.c
    private static final long f21165h = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient Class<K> f21166g;

    private u4(Class<K> cls) {
        super(gk.t0(new EnumMap(cls)), wb.k0(cls.getEnumConstants().length));
        this.f21166g = cls;
    }

    public static <K extends Enum<K>, V> u4<K, V> J0(Class<K> cls) {
        return new u4<>(cls);
    }

    public static <K extends Enum<K>, V> u4<K, V> K0(Map<K, ? extends V> map) {
        u4<K, V> u4VarJ0 = J0(t4.M0(map));
        u4VarJ0.putAll(map);
        return u4VarJ0;
    }

    @s1.c
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f21166g = (Class) objectInputStream.readObject();
        F0(gk.t0(new EnumMap(this.f21166g)), new HashMap((this.f21166g.getEnumConstants().length * 3) / 2));
        se.b(this, objectInputStream);
    }

    @s1.c
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f21166g);
        se.i(this, objectOutputStream);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.c
    /* JADX INFO: renamed from: I0, reason: merged with bridge method [inline-methods] */
    public K y0(K k7) {
        return (K) com.google.common.base.e0.E(k7);
    }

    @Override // com.google.common.collect.c, com.google.common.collect.r0
    @u1.a
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public V x(K k7, V v7) {
        return (V) super.x(k7, v7);
    }

    public Class<K> M0() {
        return this.f21166g;
    }

    @Override // com.google.common.collect.c, com.google.common.collect.u5, java.util.Map, com.google.common.collect.r0
    @u1.a
    /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
    public V put(K k7, V v7) {
        return (V) super.put(k7, v7);
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

    @Override // com.google.common.collect.c, com.google.common.collect.u5, java.util.Map
    @u1.a
    public /* bridge */ /* synthetic */ Object remove(Object obj) {
        return super.remove(obj);
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
