package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f23657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f23658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f23659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f23660d;

    public e(CharSequence charSequence, int i7, int i8) {
        this.f23657a = charSequence;
        this.f23659c = i7;
        this.f23658b = i8;
        byte[] bArr = new byte[i7 * i8];
        this.f23660d = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    private void a(int i7) {
        j(this.f23658b - 1, 0, i7, 1);
        j(this.f23658b - 1, 1, i7, 2);
        j(this.f23658b - 1, 2, i7, 3);
        j(0, this.f23659c - 2, i7, 4);
        j(0, this.f23659c - 1, i7, 5);
        j(1, this.f23659c - 1, i7, 6);
        j(2, this.f23659c - 1, i7, 7);
        j(3, this.f23659c - 1, i7, 8);
    }

    private void b(int i7) {
        j(this.f23658b - 3, 0, i7, 1);
        j(this.f23658b - 2, 0, i7, 2);
        j(this.f23658b - 1, 0, i7, 3);
        j(0, this.f23659c - 4, i7, 4);
        j(0, this.f23659c - 3, i7, 5);
        j(0, this.f23659c - 2, i7, 6);
        j(0, this.f23659c - 1, i7, 7);
        j(1, this.f23659c - 1, i7, 8);
    }

    private void c(int i7) {
        j(this.f23658b - 3, 0, i7, 1);
        j(this.f23658b - 2, 0, i7, 2);
        j(this.f23658b - 1, 0, i7, 3);
        j(0, this.f23659c - 2, i7, 4);
        j(0, this.f23659c - 1, i7, 5);
        j(1, this.f23659c - 1, i7, 6);
        j(2, this.f23659c - 1, i7, 7);
        j(3, this.f23659c - 1, i7, 8);
    }

    private void d(int i7) {
        j(this.f23658b - 1, 0, i7, 1);
        j(this.f23658b - 1, this.f23659c - 1, i7, 2);
        j(0, this.f23659c - 3, i7, 3);
        j(0, this.f23659c - 2, i7, 4);
        j(0, this.f23659c - 1, i7, 5);
        j(1, this.f23659c - 3, i7, 6);
        j(1, this.f23659c - 2, i7, 7);
        j(1, this.f23659c - 1, i7, 8);
    }

    private boolean i(int i7, int i8) {
        return this.f23660d[(i8 * this.f23659c) + i7] >= 0;
    }

    private void j(int i7, int i8, int i9, int i10) {
        if (i7 < 0) {
            int i11 = this.f23658b;
            i7 += i11;
            i8 += 4 - ((i11 + 4) % 8);
        }
        if (i8 < 0) {
            int i12 = this.f23659c;
            i8 += i12;
            i7 += 4 - ((i12 + 4) % 8);
        }
        l(i8, i7, (this.f23657a.charAt(i9) & (1 << (8 - i10))) != 0);
    }

    private void l(int i7, int i8, boolean z7) {
        this.f23660d[(i8 * this.f23659c) + i7] = z7 ? (byte) 1 : (byte) 0;
    }

    private void m(int i7, int i8, int i9) {
        int i10 = i7 - 2;
        int i11 = i8 - 2;
        j(i10, i11, i9, 1);
        int i12 = i8 - 1;
        j(i10, i12, i9, 2);
        int i13 = i7 - 1;
        j(i13, i11, i9, 3);
        j(i13, i12, i9, 4);
        j(i13, i8, i9, 5);
        j(i7, i11, i9, 6);
        j(i7, i12, i9, 7);
        j(i7, i8, i9, 8);
    }

    public final boolean e(int i7, int i8) {
        return this.f23660d[(i8 * this.f23659c) + i7] == 1;
    }

    final byte[] f() {
        return this.f23660d;
    }

    final int g() {
        return this.f23659c;
    }

    final int h() {
        return this.f23658b;
    }

    public final void k() {
        int i7;
        int i8;
        int i9 = 0;
        int i10 = 0;
        int i11 = 4;
        while (true) {
            if (i11 == this.f23658b && i9 == 0) {
                a(i10);
                i10++;
            }
            if (i11 == this.f23658b - 2 && i9 == 0 && this.f23659c % 4 != 0) {
                b(i10);
                i10++;
            }
            if (i11 == this.f23658b - 2 && i9 == 0 && this.f23659c % 8 == 4) {
                c(i10);
                i10++;
            }
            if (i11 == this.f23658b + 4 && i9 == 2 && this.f23659c % 8 == 0) {
                d(i10);
                i10++;
            }
            do {
                if (i11 < this.f23658b && i9 >= 0 && !i(i9, i11)) {
                    m(i11, i9, i10);
                    i10++;
                }
                i11 -= 2;
                i9 += 2;
                if (i11 < 0) {
                    break;
                }
            } while (i9 < this.f23659c);
            int i12 = i11 + 1;
            int i13 = i9 + 3;
            do {
                if (i12 >= 0 && i13 < this.f23659c && !i(i13, i12)) {
                    m(i12, i13, i10);
                    i10++;
                }
                i12 += 2;
                i13 -= 2;
                i7 = this.f23658b;
                if (i12 >= i7) {
                    break;
                }
            } while (i13 >= 0);
            i11 = i12 + 3;
            i9 = i13 + 1;
            if (i11 >= i7 && i9 >= (i8 = this.f23659c)) {
                break;
            }
        }
        if (i(i8 - 1, i7 - 1)) {
            return;
        }
        l(this.f23659c - 1, this.f23658b - 1, true);
        l(this.f23659c - 2, this.f23658b - 2, true);
    }
}
