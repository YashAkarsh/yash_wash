package org.chromium.net.impl;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class l extends e {
    public l(Context context) {
        super(context);
    }

    @Override // org.chromium.net.s
    public org.chromium.net.o c() {
        if (E() == null) {
            p(k());
        }
        CronetUrlRequestContext cronetUrlRequestContext = new CronetUrlRequestContext(this);
        this.f39343n = 0L;
        return cronetUrlRequestContext;
    }
}
