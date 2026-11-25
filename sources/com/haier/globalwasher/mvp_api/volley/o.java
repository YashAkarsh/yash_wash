package com.haier.globalwasher.mvp_api.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f24929l = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicInteger f24930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Queue<n<?>>> f24931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<n<?>> f24932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PriorityBlockingQueue<n<?>> f24933d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PriorityBlockingQueue<n<?>> f24934e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.haier.globalwasher.mvp_api.volley.b f24935f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final g f24936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final q f24937h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private h[] f24938i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.haier.globalwasher.mvp_api.volley.c f24939j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<c> f24940k;

    class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f24941a;

        a(Object obj) {
            this.f24941a = obj;
        }

        @Override // com.haier.globalwasher.mvp_api.volley.o.b
        public boolean a(n<?> nVar) {
            return nVar.C() == this.f24941a;
        }
    }

    public interface b {
        boolean a(n<?> nVar);
    }

    public interface c<T> {
        void a(n<T> nVar);
    }

    public o(com.haier.globalwasher.mvp_api.volley.b bVar, g gVar, int i7, q qVar) {
        this.f24930a = new AtomicInteger();
        this.f24931b = new HashMap();
        this.f24932c = new HashSet();
        this.f24933d = new PriorityBlockingQueue<>();
        this.f24934e = new PriorityBlockingQueue<>();
        this.f24940k = new ArrayList();
        this.f24935f = bVar;
        this.f24936g = gVar;
        this.f24938i = new h[i7];
        this.f24937h = qVar;
    }

    public <T> n<T> a(n<T> nVar) {
        nVar.O(this);
        synchronized (this.f24932c) {
            this.f24932c.add(nVar);
        }
        nVar.Q(g());
        nVar.b("add-to-queue");
        if (!nVar.T()) {
            this.f24934e.add(nVar);
            return nVar;
        }
        synchronized (this.f24931b) {
            String strN = nVar.n();
            if (this.f24931b.containsKey(strN)) {
                Queue<n<?>> linkedList = this.f24931b.get(strN);
                if (linkedList == null) {
                    linkedList = new LinkedList<>();
                }
                linkedList.add(nVar);
                this.f24931b.put(strN, linkedList);
                if (v.f25046b) {
                    v.f("Request for cacheKey=%s is in flight, putting on hold.", strN);
                }
            } else {
                this.f24931b.put(strN, null);
                this.f24933d.add(nVar);
            }
        }
        return nVar;
    }

    public <T> void b(c<T> cVar) {
        synchronized (this.f24940k) {
            this.f24940k.add(cVar);
        }
    }

    public void c(b bVar) {
        synchronized (this.f24932c) {
            for (n<?> nVar : this.f24932c) {
                if (bVar.a(nVar)) {
                    nVar.c();
                }
            }
        }
    }

    public void d(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Cannot cancelAll with a null tag");
        }
        c(new a(obj));
    }

    <T> void e(n<T> nVar) {
        synchronized (this.f24932c) {
            this.f24932c.remove(nVar);
        }
        synchronized (this.f24940k) {
            Iterator<c> it = this.f24940k.iterator();
            while (it.hasNext()) {
                it.next().a(nVar);
            }
        }
        if (nVar.T()) {
            synchronized (this.f24931b) {
                String strN = nVar.n();
                Queue<n<?>> queueRemove = this.f24931b.remove(strN);
                if (queueRemove != null) {
                    if (v.f25046b) {
                        v.f("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(queueRemove.size()), strN);
                    }
                    this.f24933d.addAll(queueRemove);
                }
            }
        }
    }

    public com.haier.globalwasher.mvp_api.volley.b f() {
        return this.f24935f;
    }

    public int g() {
        return this.f24930a.incrementAndGet();
    }

    public <T> void h(c<T> cVar) {
        synchronized (this.f24940k) {
            this.f24940k.remove(cVar);
        }
    }

    public void i() {
        j();
        com.haier.globalwasher.mvp_api.volley.c cVar = new com.haier.globalwasher.mvp_api.volley.c(this.f24933d, this.f24934e, this.f24935f, this.f24937h);
        this.f24939j = cVar;
        cVar.start();
        for (int i7 = 0; i7 < this.f24938i.length; i7++) {
            h hVar = new h(this.f24934e, this.f24936g, this.f24935f, this.f24937h);
            this.f24938i[i7] = hVar;
            hVar.start();
        }
    }

    public void j() {
        com.haier.globalwasher.mvp_api.volley.c cVar = this.f24939j;
        if (cVar != null) {
            cVar.b();
        }
        int i7 = 0;
        while (true) {
            h[] hVarArr = this.f24938i;
            if (i7 >= hVarArr.length) {
                return;
            }
            h hVar = hVarArr[i7];
            if (hVar != null) {
                hVar.c();
            }
            i7++;
        }
    }

    public o(com.haier.globalwasher.mvp_api.volley.b bVar, g gVar, int i7) {
        this(bVar, gVar, i7, new e(new Handler(Looper.getMainLooper())));
    }

    public o(com.haier.globalwasher.mvp_api.volley.b bVar, g gVar) {
        this(bVar, gVar, 4);
    }
}
