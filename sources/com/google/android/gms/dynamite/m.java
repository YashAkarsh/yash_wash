package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class m implements DynamiteModule.b {
    m() {
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001c A[DONT_INVERT, PHI: r4
      0x001c: PHI (r4v2 int) = (r4v1 int), (r4v3 int) binds: [B:3:0x0014, B:5:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:8:0x001e  */
    /* JADX WARN: Code duplicated, block: B:9:0x0021  */
    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0186b a(Context context, String str, DynamiteModule.b.a aVar) throws DynamiteModule.a {
        DynamiteModule.b.C0186b c0186b = new DynamiteModule.b.C0186b();
        c0186b.f16057a = aVar.b(context, str);
        int iA = aVar.a(context, str, true);
        c0186b.f16058b = iA;
        int i7 = c0186b.f16057a;
        if (i7 == 0) {
            i7 = 0;
            if (iA == 0) {
                c0186b.f16059c = 0;
            } else if (iA >= i7) {
                c0186b.f16059c = 1;
            } else {
                c0186b.f16059c = -1;
            }
        } else if (iA >= i7) {
            c0186b.f16059c = 1;
        } else {
            c0186b.f16059c = -1;
        }
        return c0186b;
    }
}
