package com.haier.uhome.ble.hal.a.a.a;

import android.os.Bundle;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;

/* JADX INFO: loaded from: classes2.dex */
public class i extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f28231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f28232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f28233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final byte[] f28234h;

    public i(String str, String str2, String str3, byte[] bArr, ICallback<Bundle> iCallback) {
        super(iCallback);
        this.f28231e = str;
        this.f28232f = str2;
        this.f28233g = str3;
        this.f28234h = bArr;
    }

    private void m() {
        if (a(this.f28231e, this.f28232f, this.f28233g, this.f28234h)) {
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
