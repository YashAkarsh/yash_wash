package com.bumptech.glide;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class q implements com.bumptech.glide.manager.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f14776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.manager.g f14777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.manager.l f14778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.manager.m f14779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final l f14780e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e f14781f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f14782g;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bumptech.glide.manager.g f14783a;

        a(com.bumptech.glide.manager.g gVar) {
            this.f14783a = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14783a.a(q.this);
        }
    }

    public interface b {
        <T> void a(h<T, ?, ?, ?> hVar);
    }

    public final class d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.model.l<T, InputStream> f14792a;

        d(com.bumptech.glide.load.model.l<T, InputStream> lVar) {
            this.f14792a = lVar;
        }

        public com.bumptech.glide.g<T> a(Class<T> cls) {
            return (com.bumptech.glide.g) q.this.f14781f.a(new com.bumptech.glide.g(cls, this.f14792a, null, q.this.f14776a, q.this.f14780e, q.this.f14779d, q.this.f14777b, q.this.f14781f));
        }

        public com.bumptech.glide.g<T> b(T t7) {
            return (com.bumptech.glide.g) a(q.y(t7)).H(t7);
        }
    }

    class e {
        e() {
        }

        public <A, X extends h<A, ?, ?, ?>> X a(X x7) {
            if (q.this.f14782g != null) {
                q.this.f14782g.a(x7);
            }
            return x7;
        }
    }

    private static class f implements com.bumptech.glide.manager.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.manager.m f14795a;

        public f(com.bumptech.glide.manager.m mVar) {
            this.f14795a = mVar;
        }

        @Override // com.bumptech.glide.manager.c.a
        public void a(boolean z7) {
            if (z7) {
                this.f14795a.f();
            }
        }
    }

    public final class g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.model.l<T, ParcelFileDescriptor> f14796a;

        g(com.bumptech.glide.load.model.l<T, ParcelFileDescriptor> lVar) {
            this.f14796a = lVar;
        }

        public com.bumptech.glide.g<T> a(T t7) {
            return (com.bumptech.glide.g) ((com.bumptech.glide.g) q.this.f14781f.a(new com.bumptech.glide.g(q.y(t7), null, this.f14796a, q.this.f14776a, q.this.f14780e, q.this.f14779d, q.this.f14777b, q.this.f14781f))).H(t7);
        }
    }

    public q(Context context, com.bumptech.glide.manager.g gVar, com.bumptech.glide.manager.l lVar) {
        this(context, gVar, lVar, new com.bumptech.glide.manager.m(), new com.bumptech.glide.manager.d());
    }

    private <T> com.bumptech.glide.g<T> K(Class<T> cls) {
        com.bumptech.glide.load.model.l lVarG = l.g(cls, this.f14776a);
        com.bumptech.glide.load.model.l lVarB = l.b(cls, this.f14776a);
        if (cls == null || lVarG != null || lVarB != null) {
            e eVar = this.f14781f;
            return (com.bumptech.glide.g) eVar.a(new com.bumptech.glide.g(cls, lVarG, lVarB, this.f14776a, this.f14780e, this.f14779d, this.f14777b, eVar));
        }
        throw new IllegalArgumentException("Unknown type " + cls + ". You must provide a Model of a type for which there is a registered ModelLoader, if you are using a custom model, you must first call Glide#register with a ModelLoaderFactory for your custom model class");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> Class<T> y(T t7) {
        if (t7 != null) {
            return (Class<T>) t7.getClass();
        }
        return null;
    }

    public com.bumptech.glide.g<Uri> A(Uri uri) {
        return (com.bumptech.glide.g) w().H(uri);
    }

    public com.bumptech.glide.g<File> B(File file) {
        return (com.bumptech.glide.g) s().H(file);
    }

    public com.bumptech.glide.g<Integer> C(Integer num) {
        return (com.bumptech.glide.g) u().H(num);
    }

    public <T> com.bumptech.glide.g<T> D(T t7) {
        return (com.bumptech.glide.g) K(y(t7)).H(t7);
    }

    public com.bumptech.glide.g<String> E(String str) {
        return (com.bumptech.glide.g) v().H(str);
    }

    @Deprecated
    public com.bumptech.glide.g<URL> F(URL url) {
        return (com.bumptech.glide.g) x().H(url);
    }

    public com.bumptech.glide.g<byte[]> G(byte[] bArr) {
        return (com.bumptech.glide.g) r().H(bArr);
    }

    @Deprecated
    public com.bumptech.glide.g<byte[]> H(byte[] bArr, String str) {
        return (com.bumptech.glide.g) G(bArr).Q(new com.bumptech.glide.signature.d(str));
    }

    public com.bumptech.glide.g<Uri> I(Uri uri) {
        return (com.bumptech.glide.g) t().H(uri);
    }

    @Deprecated
    public com.bumptech.glide.g<Uri> J(Uri uri, String str, long j7, int i7) {
        return (com.bumptech.glide.g) I(uri).Q(new com.bumptech.glide.signature.c(str, j7, i7));
    }

    public void L() {
        this.f14780e.n();
    }

    public void M(int i7) {
        this.f14780e.I(i7);
    }

    public void N() {
        com.bumptech.glide.util.i.b();
        this.f14779d.d();
    }

    public void O() {
        com.bumptech.glide.util.i.b();
        N();
        Iterator<q> it = this.f14778c.a().iterator();
        while (it.hasNext()) {
            it.next().N();
        }
    }

    public void P() {
        com.bumptech.glide.util.i.b();
        this.f14779d.g();
    }

    public void Q() {
        com.bumptech.glide.util.i.b();
        P();
        Iterator<q> it = this.f14778c.a().iterator();
        while (it.hasNext()) {
            it.next().P();
        }
    }

    public void R(b bVar) {
        this.f14782g = bVar;
    }

    public <A, T> c<A, T> S(com.bumptech.glide.load.model.l<A, T> lVar, Class<T> cls) {
        return new c<>(lVar, cls);
    }

    public d<byte[]> T(com.bumptech.glide.load.model.stream.d dVar) {
        return new d<>(dVar);
    }

    public <T> d<T> U(com.bumptech.glide.load.model.stream.f<T> fVar) {
        return new d<>(fVar);
    }

    public <T> g<T> V(com.bumptech.glide.load.model.file_descriptor.b<T> bVar) {
        return new g<>(bVar);
    }

    @Override // com.bumptech.glide.manager.h
    public void g() {
        N();
    }

    @Override // com.bumptech.glide.manager.h
    public void k() {
        this.f14779d.b();
    }

    @Override // com.bumptech.glide.manager.h
    public void onStart() {
        P();
    }

    public <T> com.bumptech.glide.g<T> q(Class<T> cls) {
        return K(cls);
    }

    public com.bumptech.glide.g<byte[]> r() {
        return (com.bumptech.glide.g) K(byte[].class).Q(new com.bumptech.glide.signature.d(UUID.randomUUID().toString())).u(com.bumptech.glide.load.engine.c.NONE).S(true);
    }

    public com.bumptech.glide.g<File> s() {
        return K(File.class);
    }

    public com.bumptech.glide.g<Uri> t() {
        com.bumptech.glide.load.model.stream.c cVar = new com.bumptech.glide.load.model.stream.c(this.f14776a, l.g(Uri.class, this.f14776a));
        com.bumptech.glide.load.model.l lVarB = l.b(Uri.class, this.f14776a);
        e eVar = this.f14781f;
        return (com.bumptech.glide.g) eVar.a(new com.bumptech.glide.g(Uri.class, cVar, lVarB, this.f14776a, this.f14780e, this.f14779d, this.f14777b, eVar));
    }

    public com.bumptech.glide.g<Integer> u() {
        return (com.bumptech.glide.g) K(Integer.class).Q(com.bumptech.glide.signature.a.a(this.f14776a));
    }

    public com.bumptech.glide.g<String> v() {
        return K(String.class);
    }

    public com.bumptech.glide.g<Uri> w() {
        return K(Uri.class);
    }

    @Deprecated
    public com.bumptech.glide.g<URL> x() {
        return K(URL.class);
    }

    public boolean z() {
        com.bumptech.glide.util.i.b();
        return this.f14779d.c();
    }

    q(Context context, com.bumptech.glide.manager.g gVar, com.bumptech.glide.manager.l lVar, com.bumptech.glide.manager.m mVar, com.bumptech.glide.manager.d dVar) {
        this.f14776a = context.getApplicationContext();
        this.f14777b = gVar;
        this.f14778c = lVar;
        this.f14779d = mVar;
        this.f14780e = l.o(context);
        this.f14781f = new e();
        com.bumptech.glide.manager.c cVarA = dVar.a(context, new f(mVar));
        if (com.bumptech.glide.util.i.j()) {
            new Handler(Looper.getMainLooper()).post(new a(gVar));
        } else {
            gVar.a(this);
        }
        gVar.a(cVarA);
    }

    public final class c<A, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.model.l<A, T> f14785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<T> f14786b;

        c(com.bumptech.glide.load.model.l<A, T> lVar, Class<T> cls) {
            this.f14785a = lVar;
            this.f14786b = cls;
        }

        public c<A, T>.a c(Class<A> cls) {
            return new a((Class) cls);
        }

        public c<A, T>.a d(A a8) {
            return new a(a8);
        }

        public final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final A f14788a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Class<A> f14789b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final boolean f14790c;

            a(A a8) {
                this.f14790c = true;
                this.f14788a = a8;
                this.f14789b = q.y(a8);
            }

            public <Z> i<A, T, Z> a(Class<Z> cls) {
                i<A, T, Z> iVar = (i) q.this.f14781f.a(new i(q.this.f14776a, q.this.f14780e, this.f14789b, c.this.f14785a, c.this.f14786b, cls, q.this.f14779d, q.this.f14777b, q.this.f14781f));
                if (this.f14790c) {
                    iVar.H(this.f14788a);
                }
                return iVar;
            }

            a(Class<A> cls) {
                this.f14790c = false;
                this.f14788a = null;
                this.f14789b = cls;
            }
        }
    }
}
