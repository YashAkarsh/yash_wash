package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class j implements DynamiteModule.b {
    j() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0186b a(Context context, String str, DynamiteModule.b.a aVar) throws DynamiteModule.a {
        DynamiteModule.b.C0186b c0186b = new DynamiteModule.b.C0186b();
        int iA = aVar.a(context, str, false);
        c0186b.f16058b = iA;
        if (iA == 0) {
            c0186b.f16059c = 0;
        } else {
            c0186b.f16059c = 1;
        }
        return c0186b;
    }
}
