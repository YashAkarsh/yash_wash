package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
class e implements j.a {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final b f14363q = new b();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final Handler f14364r = new Handler(Looper.getMainLooper(), new c());

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f14365s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f14366t = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.bumptech.glide.request.g> f14367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f14368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f f14369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final w0.c f14370d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ExecutorService f14371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ExecutorService f14372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f14373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f14374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private m<?> f14375i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f14376j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Exception f14377k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f14378l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Set<com.bumptech.glide.request.g> f14379m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private j f14380n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private i<?> f14381o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private volatile Future<?> f14382p;

    static class b {
        b() {
        }

        public <R> i<R> a(m<R> mVar, boolean z7) {
            return new i<>(mVar, z7);
        }
    }

    private static class c implements Handler.Callback {
        private c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i7 = message.what;
            if (1 != i7 && 2 != i7) {
                return false;
            }
            e eVar = (e) message.obj;
            if (1 == i7) {
                eVar.j();
            } else {
                eVar.i();
            }
            return true;
        }
    }

    public e(w0.c cVar, ExecutorService executorService, ExecutorService executorService2, boolean z7, f fVar) {
        this(cVar, executorService, executorService2, z7, fVar, f14363q);
    }

    private void g(com.bumptech.glide.request.g gVar) {
        if (this.f14379m == null) {
            this.f14379m = new HashSet();
        }
        this.f14379m.add(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f14374h) {
            return;
        }
        if (this.f14367a.isEmpty()) {
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        }
        this.f14378l = true;
        this.f14369c.c(this.f14370d, null);
        for (com.bumptech.glide.request.g gVar : this.f14367a) {
            if (!l(gVar)) {
                gVar.d(this.f14377k);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.f14374h) {
            this.f14375i.a();
            return;
        }
        if (this.f14367a.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        }
        i<?> iVarA = this.f14368b.a(this.f14375i, this.f14373g);
        this.f14381o = iVarA;
        this.f14376j = true;
        iVarA.c();
        this.f14369c.c(this.f14370d, this.f14381o);
        for (com.bumptech.glide.request.g gVar : this.f14367a) {
            if (!l(gVar)) {
                this.f14381o.c();
                gVar.b(this.f14381o);
            }
        }
        this.f14381o.e();
    }

    private boolean l(com.bumptech.glide.request.g gVar) {
        Set<com.bumptech.glide.request.g> set = this.f14379m;
        return set != null && set.contains(gVar);
    }

    @Override // com.bumptech.glide.request.g
    public void b(m<?> mVar) {
        this.f14375i = mVar;
        f14364r.obtainMessage(1, this).sendToTarget();
    }

    @Override // com.bumptech.glide.request.g
    public void d(Exception exc) {
        this.f14377k = exc;
        f14364r.obtainMessage(2, this).sendToTarget();
    }

    public void e(com.bumptech.glide.request.g gVar) {
        com.bumptech.glide.util.i.b();
        if (this.f14376j) {
            gVar.b(this.f14381o);
        } else if (this.f14378l) {
            gVar.d(this.f14377k);
        } else {
            this.f14367a.add(gVar);
        }
    }

    @Override // com.bumptech.glide.load.engine.j.a
    public void f(j jVar) {
        this.f14382p = this.f14372f.submit(jVar);
    }

    void h() {
        if (this.f14378l || this.f14376j || this.f14374h) {
            return;
        }
        this.f14380n.b();
        Future<?> future = this.f14382p;
        if (future != null) {
            future.cancel(true);
        }
        this.f14374h = true;
        this.f14369c.b(this, this.f14370d);
    }

    boolean k() {
        return this.f14374h;
    }

    public void m(com.bumptech.glide.request.g gVar) {
        com.bumptech.glide.util.i.b();
        if (this.f14376j || this.f14378l) {
            g(gVar);
            return;
        }
        this.f14367a.remove(gVar);
        if (this.f14367a.isEmpty()) {
            h();
        }
    }

    public void n(j jVar) {
        this.f14380n = jVar;
        this.f14382p = this.f14371e.submit(jVar);
    }

    public e(w0.c cVar, ExecutorService executorService, ExecutorService executorService2, boolean z7, f fVar, b bVar) {
        this.f14367a = new ArrayList();
        this.f14370d = cVar;
        this.f14371e = executorService;
        this.f14372f = executorService2;
        this.f14373g = z7;
        this.f14369c = fVar;
        this.f14368b = bVar;
    }
}
