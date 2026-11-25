package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes.dex */
@g1.d0
final class k0 implements com.google.android.gms.maps.internal.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Fragment f16535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.gms.maps.internal.d f16536b;

    public k0(Fragment fragment, com.google.android.gms.maps.internal.d dVar) {
        this.f16536b = (com.google.android.gms.maps.internal.d) com.google.android.gms.common.internal.u.k(dVar);
        this.f16535a = (Fragment) com.google.android.gms.common.internal.u.k(fragment);
    }

    @Override // com.google.android.gms.dynamic.e
    public final void I() {
        try {
            this.f16536b.I();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void J(Activity activity, Bundle bundle, @c.o0 Bundle bundle2) {
        GoogleMapOptions googleMapOptions = (GoogleMapOptions) bundle.getParcelable("MapOptions");
        try {
            Bundle bundle3 = new Bundle();
            com.google.android.gms.maps.internal.n1.b(bundle2, bundle3);
            this.f16536b.D2(com.google.android.gms.dynamic.f.z3(activity), googleMapOptions, bundle3);
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
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
            try {
                com.google.android.gms.dynamic.d dVarZ = this.f16536b.Z(com.google.android.gms.dynamic.f.z3(layoutInflater), com.google.android.gms.dynamic.f.z3(viewGroup), bundle2);
                StrictMode.setThreadPolicy(threadPolicy);
                com.google.android.gms.maps.internal.n1.b(bundle2, bundle);
                return (View) com.google.android.gms.dynamic.f.y0(dVarZ);
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(threadPolicy);
                throw th;
            }
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.maps.internal.k
    public final void a(g gVar) {
        try {
            this.f16536b.E(new j0(this, gVar));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void c(@c.o0 Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            com.google.android.gms.maps.internal.n1.b(bundle, bundle2);
            this.f16536b.z(bundle2);
            com.google.android.gms.maps.internal.n1.b(bundle2, bundle);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void d() {
        try {
            this.f16536b.x();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void g() {
        try {
            this.f16536b.g();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void i() {
        try {
            this.f16536b.i();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void j() {
        try {
            this.f16536b.j();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void k() {
        try {
            this.f16536b.k();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void n(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            com.google.android.gms.maps.internal.n1.b(bundle, bundle2);
            this.f16536b.n(bundle2);
            com.google.android.gms.maps.internal.n1.b(bundle2, bundle);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void onLowMemory() {
        try {
            this.f16536b.onLowMemory();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void onStart() {
        try {
            this.f16536b.onStart();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void p(@c.o0 Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            com.google.android.gms.maps.internal.n1.b(bundle, bundle2);
            Bundle arguments = this.f16535a.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                com.google.android.gms.maps.internal.n1.c(bundle2, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.f16536b.p(bundle2);
            com.google.android.gms.maps.internal.n1.b(bundle2, bundle);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }
}
