package com.bumptech.glide.load.engine;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import com.bumptech.glide.p;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public class d implements f, com.bumptech.glide.load.engine.cache.i.a, i.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f14344i = "Engine";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<w0.c, com.bumptech.glide.load.engine.e> f14345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f14346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.cache.i f14347c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f14348d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<w0.c, WeakReference<i<?>>> f14349e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final n f14350f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final b f14351g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ReferenceQueue<i<?>> f14352h;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ExecutorService f14353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ExecutorService f14354b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final f f14355c;

        public a(ExecutorService executorService, ExecutorService executorService2, f fVar) {
            this.f14353a = executorService;
            this.f14354b = executorService2;
            this.f14355c = fVar;
        }

        public com.bumptech.glide.load.engine.e a(w0.c cVar, boolean z7) {
            return new com.bumptech.glide.load.engine.e(cVar, this.f14353a, this.f14354b, z7, this.f14355c);
        }
    }

    private static class b implements com.bumptech.glide.load.engine.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.engine.cache.a.InterfaceC0164a f14356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile com.bumptech.glide.load.engine.cache.a f14357b;

        public b(com.bumptech.glide.load.engine.cache.a.InterfaceC0164a interfaceC0164a) {
            this.f14356a = interfaceC0164a;
        }

        @Override // com.bumptech.glide.load.engine.b.a
        public com.bumptech.glide.load.engine.cache.a a() {
            if (this.f14357b == null) {
                synchronized (this) {
                    if (this.f14357b == null) {
                        this.f14357b = this.f14356a.build();
                    }
                    if (this.f14357b == null) {
                        this.f14357b = new com.bumptech.glide.load.engine.cache.b();
                    }
                }
            }
            return this.f14357b;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.engine.e f14358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.request.g f14359b;

        public c(com.bumptech.glide.request.g gVar, com.bumptech.glide.load.engine.e eVar) {
            this.f14359b = gVar;
            this.f14358a = eVar;
        }

        public void a() {
            this.f14358a.m(this.f14359b);
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.d$d, reason: collision with other inner class name */
    private static class C0166d implements MessageQueue.IdleHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<w0.c, WeakReference<i<?>>> f14360a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ReferenceQueue<i<?>> f14361b;

        public C0166d(Map<w0.c, WeakReference<i<?>>> map, ReferenceQueue<i<?>> referenceQueue) {
            this.f14360a = map;
            this.f14361b = referenceQueue;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            e eVar = (e) this.f14361b.poll();
            if (eVar == null) {
                return true;
            }
            this.f14360a.remove(eVar.f14362a);
            return true;
        }
    }

    private static class e extends WeakReference<i<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final w0.c f14362a;

        public e(w0.c cVar, i<?> iVar, ReferenceQueue<? super i<?>> referenceQueue) {
            super(iVar, referenceQueue);
            this.f14362a = cVar;
        }
    }

    public d(com.bumptech.glide.load.engine.cache.i iVar, com.bumptech.glide.load.engine.cache.a.InterfaceC0164a interfaceC0164a, ExecutorService executorService, ExecutorService executorService2) {
        this(iVar, interfaceC0164a, executorService, executorService2, null, null, null, null, null);
    }

    private i<?> f(w0.c cVar) {
        m<?> mVarG = this.f14347c.g(cVar);
        if (mVarG == null) {
            return null;
        }
        return mVarG instanceof i ? (i) mVarG : new i<>(mVarG, true);
    }

    private ReferenceQueue<i<?>> g() {
        if (this.f14352h == null) {
            this.f14352h = new ReferenceQueue<>();
            Looper.myQueue().addIdleHandler(new C0166d(this.f14349e, this.f14352h));
        }
        return this.f14352h;
    }

    private i<?> i(w0.c cVar, boolean z7) {
        i<?> iVar = null;
        if (!z7) {
            return null;
        }
        WeakReference<i<?>> weakReference = this.f14349e.get(cVar);
        if (weakReference != null) {
            iVar = weakReference.get();
            if (iVar != null) {
                iVar.c();
            } else {
                this.f14349e.remove(cVar);
            }
        }
        return iVar;
    }

    private i<?> j(w0.c cVar, boolean z7) {
        if (!z7) {
            return null;
        }
        i<?> iVarF = f(cVar);
        if (iVarF != null) {
            iVarF.c();
            this.f14349e.put(cVar, new e(cVar, iVarF, g()));
        }
        return iVarF;
    }

    private static void k(String str, long j7, w0.c cVar) {
        Log.v(f14344i, str + " in " + com.bumptech.glide.util.e.a(j7) + "ms, key: " + cVar);
    }

    @Override // com.bumptech.glide.load.engine.cache.i.a
    public void a(m<?> mVar) {
        com.bumptech.glide.util.i.b();
        this.f14350f.a(mVar);
    }

    @Override // com.bumptech.glide.load.engine.f
    public void b(com.bumptech.glide.load.engine.e eVar, w0.c cVar) {
        com.bumptech.glide.util.i.b();
        if (eVar.equals(this.f14345a.get(cVar))) {
            this.f14345a.remove(cVar);
        }
    }

    @Override // com.bumptech.glide.load.engine.f
    public void c(w0.c cVar, i<?> iVar) {
        com.bumptech.glide.util.i.b();
        if (iVar != null) {
            iVar.f(cVar, this);
            if (iVar.d()) {
                this.f14349e.put(cVar, new e(cVar, iVar, g()));
            }
        }
        this.f14345a.remove(cVar);
    }

    @Override // com.bumptech.glide.load.engine.i.a
    public void d(w0.c cVar, i iVar) {
        com.bumptech.glide.util.i.b();
        this.f14349e.remove(cVar);
        if (iVar.d()) {
            this.f14347c.d(cVar, iVar);
        } else {
            this.f14350f.a(iVar);
        }
    }

    public void e() {
        this.f14351g.a().clear();
    }

    public <T, Z, R> c h(w0.c cVar, int i7, int i8, com.bumptech.glide.load.data.c<T> cVar2, a1.b<T, Z> bVar, w0.g<Z> gVar, y0.f<Z, R> fVar, p pVar, boolean z7, com.bumptech.glide.load.engine.c cVar3, com.bumptech.glide.request.g gVar2) {
        com.bumptech.glide.util.i.b();
        long jB = com.bumptech.glide.util.e.b();
        g gVarA = this.f14346b.a(cVar2.a(), cVar, i7, i8, bVar.k(), bVar.j(), gVar, bVar.i(), fVar, bVar.e());
        i<?> iVarJ = j(gVarA, z7);
        if (iVarJ != null) {
            gVar2.b(iVarJ);
            if (Log.isLoggable(f14344i, 2)) {
                k("Loaded resource from cache", jB, gVarA);
            }
            return null;
        }
        i<?> iVarI = i(gVarA, z7);
        if (iVarI != null) {
            gVar2.b(iVarI);
            if (Log.isLoggable(f14344i, 2)) {
                k("Loaded resource from active resources", jB, gVarA);
            }
            return null;
        }
        com.bumptech.glide.load.engine.e eVar = this.f14345a.get(gVarA);
        if (eVar != null) {
            eVar.e(gVar2);
            if (Log.isLoggable(f14344i, 2)) {
                k("Added to existing load", jB, gVarA);
            }
            return new c(gVar2, eVar);
        }
        com.bumptech.glide.load.engine.e eVarA = this.f14348d.a(gVarA, z7);
        j jVar = new j(eVarA, new com.bumptech.glide.load.engine.b(gVarA, i7, i8, cVar2, bVar, gVar, fVar, this.f14351g, cVar3, pVar), pVar);
        this.f14345a.put(gVarA, eVarA);
        eVarA.e(gVar2);
        eVarA.n(jVar);
        if (Log.isLoggable(f14344i, 2)) {
            k("Started new load", jB, gVarA);
        }
        return new c(gVar2, eVarA);
    }

    public void l(m mVar) {
        com.bumptech.glide.util.i.b();
        if (!(mVar instanceof i)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((i) mVar).e();
    }

    d(com.bumptech.glide.load.engine.cache.i iVar, com.bumptech.glide.load.engine.cache.a.InterfaceC0164a interfaceC0164a, ExecutorService executorService, ExecutorService executorService2, Map<w0.c, com.bumptech.glide.load.engine.e> map, h hVar, Map<w0.c, WeakReference<i<?>>> map2, a aVar, n nVar) {
        this.f14347c = iVar;
        this.f14351g = new b(interfaceC0164a);
        this.f14349e = map2 == null ? new HashMap<>() : map2;
        this.f14346b = hVar == null ? new h() : hVar;
        this.f14345a = map == null ? new HashMap<>() : map;
        this.f14348d = aVar == null ? new a(executorService, executorService2, this) : aVar;
        this.f14350f = nVar == null ? new n() : nVar;
        iVar.h(this);
    }
}
