package com.haier.uhome.control.base.api;

import android.text.TextUtils;
import com.haier.uhome.control.base.handler.ControlBaseNotifier;
import com.haier.uhome.control.base.json.RouterSsidPasswordEvent;
import com.haier.uhome.control.base.json.entity.DeviceBleAdvEpp;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f28801d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f28802e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f28803f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f28804g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f28805h = 5;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f28806i = 6;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f28807j = 6;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final long f28808k = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    DeviceStatus f28809a = DeviceStatus.STATUS_UNCONNECT;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.haier.library.common.thread.d f28810b = new com.haier.library.common.thread.d(1000);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    com.haier.uhome.control.base.handler.f f28811c = new com.haier.uhome.control.base.handler.f() { // from class: com.haier.uhome.control.base.api.g.1
        @Override // com.haier.uhome.control.base.handler.f
        public /* synthetic */ void a(RouterSsidPasswordEvent routerSsidPasswordEvent) {
            com.haier.uhome.control.base.handler.t.a(this, routerSsidPasswordEvent);
        }

        @Override // com.haier.uhome.control.base.handler.f
        public void b(String str, String str2, int i7, List<Integer> list, List<d> list2) {
            com.haier.uhome.usdk.base.api.c<String> cVarA = a(str, str2, i7);
            if (cVarA.b().a(ErrorConst.RET_USDK_OK)) {
                String strC = cVarA.c();
                if (!TextUtils.isEmpty(strC)) {
                    str2 = strC;
                }
                g.this.a("handle inGroup device<%s> attr", str2);
                g.this.f28812l.c(g.this.f28813m, list2);
            }
        }

        @Override // com.haier.uhome.control.base.handler.f
        public /* synthetic */ void a(DeviceBleAdvEpp deviceBleAdvEpp) {
            com.haier.uhome.control.base.handler.t.b(this, deviceBleAdvEpp);
        }

        @Override // com.haier.uhome.control.base.handler.f
        public void a(String str, String str2, List<e> list) {
        }

        @Override // com.haier.uhome.control.base.handler.f
        public void a(String str, String str2, int i7, List<Integer> list, List<b> list2) {
            com.haier.uhome.usdk.base.api.c<String> cVarA = a(str, str2, i7);
            if (cVarA.b().a(ErrorConst.RET_USDK_OK)) {
                String strC = cVarA.c();
                if (!TextUtils.isEmpty(strC)) {
                    str2 = strC;
                }
                g.this.a("handle inGroup device<%s> alarm", str2);
                g.this.f28812l.b(g.this.f28813m, list2);
            }
        }

        @Override // com.haier.uhome.control.base.handler.f
        public void a(String str, String str2, int i7, DeviceStatus deviceStatus, int i8) {
            com.haier.uhome.usdk.base.api.c<String> cVarA = a(str, str2, i7);
            if (cVarA.b().a(ErrorConst.RET_USDK_OK)) {
                String strC = cVarA.c();
                if (!TextUtils.isEmpty(strC)) {
                    str2 = strC;
                }
                g.this.a("handle inGroup device status <%s>, status=%s", str2, deviceStatus);
                if (com.haier.library.common.util.c.c(str, com.haier.uhome.usdk.base.a.ao)) {
                    if (com.haier.library.common.util.c.c(str2, g.this.f28813m.X()) && deviceStatus == DeviceStatus.STATUS_CONNECTED) {
                        g.this.g();
                        return;
                    }
                    return;
                }
                g.this.a();
            }
        }

        private com.haier.uhome.usdk.base.api.c<String> a(String str, String str2, int i7) {
            com.haier.uhome.usdk.base.api.c<String> cVar = new com.haier.uhome.usdk.base.api.c<>();
            if (com.haier.library.common.util.c.c(str, g.this.f28812l.f())) {
                String strA = g.this.f28812l.a(i7);
                if (!TextUtils.isEmpty(strA)) {
                    str2 = strA;
                }
                if (!g.this.a(str2) && !com.haier.library.common.util.c.c(str2, g.this.f28813m.X())) {
                    cVar.a(new uSDKError(-1, "hit not device"));
                    return cVar;
                }
                cVar.a(str2);
                cVar.a(ErrorConst.RET_USDK_OK.toError());
                return cVar;
            }
            cVar.a(new uSDKError(-1, "hit not module"));
            return cVar;
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.haier.uhome.control.base.c.a f28812l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private a f28813m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private p f28814n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f28815o;

    /* JADX INFO: renamed from: com.haier.uhome.control.base.api.g$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f28817a;

        static {
            int[] iArr = new int[DeviceStatus.values().length];
            f28817a = iArr;
            try {
                iArr[DeviceStatus.STATUS_UNCONNECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28817a[DeviceStatus.STATUS_OFFLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28817a[DeviceStatus.STATUS_CONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f28817a[DeviceStatus.STATUS_CONNECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f28817a[DeviceStatus.STATUS_READY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public g(com.haier.uhome.control.base.c.a aVar, p pVar, a aVar2) {
        this.f28812l = aVar;
        this.f28813m = aVar2;
        this.f28814n = pVar;
        ControlBaseNotifier.getInstance().addNotifier(this.f28811c);
    }

    private synchronized void f() {
        String strB = b();
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        a aVarB = this.f28812l.b(strB);
        if (aVarB == null) {
            return;
        }
        if (aVarB.n() != DeviceStatus.STATUS_READY) {
            return;
        }
        Map<String, d> mapQ = aVarB.q();
        if (mapQ != null && !mapQ.isEmpty()) {
            a("steal inGroup<%s> attr", strB);
            this.f28812l.c(this.f28813m, new ArrayList(mapQ.values()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.control.base.api.n0
            @Override // java.lang.Runnable
            public final void run() {
                this.f28827a.k();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h() {
        a("refreshInGroupDev start", new Object[0]);
        i();
        j();
        a("refreshInGroupDev end", new Object[0]);
    }

    private void i() {
        List<String> listE = e();
        int i7 = -1;
        String str = null;
        for (String str2 : listE) {
            int iA = a(this.f28812l.b(str2));
            if (iA > i7) {
                str = str2;
                i7 = iA;
            }
            if (i7 == 6) {
                break;
            }
        }
        a("set top device id to %s wight %d inGroupDev size %d", str, Integer.valueOf(i7), Integer.valueOf(listE.size()));
        this.f28815o = str;
    }

    private synchronized void j() {
        DeviceStatus deviceStatusN;
        String strB = b();
        if (TextUtils.isEmpty(strB)) {
            deviceStatusN = DeviceStatus.STATUS_OFFLINE;
        } else {
            a aVarB = this.f28812l.b(strB);
            if (aVarB != null) {
                deviceStatusN = aVarB.n();
            } else {
                a("try2NotifyStatus no find topDev<%s>", strB);
                deviceStatusN = null;
            }
        }
        if (deviceStatusN == null) {
            a("try2NotifyStatus find null status!!!", new Object[0]);
            deviceStatusN = DeviceStatus.STATUS_OFFLINE;
        }
        if (deviceStatusN == this.f28809a) {
            return;
        }
        a("try2NotifyStatus main status:%s", deviceStatusN);
        this.f28809a = deviceStatusN;
        a(deviceStatusN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        i();
        f();
    }

    protected abstract void a(DeviceStatus deviceStatus);

    private List<String> e() {
        List<String> listA = this.f28814n.a(this.f28813m.X());
        return listA == null ? Collections.emptyList() : listA;
    }

    public String b() {
        return this.f28815o;
    }

    public DeviceStatus c() {
        return this.f28809a;
    }

    public void d() {
        ControlBaseNotifier.getInstance().rmNotifier(this.f28811c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = e().iterator();
        while (it.hasNext()) {
            if (com.haier.library.common.util.c.c(it.next(), str)) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        a("refreshInGroupDev add", new Object[0]);
        this.f28810b.c(new Runnable() { // from class: com.haier.uhome.control.base.api.m0
            @Override // java.lang.Runnable
            public final void run() {
                this.f28826a.h();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, Object... objArr) {
        e3.a.e(String.format("group device<%s>, type:%s:", this.f28813m.X(), this.f28813m.e()) + str, objArr);
    }

    private int a(a aVar) {
        if (aVar == null) {
            return 0;
        }
        DeviceStatus deviceStatusN = aVar.n();
        if (deviceStatusN == null) {
            return 1;
        }
        int i7 = AnonymousClass2.f28817a[deviceStatusN.ordinal()];
        if (i7 == 1) {
            return 2;
        }
        if (i7 == 2) {
            return 3;
        }
        if (i7 == 3) {
            return 4;
        }
        if (i7 != 4) {
            return i7 != 5 ? 0 : 6;
        }
        return 5;
    }
}
