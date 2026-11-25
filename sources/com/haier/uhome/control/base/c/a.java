package com.haier.uhome.control.base.c;

import android.os.SystemClock;
import android.text.TextUtils;
import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.control.base.handler.ControlBaseNotifier;
import com.haier.uhome.control.base.json.ControlBaseProtocol;
import com.haier.uhome.control.base.json.OperArgs;
import com.haier.uhome.control.base.json.RouterSsidPasswordEvent;
import com.haier.uhome.control.base.json.entity.DeviceBleAdvEpp;
import com.haier.uhome.control.base.json.entity.NameAndValue;
import com.haier.uhome.control.base.json.req.BasicOpReq;
import com.haier.uhome.control.base.json.req.DeviceAttrReadReq;
import com.haier.uhome.control.base.json.req.DeviceAttrWriteReq;
import com.haier.uhome.control.base.json.req.DeviceOperReq;
import com.haier.uhome.control.base.json.req.DeviceStateReq;
import com.haier.uhome.control.base.json.req.NetworkQualityReq;
import com.haier.uhome.control.base.json.resp.DeviceAttrReadResp;
import com.haier.uhome.control.base.json.resp.DeviceAttrWriteResp;
import com.haier.uhome.control.base.json.resp.DeviceOperResp;
import com.haier.uhome.control.base.json.resp.NetworkQualityResp;
import com.haier.uhome.trace.api.DITraceNode;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.VersionManager;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicReq;
import com.haier.uhome.usdk.base.json.BasicResp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends com.haier.uhome.usdk.base.service.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f28861c = -23013;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private C0368a f28864e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.haier.uhome.control.base.handler.f f28866g = new AnonymousClass1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Map<String, com.haier.uhome.control.base.api.a> f28862a = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, Integer> f28863d = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, Object> f28865f = new ConcurrentHashMap();

    /* JADX INFO: renamed from: com.haier.uhome.control.base.c.a$a, reason: collision with other inner class name */
    protected class C0368a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final long f28870b = 600000;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final long f28871c = 30000;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f28872d = 50;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ConcurrentHashMap<String, com.haier.uhome.control.base.api.a> f28874e = new ConcurrentHashMap<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private AtomicBoolean f28875f = new AtomicBoolean(false);

        C0368a() {
        }

        private void b(com.haier.uhome.control.base.api.a aVar) {
            String strX = aVar.X();
            if (TextUtils.isEmpty(strX)) {
                return;
            }
            this.f28874e.remove(strX);
        }

        private boolean c(com.haier.uhome.control.base.api.a aVar) {
            DeviceStatus deviceStatusN = aVar.n();
            DeviceStatus deviceStatus = DeviceStatus.STATUS_OFFLINE;
            if (deviceStatusN == deviceStatus) {
                return false;
            }
            long jX = aVar.x();
            long jCurrentTimeMillis = System.currentTimeMillis();
            e3.a.n("checkOnline <%s> <%s>,now is %d, lastOnLineTime: %d.", getClass().getName(), aVar.X(), Long.valueOf(jCurrentTimeMillis), Long.valueOf(jX));
            if (jCurrentTimeMillis - jX < f28870b) {
                return true;
            }
            e3.a.o("checkOnline OFFLINE <%s>", aVar.X());
            aVar.a(a.this.f(), deviceStatus, 0);
            return false;
        }

        public void a(com.haier.uhome.control.base.api.a aVar) {
            if (aVar == null) {
                return;
            }
            aVar.y();
            DeviceStatus deviceStatusN = aVar.n();
            if (aVar.q() == null || aVar.q().isEmpty() || !aVar.u()) {
                aVar.a(a.this.f(), DeviceStatus.STATUS_CONNECTED, 0);
            } else {
                aVar.a(a.this.f(), DeviceStatus.STATUS_READY, 0);
            }
            DeviceStatus deviceStatusN2 = aVar.n();
            DeviceStatus deviceStatus = DeviceStatus.STATUS_READY;
            if (deviceStatusN2 == deviceStatus && deviceStatusN != deviceStatus) {
                aVar.i();
            }
            String strX = aVar.X();
            if (TextUtils.isEmpty(strX)) {
                return;
            }
            this.f28874e.put(strX, aVar);
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            while (true) {
                e3.a.e("checkOnLine loop...", new Object[0]);
                ArrayList<com.haier.uhome.control.base.api.a> arrayList = new ArrayList(this.f28874e.values());
                if (arrayList.isEmpty()) {
                    return;
                }
                for (com.haier.uhome.control.base.api.a aVar : arrayList) {
                    if (aVar != null && !aVar.z()) {
                        aVar.d(true);
                        if (!c(aVar)) {
                            aVar.d(false);
                            b(aVar);
                        } else {
                            aVar.d(false);
                            try {
                                Thread.sleep(f28872d);
                            } catch (InterruptedException unused) {
                                e3.a.e("checkOnLine InterruptedException", new Object[0]);
                                Thread.currentThread().interrupt();
                            }
                        }
                    }
                }
                SystemClock.sleep(f28871c);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void a() {
            if (this.f28875f.get()) {
                return;
            }
            this.f28875f.set(true);
            new com.haier.library.common.thread.m<Void, Void, Void>() { // from class: com.haier.uhome.control.base.c.a.a.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.haier.library.common.thread.m
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Void doInBackground(Void... voidArr) {
                    e3.a.e("checkOnLine start", new Object[0]);
                    C0368a.this.b();
                    e3.a.e("checkOnLine end", new Object[0]);
                    C0368a.this.f28875f.set(false);
                    return null;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.haier.library.common.thread.m
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onPostExecute(Void r7) {
                    if (C0368a.this.f28874e.size() > 0) {
                        C0368a.this.a();
                    }
                }
            }.execute(new Void[0]);
        }
    }

    static {
        ControlBaseProtocol.register();
    }

    public a() {
        ControlBaseNotifier.getInstance().addNotifier(this.f28866g);
        this.f28864e = new C0368a();
    }

    public abstract void a(String str, int i7, Trace trace, ICallback<com.haier.uhome.control.base.api.r> iCallback);

    protected abstract void a(String str, com.haier.uhome.usdk.base.api.o oVar);

    protected void a(String str, String str2, String str3) {
    }

    protected abstract void a(String str, String str2, List<Integer> list, String str3, int i7, Trace trace, ICallback<String> iCallback);

    protected abstract void a(String str, String str2, List<Integer> list, String str3, String str4, int i7, Trace trace, ICallback<Void> iCallback);

    protected abstract void a(String str, String str2, List<Integer> list, String str3, List<com.haier.uhome.control.base.api.c> list2, int i7, Trace trace, String str4, ICallback<Void> iCallback);

    protected void b(String str, List<Integer> list) {
    }

    public void c(final com.haier.uhome.control.base.api.a aVar, List<com.haier.uhome.control.base.api.d> list) {
        boolean zA;
        if (aVar == null || com.haier.library.common.util.u.h(list)) {
            return;
        }
        HashMap map = new HashMap();
        Map<String, com.haier.uhome.control.base.api.d> mapQ = aVar.q();
        if (com.haier.uhome.usdk.base.api.e.a(aVar.ai())) {
            for (com.haier.uhome.control.base.api.d dVar : list) {
                com.haier.uhome.control.base.api.d dVar2 = new com.haier.uhome.control.base.api.d(dVar.getName(), dVar.getValue(), dVar.getUniqueId(), dVar.getTimeStamp());
                map.put(dVar2.getName(), dVar2);
                mapQ.put(dVar2.getName(), dVar2);
            }
            zA = true;
        } else {
            zA = a(mapQ, list, (Map<String, com.haier.uhome.control.base.api.d>) map, false);
        }
        e3.a.d("BaseControlService dev<%s> module<%s> notifyDevAttrChange: device attr is changed:%s", aVar.X(), aVar.e(), Boolean.valueOf(zA));
        if (zA) {
            final HashMap map2 = new HashMap(map);
            Iterator it = map2.keySet().iterator();
            while (it.hasNext()) {
                com.haier.uhome.control.base.api.d dVar3 = (com.haier.uhome.control.base.api.d) map2.get((String) it.next());
                if (dVar3 != null) {
                    aVar.a(dVar3.getUniqueId());
                    break;
                }
            }
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.c.j
                @Override // java.lang.Runnable
                public final void run() {
                    a.a(aVar, map2);
                }
            });
        }
        if (a(aVar)) {
            h(aVar);
        }
    }

    public void d(com.haier.uhome.control.base.api.a aVar) {
        if (aVar != null) {
            aVar.h();
        }
    }

    public void e(com.haier.uhome.control.base.api.a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.a(com.haier.uhome.usdk.base.a.af, new ArrayList(), 15, Trace.createDITrace(), com.haier.uhome.usdk.base.a.af, null);
    }

    protected abstract boolean e();

    protected uSDKError f(com.haier.uhome.control.base.api.a aVar) {
        if (aVar == null) {
            return ErrorConst.ERR_INTERNAL.toError();
        }
        if (com.haier.library.common.b.h.a().c(com.haier.uhome.usdk.base.service.e.a().b())) {
            return (aVar.n() == DeviceStatus.STATUS_READY || aVar.n() == DeviceStatus.STATUS_CONNECTED) ? ErrorConst.RET_USDK_OK.toError() : ErrorConst.ERR_USDK_DEVICE_NOT_CONNECTED.toError();
        }
        return ErrorConst.ERR_USDK_NETWORK_IS_NONE.toError();
    }

    public abstract String f();

    private boolean l() {
        return (TextUtils.isEmpty(com.haier.uhome.usdk.base.service.e.a().i()) || TextUtils.isEmpty(com.haier.uhome.usdk.base.service.e.a().h())) ? false : true;
    }

    protected void a(String str, List<Integer> list) {
    }

    public void b(final com.haier.uhome.control.base.api.a aVar, List<com.haier.uhome.control.base.api.b> list) {
        if (aVar == null || com.haier.library.common.util.u.h(list)) {
            return;
        }
        final com.haier.uhome.control.base.api.i iVarO = aVar.o();
        aVar.a(list);
        final ArrayList<com.haier.uhome.control.base.api.b> arrayList = new ArrayList(aVar.r());
        for (com.haier.uhome.control.base.api.b bVar : arrayList) {
            if (bVar != null) {
                aVar.a(bVar.getUniqueId());
            }
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.c.p
            @Override // java.lang.Runnable
            public final void run() {
                a.a(iVarO, aVar, arrayList);
            }
        });
    }

    protected DeviceOperReq d() {
        return new DeviceOperReq();
    }

    public int g() {
        return 0;
    }

    protected int h() {
        return -1;
    }

    public String i() {
        return TraceProtocolConst.PRO_OP_LST;
    }

    public String j() {
        return TraceProtocolConst.PRO_ACK_LST;
    }

    public String k() {
        int iA = com.haier.library.common.util.w.a(com.haier.uhome.usdk.base.service.e.a().b());
        if (iA == 0) {
            return "2";
        }
        if (iA == 1) {
            return "1";
        }
        if (iA == 4) {
            return "2";
        }
        if (iA != 7) {
            return iA != 9 ? "0" : "1";
        }
        return "3";
    }

    private void h(com.haier.uhome.control.base.api.a aVar) {
        aVar.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(com.haier.uhome.control.base.api.a aVar) {
        aVar.j();
    }

    public String g(com.haier.uhome.control.base.api.a aVar) {
        if (1 == g()) {
            return com.haier.uhome.usdk.base.a.au;
        }
        if (2 == g()) {
            return aVar.p() == com.haier.uhome.usdk.base.api.a.APP_PROT_STD ? "coap" : "uwt";
        }
        return "local";
    }

    /* JADX INFO: renamed from: com.haier.uhome.control.base.c.a$1, reason: invalid class name */
    class AnonymousClass1 implements com.haier.uhome.control.base.handler.f {
        AnonymousClass1() {
        }

        @Override // com.haier.uhome.control.base.handler.f
        public void a(String str, String str2, List<com.haier.uhome.control.base.api.e> list) {
            if (a(str)) {
                e3.a.d("BaseControlService:%s <%s> notifyDevEventChange:%s", str, str2, list);
                com.haier.uhome.control.base.api.a aVar = a.this.f28862a.get(str2);
                if (aVar == null) {
                    e3.a.d("No this <%s> device!!! lost device id = %s", a.this.f(), str2, new Object[0]);
                } else {
                    a.this.a(aVar, list);
                }
            }
        }

        @Override // com.haier.uhome.control.base.handler.f
        public void b(String str, String str2, int i7, List<Integer> list, List<com.haier.uhome.control.base.api.d> list2) {
            if (a(str)) {
                String strA = a.this.a(i7);
                if (!TextUtils.isEmpty(strA)) {
                    e3.a.e("BaseControlService elementAddr %d to deviceId %s", Integer.valueOf(i7), strA);
                    str2 = strA;
                }
                a(str, str2, list, list2);
                com.haier.uhome.control.base.api.a aVar = a.this.f28862a.get(str2);
                if (aVar == null) {
                    e3.a.d("No this <%s> device!!! lost device id = %s", a.this.f(), str2, new Object[0]);
                    return;
                }
                synchronized (aVar.a()) {
                    if (!aVar.A()) {
                        e3.a.o("BaseControlService <%s> notifyDevAttrChange:%s device is no onConnected so give up", str2, list2);
                        return;
                    }
                    a.this.c(aVar, list2);
                    if (com.haier.library.common.util.u.h(list)) {
                        return;
                    }
                    a.this.c(str2, list);
                    for (Integer num : list) {
                        com.haier.uhome.control.base.api.a aVar2 = a.this.f28862a.get(com.haier.uhome.control.base.c.a(str2, num.intValue()));
                        if (aVar2 == null) {
                            e3.a.e("get sub dev fail deviceId<%s> subDevice<%s>", str2, num);
                        } else {
                            a.this.c(aVar2, list2);
                            a.this.f28864e.a(aVar2);
                        }
                    }
                }
            }
        }

        @Override // com.haier.uhome.control.base.handler.f
        public void a(String str, String str2, int i7, List<Integer> list, List<com.haier.uhome.control.base.api.b> list2) {
            if (a(str)) {
                String strA = a.this.a(i7);
                if (!TextUtils.isEmpty(strA)) {
                    e3.a.e("BaseControlService elementAddr %d to deviceId %s", Integer.valueOf(i7), strA);
                    str2 = strA;
                }
                Object[] objArr = new Object[2];
                objArr[0] = list2;
                objArr[1] = list == null ? "" : list;
                e3.a.d("BaseControlService:%s <%s> notifyDevAlarmChange:%s subDeviceList:%s", str, str2, objArr);
                com.haier.uhome.control.base.api.a aVar = a.this.f28862a.get(str2);
                if (aVar == null) {
                    e3.a.d("No this <%s> device!!! lost device id = %s", a.this.f(), str2, new Object[0]);
                    return;
                }
                synchronized (aVar.a()) {
                    if (!aVar.A()) {
                        e3.a.o("BaseControlService <%s> notifyDevAlarmChange:%s device is no onConnected so give up", str2, list2);
                        return;
                    }
                    a.this.b(aVar, list2);
                    if (com.haier.library.common.util.u.h(list)) {
                        return;
                    }
                    a.this.c(str2, list);
                    for (Integer num : list) {
                        com.haier.uhome.control.base.api.a aVar2 = a.this.f28862a.get(com.haier.uhome.control.base.c.a(str2, num.intValue()));
                        if (aVar2 != null) {
                            a.this.f28864e.a(aVar2);
                            a.this.b(aVar2, list2);
                        } else {
                            e3.a.e("get sub dev fail deviceId<%s> subDevice<%s>", str2, num);
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ com.haier.uhome.control.base.api.d b(DeviceBleAdvEpp deviceBleAdvEpp, NameAndValue nameAndValue) {
            return new com.haier.uhome.control.base.api.d(nameAndValue.getName(), nameAndValue.getValue(), deviceBleAdvEpp.getUniqueId(), System.currentTimeMillis());
        }

        void a(String str, String str2, List<Integer> list, List<com.haier.uhome.control.base.api.d> list2) {
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = str2;
            objArr[2] = list2;
            Object obj = list;
            if (list == null) {
                obj = "";
            }
            objArr[3] = obj;
            String strSubstring = String.format("BaseControlService:%s <%s> notifyDevAttrChange:%s, subDevice:%s", objArr);
            if (strSubstring.length() <= 1000) {
                e3.a.e(strSubstring, new Object[0]);
                return;
            }
            while (strSubstring.length() > 1000) {
                e3.a.e("logAttrChange-" + strSubstring.substring(0, 1000), new Object[0]);
                strSubstring = strSubstring.substring(1000);
            }
            e3.a.e("logAttrChange-" + strSubstring, new Object[0]);
        }

        @Override // com.haier.uhome.control.base.handler.f
        public void a(String str, String str2, int i7, DeviceStatus deviceStatus, int i8) {
            if (i8 == -10 && com.haier.uhome.usdk.base.a.aq.equals(str)) {
                deviceStatus = DeviceStatus.STATUS_OFFLINE;
                i8 = ErrorConst.ERR_USDK_BLE_IN_CONFIG_MODE_OFFLINE.getErrorId();
            } else if (i8 == -318 && com.haier.uhome.usdk.base.a.aq.equals(str)) {
                deviceStatus = DeviceStatus.STATUS_OFFLINE;
                i8 = ErrorConst.ERR_USDK_DEVICE_DISCONNECT_FROM_US.getErrorId();
            } else if (!a(str)) {
                return;
            }
            String strA = a.this.a(i7);
            if (!TextUtils.isEmpty(strA)) {
                e3.a.e("BaseControlService elementAddr %d to deviceId %s", Integer.valueOf(i7), strA);
                str2 = strA;
            }
            e3.a.d("BaseControlService:%s <%s> notifyDevStateChange:%s, %d", str, str2, deviceStatus, Integer.valueOf(i8));
            com.haier.uhome.control.base.api.a aVar = a.this.f28862a.get(str2);
            if (aVar == null) {
                e3.a.d("No this <%s> device!!! lost device id = %s", a.this.f(), str2, new Object[0]);
                return;
            }
            synchronized (aVar.a()) {
                if (!aVar.A() && deviceStatus != DeviceStatus.STATUS_UNCONNECT) {
                    e3.a.o("BaseControlService <%s> notifyDevStateChange:%s device is no onConnected so give up", str2, deviceStatus);
                    return;
                }
                if (aVar.n() == deviceStatus) {
                    e3.a.h("device:%s does not change online status <%s>", str2, deviceStatus);
                    return;
                }
                aVar.a(str, deviceStatus, i8);
                if (deviceStatus != DeviceStatus.STATUS_CONNECTED) {
                    a.this.i(aVar);
                } else {
                    a.this.c(str2);
                }
            }
        }

        @Override // com.haier.uhome.control.base.handler.f
        public void a(RouterSsidPasswordEvent routerSsidPasswordEvent) {
            String devId = routerSsidPasswordEvent.getDevId();
            com.haier.uhome.control.base.api.a aVar = a.this.f28862a.get(devId);
            if (aVar == null) {
                e3.a.d("No this <%s> device!!! lost device id = %s", a.this.f(), devId, new Object[0]);
            } else {
                aVar.o().a(routerSsidPasswordEvent);
            }
        }

        @Override // com.haier.uhome.control.base.handler.f
        public void a(final DeviceBleAdvEpp deviceBleAdvEpp) {
            String devId = deviceBleAdvEpp.getDevId();
            com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(devId);
            if (fVarA == null) {
                e3.a.h("notifyBleAdvEpp getDeviceInfo ret null", new Object[0]);
                return;
            }
            if (com.haier.uhome.usdk.base.api.e.a(fVarA.n())) {
                a.this.b(devId, deviceBleAdvEpp.getUplusId(), deviceBleAdvEpp.getBleDevId());
                fVarA.d(deviceBleAdvEpp.getLongProduceCode());
                com.haier.uhome.usdk.base.api.f.a aVarR = fVarA.r();
                if (aVarR != null) {
                    aVarR.b(deviceBleAdvEpp.getBleDevId());
                    aVarR.a(com.haier.uhome.usdk.base.api.q.a(deviceBleAdvEpp.getProtocol()));
                }
                com.haier.uhome.control.base.api.a aVar = a.this.f28862a.get(devId);
                if (aVar == null) {
                    e3.a.d("No this <%s> device!!! lost device id = %s", a.this.f(), devId, new Object[0]);
                    return;
                }
                synchronized (aVar.a()) {
                    if (!aVar.A()) {
                        e3.a.o("BaseControlService <%s> notifyBleAdvEpp:%s device is no onConnected so give up", devId, deviceBleAdvEpp);
                        return;
                    }
                    try {
                        int eppType = deviceBleAdvEpp.getEppType();
                        if (eppType == 1) {
                            a.this.c(aVar, com.haier.library.common.util.u.a(deviceBleAdvEpp.getEppValue(), new com.haier.library.common.util.p() { // from class: com.haier.uhome.control.base.c.t
                                @Override // com.haier.library.common.util.p
                                public final Object transform(Object obj) {
                                    return a.AnonymousClass1.b(deviceBleAdvEpp, (NameAndValue) obj);
                                }
                            }));
                        } else if (eppType == 2) {
                            a.this.b(aVar, com.haier.library.common.util.u.a(deviceBleAdvEpp.getEppValue(), new com.haier.library.common.util.p() { // from class: com.haier.uhome.control.base.c.u
                                @Override // com.haier.library.common.util.p
                                public final Object transform(Object obj) {
                                    return a.AnonymousClass1.a(deviceBleAdvEpp, (NameAndValue) obj);
                                }
                            }));
                        }
                        return;
                    } catch (Exception e8) {
                        e3.a.v("DeviceBleAdvEpp parse error", e8);
                        return;
                    }
                }
            }
            e3.a.v("notifyBleAdvEpp epp not Ble Fat Scale", new Object[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ com.haier.uhome.control.base.api.b a(DeviceBleAdvEpp deviceBleAdvEpp, NameAndValue nameAndValue) {
            return new com.haier.uhome.control.base.api.b(nameAndValue.getName(), nameAndValue.getValue(), deviceBleAdvEpp.getUniqueId());
        }

        private boolean a(String str) {
            if (a.this.f().equals(str)) {
                return true;
            }
            e3.a.d("ignore this module %s, %s", a.this.f(), str, new Object[0]);
            return false;
        }
    }

    public synchronized void a(String str, com.haier.uhome.control.base.api.a aVar) {
        Integer num = this.f28863d.get(str);
        int iIntValue = 1;
        if (num != null) {
            iIntValue = 1 + num.intValue();
        }
        this.f28863d.put(str, Integer.valueOf(iIntValue));
        if (this.f28862a.put(str, aVar) == null) {
            String strA = com.haier.uhome.control.base.c.a(str);
            com.haier.uhome.usdk.base.api.g gVarA = com.haier.uhome.usdk.base.api.g.a();
            if (!TextUtils.isEmpty(strA)) {
                str = strA;
            }
            gVarA.b(str);
        } else {
            e3.a.o("multiple registration devId : " + str, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, String str2, String str3) {
        if (this.f28862a.get(str) != null) {
            return;
        }
        a(str, str2, str3);
    }

    public com.haier.uhome.control.base.api.a b(String str) {
        if (str == null) {
            return null;
        }
        return this.f28862a.get(str);
    }

    public void b(final com.haier.uhome.control.base.api.a aVar) {
        e3.a.d("getAllProperty exec device = %s, module = %s", aVar.X(), f(), new Object[0]);
        aVar.a(com.haier.uhome.usdk.base.a.ag, new ArrayList(), 15, Trace.createDITrace(), com.haier.uhome.usdk.base.a.ag, new ICallback<Void>() { // from class: com.haier.uhome.control.base.c.a.2
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                e3.a.e("DeviceOperResp getAllProperty: onSuccess ", new Object[0]);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.e("DeviceOperResp getAllProperty: onFailure %s ", usdkerror);
                aVar.a(a.this.f(), aVar.n(), usdkerror.getCode());
            }
        });
    }

    public synchronized void a(String str) {
        com.haier.uhome.control.base.api.a aVarB;
        Integer num = this.f28863d.get(str);
        Integer numValueOf = Integer.valueOf(num == null ? 0 : num.intValue() - 1);
        this.f28863d.put(str, numValueOf);
        if (numValueOf.intValue() > 0) {
            e3.a.o("unRegistration devId:%s, but referenceCount:%d is not 0", str, numValueOf);
            return;
        }
        this.f28863d.remove(str);
        if (this.f28862a.remove(str) != null) {
            String strA = com.haier.uhome.control.base.c.a(str);
            com.haier.uhome.usdk.base.api.g gVarA = com.haier.uhome.usdk.base.api.g.a();
            if (TextUtils.isEmpty(strA)) {
                strA = str;
            }
            gVarA.c(strA);
        } else {
            e3.a.o("multiple unRegistration devId : " + str, new Object[0]);
        }
        if (com.haier.uhome.control.base.c.c(str) && (aVarB = b(com.haier.uhome.control.base.c.a(str))) != null) {
            List<String> listL = aVarB.l();
            if (!com.haier.library.common.util.u.h(listL)) {
                listL.remove(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.haier.uhome.control.base.api.a aVar, AtomicBoolean atomicBoolean, com.haier.uhome.usdk.base.api.o oVar, BasicReq basicReq) {
        if (!aVar.A() && !atomicBoolean.get()) {
            e3.a.e("disconnect disconnected device id : %s, unSyn return ok", aVar.X());
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
            return;
        }
        synchronized (aVar.a()) {
            atomicBoolean.set(true);
            if (aVar != b(aVar.X())) {
                com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_INTERNAL);
                return;
            }
            if (!aVar.A()) {
                e3.a.e("disconnect disconnected device id : %s, return ok", aVar.X());
                com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
                return;
            }
            e3.a.d("do disconnect begin device id:%s-request:%s", aVar.X(), basicReq + "", new Object[0]);
            uSDKError usdkerrorA = a(basicReq, 15);
            e3.a.e("do disconnect end device id:%s-result:%s", aVar.X(), Integer.valueOf(usdkerrorA.getCode()));
            aVar.d(oVar);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.getErrorConstById(usdkerrorA.getCode()));
            if (usdkerrorA.getCode() == 0) {
                aVar.e(false);
                aVar.a(f(), DeviceStatus.STATUS_UNCONNECT, 0);
            }
            atomicBoolean.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, List<Integer> list) {
        ArrayList arrayList = new ArrayList();
        for (Integer num : list) {
            if (this.f28862a.get(com.haier.uhome.control.base.c.a(str, num.intValue())) == null) {
                arrayList.add(num);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        e3.a.e("add sub dev deviceId<%s> subDevice<%s>", str, list);
        a(str, arrayList);
    }

    public void c(String str) {
        com.haier.uhome.control.base.api.a aVarB = b(str);
        if (aVarB != null && aVarB.u() && c(aVarB)) {
            d(aVarB);
        }
    }

    protected boolean c(com.haier.uhome.control.base.api.a aVar) {
        return !com.haier.uhome.usdk.base.api.e.a(aVar.ai());
    }

    protected DeviceAttrWriteReq c() {
        return new DeviceAttrWriteReq();
    }

    public String a(int i7) {
        return com.haier.uhome.usdk.base.api.g.a().a(i7);
    }

    public void a(final com.haier.uhome.control.base.api.a aVar, final List<com.haier.uhome.control.base.api.e> list) {
        if (aVar == null || com.haier.library.common.util.u.h(list)) {
            return;
        }
        final com.haier.uhome.control.base.api.i iVarO = aVar.o();
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.c.q
            @Override // java.lang.Runnable
            public final void run() {
                a.a(iVarO, aVar, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.control.base.api.i iVar, com.haier.uhome.control.base.api.a aVar, List list) {
        if (iVar != null) {
            iVar.a(aVar.X(), (List<com.haier.uhome.control.base.api.e>) list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.control.base.api.i iVar, com.haier.uhome.control.base.api.a aVar, ArrayList arrayList) {
        if (iVar != null) {
            iVar.b(aVar.X(), arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.control.base.api.a aVar, HashMap map) {
        com.haier.uhome.control.base.api.i iVarO = aVar.o();
        if (iVarO != null) {
            iVarO.a(aVar.X(), (HashMap<String, com.haier.uhome.control.base.api.d>) map);
        }
    }

    protected void b(final com.haier.uhome.control.base.api.a aVar, final BasicReq basicReq, final com.haier.uhome.usdk.base.api.o oVar) {
        if (aVar == null) {
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_DEVICE_NOT_FOUND);
            return;
        }
        final AtomicBoolean atomicBooleanF_ = aVar.f_();
        if (aVar.A() && !atomicBooleanF_.get()) {
            e3.a.e("connect connected device id : %s, unSyn return ok", aVar.X());
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
        } else {
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.control.base.c.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f28920a.a(aVar, atomicBooleanF_, oVar, basicReq);
                }
            });
        }
    }

    public boolean a(com.haier.uhome.control.base.api.a aVar) {
        if (aVar == null || com.haier.uhome.usdk.base.api.e.a(aVar.ai())) {
            return false;
        }
        if ((aVar.n() != DeviceStatus.STATUS_CONNECTED && aVar.g() != ErrorConst.ERR_USDK_OFFLINE_DECLARE.getErrorId()) || !aVar.u() || aVar.q().isEmpty()) {
            return false;
        }
        e3.a.e("dev<%s> status<%s> AttributeMap is not empty so to ready", aVar.X(), aVar.n());
        aVar.a(f(), DeviceStatus.STATUS_READY, 0);
        return true;
    }

    protected DeviceAttrReadReq b() {
        return new DeviceAttrReadReq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(com.haier.uhome.control.base.api.a.C0367a c0367a, Trace trace, com.haier.uhome.control.base.api.a aVar, com.haier.uhome.control.base.d.a aVar2, ICallback iCallback, BasicResp basicResp) {
        uSDKError usdkerrorA = c0367a.a();
        DeviceAttrReadResp deviceAttrReadResp = (DeviceAttrReadResp) basicResp;
        uSDKError usdkerrorA2 = com.haier.uhome.usdk.base.utils.c.a(basicResp);
        if (deviceAttrReadResp != null && usdkerrorA2 != null) {
            usdkerrorA2.a(deviceAttrReadResp.getInvalidCode());
        }
        if ((!usdkerrorA2.a(ErrorConst.ERR_USDK_TIMEOUT) && usdkerrorA2.getCode() != h()) || usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            usdkerrorA = usdkerrorA2;
        }
        a(trace, "read", aVar, deviceAttrReadResp.getCode(), deviceAttrReadResp.getSpan(), deviceAttrReadResp.getBoardSpan());
        aVar2.a(usdkerrorA);
        if (usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback<String>) iCallback, deviceAttrReadResp.getValue());
        } else {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerrorA);
        }
    }

    public void a(String str, String str2, com.haier.uhome.control.base.api.m mVar) {
        d.a().a(com.haier.uhome.usdk.base.service.e.a().b(), str, str2, mVar);
    }

    public void a(String str, String str2, ICallback<com.haier.uhome.control.base.api.s> iCallback) {
        d.a().a(com.haier.uhome.usdk.base.service.e.a().b(), str, str2, iCallback);
    }

    public void a(String str, String str2, com.haier.uhome.control.base.api.n nVar) {
        com.haier.uhome.control.base.api.a aVar;
        if (!e()) {
            a(ErrorConst.ERR_MODULE_UNSTARTED, nVar);
            return;
        }
        if (!l()) {
            a(ErrorConst.ERR_USDK_APPID_APPKEY_NULL, nVar);
            return;
        }
        if (TextUtils.isEmpty(str2) || (aVar = this.f28862a.get(str2)) == null) {
            return;
        }
        if (aVar.n() != DeviceStatus.STATUS_CONNECTED && aVar.n() != DeviceStatus.STATUS_READY) {
            a(ErrorConst.ERR_USDK_DEVICE_NOT_CONNECTED, nVar);
        } else if (TextUtils.isEmpty(str)) {
            a(ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST, nVar);
        } else {
            d.a().a(com.haier.uhome.usdk.base.service.e.a().b(), str, str2, nVar);
        }
    }

    private void a(final ErrorConst errorConst, final com.haier.uhome.control.base.api.n nVar) {
        if (nVar == null) {
            return;
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.c.n
            @Override // java.lang.Runnable
            public final void run() {
                a.a(nVar, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.control.base.api.n nVar, ErrorConst errorConst) {
        if (nVar == null) {
            return;
        }
        nVar.onDeviceTokenGet(errorConst, "");
    }

    public void a(String str, String str2, com.haier.uhome.usdk.base.api.o oVar) {
        if (!e()) {
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_MODULE_UNSTARTED);
            return;
        }
        if (!l()) {
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_APPID_APPKEY_NULL);
        } else if (TextUtils.isEmpty(str)) {
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST);
        } else {
            d.a().a(com.haier.uhome.usdk.base.service.e.a().b(), str, str2, oVar);
        }
    }

    public void a(String str, com.haier.uhome.control.base.api.j jVar) {
        if (!e()) {
            a(ErrorConst.ERR_MODULE_UNSTARTED, jVar);
            return;
        }
        if (!l()) {
            a(ErrorConst.ERR_USDK_APPID_APPKEY_NULL, jVar);
        } else if (TextUtils.isEmpty(str)) {
            a(ErrorConst.ERR_USDK_CALL_CONNECT_TO_GATEWAY_INTERFACE_FIRST, jVar);
        } else {
            d.a().a(com.haier.uhome.usdk.base.service.e.a().b(), str, jVar);
        }
    }

    private void a(final ErrorConst errorConst, final com.haier.uhome.control.base.api.j jVar) {
        if (jVar == null) {
            return;
        }
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.c.s
            @Override // java.lang.Runnable
            public final void run() {
                a.a(jVar, errorConst);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.control.base.api.j jVar, ErrorConst errorConst) {
        if (jVar == null) {
            return;
        }
        jVar.onDeviceTokenInfoList(errorConst, null);
    }

    public List<String> a() {
        return new ArrayList(this.f28862a.keySet());
    }

    private boolean a(Map<String, com.haier.uhome.control.base.api.d> map, List<com.haier.uhome.control.base.api.d> list, Map<String, com.haier.uhome.control.base.api.d> map2, boolean z7) {
        String name;
        if (list == null) {
            return false;
        }
        boolean z8 = false;
        for (com.haier.uhome.control.base.api.d dVar : list) {
            if (dVar != null && (name = dVar.getName()) != null) {
                if (!z7 || !name.equalsIgnoreCase("subDeviceList")) {
                    try {
                        com.haier.uhome.control.base.api.d dVar2 = new com.haier.uhome.control.base.api.d(dVar.getName(), dVar.getValue(), dVar.getUniqueId(), dVar.getTimeStamp());
                        com.haier.uhome.control.base.api.d dVar3 = map.get(name);
                        if (dVar3 == null) {
                            try {
                                map.put(name, dVar2);
                                map2.put(name, dVar2);
                            } catch (Exception e8) {
                                e = e8;
                                z8 = true;
                                e3.a.v("Attr set error", e);
                            }
                        } else if (!dVar3.getValue().equals(dVar2.getValue())) {
                            map2.put(name, dVar2);
                            dVar3.b(dVar2.getValue());
                        }
                        z8 = true;
                    } catch (Exception e9) {
                        e = e9;
                    }
                }
            } else {
                e3.a.v("compareAttrMap error nAttr = %s", dVar);
            }
        }
        return z8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(final ErrorConst errorConst, final com.haier.uhome.usdk.base.api.n nVar) {
        if (nVar == null) {
            e3.a.v("callbackWithError callback is null,so give up callback", new Object[0]);
        } else {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.c.e
                @Override // java.lang.Runnable
                public final void run() {
                    nVar.a(errorConst);
                }
            });
        }
    }

    private uSDKError a(BasicReq basicReq, int i7) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final uSDKError[] usdkerrorArr = {ErrorConst.ERR_USDK_TIMEOUT.toError()};
        com.haier.uhome.usdk.base.d.a.a().a(basicReq, i7, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.base.c.i
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                a.a(usdkerrorArr, countDownLatch, basicResp);
            }
        });
        try {
            e3.a.e("syncSendReq await count reached zero ? %s", Boolean.valueOf(countDownLatch.await(i7, TimeUnit.SECONDS)));
        } catch (InterruptedException e8) {
            e3.a.g("get excp %s !", e8);
            Thread.currentThread().interrupt();
        }
        return usdkerrorArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(uSDKError[] usdkerrorArr, CountDownLatch countDownLatch, BasicResp basicResp) {
        usdkerrorArr[0] = com.haier.uhome.usdk.base.utils.c.a(basicResp);
        countDownLatch.countDown();
    }

    protected void a(final com.haier.uhome.control.base.api.a aVar, final BasicReq basicReq, final com.haier.uhome.usdk.base.api.o oVar) {
        if (aVar == null) {
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_DEVICE_NOT_FOUND);
            return;
        }
        final AtomicBoolean atomicBooleanF_ = aVar.f_();
        if (!aVar.A() && !atomicBooleanF_.get()) {
            e3.a.e("disconnect disconnected device id : %s, unSyn return ok", aVar.X());
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
        } else {
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.control.base.c.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f28912a.b(aVar, atomicBooleanF_, oVar, basicReq);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.haier.uhome.control.base.api.a aVar, AtomicBoolean atomicBoolean, com.haier.uhome.usdk.base.api.o oVar, BasicReq basicReq) {
        if (aVar.A() && !atomicBoolean.get()) {
            e3.a.e("connect connected device id : %s, unSyn return ok", aVar.X());
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
            return;
        }
        synchronized (aVar.a()) {
            atomicBoolean.set(true);
            if (aVar != b(aVar.X())) {
                com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_INTERNAL);
                return;
            }
            if (aVar.A()) {
                e3.a.e("connect connected device id : %s, return ok", aVar.X());
                com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
                return;
            }
            e3.a.d("do connect device id:%s-request:%s", aVar.X(), basicReq + "", new Object[0]);
            uSDKError usdkerrorA = a(basicReq, 15);
            e3.a.e("do connect device id:%s-result:%s", aVar.X(), Integer.valueOf(usdkerrorA.getCode()));
            aVar.c(oVar);
            if (usdkerrorA.getCode() == 0 || usdkerrorA.getCode() == f28861c) {
                aVar.e(true);
            }
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.getErrorConstById(usdkerrorA.getCode()));
            atomicBoolean.set(false);
        }
    }

    protected void a(com.haier.uhome.usdk.base.d.e eVar, String str, String str2, List<Integer> list, String str3, int i7, final Trace trace, final ICallback<String> iCallback) {
        if (!e()) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_MODULE_UNSTARTED.toError());
            return;
        }
        final com.haier.uhome.control.base.api.a aVar = this.f28862a.get(str);
        if (aVar == null) {
            e3.a.h("readDeviceAttribute device not found in deviceMap ", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError());
            return;
        }
        if (com.haier.uhome.trace.b.g.a().c() && (trace == null || TextUtils.isEmpty(trace.getTraceId()))) {
            e3.a.h("enable ditrace,but ditrace is null or traceId is null", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        final com.haier.uhome.control.base.d.a aVar2 = new com.haier.uhome.control.base.d.a(trace, "read", aVar, System.currentTimeMillis());
        aVar2.a("name", str3);
        DeviceAttrReadReq deviceAttrReadReqB = b();
        try {
            uSDKError usdkerrorF = f(aVar);
            ErrorConst errorConst = ErrorConst.RET_USDK_OK;
            if (usdkerrorF.a(errorConst)) {
                usdkerrorF = a(aVar, deviceAttrReadReqB);
            }
            if (!usdkerrorF.a(errorConst)) {
                aVar2.a(usdkerrorF);
                com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, usdkerrorF);
                return;
            }
            deviceAttrReadReqB.setModule(f());
            deviceAttrReadReqB.setDevId(str);
            deviceAttrReadReqB.setParentDevId(str2);
            deviceAttrReadReqB.setSubdeviceList(list);
            deviceAttrReadReqB.setName(str3);
            deviceAttrReadReqB.setTimeout(i7);
            deviceAttrReadReqB.setTraceId(trace == null ? null : trace.getTraceId());
            deviceAttrReadReqB.setNativeSender(eVar);
            final com.haier.uhome.control.base.api.a.C0367a c0367aB = aVar.b(i7);
            com.haier.uhome.usdk.base.d.a.a().a(deviceAttrReadReqB, i7, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.base.c.o
                @Override // com.haier.uhome.usdk.base.api.l
                public final void onResp(BasicResp basicResp) {
                    this.f28946a.b(c0367aB, trace, aVar, aVar2, iCallback, basicResp);
                }
            });
        } catch (Exception e8) {
            e3.a.h("tryReadDeviceAttr Error = %s", e8.getMessage());
            ErrorConst errorConst2 = ErrorConst.ERR_USDK_INVALID_PARAM;
            aVar2.a(errorConst2.toError());
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, errorConst2.toError());
        }
    }

    private void a(Trace trace, String str, com.haier.uhome.control.base.api.a aVar, String str2, String str3, int i7) {
        if (trace == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        DITraceNode dITraceNode = new DITraceNode("opack", str, aVar.X(), str2, VersionManager.getInstance().getSDKVersion());
        dITraceNode.add(TraceProtocolConst.PRO_SPAN, str3);
        dITraceNode.add("sys", com.haier.uhome.trace.b.e.MODULE.name());
        dITraceNode.add(TraceProtocolConst.PRO_PROTOCOL, g(aVar));
        dITraceNode.add("bspan", String.valueOf(i7));
        dITraceNode.add(TraceProtocolConst.PRO_NETWORK_TYPE, k());
        trace.addDITraceNode(dITraceNode);
    }

    protected void a(com.haier.uhome.usdk.base.d.e eVar, String str, String str2, List<Integer> list, String str3, String str4, int i7, final Trace trace, final ICallback<Void> iCallback) {
        if (!e()) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_MODULE_UNSTARTED.toError());
            return;
        }
        final com.haier.uhome.control.base.api.a aVar = this.f28862a.get(str);
        if (aVar == null) {
            e3.a.h("writeDeviceAttribute device not found in deviceMap ", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError());
            return;
        }
        if (com.haier.uhome.trace.b.g.a().c() && (trace == null || TextUtils.isEmpty(trace.getTraceId()))) {
            e3.a.h("enable ditrace,but ditrace is null or traceId is null", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        final com.haier.uhome.control.base.d.a aVar2 = new com.haier.uhome.control.base.d.a(trace, "write", aVar);
        aVar2.a("name", str3);
        aVar2.a("value", str4);
        DeviceAttrWriteReq deviceAttrWriteReqC = c();
        try {
            uSDKError usdkerrorF = f(aVar);
            ErrorConst errorConst = ErrorConst.RET_USDK_OK;
            if (usdkerrorF.a(errorConst)) {
                usdkerrorF = a(aVar, deviceAttrWriteReqC);
            }
            if (!usdkerrorF.a(errorConst)) {
                aVar2.a(usdkerrorF);
                com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, usdkerrorF);
                return;
            }
            deviceAttrWriteReqC.setSubdeviceList(list);
            deviceAttrWriteReqC.setName(str3);
            deviceAttrWriteReqC.setValue(str4);
            deviceAttrWriteReqC.setTimeout(i7);
            deviceAttrWriteReqC.setTraceId(trace == null ? null : trace.getTraceId());
            deviceAttrWriteReqC.setNativeSender(eVar);
            final com.haier.uhome.control.base.api.a.C0367a c0367aB = aVar.b(i7);
            com.haier.uhome.usdk.base.d.a.a().a(deviceAttrWriteReqC, i7, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.base.c.r
                @Override // com.haier.uhome.usdk.base.api.l
                public final void onResp(BasicResp basicResp) {
                    this.f28958a.a(c0367aB, trace, aVar, aVar2, iCallback, basicResp);
                }
            });
        } catch (Exception e8) {
            e3.a.h("writeDeviceAttribute Error = %s", e8.getMessage());
            ErrorConst errorConst2 = ErrorConst.ERR_USDK_INVALID_PARAM;
            aVar2.a(errorConst2.toError());
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, errorConst2.toError());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.haier.uhome.control.base.api.a.C0367a c0367a, Trace trace, com.haier.uhome.control.base.api.a aVar, com.haier.uhome.control.base.d.a aVar2, ICallback iCallback, BasicResp basicResp) {
        uSDKError usdkerrorA = c0367a.a();
        DeviceAttrWriteResp deviceAttrWriteResp = (DeviceAttrWriteResp) basicResp;
        uSDKError usdkerrorA2 = com.haier.uhome.usdk.base.utils.c.a(basicResp);
        if (deviceAttrWriteResp != null && usdkerrorA2 != null) {
            usdkerrorA2.a(deviceAttrWriteResp.getInvalidCode());
        }
        if (usdkerrorA2.a(ErrorConst.ERR_USDK_INVALID_COMMAND)) {
            usdkerrorA2.a(String.valueOf(deviceAttrWriteResp.getReason()));
        }
        if ((!usdkerrorA2.a(ErrorConst.ERR_USDK_TIMEOUT) && usdkerrorA2.getCode() != h()) || usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            usdkerrorA = usdkerrorA2;
        }
        a(trace, "write", aVar, deviceAttrWriteResp.getCode(), deviceAttrWriteResp.getSpan(), deviceAttrWriteResp.getBoardSpan());
        aVar2.a(usdkerrorA);
        if (usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
        } else {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerrorA);
        }
    }

    protected uSDKError a(com.haier.uhome.control.base.api.a aVar, BasicOpReq basicOpReq) {
        basicOpReq.setModule(f());
        basicOpReq.setDevId(aVar.X());
        basicOpReq.setParentDevId(aVar.U());
        basicOpReq.setIsGroup(aVar.ah());
        return ErrorConst.RET_USDK_OK.toError();
    }

    public void a(com.haier.uhome.usdk.base.d.e eVar, String str, int i7, Trace trace, final ICallback<com.haier.uhome.control.base.api.r> iCallback) {
        if (!e()) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_MODULE_UNSTARTED.toError());
            return;
        }
        com.haier.uhome.control.base.api.a aVar = this.f28862a.get(str);
        if (aVar == null) {
            e3.a.h("getNetworkQuality device not found in deviceMap ", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError());
            return;
        }
        if (!aVar.A()) {
            e3.a.e("getNetworkQuality device not connected", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_DEVICE_NOT_CONNECT.toError());
            return;
        }
        if (aVar.n() != DeviceStatus.STATUS_READY && aVar.n() != DeviceStatus.STATUS_CONNECTED) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_DEVICE_NOT_CONNECTED.toError());
            return;
        }
        if (com.haier.uhome.trace.b.g.a().c() && (trace == null || TextUtils.isEmpty(trace.getTraceId()))) {
            e3.a.e("enable ditrace,but ditrace is null or traceId is null", new Object[0]);
        }
        if (eVar == null) {
            e3.a.h("getNetworkQuality with null sender", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        NetworkQualityReq networkQualityReq = new NetworkQualityReq();
        networkQualityReq.setTimeout(i7);
        networkQualityReq.setTraceId(trace == null ? "" : trace.getTraceId());
        networkQualityReq.setNativeSender(eVar);
        networkQualityReq.setDevId(str);
        networkQualityReq.setModule("local");
        com.haier.uhome.usdk.base.d.a.a().a(networkQualityReq, i7, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.base.c.l
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                a.a(iCallback, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ICallback iCallback, BasicResp basicResp) {
        NetworkQualityResp networkQualityResp = (NetworkQualityResp) basicResp;
        if (networkQualityResp.getErrNo() != 0) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, com.haier.uhome.usdk.base.utils.c.a(networkQualityResp));
            return;
        }
        com.haier.uhome.control.base.api.r rVar = new com.haier.uhome.control.base.api.r();
        rVar.a(networkQualityResp.getStrength());
        rVar.c(networkQualityResp.getLplr());
        rVar.b(networkQualityResp.getLrtt());
        rVar.e(networkQualityResp.getRplr());
        rVar.d(networkQualityResp.getRrtt());
        com.haier.uhome.usdk.base.utils.b.a((ICallback<com.haier.uhome.control.base.api.r>) iCallback, rVar);
    }

    public void a(com.haier.uhome.usdk.base.d.e eVar, String str, com.haier.uhome.usdk.base.api.o oVar) {
        if (!e()) {
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_MODULE_UNSTARTED);
            return;
        }
        if (this.f28862a.get(str) == null) {
            e3.a.h("getDeviceState device not found in deviceMap ", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_DEVICE_NOT_FOUND);
            return;
        }
        DeviceStateReq deviceStateReq = new DeviceStateReq();
        try {
            deviceStateReq.setNativeSender(eVar);
            deviceStateReq.setDevId(str);
            deviceStateReq.setModule(f());
            com.haier.uhome.usdk.base.d.a.a().a(deviceStateReq, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.base.c.g
                @Override // com.haier.uhome.usdk.base.api.l
                public final void onResp(BasicResp basicResp) {
                    a.a(basicResp);
                }
            });
        } catch (Exception e8) {
            e3.a.h("getDeviceState Error = %s", e8.getMessage());
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_INVALID_PARAM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(BasicResp basicResp) {
        e3.a.e("getDeviceState ret %d", Integer.valueOf(basicResp.getErrNo()));
    }

    public void a(com.haier.uhome.usdk.base.d.e eVar, String str, String str2, List<Integer> list, String str3, List<com.haier.uhome.control.base.api.c> list2, int i7, final Trace trace, final String str4, final ICallback<Void> iCallback) {
        if (!e()) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_MODULE_UNSTARTED.toError());
            return;
        }
        final com.haier.uhome.control.base.api.a aVar = this.f28862a.get(str);
        if (aVar == null) {
            e3.a.h("execDeviceOperation device not found in deviceMap ", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_DEVICE_NOT_FOUND.toError());
            return;
        }
        if (list2 == null) {
            e3.a.h("execDeviceOperation args is null ", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        if (com.haier.uhome.trace.b.g.a().c() && (trace == null || TextUtils.isEmpty(trace.getTraceId()))) {
            e3.a.h("enable ditrace,but ditrace is null or traceId is null", new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        final com.haier.uhome.control.base.d.a aVar2 = new com.haier.uhome.control.base.d.a(trace, com.haier.library.common.util.c.m(str4) ? "op" : str4, aVar);
        aVar2.a("name", str3);
        DeviceOperReq deviceOperReqD = d();
        try {
            uSDKError usdkerrorF = f(aVar);
            ErrorConst errorConst = ErrorConst.RET_USDK_OK;
            if (usdkerrorF.a(errorConst)) {
                usdkerrorF = a(aVar, deviceOperReqD);
            }
            if (!usdkerrorF.a(errorConst)) {
                aVar2.a(usdkerrorF);
                com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, usdkerrorF);
                return;
            }
            deviceOperReqD.setSubdeviceList(list);
            deviceOperReqD.setOp(str3);
            ArrayList arrayList = new ArrayList(list2.size());
            for (com.haier.uhome.control.base.api.c cVar : list2) {
                arrayList.add(new OperArgs(cVar.getName(), cVar.getValue()));
            }
            deviceOperReqD.setArgs(arrayList);
            deviceOperReqD.setTimeout(i7);
            deviceOperReqD.setTraceId(trace == null ? null : trace.getTraceId());
            deviceOperReqD.setNativeSender(eVar);
            final com.haier.uhome.control.base.api.a.C0367a c0367aB = aVar.b(i7);
            com.haier.uhome.usdk.base.d.a.a().a(deviceOperReqD, i7, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.base.c.k
                @Override // com.haier.uhome.usdk.base.api.l
                public final void onResp(BasicResp basicResp) {
                    this.f28933a.a(c0367aB, trace, str4, aVar, aVar2, iCallback, basicResp);
                }
            });
        } catch (Exception e8) {
            e3.a.h("execDeviceOperation Error = %s", e8.getMessage());
            ErrorConst errorConst2 = ErrorConst.ERR_USDK_INVALID_PARAM;
            aVar2.a(errorConst2.toError());
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, errorConst2.toError());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.haier.uhome.control.base.api.a.C0367a c0367a, Trace trace, String str, com.haier.uhome.control.base.api.a aVar, com.haier.uhome.control.base.d.a aVar2, ICallback iCallback, BasicResp basicResp) {
        uSDKError usdkerrorA = c0367a.a();
        DeviceOperResp deviceOperResp = (DeviceOperResp) basicResp;
        uSDKError usdkerrorA2 = com.haier.uhome.usdk.base.utils.c.a(basicResp);
        if (deviceOperResp != null && usdkerrorA2 != null) {
            usdkerrorA2.a(deviceOperResp.getInvalidCode());
        }
        if (usdkerrorA2.a(ErrorConst.ERR_USDK_INVALID_COMMAND)) {
            usdkerrorA2.a(String.valueOf(deviceOperResp.getReason()));
        }
        if ((!usdkerrorA2.a(ErrorConst.ERR_USDK_TIMEOUT) && usdkerrorA2.getCode() != h()) || usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            usdkerrorA = usdkerrorA2;
        }
        if (com.haier.library.common.util.c.m(str)) {
            str = "op";
        }
        a(trace, str, aVar, deviceOperResp.getCode(), deviceOperResp.getSpan(), deviceOperResp.getBoardSpan());
        aVar2.a(usdkerrorA);
        if (usdkerrorA.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.usdk.base.utils.b.a((ICallback<Object>) iCallback, (Object) null);
        } else {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerrorA);
        }
    }

    public void a(String str, String str2, int i7, String str3, String str4, com.haier.uhome.usdk.base.api.q qVar, boolean z7, TraceNode traceNode, String str5, final com.haier.uhome.control.base.api.l lVar) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.control.base.c.m
            @Override // java.lang.Runnable
            public final void run() {
                a.a(lVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.control.base.api.l lVar) {
        if (lVar != null) {
            lVar.onDeviceBindInfoGet(ErrorConst.ERR_USDK_NOT_SUPPORT, null);
        } else {
            e3.a.v("getDeviceBindInfo callback is null,so give up callback", new Object[0]);
        }
    }

    public Object a(Object obj, String str) {
        synchronized (obj) {
            Object obj2 = this.f28865f.get(str);
            if (obj2 != null) {
                return obj2;
            }
            Object obj3 = new Object();
            this.f28865f.put(str, obj3);
            return obj3;
        }
    }
}
