package com.haier.uhome.control.local.api;

import android.text.TextUtils;
import com.haier.library.common.util.u;
import com.haier.uhome.control.base.api.DeviceStatus;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class i extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    List<h> f29322e;

    public i(String str, String str2, String str3, String str4, int i7, com.haier.uhome.control.base.api.p pVar) {
        super(str, str2, str3, str4, i7, pVar, com.haier.uhome.control.local.e.d.l());
        R();
    }

    @Override // com.haier.uhome.control.base.api.a
    protected String F() {
        return com.haier.uhome.usdk.base.a.at;
    }

    @Override // com.haier.uhome.control.local.api.c
    DeviceStatus N() {
        h hVarS = S();
        if (hVarS != null) {
            return com.haier.uhome.control.local.d.d.a().a(hVarS.X(), d());
        }
        e3.a.v("LocalGatewayDevice<%s> getCatchStatus but not find gateway", X());
        return DeviceStatus.STATUS_OFFLINE;
    }

    @Override // com.haier.uhome.control.local.api.c
    protected String O() {
        return X();
    }

    public synchronized List<h> R() {
        if (this.f29322e == null) {
            this.f29322e = new CopyOnWriteArrayList();
        }
        return this.f29322e;
    }

    public h S() {
        h hVar = null;
        if (ah()) {
            String strB = this.f29309d.b();
            if (TextUtils.isEmpty(strB)) {
                return null;
            }
            i iVar = (i) s().b(strB);
            if (iVar != null) {
                return iVar.S();
            }
            e3.a.h("group dev<%s> get best gateway fail", X());
            this.f29309d.a();
            return null;
        }
        List<h> listR = R();
        for (h hVar2 : listR) {
            if (hVar2.n() == DeviceStatus.STATUS_READY) {
                hVar = hVar2;
                break;
            }
        }
        if (hVar == null) {
            for (h hVar3 : listR) {
                if (hVar3.n() == DeviceStatus.STATUS_CONNECTED) {
                    hVar = hVar3;
                    break;
                }
            }
        }
        e3.a.d("localGatewayDevice<%s> find his gateway<%s>", X(), hVar == null ? "noGateway" : hVar.X(), new Object[0]);
        return hVar;
    }

    @Override // com.haier.uhome.control.local.api.a, com.haier.uhome.control.base.api.a
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public com.haier.uhome.control.local.e.e s() {
        return ((c) this).f29306a;
    }

    public void a(h hVar) {
        if (hVar == null) {
            e3.a.v("addLocalGateway with null device", new Object[0]);
            return;
        }
        List<h> listR = R();
        if (listR.size() == 0) {
            a(F(), com.haier.uhome.control.local.d.d.a().a(hVar.X(), d()), 0);
        }
        listR.add(hVar);
    }

    public void b(h hVar) {
        if (hVar == null) {
            e3.a.v("rmLocalGateway with null device", new Object[0]);
            return;
        }
        R().remove(hVar);
        if (u.h(R())) {
            a(F(), DeviceStatus.STATUS_OFFLINE, 0);
        }
    }

    @Override // com.haier.uhome.control.base.api.a
    public String e() {
        return "localGw";
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(com.haier.uhome.usdk.base.api.o oVar) {
        com.haier.uhome.usdk.base.utils.b.a(oVar, ErrorConst.RET_USDK_OK);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, int i7, Trace trace, ICallback<String> iCallback) {
        e3.a.d("BleMeshDevice<%s>\u3000readAttribute <%s>...", X(), str, new Object[0]);
        ((c) this).f29306a.a(X(), U(), m(), str, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, String str2, int i7, Trace trace, ICallback<Void> iCallback) {
        e3.a.d("BleMeshDevice<%s>\u3000writeAttribute <%s> ", X(), str, new Object[0]);
        ((c) this).f29306a.a(X(), U(), m(), str, str2, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, List<com.haier.uhome.control.base.api.c> list, int i7, Trace trace, String str2, ICallback<Void> iCallback) {
        e3.a.d("BleMeshDevice<%s> execDeviceOperation <%s> args <%s> ", X(), str, list);
        ((c) this).f29306a.a(X(), U(), m(), str, list, i7, trace, str2, iCallback);
    }
}
