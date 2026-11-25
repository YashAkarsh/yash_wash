package com.google.android.gms.internal.common;

/* JADX INFO: loaded from: classes.dex */
final class e0 extends h0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ f0 f16097h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    e0(f0 f0Var, i0 i0Var, CharSequence charSequence) {
        super(i0Var, charSequence);
        this.f16097h = f0Var;
    }

    @Override // com.google.android.gms.internal.common.h0
    final int c(int i7) {
        return i7 + 1;
    }

    @Override // com.google.android.gms.internal.common.h0
    final int d(int i7) {
        z zVar = this.f16097h.f16099a;
        CharSequence charSequence = this.f16106c;
        int length = charSequence.length();
        d0.b(i7, length, "index");
        while (i7 < length) {
            if (zVar.a(charSequence.charAt(i7))) {
                return i7;
            }
            i7++;
        }
        return -1;
    }
}
