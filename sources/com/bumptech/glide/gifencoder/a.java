package com.bumptech.glide.gifencoder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f14065v = "AnimatedGifEncoder";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final double f14066w = 4.0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14068b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14070d;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private OutputStream f14074h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Bitmap f14075i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte[] f14076j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private byte[] f14077k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f14078l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private byte[] f14079m;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f14087u;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Integer f14069c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14071e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14072f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f14073g = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean[] f14080n = new boolean[256];

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f14081o = 7;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f14082p = -1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f14083q = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f14084r = true;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f14085s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f14086t = 10;

    private void b() {
        byte[] bArr = this.f14076j;
        int length = bArr.length;
        int i7 = length / 3;
        this.f14077k = new byte[i7];
        c cVar = new c(bArr, length, this.f14086t);
        this.f14079m = cVar.h();
        int i8 = 0;
        while (true) {
            byte[] bArr2 = this.f14079m;
            if (i8 >= bArr2.length) {
                break;
            }
            byte b8 = bArr2[i8];
            int i9 = i8 + 2;
            bArr2[i8] = bArr2[i9];
            bArr2[i9] = b8;
            this.f14080n[i8 / 3] = false;
            i8 += 3;
        }
        int i10 = 0;
        int i11 = 0;
        while (i10 < i7) {
            byte[] bArr3 = this.f14076j;
            int i12 = i11 + 1;
            int i13 = i12 + 1;
            int iG = cVar.g(bArr3[i11] & 255, bArr3[i12] & 255, bArr3[i13] & 255);
            this.f14080n[iG] = true;
            this.f14077k[i10] = (byte) iG;
            i10++;
            i11 = i13 + 1;
        }
        this.f14076j = null;
        this.f14078l = 8;
        this.f14081o = 7;
        Integer num = this.f14069c;
        if (num != null) {
            this.f14070d = c(num.intValue());
        } else if (this.f14087u) {
            this.f14070d = c(0);
        }
    }

    private int c(int i7) {
        if (this.f14079m == null) {
            return -1;
        }
        int iRed = Color.red(i7);
        int iGreen = Color.green(i7);
        int iBlue = Color.blue(i7);
        int length = this.f14079m.length;
        int i8 = 0;
        int i9 = 16777216;
        int i10 = 0;
        while (i8 < length) {
            byte[] bArr = this.f14079m;
            int i11 = i8 + 1;
            int i12 = iRed - (bArr[i8] & 255);
            int i13 = i11 + 1;
            int i14 = iGreen - (bArr[i11] & 255);
            int i15 = iBlue - (bArr[i13] & 255);
            int i16 = (i12 * i12) + (i14 * i14) + (i15 * i15);
            int i17 = i13 / 3;
            if (this.f14080n[i17] && i16 < i9) {
                i9 = i16;
                i10 = i17;
            }
            i8 = i13 + 1;
        }
        return i10;
    }

    private void e() {
        int width = this.f14075i.getWidth();
        int height = this.f14075i.getHeight();
        int i7 = this.f14067a;
        if (width != i7 || height != this.f14068b) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i7, this.f14068b, Bitmap.Config.ARGB_8888);
            new Canvas(bitmapCreateBitmap).drawBitmap(bitmapCreateBitmap, 0.0f, 0.0f, (Paint) null);
            this.f14075i = bitmapCreateBitmap;
        }
        int i8 = width * height;
        int[] iArr = new int[i8];
        this.f14075i.getPixels(iArr, 0, width, 0, 0, width, height);
        this.f14076j = new byte[i8 * 3];
        this.f14087u = false;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i9 < i8) {
            int i12 = iArr[i9];
            if (i12 == 0) {
                i10++;
            }
            byte[] bArr = this.f14076j;
            int i13 = i11 + 1;
            bArr[i11] = (byte) (i12 & 255);
            int i14 = i13 + 1;
            bArr[i13] = (byte) ((i12 >> 8) & 255);
            bArr[i14] = (byte) ((i12 >> 16) & 255);
            i9++;
            i11 = i14 + 1;
        }
        double d8 = ((double) (i10 * 100)) / ((double) i8);
        this.f14087u = d8 > f14066w;
        if (Log.isLoggable(f14065v, 3)) {
            Log.d(f14065v, "got pixels for frame with " + d8 + "% transparent pixels");
        }
    }

    private void o() throws IOException {
        int i7;
        int i8;
        this.f14074h.write(33);
        this.f14074h.write(249);
        this.f14074h.write(4);
        if (this.f14069c != null || this.f14087u) {
            i7 = 1;
            i8 = 2;
        } else {
            i7 = 0;
            i8 = 0;
        }
        int i9 = this.f14082p;
        if (i9 >= 0) {
            i8 = i9 & 7;
        }
        this.f14074h.write(i7 | (i8 << 2) | 0 | 0);
        u(this.f14072f);
        this.f14074h.write(this.f14070d);
        this.f14074h.write(0);
    }

    private void p() throws IOException {
        this.f14074h.write(44);
        u(0);
        u(0);
        u(this.f14067a);
        u(this.f14068b);
        if (this.f14084r) {
            this.f14074h.write(0);
        } else {
            this.f14074h.write(this.f14081o | 128);
        }
    }

    private void q() throws IOException {
        u(this.f14067a);
        u(this.f14068b);
        this.f14074h.write(this.f14081o | 240);
        this.f14074h.write(0);
        this.f14074h.write(0);
    }

    private void r() throws IOException {
        this.f14074h.write(33);
        this.f14074h.write(255);
        this.f14074h.write(11);
        v("NETSCAPE2.0");
        this.f14074h.write(3);
        this.f14074h.write(1);
        u(this.f14071e);
        this.f14074h.write(0);
    }

    private void s() throws IOException {
        OutputStream outputStream = this.f14074h;
        byte[] bArr = this.f14079m;
        outputStream.write(bArr, 0, bArr.length);
        int length = 768 - this.f14079m.length;
        for (int i7 = 0; i7 < length; i7++) {
            this.f14074h.write(0);
        }
    }

    private void t() throws IOException {
        new b(this.f14067a, this.f14068b, this.f14077k, this.f14078l).f(this.f14074h);
    }

    private void u(int i7) throws IOException {
        this.f14074h.write(i7 & 255);
        this.f14074h.write((i7 >> 8) & 255);
    }

    private void v(String str) throws IOException {
        for (int i7 = 0; i7 < str.length(); i7++) {
            this.f14074h.write((byte) str.charAt(i7));
        }
    }

    public boolean a(Bitmap bitmap) {
        if (bitmap == null || !this.f14073g) {
            return false;
        }
        try {
            if (!this.f14085s) {
                k(bitmap.getWidth(), bitmap.getHeight());
            }
            this.f14075i = bitmap;
            e();
            b();
            if (this.f14084r) {
                q();
                s();
                if (this.f14071e >= 0) {
                    r();
                }
            }
            o();
            p();
            if (!this.f14084r) {
                s();
            }
            t();
            this.f14084r = false;
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean d() {
        boolean z7;
        if (!this.f14073g) {
            return false;
        }
        this.f14073g = false;
        try {
            this.f14074h.write(59);
            this.f14074h.flush();
            if (this.f14083q) {
                this.f14074h.close();
            }
            z7 = true;
        } catch (IOException unused) {
            z7 = false;
        }
        this.f14070d = 0;
        this.f14074h = null;
        this.f14075i = null;
        this.f14076j = null;
        this.f14077k = null;
        this.f14079m = null;
        this.f14083q = false;
        this.f14084r = true;
        return z7;
    }

    public void f(int i7) {
        this.f14072f = Math.round(i7 / 10.0f);
    }

    public void g(int i7) {
        if (i7 >= 0) {
            this.f14082p = i7;
        }
    }

    public void h(float f8) {
        if (f8 != 0.0f) {
            this.f14072f = Math.round(100.0f / f8);
        }
    }

    public void i(int i7) {
        if (i7 < 1) {
            i7 = 1;
        }
        this.f14086t = i7;
    }

    public void j(int i7) {
        if (i7 >= 0) {
            this.f14071e = i7;
        }
    }

    public void k(int i7, int i8) {
        if (!this.f14073g || this.f14084r) {
            this.f14067a = i7;
            this.f14068b = i8;
            if (i7 < 1) {
                this.f14067a = 320;
            }
            if (i8 < 1) {
                this.f14068b = 240;
            }
            this.f14085s = true;
        }
    }

    public void l(int i7) {
        this.f14069c = Integer.valueOf(i7);
    }

    public boolean m(OutputStream outputStream) {
        boolean z7 = false;
        if (outputStream == null) {
            return false;
        }
        this.f14083q = false;
        this.f14074h = outputStream;
        try {
            v("GIF89a");
            z7 = true;
        } catch (IOException unused) {
        }
        this.f14073g = z7;
        return z7;
    }

    public boolean n(String str) {
        boolean zM;
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
            this.f14074h = bufferedOutputStream;
            zM = m(bufferedOutputStream);
            this.f14083q = true;
        } catch (IOException unused) {
            zM = false;
        }
        this.f14073g = zM;
        return zM;
    }
}
