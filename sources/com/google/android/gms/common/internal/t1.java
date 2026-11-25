package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public final class t1 extends e1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @c.o0
    public final IBinder f15807g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ e f15808h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @c.g
    public t1(e eVar, @c.o0 int i7, @c.o0 IBinder iBinder, Bundle bundle) {
        super(eVar, i7, bundle);
        this.f15808h = eVar;
        this.f15807g = iBinder;
    }

    @Override // com.google.android.gms.common.internal.e1
    protected final void f(ConnectionResult connectionResult) {
        if (this.f15808h.f15700v != null) {
            this.f15808h.f15700v.u0(connectionResult);
        }
        this.f15808h.U(connectionResult);
    }

    @Override // com.google.android.gms.common.internal.e1
    protected final boolean g() {
        try {
            IBinder iBinder = this.f15807g;
            u.k(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f15808h.N().equals(interfaceDescriptor)) {
                String strN = this.f15808h.N();
                StringBuilder sb = new StringBuilder(String.valueOf(strN).length() + 34 + String.valueOf(interfaceDescriptor).length());
                sb.append("service descriptor mismatch: ");
                sb.append(strN);
                sb.append(" vs. ");
                sb.append(interfaceDescriptor);
                Log.w("GmsClient", sb.toString());
                return false;
            }
            IInterface iInterfaceA = this.f15808h.A(this.f15807g);
            if (iInterfaceA == null || !(e.o0(this.f15808h, 2, 4, iInterfaceA) || e.o0(this.f15808h, 3, 4, iInterfaceA))) {
                return false;
            }
            this.f15808h.f15704z = null;
            Bundle bundleF = this.f15808h.F();
            e eVar = this.f15808h;
            if (eVar.f15699u == null) {
                return true;
            }
            eVar.f15699u.y0(bundleF);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
