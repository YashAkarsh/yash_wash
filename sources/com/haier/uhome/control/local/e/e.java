package com.haier.uhome.control.local.e;

import com.haier.uhome.control.base.json.req.DeviceConnectReq;
import com.haier.uhome.control.base.json.req.DeviceDisconnectReq;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends a {
    protected e() {
    }

    @Override // com.haier.uhome.control.base.c.a
    public String a(int i7) {
        return com.haier.uhome.usdk.base.api.g.a().a(i7);
    }

    public void b(String str, com.haier.uhome.usdk.base.api.o oVar) {
        com.haier.uhome.control.base.api.a aVarB = b(str);
        if (aVarB == null) {
            e3.a.h("disconnect a not find device<id=%s>!!", str);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_DEVICE_NOT_FOUND);
            return;
        }
        if (!e()) {
            aVarB.e(false);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
            return;
        }
        e3.a.d("%s disConnectDevice(%s)", aVarB.e(), str, new Object[0]);
        DeviceDisconnectReq deviceDisconnectReq = new DeviceDisconnectReq();
        deviceDisconnectReq.setModule(f());
        deviceDisconnectReq.setDevId(str);
        deviceDisconnectReq.setElementAddr(((com.haier.uhome.control.local.api.c) aVarB).d());
        deviceDisconnectReq.setNativeSender(this.f31347b);
        a(aVarB, deviceDisconnectReq, oVar);
    }

    public void a(String str, String str2, int i7, boolean z7, int i8, com.haier.uhome.usdk.base.api.o oVar) {
        if (!e()) {
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_MODULE_UNSTARTED);
            return;
        }
        com.haier.uhome.control.base.api.a aVarB = b(str);
        if (aVarB == null) {
            e3.a.h("try to connect a not find device<id=%s>!!", str);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.ERR_USDK_DEVICE_NOT_FOUND);
            return;
        }
        aVarB.a(z7);
        e3.a.d("%s tryConnectDevice(%s,%s).", aVarB.e(), str, str2);
        DeviceConnectReq deviceConnectReq = new DeviceConnectReq();
        deviceConnectReq.setModule(f());
        deviceConnectReq.setDevId(str);
        deviceConnectReq.setMacAddress("");
        deviceConnectReq.setUplusId(str2);
        deviceConnectReq.setBleDevId("");
        deviceConnectReq.setIp("");
        deviceConnectReq.setPort(0);
        deviceConnectReq.setToken(com.haier.uhome.usdk.base.service.e.a().g());
        deviceConnectReq.setProtocol("");
        deviceConnectReq.setDeviceType(5);
        deviceConnectReq.setSecurityVersion("");
        deviceConnectReq.setSharedPort(aVarB.Z());
        deviceConnectReq.setElementAddr(i7);
        deviceConnectReq.setNativeSender(this.f31347b);
        deviceConnectReq.setIsMeshGW(0);
        deviceConnectReq.setIsAuxConfigCapability(i8);
        deviceConnectReq.setProtVers("");
        b(aVarB, deviceConnectReq, oVar);
    }

    @Override // com.haier.uhome.control.base.c.a
    public void a(String str, String str2, List<Integer> list, String str3, int i7, Trace trace, ICallback<String> iCallback) {
        a(this.f31347b, str, str2, list, str3, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.base.c.a
    public void a(String str, String str2, List<Integer> list, String str3, String str4, int i7, Trace trace, ICallback<Void> iCallback) {
        a(this.f31347b, str, str2, list, str3, str4, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.base.c.a
    public void a(String str, String str2, List<Integer> list, String str3, List<com.haier.uhome.control.base.api.c> list2, int i7, Trace trace, String str4, ICallback<Void> iCallback) {
        a(this.f31347b, str, str2, list, str3, list2, i7, trace, str4, iCallback);
    }
}
