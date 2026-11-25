package com.google.android.gms.common.api.internal;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public final class p3 extends u3 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SparseArray<o3> f15384f;

    private p3(m mVar) {
        super(mVar, com.google.android.gms.common.g.x());
        this.f15384f = new SparseArray<>();
        this.f15136a.h("AutoManageHelper", this);
    }

    public static p3 u(l lVar) {
        m mVarE = LifecycleCallback.e(lVar);
        p3 p3Var = (p3) mVarE.l("AutoManageHelper", p3.class);
        return p3Var != null ? p3Var : new p3(mVarE);
    }

    @c.o0
    private final o3 x(int i7) {
        if (this.f15384f.size() <= i7) {
            return null;
        }
        SparseArray<o3> sparseArray = this.f15384f;
        return sparseArray.get(sparseArray.keyAt(i7));
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i7 = 0; i7 < this.f15384f.size(); i7++) {
            o3 o3VarX = x(i7);
            if (o3VarX != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(o3VarX.f15363a);
                printWriter.println(":");
                o3VarX.f15364d.j(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.u3, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void k() {
        super.k();
        boolean z7 = this.f15429b;
        String strValueOf = String.valueOf(this.f15384f);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 14);
        sb.append("onStart ");
        sb.append(z7);
        sb.append(" ");
        sb.append(strValueOf);
        Log.d("AutoManageHelper", sb.toString());
        if (this.f15430c.get() == null) {
            for (int i7 = 0; i7 < this.f15384f.size(); i7++) {
                o3 o3VarX = x(i7);
                if (o3VarX != null) {
                    o3VarX.f15364d.g();
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.u3, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void l() {
        super.l();
        for (int i7 = 0; i7 < this.f15384f.size(); i7++) {
            o3 o3VarX = x(i7);
            if (o3VarX != null) {
                o3VarX.f15364d.i();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.u3
    protected final void n(ConnectionResult connectionResult, int i7) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i7 < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        o3 o3Var = this.f15384f.get(i7);
        if (o3Var != null) {
            w(i7);
            com.google.android.gms.common.api.k.c cVar = o3Var.f15365e;
            if (cVar != null) {
                cVar.u0(connectionResult);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.u3
    protected final void o() {
        for (int i7 = 0; i7 < this.f15384f.size(); i7++) {
            o3 o3VarX = x(i7);
            if (o3VarX != null) {
                o3VarX.f15364d.g();
            }
        }
    }

    public final void v(int i7, com.google.android.gms.common.api.k kVar, @c.o0 com.google.android.gms.common.api.k.c cVar) {
        com.google.android.gms.common.internal.u.l(kVar, "GoogleApiClient instance cannot be null");
        boolean z7 = this.f15384f.indexOfKey(i7) < 0;
        StringBuilder sb = new StringBuilder(54);
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(i7);
        com.google.android.gms.common.internal.u.r(z7, sb.toString());
        r3 r3Var = this.f15430c.get();
        boolean z8 = this.f15429b;
        String strValueOf = String.valueOf(r3Var);
        StringBuilder sb2 = new StringBuilder(strValueOf.length() + 49);
        sb2.append("starting AutoManage for client ");
        sb2.append(i7);
        sb2.append(" ");
        sb2.append(z8);
        sb2.append(" ");
        sb2.append(strValueOf);
        Log.d("AutoManageHelper", sb2.toString());
        o3 o3Var = new o3(this, i7, kVar, cVar);
        kVar.C(o3Var);
        this.f15384f.put(i7, o3Var);
        if (this.f15429b && r3Var == null) {
            Log.d("AutoManageHelper", "connecting ".concat(kVar.toString()));
            kVar.g();
        }
    }

    public final void w(int i7) {
        o3 o3Var = this.f15384f.get(i7);
        this.f15384f.remove(i7);
        if (o3Var != null) {
            o3Var.f15364d.G(o3Var);
            o3Var.f15364d.i();
        }
    }
}
