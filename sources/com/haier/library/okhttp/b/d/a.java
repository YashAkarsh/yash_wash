package com.haier.library.okhttp.b.d;

import com.haier.library.okhttp.i0;
import com.haier.library.okhttp.l0;
import com.haier.uhome.account.api.Const;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l0 f27005a;

    public a(l0 l0Var) {
        this.f27005a = l0Var;
    }

    @Override // com.haier.library.okhttp.i0
    public com.haier.library.okhttp.a a(i0.a aVar) throws IOException {
        com.haier.library.okhttp.b.e.g gVar = (com.haier.library.okhttp.b.e.g) aVar;
        com.haier.library.okhttp.f fVarA = gVar.a();
        g gVarG = gVar.g();
        return gVar.e(fVarA, gVarG, gVarG.d(this.f27005a, aVar, !fVarA.d().equals(Const.HTTP_REQUEST_TYPE_GET)), gVarG.l());
    }
}
