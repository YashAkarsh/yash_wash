package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
@g1.d0
final class h0 implements com.google.android.gms.maps.internal.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroup f16518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.gms.maps.internal.i f16519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f16520c;

    public h0(ViewGroup viewGroup, com.google.android.gms.maps.internal.i iVar) {
        this.f16519b = (com.google.android.gms.maps.internal.i) com.google.android.gms.common.internal.u.k(iVar);
        this.f16518a = (ViewGroup) com.google.android.gms.common.internal.u.k(viewGroup);
    }

    @Override // com.google.android.gms.dynamic.e
    public final void I() {
        throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
    }

    @Override // com.google.android.gms.dynamic.e
    public final void J(Activity activity, Bundle bundle, @c.o0 Bundle bundle2) {
        throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
    }

    @Override // com.google.android.gms.dynamic.e
    public final View K(LayoutInflater layoutInflater, @c.o0 ViewGroup viewGroup, @c.o0 Bundle bundle) {
        throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
    }

    @Override // com.google.android.gms.maps.internal.l
    public final void b(i iVar) {
        try {
            this.f16519b.w0(new g0(this, iVar));
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void g() {
        try {
            this.f16519b.g();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void i() {
        try {
            this.f16519b.i();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void j() {
        try {
            this.f16519b.j();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void k() {
        try {
            this.f16519b.k();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void n(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            com.google.android.gms.maps.internal.n1.b(bundle, bundle2);
            this.f16519b.n(bundle2);
            com.google.android.gms.maps.internal.n1.b(bundle2, bundle);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void onLowMemory() {
        try {
            this.f16519b.onLowMemory();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void onStart() {
        try {
            this.f16519b.onStart();
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }

    @Override // com.google.android.gms.dynamic.e
    public final void p(@c.o0 Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            com.google.android.gms.maps.internal.n1.b(bundle, bundle2);
            this.f16519b.p(bundle2);
            com.google.android.gms.maps.internal.n1.b(bundle2, bundle);
            this.f16520c = (View) com.google.android.gms.dynamic.f.y0(this.f16519b.H());
            this.f16518a.removeAllViews();
            this.f16518a.addView(this.f16520c);
        } catch (RemoteException e8) {
            throw new com.google.android.gms.maps.model.k(e8);
        }
    }
}
