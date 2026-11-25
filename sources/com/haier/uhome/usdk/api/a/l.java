package com.haier.uhome.usdk.api.a;

import com.haier.uhome.control.local.json.req.RemoveDeviceFromGroupReq;
import com.haier.uhome.control.local.json.resp.RemoveDeviceFromGroupResp;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.base.json.BasicResp;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class l extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f30409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f30410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f30411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f30412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.haier.uhome.control.base.api.a f30413e;

    l(String str, int i7, uSDKDevice usdkdevice) {
        super(usdkdevice);
        this.f30409a = str;
        this.f30410b = i7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(BasicResp basicResp) {
        if (basicResp.getClass() == RemoveDeviceFromGroupResp.class) {
            a(2, basicResp);
        }
    }

    private void e() {
        com.haier.uhome.usdk.base.d.f.a().a(a(this.f30413e.s().f(), 5), 5, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.usdk.api.a.z
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                this.f30429a.a(basicResp);
            }
        });
    }

    void a(int i7) {
        this.f30411c = i7;
    }

    @Override // com.haier.uhome.usdk.api.a.a
    protected void c() {
        try {
            this.f30413e = a.a(d());
            e();
        } catch (com.haier.uhome.usdk.base.b.a unused) {
            this.f30412d = true;
            f();
        }
    }

    @Override // com.haier.uhome.usdk.api.a.a
    public String toString() {
        return String.format(Locale.ENGLISH, "%s(group address = %d, mesh address = %s)", super.toString(), Integer.valueOf(this.f30411c), Integer.valueOf(b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BasicResp basicResp) {
        if (basicResp.getClass() == RemoveDeviceFromGroupResp.class) {
            a((Object) basicResp);
        }
    }

    private void f() {
        for (com.haier.uhome.control.base.api.a aVar : d().sortByPriority()) {
            if (aVar instanceof com.haier.uhome.control.cloud.api.c) {
                this.f30413e = aVar;
            }
        }
        com.haier.uhome.usdk.base.d.f.a().a(a(com.haier.uhome.usdk.base.a.ao, 15), 15, new com.haier.uhome.usdk.base.api.l() { // from class: com.haier.uhome.usdk.api.a.y
            @Override // com.haier.uhome.usdk.base.api.l
            public final void onResp(BasicResp basicResp) {
                this.f30428a.b(basicResp);
            }
        });
    }

    @k(a = 2)
    private void b(RemoveDeviceFromGroupResp removeDeviceFromGroupResp) {
        uSDKError usdkerrorB = com.haier.uhome.usdk.base.utils.c.b(removeDeviceFromGroupResp);
        if (usdkerrorB.a(ErrorConst.RET_USDK_OK)) {
            a(usdkerrorB);
            a(true);
        } else {
            if (!this.f30412d) {
                a(usdkerrorB);
            } else {
                a(ErrorConst.ERR_USDK_REMOVE_DEVICE_CLOUD_FAIL.toError());
            }
            a(false);
        }
        a();
    }

    @k
    private void a(RemoveDeviceFromGroupResp removeDeviceFromGroupResp) {
        this.f30412d = !com.haier.uhome.usdk.base.utils.c.a(removeDeviceFromGroupResp).a(ErrorConst.RET_USDK_OK);
        f();
    }

    private RemoveDeviceFromGroupReq a(String str, int i7) {
        return a(new RemoveDeviceFromGroupReq(), str, i7);
    }

    private RemoveDeviceFromGroupReq a(RemoveDeviceFromGroupReq removeDeviceFromGroupReq, String str, int i7) {
        removeDeviceFromGroupReq.setModule(str);
        removeDeviceFromGroupReq.setDevId(a.a(this.f30413e));
        removeDeviceFromGroupReq.setCloudOp(this.f30412d);
        removeDeviceFromGroupReq.setGroupDeviceId(this.f30409a);
        removeDeviceFromGroupReq.setTimeout(i7);
        if (com.haier.uhome.usdk.base.api.e.a(this.f30410b, 4)) {
            removeDeviceFromGroupReq.setGroupAddr(this.f30411c);
            removeDeviceFromGroupReq.setElementAddr(b());
        }
        com.haier.uhome.control.base.api.a aVar = this.f30413e;
        if (aVar instanceof com.haier.uhome.control.cloud.api.c) {
            removeDeviceFromGroupReq.setNativeSender(com.haier.uhome.control.cloud.service.b.a());
        } else {
            removeDeviceFromGroupReq.setNativeSender(com.haier.uhome.usdk.base.service.c.a());
        }
        if (aVar instanceof com.haier.uhome.control.local.api.h) {
            removeDeviceFromGroupReq.setGWSelf(true);
        }
        return removeDeviceFromGroupReq;
    }
}
