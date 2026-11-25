package com.google.android.gms.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class MapView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x f16469a;

    public MapView(@c.m0 Context context) {
        super(context);
        this.f16469a = new x(this, context, null);
        setClickable(true);
    }

    public void a(@c.m0 g gVar) {
        com.google.android.gms.common.internal.u.f("getMapAsync() must be called on the main thread");
        com.google.android.gms.common.internal.u.l(gVar, "callback must not be null.");
        this.f16469a.v(gVar);
    }

    public void b(@c.o0 Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            this.f16469a.d(bundle);
            if (this.f16469a.b() == null) {
                com.google.android.gms.dynamic.a.o(this);
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void c() {
        this.f16469a.f();
    }

    public void d(@c.o0 Bundle bundle) {
        com.google.android.gms.common.internal.u.f("onEnterAmbient() must be called on the main thread");
        x xVar = this.f16469a;
        if (xVar.b() != null) {
            xVar.b().c(bundle);
        }
    }

    public void e() {
        com.google.android.gms.common.internal.u.f("onExitAmbient() must be called on the main thread");
        x xVar = this.f16469a;
        if (xVar.b() != null) {
            xVar.b().d();
        }
    }

    public void f() {
        this.f16469a.i();
    }

    public void g() {
        this.f16469a.j();
    }

    public void h() {
        this.f16469a.k();
    }

    public void i(@c.m0 Bundle bundle) {
        this.f16469a.l(bundle);
    }

    public void j() {
        this.f16469a.m();
    }

    public void k() {
        this.f16469a.n();
    }

    public MapView(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16469a = new x(this, context, GoogleMapOptions.r0(context, attributeSet));
        setClickable(true);
    }

    public MapView(@c.m0 Context context, @c.m0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f16469a = new x(this, context, GoogleMapOptions.r0(context, attributeSet));
        setClickable(true);
    }

    public MapView(@c.m0 Context context, @c.o0 GoogleMapOptions googleMapOptions) {
        super(context);
        this.f16469a = new x(this, context, googleMapOptions);
        setClickable(true);
    }
}
