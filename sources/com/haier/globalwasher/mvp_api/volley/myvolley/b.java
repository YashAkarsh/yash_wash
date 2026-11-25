package com.haier.globalwasher.mvp_api.volley.myvolley;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.haier.globalwasher.mvp_api.volley.toolbox.l;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class b implements l.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f24848d = 8192;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f24849e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f24850f = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.jakewharton.disklrucache.a f24851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Bitmap.CompressFormat f24852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f24853c;

    public b(Context context, String str, int i7, Bitmap.CompressFormat compressFormat, int i8) {
        this.f24852b = Bitmap.CompressFormat.JPEG;
        this.f24853c = 70;
        try {
            this.f24851a = com.jakewharton.disklrucache.a.p0(f(context, str), 1, 1, i7);
            this.f24852b = compressFormat;
            this.f24853c = i8;
        } catch (IOException e8) {
            e8.printStackTrace();
        }
    }

    private File f(Context context, String str) {
        return new File(context.getCacheDir().getPath() + File.separator + str);
    }

    private boolean g(Bitmap bitmap, com.jakewharton.disklrucache.a.c cVar) throws Throwable {
        BufferedOutputStream bufferedOutputStream = null;
        try {
            BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(cVar.i(0), f24848d);
            try {
                boolean zCompress = bitmap.compress(this.f24852b, this.f24853c, bufferedOutputStream2);
                bufferedOutputStream2.close();
                return zCompress;
            } catch (Throwable th) {
                th = th;
                bufferedOutputStream = bufferedOutputStream2;
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x003c  */
    @Override // com.haier.globalwasher.mvp_api.volley.toolbox.l.f
    public Bitmap a(String str) throws Throwable {
        Throwable th;
        com.jakewharton.disklrucache.a.e eVarQ;
        Bitmap bitmapDecodeStream = null;
        try {
            eVarQ = this.f24851a.Q(e.b(str, false));
            if (eVarQ == null) {
                if (eVarQ != null) {
                    eVarQ.close();
                }
                return null;
            }
            try {
                try {
                    InputStream inputStreamC = eVarQ.c(0);
                    if (inputStreamC != null) {
                        bitmapDecodeStream = BitmapFactory.decodeStream(new BufferedInputStream(inputStreamC, f24848d));
                    }
                } catch (IOException e8) {
                    e = e8;
                    e.printStackTrace();
                    if (eVarQ != null) {
                    }
                    return bitmapDecodeStream;
                }
                eVarQ.close();
                return bitmapDecodeStream;
            } catch (Throwable th2) {
                th = th2;
                if (eVarQ != null) {
                    eVarQ.close();
                }
                throw th;
            }
        } catch (IOException e9) {
            e = e9;
            eVarQ = null;
        } catch (Throwable th3) {
            th = th3;
            eVarQ = null;
            if (eVarQ != null) {
                eVarQ.close();
            }
            throw th;
        }
    }

    @Override // com.haier.globalwasher.mvp_api.volley.toolbox.l.f
    public void b(String str, Bitmap bitmap) {
        com.jakewharton.disklrucache.a.c cVarH = null;
        try {
            cVarH = this.f24851a.H(e.b(str, false));
            if (cVarH == null) {
                return;
            }
            if (g(bitmap, cVarH)) {
                this.f24851a.flush();
                cVarH.f();
            } else {
                cVarH.a();
            }
        } catch (IOException unused) {
            if (cVarH != null) {
                try {
                    cVarH.a();
                } catch (IOException unused2) {
                }
            }
        }
    }

    public void c() {
        try {
            this.f24851a.F();
        } catch (IOException e8) {
            e8.printStackTrace();
        }
    }

    public boolean d(String str) {
        boolean z7 = false;
        try {
            com.jakewharton.disklrucache.a.e eVarQ = this.f24851a.Q(str);
            z7 = eVarQ != null;
            if (eVarQ != null) {
                eVarQ.close();
            }
        } catch (IOException e8) {
            e8.printStackTrace();
        }
        return z7;
    }

    public File e() {
        return this.f24851a.g0();
    }
}
