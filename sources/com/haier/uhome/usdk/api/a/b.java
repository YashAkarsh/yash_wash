package com.haier.uhome.usdk.api.a;

import com.haier.uhome.control.local.json.req.AddDeviceToGroupReq;
import com.haier.uhome.control.local.json.req.RemoveDeviceFromGroupReq;
import com.haier.uhome.control.local.json.resp.AddDeviceToGroupResp;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceStatusConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f30373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f30374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f30375d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.haier.uhome.control.base.api.a f30376e;

    b(String str, int i7, uSDKDevice usdkdevice) {
        super(usdkdevice);
        this.f30372a = str;
        this.f30373b = i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BasicResp basicResp) {
        if (basicResp.getClass() == AddDeviceToGroupResp.class) {
            a(2, basicResp);
        }
    }

    private void e() {
        com.haier.uhome.usdk.base.d.f.a().a(a(this.f30376e.s().f(), 5), 5, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.usdk.api.a.n
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                this.f30415a.a(basicResp);
            }
        });
    }

    void a(int i7) {
        this.f30374c = i7;
    }

    @Override // com.haier.uhome.usdk.api.a.a
    protected void c() {
        uSDKDevice usdkdeviceD = d();
        if (usdkdeviceD.isGroup()) {
            throw new com.haier.uhome.usdk.base.b.a(ErrorConst.ERR_USDK_IS_NOT_GROUP_DEVICE.toError());
        }
        if (uSDKDeviceStatusConst.STATUS_CONNECTED != usdkdeviceD.getStatus() && uSDKDeviceStatusConst.STATUS_READY != usdkdeviceD.getStatus()) {
            throw new com.haier.uhome.usdk.base.b.a(ErrorConst.ERR_USDK_DEVICE_NOT_CONNECTED.toError());
        }
        try {
            this.f30376e = a.a(usdkdeviceD);
            e();
        } catch (com.haier.uhome.usdk.base.b.a unused) {
            this.f30375d = true;
            f();
        }
    }

    @Override // com.haier.uhome.usdk.api.a.a
    public String toString() {
        return String.format(Locale.ENGLISH, "%s(group address = %d, mesh address = %s, devId = %s)", super.toString(), Integer.valueOf(this.f30374c), Integer.valueOf(b()), d().getDeviceId());
    }

    private AddDeviceToGroupReq a(String str, int i7) {
        return a(new AddDeviceToGroupReq(), str, i7);
    }

    private void f() {
        for (com.haier.uhome.control.base.api.a aVar : d().sortByPriority()) {
            if (aVar instanceof com.haier.uhome.control.cloud.api.c) {
                this.f30376e = aVar;
            }
        }
        com.haier.uhome.usdk.base.d.f.a().a(a(com.haier.uhome.usdk.base.a.ao, 15), 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.usdk.api.a.m
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                this.f30414a.b(basicResp);
            }
        });
    }

    private void g() {
        this.f30376e = a.a(d());
        RemoveDeviceFromGroupReq removeDeviceFromGroupReq = new RemoveDeviceFromGroupReq();
        a(removeDeviceFromGroupReq, this.f30376e.s().f(), 5);
        com.haier.uhome.usdk.base.d.f.a().a(removeDeviceFromGroupReq, 5, null);
        a();
    }

    @k(a = 2)
    private void b(AddDeviceToGroupResp addDeviceToGroupResp) {
        uSDKError usdkerrorB = com.haier.uhome.usdk.base.utils.c.b(addDeviceToGroupResp);
        if (uSDKError.RET_USDK_OK.a(usdkerrorB)) {
            a(usdkerrorB);
            a(true);
            a();
        } else {
            a(usdkerrorB);
            a(false);
            if (!this.f30375d) {
                g();
            } else {
                a();
            }
        }
    }

    private AddDeviceToGroupReq a(AddDeviceToGroupReq addDeviceToGroupReq, String str, int i7) {
        addDeviceToGroupReq.setModule(str);
        addDeviceToGroupReq.setDevId(a.a(this.f30376e));
        addDeviceToGroupReq.setCloudOp(this.f30375d);
        addDeviceToGroupReq.setGroupDeviceId(this.f30372a);
        addDeviceToGroupReq.setTimeout(i7);
        if (com.haier.uhome.usdk.base.api.e.a(this.f30373b, 4)) {
            addDeviceToGroupReq.setGroupAddr(this.f30374c);
            addDeviceToGroupReq.setElementAddr(b());
        }
        com.haier.uhome.control.base.api.a aVar = this.f30376e;
        if (aVar instanceof com.haier.uhome.control.cloud.api.c) {
            addDeviceToGroupReq.setNativeSender(com.haier.uhome.control.cloud.service.b.a());
        } else {
            addDeviceToGroupReq.setNativeSender(com.haier.uhome.usdk.base.service.c.a());
        }
        if (aVar instanceof com.haier.uhome.control.local.api.h) {
            addDeviceToGroupReq.setGWSelf(true);
        }
        return addDeviceToGroupReq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BasicResp basicResp) {
        if (basicResp.getClass() == AddDeviceToGroupResp.class) {
            a((Object) basicResp);
        }
    }

    @k
    private void a(AddDeviceToGroupResp addDeviceToGroupResp) {
        this.f30375d = !com.haier.uhome.usdk.base.utils.c.a(addDeviceToGroupResp).a(ErrorConst.RET_USDK_OK);
        f();
    }
}
