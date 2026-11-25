package com.haier.uhome.usdk.api.a;

import com.haier.uhome.usdk.api.interfaces.IProgressCallback;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class i extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private uSDKDevice f30401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<uSDKDevice> f30402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IProgressCallback<uSDKDevice, Void> f30403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicInteger f30404d = new AtomicInteger();

    public void a(uSDKDevice usdkdevice, List<uSDKDevice> list, int i7, IProgressCallback<uSDKDevice, Void> iProgressCallback) {
        if (usdkdevice == null || !usdkdevice.isGroup()) {
            iProgressCallback.onComplete(null, ErrorConst.ERR_USDK_IS_NOT_GROUP_DEVICE.toError());
            return;
        }
        if (i7 > 180 || i7 < 30) {
            iProgressCallback.onComplete(null, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        if (list == null || list.isEmpty()) {
            iProgressCallback.onComplete(null, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        if (com.haier.uhome.control.cloud.service.c.l().n() != com.haier.uhome.control.cloud.api.b.CONNECTED) {
            iProgressCallback.onComplete(null, ErrorConst.ERR_USDK_CLOUD_OFFLINE.toError());
            return;
        }
        if (g()) {
            iProgressCallback.onComplete(null, ErrorConst.ERR_USDK_GROUP_IS_OPERATING.toError());
            return;
        }
        if (!f()) {
            iProgressCallback.onComplete(null, ErrorConst.ERR_USDK_GROUP_IS_OPERATING.toError());
            e3.a.v("Remove devices: current object occur parallel invoked!", new Object[0]);
            return;
        }
        this.f30401a = usdkdevice;
        this.f30402b = list;
        this.f30403c = iProgressCallback;
        a(i7);
        i();
    }

    @Override // com.haier.uhome.usdk.api.a.c
    protected void h() {
        super.h();
        this.f30404d.set(0);
    }

    private void i() {
        int size = this.f30402b.size();
        final CountDownLatch countDownLatch = new CountDownLatch(size);
        com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.api.a.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f30425a.a(countDownLatch);
            }
        }, 10L, TimeUnit.MILLISECONDS);
        for (int i7 = 0; i7 < size; i7++) {
            l lVar = new l(this.f30401a.getDeviceId(), this.f30401a.getChannel(), this.f30402b.get(i7));
            lVar.a(this.f30403c);
            lVar.a(this.f30401a.getElementAddr());
            lVar.a(new j() { // from class: com.haier.uhome.usdk.api.a.x
                @Override // com.haier.uhome.usdk.api.a.j
                public final void operateComplete(uSDKDevice usdkdevice, boolean z7) {
                    this.f30427a.a(usdkdevice, z7);
                }
            });
            lVar.a(countDownLatch);
            com.haier.library.common.thread.m.execute(lVar);
            e3.a.e("Mesh group: remove task %s", lVar);
        }
    }

    private void j() {
        if (c()) {
            e3.a.v("Remove devices: Parallel task completed but already timeout!", new Object[0]);
            return;
        }
        if (this.f30404d.get() > 0) {
            uSDKDeviceManager.getSingleInstance().refreshDeviceList(null);
            this.f30403c.onComplete(null, uSDKError.RET_USDK_OK);
        } else {
            this.f30403c.onComplete(null, ErrorConst.ERR_INTERNAL.toError());
        }
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(CountDownLatch countDownLatch) {
        try {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            countDownLatch.await(a(timeUnit), timeUnit);
            j();
        } catch (InterruptedException e8) {
            e8.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(uSDKDevice usdkdevice, boolean z7) {
        e3.a.e("Remove devices: device: %s remove from group result: %s", usdkdevice.getDeviceId(), Boolean.valueOf(z7));
        if (c()) {
            e3.a.v("Remove devices: device remove from group already timeout!", new Object[0]);
        } else if (z7) {
            this.f30404d.incrementAndGet();
        }
    }

    @Override // com.haier.library.common.util.m
    protected void a() {
        e3.a.v("Remove devices: remove from group timeout!", new Object[0]);
        this.f30403c.onComplete(null, ErrorConst.ERR_USDK_TIMEOUT.toError());
        h();
    }
}
