package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a.d;

/* JADX INFO: loaded from: classes.dex */
public final class c<O extends com.google.android.gms.common.api.a.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f15169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.gms.common.api.a<O> f15170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.o0
    private final O f15171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.o0
    private final String f15172d;

    private c(com.google.android.gms.common.api.a<O> aVar, @c.o0 O o7, @c.o0 String str) {
        this.f15170b = aVar;
        this.f15171c = o7;
        this.f15172d = str;
        this.f15169a = com.google.android.gms.common.internal.s.c(aVar, o7, str);
    }

    @c.m0
    public static <O extends com.google.android.gms.common.api.a.d> c<O> a(@c.m0 com.google.android.gms.common.api.a<O> aVar, @c.o0 O o7, @c.o0 String str) {
        return new c<>(aVar, o7, str);
    }

    @c.m0
    public final String b() {
        return this.f15170b.d();
    }

    public final boolean equals(@c.o0 Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return com.google.android.gms.common.internal.s.b(this.f15170b, cVar.f15170b) && com.google.android.gms.common.internal.s.b(this.f15171c, cVar.f15171c) && com.google.android.gms.common.internal.s.b(this.f15172d, cVar.f15172d);
    }

    public final int hashCode() {
        return this.f15169a;
    }
}
