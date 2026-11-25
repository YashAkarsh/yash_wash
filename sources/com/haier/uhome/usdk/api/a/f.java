package com.haier.uhome.usdk.api.a;

import com.haier.uhome.control.local.json.req.CreateGroupReq;
import com.haier.uhome.control.local.json.resp.CreateGroupResp;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.api.uSDKDeviceNetTypeConst;
import com.haier.uhome.usdk.api.uSDKManager;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class f extends c implements ICallback<uSDKDevice> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private uSDKDevice f30389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ICallback<uSDKDevice> f30390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f30391c;

    static class a extends com.haier.uhome.control.cloud.a.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f30393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f30394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final WeakReference<f> f30395c;

        a(String str, f fVar) {
            this.f30393a = str;
            this.f30395c = new WeakReference<>(fVar);
        }

        private void c(String str) {
            f fVar = this.f30395c.get();
            if (fVar == null) {
                e3.a.v("create group: create handler has been released!", new Object[0]);
            } else if (this.f30393a.equals(str)) {
                synchronized (this) {
                    if (!this.f30394b) {
                        this.f30394b = true;
                        fVar.a(str);
                    }
                }
            }
        }

        @Override // com.haier.uhome.control.cloud.a.a, com.haier.uhome.control.cloud.a.p
        public void a(String str, String str2, String str3) {
        }

        @Override // com.haier.uhome.control.cloud.a.a, com.haier.uhome.control.cloud.a.p
        public void a(String str, int i7, boolean z7, String str2) {
            c(str);
        }

        @Override // com.haier.uhome.control.cloud.a.a, com.haier.uhome.control.cloud.a.p
        public void a(String str, int i7, String str2, int i8) {
            c(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        CreateGroupReq createGroupReq = new CreateGroupReq();
        createGroupReq.setBaseDeviceId(this.f30389a.getDeviceId());
        createGroupReq.setTimeout(15);
        createGroupReq.setNativeSender(com.haier.uhome.control.cloud.service.b.a());
        com.haier.uhome.usdk.base.d.f.a().a(createGroupReq, 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.usdk.api.a.s
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                this.f30421a.a(basicResp);
            }
        });
    }

    private void l() {
        com.haier.uhome.control.cloud.a.h.a().b(this.f30391c);
        com.haier.uhome.usdk.c.f.a().a(this.f30389a.getDeviceId());
        this.f30391c = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.haier.library.common.util.m
    public void d() {
        super.d();
        l();
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    public void onFailure(uSDKError usdkerror) {
        if (c()) {
            e3.a.v("create group: find group device has already timeout!", new Object[0]);
        } else {
            this.f30390b.onFailure(usdkerror);
            h();
        }
    }

    private void i() {
        new com.haier.uhome.usdk.base.utils.e.a<Void>(com.haier.uhome.usdk.base.utils.e.k(), 6000L) { // from class: com.haier.uhome.usdk.api.a.f.1
            @Override // com.haier.uhome.usdk.base.utils.e
            /* JADX INFO: renamed from: a */
            public void d(com.haier.uhome.usdk.base.api.c<Void> cVar) {
            }

            @Override // com.haier.uhome.usdk.base.utils.e
            public void a(long j7) {
                if (!f.this.g()) {
                    e();
                } else if (f.this.c()) {
                    e();
                } else {
                    f.this.j();
                    l();
                }
            }
        }.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        uSDKDeviceManager.getSingleInstance().e().a(this.f30389a.getDeviceId(), (com.haier.uhome.usdk.base.api.o) null);
    }

    public void a(uSDKDevice usdkdevice, int i7, ICallback<uSDKDevice> iCallback) {
        if (!uSDKManager.getSingleInstance().a()) {
            iCallback.onFailure(ErrorConst.ERR_USDK_UNSTARTED.toError());
            return;
        }
        if (usdkdevice == null) {
            iCallback.onFailure(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        if (!usdkdevice.isBound()) {
            iCallback.onFailure(ErrorConst.ERR_USDK_DEVICE_IS_NOT_BOUND.toError());
            return;
        }
        if (usdkdevice.isGroup()) {
            iCallback.onFailure(ErrorConst.ERR_USDK_GROUP_DEVICE_CAN_NOT_CREATE_GROUP.toError());
            return;
        }
        int channel = usdkdevice.getChannel();
        if (!com.haier.uhome.usdk.base.api.e.a(channel, 4) && !com.haier.uhome.usdk.base.api.e.a(channel, 16)) {
            iCallback.onFailure(ErrorConst.ERR_USDK_DEVICE_NOT_SUPPORT_GROUP.toError());
            return;
        }
        if (i7 <= 180 && i7 >= 30) {
            if (com.haier.uhome.control.cloud.service.c.l().n() != com.haier.uhome.control.cloud.api.b.CONNECTED) {
                iCallback.onFailure(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError());
                return;
            }
            if (g()) {
                iCallback.onFailure(ErrorConst.ERR_USDK_GROUP_IS_OPERATING.toError());
                return;
            }
            if (f()) {
                this.f30389a = usdkdevice;
                this.f30390b = iCallback;
                a(i7);
                i();
                k();
                return;
            }
            e3.a.v("create group: current object occur parallel invoked!", new Object[0]);
            iCallback.onFailure(ErrorConst.ERR_USDK_GROUP_IS_OPERATING.toError());
            return;
        }
        iCallback.onFailure(ErrorConst.ERR_USDK_INVALID_PARAM.toError());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BasicResp basicResp) {
        if (c()) {
            e3.a.v("Mesh create group: the result has already timeout", new Object[0]);
            return;
        }
        uSDKError usdkerrorB = com.haier.uhome.usdk.base.utils.c.b(basicResp);
        if (uSDKError.RET_USDK_OK.a(usdkerrorB)) {
            CreateGroupResp createGroupResp = (CreateGroupResp) basicResp;
            uSDKDevice device = uSDKDeviceManager.getSingleInstance().getDevice(createGroupResp.getDevId());
            if (device != null && device.isGroup()) {
                onSuccess(device);
                return;
            }
            a aVar = new a(createGroupResp.getDevId(), this);
            com.haier.uhome.control.cloud.a.h.a().a(aVar);
            uSDKDeviceManager.getSingleInstance().refreshDeviceList(null);
            this.f30391c = aVar;
            return;
        }
        if (usdkerrorB.a(ErrorConst.ERR_USDK_TIMEOUT)) {
            com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.api.a.r
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30420a.k();
                }
            }, 100L, TimeUnit.MILLISECONDS);
        } else {
            this.f30390b.onFailure(usdkerrorB);
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (c()) {
            e3.a.v("create group: found group has already timeout!", new Object[0]);
            return;
        }
        uSDKDevice device = uSDKDeviceManager.getSingleInstance().getDevice(str);
        if (device != null) {
            onSuccess(device);
        } else {
            e3.a.e("create group: group device not found use NewDeviceFind case!", new Object[0]);
            com.haier.uhome.usdk.c.f.a().a(str, a(TimeUnit.MILLISECONDS), uSDKDeviceNetTypeConst.NET_REMOTE, this);
        }
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(uSDKDevice usdkdevice) {
        if (c()) {
            e3.a.v("create group: find group device has already timeout!", new Object[0]);
        } else {
            this.f30390b.onSuccess(usdkdevice);
            h();
        }
    }

    @Override // com.haier.library.common.util.m
    protected void a() {
        if (this.f30391c == null) {
            this.f30390b.onFailure(ErrorConst.ERR_USDK_CLOUD_COMMON_ERROR.toError());
        } else {
            this.f30390b.onFailure(ErrorConst.ERR_USDK_TIMEOUT.toError());
        }
        l();
    }
}
