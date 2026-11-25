package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public interface e {
    @c1.a
    void I();

    @c1.a
    void J(@m0 Activity activity, @m0 Bundle bundle, @o0 Bundle bundle2);

    @c1.a
    @m0
    View K(@m0 LayoutInflater layoutInflater, @o0 ViewGroup viewGroup, @o0 Bundle bundle);

    @c1.a
    void g();

    @c1.a
    void i();

    @c1.a
    void j();

    @c1.a
    void k();

    @c1.a
    void n(@m0 Bundle bundle);

    @c1.a
    void onLowMemory();

    @c1.a
    void onStart();

    @c1.a
    void p(@o0 Bundle bundle);
}
