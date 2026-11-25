package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import c.m0;
import c.o0;
import c.t0;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
public final class n extends r<s> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f19118e = 0.85f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f19119d;

    public n(boolean z7) {
        super(p(z7), q());
        this.f19119d = z7;
    }

    private static s p(boolean z7) {
        s sVar = new s(z7);
        sVar.m(f19118e);
        sVar.l(f19118e);
        return sVar;
    }

    private static w q() {
        return new d();
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

    public boolean r() {
        return this.f19119d;
    }
}
