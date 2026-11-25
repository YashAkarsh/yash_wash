package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f32730d = "d";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final String f32731e = "Initialize ImageLoader with configuration";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final String f32732f = "Destroy ImageLoader";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final String f32733g = "Load image from memory cache [%s]";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f32734h = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f32735i = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f32736j = "ImageLoader must be init with configuration before using";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f32737k = "ImageLoader configuration can not be initialized with null";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile d f32738l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f32739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f32740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final y3.a f32741c = new y3.d();

    protected d() {
    }

    private void c() {
        if (this.f32739a == null) {
            throw new IllegalStateException(f32736j);
        }
    }

    private static Handler f(c cVar) {
        Handler handlerY = cVar.y();
        if (cVar.J()) {
            return null;
        }
        return (handlerY == null && Looper.myLooper() == Looper.getMainLooper()) ? new Handler() : handlerY;
    }

    public static d t() {
        if (f32738l == null) {
            synchronized (d.class) {
                if (f32738l == null) {
                    f32738l = new d();
                }
            }
        }
        return f32738l;
    }

    public void A(String str, c cVar, y3.a aVar) {
        C(str, null, cVar, aVar, null);
    }

    public void B(String str, com.nostra13.universalimageloader.core.assist.e eVar, c cVar, y3.a aVar) {
        C(str, eVar, cVar, aVar, null);
    }

    public void C(String str, com.nostra13.universalimageloader.core.assist.e eVar, c cVar, y3.a aVar, y3.b bVar) {
        c();
        if (eVar == null) {
            eVar = this.f32739a.b();
        }
        if (cVar == null) {
            cVar = this.f32739a.f32816t;
        }
        q(str, new com.nostra13.universalimageloader.core.imageaware.b(str, eVar, com.nostra13.universalimageloader.core.assist.h.CROP), cVar, aVar, bVar);
    }

    public void D(String str, com.nostra13.universalimageloader.core.assist.e eVar, y3.a aVar) {
        C(str, eVar, null, aVar, null);
    }

    public void E(String str, y3.a aVar) {
        C(str, null, null, aVar, null);
    }

    public Bitmap F(String str) {
        return I(str, null, null);
    }

    public Bitmap G(String str, c cVar) {
        return I(str, null, cVar);
    }

    public Bitmap H(String str, com.nostra13.universalimageloader.core.assist.e eVar) {
        return I(str, eVar, null);
    }

    public Bitmap I(String str, com.nostra13.universalimageloader.core.assist.e eVar, c cVar) {
        if (cVar == null) {
            cVar = this.f32739a.f32816t;
        }
        c cVarU = new c.b().z(cVar).S(true).u();
        y3.e eVar2 = new y3.e();
        B(str, eVar, cVarU, eVar2);
        return eVar2.e();
    }

    public void J() {
        this.f32740b.o();
    }

    public void K() {
        this.f32740b.q();
    }

    public void L() {
        this.f32740b.r();
    }

    public void a(ImageView imageView) {
        this.f32740b.d(new com.nostra13.universalimageloader.core.imageaware.c(imageView));
    }

    public void b(com.nostra13.universalimageloader.core.imageaware.a aVar) {
        this.f32740b.d(aVar);
    }

    public void d() {
        c();
        this.f32739a.f32813q.clear();
    }

    public void e() {
        c();
        this.f32739a.f32812p.clear();
    }

    public void g(boolean z7) {
        this.f32740b.f(z7);
    }

    public void h() {
        e eVar = this.f32739a;
        if (eVar != null && eVar.f32817u) {
            com.nostra13.universalimageloader.utils.d.a(f32732f, new Object[0]);
        }
        L();
        this.f32740b = null;
        this.f32739a = null;
    }

    public void i(String str, ImageView imageView) {
        q(str, new com.nostra13.universalimageloader.core.imageaware.c(imageView), null, null, null);
    }

    public void j(String str, ImageView imageView, c cVar) {
        q(str, new com.nostra13.universalimageloader.core.imageaware.c(imageView), cVar, null, null);
    }

    public void k(String str, ImageView imageView, c cVar, y3.a aVar) {
        l(str, imageView, cVar, aVar, null);
    }

    public void l(String str, ImageView imageView, c cVar, y3.a aVar, y3.b bVar) {
        q(str, new com.nostra13.universalimageloader.core.imageaware.c(imageView), cVar, aVar, bVar);
    }

    public void m(String str, ImageView imageView, y3.a aVar) {
        q(str, new com.nostra13.universalimageloader.core.imageaware.c(imageView), null, aVar, null);
    }

    public void n(String str, com.nostra13.universalimageloader.core.imageaware.a aVar) {
        q(str, aVar, null, null, null);
    }

    public void o(String str, com.nostra13.universalimageloader.core.imageaware.a aVar, c cVar) {
        q(str, aVar, cVar, null, null);
    }

    public void p(String str, com.nostra13.universalimageloader.core.imageaware.a aVar, c cVar, y3.a aVar2) {
        q(str, aVar, cVar, aVar2, null);
    }

    public void q(String str, com.nostra13.universalimageloader.core.imageaware.a aVar, c cVar, y3.a aVar2, y3.b bVar) {
        c();
        if (aVar == null) {
            throw new IllegalArgumentException(f32735i);
        }
        if (aVar2 == null) {
            aVar2 = this.f32741c;
        }
        y3.a aVar3 = aVar2;
        if (cVar == null) {
            cVar = this.f32739a.f32816t;
        }
        if (TextUtils.isEmpty(str)) {
            this.f32740b.d(aVar);
            aVar3.a(str, aVar.d());
            if (cVar.N()) {
                aVar.c(cVar.z(this.f32739a.f32797a));
            } else {
                aVar.c(null);
            }
            aVar3.b(str, aVar.d(), null);
            return;
        }
        com.nostra13.universalimageloader.core.assist.e eVarD = com.nostra13.universalimageloader.utils.b.d(aVar, this.f32739a.b());
        String strD = com.nostra13.universalimageloader.utils.e.d(str, eVarD);
        this.f32740b.p(aVar, strD);
        aVar3.a(str, aVar.d());
        Bitmap bitmap = this.f32739a.f32812p.get(strD);
        if (bitmap == null || bitmap.isRecycled()) {
            if (cVar.P()) {
                aVar.c(cVar.B(this.f32739a.f32797a));
            } else if (cVar.I()) {
                aVar.c(null);
            }
            h hVar = new h(this.f32740b, new g(str, aVar, eVarD, strD, cVar, aVar3, bVar, this.f32740b.h(str)), f(cVar));
            if (cVar.J()) {
                hVar.run();
                return;
            } else {
                this.f32740b.s(hVar);
                return;
            }
        }
        if (this.f32739a.f32817u) {
            com.nostra13.universalimageloader.utils.d.a(f32733g, strD);
        }
        if (!cVar.L()) {
            cVar.w().a(bitmap, aVar, com.nostra13.universalimageloader.core.assist.f.MEMORY_CACHE);
            aVar3.b(str, aVar.d(), bitmap);
            return;
        }
        i iVar = new i(this.f32740b, bitmap, new g(str, aVar, eVarD, strD, cVar, aVar3, bVar, this.f32740b.h(str)), f(cVar));
        if (cVar.J()) {
            iVar.run();
        } else {
            this.f32740b.t(iVar);
        }
    }

    public void r(String str, com.nostra13.universalimageloader.core.imageaware.a aVar, y3.a aVar2) {
        q(str, aVar, null, aVar2, null);
    }

    public com.nostra13.universalimageloader.cache.disc.b s() {
        c();
        return this.f32739a.f32813q;
    }

    public String u(ImageView imageView) {
        return this.f32740b.g(new com.nostra13.universalimageloader.core.imageaware.c(imageView));
    }

    public String v(com.nostra13.universalimageloader.core.imageaware.a aVar) {
        return this.f32740b.g(aVar);
    }

    public com.nostra13.universalimageloader.cache.memory.c<String, Bitmap> w() {
        c();
        return this.f32739a.f32812p;
    }

    public void x(boolean z7) {
        this.f32740b.k(z7);
    }

    public synchronized void y(e eVar) {
        try {
            if (eVar == null) {
                throw new IllegalArgumentException(f32737k);
            }
            if (this.f32739a == null) {
                if (eVar.f32817u) {
                    com.nostra13.universalimageloader.utils.d.a(f32731e, new Object[0]);
                }
                this.f32740b = new f(eVar);
                this.f32739a = eVar;
            } else {
                com.nostra13.universalimageloader.utils.d.i(f32734h, new Object[0]);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public boolean z() {
        return this.f32739a != null;
    }
}
