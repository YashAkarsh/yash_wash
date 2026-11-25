package com.haier.uhome.control.cloud.api;

import android.text.TextUtils;
import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.control.base.api.o;
import com.haier.uhome.control.base.api.p;
import com.haier.uhome.control.base.api.r;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.n;
import com.haier.uhome.usdk.base.api.s;
import com.haier.uhome.usdk.base.api.uSDKError;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class c extends com.haier.uhome.control.base.api.a implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f29106a = 30000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f29107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f29108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.haier.uhome.control.base.api.g f29109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private p f29110e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FOTAStatusInfo f29111f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private h f29112g;

    protected c(d dVar, String str, String str2, String str3, p pVar) {
        super(str, str2, str3);
        e3.a.d("CloudDevice create %s-%s-%s", str, str2, str3);
        this.f29107b = dVar;
        this.f29110e = pVar;
        K();
        g_();
    }

    private void K() {
        if (ah() && this.f29109d == null) {
            this.f29109d = new com.haier.uhome.control.base.api.g(s(), this.f29110e, this) { // from class: com.haier.uhome.control.cloud.api.c.1
                @Override // com.haier.uhome.control.base.api.g
                protected void a(DeviceStatus deviceStatus) {
                    e3.a.e("calculation group cloud device<%s> status to %s but no use", c.this.X(), deviceStatus);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ErrorConst errorConst) {
        if (errorConst != ErrorConst.RET_USDK_OK) {
            e3.a.h("destroy device<id=%s> first call disConnect, but disConnect fail<err id=%d>!!", X(), Integer.valueOf(errorConst.getErrorId()));
        }
        this.f29107b.b().a(X());
        com.haier.uhome.control.base.api.g gVar = this.f29109d;
        if (gVar != null) {
            gVar.d();
        }
    }

    @Override // com.haier.uhome.control.base.api.a
    protected long B() {
        return f29106a;
    }

    @Override // com.haier.uhome.control.base.api.a
    protected String F() {
        return com.haier.uhome.usdk.base.a.ao;
    }

    @Override // com.haier.uhome.usdk.base.api.b
    public String H() {
        e3.a.e("get ip form cloud device so return nothing", new Object[0]);
        return "";
    }

    @Override // com.haier.uhome.usdk.base.api.b
    public int I() {
        return 0;
    }

    public h J() {
        return this.f29112g;
    }

    @Override // com.haier.uhome.control.base.api.o
    public com.haier.uhome.control.base.api.g b() {
        c cVarC = c();
        if (cVarC != null) {
            return cVarC.f29109d;
        }
        return null;
    }

    @Override // com.haier.uhome.control.base.api.o
    public int d() {
        return com.haier.uhome.usdk.base.api.g.a().a(X()).s().a();
    }

    @Override // com.haier.uhome.control.base.api.a
    public String e() {
        return com.haier.uhome.usdk.base.a.ao;
    }

    @Override // com.haier.uhome.control.base.api.o
    public void e_() {
        if (ah()) {
            K();
            this.f29109d.a();
        } else {
            com.haier.uhome.control.base.api.g gVarB = b();
            if (gVarB != null) {
                gVarB.a();
            }
        }
    }

    @Override // com.haier.uhome.control.base.api.a
    public void f() {
        a(new com.haier.uhome.usdk.base.e.b(new com.haier.uhome.usdk.base.api.o() { // from class: com.haier.uhome.control.cloud.api.j
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f29134a.a(errorConst);
            }
        }));
        this.f29111f = null;
    }

    @Override // com.haier.uhome.control.base.api.a
    public com.haier.uhome.control.base.c.a s() {
        d dVar = this.f29107b;
        if (dVar == null) {
            return null;
        }
        return dVar.b();
    }

    @Override // com.haier.uhome.control.base.api.o
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public c c() {
        com.haier.uhome.control.base.c.a aVarS;
        com.haier.uhome.control.base.api.a aVarB;
        String strV = V();
        if (TextUtils.isEmpty(strV) || (aVarS = s()) == null || (aVarB = aVarS.b(strV)) == null) {
            return null;
        }
        return (c) aVarB;
    }

    public void c(String str, com.haier.uhome.usdk.base.api.o oVar) {
        this.f29107b.b().b(X(), str, oVar);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void b(com.haier.uhome.usdk.base.api.o oVar) {
        this.f29107b.b().a(X(), oVar);
    }

    public void b(ICallback<FOTAStatusInfo> iCallback) {
        this.f29107b.b().b(X(), iCallback);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(boolean z7, com.haier.uhome.usdk.base.api.o oVar) {
        e3.a.e("CloudDevice<%s> connect ...", X());
        this.f29107b.b().a(X(), W(), z7, oVar);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(com.haier.uhome.usdk.base.api.o oVar) {
        e3.a.e("CloudDevice<%s> disConnect ...", X());
        this.f29107b.b().c(X(), oVar);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, int i7, Trace trace, ICallback<String> iCallback) {
        e3.a.d("CloudDevice<%s>\u3000readAttribute <%s>...", X(), str, new Object[0]);
        this.f29107b.b().a(X(), U(), m(), str, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, String str2, int i7, Trace trace, ICallback<Void> iCallback) {
        e3.a.d("CloudDevice<%s>\u3000writeAttribute <%s> ", X(), str, new Object[0]);
        this.f29107b.b().a(X(), U(), m(), str, str2, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, List<com.haier.uhome.control.base.api.c> list, int i7, Trace trace, String str2, ICallback<Void> iCallback) {
        e3.a.d("CloudDevice<%s> execDeviceOperation <%s> args <%s> ", X(), str, list);
        this.f29107b.b().a(X(), U(), m(), str, list, i7, trace, str2, iCallback);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(int i7, Trace trace, ICallback<r> iCallback) {
        this.f29107b.b().a(X(), i7, trace, iCallback);
    }

    public void a(h hVar) {
        this.f29112g = hVar;
    }

    public void a(String str, int i7, n<e> nVar) {
        this.f29107b.b().a(X(), str, i7, nVar);
    }

    public void a(ICallback<FOTAInfo> iCallback) {
        this.f29107b.b().a(X(), iCallback);
    }

    public void a(FOTAInfo fOTAInfo, ICallback<Void> iCallback) {
        this.f29107b.b().a(X(), fOTAInfo, iCallback);
    }

    public void a(DeviceFOTAInfo deviceFOTAInfo, ICallback<Void> iCallback) {
        this.f29107b.b().a(X(), deviceFOTAInfo, iCallback);
    }

    public void a(g gVar) {
        this.f29108c = gVar;
    }

    public void a(FOTAStatusInfo fOTAStatusInfo) {
        g gVar = this.f29108c;
        if (gVar == null) {
            e3.a.v("notifyFotaStatus but listener is null", new Object[0]);
            return;
        }
        com.haier.uhome.control.cloud.b.a.a(fOTAStatusInfo);
        synchronized (this) {
            if (fOTAStatusInfo.equals(this.f29111f)) {
                e3.a.e("notifyFotaStatus duplicated current = %s, last = %s!", fOTAStatusInfo, this.f29111f);
                return;
            }
            this.f29111f = fOTAStatusInfo;
            if (com.haier.uhome.control.cloud.b.a.b(fOTAStatusInfo)) {
                this.f29111f = null;
            }
            gVar.onFOTAStatus(fOTAStatusInfo);
        }
    }

    public void a(String str, String str2, String str3, String str4, ICallback<Void> iCallback) {
        this.f29107b.b().a(X(), str, str2, str3, str4, iCallback);
    }

    public void a(int i7, ICallback<ModuleInfo> iCallback) {
        this.f29107b.b().a(X(), i7, iCallback);
    }

    public void a(f fVar) {
        this.f29107b.b().a(15, X(), fVar, new s() { // from class: com.haier.uhome.control.cloud.api.k
            @Override // com.haier.uhome.usdk.base.api.s
            public final void onCallback(uSDKError usdkerror) {
                c.a(usdkerror);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(uSDKError usdkerror) {
        if (uSDKError.RET_USDK_OK.a(usdkerror)) {
            e3.a.e("Update device version success error = %s", usdkerror);
        } else {
            e3.a.h("Update device version fail error = %s", usdkerror);
        }
    }
}
