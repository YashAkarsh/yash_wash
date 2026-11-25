package com.google.common.collect;

import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
final class a7<K extends Enum<K>, V> extends v7.c<K, V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient EnumMap<K, V> f19860f;

    private static class b<K extends Enum<K>, V> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19861b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final EnumMap<K, V> f19862a;

        b(EnumMap<K, V> enumMap) {
            this.f19862a = enumMap;
        }

        Object readResolve() {
            return new a7(this.f19862a);
        }
    }

    static <K extends Enum<K>, V> v7<K, V> M(EnumMap<K, V> enumMap) {
        int size = enumMap.size();
        if (size == 0) {
            return v7.y();
        }
        if (size != 1) {
            return new a7(enumMap);
        }
        Map.Entry entry = (Map.Entry) ma.z(enumMap.entrySet());
        return v7.z(entry.getKey(), entry.getValue());
    }

    @Override // com.google.common.collect.v7.c
    ck<Map.Entry<K, V>> K() {
        return wb.U0(this.f19860f.entrySet().iterator());
    }

    @Override // com.google.common.collect.v7.c
    Spliterator<Map.Entry<K, V>> L() {
        return q2.e(this.f19860f.entrySet().spliterator(), new Function() { // from class: com.google.common.collect.z6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return wb.T0((Map.Entry) obj);
            }
        });
    }

    @Override // com.google.common.collect.v7, java.util.Map
    public boolean containsKey(Object obj) {
        return this.f19860f.containsKey(obj);
    }

    @Override // com.google.common.collect.v7, java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a7) {
            obj = ((a7) obj).f19860f;
        }
        return this.f19860f.equals(obj);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        this.f19860f.forEach(biConsumer);
    }

    @Override // com.google.common.collect.v7, java.util.Map
    public V get(Object obj) {
        return this.f19860f.get(obj);
    }

    @Override // com.google.common.collect.v7
    boolean r() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f19860f.size();
    }

    @Override // com.google.common.collect.v7
    ck<K> t() {
        return ua.f0(this.f19860f.keySet().iterator());
    }

    @Override // com.google.common.collect.v7
    Spliterator<K> w() {
        return this.f19860f.keySet().spliterator();
    }

    @Override // com.google.common.collect.v7
    Object writeReplace() {
        return new b(this.f19860f);
    }

    private a7(EnumMap<K, V> enumMap) {
        this.f19860f = enumMap;
        com.google.common.base.e0.d(!enumMap.isEmpty());
    }
}
