package com.haier.uhome.control.local.api;

import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.haier.uhome.control.local.e.b f29318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f29319b;

    public g(String str, String str2, String str3, String str4) {
        super(str, str2, str3, str4);
        e3.a.d("LocalBLEDevice create %s-%s-%s-%s", str, str2, str3, str4);
        com.haier.uhome.control.local.e.b bVarL = com.haier.uhome.control.local.e.b.l();
        this.f29318a = bVarL;
        bVarL.a(str, this);
        g_();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ErrorConst errorConst) {
        if (errorConst != ErrorConst.RET_USDK_OK) {
            e3.a.o("destroy device<id=%s> first call disConnect, but disConnect fail<err id=%d>!!", X(), Integer.valueOf(errorConst.getErrorId()));
        }
        this.f29318a.a(X());
    }

    @Override // com.haier.uhome.control.base.api.a
    protected String F() {
        return com.haier.uhome.usdk.base.a.aq;
    }

    @Override // com.haier.uhome.control.local.api.a, com.haier.uhome.control.base.api.a
    /* JADX INFO: renamed from: K */
    public com.haier.uhome.control.local.e.a s() {
        return this.f29318a;
    }

    public int M() {
        return com.haier.uhome.usdk.base.api.g.a().a(X()).r().a();
    }

    public String N() {
        return com.haier.uhome.usdk.base.api.g.a().a(X()).r().b();
    }

    public com.haier.uhome.usdk.base.api.d P() {
        return com.haier.uhome.usdk.base.api.g.a().a(X()).r().c();
    }

    public void b(ICallback<Void> iCallback) {
        this.f29318a.b(X(), iCallback);
    }

    public void c(ICallback<Void> iCallback) {
        this.f29318a.a(X(), iCallback);
    }

    @Override // com.haier.uhome.control.base.api.a
    public String e() {
        return com.haier.uhome.usdk.base.a.aq;
    }

    @Override // com.haier.uhome.control.base.api.a
    public void f() {
        a(new com.haier.uhome.usdk.base.e.b(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.control.local.api.q
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f29330a.a(errorConst);
            }
        }));
    }

    @Override // com.haier.uhome.usdk.base.api.b
    public String j_() {
        String strG = com.haier.uhome.usdk.base.api.g.a().a(X()).r().g();
        return com.haier.library.common.util.c.l(strG) ? strG : "";
    }

    @Override // com.haier.uhome.control.base.api.a, com.haier.uhome.usdk.base.api.b
    public String toString() {
        return "LocalBLEDevice{" + super.toString() + ", mBleDevId=" + J() + ", mDevProtocolType=" + P() + '}';
    }

    public b O() {
        return this.f29319b;
    }

    @Override // com.haier.uhome.control.base.api.a
    public void b(com.haier.uhome.usdk.base.api.o oVar) {
        e3.a.e("LocalBLEDevice is not support", new Object[0]);
    }

    @Override // com.haier.uhome.control.base.api.a
    public synchronized com.haier.uhome.control.base.api.a.C0367a b(int i7) {
        return new com.haier.uhome.control.base.api.a.C0367a(i7) { // from class: com.haier.uhome.control.local.api.g.1
            @Override // com.haier.uhome.control.base.api.a.C0367a
            public uSDKError a() {
                super.a();
                return ErrorConst.RET_USDK_OK.toError();
            }
        };
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(boolean z7, com.haier.uhome.usdk.base.api.o oVar) {
        com.haier.uhome.control.base.api.a aVarB;
        if (L()) {
            e3.a.u("LocalBLEDevice<%s-%s> ota activation give up connect!", X(), J(), new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
            return;
        }
        if (U() != null) {
            if (A()) {
                com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
                return;
            }
            e(true);
            if (z7 && (aVarB = this.f29318a.b(U())) != null) {
                this.f29318a.d(aVarB);
            }
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
            return;
        }
        if (com.haier.uhome.usdk.base.api.e.a(ai())) {
            e(true);
            a(F(), DeviceStatus.STATUS_CONNECTED, 0);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
        } else {
            e3.a.d("LocalBLEDevice<%s-%s>\u3000connect ...", X(), J(), new Object[0]);
            this.f29318a.a(X(), J(), W(), com.haier.uhome.usdk.base.api.g.a().a(X()).r().d(), N(), z7, aj(), com.haier.uhome.usdk.base.api.g.a().a(X()).r().g(), oVar);
        }
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(com.haier.uhome.usdk.base.api.o oVar) {
        if (L()) {
            e3.a.u("LocalBLEDevice<%s-%s> ota activation give up disConnect!", X(), J(), new Object[0]);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
            return;
        }
        if (U() != null) {
            e(false);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
        } else if (com.haier.uhome.usdk.base.api.e.a(ai())) {
            e(false);
            a(F(), DeviceStatus.STATUS_UNCONNECT, 0);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
        } else {
            e3.a.e("LocalBLEDevice<%s> disConnect ...", X());
            this.f29318a.b(X(), oVar);
        }
    }

    public void a(b bVar) {
        this.f29319b = bVar;
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, int i7, Trace trace, ICallback<String> iCallback) {
        e3.a.d("LocalBLEDevice<%s> readAttribute <%s>...", X(), str, new Object[0]);
        this.f29318a.a(X(), U(), m(), str, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, String str2, int i7, Trace trace, ICallback<Void> iCallback) {
        e3.a.d("LocalBLEDevice<%s> writeAttribute <%s> ", X(), str, new Object[0]);
        this.f29318a.a(X(), U(), m(), str, str2, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, List<com.haier.uhome.control.base.api.c> list, int i7, Trace trace, String str2, ICallback<Void> iCallback) {
        e3.a.d("LocalBLEDevice<%s> execDeviceOperation <%s> args <%s> ", X(), str, list);
        this.f29318a.a(X(), U(), m(), str, list, i7, trace, str2, iCallback);
    }
}
