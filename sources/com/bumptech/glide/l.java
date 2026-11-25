package com.bumptech.glide;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f14170o = "Glide";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static volatile l f14171p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static boolean f14172q = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.model.c f14173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.d f14174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.c f14175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.cache.i f14176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final w0.a f14177e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.bumptech.glide.request.target.g f14178f = new com.bumptech.glide.request.target.g();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final y0.g f14179g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a1.c f14180h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.resource.bitmap.f f14181i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.bumptech.glide.load.resource.gifbitmap.f f14182j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.bumptech.glide.load.resource.bitmap.j f14183k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final com.bumptech.glide.load.resource.gifbitmap.f f14184l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Handler f14185m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.prefill.b f14186n;

    private static class a extends com.bumptech.glide.request.target.n<View, Object> {
        public a(View view) {
            super(view);
        }

        @Override // com.bumptech.glide.request.target.m
        public void b(Object obj, com.bumptech.glide.request.animation.e<? super Object> eVar) {
        }

        @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.m
        public void c(Exception exc, Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.m
        public void d(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.b, com.bumptech.glide.request.target.m
        public void f(Drawable drawable) {
        }
    }

    l(com.bumptech.glide.load.engine.d dVar, com.bumptech.glide.load.engine.cache.i iVar, com.bumptech.glide.load.engine.bitmap_recycle.c cVar, Context context, w0.a aVar) {
        y0.g gVar = new y0.g();
        this.f14179g = gVar;
        this.f14174b = dVar;
        this.f14175c = cVar;
        this.f14176d = iVar;
        this.f14177e = aVar;
        this.f14173a = new com.bumptech.glide.load.model.c(context);
        this.f14185m = new Handler(Looper.getMainLooper());
        this.f14186n = new com.bumptech.glide.load.engine.prefill.b(iVar, cVar, aVar);
        a1.c cVar2 = new a1.c();
        this.f14180h = cVar2;
        com.bumptech.glide.load.resource.bitmap.q qVar = new com.bumptech.glide.load.resource.bitmap.q(cVar, aVar);
        cVar2.b(InputStream.class, Bitmap.class, qVar);
        com.bumptech.glide.load.resource.bitmap.h hVar = new com.bumptech.glide.load.resource.bitmap.h(cVar, aVar);
        cVar2.b(ParcelFileDescriptor.class, Bitmap.class, hVar);
        com.bumptech.glide.load.resource.bitmap.o oVar = new com.bumptech.glide.load.resource.bitmap.o(qVar, hVar);
        cVar2.b(com.bumptech.glide.load.model.g.class, Bitmap.class, oVar);
        com.bumptech.glide.load.resource.gif.c cVar3 = new com.bumptech.glide.load.resource.gif.c(context, cVar);
        cVar2.b(InputStream.class, com.bumptech.glide.load.resource.gif.b.class, cVar3);
        cVar2.b(com.bumptech.glide.load.model.g.class, com.bumptech.glide.load.resource.gifbitmap.a.class, new com.bumptech.glide.load.resource.gifbitmap.g(oVar, cVar3, cVar));
        cVar2.b(InputStream.class, File.class, new com.bumptech.glide.load.resource.file.d());
        D(File.class, ParcelFileDescriptor.class, new com.bumptech.glide.load.model.file_descriptor.a.C0171a());
        D(File.class, InputStream.class, new com.bumptech.glide.load.model.stream.e.a());
        Class cls = Integer.TYPE;
        D(cls, ParcelFileDescriptor.class, new com.bumptech.glide.load.model.file_descriptor.c.a());
        D(cls, InputStream.class, new com.bumptech.glide.load.model.stream.g.a());
        D(Integer.class, ParcelFileDescriptor.class, new com.bumptech.glide.load.model.file_descriptor.c.a());
        D(Integer.class, InputStream.class, new com.bumptech.glide.load.model.stream.g.a());
        D(String.class, ParcelFileDescriptor.class, new com.bumptech.glide.load.model.file_descriptor.d.a());
        D(String.class, InputStream.class, new com.bumptech.glide.load.model.stream.h.a());
        D(Uri.class, ParcelFileDescriptor.class, new com.bumptech.glide.load.model.file_descriptor.e.a());
        D(Uri.class, InputStream.class, new com.bumptech.glide.load.model.stream.i.a());
        D(URL.class, InputStream.class, new com.bumptech.glide.load.model.stream.j.a());
        D(com.bumptech.glide.load.model.d.class, InputStream.class, new com.bumptech.glide.load.model.stream.b.a());
        D(byte[].class, InputStream.class, new com.bumptech.glide.load.model.stream.d.a());
        gVar.b(Bitmap.class, com.bumptech.glide.load.resource.bitmap.k.class, new y0.e(context.getResources(), cVar));
        gVar.b(com.bumptech.glide.load.resource.gifbitmap.a.class, com.bumptech.glide.load.resource.drawable.b.class, new y0.c(new y0.e(context.getResources(), cVar)));
        com.bumptech.glide.load.resource.bitmap.f fVar = new com.bumptech.glide.load.resource.bitmap.f(cVar);
        this.f14181i = fVar;
        this.f14182j = new com.bumptech.glide.load.resource.gifbitmap.f(cVar, fVar);
        com.bumptech.glide.load.resource.bitmap.j jVar = new com.bumptech.glide.load.resource.bitmap.j(cVar);
        this.f14183k = jVar;
        this.f14184l = new com.bumptech.glide.load.resource.gifbitmap.f(cVar, jVar);
    }

    @Deprecated
    public static boolean A() {
        return f14171p != null;
    }

    private static List<z0.a> B(Context context) {
        return f14172q ? new z0.b(context).a() : Collections.emptyList();
    }

    public static void F(boolean z7) {
        synchronized (l.class) {
            if (f14171p != null) {
                throw new IllegalArgumentException("Glide singleton already exists.");
            }
            f14172q = z7;
        }
    }

    @Deprecated
    public static void G(m mVar) {
        if (A()) {
            throw new IllegalArgumentException("Glide is already setup, check with isSetup() first");
        }
        f14171p = mVar.a();
    }

    static void H() {
        f14171p = null;
        f14172q = true;
    }

    public static q K(Activity activity) {
        return com.bumptech.glide.manager.k.h().c(activity);
    }

    @TargetApi(11)
    public static q L(Fragment fragment) {
        return com.bumptech.glide.manager.k.h().d(fragment);
    }

    public static q M(Context context) {
        return com.bumptech.glide.manager.k.h().e(context);
    }

    public static q N(androidx.fragment.app.Fragment fragment) {
        return com.bumptech.glide.manager.k.h().f(fragment);
    }

    public static q O(FragmentActivity fragmentActivity) {
        return com.bumptech.glide.manager.k.h().g(fragmentActivity);
    }

    public static <T> com.bumptech.glide.load.model.l<T, ParcelFileDescriptor> b(Class<T> cls, Context context) {
        return e(cls, ParcelFileDescriptor.class, context);
    }

    public static <T> com.bumptech.glide.load.model.l<T, ParcelFileDescriptor> c(T t7, Context context) {
        return f(t7, ParcelFileDescriptor.class, context);
    }

    public static <T, Y> com.bumptech.glide.load.model.l<T, Y> e(Class<T> cls, Class<Y> cls2, Context context) {
        if (cls != null) {
            return o(context).w().a(cls, cls2);
        }
        if (!Log.isLoggable(f14170o, 3)) {
            return null;
        }
        Log.d(f14170o, "Unable to load null model, setting placeholder only");
        return null;
    }

    public static <T, Y> com.bumptech.glide.load.model.l<T, Y> f(T t7, Class<Y> cls, Context context) {
        return e(t7 != null ? t7.getClass() : null, cls, context);
    }

    public static <T> com.bumptech.glide.load.model.l<T, InputStream> g(Class<T> cls, Context context) {
        return e(cls, InputStream.class, context);
    }

    public static <T> com.bumptech.glide.load.model.l<T, InputStream> h(T t7, Context context) {
        return f(t7, InputStream.class, context);
    }

    public static void j(View view) {
        l(new a(view));
    }

    public static void k(com.bumptech.glide.request.a<?> aVar) {
        aVar.clear();
    }

    public static void l(com.bumptech.glide.request.target.m<?> mVar) {
        com.bumptech.glide.util.i.b();
        com.bumptech.glide.request.c cVarE = mVar.e();
        if (cVarE != null) {
            cVarE.clear();
            mVar.a(null);
        }
    }

    public static l o(Context context) {
        if (f14171p == null) {
            synchronized (l.class) {
                if (f14171p == null) {
                    Context applicationContext = context.getApplicationContext();
                    m mVar = new m(applicationContext);
                    List<z0.a> listB = B(applicationContext);
                    Iterator<z0.a> it = listB.iterator();
                    while (it.hasNext()) {
                        it.next().a(applicationContext, mVar);
                    }
                    f14171p = mVar.a();
                    Iterator<z0.a> it2 = listB.iterator();
                    while (it2.hasNext()) {
                        it2.next().b(applicationContext, f14171p);
                    }
                }
            }
        }
        return f14171p;
    }

    private com.bumptech.glide.load.model.c w() {
        return this.f14173a;
    }

    public static File y(Context context) {
        return z(context, com.bumptech.glide.load.engine.cache.a.InterfaceC0164a.f14306b);
    }

    public static File z(Context context, String str) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            if (Log.isLoggable(f14170o, 6)) {
                Log.e(f14170o, "default disk cache dir is null");
            }
            return null;
        }
        File file = new File(cacheDir, str);
        if (file.mkdirs() || (file.exists() && file.isDirectory())) {
            return file;
        }
        return null;
    }

    public void C(com.bumptech.glide.load.engine.prefill.d.a... aVarArr) {
        this.f14186n.c(aVarArr);
    }

    public <T, Y> void D(Class<T> cls, Class<Y> cls2, com.bumptech.glide.load.model.m<T, Y> mVar) {
        com.bumptech.glide.load.model.m<T, Y> mVarG = this.f14173a.g(cls, cls2, mVar);
        if (mVarG != null) {
            mVarG.a();
        }
    }

    public void E(o oVar) {
        com.bumptech.glide.util.i.b();
        this.f14176d.a(oVar.a());
        this.f14175c.a(oVar.a());
    }

    public void I(int i7) {
        com.bumptech.glide.util.i.b();
        this.f14176d.e(i7);
        this.f14175c.e(i7);
    }

    @Deprecated
    public <T, Y> void J(Class<T> cls, Class<Y> cls2) {
        com.bumptech.glide.load.model.m<T, Y> mVarH = this.f14173a.h(cls, cls2);
        if (mVarH != null) {
            mVarH.a();
        }
    }

    <T, Z> a1.b<T, Z> a(Class<T> cls, Class<Z> cls2) {
        return this.f14180h.a(cls, cls2);
    }

    <R> com.bumptech.glide.request.target.m<R> d(ImageView imageView, Class<R> cls) {
        return this.f14178f.a(imageView, cls);
    }

    <Z, R> y0.f<Z, R> i(Class<Z> cls, Class<R> cls2) {
        return this.f14179g.a(cls, cls2);
    }

    public void m() {
        com.bumptech.glide.util.i.a();
        v().e();
    }

    public void n() {
        com.bumptech.glide.util.i.b();
        this.f14176d.f();
        this.f14175c.f();
    }

    com.bumptech.glide.load.resource.bitmap.f p() {
        return this.f14181i;
    }

    com.bumptech.glide.load.resource.bitmap.j q() {
        return this.f14183k;
    }

    public com.bumptech.glide.load.engine.bitmap_recycle.c r() {
        return this.f14175c;
    }

    w0.a s() {
        return this.f14177e;
    }

    com.bumptech.glide.load.resource.gifbitmap.f t() {
        return this.f14182j;
    }

    com.bumptech.glide.load.resource.gifbitmap.f u() {
        return this.f14184l;
    }

    com.bumptech.glide.load.engine.d v() {
        return this.f14174b;
    }

    Handler x() {
        return this.f14185m;
    }
}
