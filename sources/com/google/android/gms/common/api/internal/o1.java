package com.google.android.gms.common.api.internal;

import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExecutorService f15361a = com.google.android.gms.internal.base.o.a().b(2, new com.google.android.gms.common.util.concurrent.c("GAC_Executor"), 2);

    public static ExecutorService a() {
        return f15361a;
    }
}
