package com.haier.uhome.usdk.api.a;

import com.haier.uhome.usdk.api.interfaces.IProgressCallback;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKDeviceManager;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class e extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private uSDKDevice f30384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<uSDKDevice> f30385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IProgressCallback<uSDKDevice, Void> f30386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkedList<a> f30387d = new LinkedList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicInteger f30388e = new AtomicInteger();

    private void k() {
        if (c()) {
            e3.a.v("Mesh group: Parallel task completed but already timeout!", new Object[0]);
            return;
        }
        if (this.f30388e.get() > 0) {
            this.f30386c.onComplete(null, uSDKError.RET_USDK_OK);
            uSDKDeviceManager.getSingleInstance().refreshDeviceList(null);
        } else {
            this.f30386c.onComplete(null, ErrorConst.ERR_INTERNAL.toError());
        }
        h();
    }

    public void a(uSDKDevice usdkdevice, List<uSDKDevice> list, int i7, IProgressCallback<uSDKDevice, Void> iProgressCallback) {
        if (usdkdevice == null || !usdkdevice.isGroup()) {
            iProgressCallback.onComplete(null, ErrorConst.ERR_USDK_IS_NOT_GROUP_DEVICE.toError());
            return;
        }
        if (i7 > 180 || i7 < 30) {
            iProgressCallback.onComplete(null, ErrorConst.ERR_USDK_INVALID_PARAM.toError());
            return;
        }
        if (com.haier.library.common.util.u.h(list)) {
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
            e3.a.v("Mesh group: current object occur parallel invoked!", new Object[0]);
            iProgressCallback.onComplete(null, ErrorConst.ERR_USDK_GROUP_IS_OPERATING.toError());
            return;
        }
        this.f30384a = usdkdevice;
        this.f30385b = list;
        this.f30386c = iProgressCallback;
        a(i7);
        i();
    }

    @Override // com.haier.uhome.usdk.api.a.c
    protected void h() {
        super.h();
        this.f30388e.set(0);
    }

    private void i() {
        int size = this.f30385b.size();
        final CountDownLatch countDownLatch = new CountDownLatch(size);
        com.haier.library.common.thread.m.execute(new Runnable() { // from class: com.haier.uhome.usdk.api.a.p
            @Override // java.lang.Runnable
            public final void run() {
                this.f30417a.a(countDownLatch);
            }
        }, 10L, TimeUnit.MILLISECONDS);
        for (int i7 = 0; i7 < size; i7++) {
            b bVar = new b(this.f30384a.getDeviceId(), this.f30384a.getChannel(), this.f30385b.get(i7));
            bVar.a(this.f30386c);
            bVar.a(this.f30384a.getElementAddr());
            bVar.a(new j() { // from class: com.haier.uhome.usdk.api.a.q
                @Override // com.haier.uhome.usdk.api.a.j
                public final void operateComplete(uSDKDevice usdkdevice, boolean z7) {
                    this.f30419a.a(usdkdevice, z7);
                }
            });
            bVar.a(countDownLatch);
            this.f30387d.addFirst(bVar);
            e3.a.e("Mesh group: add task %s", bVar);
        }
        j();
    }

    private void j() {
        if (this.f30387d.isEmpty()) {
            return;
        }
        com.haier.library.common.thread.m.execute(this.f30387d.removeLast());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(CountDownLatch countDownLatch) {
        try {
            e3.a.e("Mesh group: all latch result = %s", Boolean.valueOf(countDownLatch.await(e(), TimeUnit.MILLISECONDS)));
            k();
        } catch (InterruptedException e8) {
            e8.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(uSDKDevice usdkdevice, boolean z7) {
        e3.a.e("Mesh group: device: %s add group result: %s", usdkdevice.getDeviceId(), Boolean.valueOf(z7));
        if (c()) {
            e3.a.v("Mesh group: add group already timeout!", new Object[0]);
            return;
        }
        if (z7) {
            this.f30388e.incrementAndGet();
        }
        j();
    }

    @Override // com.haier.library.common.util.m
    protected void a() {
        e3.a.v("Mesh group: add group timeout!", new Object[0]);
        this.f30386c.onComplete(null, ErrorConst.ERR_USDK_TIMEOUT.toError());
        h();
    }
}
