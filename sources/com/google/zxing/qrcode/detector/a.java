package com.google.zxing.qrcode.detector;

import com.google.zxing.t;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f24178c;

    a(float f8, float f9, float f10) {
        super(f8, f9);
        this.f24178c = f10;
    }

    boolean f(float f8, float f9, float f10) {
        if (Math.abs(f9 - d()) > f8 || Math.abs(f10 - c()) > f8) {
            return false;
        }
        float fAbs = Math.abs(f8 - this.f24178c);
        return fAbs <= 1.0f || fAbs <= this.f24178c;
    }

    a g(float f8, float f9, float f10) {
        return new a((c() + f9) / 2.0f, (d() + f8) / 2.0f, (this.f24178c + f10) / 2.0f);
    }
}
