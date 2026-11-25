package com.google.android.gms.internal.common;

import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes.dex */
final class g extends h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient int f16100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final transient int f16101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ h f16102e;

    g(h hVar, int i7, int i8) {
        this.f16102e = hVar;
        this.f16100c = i7;
        this.f16101d = i8;
    }

    @Override // com.google.android.gms.internal.common.d
    final int b() {
        return this.f16102e.d() + this.f16100c + this.f16101d;
    }

    @Override // com.google.android.gms.internal.common.d
    final int d() {
        return this.f16102e.d() + this.f16100c;
    }

    @Override // java.util.List
    public final Object get(int i7) {
        d0.a(i7, this.f16101d, "index");
        return this.f16102e.get(i7 + this.f16100c);
    }

    @Override // com.google.android.gms.internal.common.d
    final boolean h() {
        return true;
    }

    @Override // com.google.android.gms.internal.common.d
    @CheckForNull
    final Object[] j() {
        return this.f16102e.j();
    }

    @Override // com.google.android.gms.internal.common.h
    /* JADX INFO: renamed from: k */
    public final h subList(int i7, int i8) {
        d0.c(i7, i8, this.f16101d);
        h hVar = this.f16102e;
        int i9 = this.f16100c;
        return hVar.subList(i7 + i9, i8 + i9);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f16101d;
    }

    @Override // com.google.android.gms.internal.common.h, java.util.List
    public final /* bridge */ /* synthetic */ List subList(int i7, int i8) {
        return subList(i7, i8);
    }
}
