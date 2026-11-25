package com.bumptech.glide.gifdecoder;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.fragment.app.v;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final int A = 2;
    private static final int B = 3;
    private static final int C = -1;
    private static final int D = -1;
    private static final Bitmap.Config E = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f14005r = "a";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f14006s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f14007t = 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f14008u = 2;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f14009v = 3;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f14010w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final int f14011x = 4096;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final int f14012y = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final int f14013z = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f14014a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ByteBuffer f14016c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d f14018e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private short[] f14019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private byte[] f14020g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private byte[] f14021h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private byte[] f14022i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f14023j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f14024k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private byte[] f14025l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private InterfaceC0161a f14027n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Bitmap f14028o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f14029p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f14030q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f14015b = new int[256];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f14017d = new byte[256];

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private c f14026m = new c();

    /* JADX INFO: renamed from: com.bumptech.glide.gifdecoder.a$a, reason: collision with other inner class name */
    public interface InterfaceC0161a {
        Bitmap a(int i7, int i8, Bitmap.Config config);

        void b(Bitmap bitmap);
    }

    public a(InterfaceC0161a interfaceC0161a) {
        this.f14027n = interfaceC0161a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v26, types: [short] */
    /* JADX WARN: Type inference failed for: r1v28 */
    private void c(b bVar) {
        int i7;
        int i8;
        short s7;
        if (bVar != null) {
            this.f14016c.position(bVar.f14040j);
        }
        if (bVar == null) {
            c cVar = this.f14026m;
            i7 = cVar.f14049f;
            i8 = cVar.f14050g;
        } else {
            i7 = bVar.f14033c;
            i8 = bVar.f14034d;
        }
        int i9 = i7 * i8;
        byte[] bArr = this.f14022i;
        if (bArr == null || bArr.length < i9) {
            this.f14022i = new byte[i9];
        }
        if (this.f14019f == null) {
            this.f14019f = new short[4096];
        }
        if (this.f14020g == null) {
            this.f14020g = new byte[4096];
        }
        if (this.f14021h == null) {
            this.f14021h = new byte[v.I];
        }
        int iR = r();
        int i10 = 1;
        int i11 = 1 << iR;
        int i12 = i11 + 1;
        int i13 = i11 + 2;
        int i14 = iR + 1;
        int i15 = (1 << i14) - 1;
        for (int i16 = 0; i16 < i11; i16++) {
            this.f14019f[i16] = 0;
            this.f14020g[i16] = (byte) i16;
        }
        int i17 = -1;
        int i18 = i14;
        int i19 = i13;
        int i20 = i15;
        int i21 = 0;
        int iU = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = -1;
        while (i21 < i9) {
            int i29 = 3;
            if (iU == 0) {
                iU = u();
                if (iU <= 0) {
                    this.f14030q = 3;
                    break;
                }
                i22 = 0;
            }
            i24 += (this.f14017d[i22] & 255) << i23;
            i23 += 8;
            i22 += i10;
            iU += i17;
            i19 = i19;
            i18 = i18;
            int i30 = i28;
            int i31 = i26;
            while (true) {
                if (i23 < i18) {
                    i26 = i31;
                    i28 = i30;
                    i12 = i12;
                    i10 = 1;
                    break;
                }
                int i32 = i24 & i20;
                i24 >>= i18;
                i23 -= i18;
                if (i32 != i11) {
                    if (i32 > i19) {
                        this.f14030q = i29;
                    } else if (i32 != i12) {
                        int i33 = i14;
                        int i34 = i30;
                        if (i34 == -1) {
                            this.f14021h[i27] = this.f14020g[i32];
                            i30 = i32;
                            i31 = i30;
                            i14 = i33;
                            i27++;
                            i29 = 3;
                            i17 = -1;
                        } else {
                            if (i32 >= i19) {
                                this.f14021h[i27] = (byte) i31;
                                s7 = i34;
                                i27++;
                            } else {
                                s7 = i32;
                            }
                            while (s7 >= i11) {
                                this.f14021h[i27] = this.f14020g[s7];
                                s7 = this.f14019f[s7];
                                i27++;
                                i11 = i11;
                            }
                            int i35 = i11;
                            byte[] bArr2 = this.f14020g;
                            int i36 = bArr2[s7] & 255;
                            int i37 = i27 + 1;
                            int i38 = i13;
                            byte b8 = (byte) i36;
                            this.f14021h[i27] = b8;
                            if (i19 < 4096) {
                                this.f14019f[i19] = (short) i34;
                                bArr2[i19] = b8;
                                i19++;
                                if ((i19 & i20) == 0 && i19 < 4096) {
                                    i18++;
                                    i20 += i19;
                                }
                            }
                            i27 = i37;
                            while (i27 > 0) {
                                i27--;
                                this.f14022i[i25] = this.f14021h[i27];
                                i21++;
                                i25++;
                            }
                            i30 = i32;
                            i11 = i35;
                            i12 = i12;
                            i13 = i38;
                            i29 = 3;
                            i17 = -1;
                            i31 = i36;
                            i14 = i33;
                        }
                    }
                    i28 = i30;
                    i26 = i31;
                    i10 = 1;
                    i17 = -1;
                    break;
                }
                i18 = i14;
                i19 = i13;
                i20 = i15;
                i17 = -1;
                i30 = -1;
            }
        }
        for (int i39 = i25; i39 < i9; i39++) {
            this.f14022i[i39] = 0;
        }
    }

    private d h() {
        if (this.f14018e == null) {
            this.f14018e = new d();
        }
        return this.f14018e;
    }

    private Bitmap l() {
        InterfaceC0161a interfaceC0161a = this.f14027n;
        c cVar = this.f14026m;
        int i7 = cVar.f14049f;
        int i8 = cVar.f14050g;
        Bitmap.Config config = E;
        Bitmap bitmapA = interfaceC0161a.a(i7, i8, config);
        if (bitmapA == null) {
            c cVar2 = this.f14026m;
            bitmapA = Bitmap.createBitmap(cVar2.f14049f, cVar2.f14050g, config);
        }
        w(bitmapA);
        return bitmapA;
    }

    private int r() {
        try {
            return this.f14016c.get() & 255;
        } catch (Exception unused) {
            this.f14030q = 1;
            return 0;
        }
    }

    private int u() {
        int iR = r();
        int i7 = 0;
        if (iR > 0) {
            while (i7 < iR) {
                int i8 = iR - i7;
                try {
                    this.f14016c.get(this.f14017d, i7, i8);
                    i7 += i8;
                } catch (Exception e8) {
                    Log.w(f14005r, "Error Reading Block", e8);
                    this.f14030q = 1;
                }
            }
        }
        return i7;
    }

    @TargetApi(12)
    private static void w(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0030  */
    private Bitmap y(b bVar, b bVar2) {
        int i7;
        int i8;
        int i9;
        Bitmap bitmap;
        int i10;
        c cVar = this.f14026m;
        int i11 = cVar.f14049f;
        int i12 = cVar.f14050g;
        int[] iArr = this.f14023j;
        int i13 = 0;
        if (bVar2 == null) {
            Arrays.fill(iArr, 0);
        }
        int i14 = 3;
        int i15 = 2;
        if (bVar2 != null && (i9 = bVar2.f14037g) > 0) {
            if (i9 == 2) {
                if (bVar.f14036f) {
                    i10 = 0;
                } else {
                    c cVar2 = this.f14026m;
                    i10 = cVar2.f14055l;
                    if (bVar.f14041k != null && cVar2.f14053j == bVar.f14038h) {
                        i10 = 0;
                    }
                }
                int i16 = (bVar2.f14032b * i11) + bVar2.f14031a;
                int i17 = (bVar2.f14034d * i11) + i16;
                while (i16 < i17) {
                    int i18 = bVar2.f14033c + i16;
                    for (int i19 = i16; i19 < i18; i19++) {
                        iArr[i19] = i10;
                    }
                    i16 += i11;
                }
            } else if (i9 == 3 && (bitmap = this.f14028o) != null) {
                bitmap.getPixels(iArr, 0, i11, 0, 0, i11, i12);
            }
        }
        c(bVar);
        int i20 = 8;
        int i21 = 1;
        int i22 = 0;
        while (true) {
            int i23 = bVar.f14034d;
            if (i13 >= i23) {
                break;
            }
            if (bVar.f14035e) {
                if (i22 >= i23) {
                    i21++;
                    if (i21 == i15) {
                        i22 = 4;
                    } else if (i21 == i14) {
                        i22 = i15;
                        i20 = 4;
                    } else if (i21 == 4) {
                        i20 = i15;
                        i22 = 1;
                    }
                }
                i8 = i22 + i20;
            } else {
                i8 = i22;
                i22 = i13;
            }
            int i24 = i22 + bVar.f14032b;
            c cVar3 = this.f14026m;
            if (i24 < cVar3.f14050g) {
                int i25 = cVar3.f14049f;
                int i26 = i24 * i25;
                int i27 = bVar.f14031a + i26;
                int i28 = bVar.f14033c;
                int i29 = i27 + i28;
                if (i26 + i25 < i29) {
                    i29 = i26 + i25;
                }
                int i30 = i28 * i13;
                while (i27 < i29) {
                    int i31 = i30 + 1;
                    int i32 = this.f14014a[this.f14022i[i30] & 255];
                    if (i32 != 0) {
                        iArr[i27] = i32;
                    }
                    i27++;
                    i30 = i31;
                }
            }
            i13++;
            i22 = i8;
            i15 = 2;
            i14 = 3;
        }
        if (this.f14029p && ((i7 = bVar.f14037g) == 0 || i7 == 1)) {
            if (this.f14028o == null) {
                this.f14028o = l();
            }
            this.f14028o.setPixels(iArr, 0, i11, 0, 0, i11, i12);
        }
        Bitmap bitmapL = l();
        bitmapL.setPixels(iArr, 0, i11, 0, 0, i11, i12);
        return bitmapL;
    }

    public void a() {
        this.f14024k = (this.f14024k + 1) % this.f14026m.f14046c;
    }

    public void b() {
        this.f14026m = null;
        this.f14025l = null;
        this.f14022i = null;
        this.f14023j = null;
        Bitmap bitmap = this.f14028o;
        if (bitmap != null) {
            this.f14027n.b(bitmap);
        }
        this.f14028o = null;
        this.f14016c = null;
    }

    public int d() {
        return this.f14024k;
    }

    public byte[] e() {
        return this.f14025l;
    }

    public int f(int i7) {
        if (i7 >= 0) {
            c cVar = this.f14026m;
            if (i7 < cVar.f14046c) {
                return cVar.f14048e.get(i7).f14039i;
            }
        }
        return -1;
    }

    public int g() {
        return this.f14026m.f14046c;
    }

    public int i() {
        return this.f14026m.f14050g;
    }

    @Deprecated
    public int j() {
        int i7 = this.f14026m.f14056m;
        if (i7 == -1) {
            return 1;
        }
        return i7;
    }

    public int k() {
        return this.f14026m.f14056m;
    }

    public int m() {
        int i7;
        if (this.f14026m.f14046c <= 0 || (i7 = this.f14024k) < 0) {
            return -1;
        }
        return f(i7);
    }

    public synchronized Bitmap n() {
        if (this.f14026m.f14046c <= 0 || this.f14024k < 0) {
            String str = f14005r;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "unable to decode frame, frameCount=" + this.f14026m.f14046c + " framePointer=" + this.f14024k);
            }
            this.f14030q = 1;
        }
        int i7 = this.f14030q;
        if (i7 != 1 && i7 != 2) {
            this.f14030q = 0;
            b bVar = this.f14026m.f14048e.get(this.f14024k);
            int i8 = this.f14024k - 1;
            b bVar2 = i8 >= 0 ? this.f14026m.f14048e.get(i8) : null;
            int[] iArr = bVar.f14041k;
            if (iArr == null) {
                iArr = this.f14026m.f14044a;
            }
            this.f14014a = iArr;
            if (iArr == null) {
                String str2 = f14005r;
                if (Log.isLoggable(str2, 3)) {
                    Log.d(str2, "No Valid Color Table");
                }
                this.f14030q = 1;
                return null;
            }
            if (bVar.f14036f) {
                System.arraycopy(iArr, 0, this.f14015b, 0, iArr.length);
                int[] iArr2 = this.f14015b;
                this.f14014a = iArr2;
                iArr2[bVar.f14038h] = 0;
            }
            return y(bVar, bVar2);
        }
        String str3 = f14005r;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, "Unable to decode frame, status=" + this.f14030q);
        }
        return null;
    }

    public int o() {
        return this.f14030q;
    }

    public int p() {
        int i7 = this.f14026m.f14056m;
        if (i7 == -1) {
            return 1;
        }
        if (i7 == 0) {
            return 0;
        }
        return i7 + 1;
    }

    public int q() {
        return this.f14026m.f14049f;
    }

    public int s(InputStream inputStream, int i7) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i7 > 0 ? i7 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int i8 = inputStream.read(bArr, 0, 16384);
                    if (i8 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i8);
                }
                byteArrayOutputStream.flush();
                t(byteArrayOutputStream.toByteArray());
            } catch (IOException e8) {
                Log.w(f14005r, "Error reading data from stream", e8);
            }
        } else {
            this.f14030q = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e9) {
                Log.w(f14005r, "Error closing stream", e9);
            }
        }
        return this.f14030q;
    }

    public int t(byte[] bArr) {
        this.f14025l = bArr;
        this.f14026m = h().o(bArr).c();
        if (bArr != null) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            this.f14016c = byteBufferWrap;
            byteBufferWrap.rewind();
            this.f14016c.order(ByteOrder.LITTLE_ENDIAN);
            c cVar = this.f14026m;
            int i7 = cVar.f14049f;
            int i8 = cVar.f14050g;
            this.f14022i = new byte[i7 * i8];
            this.f14023j = new int[i7 * i8];
            this.f14029p = false;
            Iterator<b> it = cVar.f14048e.iterator();
            while (it.hasNext()) {
                if (it.next().f14037g == 3) {
                    this.f14029p = true;
                    break;
                }
            }
        }
        return this.f14030q;
    }

    public void v() {
        this.f14024k = -1;
    }

    public void x(c cVar, byte[] bArr) {
        this.f14026m = cVar;
        this.f14025l = bArr;
        this.f14030q = 0;
        this.f14024k = -1;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.f14016c = byteBufferWrap;
        byteBufferWrap.rewind();
        this.f14016c.order(ByteOrder.LITTLE_ENDIAN);
        this.f14029p = false;
        Iterator<b> it = cVar.f14048e.iterator();
        while (it.hasNext()) {
            if (it.next().f14037g == 3) {
                this.f14029p = true;
                break;
            }
        }
        int i7 = cVar.f14049f;
        int i8 = cVar.f14050g;
        this.f14022i = new byte[i7 * i8];
        this.f14023j = new int[i7 * i8];
    }
}
