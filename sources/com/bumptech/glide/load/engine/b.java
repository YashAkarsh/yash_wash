package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.p;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
class b<A, T, Z> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f14236m = "DecodeJob";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final C0162b f14237n = new C0162b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f14238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f14240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bumptech.glide.load.data.c<A> f14241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a1.b<A, T> f14242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final w0.g<T> f14243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final y0.f<T, Z> f14244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a f14245h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.c f14246i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final p f14247j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final C0162b f14248k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile boolean f14249l;

    interface a {
        com.bumptech.glide.load.engine.cache.a a();
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.b$b, reason: collision with other inner class name */
    static class C0162b {
        C0162b() {
        }

        public OutputStream a(File file) throws FileNotFoundException {
            return new BufferedOutputStream(new FileOutputStream(file));
        }
    }

    class c<DataType> implements com.bumptech.glide.load.engine.cache.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final w0.b<DataType> f14250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DataType f14251b;

        public c(w0.b<DataType> bVar, DataType datatype) {
            this.f14250a = bVar;
            this.f14251b = datatype;
        }

        @Override // com.bumptech.glide.load.engine.cache.a.b
        public boolean a(File file) {
            OutputStream outputStreamA = null;
            try {
                outputStreamA = b.this.f14248k.a(file);
                boolean zB = this.f14250a.b(this.f14251b, outputStreamA);
                if (outputStreamA == null) {
                    return zB;
                }
                try {
                    return zB;
                } catch (IOException unused) {
                    return zB;
                }
            } catch (FileNotFoundException e8) {
                if (Log.isLoggable(b.f14236m, 3)) {
                    Log.d(b.f14236m, "Failed to find file to write to disk cache", e8);
                }
                return false;
            } finally {
                if (outputStreamA != null) {
                    try {
                        outputStreamA.close();
                    } catch (IOException unused2) {
                    }
                }
            }
        }
    }

    public b(g gVar, int i7, int i8, com.bumptech.glide.load.data.c<A> cVar, a1.b<A, T> bVar, w0.g<T> gVar2, y0.f<T, Z> fVar, a aVar, com.bumptech.glide.load.engine.c cVar2, p pVar) {
        this(gVar, i7, i8, cVar, bVar, gVar2, fVar, aVar, cVar2, pVar, f14237n);
    }

    private m<T> b(A a8) throws IOException {
        long jB = com.bumptech.glide.util.e.b();
        this.f14245h.a().c(this.f14238a.b(), new c(this.f14242e.e(), a8));
        if (Log.isLoggable(f14236m, 2)) {
            j("Wrote source to cache", jB);
        }
        long jB2 = com.bumptech.glide.util.e.b();
        m<T> mVarI = i(this.f14238a.b());
        if (Log.isLoggable(f14236m, 2) && mVarI != null) {
            j("Decoded source from cache", jB2);
        }
        return mVarI;
    }

    private m<T> e(A a8) throws IOException {
        if (this.f14246i.b()) {
            return b(a8);
        }
        long jB = com.bumptech.glide.util.e.b();
        m<T> mVarB = this.f14242e.j().b(a8, this.f14239b, this.f14240c);
        if (!Log.isLoggable(f14236m, 2)) {
            return mVarB;
        }
        j("Decoded from source", jB);
        return mVarB;
    }

    private m<T> g() throws Exception {
        try {
            long jB = com.bumptech.glide.util.e.b();
            A aC = this.f14241d.c(this.f14247j);
            if (Log.isLoggable(f14236m, 2)) {
                j("Fetched data", jB);
            }
            if (this.f14249l) {
                return null;
            }
            return e(aC);
        } finally {
            this.f14241d.b();
        }
    }

    private m<T> i(w0.c cVar) throws IOException {
        File fileA = this.f14245h.a().a(cVar);
        if (fileA == null) {
            return null;
        }
        try {
            m<T> mVarB = this.f14242e.k().b(fileA, this.f14239b, this.f14240c);
            if (mVarB == null) {
                this.f14245h.a().b(cVar);
            }
            return mVarB;
        } catch (Throwable th) {
            this.f14245h.a().b(cVar);
            throw th;
        }
    }

    private void j(String str, long j7) {
        Log.v(f14236m, str + " in " + com.bumptech.glide.util.e.a(j7) + ", key: " + this.f14238a);
    }

    private m<Z> k(m<T> mVar) {
        if (mVar == null) {
            return null;
        }
        return this.f14244g.b(mVar);
    }

    private m<T> l(m<T> mVar) {
        if (mVar == null) {
            return null;
        }
        m<T> mVarB = this.f14243f.b(mVar, this.f14239b, this.f14240c);
        if (!mVar.equals(mVarB)) {
            mVar.a();
        }
        return mVarB;
    }

    private m<Z> m(m<T> mVar) {
        long jB = com.bumptech.glide.util.e.b();
        m<T> mVarL = l(mVar);
        if (Log.isLoggable(f14236m, 2)) {
            j("Transformed resource from source", jB);
        }
        n(mVarL);
        long jB2 = com.bumptech.glide.util.e.b();
        m<Z> mVarK = k(mVarL);
        if (Log.isLoggable(f14236m, 2)) {
            j("Transcoded transformed from source", jB2);
        }
        return mVarK;
    }

    private void n(m<T> mVar) {
        if (mVar == null || !this.f14246i.a()) {
            return;
        }
        long jB = com.bumptech.glide.util.e.b();
        this.f14245h.a().c(this.f14238a, new c(this.f14242e.i(), mVar));
        if (Log.isLoggable(f14236m, 2)) {
            j("Wrote transformed from source to cache", jB);
        }
    }

    public void c() {
        this.f14249l = true;
        this.f14241d.cancel();
    }

    public m<Z> d() throws Exception {
        return m(g());
    }

    public m<Z> f() throws Exception {
        if (!this.f14246i.a()) {
            return null;
        }
        long jB = com.bumptech.glide.util.e.b();
        m<T> mVarI = i(this.f14238a);
        if (Log.isLoggable(f14236m, 2)) {
            j("Decoded transformed from cache", jB);
        }
        long jB2 = com.bumptech.glide.util.e.b();
        m<Z> mVarK = k(mVarI);
        if (Log.isLoggable(f14236m, 2)) {
            j("Transcoded transformed from cache", jB2);
        }
        return mVarK;
    }

    public m<Z> h() throws Exception {
        if (!this.f14246i.b()) {
            return null;
        }
        long jB = com.bumptech.glide.util.e.b();
        m<T> mVarI = i(this.f14238a.b());
        if (Log.isLoggable(f14236m, 2)) {
            j("Decoded source from cache", jB);
        }
        return m(mVarI);
    }

    b(g gVar, int i7, int i8, com.bumptech.glide.load.data.c<A> cVar, a1.b<A, T> bVar, w0.g<T> gVar2, y0.f<T, Z> fVar, a aVar, com.bumptech.glide.load.engine.c cVar2, p pVar, C0162b c0162b) {
        this.f14238a = gVar;
        this.f14239b = i7;
        this.f14240c = i8;
        this.f14241d = cVar;
        this.f14242e = bVar;
        this.f14243f = gVar2;
        this.f14244g = fVar;
        this.f14245h = aVar;
        this.f14246i = cVar2;
        this.f14247j = pVar;
        this.f14248k = c0162b;
    }
}
