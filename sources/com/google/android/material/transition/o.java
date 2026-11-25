package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.d0;
import c.m0;
import c.o0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
public final class o extends q<e> {
    private static final float G0 = 0.92f;

    @c.f
    private static final int H0 = R.attr.motionDurationLong1;

    @c.f
    private static final int I0 = R.attr.motionEasingStandard;

    public o() {
        super(Y0(), Z0());
    }

    private static e Y0() {
        return new e();
    }

    private static v Z0() {
        r rVar = new r();
        rVar.o(false);
        rVar.l(G0);
        return rVar;
    }

    @Override // com.google.android.material.transition.q, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator H0(ViewGroup viewGroup, View view, d0 d0Var, d0 d0Var2) {
        return super.H0(viewGroup, view, d0Var, d0Var2);
    }

    @Override // com.google.android.material.transition.q, androidx.transition.Visibility
    public /* bridge */ /* synthetic */ Animator J0(ViewGroup viewGroup, View view, d0 d0Var, d0 d0Var2) {
        return super.J0(viewGroup, view, d0Var, d0Var2);
    }

    @Override // com.google.android.material.transition.q
    public /* bridge */ /* synthetic */ void M0(@m0 v vVar) {
        super.M0(vVar);
    }

    @Override // com.google.android.material.transition.q
    public /* bridge */ /* synthetic */ void O0() {
        super.O0();
    }

    @Override // com.google.android.material.transition.q
    @c.f
    int R0(boolean z7) {
        return H0;
    }

    @Override // com.google.android.material.transition.q
    @c.f
    int S0(boolean z7) {
        return I0;
    }

    @Override // com.google.android.material.transition.q
    @o0
    public /* bridge */ /* synthetic */ v U0() {
        return super.U0();
    }

    @Override // com.google.android.material.transition.q
    public /* bridge */ /* synthetic */ boolean W0(@m0 v vVar) {
        return super.W0(vVar);
    }

    @Override // com.google.android.material.transition.q
    public /* bridge */ /* synthetic */ void X0(@o0 v vVar) {
        super.X0(vVar);
    }
}
