package com.haier.uhome.search.b;

import android.text.TextUtils;
import com.haier.uhome.search.json.notify.DeviceUpdateNotify;
import com.haier.uhome.usdk.base.json.BasicNotify;

/* JADX INFO: loaded from: classes2.dex */
public class d extends com.haier.uhome.usdk.base.c.e {
    private boolean a(DeviceUpdateNotify deviceUpdateNotify) {
        String bdAddress;
        String module = deviceUpdateNotify.getModule();
        if (!com.haier.uhome.usdk.base.a.aq.equalsIgnoreCase(module)) {
            return false;
        }
        if (deviceUpdateNotify.getConfigurable() != 1 && deviceUpdateNotify.getTriggerConfigurable() != 1) {
            if (deviceUpdateNotify.getControllable() != 1) {
                a(deviceUpdateNotify, 3);
                return true;
            }
            if (deviceUpdateNotify.getAccessoryWifi() != 1) {
                e3.a.e("isLocalkeyValid == 1,but AccessoryWifi ==1 ,can not give up %s", deviceUpdateNotify);
            } else if (deviceUpdateNotify.getLocalkeyValid() != 1) {
                e3.a.v("isLocalkeyValid != 1, so give up %s", deviceUpdateNotify);
                return true;
            }
            a(deviceUpdateNotify, 3);
            return false;
        }
        int i7 = deviceUpdateNotify.getTriggerConfigurable() == 1 ? 2 : 1;
        if (deviceUpdateNotify.getAccessoryWifi() == 1) {
            bdAddress = deviceUpdateNotify.getWifiMac();
            if (deviceUpdateNotify.getSelfBind() != 1) {
                e3.a.v("SelfBound != 1, so give up %s", deviceUpdateNotify);
                return true;
            }
        } else {
            bdAddress = deviceUpdateNotify.getBdAddress();
        }
        if (TextUtils.isEmpty(bdAddress)) {
            e3.a.v("devId is empty, so give up %s", deviceUpdateNotify);
            return true;
        }
        deviceUpdateNotify.setDevId(bdAddress);
        a(deviceUpdateNotify, i7);
        f.a().a(module, bdAddress, 6);
        return true;
    }

