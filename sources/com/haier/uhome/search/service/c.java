package com.haier.uhome.search.service;

import android.text.TextUtils;
import com.haier.uhome.search.json.notify.UnconnectedDevInfo;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.haier.uhome.search.service.a implements com.haier.uhome.search.a.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.haier.uhome.search.a.f f29824g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile ScheduledFuture<?> f29826i;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f29825h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.haier.library.common.util.j<String, com.haier.uhome.search.a.c> f29823f = new com.haier.library.common.util.j<String, com.haier.uhome.search.a.c>() { // from class: com.haier.uhome.search.service.c.1
        @Override // com.haier.library.common.util.j
        public void a(String str, com.haier.uhome.search.a.c cVar) {
        }

        @Override // com.haier.library.common.util.j
        public void b(String str, com.haier.uhome.search.a.c cVar) {
            if (cVar != null) {
                c.this.e(cVar.a(), 10);
            }
        }
    };

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f29828a = new c();

        private a() {
        }
    }

    private int a(int i7) {
        if (i7 == 0 || i7 == 2) {
            return 1;
        }
        if (i7 == 3) {
            return 2;
        }
        return i7;
    }

    private ScheduledFuture b(final String str, final com.haier.uhome.search.a.j<Void> jVar) {
        return com.haier.library.common.thread.m.scheduleWithFixedDelayToFuture(new Runnable() { // from class: com.haier.uhome.search.service.q
            @Override // java.lang.Runnable
            public final void run() {
                this.f30024a.c(str, jVar);
            }
        }, 0L, 5L, TimeUnit.SECONDS);
    }

    public static c c() {
        return a.f29828a;
    }

    uSDKError d() {
        if (!this.f29825h.get()) {
            e3.a.v("LAN search: unconnected dev search is already stop!", new Object[0]);
            return ErrorConst.RET_USDK_OK.toError();
        }
        if (this.f29826i == null) {
            e3.a.v("LAN search: unconnected dev search task error!", new Object[0]);
            this.f29825h.set(false);
            return ErrorConst.ERR_INTERNAL.toError();
        }
        synchronized (this) {
            if (!this.f29826i.isCancelled()) {
                this.f29826i.cancel(true);
            }
            this.f29826i = null;
            this.f29825h.set(false);
            this.f29823f.clear();
        }
        return ErrorConst.RET_USDK_OK.toError();
    }

    private void b(com.haier.uhome.search.a.c cVar) {
        com.haier.uhome.search.a.f fVar = this.f29824g;
        if (fVar != null) {
            fVar.onDeviceUpdate(cVar.clone());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str, com.haier.uhome.search.a.j jVar) {
        synchronized (this.f29825h) {
            int iB = this.f29792e.b(str);
            boolean z7 = true;
            e3.a.e("LAN search: startUnconnectedDevSearch ret = %d", Integer.valueOf(iB));
            AtomicBoolean atomicBoolean = this.f29825h;
            if (iB != 0) {
                z7 = false;
            }
            if (atomicBoolean.compareAndSet(false, z7)) {
                jVar.onSuccess(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str, int i7) {
        if (str == null) {
            e3.a.v("LAN search: handleConfigDeviceDel with null deviceId", new Object[0]);
            return;
        }
        e3.a.e("LAN search: handleConfigDeviceDel %s", str);
        com.haier.uhome.search.a.c cVar = this.f29823f.get(str);
        if (cVar != null) {
            this.f29823f.remove(str);
            com.haier.uhome.search.a.f fVar = this.f29824g;
            if (fVar != null) {
                fVar.onDeviceDel(cVar.clone(), i7);
            }
        }
    }

    void a(com.haier.uhome.search.a.f fVar) {
        this.f29824g = fVar;
    }

    void a(String str, com.haier.uhome.search.a.j<Void> jVar) {
        if (!com.haier.library.common.util.w.m(com.haier.uhome.usdk.base.service.e.a().b())) {
            e3.a.v("LAN search: wifi disable!", new Object[0]);
            com.haier.uhome.search.service.a.a(jVar, 32);
            com.haier.uhome.usdk.base.utils.b.b((ICallback) jVar, ErrorConst.ERR_INTERNAL.toError());
        } else if (this.f29825h.get()) {
            e3.a.v("LAN search: unconnected dev search is already started!", new Object[0]);
            jVar.onSuccess(null);
        } else if (this.f29826i == null) {
            synchronized (this) {
                if (this.f29826i == null) {
                    this.f29826i = b(str, jVar);
                }
            }
        }
    }

    @Override // com.haier.uhome.search.service.a
    void c(com.haier.uhome.search.service.entity.b bVar) {
        super.c(bVar);
        com.haier.uhome.search.a.c cVar = this.f29823f.get(bVar.a());
        if (cVar == null) {
            com.haier.uhome.search.a.c cVar2 = new com.haier.uhome.search.a.c();
            cVar2.c(bVar.c());
            cVar2.a(bVar.a());
            cVar2.a(bVar.s());
            cVar2.d(bVar.f());
            cVar2.c(bVar.l());
            cVar2.i(bVar.t());
            cVar2.t(bVar.p());
            cVar2.j(bVar.I());
            cVar2.m(bVar.B());
            cVar2.s(bVar.C());
            cVar2.n(bVar.E());
            cVar2.p(bVar.F());
            cVar2.o(bVar.G());
            cVar2.l(bVar.H());
            cVar2.r(bVar.J());
            this.f29823f.a(bVar.a(), cVar2, 15000L, 500L);
            a(cVar2);
            return;
        }
        cVar.i(bVar.t());
        boolean z7 = cVar.j(bVar.I()) || (cVar.c(bVar.l()) || (cVar.d(bVar.f()) || (cVar.c(bVar.c()) || cVar.a(bVar.s()))));
        cVar.a(System.currentTimeMillis());
        this.f29823f.a(bVar.a(), cVar, 15000L, 500L);
        if (z7) {
            b(cVar);
        }
    }

    @Override // com.haier.uhome.search.service.a
    void a(List<UnconnectedDevInfo> list) {
        if (list.isEmpty()) {
            e3.a.v("LAN search: unconnected dev found no-one!", new Object[0]);
            return;
        }
        int size = list.size();
        for (UnconnectedDevInfo unconnectedDevInfo : list) {
            if (!TextUtils.isEmpty(unconnectedDevInfo.getMac())) {
                String strE = com.haier.uhome.usdk.base.utils.f.e(unconnectedDevInfo.getMac());
                e3.a.e("LAN search: LANSearchResp deviceId = %s, listSize = %s", strE, Integer.valueOf(size));
                a(strE, unconnectedDevInfo);
            } else {
                e3.a.v("LAN search: LANSearchService onSuccess mac is null", new Object[0]);
            }
        }
    }

    private void a(String str, UnconnectedDevInfo unconnectedDevInfo) {
        unconnectedDevInfo.setConfigState(a(unconnectedDevInfo.getConfigState()));
        com.haier.uhome.search.service.entity.b bVarA = com.haier.uhome.search.service.entity.b.a(unconnectedDevInfo);
        if (com.haier.library.common.util.c.l(unconnectedDevInfo.getSoftApSSID())) {
            com.haier.uhome.search.c.a.a(unconnectedDevInfo.getSoftApSSID(), bVarA);
        } else {
            bVarA.c(unconnectedDevInfo.getSsid());
        }
        if (bVarA.r() == 0 || bVarA.D() == 0) {
            if (com.haier.library.common.util.c.j(bVarA.q())) {
                bVarA.f(8);
                bVarA.n(8);
            } else {
                int iG = com.haier.uhome.search.c.a.g(bVarA.q());
                if (iG == 4 || iG == 5 || iG == 6) {
                    bVarA.f(8);
                }
                bVarA.p(String.valueOf(iG));
                bVarA.n(com.haier.uhome.search.c.a.b(iG));
            }
        }
        bVarA.a(str);
        c(bVarA);
    }

    @Override // com.haier.uhome.search.service.a
    protected void c(String str, int i7) {
        if (str == null) {
            e3.a.h("LANSearchService handleConfigDeviceDel with null deviceId", new Object[0]);
        } else if (i7 == 7) {
            e(str, i7);
        }
    }

    private void a(com.haier.uhome.search.a.c cVar) {
        com.haier.uhome.search.a.f fVar = this.f29824g;
        if (fVar == null || cVar == null) {
            return;
        }
        fVar.onDeviceAdd(cVar.clone());
    }

    @Override // com.haier.uhome.search.a.b
    public boolean a(String str) {
        return this.f29823f.containsKey(str);
    }
}
