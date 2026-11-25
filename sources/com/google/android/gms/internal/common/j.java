package com.google.android.gms.internal.common;

/* JADX INFO: loaded from: classes.dex */
final class j<E> extends h<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final h<Object> f16114e = new j(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient Object[] f16115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient int f16116d;

    j(Object[] objArr, int i7) {
        this.f16115c = objArr;
        this.f16116d = i7;
    }

    @Override // com.google.android.gms.internal.common.h, com.google.android.gms.internal.common.d
    final int a(Object[] objArr, int i7) {
        System.arraycopy(this.f16115c, 0, objArr, 0, this.f16116d);
        return this.f16116d;
    }

    @Override // com.google.android.gms.internal.common.d
    final int b() {
        return this.f16116d;
    }

    @Override // com.google.android.gms.internal.common.d
    final int d() {
        return 0;
    }

    @Override // java.util.List
    public final E get(int i7) {
        d0.a(i7, this.f16116d, "index");
        E e8 = (E) this.f16115c[i7];
        e8.getClass();
        return e8;
    }

    @Override // com.google.android.gms.internal.common.d
    final boolean h() {
        return false;
    }

    @Override // com.google.android.gms.internal.common.d
    final Object[] j() {
        return this.f16115c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f16116d;
    }
}
