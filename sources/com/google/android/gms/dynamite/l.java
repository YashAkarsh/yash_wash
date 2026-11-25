package com.google.android.gms.dynamite;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class l implements DynamiteModule.b {
    l() {
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.b
    public final DynamiteModule.b.C0186b a(Context context, String str, DynamiteModule.b.a aVar) throws DynamiteModule.a {
        int iA;
        DynamiteModule.b.C0186b c0186b = new DynamiteModule.b.C0186b();
        int iB = aVar.b(context, str);
        c0186b.f16057a = iB;
        int i7 = 0;
        if (iB != 0) {
            iA = aVar.a(context, str, false);
            c0186b.f16058b = iA;
        } else {
            iA = aVar.a(context, str, true);
            c0186b.f16058b = iA;
        }
        int i8 = c0186b.f16057a;
        if (i8 == 0) {
            if (iA == 0) {
                c0186b.f16059c = 0;
            }
            return c0186b;
        }
        i7 = i8;
        if (i7 >= iA) {
            c0186b.f16059c = -1;
        } else {
            c0186b.f16059c = 1;
        }
        return c0186b;
    }
}
