package org.chromium.net.impl;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class m extends l {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private VersionSafeCallbacks.b f39392s;

    public m(Context context) {
        super(context);
    }

    @Override // org.chromium.net.impl.e
    VersionSafeCallbacks.b I() {
        return this.f39392s;
    }

    @Override // org.chromium.net.impl.e, org.chromium.net.s
    /* JADX INFO: renamed from: Q */
    public e m(org.chromium.net.j.a.b bVar) {
        this.f39392s = new VersionSafeCallbacks.b(bVar);
        return this;
    }
}
