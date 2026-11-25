package com.haier.uhome.ble.hal.a.a.a;

import android.os.Bundle;
import com.haier.uhome.usdk.base.api.ErrorConst;
import com.haier.uhome.usdk.base.api.ICallback;

/* JADX INFO: loaded from: classes2.dex */
public class e extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f28201e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f28202f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f28203g;

    public e(String str, String str2, String str3, ICallback<Bundle> iCallback) {
        super(iCallback);
        this.f28201e = str;
        this.f28202f = str2;
        this.f28203g = str3;
    }

    private void m() {
        if (a(this.f28201e, this.f28202f, this.f28203g)) {
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
