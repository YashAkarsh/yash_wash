package com.haier.uhome.control.local.d;

import android.text.TextUtils;
import com.haier.library.common.thread.m;
import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.control.base.handler.ControlBaseNotifier;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.o;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class f extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f29398a = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.haier.uhome.control.local.api.d f29399d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<Integer, DeviceStatus> f29400e;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static f f29404a = new f();

        private a() {
        }
    }

    private f() {
        this.f29400e = new ConcurrentHashMap();
        c();
    }

    public static f a() {
        return a.f29404a;
    }

    private String c(int i7) {
        return com.haier.uhome.usdk.base.api.g.a().a(i7);
    }

    private synchronized boolean d(int i7) {
        try {
            if (i7 <= 0) {
                e3.a.v("setProxyDevice with illegal elementAddr %d", Integer.valueOf(i7));
                return false;
            }
            String strC = c(i7);
            if (TextUtils.isEmpty(strC)) {
                e3.a.v("setProxyDevice with elementAddr<%d> 2 deviceId fail", Integer.valueOf(i7));
                return false;
            }
            com.haier.uhome.control.local.api.d dVarD = com.haier.uhome.control.local.e.f.l().d(strC);
            if (dVarD == null) {
                e3.a.v("setProxyDevice with null device", new Object[0]);
                return false;
            }
            if (this.f29399d == dVarD) {
                e3.a.e("setProxyDevice but same as already one", new Object[0]);
                return false;
            }
            this.f29400e.clear();
            this.f29399d = dVarD;
            b(dVarD);
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public synchronized void f() {
        Iterator<Integer> it = this.f29400e.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            com.haier.uhome.control.local.api.d dVarD = com.haier.uhome.control.local.e.f.l().d(c(iIntValue));
            if (dVarD != null) {
                e3.a.e("proxy disconnected so offline device<%s-%d>", dVarD.X(), Integer.valueOf(iIntValue));
                dVarD.a(com.haier.uhome.usdk.base.a.as, DeviceStatus.STATUS_OFFLINE, 0);
            }
        }
        this.f29400e.clear();
        this.f29399d = null;
    }

    public void b() {
        m.execute(new Runnable() { // from class: com.haier.uhome.control.local.d.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f29415a.f();
            }
        });
    }

    public DeviceStatus a(int i7) {
        DeviceStatus deviceStatus = this.f29400e.get(Integer.valueOf(i7));
        return deviceStatus == null ? DeviceStatus.STATUS_OFFLINE : deviceStatus;
    }

    public void b(final int i7) {
        m.execute(new Callable() { // from class: com.haier.uhome.control.local.d.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f29405a.e(i7);
            }
        });
    }

    void c() {
        ControlBaseNotifier.getInstance().addNotifier(new b() { // from class: com.haier.uhome.control.local.d.f.1
            @Override // com.haier.uhome.control.local.d.b, com.haier.uhome.control.base.handler.f
            public void a(String str, String str2, int i7, DeviceStatus deviceStatus, int i8) {
                if (com.haier.uhome.usdk.base.a.as.equals(str)) {
                    f.this.a(str2, i7, deviceStatus);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str, int i7, DeviceStatus deviceStatus) {
        e3.a.e("notifyDevStateChang dev<%s> elementAddr<%d> status<%s> to proxy cache status", str, Integer.valueOf(i7), deviceStatus);
        this.f29400e.put(Integer.valueOf(i7), deviceStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final int i7, final DeviceStatus deviceStatus) {
        m.execute(new Runnable() { // from class: com.haier.uhome.control.local.d.h
            @Override // java.lang.Runnable
            public final void run() {
                this.f29407a.b(str, i7, deviceStatus);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(final com.haier.uhome.control.local.api.d dVar) {
        if (dVar == null) {
            return;
        }
        if (dVar != this.f29399d) {
            e3.a.e("proxy change so give up this proxy<%s> refreshOnlineDeviceList", dVar.X());
            return;
        }
        if (this.f29400e.isEmpty()) {
            m.execute(new Runnable() { // from class: com.haier.uhome.control.local.d.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f29411a.b(dVar);
                }
            }, 5L);
        }
        dVar.a(true, new o() { // from class: com.haier.uhome.control.local.d.j
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f29413a.a(dVar, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean e(int i7) throws Exception {
        return Boolean.valueOf(d(i7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final com.haier.uhome.control.local.api.d dVar, ErrorConst errorConst) {
        if (!dVar.A()) {
            e3.a.v("connect proxy<%s> fail so no refreshOnlineDeviceList", dVar.X());
        } else {
            e3.a.e("refreshOnlineDeviceList proxy<%s> start", dVar.X());
            dVar.b(new ICallback<Void>() { // from class: com.haier.uhome.control.local.d.f.2
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                    e3.a.e("refreshOnlineDeviceList proxy<%s> success", dVar.X());
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                }
            });
        }
    }

    public com.haier.uhome.control.local.api.d d() {
        return this.f29399d;
    }
}
