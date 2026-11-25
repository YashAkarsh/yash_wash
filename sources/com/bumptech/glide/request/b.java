package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.alipay.sdk.util.j;
import com.bumptech.glide.p;
import com.bumptech.glide.request.target.k;
import com.bumptech.glide.request.target.m;
import com.bumptech.glide.util.i;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public final class b<A, T, Z, R> implements c, k, g {
    private static final String D = "GenericRequest";
    private static final Queue<b<?, ?, ?, ?>> E = i.d(0);
    private static final double F = 9.5367431640625E-7d;
    private com.bumptech.glide.load.engine.d.c A;
    private long B;
    private a C;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14820a = String.valueOf(hashCode());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private w0.c f14821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f14822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f14825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f14826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private w0.g<Z> f14827h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private a1.f<A, T, Z, R> f14828i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private d f14829j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private A f14830k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Class<R> f14831l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f14832m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private p f14833n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private m<R> f14834o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private f<? super A, R> f14835p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f14836q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private com.bumptech.glide.load.engine.d f14837r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private com.bumptech.glide.request.animation.f<R> f14838s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f14839t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f14840u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private com.bumptech.glide.load.engine.c f14841v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Drawable f14842w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Drawable f14843x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f14844y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private com.bumptech.glide.load.engine.m<?> f14845z;

    private enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    private b() {
    }

    private boolean k() {
        d dVar = this.f14829j;
        return dVar == null || dVar.d(this);
    }

    private boolean l() {
        d dVar = this.f14829j;
        return dVar == null || dVar.e(this);
    }

    private static void n(String str, Object obj, String str2) {
        if (obj == null) {
            StringBuilder sb = new StringBuilder(str);
            sb.append(" must not be null");
            if (str2 != null) {
                sb.append(", ");
                sb.append(str2);
            }
            throw new NullPointerException(sb.toString());
        }
    }

    private Drawable o() {
        if (this.f14843x == null && this.f14825f > 0) {
            this.f14843x = this.f14826g.getResources().getDrawable(this.f14825f);
        }
        return this.f14843x;
    }

    private Drawable p() {
        if (this.f14822c == null && this.f14823d > 0) {
            this.f14822c = this.f14826g.getResources().getDrawable(this.f14823d);
        }
        return this.f14822c;
    }

    private Drawable q() {
        if (this.f14842w == null && this.f14824e > 0) {
            this.f14842w = this.f14826g.getResources().getDrawable(this.f14824e);
        }
        return this.f14842w;
    }

    private void r(a1.f<A, T, Z, R> fVar, A a8, w0.c cVar, Context context, p pVar, m<R> mVar, float f8, Drawable drawable, int i7, Drawable drawable2, int i8, Drawable drawable3, int i9, f<? super A, R> fVar2, d dVar, com.bumptech.glide.load.engine.d dVar2, w0.g<Z> gVar, Class<R> cls, boolean z7, com.bumptech.glide.request.animation.f<R> fVar3, int i10, int i11, com.bumptech.glide.load.engine.c cVar2) {
        this.f14828i = fVar;
        this.f14830k = a8;
        this.f14821b = cVar;
        this.f14822c = drawable3;
        this.f14823d = i9;
        this.f14826g = context.getApplicationContext();
        this.f14833n = pVar;
        this.f14834o = mVar;
        this.f14836q = f8;
        this.f14842w = drawable;
        this.f14824e = i7;
        this.f14843x = drawable2;
        this.f14825f = i8;
        this.f14835p = fVar2;
        this.f14829j = dVar;
        this.f14837r = dVar2;
        this.f14827h = gVar;
        this.f14831l = cls;
        this.f14832m = z7;
        this.f14838s = fVar3;
        this.f14839t = i10;
        this.f14840u = i11;
        this.f14841v = cVar2;
        this.C = a.PENDING;
        if (a8 != null) {
            n("ModelLoader", fVar.l(), "try .using(ModelLoader)");
            n("Transcoder", fVar.h(), "try .as*(Class).transcode(ResourceTranscoder)");
            n("Transformation", gVar, "try .transform(UnitTransformation.get())");
            if (cVar2.b()) {
                n("SourceEncoder", fVar.e(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
            } else {
                n("SourceDecoder", fVar.j(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
            }
            if (cVar2.b() || cVar2.a()) {
                n("CacheDecoder", fVar.k(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
            }
            if (cVar2.a()) {
                n("Encoder", fVar.i(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
            }
        }
    }

    private boolean s() {
        d dVar = this.f14829j;
        return dVar == null || !dVar.b();
    }

    private void t(String str) {
        Log.v(D, str + " this: " + this.f14820a);
    }

    private void u() {
        d dVar = this.f14829j;
        if (dVar != null) {
            dVar.f(this);
        }
    }

    public static <A, T, Z, R> b<A, T, Z, R> v(a1.f<A, T, Z, R> fVar, A a8, w0.c cVar, Context context, p pVar, m<R> mVar, float f8, Drawable drawable, int i7, Drawable drawable2, int i8, Drawable drawable3, int i9, f<? super A, R> fVar2, d dVar, com.bumptech.glide.load.engine.d dVar2, w0.g<Z> gVar, Class<R> cls, boolean z7, com.bumptech.glide.request.animation.f<R> fVar3, int i10, int i11, com.bumptech.glide.load.engine.c cVar2) {
        b<A, T, Z, R> bVar = (b) E.poll();
        if (bVar == null) {
            bVar = new b<>();
        }
        bVar.r(fVar, a8, cVar, context, pVar, mVar, f8, drawable, i7, drawable2, i8, drawable3, i9, fVar2, dVar, dVar2, gVar, cls, z7, fVar3, i10, i11, cVar2);
        return bVar;
    }

    private void w(com.bumptech.glide.load.engine.m<?> mVar, R r7) {
        boolean zS = s();
        this.C = a.COMPLETE;
        this.f14845z = mVar;
        f<? super A, R> fVar = this.f14835p;
        if (fVar == null || !fVar.b(r7, this.f14830k, this.f14834o, this.f14844y, zS)) {
            this.f14834o.b(r7, this.f14838s.a(this.f14844y, zS));
        }
        u();
        if (Log.isLoggable(D, 2)) {
            t("Resource ready in " + com.bumptech.glide.util.e.a(this.B) + " size: " + (((double) mVar.b()) * F) + " fromCache: " + this.f14844y);
        }
    }

    private void x(com.bumptech.glide.load.engine.m mVar) {
        this.f14837r.l(mVar);
        this.f14845z = null;
    }

    private void y(Exception exc) {
        if (k()) {
            Drawable drawableP = this.f14830k == null ? p() : null;
            if (drawableP == null) {
                drawableP = o();
            }
            if (drawableP == null) {
                drawableP = q();
            }
            this.f14834o.c(exc, drawableP);
        }
    }

    @Override // com.bumptech.glide.request.c
    public void a() {
        this.f14828i = null;
        this.f14830k = null;
        this.f14826g = null;
        this.f14834o = null;
        this.f14842w = null;
        this.f14843x = null;
        this.f14822c = null;
        this.f14835p = null;
        this.f14829j = null;
        this.f14827h = null;
        this.f14838s = null;
        this.f14844y = false;
        this.A = null;
        E.offer(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.g
    public void b(com.bumptech.glide.load.engine.m<?> mVar) {
        if (mVar == null) {
            d(new Exception("Expected to receive a Resource<R> with an object of " + this.f14831l + " inside, but instead got null."));
            return;
        }
        Object obj = mVar.get();
        if (obj != null && this.f14831l.isAssignableFrom(obj.getClass())) {
            if (l()) {
                w(mVar, obj);
                return;
            } else {
                x(mVar);
                this.C = a.COMPLETE;
                return;
            }
        }
        x(mVar);
        StringBuilder sb = new StringBuilder();
        sb.append("Expected to receive an object of ");
        sb.append(this.f14831l);
        sb.append(" but instead got ");
        sb.append(obj != null ? obj.getClass() : "");
        sb.append("{");
        sb.append(obj);
        sb.append(j.f13808d);
        sb.append(" inside Resource{");
        sb.append(mVar);
        sb.append("}.");
        sb.append(obj == null ? " To indicate failure return a null Resource object, rather than a Resource object containing null data." : "");
        d(new Exception(sb.toString()));
    }

    @Override // com.bumptech.glide.request.c
    public boolean c() {
        return j();
    }

    @Override // com.bumptech.glide.request.c
    public void clear() {
        i.b();
        a aVar = this.C;
        a aVar2 = a.CLEARED;
        if (aVar == aVar2) {
            return;
        }
        m();
        com.bumptech.glide.load.engine.m<?> mVar = this.f14845z;
        if (mVar != null) {
            x(mVar);
        }
        if (k()) {
            this.f14834o.f(q());
        }
        this.C = aVar2;
    }

    @Override // com.bumptech.glide.request.g
    public void d(Exception exc) {
        if (Log.isLoggable(D, 3)) {
            Log.d(D, "load failed", exc);
        }
        this.C = a.FAILED;
        f<? super A, R> fVar = this.f14835p;
        if (fVar == null || !fVar.a(exc, this.f14830k, this.f14834o, s())) {
            y(exc);
        }
    }

    @Override // com.bumptech.glide.request.target.k
    public void e(int i7, int i8) {
        if (Log.isLoggable(D, 2)) {
            t("Got onSizeReady in " + com.bumptech.glide.util.e.a(this.B));
        }
        if (this.C != a.WAITING_FOR_SIZE) {
            return;
        }
        this.C = a.RUNNING;
        int iRound = Math.round(this.f14836q * i7);
        int iRound2 = Math.round(this.f14836q * i8);
        com.bumptech.glide.load.data.c<T> cVarA = this.f14828i.l().a(this.f14830k, iRound, iRound2);
        if (cVarA == null) {
            d(new Exception("Failed to load model: '" + this.f14830k + "'"));
            return;
        }
        y0.f<Z, R> fVarH = this.f14828i.h();
        if (Log.isLoggable(D, 2)) {
            t("finished setup for calling load in " + com.bumptech.glide.util.e.a(this.B));
        }
        this.f14844y = true;
        this.A = this.f14837r.h(this.f14821b, iRound, iRound2, cVarA, this.f14828i, this.f14827h, fVarH, this.f14833n, this.f14832m, this.f14841v, this);
        this.f14844y = this.f14845z != null;
        if (Log.isLoggable(D, 2)) {
            t("finished onSizeReady in " + com.bumptech.glide.util.e.a(this.B));
        }
    }

    @Override // com.bumptech.glide.request.c
    public boolean g() {
        return this.C == a.FAILED;
    }

    @Override // com.bumptech.glide.request.c
    public boolean h() {
        return this.C == a.PAUSED;
    }

    @Override // com.bumptech.glide.request.c
    public void i() {
        this.B = com.bumptech.glide.util.e.b();
        if (this.f14830k == null) {
            d(null);
            return;
        }
        this.C = a.WAITING_FOR_SIZE;
        if (i.m(this.f14839t, this.f14840u)) {
            e(this.f14839t, this.f14840u);
        } else {
            this.f14834o.h(this);
        }
        if (!j() && !g() && k()) {
            this.f14834o.d(q());
        }
        if (Log.isLoggable(D, 2)) {
            t("finished run method in " + com.bumptech.glide.util.e.a(this.B));
        }
    }

    @Override // com.bumptech.glide.request.c
    public boolean isCancelled() {
        a aVar = this.C;
        return aVar == a.CANCELLED || aVar == a.CLEARED;
    }

    @Override // com.bumptech.glide.request.c
    public boolean isRunning() {
        a aVar = this.C;
        return aVar == a.RUNNING || aVar == a.WAITING_FOR_SIZE;
    }

    @Override // com.bumptech.glide.request.c
    public boolean j() {
        return this.C == a.COMPLETE;
    }

    void m() {
        this.C = a.CANCELLED;
        com.bumptech.glide.load.engine.d.c cVar = this.A;
        if (cVar != null) {
            cVar.a();
            this.A = null;
        }
    }

    @Override // com.bumptech.glide.request.c
    public void pause() {
        clear();
        this.C = a.PAUSED;
    }
}
