package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class p0 extends q0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Callable<String> f15875e;

    /* synthetic */ p0(Callable callable, o0 o0Var) {
        super(false, null, null);
        this.f15875e = callable;
    }

    @Override // com.google.android.gms.common.q0
    final String a() {
        try {
            return this.f15875e.call();
        } catch (Exception e8) {
            throw new RuntimeException(e8);
        }
    }
}
