package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import c.m0;
import c.o0;
import c.t0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
public final class p extends r<e> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f19125d = 0.92f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.f
    private static final int f19126e = R.attr.motionDurationLong1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c.f
    private static final int f19127f = R.attr.motionEasingStandard;

    public p() {
        super(p(), q());
    }

    private static e p() {
        return new e();
    }

    private static w q() {
        s sVar = new s();
        sVar.o(false);
        sVar.l(f19125d);
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
    @c.f
    int i(boolean z7) {
        return f19126e;
    }

    @Override // com.google.android.material.transition.platform.r
    @c.f
    int j(boolean z7) {
        return f19127f;
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
