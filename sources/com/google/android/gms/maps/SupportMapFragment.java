package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes.dex */
public class SupportMapFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l0 f16481a = new l0(this);

    @c.m0
    public static SupportMapFragment B() {
        return new SupportMapFragment();
    }

    @c.m0
    public static SupportMapFragment C(@c.o0 GoogleMapOptions googleMapOptions) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", googleMapOptions);
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }

    public void A(@c.m0 g gVar) {
        com.google.android.gms.common.internal.u.f("getMapAsync must be called on the main thread.");
        com.google.android.gms.common.internal.u.l(gVar, "callback must not be null.");
        this.f16481a.w(gVar);
    }

    public final void D(@c.o0 Bundle bundle) {
        com.google.android.gms.common.internal.u.f("onEnterAmbient must be called on the main thread.");
        l0 l0Var = this.f16481a;
        if (l0Var.b() != null) {
            l0Var.b().c(bundle);
        }
    }

    public final void E() {
        com.google.android.gms.common.internal.u.f("onExitAmbient must be called on the main thread.");
        l0 l0Var = this.f16481a;
        if (l0Var.b() != null) {
            l0Var.b().d();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@c.o0 Bundle bundle) {
        ClassLoader classLoader = SupportMapFragment.class.getClassLoader();
        if (bundle != null && classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@c.m0 Activity activity) {
        super.onAttach(activity);
        l0.v(this.f16481a, activity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@c.o0 Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onCreate(bundle);
            this.f16481a.d(bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @c.m0
    public View onCreateView(@c.m0 LayoutInflater layoutInflater, @c.o0 ViewGroup viewGroup, @c.o0 Bundle bundle) {
        View viewE = this.f16481a.e(layoutInflater, viewGroup, bundle);
        viewE.setClickable(true);
        return viewE;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f16481a.f();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f16481a.g();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(@c.m0 Activity activity, @c.m0 AttributeSet attributeSet, @c.o0 Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            l0.v(this.f16481a, activity);
            GoogleMapOptions googleMapOptionsR0 = GoogleMapOptions.r0(activity, attributeSet);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("MapOptions", googleMapOptionsR0);
            this.f16481a.h(activity, bundle2, bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f16481a.i();
        super.onLowMemory();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.f16481a.j();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f16481a.k();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@c.m0 Bundle bundle) {
        ClassLoader classLoader = SupportMapFragment.class.getClassLoader();
        if (bundle != null && classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        super.onSaveInstanceState(bundle);
        this.f16481a.l(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f16481a.m();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.f16481a.n();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void setArguments(@c.o0 Bundle bundle) {
        super.setArguments(bundle);
    }
}
