package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class h1 extends com.google.android.gms.internal.base.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ j1 f15239a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    h1(j1 j1Var, Looper looper) {
        super(looper);
        this.f15239a = j1Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i7 = message.what;
        if (i7 == 1) {
            j1.Q(this.f15239a);
            return;
        }
        if (i7 == 2) {
            j1.P(this.f15239a);
            return;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("Unknown message id: ");
        sb.append(i7);
        Log.w("GoogleApiClientImpl", sb.toString());
    }
}
