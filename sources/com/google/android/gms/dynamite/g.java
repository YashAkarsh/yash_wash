package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class g implements DynamiteModule.b.a {
    g() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.b.a
    public final int a(Context context, String str, boolean z7) throws DynamiteModule.a {
        return DynamiteModule.f(context, str, z7);
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.b.a
    public final int b(Context context, String str) {
        return DynamiteModule.a(context, str);
    }
}
