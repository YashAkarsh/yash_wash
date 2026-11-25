package com.haier.uhome.control.cloud.api;

import android.text.TextUtils;
import com.haier.uhome.control.base.api.p;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;
import com.haier.uhome.usdk.base.api.o;
import com.haier.uhome.usdk.base.api.s;
import com.haier.uhome.usdk.base.api.uSDKError;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.haier.uhome.control.cloud.service.c f29114a;

    private d(int i7, String str, String str2, int i8) throws com.haier.uhome.usdk.base.b.b {
        com.haier.uhome.control.cloud.service.c cVarL = com.haier.uhome.control.cloud.service.c.l();
        this.f29114a = cVarL;
        ErrorConst errorConstA = cVarL.a(i7, str, str2, i8);
        if (errorConstA != ErrorConst.RET_USDK_OK) {
            throw new com.haier.uhome.usdk.base.b.b(errorConstA.toError());
        }
    }

    private boolean e() {
        return this.f29114a == null;
    }

    public c a(String str, String str2, String str3, p pVar) {
        c cVar = new c(this, str, str2, str3, pVar);
        this.f29114a.a(str, cVar);
        return cVar;
    }

    public void c(o oVar) {
        if (e()) {
            return;
        }
        this.f29114a.c(oVar);
    }

    public long d() {
        return this.f29114a.o();
    }

    public void b(o oVar) {
        if (e()) {
            return;
        }
        this.f29114a.b(oVar);
    }

    public static d a(int i7, String str, String str2, int i8) throws com.haier.uhome.usdk.base.b.b {
        return new d(i7, str, str2, i8);
    }

    public b c() {
        return this.f29114a.n();
    }

    public void a(o oVar) {
        if (e()) {
            return;
        }
        this.f29114a.a(oVar);
    }

    protected com.haier.uhome.control.cloud.service.c b() {
        return this.f29114a;
    }

    public void a(String str, String str2, long j7, int i7, int i8, String str3, ICallback<String> iCallback) {
        this.f29114a.a(str, str2, j7, i7, i8, str3, "", iCallback);
    }

    public void a(String str, String str2, long j7, int i7, int i8, String str3, String str4, s sVar) {
        this.f29114a.a(str, str2, j7, i7, i8, str3, str4, com.haier.uhome.usdk.base.utils.b.a(sVar));
    }

    public void a() {
        this.f29114a.m();
    }

    public void a(String str, String str2, String str3, int i7, String str4, int i8, String str5, o oVar) {
        this.f29114a.a(str, str2, str3, i7, str4, i8, str5, oVar);
    }

    public void a(String str, o oVar) {
        this.f29114a.b(str, oVar);
    }

    public void a(String str, long j7, int i7, int i8, String str2, ICallback<com.haier.uhome.control.base.a> iCallback) {
        a(str, j7, i7, i8, str2, 0L, 0L, iCallback);
    }

    public void a(String str, long j7, int i7, int i8, String str2, long j8, long j9, ICallback<com.haier.uhome.control.base.a> iCallback) {
        this.f29114a.a(str, j7, i7, i8, str2, j8, j9, iCallback);
    }

    public void a(int i7, String str, f fVar, final o oVar) {
        this.f29114a.a(i7, str, fVar, new s() { // from class: com.haier.uhome.control.cloud.api.l
            @Override // com.haier.uhome.usdk.base.api.s
            public final void onCallback(uSDKError usdkerror) {
                d.a(oVar, usdkerror);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(o oVar, uSDKError usdkerror) {
        if (oVar != null) {
            oVar.onCallback(ErrorConst.getErrorConstById(usdkerror.getCode()));
        }
    }

    public void a(i iVar) {
        this.f29114a.a(iVar);
    }

    public c a(String str) {
        com.haier.uhome.control.base.api.a aVarB = TextUtils.isEmpty(str) ? null : this.f29114a.b(str);
        if (aVarB instanceof c) {
            return (c) aVarB;
        }
        return null;
    }
}
