package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.engine.cache.i;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class a implements Runnable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f14428i = "PreFillRunner";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final long f14430k = 32;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final long f14431l = 40;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final int f14432m = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.c f14434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f14435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.prefill.c f14436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f14437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<d> f14438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f14439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f14440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f14441h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final b f14429j = new b();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final long f14433n = TimeUnit.SECONDS.toMillis(1);

    static class b {
        b() {
        }

        public long a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    private static class c implements w0.c {
        private c() {
        }

        @Override // w0.c
        public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
        }
    }

    public a(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, i iVar, com.bumptech.glide.load.engine.prefill.c cVar2) {
        this(cVar, iVar, cVar2, f14429j, new Handler(Looper.getMainLooper()));
    }

    private void a(d dVar, Bitmap bitmap) {
        Bitmap bitmapD;
        if (this.f14438e.add(dVar) && (bitmapD = this.f14434a.d(dVar.d(), dVar.b(), dVar.a())) != null) {
            this.f14434a.b(bitmapD);
        }
        this.f14434a.b(bitmap);
    }

    private boolean b() {
        long jA = this.f14437d.a();
        while (!this.f14436c.b() && !f(jA)) {
            d dVarC = this.f14436c.c();
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dVarC.d(), dVarC.b(), dVarC.a());
            if (d() >= com.bumptech.glide.util.i.f(bitmapCreateBitmap)) {
                this.f14435b.d(new c(), com.bumptech.glide.load.resource.bitmap.d.d(bitmapCreateBitmap, this.f14434a));
            } else {
                a(dVarC, bitmapCreateBitmap);
            }
            if (Log.isLoggable(f14428i, 3)) {
                Log.d(f14428i, "allocated [" + dVarC.d() + "x" + dVarC.b() + "] " + dVarC.a() + " size: " + com.bumptech.glide.util.i.f(bitmapCreateBitmap));
            }
        }
        return (this.f14441h || this.f14436c.b()) ? false : true;
    }

    private int d() {
        return this.f14435b.c() - this.f14435b.b();
    }

    private long e() {
        long j7 = this.f14440g;
        this.f14440g = Math.min(4 * j7, f14433n);
        return j7;
    }

    private boolean f(long j7) {
        return this.f14437d.a() - j7 >= 32;
    }

    public void c() {
        this.f14441h = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (b()) {
            this.f14439f.postDelayed(this, e());
        }
    }

    a(com.bumptech.glide.load.engine.bitmap_recycle.c cVar, i iVar, com.bumptech.glide.load.engine.prefill.c cVar2, b bVar, Handler handler) {
        this.f14438e = new HashSet();
        this.f14440g = f14431l;
        this.f14434a = cVar;
        this.f14435b = iVar;
        this.f14436c = cVar2;
        this.f14437d = bVar;
        this.f14439f = handler;
    }
}
