package com.haier.uhome.control.noumenon.a;

import com.haier.uhome.control.base.api.c;
import com.haier.uhome.control.base.api.l;
import com.haier.uhome.control.base.api.r;
import com.haier.uhome.trace.api.Trace;
import com.haier.uhome.trace.api.TraceNode;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.o;
import com.haier.uhome.usdk.base.api.q;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.haier.uhome.control.base.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.haier.uhome.control.noumenon.service.b f29457a;

    public a(String str, String str2, String str3) {
        super(str, str2, str3);
        e3.a.d("NoumenonDevice create %s-%s-%s", str, str2, str3);
        com.haier.uhome.control.noumenon.service.b bVarL = com.haier.uhome.control.noumenon.service.b.l();
        this.f29457a = bVarL;
        bVarL.a(str, this);
        g_();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ErrorConst errorConst) {
        if (errorConst != ErrorConst.RET_USDK_OK) {
            e3.a.h("destroy device<id=%s> first call disConnect, but disConnect fail<err id=%d>!!", X(), Integer.valueOf(errorConst.getErrorId()));
        }
        this.f29457a.a(X());
    }

    @Override // com.haier.uhome.control.base.api.a
    protected String F() {
        return com.haier.uhome.usdk.base.a.ar;
    }

    @Override // com.haier.uhome.control.base.api.a
    public void b(o oVar) {
        e3.a.e("NoumenonDevice is not support", new Object[0]);
    }

    @Override // com.haier.uhome.control.base.api.a
    public String e() {
        return com.haier.uhome.usdk.base.a.ar;
    }

    @Override // com.haier.uhome.control.base.api.a
    public void f() {
        a(new com.haier.uhome.usdk.base.e.b(new o() { // from class: com.haier.uhome.control.noumenon.a.b
            @Override // com.haier.uhome.usdk.base.api.o
            public final void onCallback(ErrorConst errorConst) {
                this.f29458a.a(errorConst);
            }
        }));
    }

    @Override // com.haier.uhome.control.base.api.a
    public com.haier.uhome.control.base.c.a s() {
        return this.f29457a;
    }

    @Override // com.haier.uhome.control.base.api.a, com.haier.uhome.usdk.base.api.b
    public String toString() {
        return "NoumenonDevice{" + super.toString() + "mControlService=" + this.f29457a + '}';
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(boolean z7, o oVar) {
        e3.a.e("NoumenonDevice<%s>\u3000connect ...", X());
        this.f29457a.a(X(), z7, oVar);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(o oVar) {
        e3.a.e("NoumenonDevice<%s>\u3000disConnect ...", X());
        this.f29457a.b(X(), oVar);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, int i7, Trace trace, ICallback<String> iCallback) {
        e3.a.d("NoumenonDevice<%s>\u3000readAttribute <%s>...", X(), str, new Object[0]);
        this.f29457a.a(X(), U(), m(), str, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, String str2, int i7, Trace trace, ICallback<Void> iCallback) {
        e3.a.d("NoumenonDevice<%s>\u3000writeAttribute <%s> ", X(), str, new Object[0]);
        this.f29457a.a(X(), U(), m(), str, str2, i7, trace, iCallback);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, List<c> list, int i7, Trace trace, String str2, ICallback<Void> iCallback) {
        e3.a.d("NoumenonDevice<%s> execDeviceOperation <%s> args <%s> ", X(), str, list);
        this.f29457a.a(X(), U(), m(), str, list, i7, trace, str2, iCallback);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, boolean z7, TraceNode traceNode, l lVar) {
        this.f29457a.a(X(), (String) null, 0, (String) null, "", (q) null, z7, traceNode, "", lVar);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(String str, int i7, String str2, o oVar) {
        this.f29457a.a(oVar);
    }

    @Override // com.haier.uhome.control.base.api.a
    public void a(int i7, Trace trace, ICallback<r> iCallback) {
        this.f29457a.a(X(), i7, trace, iCallback);
    }
}
