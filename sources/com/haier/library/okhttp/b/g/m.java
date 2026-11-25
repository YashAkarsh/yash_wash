package com.haier.library.okhttp.b.g;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f27339c = 65535;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f27340d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f27341e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f27342f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int f27343g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int f27344h = 6;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int f27345i = 7;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final int f27346j = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f27347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f27348b = new int[10];

    m a(int i7, int i8) {
        if (i7 >= 0) {
            int[] iArr = this.f27348b;
            if (i7 < iArr.length) {
                this.f27347a = (1 << i7) | this.f27347a;
                iArr[i7] = i8;
            }
        }
        return this;
    }

    void b() {
        this.f27347a = 0;
        Arrays.fill(this.f27348b, 0);
    }

    void c(m mVar) {
        for (int i7 = 0; i7 < 10; i7++) {
            if (mVar.d(i7)) {
                a(i7, mVar.g(i7));
            }
        }
    }

    boolean d(int i7) {
        return ((1 << i7) & this.f27347a) != 0;
    }

    boolean e(boolean z7) {
        int i7;
        if ((this.f27347a & 4) != 0) {
            i7 = this.f27348b[2];
        } else {
            i7 = z7 ? 1 : 0;
        }
        return i7 == 1;
    }

    int f() {
        return Integer.bitCount(this.f27347a);
    }

    int g(int i7) {
        return this.f27348b[i7];
    }

    int h() {
        if ((this.f27347a & 2) != 0) {
            return this.f27348b[1];
        }
        return -1;
    }

    int i(int i7) {
        return (this.f27347a & 16) != 0 ? this.f27348b[4] : i7;
    }

    int j() {
        if ((this.f27347a & 128) != 0) {
            return this.f27348b[7];
        }
        return 65535;
    }

    int k(int i7) {
        return (this.f27347a & 32) != 0 ? this.f27348b[5] : i7;
    }

    int l(int i7) {
        return (this.f27347a & 64) != 0 ? this.f27348b[6] : i7;
    }
}
