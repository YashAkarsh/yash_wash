package com.google.android.gms.internal.location;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class p0 extends q0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient int f16155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final transient int f16156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ q0 f16157e;

    p0(q0 q0Var, int i7, int i8) {
        this.f16157e = q0Var;
        this.f16155c = i7;
        this.f16156d = i8;
    }

    @Override // com.google.android.gms.internal.location.n0
    final Object[] b() {
        return this.f16157e.b();
    }

    @Override // com.google.android.gms.internal.location.n0
    final int d() {
        return this.f16157e.d() + this.f16155c;
    }

    @Override // com.google.android.gms.internal.location.n0
    final int f() {
        return this.f16157e.d() + this.f16155c + this.f16156d;
    }

    @Override // java.util.List
    public final Object get(int i7) {
        k0.a(i7, this.f16156d, "index");
        return this.f16157e.get(i7 + this.f16155c);
    }

    @Override // com.google.android.gms.internal.location.n0
    final boolean h() {
        return true;
    }

    @Override // com.google.android.gms.internal.location.q0
    /* JADX INFO: renamed from: k */
    public final q0 subList(int i7, int i8) {
        k0.c(i7, i8, this.f16156d);
        q0 q0Var = this.f16157e;
        int i9 = this.f16155c;
        return q0Var.subList(i7 + i9, i8 + i9);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f16156d;
    }

    @Override // com.google.android.gms.internal.location.q0, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i7, int i8) {
        return subList(i7, i8);
    }
}
