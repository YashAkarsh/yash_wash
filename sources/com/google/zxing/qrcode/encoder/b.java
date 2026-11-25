package com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[][] f24207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f24208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f24209c;

    public b(int i7, int i8) {
        this.f24207a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i8, i7);
        this.f24208b = i7;
        this.f24209c = i8;
    }

    public void a(byte b8) {
        for (byte[] bArr : this.f24207a) {
            Arrays.fill(bArr, b8);
        }
    }

    public byte b(int i7, int i8) {
        return this.f24207a[i8][i7];
    }

    public byte[][] c() {
        return this.f24207a;
    }

    public int d() {
        return this.f24209c;
    }

    public int e() {
        return this.f24208b;
    }

    public void f(int i7, int i8, byte b8) {
        this.f24207a[i8][i7] = b8;
    }

    public void g(int i7, int i8, int i9) {
        this.f24207a[i8][i7] = (byte) i9;
    }

    public void h(int i7, int i8, boolean z7) {
        this.f24207a[i8][i7] = z7 ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f24208b * 2 * this.f24209c) + 2);
        for (int i7 = 0; i7 < this.f24209c; i7++) {
            byte[] bArr = this.f24207a[i7];
            for (int i8 = 0; i8 < this.f24208b; i8++) {
                byte b8 = bArr[i8];
                if (b8 == 0) {
                    sb.append(" 0");
                } else if (b8 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
