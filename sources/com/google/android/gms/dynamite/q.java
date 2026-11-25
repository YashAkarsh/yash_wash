package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class q implements DynamiteModule.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f16063a;

    public q(int i7, int i8) {
        this.f16063a = i7;
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.b.a
    public final int a(Context context, String str, boolean z7) {
        return 0;
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.b.a
    public final int b(Context context, String str) {
        return this.f16063a;
    }
}
