package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
final class h implements Runnable, com.nostra13.universalimageloader.utils.c.a {
    private static final String A = "PreProcess image before caching in memory [%s]";
    private static final String B = "PostProcess image before displaying [%s]";
    private static final String C = "Cache image in memory [%s]";
    private static final String D = "Cache image on disc [%s]";
    private static final String E = "Process image before cache on disc [%s]";
    private static final String F = "ImageAware is reused for another image. Task is cancelled. [%s]";
    private static final String G = "ImageAware was collected by GC. Task is cancelled. [%s]";
    private static final String H = "Task was interrupted [%s]";
    private static final String I = "Pre-processor returned null [%s]";

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private static final String f32867J = "Post-processor returned null [%s]";
    private static final String K = "Bitmap processor for disc cache returned null [%s]";
    private static final int L = 32768;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f32868r = "ImageLoader is paused. Waiting...  [%s]";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f32869s = ".. Resume loading [%s]";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f32870t = "Delay %d ms before loading...  [%s]";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f32871u = "Start display image task [%s]";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f32872v = "Image already is loading. Waiting... [%s]";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f32873w = "...Get cached bitmap from memory after waiting. [%s]";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f32874x = "Load image from network [%s]";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final String f32875y = "Load image from disc cache [%s]";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f32876z = "Resize image in disc cache [%s]";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f32877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f32878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f32879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f32880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.nostra13.universalimageloader.core.download.c f32881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.nostra13.universalimageloader.core.download.c f32882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.nostra13.universalimageloader.core.download.c f32883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.nostra13.universalimageloader.core.decode.b f32884h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f32885i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final String f32886j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f32887k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final com.nostra13.universalimageloader.core.imageaware.a f32888l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final com.nostra13.universalimageloader.core.assist.e f32889m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final com.nostra13.universalimageloader.core.c f32890n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final y3.a f32891o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final y3.b f32892p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private com.nostra13.universalimageloader.core.assist.f f32893q = com.nostra13.universalimageloader.core.assist.f.NETWORK;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f32894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f32895b;

