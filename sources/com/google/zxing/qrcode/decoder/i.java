package com.google.zxing.qrcode.decoder;

import com.google.zxing.t;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f24167a;

    i(boolean z7) {
        this.f24167a = z7;
    }

    public void a(t[] tVarArr) {
        if (!this.f24167a || tVarArr == null || tVarArr.length < 3) {
            return;
        }
        t tVar = tVarArr[0];
        tVarArr[0] = tVarArr[2];
        tVarArr[2] = tVar;
    }

    public boolean b() {
        return this.f24167a;
    }
}
