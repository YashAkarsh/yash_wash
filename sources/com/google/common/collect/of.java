package com.google.common.collect;

/* JADX INFO: loaded from: classes2.dex */
@s1.b(emulated = true, serializable = true)
final class of<E> extends u8<E> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final transient E f20855j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @v1.b
    private transient int f20856k;

    of(E e8) {
        this.f20855j = (E) com.google.common.base.e0.E(e8);
    }

    @Override // com.google.common.collect.x6
    int b(Object[] objArr, int i7) {
        objArr[i7] = this.f20855j;
        return i7 + 1;
    }

    @Override // com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f20855j.equals(obj);
    }

    @Override // com.google.common.collect.x6
    boolean h() {
        return false;
    }

    @Override // com.google.common.collect.u8, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i7 = this.f20856k;
        if (i7 != 0) {
            return i7;
        }
        int iHashCode = this.f20855j.hashCode();
        this.f20856k = iHashCode;
        return iHashCode;
    }

    @Override // com.google.common.collect.u8, com.google.common.collect.x6, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: j */
    public ck<E> iterator() {
        return ua.Y(this.f20855j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.f20855j.toString() + ']';
    }

    @Override // com.google.common.collect.u8
    d7<E> v() {
        return d7.z(this.f20855j);
    }

    @Override // com.google.common.collect.u8
    boolean x() {
        return this.f20856k != 0;
    }

    of(E e8, int i7) {
        this.f20855j = e8;
        this.f20856k = i7;
    }
}
