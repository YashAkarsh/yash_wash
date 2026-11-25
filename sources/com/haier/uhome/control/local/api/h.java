package com.haier.uhome.control.local.api;

import android.text.TextUtils;
import com.haier.library.common.util.u;
import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h extends com.haier.uhome.control.base.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.haier.uhome.control.local.e.c f29321a;

    public h(String str, String str2, String str3) {
        super(str, str2, str3);
        e3.a.d("LocalDevice create %s-%s-%s", str, str2, str3);
        com.haier.uhome.control.local.e.c cVarL = com.haier.uhome.control.local.e.c.l();
        this.f29321a = cVarL;
        cVarL.a(str, this);
        g_();
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        b(str3);
    }

    private com.haier.uhome.usdk.base.api.q N() {
        return com.haier.uhome.usdk.base.api.g.a().a(X()).p().c();
    }

    private int O() {
        if (com.haier.uhome.usdk.base.api.d.DEV_PROT_STD == J()) {
            return I();
        }
        return (K() != 0 && ac().startsWith("UHOME_OVERSEAS_")) ? 56797 : 56800;
    }

    private int P() {
        return O();
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.haier.uhome.control.base.api.a aVarB = this.f29321a.b(str);
        if (aVarB == null) {
            e3.a.h("sub device try to get main device but fail!!!", new Object[0]);
        } else if (aVarB.n() == DeviceStatus.STATUS_READY) {
            a(F(), DeviceStatus.STATUS_CONNECTED, 0);
        } else {
            a(F(), aVarB.n(), 0);
        }
    }

    @Override // com.haier.uhome.control.base.api.a
    protected String F() {
        return "local";
    }

    public com.haier.uhome.usdk.base.api.d J() {
        return com.haier.uhome.usdk.base.api.g.a().a(X()).p().d();
    }

    public int K() {
        return com.haier.uhome.usdk.base.api.g.a().a(X()).p().a();
    }

    public String L() {
        return com.haier.uhome.usdk.base.api.g.a().a(X()).p().b();
    }

    public boolean M() {
        com.haier.uhome.usdk.base.api.f fVarA = com.haier.uhome.usdk.base.api.g.a().a(X());
        if (fVarA == null) {
            return false;
        }
        return fVarA.d();
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, DeviceStatus deviceStatus, int i7) {
        super.a(str, deviceStatus, i7);
        if (deviceStatus != DeviceStatus.STATUS_OFFLINE) {
            return;
        }
        List<String> listL = l();
        if (u.h(listL)) {
            return;
        }
        for (String str2 : listL) {
            com.haier.uhome.control.base.api.a aVarB = s().b(str2);
            if (aVarB != null) {
                aVarB.a(str, deviceStatus, i7);
            } else {
                e3.a.h("setDeviceStatus not found subdevice - <%s>", str2);
            }
        }
    }

    @Override // com.haier.uhome.control.base.api.a
    public String e() {
        return "local";
    }

    @Override // com.haier.uhome.control.base.api.a
    public void f() {
        a(new com.haier.uhome.usdk.base.e.b(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.control.local.api.r
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f29331a.a(errorConst);
            }
        }));
    }

    @Override // com.haier.uhome.usdk.base.api.b
    public boolean i_() {
        return com.haier.uhome.usdk.base.api.g.a().a(X()).p().n();
    }

    @Override // com.haier.uhome.control.base.api.a
    public com.haier.uhome.control.base.c.a s() {
        if (this.f29321a == null) {
            this.f29321a = com.haier.uhome.control.local.e.c.l();
        }
        return this.f29321a;
    }

    @Override // com.haier.uhome.control.base.api.a, com.haier.uhome.usdk.base.api.b
    public String toString() {
        return "LocalDevice{" + super.toString() + "mIp=" + H() + ", mPort=" + I() + ", mControlService=" + this.f29321a + '}';
    }

    @Override // com.haier.uhome.control.base.api.a
    public void b(com.haier.uhome.usdk.base.api.o oVar) {
        e3.a.e("LocalDevice is not support", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ErrorConst errorConst) {
        if (errorConst != ErrorConst.RET_USDK_OK) {
            e3.a.o("destroy device<id=%s> first call disConnect, but disConnect fail<err id=%d>!!", X(), Integer.valueOf(errorConst.getErrorId()));
        }
        this.f29321a.a(X());
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(boolean z7, com.haier.uhome.usdk.base.api.o oVar) {
        if (U() != null) {
            if (A()) {
                com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
                return;
            }
            a(z7);
            if (!z7 && n() == DeviceStatus.STATUS_READY) {
                a(F(), DeviceStatus.STATUS_CONNECTED, 0);
            }
            e(true);
            if (z7) {
                this.f29321a.d(this);
            }
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
            return;
        }
        e3.a.d("LocalDevice<%s>-<%s> connect ...", X(), W(), new Object[0]);
        this.f29321a.a(X(), Y(), W(), H(), I(), Z(), N(), L(), z7, aj(), j_(), oVar);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(com.haier.uhome.usdk.base.api.o oVar) {
        if (U() != null) {
            e(false);
            com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
        } else {
            e3.a.e("LocalDevice<%s> disConnect ...", X());
            this.f29321a.b(X(), Y(), oVar);
        }
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, int i7, Trace trace, ICallback<String> iCallback) {
        e3.a.d("LocalDevice<%s>\u3000readAttribute <%s>...", X(), str, new Object[0]);
        this.f29321a.a(X(), U(), m(), str, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, String str2, int i7, Trace trace, ICallback<Void> iCallback) {
        e3.a.d("LocalDevice<%s>\u3000writeAttribute <%s> ", X(), str, new Object[0]);
        this.f29321a.a(X(), U(), m(), str, str2, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, List<com.haier.uhome.control.base.api.c> list, int i7, Trace trace, String str2, ICallback<Void> iCallback) {
        e3.a.d("LocalDevice<%s> execDeviceOperation <%s> args <%s> ", X(), str, list);
        this.f29321a.a(X(), U(), m(), str, list, i7, trace, str2, iCallback);
    }

    public void a(ICallback<Void> iCallback) {
        this.f29321a.a(X(), iCallback);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, boolean z7, TraceNode traceNode, com.haier.uhome.control.base.api.l lVar) {
        com.haier.uhome.usdk.base.api.q qVarN = N();
        if (U() != null) {
            qVarN = com.haier.uhome.usdk.base.api.q.UWT_DEV;
        }
        this.f29321a.a(X(), H(), O(), str, L(), qVarN, z7, traceNode, lVar);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, int i7, String str2, com.haier.uhome.usdk.base.api.o oVar) {
        this.f29321a.a(X(), W(), H(), P(), str, i7, str2, L(), N(), oVar);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(int i7, Trace trace, ICallback<com.haier.uhome.control.base.api.r> iCallback) {
        this.f29321a.a(X(), i7, trace, iCallback);
    }

    public void a(String str, String str2, int i7, String str3, com.haier.uhome.usdk.base.api.o oVar) {
        this.f29321a.a(X(), new File(com.haier.uhome.usdk.base.utils.f.a(com.haier.uhome.usdk.base.service.e.a().b(), com.haier.uhome.usdk.base.a.N), str).getPath(), str2, i7, str3, oVar);
    }
}
