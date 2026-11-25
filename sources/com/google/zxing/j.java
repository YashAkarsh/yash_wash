package com.google.zxing;

import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f23739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23740b;

    protected j(int i7, int i8) {
        this.f23739a = i7;
        this.f23740b = i8;
    }

    public j a(int i7, int i8, int i9, int i10) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public final int b() {
        return this.f23740b;
    }

    public abstract byte[] c();

    public abstract byte[] d(int i7, byte[] bArr);

    public final int e() {
        return this.f23739a;
    }

    public j f() {
        return new i(this);
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public j i() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public j j() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final String toString() {
        char c8;
        int i7 = this.f23739a;
        byte[] bArrD = new byte[i7];
        StringBuilder sb = new StringBuilder(this.f23740b * (i7 + 1));
        for (int i8 = 0; i8 < this.f23740b; i8++) {
            bArrD = d(i8, bArrD);
            for (int i9 = 0; i9 < this.f23739a; i9++) {
                int i10 = bArrD[i9] & 255;
                if (i10 < 64) {
                    c8 = '#';
                } else if (i10 < 128) {
                    c8 = '+';
                } else {
                    c8 = i10 < 192 ? ClassUtils.PACKAGE_SEPARATOR_CHAR : ' ';
                }
                sb.append(c8);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
