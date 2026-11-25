package com.haier.uhome.usdk.api;

import android.text.TextUtils;
import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.usdk.base.utils.ConfigInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l implements com.haier.uhome.usdk.api.interfaces.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f30616a = 100;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<DeviceStatus, Integer> f30617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicBoolean f30618c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f30619d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ConfigInfo f30620e;

    static {
        HashMap map = new HashMap(6);
        f30617b = map;
        map.put(DeviceStatus.STATUS_UNCONNECT, 10);
        f30617b.put(DeviceStatus.STATUS_OFFLINE, 20);
        f30617b.put(DeviceStatus.STATUS_CONNECTING, 30);
        f30617b.put(DeviceStatus.STATUS_CONNECTED, 40);
        f30617b.put(DeviceStatus.STATUS_READY, 50);
    }

    public l() throws Throwable {
        c();
    }

    private void b(List<com.haier.uhome.control.base.api.a> list) {
        com.haier.uhome.control.base.api.a aVarA = a(com.haier.uhome.control.local.api.i.class, list);
        if (aVarA == null || c(list)) {
            return;
        }
        e3.a.e("remove no token local device<%s>", aVarA.X());
        list.remove(aVarA);
    }

    private void c() throws Throwable {
        ConfigInfo configInfoLoadConfigInfo = ConfigInfo.loadConfigInfo();
        this.f30620e = configInfoLoadConfigInfo;
        if (configInfoLoadConfigInfo == null) {
            e3.a.e("no config info", new Object[0]);
            return;
        }
        if (configInfoLoadConfigInfo.getPassLevelNoumenon() != 0 || this.f30620e.getPassLevelLocal() != 0 || this.f30620e.getPassLevelRemote() != 0 || this.f30620e.getPassLevelGateway() != 0 || this.f30620e.getPassLevelMesh() != 0 || this.f30620e.getPassLevelBle() != 0) {
            e3.a.e("user test engineer pass level set to[noumenon:%d-local:%d-cloud:%d-gw:%d-mesh:%d-ble:%d]", Integer.valueOf(this.f30620e.getPassLevelNoumenon()), Integer.valueOf(this.f30620e.getPassLevelLocal()), Integer.valueOf(this.f30620e.getPassLevelRemote()), Integer.valueOf(this.f30620e.getPassLevelGateway()), Integer.valueOf(this.f30620e.getPassLevelMesh()), Integer.valueOf(this.f30620e.getPassLevelBle()));
        } else {
            e3.a.e("config info error", new Object[0]);
            this.f30620e = null;
        }
    }

    private List<com.haier.uhome.control.base.api.a> d(uSDKDevice usdkdevice, List<com.haier.uhome.control.base.api.a> list) {
        com.haier.uhome.control.base.api.a aVarA;
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(com.haier.uhome.usdk.base.service.e.a().g()) && usdkdevice != null && (aVarA = a(com.haier.uhome.control.local.api.h.class, list)) != null && aVarA.W() != null && usdkdevice.isMainDevice()) {
            arrayList.add(aVarA);
        }
        return arrayList;
    }

    private void e(uSDKDevice usdkdevice, List<com.haier.uhome.control.base.api.a> list) {
        com.haier.uhome.control.base.api.a aVarA = a(com.haier.uhome.control.local.api.d.class, list);
        if (aVarA == null) {
            return;
        }
        if (!c(list)) {
            e3.a.e("remove no token mesh device<%s>", aVarA.X());
            list.remove(aVarA);
        }
        if (a(list, com.haier.uhome.control.local.api.h.class) || a(list, com.haier.uhome.control.cloud.api.c.class) || a(list, com.haier.uhome.control.local.api.i.class)) {
            return;
        }
        a(list, com.haier.uhome.control.noumenon.a.a.class);
    }

    private void f(uSDKDevice usdkdevice, List<com.haier.uhome.control.base.api.a> list) {
        b(usdkdevice, list);
    }

    private void g(uSDKDevice usdkdevice, List<com.haier.uhome.control.base.api.a> list) {
        a(list);
        c(usdkdevice, list);
        a(usdkdevice, list);
    }

    @Override // com.haier.uhome.usdk.api.interfaces.b
    public List<com.haier.uhome.control.base.api.a> a(uSDKDevice usdkdevice, boolean z7, List<com.haier.uhome.control.base.api.a> list) {
        if (usdkdevice == null) {
            e3.a.e("needConnect with null device", new Object[0]);
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list);
        if (!z7) {
            List<com.haier.uhome.control.base.api.a> listD = d(usdkdevice, arrayList);
            a(usdkdevice, "need connect no care", listD);
            return listD;
        }
        g(usdkdevice, arrayList);
        f(usdkdevice, arrayList);
        e(usdkdevice, arrayList);
        b(arrayList);
        a(usdkdevice, "need connect", arrayList);
        return arrayList;
    }

    @Override // com.haier.uhome.usdk.api.interfaces.b
    public List<com.haier.uhome.control.base.api.a> b(final uSDKDevice usdkdevice, final boolean z7, List<com.haier.uhome.control.base.api.a> list) {
        if (com.haier.library.common.util.u.h(list)) {
            e3.a.e("sortByPriority with null control device list", new Object[0]);
            return null;
        }
        if (usdkdevice == null) {
            e3.a.e("sortByPriority with null device", new Object[0]);
            return null;
        }
        ArrayList arrayList = new ArrayList(list);
        if (arrayList.size() == 1) {
            a(usdkdevice, "sort result", arrayList);
            return arrayList;
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.haier.uhome.usdk.api.r1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return this.f30709a.a(usdkdevice, z7, (com.haier.uhome.control.base.api.a) obj, (com.haier.uhome.control.base.api.a) obj2);
            }
        });
        a(usdkdevice, "sort result", arrayList);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ int a(uSDKDevice usdkdevice, boolean z7, com.haier.uhome.control.base.api.a aVar, com.haier.uhome.control.base.api.a aVar2) {
        return Integer.compare(a(usdkdevice, z7, aVar2), a(usdkdevice, z7, aVar));
    }

    protected int a(uSDKDevice usdkdevice, boolean z7, com.haier.uhome.control.base.api.a aVar) {
        Integer num;
        if (aVar == null) {
            return 0;
        }
        int iA = (!aVar.i_() || a(aVar)) ? a(usdkdevice, aVar) : 0;
        return (z7 && (num = f30617b.get(aVar.n())) != null) ? iA + num.intValue() : iA;
    }

    protected void b(uSDKDevice usdkdevice, List<com.haier.uhome.control.base.api.a> list) {
        com.haier.uhome.control.base.api.a aVarA = a(com.haier.uhome.control.local.api.g.class, list);
        if (aVarA == null) {
            return;
        }
        com.haier.uhome.control.base.api.a aVarA2 = a(com.haier.uhome.control.cloud.api.c.class, list);
        if (aVarA2 == null) {
            e3.a.e("no token ble device<%s|%s>", aVarA.X(), aVarA.n());
            list.remove(aVarA);
            return;
        }
        if (!com.haier.uhome.usdk.base.utils.a.c()) {
            e3.a.e("blue tooth is not enable so remove ble device<%s|%s>", aVarA.X(), aVarA.n());
            list.remove(aVarA);
            return;
        }
        com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(usdkdevice.getDeviceId());
        if (fVarA == null || !(com.haier.uhome.usdk.base.api.e.a(fVarA.n()) || com.haier.uhome.usdk.base.api.e.c(fVarA.n()))) {
            com.haier.uhome.control.base.api.a aVarA3 = a(com.haier.uhome.control.local.api.h.class, list);
            if (!this.f30618c.get() && (a(aVarA2) || a(aVarA3))) {
                e3.a.e("local or cloud is positive state so remove ble device<%s|%s>", aVarA.X(), aVarA.n());
                list.remove(aVarA);
            } else {
                if (com.haier.uhome.search.a.n.a().b(usdkdevice.getDeviceId()) != null || a(aVarA)) {
                    return;
                }
                e3.a.e("not find so remove ble device<%s|%s>", aVarA.X(), aVarA.n());
                list.remove(aVarA);
            }
        }
    }

    protected int a(uSDKDevice usdkdevice, com.haier.uhome.control.base.api.a aVar) {
        int passLevelMesh;
        if (usdkdevice == null || aVar == null) {
            return 0;
        }
        if (aVar instanceof com.haier.uhome.control.local.api.h) {
            ConfigInfo configInfo = this.f30620e;
            passLevelMesh = configInfo == null ? 6 : configInfo.getPassLevelLocal();
        } else if (aVar.getClass().equals(com.haier.uhome.control.local.api.g.class)) {
            if (a(usdkdevice.getDeviceId())) {
                return 100;
            }
            if (b(usdkdevice.getDeviceId())) {
                ConfigInfo configInfo2 = this.f30620e;
                passLevelMesh = configInfo2 == null ? 5 : configInfo2.getPassLevelRemote() + 1;
            } else {
                ConfigInfo configInfo3 = this.f30620e;
                passLevelMesh = configInfo3 == null ? 2 : configInfo3.getPassLevelBle();
            }
        } else if (aVar instanceof com.haier.uhome.control.cloud.api.c) {
            ConfigInfo configInfo4 = this.f30620e;
            passLevelMesh = configInfo4 == null ? 4 : configInfo4.getPassLevelRemote();
        } else if (aVar instanceof com.haier.uhome.control.local.api.i) {
            ConfigInfo configInfo5 = this.f30620e;
            passLevelMesh = configInfo5 == null ? 3 : configInfo5.getPassLevelGateway();
        } else {
            if (!(aVar instanceof com.haier.uhome.control.local.api.d)) {
                return 0;
            }
            ConfigInfo configInfo6 = this.f30620e;
            if (configInfo6 == null) {
                return 1;
            }
            passLevelMesh = configInfo6.getPassLevelMesh();
        }
        return passLevelMesh;
    }

    private boolean c(List<com.haier.uhome.control.base.api.a> list) {
        return a(com.haier.uhome.control.cloud.api.c.class, list) != null;
    }

    protected void c(uSDKDevice usdkdevice, List<com.haier.uhome.control.base.api.a> list) {
        com.haier.uhome.control.local.api.h hVar;
        if (uSDKDeviceManager.getSingleInstance().h()) {
            return;
        }
        if ((com.haier.uhome.usdk.base.service.a.a().b() && com.haier.uhome.usdk.base.service.f.a().b()) || (hVar = (com.haier.uhome.control.local.api.h) a(com.haier.uhome.control.local.api.h.class, list)) == null || hVar.J() != com.haier.uhome.usdk.base.api.d.DEV_PROT_EPP) {
            return;
        }
        list.remove(hVar);
        e3.a.e("loadReduction to the local control dev status=" + hVar.n(), new Object[0]);
    }

    protected void a(uSDKDevice usdkdevice, List<com.haier.uhome.control.base.api.a> list) {
        com.haier.uhome.control.local.api.h hVar = (com.haier.uhome.control.local.api.h) a(com.haier.uhome.control.local.api.h.class, list);
        if (hVar == null || hVar.K() == 0 || usdkdevice.isComplexDevice() || usdkdevice.getStatus() == uSDKDeviceStatusConst.STATUS_UNCONNECT || c(list)) {
            return;
        }
        e3.a.e("remove no token local device<%s>", hVar.X());
        list.remove(hVar);
    }

    boolean b() {
        return this.f30618c.compareAndSet(true, false);
    }

    boolean b(String str) {
        com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(str);
        if (fVarA == null || !com.haier.uhome.usdk.base.api.e.c(fVarA.n())) {
            return this.f30618c.get() && this.f30619d.get();
        }
        return true;
    }

    protected com.haier.uhome.control.base.api.a a(Class cls, List<com.haier.uhome.control.base.api.a> list) {
        if (cls != null && list != null) {
            for (com.haier.uhome.control.base.api.a aVar : list) {
                if (aVar != null && aVar.getClass().equals(cls)) {
                    return aVar;
                }
            }
            return null;
        }
        e3.a.v("getControlDeviceWithType with classType=" + cls + " controlDeviceList=" + list, new Object[0]);
        return null;
    }

    private boolean a(List<com.haier.uhome.control.base.api.a> list, Class cls) {
        com.haier.uhome.control.base.api.a aVarA;
        if (list == null || list.size() == 0 || (aVarA = a(cls, list)) == null) {
            return false;
        }
        return a(aVarA);
    }

    private boolean a(com.haier.uhome.control.base.api.a aVar) {
        if (aVar == null) {
            return false;
        }
        return aVar.n() == DeviceStatus.STATUS_READY || aVar.n() == DeviceStatus.STATUS_CONNECTED;
    }

    protected void a(List<com.haier.uhome.control.base.api.a> list) {
        ArrayList arrayList = new ArrayList();
        for (com.haier.uhome.control.base.api.a aVar : list) {
            if ((aVar instanceof com.haier.uhome.control.local.api.h) && aVar.i_() && !a(aVar)) {
                arrayList.add(aVar);
            }
        }
        e3.a.e("remove busy device = " + arrayList.toString(), new Object[0]);
        list.removeAll(arrayList);
    }

    boolean a() {
        return this.f30618c.compareAndSet(false, true);
    }

    void a(boolean z7) {
        this.f30619d.set(z7);
    }

    boolean a(String str) {
        com.haier.uhome.usdk.base.api.f fVarB = com.haier.uhome.search.a.n.a().b(str);
        return (fVarB == null || fVarB.r().e() != 0 || com.haier.uhome.usdk.base.api.e.c(fVarB.n())) ? false : true;
    }

    protected void a(uSDKDevice usdkdevice, String str, List<com.haier.uhome.control.base.api.a> list) {
        if (usdkdevice == null) {
            return;
        }
        String deviceId = usdkdevice.getDeviceId();
        if (deviceId == null) {
            deviceId = "noId";
        }
        if (com.haier.library.common.util.u.h(list)) {
            e3.a.e("logBestList<%s> " + str + " null", deviceId);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int elementAddr = usdkdevice.getElementAddr();
        if (elementAddr > 0) {
            sb.append(String.format("logBestList<%s-%s> %s", deviceId, elementAddr + "", str));
        } else {
            sb.append(String.format("logBestList<%s> %s", deviceId, str));
        }
        for (com.haier.uhome.control.base.api.a aVar : list) {
            sb.append(" ");
            sb.append(aVar.e());
            sb.append(":");
            sb.append(a(usdkdevice, true, aVar));
            sb.append(":");
            sb.append(aVar.n());
        }
        e3.a.e(sb.toString(), new Object[0]);
    }
}
