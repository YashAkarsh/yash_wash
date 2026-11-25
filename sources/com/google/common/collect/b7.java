package com.google.common.collect;

import java.io.Serializable;
import java.lang.Enum;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
final class b7<E extends Enum<E>> extends u8<E> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final transient EnumSet<E> f19956j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @v1.b
    private transient int f19957k;

    private static class b<E extends Enum<E>> implements Serializable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f19958b = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final EnumSet<E> f19959a;

        b(EnumSet<E> enumSet) {
            this.f19959a = enumSet;
        }

        Object readResolve() {
            return new b7(this.f19959a.clone());
        }
    }

    static u8 M(EnumSet enumSet) {
        int size = enumSet.size();
        if (size != 0) {
            return size != 1 ? new b7(enumSet) : u8.B(ma.z(enumSet));
        }
        return u8.A();
    }

    @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f19956j.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof b7) {
            collection = ((b7) collection).f19956j;
        }
        return this.f19956j.containsAll(collection);
    }

    @Override // com.google.common.collect.u8, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b7) {
            obj = ((b7) obj).f19956j;
        }
        return this.f19956j.equals(obj);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        this.f19956j.forEach(consumer);
    }

    @Override // com.google.common.collect.x6
    boolean h() {
        return false;
    }

    @Override // com.google.common.collect.u8, java.util.Collection, java.util.Set
    public int hashCode() {
        int i7 = this.f19957k;
        if (i7 != 0) {
            return i7;
        }
        int iHashCode = this.f19956j.hashCode();
        this.f19957k = iHashCode;
        return iHashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f19956j.isEmpty();
    }

    @Override // com.google.common.collect.u8, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public ck<E> iterator() {
        return ua.f0(this.f19956j.iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f19956j.size();
    }

    @Override // com.google.common.collect.x6, java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator<E> spliterator() {
        return this.f19956j.spliterator();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return this.f19956j.toString();
    }

    @Override // com.google.common.collect.u8, com.google.common.collect.x6
    Object writeReplace() {
        return new b(this.f19956j);
    }

    @Override // com.google.common.collect.u8
    boolean x() {
        return true;
    }

    private b7(EnumSet<E> enumSet) {
        this.f19956j = enumSet;
    }
}
