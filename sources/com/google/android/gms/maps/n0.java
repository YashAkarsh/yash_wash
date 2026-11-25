package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes.dex */
@g1.d0
final class n0 implements com.google.android.gms.maps.internal.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Fragment f16703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.gms.maps.internal.h f16704b;

    public n0(Fragment fragment, com.google.android.gms.maps.internal.h hVar) {
        this.f16704b = (com.google.android.gms.maps.internal.h) com.google.android.gms.common.internal.u.k(hVar);
        this.f16703a = (Fragment) com.google.android.gms.common.internal.u.k(fragment);
    }

    @Override // com.google.android.gms.dynamic.e
    public final void I() {
        try {
            this.f16704b.I();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void J(Activity activity, Bundle bundle, @c.o0 Bundle bundle2) {
        try {
            Bundle bundle3 = new Bundle();
            com.google.android.gms.maps.internal.n1.b(bundle2, bundle3);
            this.f16704b.u3(com.google.android.gms.dynamic.f.z3(activity), null, bundle3);
            com.google.android.gms.maps.internal.n1.b(bundle3, bundle2);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final View K(LayoutInflater layoutInflater, @c.o0 ViewGroup viewGroup, @c.o0 Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            com.google.android.gms.maps.internal.n1.b(bundle, bundle2);
            com.google.android.gms.dynamic.d dVarZ = this.f16704b.Z(com.google.android.gms.dynamic.f.z3(layoutInflater), com.google.android.gms.dynamic.f.z3(viewGroup), bundle2);
            com.google.android.gms.maps.internal.n1.b(bundle2, bundle);
            return (View) com.google.android.gms.dynamic.f.y0(dVarZ);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.maps.internal.l
    public final void b(i iVar) {
        try {
            this.f16704b.w0(new m0(this, iVar));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void g() {
        try {
            this.f16704b.g();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void i() {
        try {
            this.f16704b.i();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void j() {
        try {
            this.f16704b.j();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void k() {
        try {
            this.f16704b.k();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void n(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            com.google.android.gms.maps.internal.n1.b(bundle, bundle2);
            this.f16704b.n(bundle2);
            com.google.android.gms.maps.internal.n1.b(bundle2, bundle);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void onLowMemory() {
        try {
            this.f16704b.onLowMemory();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void onStart() {
        try {
            this.f16704b.onStart();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void p(@c.o0 Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            com.google.android.gms.maps.internal.n1.b(bundle, bundle2);
            Bundle arguments = this.f16703a.getArguments();
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                com.google.android.gms.maps.internal.n1.c(bundle2, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.f16704b.p(bundle2);
            com.google.android.gms.maps.internal.n1.b(bundle2, bundle);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }
}
