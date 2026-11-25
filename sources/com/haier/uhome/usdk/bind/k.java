package com.haier.uhome.usdk.bind;

import android.text.TextUtils;
import com.haier.uhome.nfc.service.NFCUtil;
import com.haier.uhome.nfc.service.entity.NFCInfo;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.api.uSDKManager;
import com.haier.uhome.usdk.api.uSDKState;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k extends com.haier.library.common.util.m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f31606d = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f31607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f31608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f31609c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected BaseBindInfo f31610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TraceNode f31611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f31612g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f31613h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.haier.uhome.control.cloud.a.a f31616k = new com.haier.uhome.control.cloud.a.a() { // from class: com.haier.uhome.usdk.bind.k.1
        @Override // com.haier.uhome.control.cloud.a.a, com.haier.uhome.control.cloud.a.p
        public void a(String str, String str2, String str3) {
            if (k.this.v() && com.haier.library.common.util.c.c(str2, k.this.f31608b)) {
                k.this.h();
            }
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f31614i = com.haier.uhome.usdk.base.utils.f.a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f31615j = -1;

    protected k(BaseBindInfo baseBindInfo) {
        this.f31610e = baseBindInfo;
        j();
    }

    private void j() {
        if (this.f31616k != null) {
            com.haier.uhome.control.cloud.a.h.a().a(this.f31616k);
        }
    }

    @Override // com.haier.library.common.util.m
    protected void a() {
    }

    protected abstract void a(uSDKError usdkerror);

    protected abstract void a(@c.m0 IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback);

    protected void b(String str) {
        if (this.f31615j == -1 && !TextUtils.isEmpty(str)) {
            com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(str);
            this.f31615j = fVarA != null ? fVarA.l() : 0L;
        }
    }

    public void c(String str) {
        this.f31609c = str;
    }

    @Deprecated
    protected void d(IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        throw new IllegalStateException("not impl");
    }

    @Override // com.haier.library.common.util.m
    protected long e() {
        return this.f31607a - System.currentTimeMillis();
    }

    protected uSDKError g() {
        return ErrorConst.RET_USDK_OK.toError();
    }

    protected abstract void h();

    protected abstract void i();

    public long m() {
        return this.f31614i;
    }

    public void p() {
        if (this.f31616k != null) {
            com.haier.uhome.control.cloud.a.h.a().b(this.f31616k);
        }
    }

    protected long q() {
        return this.f31615j;
    }

    public String r() {
        return this.f31608b;
    }

    public String s() {
        return this.f31609c;
    }

    public String t() {
        TraceNode traceNode = this.f31611f;
        return traceNode == null ? "" : traceNode.getTraceId();
    }

    public TraceNode u() {
        return this.f31611f;
    }

    public boolean v() {
        return this.f31612g;
    }

    public boolean w() {
        return this.f31613h;
    }

    protected long x() {
        return this.f31607a;
    }

    static boolean d(String str) {
        return !TextUtils.isEmpty(str) && (str.length() > 64 || str.length() < 8);
    }

    protected void a(int i7) {
    }

    public void c(@c.m0 final IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        this.f31607a = ((long) (this.f31610e.getTimeout() * 1000)) + System.currentTimeMillis();
        e3.a.e("begin bind with %s", getClass().getSimpleName());
        i();
        if (!f()) {
            ErrorConst errorConst = ErrorConst.ERR_USDK_DEVICE_IS_IN_BINDING;
            a(errorConst.toError());
            a(iBindCallback, errorConst.toError());
        } else {
            if (uSDKState.STATE_STARTED != uSDKManager.getSingleInstance().getSDKState()) {
                uSDKError error = ErrorConst.ERR_USDK_UNSTARTED.toError();
                a(error);
                a(iBindCallback, error);
                a(error.getCode());
                return;
            }
            uSDKError usdkerrorG = g();
            if (usdkerrorG.a(ErrorConst.RET_USDK_OK)) {
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                a(new IBindCallback<com.haier.uhome.usdk.api.w>() { // from class: com.haier.uhome.usdk.bind.k.2
                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(com.haier.uhome.usdk.api.w wVar) {
                        if (!atomicBoolean.compareAndSet(false, true)) {
                            e3.a.v("Multiple binding results were generated so need check code", new Object[0]);
                            return;
                        }
                        k kVar = k.this;
                        kVar.a(kVar.f31610e, wVar);
                        iBindCallback.onSuccess(wVar);
                        uSDKError error2 = ErrorConst.RET_USDK_OK.toError();
                        HashMap<String, String> map = new HashMap<>(1);
                        map.put(TraceProtocolConst.PRO_PROTOCOL, wVar.b());
                        error2.a(map);
                        k.this.a(error2);
                        k.this.p();
                        k.this.a(0);
                    }

                    @Override // com.haier.uhome.usdk.bind.IBindResultCallback
                    public void notifyProgress(BindProgress bindProgress, String str, String str2) {
                        iBindCallback.notifyProgress(bindProgress, str, str2);
                    }

                    @Override // com.haier.uhome.usdk.base.api.ICallback
                    public void onFailure(uSDKError usdkerror) {
                        if (atomicBoolean.compareAndSet(false, true)) {
                            iBindCallback.onFailure(usdkerror);
                            k.this.a(usdkerror);
                            k.this.p();
                            k.this.a(usdkerror.getCode());
                            return;
                        }
                        e3.a.v("Multiple binding results were generated so need check code,this failure =" + usdkerror, new Object[0]);
                    }

                    @Override // com.haier.uhome.usdk.bind.IBindCallback, com.haier.uhome.usdk.bind.ISoftApResultCallback
                    public void switchNetworkNotify() {
                        iBindCallback.switchNetworkNotify();
                    }
                });
            } else {
                a(usdkerrorG);
                a(iBindCallback, usdkerrorG);
                a(usdkerrorG.getCode());
            }
        }
    }

    @Deprecated
    protected void e(IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        throw new IllegalStateException("not impl");
    }

    protected boolean f() {
        return true;
    }

    protected void a(String str, String str2) {
        this.f31608b = str;
        this.f31609c = str2;
    }

    public void b(boolean z7) {
        this.f31613h = z7;
    }

    public void b(long j7) {
        this.f31614i = j7;
    }

    public void a(TraceNode traceNode) {
        this.f31611f = traceNode;
    }

    public void b(IBindCallback<com.haier.uhome.usdk.api.w> iBindCallback) {
        throw new IllegalStateException("not impl");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(IBindResultCallback iBindResultCallback, BindProgress bindProgress) {
        iBindResultCallback.notifyProgress(bindProgress, this.f31608b, this.f31609c);
    }

    public void a(boolean z7) {
        this.f31612g = z7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(BaseBindInfo baseBindInfo, com.haier.uhome.usdk.api.w wVar) {
        if (baseBindInfo == null || baseBindInfo.getNFCInfo() == null) {
            e3.a.e("updateNFC return with param bindInfo or NFCInfo is null!", new Object[0]);
            return;
        }
        if (wVar == null) {
            e3.a.e("updateNFC error with param uSDKDeviceWrapper is null!", new Object[0]);
            return;
        }
        uSDKDevice usdkdeviceA = wVar.a();
        if (usdkdeviceA == null) {
            e3.a.e("updateNFC error with param uSDKDevice is null!", new Object[0]);
            return;
        }
        String deviceId = usdkdeviceA.getDeviceId();
        if (TextUtils.isEmpty(deviceId)) {
            e3.a.e("updateNFC error with param deviceId is empty!", new Object[0]);
            return;
        }
        NFCInfo nFCInfo = baseBindInfo.getNFCInfo();
        nFCInfo.setDeviceID(deviceId);
        nFCInfo.setMAC(deviceId);
        NFCUtil.updateNFCDeviceInfo(nFCInfo, new ICallback<Void>() { // from class: com.haier.uhome.usdk.bind.k.3
            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                e3.a.e("updateNFC success", new Object[0]);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                e3.a.e("updateNFC error with " + usdkerror.toString(), new Object[0]);
            }
        });
    }

    protected void c(long j7) {
        this.f31607a = j7;
    }

    protected void a(com.haier.uhome.usdk.api.w wVar, ICallback<com.haier.uhome.usdk.api.w> iCallback) {
        throw new IllegalStateException("not impl");
    }

    protected void a(ICallback<com.haier.uhome.usdk.api.w> iCallback, uSDKError usdkerror) {
        if (iCallback == null) {
            e3.a.o(String.format("bindDevice error = %s ,but callback is null", usdkerror), new Object[0]);
        } else {
            com.haier.uhome.usdk.base.utils.b.a((ICallback) iCallback, usdkerror);
        }
    }

    protected void a(final IBindResultCallback<com.haier.uhome.usdk.api.w> iBindResultCallback, final BindProgress bindProgress) {
        if (iBindResultCallback == null) {
            e3.a.v("notifyProgress with null callback！", new Object[0]);
        } else {
            com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.bind.y0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f31920a.b(iBindResultCallback, bindProgress);
                }
            });
        }
    }
}
