package com.bumptech.glide.gifdecoder;

import android.util.Log;
import androidx.core.view.n2;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f14057e = "GifHeaderParser";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final int f14058f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final int f14059g = 10;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f14060h = 256;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f14062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f14063c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f14061a = new byte[256];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14064d = 0;

    private boolean b() {
        return this.f14063c.f14045b != 0;
    }

    private int d() {
        try {
            return this.f14062b.get() & 255;
        } catch (Exception unused) {
            this.f14063c.f14045b = 1;
            return 0;
        }
    }

    private void e() {
        this.f14063c.f14047d.f14031a = m();
        this.f14063c.f14047d.f14032b = m();
        this.f14063c.f14047d.f14033c = m();
        this.f14063c.f14047d.f14034d = m();
        int iD = d();
        boolean z7 = (iD & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iD & 7) + 1);
        b bVar = this.f14063c.f14047d;
        bVar.f14035e = (iD & 64) != 0;
        if (z7) {
            bVar.f14041k = g(iPow);
        } else {
            bVar.f14041k = null;
        }
        this.f14063c.f14047d.f14040j = this.f14062b.position();
        q();
        if (b()) {
            return;
        }
        c cVar = this.f14063c;
        cVar.f14046c++;
        cVar.f14048e.add(cVar.f14047d);
    }

    private int f() {
        int iD = d();
        this.f14064d = iD;
        int i7 = 0;
        if (iD > 0) {
            int i8 = 0;
            while (true) {
                try {
                    int i9 = this.f14064d;
                    if (i7 >= i9) {
                        break;
                    }
                    i8 = i9 - i7;
                    this.f14062b.get(this.f14061a, i7, i8);
                    i7 += i8;
                } catch (Exception e8) {
                    if (Log.isLoggable(f14057e, 3)) {
                        Log.d(f14057e, "Error Reading Block n: " + i7 + " count: " + i8 + " blockSize: " + this.f14064d, e8);
                    }
                    this.f14063c.f14045b = 1;
                }
            }
        }
        return i7;
    }

    private int[] g(int i7) {
        byte[] bArr = new byte[i7 * 3];
        int[] iArr = null;
        try {
            this.f14062b.get(bArr);
            iArr = new int[256];
            int i8 = 0;
            int i9 = 0;
            while (i8 < i7) {
                int i10 = i9 + 1;
                int i11 = i10 + 1;
                int i12 = i11 + 1;
                int i13 = i8 + 1;
                iArr[i8] = ((bArr[i9] & 255) << 16) | n2.f6743t | ((bArr[i10] & 255) << 8) | (bArr[i11] & 255);
                i9 = i12;
                i8 = i13;
            }
        } catch (BufferUnderflowException e8) {
            if (Log.isLoggable(f14057e, 3)) {
                Log.d(f14057e, "Format Error Reading Color Table", e8);
            }
            this.f14063c.f14045b = 1;
        }
        return iArr;
    }

    private void h() {
        boolean z7 = false;
        while (!z7 && !b()) {
            int iD = d();
            if (iD == 33) {
                int iD2 = d();
                if (iD2 == 1) {
                    p();
                } else if (iD2 == 249) {
                    this.f14063c.f14047d = new b();
                    i();
                } else if (iD2 == 254) {
                    p();
                } else if (iD2 != 255) {
                    p();
                } else {
                    f();
                    String str = "";
                    for (int i7 = 0; i7 < 11; i7++) {
                        str = str + ((char) this.f14061a[i7]);
                    }
                    if (str.equals("NETSCAPE2.0")) {
                        l();
                    } else {
                        p();
                    }
                }
            } else if (iD == 44) {
                c cVar = this.f14063c;
                if (cVar.f14047d == null) {
                    cVar.f14047d = new b();
                }
                e();
            } else if (iD != 59) {
                this.f14063c.f14045b = 1;
            } else {
                z7 = true;
            }
        }
    }

    private void i() {
        d();
        int iD = d();
        b bVar = this.f14063c.f14047d;
        int i7 = (iD & 28) >> 2;
        bVar.f14037g = i7;
        if (i7 == 0) {
            bVar.f14037g = 1;
        }
        bVar.f14036f = (iD & 1) != 0;
        int iM = m();
        if (iM < 3) {
            iM = 10;
        }
        b bVar2 = this.f14063c.f14047d;
        bVar2.f14039i = iM * 10;
        bVar2.f14038h = d();
        d();
    }

    private void j() {
        String str = "";
        for (int i7 = 0; i7 < 6; i7++) {
            str = str + ((char) d());
        }
        if (!str.startsWith("GIF")) {
            this.f14063c.f14045b = 1;
            return;
        }
        k();
        if (!this.f14063c.f14051h || b()) {
            return;
        }
        c cVar = this.f14063c;
        cVar.f14044a = g(cVar.f14052i);
        c cVar2 = this.f14063c;
        cVar2.f14055l = cVar2.f14044a[cVar2.f14053j];
    }

    private void k() {
        this.f14063c.f14049f = m();
        this.f14063c.f14050g = m();
        int iD = d();
        c cVar = this.f14063c;
        cVar.f14051h = (iD & 128) != 0;
        cVar.f14052i = 2 << (iD & 7);
        cVar.f14053j = d();
        this.f14063c.f14054k = d();
    }

    private void l() {
        do {
            f();
            byte[] bArr = this.f14061a;
            if (bArr[0] == 1) {
                this.f14063c.f14056m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f14064d <= 0) {
                return;
            }
        } while (!b());
    }

    private int m() {
        return this.f14062b.getShort();
    }

    private void n() {
        this.f14062b = null;
        Arrays.fill(this.f14061a, (byte) 0);
        this.f14063c = new c();
        this.f14064d = 0;
    }

    private void p() {
        int iD;
        do {
            iD = d();
            ByteBuffer byteBuffer = this.f14062b;
            byteBuffer.position(byteBuffer.position() + iD);
        } while (iD > 0);
    }

    private void q() {
        d();
        p();
    }

    public void a() {
        this.f14062b = null;
        this.f14063c = null;
    }

    public c c() {
        if (this.f14062b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (b()) {
            return this.f14063c;
        }
        j();
        if (!b()) {
            h();
            c cVar = this.f14063c;
            if (cVar.f14046c < 0) {
                cVar.f14045b = 1;
            }
        }
        return this.f14063c;
    }

    public d o(byte[] bArr) {
        n();
        if (bArr != null) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            this.f14062b = byteBufferWrap;
            byteBufferWrap.rewind();
            this.f14062b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f14062b = null;
            this.f14063c.f14045b = 2;
        }
        return this;
    }
}
