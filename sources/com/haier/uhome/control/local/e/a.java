package com.haier.uhome.control.local.e;

import com.haier.uhome.control.cloud.api.FOTAInfo;
import com.haier.uhome.control.local.json.ControlBaseProtocol;
import com.haier.uhome.control.local.json.req.EndDeviceBleOtaReq;
import com.haier.uhome.control.local.json.req.GetBleOtaInfoReq;
import com.haier.uhome.control.local.json.req.StartDeviceBleOtaReq;
import com.haier.uhome.control.local.json.resp.EndDeviceBleOtaResp;
import com.haier.uhome.control.local.json.resp.GetBleOtaInfoResp;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends com.haier.uhome.control.base.c.a {
    static {
        ControlBaseProtocol.registerBLE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(com.haier.uhome.usdk.base.api.s sVar, BasicResp basicResp) {
        sVar.onCallback(com.haier.uhome.usdk.base.utils.c.a(basicResp));
    }

    public void a(String str, int i7, ICallback<FOTAInfo> iCallback) {
        com.haier.uhome.control.cloud.b.c.a(str, i7, iCallback);
    }

    public void a(com.haier.uhome.control.local.b.a aVar, final com.haier.uhome.usdk.base.api.s sVar) {
        StartDeviceBleOtaReq startDeviceBleOtaReq = new StartDeviceBleOtaReq();
        startDeviceBleOtaReq.setDevId(aVar.a());
        startDeviceBleOtaReq.setBleDevId(aVar.b());
        startDeviceBleOtaReq.setModule(com.haier.uhome.usdk.base.a.aq);
        startDeviceBleOtaReq.setSession(aVar.c());
        startDeviceBleOtaReq.setOtaFilePath(aVar.d());
        startDeviceBleOtaReq.setNativeSender(this.f31347b);
        startDeviceBleOtaReq.setProtocol(aVar.e());
        startDeviceBleOtaReq.setSecurityKey(aVar.f());
        startDeviceBleOtaReq.setKey(aVar.g());
        startDeviceBleOtaReq.setKeyAlg(com.haier.uhome.control.local.b.d.a(aVar.i()).b());
        startDeviceBleOtaReq.setKeyLen(aVar.h());
        startDeviceBleOtaReq.setToken(com.haier.uhome.usdk.base.service.e.a().g());
        startDeviceBleOtaReq.setIsOtaResume(aVar.j());
        startDeviceBleOtaReq.setElementAddr(aVar.k() > 0 ? String.valueOf(aVar.k()) : "");
        com.haier.uhome.usdk.base.d.a.a().a(startDeviceBleOtaReq, 60, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.local.e.i
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                a.b(sVar, basicResp);
            }
        });
    }

    public void a(String str, String str2, String str3, String str4, String str5, int i7, final ICallback<com.haier.uhome.control.local.b.c> iCallback) {
        GetBleOtaInfoReq getBleOtaInfoReq = new GetBleOtaInfoReq();
        getBleOtaInfoReq.setBleDevId(str2);
        getBleOtaInfoReq.setDevId(str);
        getBleOtaInfoReq.setSecurityKey(str4);
        getBleOtaInfoReq.setModule(com.haier.uhome.usdk.base.a.aq);
        getBleOtaInfoReq.setProtocol(str3);
        getBleOtaInfoReq.setTimeout(60);
        getBleOtaInfoReq.setToken(com.haier.uhome.usdk.base.service.e.a().g());
        getBleOtaInfoReq.setNativeSender(this.f31347b);
        getBleOtaInfoReq.setElementAddr(str5);
        getBleOtaInfoReq.setActiveConnect(i7);
        com.haier.uhome.usdk.base.d.a.a().a(getBleOtaInfoReq, 60, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.local.e.j
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                this.f29434a.a(iCallback, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ICallback iCallback, BasicResp basicResp) {
        uSDKError usdkerrorB = com.haier.uhome.usdk.base.utils.c.b(basicResp);
        if (usdkerrorB.a(ErrorConst.RET_USDK_OK)) {
            iCallback.onSuccess(a((GetBleOtaInfoResp) basicResp));
        } else {
            iCallback.onFailure(usdkerrorB);
        }
    }

    private com.haier.uhome.control.local.b.c a(GetBleOtaInfoResp getBleOtaInfoResp) {
        com.haier.uhome.control.local.b.c cVar = new com.haier.uhome.control.local.b.c();
        cVar.a(getBleOtaInfoResp.getDevId());
        cVar.c(getBleOtaInfoResp.getSession());
        cVar.a(getBleOtaInfoResp.getIsOtaActive());
        cVar.b(getBleOtaInfoResp.getIsOtaResume());
        cVar.b(getBleOtaInfoResp.getHwType());
        cVar.c(getBleOtaInfoResp.getHwVersion());
        cVar.d(getBleOtaInfoResp.getSwType());
        cVar.e(getBleOtaInfoResp.getSwVersion());
        cVar.h(getBleOtaInfoResp.getDevVers());
        cVar.g(getBleOtaInfoResp.getIsOtaAble());
        cVar.i(getBleOtaInfoResp.getMac());
        cVar.d(getBleOtaInfoResp.getModuleType());
        return cVar;
    }

    public void a(final String str, String str2, final int i7, final int i8) {
        a(str, str2, i7, i8, new com.haier.uhome.usdk.base.api.s() { // from class: com.haier.uhome.control.local.e.h
            @Override // com.haier.uhome.usdk.base.api.s
            public final void onCallback(uSDKError usdkerror) {
                a.a(str, i8, i7, usdkerror);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, int i7, int i8, uSDKError usdkerror) {
        if (uSDKError.RET_USDK_OK.getCode() != usdkerror.getCode()) {
            com.haier.uhome.control.cloud.a.h.a().b(str, i7, i8);
        }
    }

    public void a(String str, String str2, int i7, int i8, com.haier.uhome.usdk.base.api.s sVar) {
        com.haier.uhome.control.cloud.b.c.a(str, str2, i7, i8, sVar);
    }

    public void a(String str, final com.haier.uhome.usdk.base.api.s sVar) {
        EndDeviceBleOtaReq endDeviceBleOtaReq = new EndDeviceBleOtaReq();
        endDeviceBleOtaReq.setModule(com.haier.uhome.usdk.base.a.aq);
        endDeviceBleOtaReq.setToken(com.haier.uhome.usdk.base.service.e.a().g());
        endDeviceBleOtaReq.setDevId(str);
        endDeviceBleOtaReq.setNativeSender(this.f31347b);
        com.haier.uhome.usdk.base.d.a.a().a(endDeviceBleOtaReq, 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.control.local.e.k
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                a.a(sVar, basicResp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.haier.uhome.usdk.base.api.s sVar, BasicResp basicResp) {
        uSDKError usdkerrorA = com.haier.uhome.usdk.base.utils.c.a((EndDeviceBleOtaResp) basicResp);
        if (sVar != null) {
            sVar.onCallback(usdkerrorA);
        }
    }

    public <T> void a(Map<String, Object> map, m3.a<T> aVar) {
        com.haier.uhome.control.cloud.b.c.a(map, aVar);
    }
}
