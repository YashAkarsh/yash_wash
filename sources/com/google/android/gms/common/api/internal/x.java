package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class x extends k.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c1.a
    private final e.b<Status> f15450a;

    @c1.a
    public x(@c.m0 e.b<Status> bVar) {
        this.f15450a = bVar;
    }

    @Override // com.google.android.gms.common.api.internal.k
    @c1.a
    public void o2(@c.m0 Status status) {
        this.f15450a.b(status);
    }
}
