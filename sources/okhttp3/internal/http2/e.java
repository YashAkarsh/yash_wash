package okhttp3.internal.http2;

import kotlin.jvm.internal.l0;
import kotlin.text.b0;
import okio.p;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f38001b = 16384;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f38002c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f38003d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f38004e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f38005f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f38006g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f38007h = 5;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f38008i = 6;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f38009j = 7;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f38010k = 8;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f38011l = 9;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f38012m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f38013n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f38014o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f38015p = 4;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f38016q = 4;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f38017r = 8;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f38018s = 32;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f38019t = 32;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String[] f38022w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final e f38023x = new e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final p f38000a = p.f38508f.l("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String[] f38020u = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String[] f38021v = new String[64];

    static {
        String[] strArr = new String[256];
        for (int i7 = 0; i7 < 256; i7++) {
            String binaryString = Integer.toBinaryString(i7);
            l0.o(binaryString, "Integer.toBinaryString(it)");
            strArr[i7] = b0.j2(okhttp3.internal.d.v("%8s", binaryString), ' ', '0', false, 4, null);
        }
        f38022w = strArr;
        String[] strArr2 = f38021v;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        strArr2[1 | 8] = l0.C("END_STREAM", "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i8 = 0; i8 < 3; i8++) {
            int i9 = iArr2[i8];
            int i10 = iArr[0];
            String[] strArr3 = f38021v;
            int i11 = i10 | i9;
            strArr3[i11] = strArr3[i10] + "|" + strArr3[i9];
            strArr3[i11 | 8] = strArr3[i10] + "|" + strArr3[i9] + "|PADDED";
        }
        int length = f38021v.length;
        for (int i12 = 0; i12 < length; i12++) {
            String[] strArr4 = f38021v;
            if (strArr4[i12] == null) {
                strArr4[i12] = f38022w[i12];
            }
        }
    }

    private e() {
    }

    @a7.d
    public final String a(int i7, int i8) {
        String str;
        if (i8 == 0) {
            return "";
        }
        if (i7 != 2 && i7 != 3) {
            if (i7 == 4 || i7 == 6) {
                return i8 == 1 ? "ACK" : f38022w[i8];
            }
            if (i7 != 7 && i7 != 8) {
                String[] strArr = f38021v;
                if (i8 < strArr.length) {
                    str = strArr[i8];
                    l0.m(str);
                } else {
                    str = f38022w[i8];
                }
                String str2 = str;
                if (i7 != 5 || (i8 & 4) == 0) {
                    return (i7 != 0 || (i8 & 32) == 0) ? str2 : b0.k2(str2, "PRIORITY", "COMPRESSED", false, 4, null);
                }
                return b0.k2(str2, "HEADERS", "PUSH_PROMISE", false, 4, null);
            }
        }
        return f38022w[i8];
    }

    @a7.d
    public final String b(int i7) {
        String[] strArr = f38020u;
        return i7 < strArr.length ? strArr[i7] : okhttp3.internal.d.v("0x%02x", Integer.valueOf(i7));
    }

    @a7.d
    public final String c(boolean z7, int i7, int i8, int i9, int i10) {
        return okhttp3.internal.d.v("%s 0x%08x %5d %-13s %s", z7 ? "<<" : ">>", Integer.valueOf(i7), Integer.valueOf(i8), b(i9), a(i9, i10));
    }
}
