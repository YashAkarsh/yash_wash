package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import c.m0;
import c.o0;
import com.google.android.gms.common.internal.u;

/* JADX INFO: loaded from: classes.dex */
@c1.a
@SuppressLint({"NewApi"})
public final class b extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Fragment f16019a;

    private b(Fragment fragment) {
        this.f16019a = fragment;
    }

    @o0
    @c1.a
    public static b y0(@o0 Fragment fragment) {
        if (fragment != null) {
            return new b(fragment);
        }
        return null;
    }

    @Override // com.google.android.gms.dynamic.c
    public final boolean B3() {
        return this.f16019a.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.c
    public final boolean B4() {
        return this.f16019a.isAdded();
    }

    @Override // com.google.android.gms.dynamic.c
    public final boolean D5() {
        return this.f16019a.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.c
    public final boolean H2() {
        return this.f16019a.isHidden();
    }

    @Override // com.google.android.gms.dynamic.c
    public final void I2(@m0 Intent intent, int i7) {
        this.f16019a.startActivityForResult(intent, i7);
    }

    @Override // com.google.android.gms.dynamic.c
    public final void J5(boolean z7) {
        this.f16019a.setUserVisibleHint(z7);
    }

    @Override // com.google.android.gms.dynamic.c
    public final boolean K() {
        return this.f16019a.isVisible();
    }

    @Override // com.google.android.gms.dynamic.c
    public final void L(boolean z7) {
        this.f16019a.setHasOptionsMenu(z7);
    }

    @Override // com.google.android.gms.dynamic.c
    public final void L4(@m0 d dVar) {
        View view = (View) f.y0(dVar);
        Fragment fragment = this.f16019a;
        u.k(view);
        fragment.unregisterForContextMenu(view);
    }

    @Override // com.google.android.gms.dynamic.c
    public final boolean Q() {
        return this.f16019a.isResumed();
    }

    @Override // com.google.android.gms.dynamic.c
    public final boolean T0() {
        return this.f16019a.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.c
    public final boolean V4() {
        return this.f16019a.isDetached();
    }

    @Override // com.google.android.gms.dynamic.c
    public final void W1(boolean z7) {
        this.f16019a.setRetainInstance(z7);
    }

    @Override // com.google.android.gms.dynamic.c
    @o0
    public final Bundle a() {
        return this.f16019a.getArguments();
    }

    @Override // com.google.android.gms.dynamic.c
    @m0
    public final d b() {
        return f.z3(this.f16019a.getActivity());
    }

    @Override // com.google.android.gms.dynamic.c
    @o0
    public final c c() {
        return y0(this.f16019a.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.c
    @o0
    public final c d() {
        return y0(this.f16019a.getTargetFragment());
    }

    @Override // com.google.android.gms.dynamic.c
    public final int e() {
        return this.f16019a.getId();
    }

    @Override // com.google.android.gms.dynamic.c
    @m0
    public final d f() {
        return f.z3(this.f16019a.getView());
    }

    @Override // com.google.android.gms.dynamic.c
    public final void g1(boolean z7) {
        this.f16019a.setMenuVisibility(z7);
    }

    @Override // com.google.android.gms.dynamic.c
    @m0
    public final d h() {
        return f.z3(this.f16019a.getResources());
    }

    @Override // com.google.android.gms.dynamic.c
    @o0
    public final String l() {
        return this.f16019a.getTag();
    }

    @Override // com.google.android.gms.dynamic.c
    public final void q4(@m0 d dVar) {
        View view = (View) f.y0(dVar);
        Fragment fragment = this.f16019a;
        u.k(view);
        fragment.registerForContextMenu(view);
    }

    @Override // com.google.android.gms.dynamic.c
    public final boolean s6() {
        return this.f16019a.getUserVisibleHint();
    }

    @Override // com.google.android.gms.dynamic.c
    public final int t() {
        return this.f16019a.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.c
    public final void x2(@m0 Intent intent) {
        this.f16019a.startActivity(intent);
    }
}
