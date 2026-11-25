package com.google.android.gms.common.api;

import c.m0;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class e implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Status f15093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n<?>[] f15094b;

    e(Status status, n<?>[] nVarArr) {
        this.f15093a = status;
        this.f15094b = nVarArr;
    }

    @Override // com.google.android.gms.common.api.t
    @m0
    public Status G() {
        return this.f15093a;
    }

    @m0
    public <R extends t> R a(@m0 f<R> fVar) {
        com.google.android.gms.common.internal.u.b(fVar.f15096a < this.f15094b.length, "The result token does not belong to this batch");
        return (R) this.f15094b[fVar.f15096a].e(0L, TimeUnit.MILLISECONDS);
    }
}
