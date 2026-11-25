package com.google.android.gms.maps;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(11)
public class e extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u f16503a = new u(this);

    @c.m0
    public static e b() {
        return new e();
    }

    @c.m0
    public static e c(@c.o0 GoogleMapOptions googleMapOptions) {
        e eVar = new e();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", googleMapOptions);
        eVar.setArguments(bundle);
        return eVar;
    }

    public void a(@c.m0 g gVar) {
        com.google.android.gms.common.internal.u.f("getMapAsync must be called on the main thread.");
        com.google.android.gms.common.internal.u.l(gVar, "callback must not be null.");
        this.f16503a.w(gVar);
    }

    public final void d(@c.o0 Bundle bundle) {
        com.google.android.gms.common.internal.u.f("onEnterAmbient must be called on the main thread.");
        u uVar = this.f16503a;
        if (uVar.b() != null) {
            uVar.b().c(bundle);
        }
    }

    public final void e() {
        com.google.android.gms.common.internal.u.f("onExitAmbient must be called on the main thread.");
        u uVar = this.f16503a;
        if (uVar.b() != null) {
            uVar.b().d();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(@c.o0 Bundle bundle) {
        ClassLoader classLoader = e.class.getClassLoader();
        if (bundle != null && classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public void onAttach(@c.m0 Activity activity) {
        super.onAttach(activity);
        u.v(this.f16503a, activity);
    }

    @Override // android.app.Fragment
    public void onCreate(@c.o0 Bundle bundle) {
        super.onCreate(bundle);
        this.f16503a.d(bundle);
    }

    @Override // android.app.Fragment
    @c.m0
    public View onCreateView(@c.m0 LayoutInflater layoutInflater, @c.o0 ViewGroup viewGroup, @c.o0 Bundle bundle) {
        View viewE = this.f16503a.e(layoutInflater, viewGroup, bundle);
        viewE.setClickable(true);
        return viewE;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        this.f16503a.f();
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.f16503a.g();
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    @SuppressLint({"NewApi"})
    public void onInflate(@c.m0 Activity activity, @c.m0 AttributeSet attributeSet, @c.o0 Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            u.v(this.f16503a, activity);
            GoogleMapOptions googleMapOptionsR0 = GoogleMapOptions.r0(activity, attributeSet);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("MapOptions", googleMapOptionsR0);
            this.f16503a.h(activity, bundle2, bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f16503a.i();
        super.onLowMemory();
    }

    @Override // android.app.Fragment
    public void onPause() {
        this.f16503a.j();
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f16503a.k();
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(@c.m0 Bundle bundle) {
        ClassLoader classLoader = e.class.getClassLoader();
        if (bundle != null && classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        super.onSaveInstanceState(bundle);
        this.f16503a.l(bundle);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f16503a.m();
    }

    @Override // android.app.Fragment
    public void onStop() {
        this.f16503a.n();
        super.onStop();
    }

    @Override // android.app.Fragment
    public void setArguments(@c.o0 Bundle bundle) {
        super.setArguments(bundle);
    }
}
