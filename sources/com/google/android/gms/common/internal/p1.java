package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
final class p1 extends com.google.android.gms.internal.common.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f15770a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p1(e eVar, Looper looper) {
        super(looper);
        this.f15770a = eVar;
    }

    private static final void a(Message message) {
        q1 q1Var = (q1) message.obj;
        q1Var.b();
        q1Var.e();
    }

    private static final boolean b(Message message) {
        int i7 = message.what;
        return i7 == 2 || i7 == 1 || i7 == 7;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f15770a.C.get() != message.arg1) {
            if (b(message)) {
                a(message);
                return;
            }
            return;
        }
        int i7 = message.what;
        if ((i7 == 1 || i7 == 7 || ((i7 == 4 && !this.f15770a.B()) || message.what == 5)) && !this.f15770a.j()) {
            a(message);
            return;
        }
        int i8 = message.what;
        if (i8 == 4) {
            this.f15770a.f15704z = new ConnectionResult(message.arg2);
            if (e.p0(this.f15770a)) {
                e eVar = this.f15770a;
                if (!eVar.A) {
                    eVar.q0(3, null);
                    return;
                }
            }
            e eVar2 = this.f15770a;
            ConnectionResult connectionResult = eVar2.f15704z != null ? eVar2.f15704z : new ConnectionResult(8);
            this.f15770a.f15694p.a(connectionResult);
            this.f15770a.U(connectionResult);
            return;
        }
        if (i8 == 5) {
            e eVar3 = this.f15770a;
            ConnectionResult connectionResult2 = eVar3.f15704z != null ? eVar3.f15704z : new ConnectionResult(8);
            this.f15770a.f15694p.a(connectionResult2);
            this.f15770a.U(connectionResult2);
            return;
        }
        if (i8 == 3) {
            Object obj = message.obj;
            ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.f15770a.f15694p.a(connectionResult3);
            this.f15770a.U(connectionResult3);
            return;
        }
        if (i8 == 6) {
            this.f15770a.q0(5, null);
            e eVar4 = this.f15770a;
            if (eVar4.f15699u != null) {
                eVar4.f15699u.i0(message.arg2);
            }
            this.f15770a.V(message.arg2);
            e.o0(this.f15770a, 5, 1, null);
            return;
        }
        if (i8 == 2 && !this.f15770a.a()) {
            a(message);
            return;
        }
        if (b(message)) {
            ((q1) message.obj).c();
            return;
        }
        int i9 = message.what;
        StringBuilder sb = new StringBuilder(45);
        sb.append("Don't know how to handle message: ");
        sb.append(i9);
        Log.wtf("GmsClient", sb.toString(), new Exception());
    }
}
