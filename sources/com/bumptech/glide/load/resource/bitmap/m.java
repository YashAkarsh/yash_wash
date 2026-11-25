package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import androidx.core.view.q1;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14557b = "ImageHeaderParser";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f14558c = 4671814;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f14559d = -1991225785;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f14560e = 65496;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f14561f = 19789;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f14562g = 18761;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f14563h = "Exif\u0000\u0000";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final byte[] f14564i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f14565j = 218;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f14566k = 217;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f14567l = 255;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f14568m = 225;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f14569n = 274;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int[] f14570o = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f14571a;

    public enum a {
        GIF(true),
        JPEG(false),
        PNG_A(true),
        PNG(false),
        UNKNOWN(false);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f14578a;

        a(boolean z7) {
            this.f14578a = z7;
        }

        public boolean a() {
            return this.f14578a;
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f14579a;

        public b(byte[] bArr) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            this.f14579a = byteBufferWrap;
            byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
        }

        public short a(int i7) {
            return this.f14579a.getShort(i7);
        }

        public int b(int i7) {
            return this.f14579a.getInt(i7);
        }

        public int c() {
            return this.f14579a.array().length;
        }

        public void d(ByteOrder byteOrder) {
            this.f14579a.order(byteOrder);
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InputStream f14580a;

        public c(InputStream inputStream) {
            this.f14580a = inputStream;
        }

        public int a() throws IOException {
            return this.f14580a.read();
        }

        public int b() throws IOException {
            return ((this.f14580a.read() << 8) & q1.f6813f) | (this.f14580a.read() & 255);
        }

        public short c() throws IOException {
            return (short) (this.f14580a.read() & 255);
        }

        public int d(byte[] bArr) throws IOException {
            int length = bArr.length;
            while (length > 0) {
                int i7 = this.f14580a.read(bArr, bArr.length - length, length);
                if (i7 == -1) {
                    break;
                }
                length -= i7;
            }
            return bArr.length - length;
        }

        public long e(long j7) throws IOException {
            if (j7 < 0) {
                return 0L;
            }
            long j8 = j7;
            while (j8 > 0) {
                long jSkip = this.f14580a.skip(j8);
                if (jSkip <= 0) {
                    if (this.f14580a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j8 -= jSkip;
            }
            return j7 - j8;
        }
    }

    static {
        byte[] bytes = new byte[0];
        try {
            bytes = f14563h.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
        f14564i = bytes;
    }

    public m(InputStream inputStream) {
        this.f14571a = new c(inputStream);
    }

    private static int a(int i7, int i8) {
        return i7 + 2 + (i8 * 12);
    }

    private byte[] b() throws IOException {
        short sC;
        int iB;
        long j7;
        long jE;
        do {
            short sC2 = this.f14571a.c();
            if (sC2 != 255) {
                if (Log.isLoggable(f14557b, 3)) {
                    Log.d(f14557b, "Unknown segmentId=" + ((int) sC2));
                }
                return null;
            }
            sC = this.f14571a.c();
            if (sC == f14565j) {
                return null;
            }
            if (sC == f14566k) {
                if (Log.isLoggable(f14557b, 3)) {
                    Log.d(f14557b, "Found MARKER_EOI in exif segment");
                }
                return null;
            }
            iB = this.f14571a.b() - 2;
            if (sC == f14568m) {
                byte[] bArr = new byte[iB];
                int iD = this.f14571a.d(bArr);
                if (iD == iB) {
                    return bArr;
                }
                if (Log.isLoggable(f14557b, 3)) {
                    Log.d(f14557b, "Unable to read segment data, type: " + ((int) sC) + ", length: " + iB + ", actually read: " + iD);
                }
                return null;
            }
            j7 = iB;
            jE = this.f14571a.e(j7);
        } while (jE == j7);
        if (Log.isLoggable(f14557b, 3)) {
            Log.d(f14557b, "Unable to skip enough data, type: " + ((int) sC) + ", wanted to skip: " + iB + ", but actually skipped: " + jE);
        }
        return null;
    }

    private static boolean e(int i7) {
        return (i7 & f14560e) == f14560e || i7 == f14561f || i7 == f14562g;
    }

    private static int g(b bVar) {
        ByteOrder byteOrder;
        short sA = bVar.a(6);
        if (sA == f14561f) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (sA == f14562g) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable(f14557b, 3)) {
                Log.d(f14557b, "Unknown endianness = " + ((int) sA));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.d(byteOrder);
        int iB = bVar.b(10) + 6;
        short sA2 = bVar.a(iB);
        for (int i7 = 0; i7 < sA2; i7++) {
            int iA = a(iB, i7);
            short sA3 = bVar.a(iA);
            if (sA3 == f14569n) {
                short sA4 = bVar.a(iA + 2);
                if (sA4 >= 1 && sA4 <= 12) {
                    int iB2 = bVar.b(iA + 4);
                    if (iB2 >= 0) {
                        if (Log.isLoggable(f14557b, 3)) {
                            Log.d(f14557b, "Got tagIndex=" + i7 + " tagType=" + ((int) sA3) + " formatCode=" + ((int) sA4) + " componentCount=" + iB2);
                        }
                        int i8 = iB2 + f14570o[sA4];
                        if (i8 <= 4) {
                            int i9 = iA + 8;
                            if (i9 >= 0 && i9 <= bVar.c()) {
                                if (i8 >= 0 && i8 + i9 <= bVar.c()) {
                                    return bVar.a(i9);
                                }
                                if (Log.isLoggable(f14557b, 3)) {
                                    Log.d(f14557b, "Illegal number of bytes for TI tag data tagType=" + ((int) sA3));
                                }
                            } else if (Log.isLoggable(f14557b, 3)) {
                                Log.d(f14557b, "Illegal tagValueOffset=" + i9 + " tagType=" + ((int) sA3));
                            }
                        } else if (Log.isLoggable(f14557b, 3)) {
                            Log.d(f14557b, "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sA4));
                        }
                    } else if (Log.isLoggable(f14557b, 3)) {
                        Log.d(f14557b, "Negative tiff component count");
                    }
                } else if (Log.isLoggable(f14557b, 3)) {
                    Log.d(f14557b, "Got invalid format code=" + ((int) sA4));
                }
            }
        }
        return -1;
    }

    public int c() throws IOException {
        if (!e(this.f14571a.b())) {
            return -1;
        }
        byte[] bArrB = b();
        boolean z7 = false;
        boolean z8 = bArrB != null && bArrB.length > f14564i.length;
        if (!z8) {
            z7 = z8;
            break;
        }
        int i7 = 0;
        while (true) {
            byte[] bArr = f14564i;
            if (i7 >= bArr.length) {
                z7 = z8;
                break;
            }
            if (bArrB[i7] != bArr[i7]) {
                break;
            }
            i7++;
        }
        if (z7) {
            return g(new b(bArrB));
        }
        return -1;
    }

    public a d() throws IOException {
        int iB = this.f14571a.b();
        if (iB == f14560e) {
            return a.JPEG;
        }
        int iB2 = ((iB << 16) & k.a.f34390c) | (this.f14571a.b() & 65535);
        if (iB2 != f14559d) {
            return (iB2 >> 8) == f14558c ? a.GIF : a.UNKNOWN;
        }
        this.f14571a.e(21L);
        return this.f14571a.a() >= 3 ? a.PNG_A : a.PNG;
    }

    public boolean f() throws IOException {
        return d().a();
    }
}
