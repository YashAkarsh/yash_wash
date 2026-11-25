package com.haier.uhome.usdk.api.a;

import com.haier.uhome.control.local.json.req.DelGroupReq;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.api.uSDKManager;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.haier.library.common.util.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private uSDKDevice f30396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ICallback<Void> f30397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f30398c = new AtomicBoolean();

    public void a(uSDKDevice usdkdevice, ICallback<Void> iCallback) {
        if (!uSDKManager.getSingleInstance().a()) {
            iCallback.onFailure(ErrorConst.ERR_USDK_UNSTARTED.toError());
            return;
        }
        if (usdkdevice == null || !usdkdevice.isGroup()) {
            iCallback.onFailure(ErrorConst.ERR_USDK_IS_NOT_GROUP_DEVICE.toError());
            return;
        }
        if (com.haier.uhome.control.cloud.service.c.l().n() != com.haier.uhome.control.cloud.api.b.CONNECTED) {
            iCallback.onFailure(ErrorConst.ERR_USDK_CLOUD_OFFLINE.toError());
            return;
        }
        if (b()) {
            iCallback.onFailure(ErrorConst.ERR_USDK_DEVICE_IS_BUSY.toError());
            return;
        }
        this.f30396a = usdkdevice;
        this.f30397b = iCallback;
        a(15L);
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        DelGroupReq delGroupReq = new DelGroupReq();
        delGroupReq.setDevId(this.f30396a.getDeviceId());
        delGroupReq.setModule(com.haier.uhome.usdk.base.a.ao);
        delGroupReq.setTimeout(5);
        delGroupReq.setNativeSender(com.haier.uhome.control.cloud.service.b.a());
        if (com.haier.uhome.usdk.base.api.e.a(this.f30396a.getChannel(), 4)) {
            delGroupReq.setGroupAddr(this.f30396a.getElementAddr());
        } else {
            delGroupReq.setGroupAddr(0);
        }
        com.haier.uhome.usdk.base.d.f.a().a(delGroupReq, 5, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.usdk.api.a.u
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                this.f30423a.a(basicResp);
            }
        });
    }

    private void g() {
        com.haier.uhome.control.base.api.a aVarA = a.a(this.f30396a);
        if (aVarA == null) {
            d();
            return;
        }
        DelGroupReq delGroupReq = new DelGroupReq();
        delGroupReq.setModule(aVarA.s().f());
        delGroupReq.setTimeout(5);
        delGroupReq.setNativeSender(com.haier.uhome.usdk.base.service.c.a());
        delGroupReq.setDevId(this.f30396a.getDeviceId());
        if (com.haier.uhome.usdk.base.api.e.a(this.f30396a.getChannel(), 4)) {
            delGroupReq.setGroupAddr(this.f30396a.getElementAddr());
        } else {
            delGroupReq.setGroupAddr(0);
        }
        com.haier.uhome.usdk.base.d.f.a().a(delGroupReq, 5, null);
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BasicResp basicResp) {
        if (c()) {
            return;
        }
        uSDKError usdkerrorB = com.haier.uhome.usdk.base.utils.c.b(basicResp);
        if (usdkerrorB.a(ErrorConst.ERR_USDK_TIMEOUT)) {
            this.f30398c.set(true);
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.api.a.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30422a.f();
                }
            }, 500L, TimeUnit.MILLISECONDS);
        } else {
            if (uSDKError.RET_USDK_OK.a(usdkerrorB)) {
                this.f30398c.set(false);
                uSDKDeviceManager.getSingleInstance().refreshDeviceList(null);
                this.f30397b.onSuccess(null);
                g();
                return;
            }
            this.f30398c.set(false);
            this.f30397b.onFailure(usdkerrorB);
            d();
        }
    }

    @Override // com.haier.library.common.util.m
    protected void a() {
        if (this.f30398c.get()) {
            this.f30397b.onFailure(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError());
        } else {
            this.f30397b.onFailure(ErrorConst.ERR_USDK_TIMEOUT.toError());
        }
    }
}
