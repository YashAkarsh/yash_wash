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
public class l extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e0 f16538a = new e0(this);

    @c.m0
    public static l b() {
        return new l();
    }

    @c.m0
    public static l c(@c.o0 StreetViewPanoramaOptions streetViewPanoramaOptions) {
        l lVar = new l();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", streetViewPanoramaOptions);
        lVar.setArguments(bundle);
        return lVar;
    }

    public void a(@c.m0 i iVar) {
        com.google.android.gms.common.internal.u.f("getStreetViewPanoramaAsync() must be called on the main thread");
        com.google.android.gms.common.internal.u.l(iVar, "callback must not be null.");
        this.f16538a.w(iVar);
    }

    @Override // android.app.Fragment
    public void onActivityCreated(@c.o0 Bundle bundle) {
        ClassLoader classLoader = l.class.getClassLoader();
        if (bundle != null && classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        super.onActivityCreated(bundle);
    }

    @Override // android.app.Fragment
    public void onAttach(@c.m0 Activity activity) {
        super.onAttach(activity);
        e0.v(this.f16538a, activity);
    }

    @Override // android.app.Fragment
    public void onCreate(@c.o0 Bundle bundle) {
        super.onCreate(bundle);
        this.f16538a.d(bundle);
    }

    @Override // android.app.Fragment
    @c.m0
    public View onCreateView(@c.m0 LayoutInflater layoutInflater, @c.o0 ViewGroup viewGroup, @c.o0 Bundle bundle) {
        return this.f16538a.e(layoutInflater, viewGroup, bundle);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        this.f16538a.f();
        super.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.f16538a.g();
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    @SuppressLint({"NewApi"})
    public void onInflate(@c.m0 Activity activity, @c.m0 AttributeSet attributeSet, @c.o0 Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            e0.v(this.f16538a, activity);
            this.f16538a.h(activity, new Bundle(), bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f16538a.i();
        super.onLowMemory();
    }

    @Override // android.app.Fragment
    public void onPause() {
        this.f16538a.j();
        super.onPause();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f16538a.k();
    }

    @Override // android.app.Fragment
    public void onSaveInstanceState(@c.m0 Bundle bundle) {
        ClassLoader classLoader = l.class.getClassLoader();
        if (bundle != null && classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        super.onSaveInstanceState(bundle);
        this.f16538a.l(bundle);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f16538a.m();
    }

    @Override // android.app.Fragment
    public void onStop() {
        this.f16538a.n();
        super.onStop();
    }

    @Override // android.app.Fragment
    public void setArguments(@c.o0 Bundle bundle) {
        super.setArguments(bundle);
    }
}