        a(int i7, int i8) {
            this.f32894a = i7;
            this.f32895b = i8;
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.f32892p.a(hVar.f32886j, hVar.f32888l.d(), this.f32894a, this.f32895b);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.nostra13.universalimageloader.core.assist.b.a f32897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Throwable f32898b;

        b(com.nostra13.universalimageloader.core.assist.b.a aVar, Throwable th) {
            this.f32897a = aVar;
            this.f32898b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f32890n.O()) {
                h hVar = h.this;
                hVar.f32888l.c(hVar.f32890n.A(hVar.f32880d.f32797a));
            }
            h hVar2 = h.this;
            hVar2.f32891o.c(hVar2.f32886j, hVar2.f32888l.d(), new com.nostra13.universalimageloader.core.assist.b(this.f32897a, this.f32898b));
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.f32891o.d(hVar.f32886j, hVar.f32888l.d());
        }
    }

    class d extends Exception {
        d() {
        }
    }

    public h(f fVar, g gVar, Handler handler) {
        this.f32877a = fVar;
        this.f32878b = gVar;
        this.f32879c = handler;
        e eVar = fVar.f32847a;
        this.f32880d = eVar;
        this.f32881e = eVar.f32814r;
        this.f32882f = eVar.f32819w;
        this.f32883g = eVar.f32820x;
        this.f32884h = eVar.f32815s;
        this.f32885i = eVar.f32817u;
        this.f32886j = gVar.f32859a;
        this.f32887k = gVar.f32860b;
        this.f32888l = gVar.f32861c;
        this.f32889m = gVar.f32862d;
        this.f32890n = gVar.f32863e;
        this.f32891o = gVar.f32864f;
        this.f32892p = gVar.f32865g;
    }

    private void c() throws d {
        if (p()) {
            throw new d();
        }
    }

    private void d() throws d {
        e();
        f();
    }

    private void e() throws d {
        if (r()) {
            throw new d();
        }
    }

    private void f() throws d {
        if (s()) {
            throw new d();
        }
    }

    private Bitmap g(String str) throws IOException {
        return this.f32884h.a(new com.nostra13.universalimageloader.core.decode.c(this.f32887k, str, this.f32889m, this.f32888l.g(), m(), this.f32890n));
    }

    private boolean h() {
        if (!this.f32890n.K()) {
            return false;
        }
        u(f32870t, Integer.valueOf(this.f32890n.v()), this.f32887k);
        try {
            Thread.sleep(this.f32890n.v());
            return q();
        } catch (InterruptedException unused) {
            com.nostra13.universalimageloader.utils.d.c(H, this.f32887k);
            return true;
        }
    }

    private boolean i(File file) throws IOException {
        InputStream inputStreamA = m().a(this.f32886j, this.f32890n.x());
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 32768);
            try {
                boolean zB = com.nostra13.universalimageloader.utils.c.b(inputStreamA, bufferedOutputStream, this);
                com.nostra13.universalimageloader.utils.c.a(bufferedOutputStream);
                com.nostra13.universalimageloader.utils.c.a(inputStreamA);
                return zB;
            } catch (Throwable th) {
                com.nostra13.universalimageloader.utils.c.a(bufferedOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            com.nostra13.universalimageloader.utils.c.a(inputStreamA);
            throw th2;
        }
    }

    private void j() {
        if (this.f32890n.J() || p()) {
            return;
        }
        w(new c(), false, this.f32879c);
    }

    private void k(com.nostra13.universalimageloader.core.assist.b.a aVar, Throwable th) {
        if (this.f32890n.J() || p() || q()) {
            return;
        }
        w(new b(aVar, th), false, this.f32879c);
    }

    private boolean l(int i7, int i8) {
        if (this.f32890n.J() || p() || q()) {
            return false;
        }
        w(new a(i7, i8), false, this.f32879c);
        return true;
    }

    private com.nostra13.universalimageloader.core.download.c m() {
        if (this.f32877a.m()) {
            return this.f32882f;
        }
        return this.f32877a.n() ? this.f32883g : this.f32881e;
    }

    private File n() {
        File parentFile;
        File fileC = this.f32880d.f32813q.c(this.f32886j);
        File parentFile2 = fileC.getParentFile();
        if ((parentFile2 == null || (!parentFile2.exists() && !parentFile2.mkdirs())) && (parentFile = (fileC = this.f32880d.f32818v.c(this.f32886j)).getParentFile()) != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        return fileC;
    }

    private boolean p() {
        if (!Thread.interrupted()) {
            return false;
        }
        t(H);
        return true;
    }

    private boolean q() {
        return r() || s();
    }

    private boolean r() {
        if (!this.f32888l.f()) {
            return false;
        }
        t(G);
        return true;
    }

    private boolean s() {
        if (!(!this.f32887k.equals(this.f32877a.g(this.f32888l)))) {
            return false;
        }
        t(F);
        return true;
    }

    private void t(String str) {
        if (this.f32885i) {
            com.nostra13.universalimageloader.utils.d.a(str, this.f32887k);
        }
    }

    private void u(String str, Object... objArr) {
        if (this.f32885i) {
            com.nostra13.universalimageloader.utils.d.a(str, objArr);
        }
    }

    private boolean v(File file, int i7, int i8) throws IOException {
        Bitmap bitmapA = this.f32884h.a(new com.nostra13.universalimageloader.core.decode.c(this.f32887k, com.nostra13.universalimageloader.core.download.c.a.FILE.d(file.getAbsolutePath()), new com.nostra13.universalimageloader.core.assist.e(i7, i8), com.nostra13.universalimageloader.core.assist.h.FIT_INSIDE, m(), new com.nostra13.universalimageloader.core.c.b().z(this.f32890n).G(com.nostra13.universalimageloader.core.assist.d.IN_SAMPLE_INT).u()));
        if (bitmapA != null && this.f32880d.f32804h != null) {
            t(E);
            bitmapA = this.f32880d.f32804h.a(bitmapA);
            if (bitmapA == null) {
                com.nostra13.universalimageloader.utils.d.c(K, this.f32887k);
            }
        }
        if (bitmapA != null) {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), 32768);
            try {
                e eVar = this.f32880d;
                bitmapA.compress(eVar.f32802f, eVar.f32803g, bufferedOutputStream);
                com.nostra13.universalimageloader.utils.c.a(bufferedOutputStream);
                bitmapA.recycle();
            } catch (Throwable th) {
                com.nostra13.universalimageloader.utils.c.a(bufferedOutputStream);
                throw th;
            }
        }
        return true;
    }

    static void w(Runnable runnable, boolean z7, Handler handler) {
        if (z7) {
            runnable.run();
        } else if (handler == null) {
            new Thread(runnable).start();
        } else {
            handler.post(runnable);
        }
    }

    private boolean x(File file) throws d {
        boolean zI;
        t(D);
        try {
            zI = i(file);
            if (zI) {
                try {
                    e eVar = this.f32880d;
                    int i7 = eVar.f32800d;
                    int i8 = eVar.f32801e;
                    if (i7 > 0 || i8 > 0) {
                        t(f32876z);
                        zI = v(file, i7, i8);
                    }
                    this.f32880d.f32813q.a(this.f32886j, file);
                } catch (IOException e8) {
                    e = e8;
                    com.nostra13.universalimageloader.utils.d.d(e);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
        } catch (IOException e9) {
            e = e9;
            zI = false;
        }
        return zI;
    }

    private Bitmap y() throws d {
        Bitmap bitmapG;
        File fileN = n();
        Bitmap bitmap = null;
        try {
            try {
                String strD = com.nostra13.universalimageloader.core.download.c.a.FILE.d(fileN.getAbsolutePath());
                if (fileN.exists()) {
                    t(f32875y);
                    this.f32893q = com.nostra13.universalimageloader.core.assist.f.DISC_CACHE;
                    d();
                    bitmapG = g(strD);
                } else {
                    bitmapG = null;
                }
                if (bitmapG != null) {
                    try {
                        if (bitmapG.getWidth() > 0 && bitmapG.getHeight() > 0) {
                            return bitmapG;
                        }
                    } catch (IOException e8) {
                        e = e8;
                        bitmap = bitmapG;
                        com.nostra13.universalimageloader.utils.d.d(e);
                        k(com.nostra13.universalimageloader.core.assist.b.a.IO_ERROR, e);
                        if (fileN.exists()) {
                            fileN.delete();
                        }
                        return bitmap;
                    } catch (IllegalStateException unused) {
                        k(com.nostra13.universalimageloader.core.assist.b.a.NETWORK_DENIED, null);
                        return bitmapG;
                    } catch (OutOfMemoryError e9) {
                        e = e9;
                        bitmap = bitmapG;
                        com.nostra13.universalimageloader.utils.d.d(e);
                        k(com.nostra13.universalimageloader.core.assist.b.a.OUT_OF_MEMORY, e);
                        return bitmap;
                    } catch (Throwable th) {
                        th = th;
                        bitmap = bitmapG;
                        com.nostra13.universalimageloader.utils.d.d(th);
                        k(com.nostra13.universalimageloader.core.assist.b.a.UNKNOWN, th);
                        return bitmap;
                    }
                }
                t(f32874x);
                this.f32893q = com.nostra13.universalimageloader.core.assist.f.NETWORK;
                if (!this.f32890n.G() || !x(fileN)) {
                    strD = this.f32886j;
                }
                d();
                bitmapG = g(strD);
                if (bitmapG != null && bitmapG.getWidth() > 0 && bitmapG.getHeight() > 0) {
                    return bitmapG;
                }
                k(com.nostra13.universalimageloader.core.assist.b.a.DECODING_ERROR, null);
                return bitmapG;
            } catch (d e10) {
                throw e10;
            }
        } catch (IOException e11) {
            e = e11;
        } catch (IllegalStateException unused2) {
            bitmapG = null;
        } catch (OutOfMemoryError e12) {
            e = e12;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean z() {
        AtomicBoolean atomicBooleanI = this.f32877a.i();
        if (atomicBooleanI.get()) {
            synchronized (this.f32877a.j()) {
                if (atomicBooleanI.get()) {
                    t(f32868r);
                    try {
                        this.f32877a.j().wait();
                        t(f32869s);
                    } catch (InterruptedException unused) {
                        com.nostra13.universalimageloader.utils.d.c(H, this.f32887k);
                        return true;
                    }
                }
            }
        }
        return q();
    }

    @Override // com.nostra13.universalimageloader.utils.c.a
    public boolean a(int i7, int i8) {
        return this.f32892p == null || l(i7, i8);
    }

    String o() {
        return this.f32886j;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (z() || h()) {
            return;
        }
        ReentrantLock reentrantLock = this.f32878b.f32866h;
        t(f32871u);
        if (reentrantLock.isLocked()) {
            t(f32872v);
        }
        reentrantLock.lock();
        try {
            try {
                d();
                Bitmap bitmapA = this.f32880d.f32812p.get(this.f32887k);
                if (bitmapA == null) {
                    bitmapA = y();
                    if (bitmapA == null) {
                        reentrantLock.unlock();
                        return;
                    }
                    d();
                    c();
                    if (this.f32890n.M()) {
                        t(A);
                        bitmapA = this.f32890n.E().a(bitmapA);
                        if (bitmapA == null) {
                            com.nostra13.universalimageloader.utils.d.c(I, this.f32887k);
                        }
                    }
                    if (bitmapA != null && this.f32890n.F()) {
                        t(C);
                        this.f32880d.f32812p.put(this.f32887k, bitmapA);
                    }
                } else {
                    this.f32893q = com.nostra13.universalimageloader.core.assist.f.MEMORY_CACHE;
                    t(f32873w);
                }
                if (bitmapA != null && this.f32890n.L()) {
                    t(B);
                    bitmapA = this.f32890n.D().a(bitmapA);
                    if (bitmapA == null) {
                        com.nostra13.universalimageloader.utils.d.c(f32867J, this.f32887k);
                    }
                }
                d();
                c();
                reentrantLock.unlock();
                com.nostra13.universalimageloader.core.b bVar = new com.nostra13.universalimageloader.core.b(bitmapA, this.f32878b, this.f32877a, this.f32893q);
                bVar.b(this.f32885i);
                w(bVar, this.f32890n.J(), this.f32879c);
            } catch (d unused) {
                j();
                reentrantLock.unlock();
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
