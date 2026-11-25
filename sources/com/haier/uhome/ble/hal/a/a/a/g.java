package com.haier.uhome.ble.hal.a.a.a;

import android.os.Bundle;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;

/* JADX INFO: loaded from: classes2.dex */
public class g extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f28225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f28226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final byte[] f28227g;

    public g(String str, String str2, byte[] bArr, ICallback<Bundle> iCallback) {
        super(iCallback);
        this.f28225e = str;
        this.f28226f = str2;
        this.f28227g = bArr;
    }

    private void m() {
        if (b(this.f28225e, this.f28226f, this.f28227g)) {
            k();
        } else {
            a(ErrorConst.ERR_INTERNAL);
        }
    }

    @Override // com.haier.uhome.ble.hal.a.a.a.a
    public void b() {
        m();
    }
}
