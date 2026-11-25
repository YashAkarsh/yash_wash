package com.google.android.gms.internal.location;

/* JADX INFO: loaded from: classes.dex */
final class r0<E> extends q0<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final q0<Object> f16161e = new r0(new Object[0], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient Object[] f16162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient int f16163d;

    r0(Object[] objArr, int i7) {
        this.f16162c = objArr;
        this.f16163d = i7;
    }

    @Override // com.google.android.gms.internal.location.n0
    final Object[] b() {
        return this.f16162c;
    }

    @Override // com.google.android.gms.internal.location.n0
    final int d() {
        return 0;
    }

    @Override // com.google.android.gms.internal.location.n0
    final int f() {
        return this.f16163d;
    }

    @Override // java.util.List
    public final E get(int i7) {
        k0.a(i7, this.f16163d, "index");
        return (E) this.f16162c[i7];
    }

    @Override // com.google.android.gms.internal.location.n0
    final boolean h() {
        return false;
    }

    @Override // com.google.android.gms.internal.location.q0, com.google.android.gms.internal.location.n0
    final int j(Object[] objArr, int i7) {
        System.arraycopy(this.f16162c, 0, objArr, 0, this.f16163d);
        return this.f16163d;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f16163d;
    }
}
