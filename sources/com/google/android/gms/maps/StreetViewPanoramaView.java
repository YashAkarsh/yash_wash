package com.google.android.gms.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class StreetViewPanoramaView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i0 f16480a;

    public StreetViewPanoramaView(@c.m0 Context context) {
        super((Context) com.google.android.gms.common.internal.u.l(context, "context must not be null"));
        this.f16480a = new i0(this, context, null);
    }

    public void a(@c.m0 i iVar) {
        com.google.android.gms.common.internal.u.l(iVar, "callback must not be null");
        com.google.android.gms.common.internal.u.f("getStreetViewPanoramaAsync() must be called on the main thread");
        this.f16480a.v(iVar);
    }

    public final void b(@c.o0 Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            this.f16480a.d(bundle);
            if (this.f16480a.b() == null) {
                com.google.android.gms.dynamic.a.o(this);
            }
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void c() {
        this.f16480a.f();
    }

    public final void d() {
        this.f16480a.i();
    }

    public final void e() {
        this.f16480a.j();
    }

    public void f() {
        this.f16480a.k();
    }

    public final void g(@c.m0 Bundle bundle) {
        this.f16480a.l(bundle);
    }

    public void h() {
        this.f16480a.m();
    }

    public void i() {
        this.f16480a.n();
    }

    public StreetViewPanoramaView(@c.m0 Context context, @c.m0 AttributeSet attributeSet) {
        super((Context) com.google.android.gms.common.internal.u.l(context, "context must not be null"), attributeSet);
        this.f16480a = new i0(this, context, null);
    }

    public StreetViewPanoramaView(@c.m0 Context context, @c.m0 AttributeSet attributeSet, int i7) {
        super((Context) com.google.android.gms.common.internal.u.l(context, "context must not be null"), attributeSet, i7);
        this.f16480a = new i0(this, context, null);
    }

    public StreetViewPanoramaView(@c.m0 Context context, @c.o0 StreetViewPanoramaOptions streetViewPanoramaOptions) {
        super((Context) com.google.android.gms.common.internal.u.l(context, "context must not be null"));
        this.f16480a = new i0(this, context, streetViewPanoramaOptions);
    }
}
