package com.google.android.gms.internal.common;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes.dex */
abstract class h0 extends u<String> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final CharSequence f16106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final z f16107d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f16108e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f16109f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f16110g = Integer.MAX_VALUE;

    protected h0(i0 i0Var, CharSequence charSequence) {
        this.f16107d = i0Var.f16111a;
        this.f16108e = i0Var.f16112b;
        this.f16106c = charSequence;
    }

    @Override // com.google.android.gms.internal.common.u
    @CheckForNull
    protected final /* bridge */ /* synthetic */ String a() {
        int iC;
        int i7 = this.f16109f;
        while (true) {
            int i8 = this.f16109f;
            if (i8 == -1) {
                b();
                return null;
            }
            int iD = d(i8);
            if (iD == -1) {
                iD = this.f16106c.length();
                this.f16109f = -1;
                iC = -1;
            } else {
                iC = c(iD);
                this.f16109f = iC;
            }
            if (iC == i7) {
                int i9 = iC + 1;
                this.f16109f = i9;
                if (i9 > this.f16106c.length()) {
                    this.f16109f = -1;
                }
            } else {
                if (i7 < iD) {
                    this.f16106c.charAt(i7);
                }
                if (i7 < iD) {
                    this.f16106c.charAt(iD - 1);
                }
                if (!this.f16108e || i7 != iD) {
                    int i10 = this.f16110g;
                    if (i10 == 1) {
                        iD = this.f16106c.length();
                        this.f16109f = -1;
                        if (iD > i7) {
                            this.f16106c.charAt(iD - 1);
                        }
                    } else {
                        this.f16110g = i10 - 1;
                    }
                    return this.f16106c.subSequence(i7, iD).toString();
                }
                i7 = this.f16109f;
            }
        }
    }

    abstract int c(int i7);

    abstract int d(int i7);
}
