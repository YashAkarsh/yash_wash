package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class m1 extends com.google.android.gms.internal.base.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ n1 f15328a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    m1(n1 n1Var, Looper looper) {
        super(looper);
        this.f15328a = n1Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i7 = message.what;
        if (i7 == 1) {
            ((l1) message.obj).b(this.f15328a);
        } else {
            if (i7 == 2) {
                throw ((RuntimeException) message.obj);
            }
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i7);
            Log.w("GACStateManager", sb.toString());
        }
    }
}
