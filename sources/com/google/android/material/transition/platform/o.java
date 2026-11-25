package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import c.m0;
import c.o0;
import c.t0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
public final class o extends r<d> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f19120d = 0.8f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f19121e = 0.3f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c.f
    private static final int f19122f = R.attr.motionDurationShort2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @c.f
    private static final int f19123g = R.attr.motionDurationShort1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @c.f
    private static final int f19124h = R.attr.motionEasingLinear;

    public o() {
        super(p(), q());
    }

    private static d p() {
        d dVar = new d();
        dVar.e(f19121e);
        return dVar;
    }

    private static w q() {
        s sVar = new s();
        sVar.o(false);
        sVar.l(f19120d);
        return sVar;
    }

    @Override // com.google.android.material.transition.platform.r
    public /* bridge */ /* synthetic */ void a(@m0 w wVar) {
        super.a(wVar);
    }

    @Override // com.google.android.material.transition.platform.r
    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    @Override // com.google.android.material.transition.platform.r
    @m0
    TimeInterpolator h(boolean z7) {
        return com.google.android.material.animation.a.f16846a;
    }

    @Override // com.google.android.material.transition.platform.r
    @c.f
    int i(boolean z7) {
        return z7 ? f19122f : f19123g;
    }

    @Override // com.google.android.material.transition.platform.r
    @c.f
    int j(boolean z7) {
        return f19124h;
    }

    @Override // com.google.android.material.transition.platform.r
    @o0
    public /* bridge */ /* synthetic */ w l() {
        return super.l();
    }

    @Override // com.google.android.material.transition.platform.r
    public /* bridge */ /* synthetic */ boolean n(@m0 w wVar) {
        return super.n(wVar);
    }

    @Override // com.google.android.material.transition.platform.r
    public /* bridge */ /* synthetic */ void o(@o0 w wVar) {
        super.o(wVar);
    }

    @Override // com.google.android.material.transition.platform.r, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // com.google.android.material.transition.platform.r, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }
}
