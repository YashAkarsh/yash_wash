package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class f implements com.bumptech.glide.load.engine.bitmap_recycle.c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f14267k = "LruBitmapPool";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Bitmap.Config f14268l = Bitmap.Config.ARGB_8888;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f14269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Bitmap.Config> f14270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f14271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b f14272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14275g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f14276h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f14277i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f14278j;

    private interface b {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    private static class c implements b {
        private c() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.f.b
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.f.b
        public void b(Bitmap bitmap) {
        }
    }

    private static class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<Bitmap> f14279a = Collections.synchronizedSet(new HashSet());

        private d() {
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.f.b
        public void a(Bitmap bitmap) {
            if (!this.f14279a.contains(bitmap)) {
                throw new IllegalStateException("Cannot remove bitmap not in tracker");
            }
            this.f14279a.remove(bitmap);
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.f.b
        public void b(Bitmap bitmap) {
            if (!this.f14279a.contains(bitmap)) {
                this.f14279a.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }
    }

    f(int i7, g gVar, Set<Bitmap.Config> set) {
        this.f14271c = i7;
        this.f14273e = i7;
        this.f14269a = gVar;
        this.f14270b = set;
        this.f14272d = new c();
    }

    private void h() {
        if (Log.isLoggable(f14267k, 2)) {
            i();
        }
    }

    private void i() {
        Log.v(f14267k, "Hits=" + this.f14275g + ", misses=" + this.f14276h + ", puts=" + this.f14277i + ", evictions=" + this.f14278j + ", currentSize=" + this.f14274f + ", maxSize=" + this.f14273e + "\nStrategy=" + this.f14269a);
    }

    private void j() {
        m(this.f14273e);
    }

    private static Set<Bitmap.Config> k() {
        HashSet hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Bitmap.Config.values()));
        hashSet.add(null);
        return Collections.unmodifiableSet(hashSet);
    }

    private static g l() {
        return new j();
    }

    private synchronized void m(int i7) {
        while (this.f14274f > i7) {
            Bitmap bitmapRemoveLast = this.f14269a.removeLast();
            if (bitmapRemoveLast == null) {
                if (Log.isLoggable(f14267k, 5)) {
                    Log.w(f14267k, "Size mismatch, resetting");
                    i();
                }
                this.f14274f = 0;
                return;
            }
            this.f14272d.a(bitmapRemoveLast);
            this.f14274f -= this.f14269a.c(bitmapRemoveLast);
            bitmapRemoveLast.recycle();
            this.f14278j++;
            if (Log.isLoggable(f14267k, 3)) {
                Log.d(f14267k, "Evicting bitmap=" + this.f14269a.e(bitmapRemoveLast));
            }
            h();
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    public synchronized void a(float f8) {
        this.f14273e = Math.round(this.f14271c * f8);
        j();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    public synchronized boolean b(Bitmap bitmap) {
        try {
            if (bitmap == null) {
                throw new NullPointerException("Bitmap must not be null");
            }
            if (bitmap.isMutable() && this.f14269a.c(bitmap) <= this.f14273e && this.f14270b.contains(bitmap.getConfig())) {
                int iC = this.f14269a.c(bitmap);
                this.f14269a.b(bitmap);
                this.f14272d.b(bitmap);
                this.f14277i++;
                this.f14274f += iC;
                if (Log.isLoggable(f14267k, 2)) {
                    Log.v(f14267k, "Put bitmap in pool=" + this.f14269a.e(bitmap));
                }
                h();
                j();
                return true;
            }
            if (Log.isLoggable(f14267k, 2)) {
                Log.v(f14267k, "Reject bitmap from pool, bitmap: " + this.f14269a.e(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f14270b.contains(bitmap.getConfig()));
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    public int c() {
        return this.f14273e;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    public synchronized Bitmap d(int i7, int i8, Bitmap.Config config) {
        Bitmap bitmapG;
        bitmapG = g(i7, i8, config);
        if (bitmapG != null) {
            bitmapG.eraseColor(0);
        }
        return bitmapG;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    @SuppressLint({"InlinedApi"})
    public void e(int i7) {
        if (Log.isLoggable(f14267k, 3)) {
            Log.d(f14267k, "trimMemory, level=" + i7);
        }
        if (i7 >= 60) {
            f();
        } else if (i7 >= 40) {
            m(this.f14273e / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    public void f() {
        if (Log.isLoggable(f14267k, 3)) {
            Log.d(f14267k, "clearMemory");
        }
        m(0);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.c
    @TargetApi(12)
    public synchronized Bitmap g(int i7, int i8, Bitmap.Config config) {
        Bitmap bitmapD;
        bitmapD = this.f14269a.d(i7, i8, config != null ? config : f14268l);
        if (bitmapD == null) {
            if (Log.isLoggable(f14267k, 3)) {
                Log.d(f14267k, "Missing bitmap=" + this.f14269a.a(i7, i8, config));
            }
            this.f14276h++;
        } else {
            this.f14275g++;
            this.f14274f -= this.f14269a.c(bitmapD);
            this.f14272d.a(bitmapD);
            bitmapD.setHasAlpha(true);
        }
        if (Log.isLoggable(f14267k, 2)) {
            Log.v(f14267k, "Get bitmap=" + this.f14269a.a(i7, i8, config));
        }
        h();
        return bitmapD;
    }

    public f(int i7) {
        this(i7, l(), k());
    }

    public f(int i7, Set<Bitmap.Config> set) {
        this(i7, l(), set);
    }
}
