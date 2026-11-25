package com.haier.library.okhttp.b.m;

import com.haier.library.a.g;
import com.haier.library.a.j;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f27444a = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f27445b = 128;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f27446c = 64;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f27447d = 32;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final int f27448e = 16;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f27449f = 15;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int f27450g = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final int f27451h = 128;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final int f27452i = 127;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final int f27453j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final int f27454k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final int f27455l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final int f27456m = 8;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final int f27457n = 9;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final int f27458o = 10;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final long f27459p = 125;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final long f27460q = 123;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final int f27461r = 126;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final long f27462s = 65535;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final int f27463t = 127;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final int f27464u = 1001;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final int f27465v = 1005;

    private b() {
        throw new AssertionError("No instances.");
    }

    static String a(int i7) {
        if (i7 < 1000 || i7 >= 5000) {
            return "Code must be in range [1000,5000): " + i7;
        }
        if ((i7 < 1004 || i7 > 1006) && (i7 < 1012 || i7 > 2999)) {
            return null;
        }
        return "Code " + i7 + " is reserved and may not be used.";
    }

    public static String b(String str) {
        return j.i(str + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").K().C();
    }

    static void c(g.c cVar, byte[] bArr) {
        int length = bArr.length;
        int i7 = 0;
        do {
            byte[] bArr2 = cVar.f26262e;
            int i8 = cVar.f26263f;
            int i9 = cVar.f26264g;
            while (i8 < i9) {
                int i10 = i7 % length;
                bArr2[i8] = (byte) (bArr2[i8] ^ bArr[i10]);
                i8++;
                i7 = i10 + 1;
            }
        } while (cVar.b() != -1);
    }

    static void d(int i7) {
        String strA = a(i7);
        if (strA != null) {
            throw new IllegalArgumentException(strA);
        }
    }
}
