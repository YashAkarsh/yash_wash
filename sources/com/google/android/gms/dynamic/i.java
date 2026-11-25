package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.u;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public final class i extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Fragment f16023a;

    private i(Fragment fragment) {
        this.f16023a = fragment;
    }

    @o0
    @c1.a
    public static i y0(@o0 Fragment fragment) {
        if (fragment != null) {
            return new i(fragment);
        }
        return null;
    }

    @Override // com.google.android.gms.dynamic.c
    public final boolean B3() {
        return this.f16023a.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.c
    public final boolean B4() {
        return this.f16023a.isAdded();
    }

    @Override // com.google.android.gms.dynamic.c
    public final boolean D5() {
        return this.f16023a.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.c
    public final boolean H2() {
        return this.f16023a.isHidden();
    }

    @Override // com.google.android.gms.dynamic.c
    public final void I2(@m0 Intent intent, int i7) {
        this.f16023a.startActivityForResult(intent, i7);
    }

    @Override // com.google.android.gms.dynamic.c
    public final void J5(boolean z7) {
        this.f16023a.setUserVisibleHint(z7);
    }

    @Override // com.google.android.gms.dynamic.c
    public final boolean K() {
        return this.f16023a.isVisible();
    }

    @Override // com.google.android.gms.dynamic.c
    public final void L(boolean z7) {
        this.f16023a.setHasOptionsMenu(z7);
    }

    @Override // com.google.android.gms.dynamic.c
    public final void L4(@m0 d dVar) {
        View view = (View) f.y0(dVar);
        Fragment fragment = this.f16023a;
        u.k(view);
        fragment.unregisterForContextMenu(view);
    }

    @Override // com.google.android.gms.dynamic.c
    public final boolean Q() {
        return this.f16023a.isResumed();
    }

    @Override // com.google.android.gms.dynamic.c
    public final boolean T0() {
        return this.f16023a.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.c
    public final boolean V4() {
        return this.f16023a.isDetached();
    }

    @Override // com.google.android.gms.dynamic.c
    public final void W1(boolean z7) {
        this.f16023a.setRetainInstance(z7);
    }

    @Override // com.google.android.gms.dynamic.c
    @o0
    public final Bundle a() {
        return this.f16023a.getArguments();
    }

    @Override // com.google.android.gms.dynamic.c
    @m0
    public final d b() {
        return f.z3(this.f16023a.getActivity());
    }

    @Override // com.google.android.gms.dynamic.c
    @o0
    public final c c() {
        return y0(this.f16023a.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.c
    @o0
    public final c d() {
        return y0(this.f16023a.getTargetFragment());
    }

    @Override // com.google.android.gms.dynamic.c
    public final int e() {
        return this.f16023a.getId();
    }

    @Override // com.google.android.gms.dynamic.c
    @m0
    public final d f() {
        return f.z3(this.f16023a.getView());
    }

    @Override // com.google.android.gms.dynamic.c
    public final void g1(boolean z7) {
        this.f16023a.setMenuVisibility(z7);
    }

    @Override // com.google.android.gms.dynamic.c
    @m0
    public final d h() {
        return f.z3(this.f16023a.getResources());
    }

    @Override // com.google.android.gms.dynamic.c
    @o0
    public final String l() {
        return this.f16023a.getTag();
    }

    @Override // com.google.android.gms.dynamic.c
    public final void q4(@m0 d dVar) {
        View view = (View) f.y0(dVar);
        Fragment fragment = this.f16023a;
        u.k(view);
        fragment.registerForContextMenu(view);
    }

    @Override // com.google.android.gms.dynamic.c
    public final boolean s6() {
        return this.f16023a.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.c
    public final int t() {
        return this.f16023a.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.c
    public final void x2(@m0 Intent intent) {
        this.f16023a.startActivity(intent);
    }
}
