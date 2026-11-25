package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class d2 implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e2 f15677a;

    /* synthetic */ d2(e2 e2Var, c2 c2Var) {
        this.f15677a = e2Var;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i7 = message.what;
        if (i7 == 0) {
            synchronized (this.f15677a.f15711f) {
                a2 a2Var = (a2) message.obj;
                b2 b2Var = (b2) this.f15677a.f15711f.get(a2Var);
                if (b2Var != null && b2Var.i()) {
                    if (b2Var.j()) {
                        b2Var.g("GmsClientSupervisor");
                    }
                    this.f15677a.f15711f.remove(a2Var);
                }
            }
            return true;
        }
        if (i7 != 1) {
            return false;
        }
        synchronized (this.f15677a.f15711f) {
            a2 a2Var2 = (a2) message.obj;
            b2 b2Var2 = (b2) this.f15677a.f15711f.get(a2Var2);
            if (b2Var2 != null && b2Var2.a() == 3) {
                String strValueOf = String.valueOf(a2Var2);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 47);
                sb.append("Timeout waiting for ServiceConnection callback ");
                sb.append(strValueOf);
                Log.e("GmsClientSupervisor", sb.toString(), new Exception());
                ComponentName componentNameB = b2Var2.b();
                if (componentNameB == null) {
                    componentNameB = a2Var2.b();
                }
                if (componentNameB == null) {
                    String strD = a2Var2.d();
                    u.k(strD);
                    componentNameB = new ComponentName(strD, "unknown");
                }
                b2Var2.onServiceDisconnected(componentNameB);
            }
        }
        return true;
    }
}
