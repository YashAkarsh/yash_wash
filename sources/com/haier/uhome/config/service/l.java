package com.haier.uhome.config.service;

import android.content.Context;
import com.haier.uhome.config.entity.ConfigRouterInfo;
import com.haier.uhome.config.json.ConfigProtocol;
import com.haier.uhome.config.json.req.DeviceGetWifiInfoReq;
import com.haier.uhome.config.json.resp.DeviceGetWifiInfoResp;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class l extends com.haier.library.common.util.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f28648a = 10;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f28649b = 180;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f28650c = -23020;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f28651d = -23003;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f28652e = -23302;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f28653f = -23303;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile ICallback<ConfigRouterInfo> f28654g;

    static {
        ConfigProtocol.registerPasswordAutoFilling();
    }

    public void a(int i7, ICallback<ConfigRouterInfo> iCallback) {
        if (i7 < 10 || i7 > 180) {
            com.haier.uhome.usdk.base.utils.b.b((ICallback) iCallback, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        this.f28654g = iCallback;
        a(i7, TimeUnit.SECONDS);
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        DeviceGetWifiInfoReq deviceGetWifiInfoReq = new DeviceGetWifiInfoReq();
        deviceGetWifiInfoReq.setModule("local");
        deviceGetWifiInfoReq.setTimeout(15);
        deviceGetWifiInfoReq.setNativeSender(com.haier.uhome.usdk.base.service.c.a());
        com.haier.uhome.usdk.base.d.f.a().a(deviceGetWifiInfoReq, 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.config.service.p0
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                this.f28677a.a(basicResp);
            }
        });
    }

    private void g() {
        if (c()) {
            e3.a.v("Lan: already timeout!", new Object[0]);
        } else {
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.config.service.q0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f28679a.f();
                }
            }, 1L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(BasicResp basicResp) {
        uSDKError usdkerrorA = com.haier.uhome.usdk.base.utils.c.a(basicResp);
        if (uSDKError.RET_USDK_OK.a(usdkerrorA)) {
            a((DeviceGetWifiInfoResp) basicResp);
            return;
        }
        if (usdkerrorA.a(ErrorConst.ERR_USDK_TIMEOUT)) {
            g();
            return;
        }
        if (usdkerrorA.getCode() == f28651d) {
            a(ErrorConst.ERR_USDK_NOT_SUPPORT_GET_ROUTER_INFO);
            return;
        }
        if (usdkerrorA.getCode() == f28650c) {
            a(ErrorConst.ERR_USDK_GET_ROUTER_INFO_FAIL);
        } else if (usdkerrorA.getCode() == f28653f) {
            a(ErrorConst.ERR_USDK_GET_ROUTER_INFO_FAIL);
        } else if (usdkerrorA.getCode() == f28652e) {
            a(ErrorConst.ERR_USDK_GET_ROUTER_INFO_TIMEOUT);
        }
    }

    private void a(DeviceGetWifiInfoResp deviceGetWifiInfoResp) {
        Context contextB = com.haier.uhome.usdk.base.service.e.a().b();
        String strH = com.haier.library.common.util.w.h(contextB);
        String strJ = com.haier.library.common.util.w.j(contextB);
        e3.a.d("Lan native ssid = %s, bssid = %s", strH, strJ, new Object[0]);
        if (com.haier.library.common.util.c.c(com.haier.library.common.util.w.f26618d, strH) && com.haier.library.common.util.c.m(strJ)) {
            a(deviceGetWifiInfoResp, true);
        } else {
            a(deviceGetWifiInfoResp, (com.haier.library.common.util.c.c(strH, deviceGetWifiInfoResp.getSsid()) && com.haier.library.common.util.c.c(strJ, deviceGetWifiInfoResp.getBssid())) ? false : true);
        }
    }

    private void a(DeviceGetWifiInfoResp deviceGetWifiInfoResp, boolean z7) {
        this.f28654g.onSuccess(new ConfigRouterInfo(deviceGetWifiInfoResp.getSsid(), deviceGetWifiInfoResp.getBssid(), deviceGetWifiInfoResp.getPassword(), z7));
        d();
    }

    private void a(ErrorConst errorConst) {
        com.haier.uhome.usdk.base.utils.b.b((ICallback) this.f28654g, errorConst.toError());
        d();
    }

    @Override // com.haier.library.common.util.m
    protected void a() {
        a(ErrorConst.ERR_USDK_GET_ROUTER_INFO_TIMEOUT);
    }
}
