package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.d0;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public final class m extends q<r> {
    private static final float H0 = 0.85f;
    private final boolean G0;

    public m(boolean z7) {
        super(Y0(z7), Z0());
        this.G0 = z7;
    }

    private static r Y0(boolean z7) {
        r rVar = new r(z7);
        rVar.m(H0);
        rVar.l(H0);
        return rVar;
    }

    private static v Z0() {
        return new d();
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

    public boolean a1() {
        return this.G0;
    }
}