    @Override // com.haier.uhome.usdk.base.c.e
    protected void handleReceive(BasicNotify basicNotify) {
        com.haier.uhome.usdk.base.api.f fVarA;
        DeviceUpdateNotify deviceUpdateNotify = (DeviceUpdateNotify) basicNotify;
        if (com.haier.uhome.usdk.base.a.ao.equals(deviceUpdateNotify.getModule()) && (fVarA = com.haier.uhome.usdk.base.api.g.a().a(deviceUpdateNotify.getDevId())) != null) {
            fVarA.b(deviceUpdateNotify.getBindTimestamp());
        }
        if (com.haier.uhome.usdk.base.a.aq.equalsIgnoreCase(deviceUpdateNotify.getModule()) || "local".equalsIgnoreCase(deviceUpdateNotify.getModule())) {
            if ("local".equalsIgnoreCase(deviceUpdateNotify.getModule()) && com.haier.library.common.util.c.m(deviceUpdateNotify.getDevId())) {
                deviceUpdateNotify.setDevId(deviceUpdateNotify.getName());
            }
            e3.a.d("SEARCH", com.haier.uhome.search.a.f29682c, "notify search device<%s> update msg %s", deviceUpdateNotify.getDevId(), deviceUpdateNotify);
            String module = deviceUpdateNotify.getModule();
            boolean zEqualsIgnoreCase = com.haier.uhome.usdk.base.a.aq.equalsIgnoreCase(module);
            if (a(deviceUpdateNotify)) {
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29682c, "notify to config business", new Object[0]);
                return;
            }
            if (TextUtils.isEmpty(deviceUpdateNotify.getDevId())) {
                e3.a.d("SEARCH", com.haier.uhome.search.a.f29682c, "Controllable dev devId must not null", new Object[0]);
                return;
            }
            String onlineVer = deviceUpdateNotify.getOnlineVer();
            if (TextUtils.isEmpty(onlineVer) || onlineVer.equals("v_normal")) {
                a(deviceUpdateNotify, module, zEqualsIgnoreCase);
            } else {
                a(deviceUpdateNotify, module, onlineVer);
            }
        }
    }

    private void a(DeviceUpdateNotify deviceUpdateNotify, String str, boolean z7) {
        com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(deviceUpdateNotify.getDevId());
        if (fVarA == null) {
            e3.a.f("SEARCH", com.haier.uhome.search.a.f29682c, "notify a illegal device update msg %s", deviceUpdateNotify);
            return;
        }
        fVarA.a(deviceUpdateNotify.getDevId());
        fVarA.c(deviceUpdateNotify.getUpdatable() != 0);
        fVarA.b(deviceUpdateNotify.getIsAuxConfigCapability());
        if (z7) {
            fVarA.r().b(deviceUpdateNotify.getBleDevId());
            fVarA.r().b(deviceUpdateNotify.getAccessoryWifi());
            fVarA.r().a(com.haier.uhome.usdk.base.api.q.a(deviceUpdateNotify.getProtocol()));
            fVarA.r().a(deviceUpdateNotify.getSecurityVersionName());
            fVarA.r().c(deviceUpdateNotify.getProtocolVers());
        } else {
            fVarA.b(deviceUpdateNotify.getUplusId());
            fVarA.b(deviceUpdateNotify.getSupportNetworkQuality() > 0);
            fVarA.b(deviceUpdateNotify.getBindTimestamp());
            fVarA.a(deviceUpdateNotify.getIsMeshGW() == 1);
            fVarA.p().e(deviceUpdateNotify.getDevId());
            fVarA.p().f(deviceUpdateNotify.getIp4hostAddress());
            fVarA.p().g(deviceUpdateNotify.getIp6hostAddress());
            fVarA.p().e(deviceUpdateNotify.getPort());
            fVarA.p().d(deviceUpdateNotify.getSharedPort());
            fVarA.p().d(deviceUpdateNotify.getSoftwareType());
            fVarA.p().a(deviceUpdateNotify.getBusy() > 0);
            fVarA.p().b(deviceUpdateNotify.getSmartlinkSeed());
            fVarA.p().c(deviceUpdateNotify.getConfigMode());
            fVarA.p().b(deviceUpdateNotify.getHardwareVer());
            fVarA.p().c(deviceUpdateNotify.getSoftwareVer());
            fVarA.p().a(com.haier.uhome.usdk.base.api.q.a(deviceUpdateNotify.getProtocol()));
            fVarA.p().a(deviceUpdateNotify.getSecurityVersionName());
            fVarA.p().h(deviceUpdateNotify.getProtocolVers());
        }
        fVarA.d(deviceUpdateNotify.getProductCode());
        f.a().a(str, fVarA);
        f.a().b(deviceUpdateNotify.getDevId(), 0);
    }

    private void a(DeviceUpdateNotify deviceUpdateNotify, String str, String str2) {
        if (!str2.equals("v_bind")) {
            e3.a.v("onLineVersion = %s", str2);
            return;
        }
        int devState = deviceUpdateNotify.getDevState();
        if (devState != 2) {
            e3.a.v("devState = %d", Integer.valueOf(devState));
            return;
        }
        String configureBindingMode = deviceUpdateNotify.getConfigureBindingMode();
        if (!com.haier.library.common.util.c.c(configureBindingMode, "5")) {
            e3.a.v("configureBindingMode = %d", configureBindingMode);
            return;
        }
        int verificationMethod = deviceUpdateNotify.getVerificationMethod();
        if (verificationMethod != 0 && verificationMethod != 1) {
            e3.a.v("verificationMethod = %d", Integer.valueOf(verificationMethod));
        } else {
            f.a().a(str, deviceUpdateNotify.getDevId(), deviceUpdateNotify.getUplusId(), deviceUpdateNotify.getIp4hostAddress(), deviceUpdateNotify.getPort(), deviceUpdateNotify.getName(), deviceUpdateNotify.getProductCode(), deviceUpdateNotify.getVerificationMethod(), str2, devState);
            f.a().a(str, deviceUpdateNotify.getDevId(), 0);
        }
    }

    private void a(DeviceUpdateNotify deviceUpdateNotify, int i7) {
        com.haier.uhome.search.service.entity.b bVar = new com.haier.uhome.search.service.entity.b();
        bVar.a(deviceUpdateNotify.getDevId());
        bVar.v(deviceUpdateNotify.getBdAddress());
        bVar.b(deviceUpdateNotify.getBleDevId());
        bVar.c(deviceUpdateNotify.getName());
        bVar.a(deviceUpdateNotify.getTypeMain());
        bVar.b(deviceUpdateNotify.getTypeMinor());
        bVar.d(deviceUpdateNotify.getProductCode());
        bVar.c(deviceUpdateNotify.getAccessoryWifi());
        bVar.d(deviceUpdateNotify.getRssi());
        bVar.e(i7);
        bVar.h(deviceUpdateNotify.getConfigMode());
        bVar.e(deviceUpdateNotify.getProtocolVers());
        bVar.f(deviceUpdateNotify.getWifiMac());
        bVar.n(deviceUpdateNotify.getSecurityVersionName());
        bVar.o(deviceUpdateNotify.getProtoVer());
        bVar.p(deviceUpdateNotify.getConfigureBindingMode());
        bVar.q(deviceUpdateNotify.getKeyVer());
        bVar.r(deviceUpdateNotify.getHwPlatform());
        bVar.s(deviceUpdateNotify.getHwVer());
        bVar.t(deviceUpdateNotify.getModelShortID());
        f.a().a(bVar);
    }
}
