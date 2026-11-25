package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class c3 implements com.google.android.gms.tasks.c<Boolean, Void> {
    c3() {
    }

    @Override // com.google.android.gms.tasks.c
    public final /* bridge */ /* synthetic */ Void a(@c.m0 com.google.android.gms.tasks.m<Boolean> mVar) throws Exception {
        if (mVar.r().booleanValue()) {
            return null;
        }
        throw new com.google.android.gms.common.api.b(new Status(13, "listener already unregistered"));
    }
}
