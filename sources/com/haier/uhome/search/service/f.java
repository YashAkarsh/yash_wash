package com.haier.uhome.search.service;

import android.os.Looper;
import android.text.TextUtils;
import com.haier.uhome.trace.api.DITraceNode;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.VersionManager;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class f extends com.haier.uhome.search.service.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<String, com.haier.uhome.usdk.base.api.f> f29928f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<com.haier.uhome.search.a.g> f29929g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AtomicBoolean f29930h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private com.haier.library.common.b.e f29931i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private a f29932j;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        f f29938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        AtomicBoolean f29939b = new AtomicBoolean();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f29940c;

        a(f fVar) {
            this.f29938a = fVar;
        }

        private void c() {
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.search.service.a0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f29811a.b();
                }
            }, this.f29940c <= 10 ? 2 : 10);
        }

        void a() {
            if (this.f29939b.get()) {
                e3.a.v("NetworkSearchService: retry running!", new Object[0]);
            } else if (this.f29939b.compareAndSet(false, true)) {
                c();
            }
        }

        synchronized void b() {
            e3.a.e("NetworkSearchService: try start search begin count = %d", Integer.valueOf(this.f29940c));
            uSDKError usdkerrorD = this.f29938a.d();
            if (uSDKError.RET_USDK_OK.a(usdkerrorD)) {
                this.f29939b.set(false);
                e3.a.e("NetworkSearchService: try start search success count = %d", Integer.valueOf(this.f29940c));
                this.f29940c = 0;
            } else {
                this.f29938a.a(usdkerrorD);
                int i7 = this.f29940c + 1;
                this.f29940c = i7;
                if (i7 == Integer.MAX_VALUE) {
                    this.f29940c = 11;
                }
                c();
            }
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static f f29941a = new f();

        private b() {
        }
    }

    private String g() {
        return "local";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f29932j == null) {
            synchronized (this) {
                if (this.f29932j == null) {
                    this.f29932j = new a(this);
                }
            }
        }
        this.f29932j.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized ErrorConst i() {
        if (!k()) {
            e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "NetworkSearchService tryStopNativeSearch already not running", new Object[0]);
            return ErrorConst.RET_USDK_OK;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            e3.a.f("SEARCH", com.haier.uhome.search.a.f29681b, "tryStopNativeSearch error, this thread is UI Thread!", new Object[0]);
            return ErrorConst.ERR_USDK_RUN_TIME_CONSUMING_OPERATION_ON_MAIN_THREAD;
        }
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "NetworkSearchService tryStopNativeSearch", new Object[0]);
        int iB = this.f29792e.b(1);
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "NetworkSearchService tryStopNativeSearch ret %d.", Integer.valueOf(iB));
        a(iB != 0);
        return ErrorConst.getErrorConstById(iB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        d(new ICallback<Void>() { // from class: com.haier.uhome.search.service.f.3
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                f.this.c((ICallback<Void>) null);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                f.this.c((ICallback<Void>) null);
            }
        });
    }

    private boolean k() {
        return this.f29930h.get();
    }

    synchronized uSDKError d() {
        if (k()) {
            e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "NetworkSearchService tryStartNativeSearch already running", new Object[0]);
            return uSDKError.RET_USDK_OK;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            e3.a.f("SEARCH", com.haier.uhome.search.a.f29681b, "tryStartNativeSearch error, this thread is UI Thread!", new Object[0]);
            return ErrorConst.ERR_USDK_RUN_TIME_CONSUMING_OPERATION_ON_MAIN_THREAD.toError();
        }
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "NetworkSearchService tryStartNativeSearch 0x01", new Object[0]);
        int iA = this.f29792e.a(1);
        a(iA == 0);
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "NetworkSearchService tryStartNativeSearch 0x01 ret %d.", Integer.valueOf(iA));
        return com.haier.uhome.usdk.base.utils.c.a(iA);
    }

    private f() {
        this.f29929g = new CopyOnWriteArrayList();
        this.f29928f = new ConcurrentHashMap<>();
        this.f29930h = new AtomicBoolean(false);
        this.f29931i = new com.haier.library.common.b.e() { // from class: com.haier.uhome.search.service.y
            @Override // com.haier.library.common.b.e
            public /* synthetic */ void a(com.haier.library.common.b.r rVar) {
                com.haier.library.common.b.b.a(this, rVar);
            }

            @Override // com.haier.library.common.b.e
            public final void a(com.haier.library.common.b.a aVar) {
                this.f30040a.a(aVar);
            }
        };
    }

    public static f c() {
        return b.f29941a;
    }

    @Override // com.haier.uhome.search.service.a
    protected void b(String str, String str2, int i7) {
        if ("local".equalsIgnoreCase(str)) {
            if (str2 == null) {
                e3.a.h("handleControlDeviceDel with null deviceId", new Object[0]);
                return;
            }
            com.haier.uhome.usdk.base.api.f fVarRemove = this.f29928f.remove(str2);
            if (fVarRemove == null) {
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "device %s not found ,so ignore notifyDeviceDelete", str2);
            } else {
                a(fVarRemove, i7);
                com.haier.uhome.usdk.base.api.g.a().c(str2);
            }
        }
    }

    public void e() {
        com.haier.library.common.b.h.a().b(com.haier.uhome.usdk.base.service.e.a().b(), this.f29931i);
    }

    public void f() {
        com.haier.library.common.b.h.a().d(com.haier.uhome.usdk.base.service.e.a().b(), this.f29931i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final ICallback<Void> iCallback) {
        new com.haier.library.common.thread.m<Void, Void, uSDKError>() { // from class: com.haier.uhome.search.service.f.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public uSDKError doInBackground(Void... voidArr) {
                return f.this.d();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(uSDKError usdkerror) {
                boolean zA = uSDKError.RET_USDK_OK.a(usdkerror);
                if (!zA) {
                    f.this.a(usdkerror);
                    f.this.h();
                }
                ICallback iCallback2 = iCallback;
                if (iCallback2 == null) {
                    e3.a.n("SEARCH", com.haier.uhome.search.a.f29681b, "NetworkSearchService: startService callback is null,so give up this callback.", new Object[0]);
                } else if (zA) {
                    com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback2, (Object) null);
                } else {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback2, usdkerror);
                }
            }
        }.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.haier.library.common.b.a aVar) {
        com.haier.library.common.thread.k.b().c(new Runnable() { // from class: com.haier.uhome.search.service.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f30041a.j();
            }
        });
        e3.a.e("networkId =  <%s>", aVar.k());
    }

    public int c(String str) {
        return this.f29792e.a(str);
    }

    private void a(com.haier.uhome.usdk.base.api.f fVar, int i7) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "sendDeviceDel deviceInfo =  " + fVar, new Object[0]);
        Iterator<com.haier.uhome.search.a.g> it = this.f29929g.iterator();
        while (it.hasNext()) {
            it.next().onDeviceDel(g(), fVar, i7);
        }
    }

    @Override // com.haier.uhome.search.service.a
    protected void b(String str, com.haier.uhome.usdk.base.api.f fVar) {
        if (g().equalsIgnoreCase(str)) {
            if (this.f29928f.get(fVar.b()) == null) {
                com.haier.uhome.usdk.base.api.g.a().b(fVar.b());
                this.f29928f.put(fVar.b(), fVar);
                a(fVar);
                return;
            }
            b(fVar);
        }
    }

    private void a(com.haier.uhome.usdk.base.api.f fVar) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "sendDeviceAdd deviceInfo =  " + fVar, new Object[0]);
        Iterator<com.haier.uhome.search.a.g> it = this.f29929g.iterator();
        while (it.hasNext()) {
            it.next().onDeviceAdd(g(), fVar);
        }
    }

    private void d(final ICallback<Void> iCallback) {
        new com.haier.library.common.thread.m<Void, Void, ErrorConst>() { // from class: com.haier.uhome.search.service.f.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ErrorConst doInBackground(Void... voidArr) {
                return f.this.i();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.haier.library.common.thread.m
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onPostExecute(ErrorConst errorConst) {
                if (ErrorConst.RET_USDK_OK != errorConst) {
                    com.haier.uhome.usdk.base.utils.b.a(iCallback, errorConst.toError());
                    return;
                }
                for (String str : new ArrayList(f.this.f29928f.keySet())) {
                    e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "NetworkSearchService: stopNativeService mDeviceMap remove devId: " + str, new Object[0]);
                    com.haier.uhome.search.b.f.a().a("local", str, ErrorConst.ERR_USDK_STOP_SEARCH_CAUSE_OFFLINE.getErrorId());
                }
                g.c().d();
                com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
            }
        }.execute(new Void[0]);
    }

    public void a(com.haier.uhome.search.a.g gVar) {
        this.f29929g.add(gVar);
    }

    public void a(ICallback<Void> iCallback) {
        if (com.haier.uhome.usdk.base.service.e.a().b() != null) {
            c(iCallback);
        } else {
            e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "NetworkSearchService please call init before startService ", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_NOT_CALL_INIT.toError());
        }
    }

    private void b(com.haier.uhome.usdk.base.api.f fVar) {
        e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "sendDeviceUpdate deviceInfo =  " + fVar, new Object[0]);
        Iterator<com.haier.uhome.search.a.g> it = this.f29929g.iterator();
        while (it.hasNext()) {
            it.next().onDeviceUpdate(g(), fVar);
        }
    }

    private void a(boolean z7) {
        this.f29930h.set(z7);
    }

    public void b(com.haier.uhome.search.a.g gVar) {
        this.f29929g.remove(gVar);
    }

    public com.haier.uhome.usdk.base.api.f a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        com.haier.uhome.usdk.base.api.f fVar = this.f29928f.get(str);
        if (fVar != null) {
            return fVar;
        }
        for (com.haier.uhome.usdk.base.api.f fVar2 : this.f29928f.values()) {
            if (str.equals(fVar2.b())) {
                return fVar2;
            }
        }
        return null;
    }

    public void b(ICallback<Void> iCallback) {
        if (com.haier.uhome.usdk.base.service.e.a().b() != null && k()) {
            d(iCallback);
        } else {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, (Object) null);
            e3.a.d("SEARCH", com.haier.uhome.search.a.f29681b, "NetworkSearchService: stopService service not running", new Object[0]);
        }
    }

    public ArrayList<com.haier.uhome.usdk.base.api.f> a(ArrayList<com.haier.uhome.usdk.base.api.h> arrayList) {
        ArrayList<com.haier.uhome.usdk.base.api.f> arrayList2 = new ArrayList<>();
        if (arrayList != null && !arrayList.contains(com.haier.uhome.usdk.base.api.h.ALL_TYPE)) {
            for (com.haier.uhome.usdk.base.api.f fVar : this.f29928f.values()) {
                if (fVar != null && fVar.f() != null && arrayList.contains(fVar.f())) {
                    arrayList2.add(fVar);
                }
            }
            return arrayList2;
        }
        arrayList2.addAll(this.f29928f.values());
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(uSDKError usdkerror) {
        Trace traceCreateDITrace = Trace.createDITrace();
        if (traceCreateDITrace == null) {
            e3.a.v("NetworkSearchService: diTrace is empty,so return", new Object[0]);
            return;
        }
        DITraceNode dITraceNode = new DITraceNode(TraceProtocolConst.PRO_BUSINESS_ID_FUN, "startLocalSearch", "", String.valueOf(usdkerror.getCode()), VersionManager.getInstance().getSDKVersion());
        dITraceNode.add("sys", com.haier.uhome.trace.b.e.USDK.name());
        dITraceNode.add(TraceProtocolConst.PRO_APP_ID, com.haier.uhome.usdk.base.service.e.a().i());
        dITraceNode.add(TraceProtocolConst.PRO_TOKEN, com.haier.uhome.usdk.base.service.e.a().g());
        traceCreateDITrace.addDITraceNode(dITraceNode);
    }
}
