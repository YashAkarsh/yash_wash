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
public class m extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o0 f16544a = new o0(this);

    @c.m0
    public static m B() {
        return new m();
    }

    @c.m0
    public static m C(@c.o0 StreetViewPanoramaOptions streetViewPanoramaOptions) {
        m mVar = new m();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", streetViewPanoramaOptions);
        mVar.setArguments(bundle);
        return mVar;
    }

    public void A(@c.m0 i iVar) {
        com.google.android.gms.common.internal.u.f("getStreetViewPanoramaAsync() must be called on the main thread");
        com.google.android.gms.common.internal.u.l(iVar, "callback must not be null.");
        this.f16544a.w(iVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@c.o0 Bundle bundle) {
        ClassLoader classLoader = m.class.getClassLoader();
        if (bundle != null && classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        super.onActivityCreated(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@c.m0 Activity activity) {
        super.onAttach(activity);
        o0.v(this.f16544a, activity);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@c.o0 Bundle bundle) {
        super.onCreate(bundle);
        this.f16544a.d(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @c.m0
    public View onCreateView(@c.m0 LayoutInflater layoutInflater, @c.o0 ViewGroup viewGroup, @c.o0 Bundle bundle) {
        return this.f16544a.e(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f16544a.f();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f16544a.g();
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onInflate(@c.m0 Activity activity, @c.m0 AttributeSet attributeSet, @c.o0 Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            o0.v(this.f16544a, activity);
            this.f16544a.h(activity, new Bundle(), bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f16544a.i();
        super.onLowMemory();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.f16544a.j();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f16544a.k();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@c.m0 Bundle bundle) {
        ClassLoader classLoader = m.class.getClassLoader();
        if (bundle != null && classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        super.onSaveInstanceState(bundle);
        this.f16544a.l(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.f16544a.m();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.f16544a.n();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void setArguments(@c.o0 Bundle bundle) {
        super.setArguments(bundle);
    }
}
