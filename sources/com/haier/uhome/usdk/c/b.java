package com.haier.uhome.usdk.c;

import android.text.TextUtils;
import com.haier.uhome.usdk.api.uSDKErrorConst;
import com.haier.uhome.usdk.api.w;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class b implements ICallback<w> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f31972b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.haier.uhome.usdk.a.a f31975e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f31979i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicBoolean f31973c = new AtomicBoolean(false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicBoolean f31974d = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicBoolean f31976f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f31977g = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f31971a = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private uSDKError f31978h = uSDKErrorConst.ERR_USDK_TIMEOUT.toError();

    /* JADX INFO: renamed from: com.haier.uhome.usdk.c.b$1, reason: invalid class name */
    class AnonymousClass1 extends com.haier.uhome.usdk.a.a {
        AnonymousClass1(AtomicLong atomicLong, boolean z7) {
            super(atomicLong, z7);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            b.this.b(uSDKErrorConst.ERR_USDK_TIMEOUT.toError());
        }

        @Override // com.haier.uhome.usdk.a.a
        public void a() {
            com.haier.uhome.usdk.api.b.b.a().a(new Runnable() { // from class: com.haier.uhome.usdk.c.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f32067a.e();
                }
            }, 1500L);
            b.this.f31974d.set(true);
        }
    }

    public interface a {
        com.haier.uhome.usdk.bind.a.b a();

        void a(w wVar, uSDKError usdkerror);
    }

    public b(a aVar, String str, int i7, boolean z7) {
        this.f31972b = aVar;
        this.f31979i = str;
        a(i7, z7);
    }

    public void b() {
        this.f31976f.set(true);
    }

    public boolean c() {
        return this.f31974d.get();
    }

    public boolean d() {
        return this.f31972b != null;
    }

    public long e() {
        return this.f31975e.d();
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    public void onFailure(uSDKError usdkerror) {
        e3.a.e("BackConfigActuator onFailure error = %s", usdkerror.toString());
        b(usdkerror);
    }

    private uSDKError c(uSDKError usdkerror) {
        a aVar = this.f31972b;
        if (aVar == null) {
            return usdkerror;
        }
        com.haier.uhome.usdk.bind.a.b bVarA = aVar.a();
        if (bVarA == null) {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "Device config info not found!", new Object[0]);
            return usdkerror;
        }
        com.haier.uhome.usdk.bind.a.a aVarA = bVarA.a();
        uSDKError usdkerrorB = c.b(bVarA.b().getLastErr());
        if (usdkerrorB != null) {
            return usdkerrorB;
        }
        uSDKError usdkerrorA = c.a(aVarA);
        return usdkerrorA != null ? usdkerrorA : usdkerror;
    }

    protected void b(uSDKError usdkerror) {
        uSDKError error;
        if (this.f31979i == null) {
            return;
        }
        if (!usdkerror.a(uSDKErrorConst.ERR_USDK_TIMEOUT.toError())) {
            uSDKErrorConst usdkerrorconst = uSDKErrorConst.ERR_USDK_CONFIG_BE_CANCELED;
            if (!usdkerror.a(usdkerrorconst.toError())) {
                error = usdkerror;
            } else if (this.f31973c.get()) {
                error = !com.haier.library.common.util.w.h(com.haier.uhome.usdk.base.service.e.a().b()).contentEquals(this.f31979i) ? uSDKErrorConst.ERR_USDK_CONFIG_OK_BUT_NETWORK_NOT_SWITCH_TO_CONFIG_SSID.toError() : uSDKErrorConst.ERR_USDK_CONFIG_OK_BUT_NOT_FIND_DEVICE.toError();
            } else {
                error = usdkerrorconst.toError();
            }
        } else if (!this.f31973c.get()) {
            error = c(this.f31978h);
        } else if (this.f31971a) {
            c(this.f31978h);
            error = usdkerror;
        } else if (com.haier.library.common.util.w.h(com.haier.uhome.usdk.base.service.e.a().b()).equals(this.f31979i)) {
            error = this.f31976f.get() ? uSDKErrorConst.ERR_USDK_NOT_RECV_SOFTAP_ACK_AND_NOT_FIND_DEVICE.toError() : uSDKErrorConst.ERR_USDK_CONFIG_OK_BUT_NOT_FIND_DEVICE.toError();
        } else {
            error = this.f31976f.get() ? uSDKErrorConst.ERR_USDK_NOT_RECV_SOFTAP_ACK_AND_NOT_SWITCH_TO_CONFIGED_SSID.toError() : uSDKErrorConst.ERR_USDK_CONFIG_OK_BUT_NETWORK_NOT_SWITCH_TO_CONFIG_SSID.toError();
        }
        e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "adjusted error from %s to %s", usdkerror, error.toString());
        a((w) null, error);
    }

    public void a(boolean z7) {
        this.f31971a = z7;
    }

    private void a(int i7, boolean z7) {
        AtomicLong atomicLong = new AtomicLong(((long) (i7 * 1000)) + System.currentTimeMillis());
        this.f31974d.set(false);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(atomicLong, z7);
        anonymousClass1.b();
        this.f31975e = anonymousClass1;
    }

    public void a() {
        this.f31973c.set(true);
    }

    public void a(uSDKError usdkerror) {
        this.f31978h = usdkerror;
    }

    public void a(uSDKError usdkerror, w wVar) {
        a(wVar, usdkerror);
    }

    public void a(String str) {
        if (str == null) {
            e3.a.u(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "setDeviceId to BackConfigActuator with null", new Object[0]);
        } else {
            e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "set device id<%s> to BackConfigActuator", str);
            this.f31977g = str;
        }
    }

    private void a(final w wVar, final uSDKError usdkerror) {
        com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.c.j
            @Override // java.lang.Runnable
            public final void run() {
                this.f32064a.b(wVar, usdkerror);
            }
        });
    }

    @Override // com.haier.uhome.usdk.base.api.ICallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(w wVar) {
        b(wVar);
    }

    private void b(w wVar) {
        if (wVar == null || this.f31972b == null) {
            return;
        }
        if (TextUtils.isEmpty(this.f31977g)) {
            e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "device add to BackConfigActuator but it with a null device id", new Object[0]);
            return;
        }
        if (wVar.a().getDeviceId().toUpperCase().endsWith(this.f31977g.toUpperCase())) {
            a(uSDKErrorConst.RET_USDK_OK.toError(), wVar);
            e3.a.d(com.haier.uhome.config.a.E, com.haier.uhome.config.a.G, "soft ap config worked by device add deviceId=" + wVar.a().getDeviceId(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(w wVar, uSDKError usdkerror) {
        if (this.f31972b == null) {
            return;
        }
        com.haier.uhome.usdk.a.a aVar = this.f31975e;
        if (aVar != null) {
            aVar.c();
        }
        this.f31972b.a(wVar, usdkerror);
        this.f31972b = null;
    }
}
