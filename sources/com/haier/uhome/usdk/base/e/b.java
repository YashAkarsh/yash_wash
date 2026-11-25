package com.haier.uhome.usdk.base.e;

import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.o;

/* JADX INFO: loaded from: classes2.dex */
@a
public class b implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private o f31280a;

    public b(o oVar) {
        this.f31280a = oVar;
    }

    @Override // com.haier.uhome.usdk.base.api.o
    public void onCallback(ErrorConst errorConst) {
        o oVar = this.f31280a;
        if (oVar != null) {
            oVar.onCallback(errorConst);
        }
    }
}
