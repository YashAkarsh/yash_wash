package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.d0;
import c.m0;
import c.o0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
public final class n extends q<d> {
    private static final float G0 = 0.8f;
    private static final float H0 = 0.3f;

    @c.f
    private static final int I0 = R.attr.motionDurationShort2;

    @c.f
    private static final int J0 = R.attr.motionDurationShort1;

    @c.f
    private static final int K0 = R.attr.motionEasingLinear;

    public n() {
        super(Y0(), Z0());
    }

    private static d Y0() {
        d dVar = new d();
        dVar.e(H0);
        return dVar;
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
    @m0
    TimeInterpolator Q0(boolean z7) {
        return com.google.android.material.animation.a.f16846a;
    }

    @Override // com.google.android.material.transition.q
    @c.f
    int R0(boolean z7) {
        return z7 ? I0 : J0;
    }

    @Override // com.google.android.material.transition.q
    @c.f
    int S0(boolean z7) {
        return K0;
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
