package okhttp3.internal.ws;

import kotlin.jvm.internal.l0;
import okio.m;
import okio.p;

/* JADX INFO: loaded from: classes3.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    public static final String f38368a = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f38369b = 128;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f38370c = 64;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f38371d = 32;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f38372e = 16;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f38373f = 15;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f38374g = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f38375h = 128;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f38376i = 127;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f38377j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f38378k = 1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f38379l = 2;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f38380m = 8;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f38381n = 9;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f38382o = 10;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long f38383p = 125;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long f38384q = 123;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f38385r = 126;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long f38386s = 65535;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f38387t = 127;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f38388u = 1001;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f38389v = 1005;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final g f38390w = new g();

    private g() {
    }

    @a7.d
    public final String a(@a7.d String key) {
        l0.p(key, "key");
        return p.f38508f.l(key + f38368a).X().d();
    }

    @a7.e
    public final String b(int i7) {
        if (i7 < 1000 || i7 >= 5000) {
            return "Code must be in range [1000,5000): " + i7;
        }
        if ((1004 > i7 || 1006 < i7) && (1015 > i7 || 2999 < i7)) {
            return null;
        }
        return "Code " + i7 + " is reserved and may not be used.";
    }

    public final void c(@a7.d m.a cursor, @a7.d byte[] key) {
        l0.p(cursor, "cursor");
        l0.p(key, "key");
        int length = key.length;
        int i7 = 0;
        do {
            byte[] bArr = cursor.f38500e;
            int i8 = cursor.f38501f;
            int i9 = cursor.f38502g;
            if (bArr != null) {
                while (i8 < i9) {
                    int i10 = i7 % length;
                    bArr[i8] = (byte) (bArr[i8] ^ key[i10]);
                    i8++;
                    i7 = i10 + 1;
                }
            }
        } while (cursor.e() != -1);
    }

    public final void d(int i7) {
        String strB = b(i7);
        if (strB == null) {
            return;
        }
        l0.m(strB);
        throw new IllegalArgumentException(strB.toString());
    }
}
