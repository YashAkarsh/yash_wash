package com.haier.uhome.config.service;

import com.haier.uhome.config.json.ConfigProtocol;
import com.haier.uhome.config.json.req.DeviceBleSecurityAuthReq;
import com.haier.uhome.config.json.resp.DeviceBleSecurityAuthResp;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;

/* JADX INFO: loaded from: classes2.dex */
public class k implements com.haier.uhome.config.service.a.a<com.haier.uhome.config.entity.a, com.haier.uhome.config.entity.b, ICallback<com.haier.uhome.config.entity.b>> {
    static {
        ConfigProtocol.registerBle();
    }

    @Override // com.haier.uhome.config.service.a.a
    public /* synthetic */ uSDKError a() {
        return p3.a.a(this);
    }

    @Override // com.haier.uhome.config.service.a.a
    public void a(String str) {
    }

    @Override // com.haier.uhome.config.service.a.a
    public /* bridge */ /* synthetic */ void a(com.haier.uhome.config.entity.a aVar, ICallback iCallback) {
        a2(aVar, (ICallback<com.haier.uhome.config.entity.b>) iCallback);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public void a2(com.haier.uhome.config.entity.a aVar, final ICallback<com.haier.uhome.config.entity.b> iCallback) {
        DeviceBleSecurityAuthReq deviceBleSecurityAuthReq = new DeviceBleSecurityAuthReq();
        try {
            deviceBleSecurityAuthReq.setNativeSender(com.haier.uhome.usdk.base.service.c.a());
            deviceBleSecurityAuthReq.setBleDevId(aVar.a());
            deviceBleSecurityAuthReq.setTimeout(aVar.k());
            deviceBleSecurityAuthReq.setTraceId(aVar.i());
            deviceBleSecurityAuthReq.setToken(aVar.f());
            deviceBleSecurityAuthReq.setDevId("");
            deviceBleSecurityAuthReq.setModule(com.haier.uhome.usdk.base.a.aq);
            com.haier.uhome.usdk.base.d.a.a().a(deviceBleSecurityAuthReq, aVar.k(), new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.config.service.o0
                @Override // com.haier.uhome.usdk.base.api.l
                public final void onResp(BasicResp basicResp) {
                    k.a(iCallback, basicResp);
                }
            });
        } catch (Exception e8) {
            e3.a.g("Prepare device_ble_security_auth_req error", e8);
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(ICallback iCallback, BasicResp basicResp) {
        uSDKError usdkerrorB = com.haier.uhome.usdk.base.utils.c.b(basicResp);
        if (!usdkerrorB.a(ErrorConst.RET_USDK_OK)) {
            com.haier.uhome.usdk.base.utils.b.a(iCallback, usdkerrorB);
            return;
        }
        DeviceBleSecurityAuthResp deviceBleSecurityAuthResp = (DeviceBleSecurityAuthResp) basicResp;
        com.haier.uhome.config.entity.b bVar = new com.haier.uhome.config.entity.b();
        bVar.a(deviceBleSecurityAuthResp.getDevId());
        bVar.b(deviceBleSecurityAuthResp.getUplusId());
        com.haier.uhome.usdk.base.utils.b.a((ICallback<com.haier.uhome.config.entity.b>) iCallback, bVar);
    }
}
