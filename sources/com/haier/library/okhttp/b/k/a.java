package com.haier.library.okhttp.b.k;

import com.haier.library.a.i;
import com.haier.library.a.p;
import com.haier.library.a.t;
import com.haier.library.okhttp.b.i.f;
import com.haier.library.okhttp.n;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f27382e = "publicsuffixes.gz";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final byte f27386i = 33;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f27388a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CountDownLatch f27389b = new CountDownLatch(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f27390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private byte[] f27391d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f27383f = {42};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f27384g = new String[0];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String[] f27385h = {"*"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final a f27387j = new a();

    public static a a() {
        return f27387j;
    }

    private static String c(byte[] bArr, byte[][] bArr2, int i7) {
        int i8;
        boolean z7;
        int i9;
        int i10;
        int length = bArr.length;
        int i11 = 0;
        while (i11 < length) {
            int i12 = (i11 + length) / 2;
            while (i12 > -1 && bArr[i12] != 10) {
                i12--;
            }
            int i13 = i12 + 1;
            int i14 = 1;
            while (true) {
                i8 = i13 + i14;
                if (bArr[i8] == 10) {
                    break;
                }
                i14++;
            }
            int i15 = i8 - i13;
            int i16 = i7;
            boolean z8 = false;
            int i17 = 0;
            int i18 = 0;
            while (true) {
                if (z8) {
                    i9 = 46;
                    z7 = false;
                } else {
                    z7 = z8;
                    i9 = bArr2[i16][i17] & 255;
                }
                i10 = i9 - (bArr[i13 + i18] & 255);
                if (i10 == 0) {
                    i18++;
                    i17++;
                    if (i18 == i15) {
                        break;
                    }
                    if (bArr2[i16].length != i17) {
                        z8 = z7;
                    } else {
                        if (i16 == bArr2.length - 1) {
                            break;
                        }
                        i16++;
                        i17 = -1;
                        z8 = true;
                    }
                } else {
                    break;
                }
            }
            if (i10 >= 0) {
                if (i10 <= 0) {
                    int i19 = i15 - i18;
                    int length2 = bArr2[i16].length - i17;
                    while (true) {
                        i16++;
                        if (i16 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i16].length;
                    }
                    if (length2 >= i19) {
                        if (length2 <= i19) {
                            return new String(bArr, i13, i15, n.d.f27695j);
                        }
                    }
                }
                i11 = i8 + 1;
            }
            length = i13 - 1;
        }
        return null;
    }

    private String[] e(String[] strArr) {
        String str;
        String strC;
        String strC2;
        if (this.f27388a.get() || !this.f27388a.compareAndSet(false, true)) {
            try {
                this.f27389b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            f();
        }
        synchronized (this) {
            if (this.f27390c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i7 = 0; i7 < strArr.length; i7++) {
            bArr[i7] = strArr[i7].getBytes(n.d.f27695j);
        }
        int i8 = 0;
        while (true) {
            str = null;
            if (i8 >= length) {
                strC = null;
                break;
            }
            strC = c(this.f27390c, bArr, i8);
            if (strC != null) {
                break;
            }
            i8++;
        }
        if (length <= 1) {
            strC2 = null;
            break;
        }
        byte[][] bArr2 = (byte[][]) bArr.clone();
        int i9 = 0;
        while (true) {
            if (i9 >= bArr2.length - 1) {
                strC2 = null;
                break;
            }
            bArr2[i9] = f27383f;
            strC2 = c(this.f27390c, bArr2, i9);
            if (strC2 != null) {
                break;
            }
            i9++;
        }
        if (strC2 != null) {
            for (int i10 = 0; i10 < length - 1; i10++) {
                String strC3 = c(this.f27391d, bArr, i10);
                if (strC3 != null) {
                    str = strC3;
                    break;
                }
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (strC == null && strC2 == null) {
            return f27385h;
        }
        String[] strArrSplit = strC != null ? strC.split("\\.") : f27384g;
        String[] strArrSplit2 = strC2 != null ? strC2.split("\\.") : f27384g;
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    private void f() {
        boolean z7 = false;
        while (true) {
            try {
                try {
                    g();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z7 = true;
                } catch (IOException e8) {
                    f.r().h(5, "Failed to read public suffix list", e8);
                    if (z7) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
    }

    private void g() throws IOException {
        InputStream resourceAsStream = a.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        i iVarB = t.b(new p(t.h(resourceAsStream)));
        try {
            byte[] bArr = new byte[iVarB.l()];
            iVarB.k1(bArr);
            byte[] bArr2 = new byte[iVarB.l()];
            iVarB.k1(bArr2);
            n.d.s(iVarB);
            synchronized (this) {
                this.f27390c = bArr;
                this.f27391d = bArr2;
            }
            this.f27389b.countDown();
        } catch (Throwable th) {
            n.d.s(iVarB);
            throw th;
        }
    }

    public String b(String str) {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrE = e(strArrSplit);
        if (strArrSplit.length == strArrE.length && strArrE[0].charAt(0) != '!') {
            return null;
        }
        if (strArrE[0].charAt(0) == '!') {
            length = strArrSplit.length;
            length2 = strArrE.length;
        } else {
            length = strArrSplit.length;
            length2 = strArrE.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit2 = str.split("\\.");
        for (int i7 = length - length2; i7 < strArrSplit2.length; i7++) {
            sb.append(strArrSplit2[i7]);
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    void d(byte[] bArr, byte[] bArr2) {
        this.f27390c = bArr;
        this.f27391d = bArr2;
        this.f27388a.set(true);
        this.f27389b.countDown();
    }
}
