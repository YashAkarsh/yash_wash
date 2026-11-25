package com.haier.uhome.usdk.bind;

import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.trace.api.TraceProtocolConst;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.uSDKError;
import com.haier.uhome.usdk.scanner.ConfigurableDevice;

/* JADX INFO: loaded from: classes2.dex */
class e extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BLEBindInfo f31539a;

    e(BLEBindInfo bLEBindInfo) {
        super(bLEBindInfo);
        this.f31539a = bLEBindInfo;
    }

    private TraceNode y() {
        ConfigurableDevice configurableDeviceO = o();
        return com.haier.uhome.trace.api.b.a().a(configurableDeviceO == null ? r() : configurableDeviceO.getDevId(), this.f31539a.getSsid(), this.f31539a.getPassword(), this.f31539a.getBssid(), this.f31539a.getTimeout(), a(configurableDeviceO), this.f31539a.getAppCsNode());
    }

    @Override // com.haier.uhome.usdk.bind.h
    protected void a(com.haier.uhome.config.entity.a aVar) {
        aVar.c(this.f31539a.getSsid());
        aVar.d(this.f31539a.getBssid());
        aVar.e(this.f31539a.getPassword());
        super.a(aVar);
    }

    @Override // com.haier.uhome.usdk.bind.h, com.haier.uhome.usdk.bind.k
    protected boolean f() {
        boolean zF = super.f();
        if (zF) {
            a(this.f31539a.getTimeout());
        }
        return zF;
    }

    @Override // com.haier.uhome.usdk.bind.h, com.haier.uhome.usdk.bind.k
    protected uSDKError g() {
        uSDKError usdkerrorG = super.g();
        String ssid = this.f31539a.getSsid();
        if (!com.haier.uhome.usdk.base.utils.f.b(ssid)) {
            e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter ssid : " + ssid, new Object[0]);
            uSDKError error = ErrorConst.ERR_USDK_INVALID_PARAM.toError();
            error.a("ssid=" + ssid);
            return error;
        }
        String password = this.f31539a.getPassword();
        if (!k.d(password)) {
            return usdkerrorG;
        }
        e3.a.f(com.haier.uhome.config.a.E, com.haier.uhome.config.a.I, "illegal parameter password : " + password, new Object[0]);
        uSDKError error2 = ErrorConst.ERR_USDK_PASSWORD_LENGTH_INVALID.toError();
        error2.a("password=" + password);
        return error2;
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void i() {
        a(this.f31539a != null ? y() : com.haier.uhome.trace.api.b.a().d(null));
    }

    @Override // com.haier.uhome.usdk.bind.h
    TraceNode j() {
        return com.haier.uhome.trace.api.b.a().e(o().getDevId(), u());
    }

    @Override // com.haier.uhome.usdk.bind.h
    void a(int i7, TraceNode traceNode) {
        com.haier.uhome.trace.api.b.a().f(i7, o().getDevId(), traceNode);
    }

    @Override // com.haier.uhome.usdk.bind.k
    protected void a(uSDKError usdkerror) {
        String str = usdkerror.getExtendedInfo().get(TraceProtocolConst.PRO_PROTOCOL);
        if (com.haier.library.common.util.c.j(str)) {
            str = "local";
        }
        com.haier.uhome.trace.api.b.a().b(usdkerror.getCode(), r(), u(), str);
    }
}
