package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Visibility;
import androidx.transition.d0;
import c.m0;
import c.o0;
import com.google.android.material.transition.v;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
abstract class q<P extends v> extends Visibility {
    private final P D0;

    @o0
    private v E0;
    private final List<v> F0 = new ArrayList();

    protected q(P p7, @o0 v vVar) {
        this.D0 = p7;
        this.E0 = vVar;
    }

    private static void N0(List<Animator> list, @o0 v vVar, ViewGroup viewGroup, View view, boolean z7) {
        if (vVar == null) {
            return;
        }
        Animator animatorA = z7 ? vVar.a(viewGroup, view) : vVar.b(viewGroup, view);
        if (animatorA != null) {
            list.add(animatorA);
        }
    }

    private Animator P0(@m0 ViewGroup viewGroup, @m0 View view, boolean z7) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        N0(arrayList, this.D0, viewGroup, view, z7);
        N0(arrayList, this.E0, viewGroup, view, z7);
        Iterator<v> it = this.F0.iterator();
        while (it.hasNext()) {
            N0(arrayList, it.next(), viewGroup, view, z7);
        }
        V0(viewGroup.getContext(), z7);
        com.google.android.material.animation.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private void V0(@m0 Context context, boolean z7) {
        u.t(this, context, R0(z7));
        u.u(this, context, S0(z7), Q0(z7));
    }

    @Override // androidx.transition.Visibility
    public Animator H0(ViewGroup viewGroup, View view, d0 d0Var, d0 d0Var2) {
        return P0(viewGroup, view, true);
    }

    @Override // androidx.transition.Visibility
    public Animator J0(ViewGroup viewGroup, View view, d0 d0Var, d0 d0Var2) {
        return P0(viewGroup, view, false);
    }

    public void M0(@m0 v vVar) {
        this.F0.add(vVar);
    }

    public void O0() {
        this.F0.clear();
    }

    @m0
    TimeInterpolator Q0(boolean z7) {
        return com.google.android.material.animation.a.f16847b;
    }

    @c.f
    int R0(boolean z7) {
        return 0;
    }

    @c.f
    int S0(boolean z7) {
        return 0;
    }

    @m0
    public P T0() {
        return this.D0;
    }

    @o0
    public v U0() {
        return this.E0;
    }

    public boolean W0(@m0 v vVar) {
        return this.F0.remove(vVar);
    }

    public void X0(@o0 v vVar) {
        this.E0 = vVar;
    }
}
