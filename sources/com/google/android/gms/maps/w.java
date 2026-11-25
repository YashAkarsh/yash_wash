package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
@g1.d0
final class w implements com.google.android.gms.maps.internal.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroup f16727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.gms.maps.internal.e f16728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f16729c;

    public w(ViewGroup viewGroup, com.google.android.gms.maps.internal.e eVar) {
        this.f16728b = (com.google.android.gms.maps.internal.e) com.google.android.gms.common.internal.u.k(eVar);
        this.f16727a = (ViewGroup) com.google.android.gms.common.internal.u.k(viewGroup);
    }

    @Override // com.google.android.gms.dynamic.e
    public final void I() {
        throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
    }

    @Override // com.google.android.gms.dynamic.e
    public final void J(Activity activity, Bundle bundle, @c.o0 Bundle bundle2) {
        throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
    }

    @Override // com.google.android.gms.dynamic.e
    public final View K(LayoutInflater layoutInflater, @c.o0 ViewGroup viewGroup, @c.o0 Bundle bundle) {
        throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
    }

    @Override // com.google.android.gms.maps.internal.k
    public final void a(g gVar) {
        try {
            this.f16728b.E(new v(this, gVar));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void c(@c.o0 Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            com.google.android.gms.maps.internal.n1.b(bundle, bundle2);
            this.f16728b.z(bundle2);
            com.google.android.gms.maps.internal.n1.b(bundle2, bundle);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    public final void d() {
        try {
            this.f16728b.x();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void g() {
        try {
            this.f16728b.g();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void i() {
        try {
            this.f16728b.i();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void j() {
        try {
            this.f16728b.j();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void k() {
        try {
            this.f16728b.k();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void n(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            com.google.android.gms.maps.internal.n1.b(bundle, bundle2);
            this.f16728b.n(bundle2);
            com.google.android.gms.maps.internal.n1.b(bundle2, bundle);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void onLowMemory() {
        try {
            this.f16728b.onLowMemory();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void onStart() {
        try {
            this.f16728b.onStart();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void p(@c.o0 Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            com.google.android.gms.maps.internal.n1.b(bundle, bundle2);
            this.f16728b.p(bundle2);
            com.google.android.gms.maps.internal.n1.b(bundle2, bundle);
            this.f16729c = (View) com.google.android.gms.dynamic.f.y0(this.f16728b.H());
            this.f16727a.removeAllViews();
            this.f16727a.addView(this.f16729c);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }
}
