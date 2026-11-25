package com.haier.uhome.usdk.bind;

import android.text.TextUtils;
import com.haier.uhome.usdk.api.uSDKDevice;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.scanner.ConfigType;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class b extends com.haier.uhome.usdk.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f31493a = 22000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f31494b = 30;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f31495c = "AutoBindImpl:";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SmartLinkBindInfo f31496d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private IAutoBindCallback<uSDKDevice> f31497e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicBoolean f31498f;

    class a<R> extends com.haier.uhome.usdk.c.d<R> implements IAutoBindCallback<R> {
        public a(IAutoBindCallback<R> iAutoBindCallback) {
            super(iAutoBindCallback);
        }

        @Override // com.haier.uhome.usdk.bind.IBindResultCallback
        public void notifyProgress(final BindProgress bindProgress, final String str, final String str2) {
            final IAutoBindCallback iAutoBindCallback = (IAutoBindCallback) this.f31996b;
            if (iAutoBindCallback != null) {
                com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.bind.l0
                    @Override // java.lang.Runnable
                    public final void run() {
                        iAutoBindCallback.notifyProgress(bindProgress, str, str2);
                    }
                });
            }
        }

        @Override // com.haier.uhome.usdk.bind.IBindCallback, com.haier.uhome.usdk.bind.ISoftApResultCallback
        public void switchNetworkNotify() {
            final IAutoBindCallback iAutoBindCallback = (IAutoBindCallback) this.f31996b;
            if (iAutoBindCallback != null) {
                com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.bind.k0
                    @Override // java.lang.Runnable
                    public final void run() {
                        iAutoBindCallback.switchNetworkNotify();
                    }
                });
            }
        }

        @Override // com.haier.uhome.usdk.bind.IAutoBindCallback
        public void switchToSoftApRequest(final String str) {
            final IAutoBindCallback iAutoBindCallback = (IAutoBindCallback) this.f31996b;
            if (iAutoBindCallback != null) {
                com.haier.library.common.thread.a.b().c(new Runnable() { // from class: com.haier.uhome.usdk.bind.j0
                    @Override // java.lang.Runnable
                    public final void run() {
                        iAutoBindCallback.switchToSoftApRequest(str);
                    }
                });
            }
        }
    }

    private b(@c.m0 SmartLinkBindInfo smartLinkBindInfo, IAutoBindCallback<uSDKDevice> iAutoBindCallback) {
        super(new AtomicLong(((long) (smartLinkBindInfo.getTimeout() * 1000)) + System.currentTimeMillis()), false);
        this.f31496d = smartLinkBindInfo;
        this.f31497e = new a(iAutoBindCallback);
        this.f31498f = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.haier.uhome.search.a.c cVar) {
        final String strH = cVar.H();
        a("auto connect2SoftAp<%s> start", strH);
        new com.haier.library.common.util.a.b.C0351b(com.haier.uhome.usdk.base.service.e.a().b()).c(strH).a(new com.haier.library.common.util.a.b.c() { // from class: com.haier.uhome.usdk.bind.i0
            @Override // com.haier.library.common.util.a.b.c
            public final void a(boolean z7) {
                this.f31589a.a(strH, z7);
            }
        }).d().b(30);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f31498f.compareAndSet(true, false)) {
            com.haier.uhome.search.service.k.c().a(new ICallback<Void>() { // from class: com.haier.uhome.usdk.bind.b.1
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                    b.this.a("stopSoftAp success", new Object[0]);
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    b.this.a("stopSoftAp failure", new Object[0]);
                }
            });
        }
    }

    private boolean h() {
        return (TextUtils.isEmpty(this.f31496d.getAppTypeCode()) || TextUtils.isEmpty(this.f31496d.getProductCode())) ? false : true;
    }

    private void b(@c.m0 final ICallback<Void> iCallback) {
        this.f31498f.set(true);
        com.haier.uhome.search.service.k.c().a(new com.haier.uhome.search.a.j<Void>() { // from class: com.haier.uhome.usdk.bind.b.2
            @Override // com.haier.uhome.search.a.j
            public void a(int i7) {
                iCallback.onFailure(ErrorConst.ERR_INTERNAL.toError());
            }

            @Override // com.haier.uhome.search.a.j
            public void b(int i7) {
                iCallback.onFailure(ErrorConst.ERR_INTERNAL.toError());
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            public void onFailure(uSDKError usdkerror) {
                iCallback.onFailure(usdkerror);
            }

            @Override // com.haier.uhome.usdk.base.api.ICallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(Void r7) {
                iCallback.onSuccess(null);
            }
        });
    }

    private void c(com.haier.uhome.search.a.c cVar) {
        if (cVar == null) {
            return;
        }
        a("configurable device<%s> productCode:%s appTypeCode:%s", cVar.a(), a(cVar) + "", b(cVar));
    }

    private List<com.haier.uhome.search.a.c> f() {
        try {
            return com.haier.library.common.util.u.b(com.haier.uhome.search.a.l.a().c(), new com.haier.library.common.util.u.c() { // from class: com.haier.uhome.usdk.bind.h0
                @Override // com.haier.library.common.util.u.c
                public final boolean a(Object obj) {
                    return b.e((com.haier.uhome.search.a.c) obj);
                }
            });
        } catch (IllegalArgumentException e8) {
            e8.printStackTrace();
            return Collections.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.haier.uhome.search.a.c g() {
        List<com.haier.uhome.search.a.c> listF = f();
        com.haier.uhome.search.a.c cVar = null;
        if (com.haier.library.common.util.u.h(listF)) {
            a("no softAp find no so match fail once", new Object[0]);
            return null;
        }
        for (com.haier.uhome.search.a.c cVar2 : listF) {
            c(cVar2);
            String strA = a(cVar2);
            if (!TextUtils.isEmpty(strA) && com.haier.library.common.util.c.c(strA, this.f31496d.getProductCode())) {
                a("%s match with productCode<%s> success", cVar2.a(), this.f31496d.getProductCode());
                cVar = cVar2;
                break;
            }
        }
        if (cVar != null) {
            return cVar;
        }
        a("match with productCode<%s> fail", this.f31496d.getProductCode());
        for (com.haier.uhome.search.a.c cVar3 : listF) {
            String strB = b(cVar3);
            if (!TextUtils.isEmpty(strB) && com.haier.library.common.util.c.c(strB, this.f31496d.getAppTypeCode())) {
                a("match with appTypeCode<%s> success", this.f31496d.getAppTypeCode());
                cVar = cVar3;
                break;
            }
        }
        if (cVar == null) {
            a("match with appTypeCode<%s> fail", this.f31496d.getAppTypeCode());
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean e(com.haier.uhome.search.a.c cVar) {
        return (cVar.i() & ConfigType.SOFT_AP.getMask()) != 0;
    }

    private String b(com.haier.uhome.search.a.c cVar) {
        if (cVar == null) {
            return null;
        }
        return cVar.E();
    }

    static b a(SmartLinkBindInfo smartLinkBindInfo, IAutoBindCallback<uSDKDevice> iAutoBindCallback) {
        if (smartLinkBindInfo == null) {
            return null;
        }
        return new b(smartLinkBindInfo, iAutoBindCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(String str) {
        a("beginSoftAp start", new Object[0]);
        Binding.getSingleInstance().bindDeviceBySoftAp(((SoftApBindInfo.Builder) ((SoftApBindInfo.Builder) new SoftApBindInfo.Builder().routerInfo(this.f31496d.getSsid(), this.f31496d.getBssid(), this.f31496d.getPassword()).timeout((int) (d() / 1000))).csNode(this.f31496d.getAppCsNode())).timerValidInBackground(false).iotDeviceSSID(str).security(true).build(), this.f31497e);
    }

    private String a(com.haier.uhome.search.a.c cVar) {
        return cVar.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@c.m0 final ICallback<Void> iCallback) {
        a("retryMatchSoftAp start", new Object[0]);
        new com.haier.uhome.usdk.base.utils.e<com.haier.uhome.search.a.c>(f31493a, 1000L) { // from class: com.haier.uhome.usdk.bind.b.3
            @Override // com.haier.uhome.usdk.base.utils.e
            public void a(long j7) {
                com.haier.uhome.usdk.base.api.c cVar = new com.haier.uhome.usdk.base.api.c(ErrorConst.ERR_INTERNAL.toError());
                com.haier.uhome.search.a.c cVarG = b.this.g();
                if (cVarG != null) {
                    cVar.a(cVarG);
                    cVar.a(ErrorConst.RET_USDK_OK.toError());
                }
                b(cVar);
            }

            @Override // com.haier.uhome.usdk.base.utils.e
            /* JADX INFO: renamed from: a */
            public void d(com.haier.uhome.usdk.base.api.c<com.haier.uhome.search.a.c> cVar) {
                b bVar = b.this;
                Object[] objArr = new Object[1];
                objArr[0] = cVar.c() == null ? com.paytm.pgsdk.d.E : "success";
                bVar.a("retryMatchSoftAp %s", objArr);
                if (cVar.c() == null) {
                    iCallback.onFailure(ErrorConst.ERR_INTERNAL.toError());
                } else {
                    iCallback.onSuccess(null);
                    b.this.d(cVar.c());
                }
                b.this.e();
            }
        }.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, boolean z7) {
        if (!z7) {
            a("auto connect2SoftAp<%s> fail so request app do switch", str);
            this.f31497e.switchToSoftApRequest(str);
        }
        a("auto connect2SoftAp<%s> success so begin softApBind", str);
        a(str);
    }

    private void a(final String str) {
        new com.haier.uhome.usdk.base.utils.e.a<Void>(com.haier.uhome.usdk.base.utils.e.k(), 1000L) { // from class: com.haier.uhome.usdk.bind.b.4
            @Override // com.haier.uhome.usdk.base.utils.e
            /* JADX INFO: renamed from: a */
            public void d(com.haier.uhome.usdk.base.api.c<Void> cVar) {
            }

            @Override // com.haier.uhome.usdk.base.utils.e
            public void a(long j7) {
                if (((int) (b.this.d() / 1000)) < 31) {
                    b.this.a("connect2SoftAp no remain time so return fail", new Object[0]);
                    b.this.f31497e.onFailure(ErrorConst.ERR_USDK_CURRENT_SSID_IS_NOT_IOT.toError());
                    e();
                    return;
                }
                String strE = com.haier.library.common.util.a.f.e(com.haier.uhome.usdk.base.service.e.a().b());
                String str2 = str;
                if (str2 == null || strE == null) {
                    l();
                } else if (!com.haier.library.common.util.c.c(str2, strE)) {
                    l();
                } else {
                    b.this.b(str);
                    e();
                }
            }
        }.a();
    }

    @Override // com.haier.uhome.usdk.a.a
    public void a() {
        this.f31497e.onFailure(ErrorConst.ERR_USDK_TIMEOUT.toError());
    }

    void a(final ICallback<Void> iCallback) {
        a("tryChange2SoftAp start", new Object[0]);
        if (!h()) {
            a("is not support change2SoftAp", new Object[0]);
            iCallback.onFailure(ErrorConst.ERR_INTERNAL.toError());
        } else {
            b(new ICallback<Void>() { // from class: com.haier.uhome.usdk.bind.b.5
                @Override // com.haier.uhome.usdk.base.api.ICallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(Void r7) {
                    b.this.c((ICallback<Void>) iCallback);
                }

                @Override // com.haier.uhome.usdk.base.api.ICallback
                public void onFailure(uSDKError usdkerror) {
                    b.this.a("startSoftApSearch fail", new Object[0]);
                    iCallback.onFailure(ErrorConst.ERR_INTERNAL.toError());
                    b.this.e();
                }
            });
        }
    }

    void a(String str, Object... objArr) {
        e3.a.e(f31495c + str, objArr);
    }
}
