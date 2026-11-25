package com.google.zxing.qrcode.detector;

import com.google.zxing.t;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f24190c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f24191d;

    d(float f8, float f9, float f10) {
        this(f8, f9, f10, 1);
    }

    boolean f(float f8, float f9, float f10) {
        if (Math.abs(f9 - d()) > f8 || Math.abs(f10 - c()) > f8) {
            return false;
        }
        float fAbs = Math.abs(f8 - this.f24190c);
        return fAbs <= 1.0f || fAbs <= this.f24190c;
    }

    d g(float f8, float f9, float f10) {
        int i7 = this.f24191d;
        int i8 = i7 + 1;
        float fC = (i7 * c()) + f9;
        float f11 = i8;
        return new d(fC / f11, ((this.f24191d * d()) + f8) / f11, ((this.f24191d * this.f24190c) + f10) / f11, i8);
    }

    int h() {
        return this.f24191d;
    }

    public float i() {
        return this.f24190c;
    }

    private d(float f8, float f9, float f10, int i7) {
        super(f8, f9);
        this.f24190c = f10;
        this.f24191d = i7;
    }
}
