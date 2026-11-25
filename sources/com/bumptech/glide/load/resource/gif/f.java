package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.l;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f14651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.gifdecoder.a f14652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f14653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f14655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.bumptech.glide.h<com.bumptech.glide.gifdecoder.a, com.bumptech.glide.gifdecoder.a, Bitmap, Bitmap> f14656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f14657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f14658h;

    static class b extends com.bumptech.glide.request.target.j<Bitmap> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Handler f14659d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f14660e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f14661f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Bitmap f14662g;

        public b(Handler handler, int i7, long j7) {
            this.f14659d = handler;
            this.f14660e = i7;
            this.f14661f = j7;
        }

        public Bitmap j() {
            return this.f14662g;
        }

        @Override // com.bumptech.glide.request.target.m
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void b(Bitmap bitmap, com.bumptech.glide.request.animation.e<? super Bitmap> eVar) {
            this.f14662g = bitmap;
            this.f14659d.sendMessageAtTime(this.f14659d.obtainMessage(1, this), this.f14661f);
        }
    }

    public interface c {
        void a(int i7);
    }

    private class d implements Handler.Callback {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f14663b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f14664c = 2;

        private d() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i7 = message.what;
            if (i7 == 1) {
                f.this.e((b) message.obj);
                return true;
            }
            if (i7 != 2) {
                return false;
            }
            l.l((b) message.obj);
            return false;
        }
    }

    static class e implements w0.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final UUID f14666b;

        public e() {
            this(UUID.randomUUID());
        }

        @Override // w0.c
        public void a(MessageDigest messageDigest) throws UnsupportedEncodingException {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // w0.c
        public boolean equals(Object obj) {
            if (obj instanceof e) {
                return ((e) obj).f14666b.equals(this.f14666b);
            }
            return false;
        }

        @Override // w0.c
        public int hashCode() {
            return this.f14666b.hashCode();
        }

        e(UUID uuid) {
            this.f14666b = uuid;
        }
    }

    public f(Context context, c cVar, com.bumptech.glide.gifdecoder.a aVar, int i7, int i8) {
        this(cVar, aVar, null, c(context, aVar, i7, i8, l.o(context).r()));
    }

    private static com.bumptech.glide.h<com.bumptech.glide.gifdecoder.a, com.bumptech.glide.gifdecoder.a, Bitmap, Bitmap> c(Context context, com.bumptech.glide.gifdecoder.a aVar, int i7, int i8, com.bumptech.glide.load.engine.bitmap_recycle.c cVar) {
        h hVar = new h(cVar);
        g gVar = new g();
        return l.M(context).S(gVar, com.bumptech.glide.gifdecoder.a.class).d(aVar).a(Bitmap.class).T(com.bumptech.glide.load.resource.b.c()).t(hVar).S(true).u(com.bumptech.glide.load.engine.c.NONE).J(i7, i8);
    }

    private void d() {
        if (!this.f14654d || this.f14655e) {
            return;
        }
        this.f14655e = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) this.f14652b.m());
        this.f14652b.a();
        this.f14656f.Q(new e()).F(new b(this.f14653c, this.f14652b.d(), jUptimeMillis));
    }

    public void a() {
        h();
        b bVar = this.f14657g;
        if (bVar != null) {
            l.l(bVar);
            this.f14657g = null;
        }
        this.f14658h = true;
    }

    public Bitmap b() {
        b bVar = this.f14657g;
        if (bVar != null) {
            return bVar.j();
        }
        return null;
    }

    void e(b bVar) {
        if (this.f14658h) {
            this.f14653c.obtainMessage(2, bVar).sendToTarget();
            return;
        }
        b bVar2 = this.f14657g;
        this.f14657g = bVar;
        this.f14651a.a(bVar.f14660e);
        if (bVar2 != null) {
            this.f14653c.obtainMessage(2, bVar2).sendToTarget();
        }
        this.f14655e = false;
        d();
    }

    public void f(w0.g<Bitmap> gVar) {
        if (gVar == null) {
            throw new NullPointerException("Transformation must not be null");
        }
        this.f14656f = this.f14656f.X(gVar);
    }

    public void g() {
        if (this.f14654d) {
            return;
        }
        this.f14654d = true;
        this.f14658h = false;
        d();
    }

    public void h() {
        this.f14654d = false;
    }

    f(c cVar, com.bumptech.glide.gifdecoder.a aVar, Handler handler, com.bumptech.glide.h<com.bumptech.glide.gifdecoder.a, com.bumptech.glide.gifdecoder.a, Bitmap, Bitmap> hVar) {
        this.f14654d = false;
        this.f14655e = false;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new d()) : handler;
        this.f14651a = cVar;
        this.f14652b = aVar;
        this.f14653c = handler;
        this.f14656f = hVar;
    }
}
