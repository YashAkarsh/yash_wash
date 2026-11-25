package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class e3 extends com.google.android.gms.internal.base.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g3 f15204a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e3(g3 g3Var, Looper looper) {
        super(looper);
        this.f15204a = g3Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i7 = message.what;
        if (i7 == 0) {
            com.google.android.gms.common.api.n<?> nVar = (com.google.android.gms.common.api.n) message.obj;
            synchronized (this.f15204a.f15226e) {
                g3 g3Var = (g3) com.google.android.gms.common.internal.u.k(this.f15204a.f15223b);
                if (nVar == null) {
                    g3Var.m(new Status(13, "Transform returned null"));
                } else if (nVar instanceof u2) {
                    g3Var.m(((u2) nVar).k());
                } else {
                    g3Var.l(nVar);
                }
            }
            return;
        }
        if (i7 == 1) {
            RuntimeException runtimeException = (RuntimeException) message.obj;
            String strValueOf = String.valueOf(runtimeException.getMessage());
            Log.e("TransformedResultImpl", strValueOf.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(strValueOf) : new String("Runtime exception on the transformation worker thread: "));
            throw runtimeException;
        }
        StringBuilder sb = new StringBuilder(70);
        sb.append("TransformationResultHandler received unknown message type: ");
        sb.append(i7);
        Log.e("TransformedResultImpl", sb.toString());
    }
}
