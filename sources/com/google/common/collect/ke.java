package com.google.common.collect;

import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
final class ke<E> extends u8<E> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final ke<Object> f20555n = new ke<>(new Object[0], 0, null, 0);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final transient Object[] f20556j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @s1.d
    final transient Object[] f20557k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final transient int f20558l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final transient int f20559m;

    ke(Object[] objArr, int i7, Object[] objArr2, int i8) {
        this.f20556j = objArr;
        this.f20557k = objArr2;
        this.f20558l = i8;
        this.f20559m = i7;
    }

    @Override // com.google.common.collect.x6
    int b(Object[] objArr, int i7) {
        Object[] objArr2 = this.f20556j;
        System.arraycopy(objArr2, 0, objArr, i7, objArr2.length);
        return i7 + this.f20556j.length;
    }

    @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        Object[] objArr = this.f20557k;
        if (obj == null || objArr == null) {
            return false;
        }
        int iD = s6.d(obj);
        while (true) {
            int i7 = iD & this.f20558l;
            Object obj2 = objArr[i7];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iD = i7 + 1;
        }
    }

    @Override // com.google.common.collect.x6
    Object[] d() {
        return this.f20556j;
    }

    @Override // com.google.common.collect.x6
    int f() {
        return this.f20556j.length;
    }

    @Override // com.google.common.collect.x6
    int g() {
        return 0;
    }

    @Override // com.google.common.collect.x6
    boolean h() {
        return false;
    }

    @Override // com.google.common.collect.u8, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f20559m;
    }

    @Override // com.google.common.collect.u8, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public ck<E> iterator() {
        return ua.B(this.f20556j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f20556j.length;
    }

    @Override // com.google.common.collect.x6, java.util.Collection, java.lang.Iterable, java.util.Set
    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this.f20556j, 1297);
    }

    @Override // com.google.common.collect.u8
    d7<E> v() {
        return this.f20557k == null ? d7.x() : new de(this, this.f20556j);
    }

    @Override // com.google.common.collect.u8
    boolean x() {
        return true;
    }
}
