package com.haier.library.okhttp.b.g;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int f27182b = 16384;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final byte f27183c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final byte f27184d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final byte f27185e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final byte f27186f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final byte f27187g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final byte f27188h = 5;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final byte f27189i = 6;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final byte f27190j = 7;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final byte f27191k = 8;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final byte f27192l = 9;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final byte f27193m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final byte f27194n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final byte f27195o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final byte f27196p = 4;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final byte f27197q = 4;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final byte f27198r = 8;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final byte f27199s = 32;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final byte f27200t = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final com.haier.library.a.j f27181a = com.haier.library.a.j.i("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String[] f27201u = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final String[] f27202v = new String[64];

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final String[] f27203w = new String[256];

    static {
        int i7 = 0;
        int i8 = 0;
        while (true) {
            String[] strArr = f27203w;
            if (i8 >= strArr.length) {
                break;
            }
            strArr[i8] = com.haier.library.okhttp.n.d.j("%8s", Integer.toBinaryString(i8)).replace(' ', '0');
            i8++;
        }
        String[] strArr2 = f27202v;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        strArr2[1 | 8] = strArr2[1] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i9 = 0; i9 < 3; i9++) {
            int i10 = iArr2[i9];
            int i11 = iArr[0];
            String[] strArr3 = f27202v;
            int i12 = i11 | i10;
            strArr3[i12] = strArr3[i11] + '|' + strArr3[i10];
            strArr3[i12 | 8] = strArr3[i11] + '|' + strArr3[i10] + "|PADDED";
        }
        while (true) {
            String[] strArr4 = f27202v;
            if (i7 >= strArr4.length) {
                return;
            }
            if (strArr4[i7] == null) {
                strArr4[i7] = f27203w[i7];
            }
            i7++;
        }
    }

    private e() {
    }

    static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(com.haier.library.okhttp.n.d.j(str, objArr));
    }

    static String b(byte b8, byte b9) {
        if (b9 == 0) {
            return "";
        }
        if (b8 != 2 && b8 != 3) {
            if (b8 == 4 || b8 == 6) {
                return b9 == 1 ? "ACK" : f27203w[b9];
            }
            if (b8 != 7 && b8 != 8) {
                String[] strArr = f27202v;
                String str = b9 < strArr.length ? strArr[b9] : f27203w[b9];
                if (b8 != 5 || (b9 & 4) == 0) {
                    return (b8 != 0 || (b9 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED");
                }
                return str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f27203w[b9];
    }

    static String c(boolean z7, int i7, int i8, byte b8, byte b9) {
        String[] strArr = f27201u;
        String strJ = b8 < strArr.length ? strArr[b8] : com.haier.library.okhttp.n.d.j("0x%02x", Byte.valueOf(b8));
        String strB = b(b8, b9);
        Object[] objArr = new Object[5];
        objArr[0] = z7 ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i7);
        objArr[2] = Integer.valueOf(i8);
        objArr[3] = strJ;
        objArr[4] = strB;
        return com.haier.library.okhttp.n.d.j("%s 0x%08x %5d %-13s %s", objArr);
    }

    static IOException d(String str, Object... objArr) throws IOException {
        throw new IOException(com.haier.library.okhttp.n.d.j(str, objArr));
    }
}
