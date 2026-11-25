package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import c.m0;
import c.o0;
import c.t0;
import com.google.android.material.transition.platform.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
abstract class r<P extends w> extends Visibility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final P f19135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private w f19136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<w> f19137c = new ArrayList();

    protected r(P p7, @o0 w wVar) {
        this.f19135a = p7;
        this.f19136b = wVar;
    }

    private static void b(List<Animator> list, @o0 w wVar, ViewGroup viewGroup, View view, boolean z7) {
        if (wVar == null) {
            return;
        }
        Animator animatorA = z7 ? wVar.a(viewGroup, view) : wVar.b(viewGroup, view);
        if (animatorA != null) {
            list.add(animatorA);
        }
    }

    private Animator g(@m0 ViewGroup viewGroup, @m0 View view, boolean z7) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        b(arrayList, this.f19135a, viewGroup, view, z7);
        b(arrayList, this.f19136b, viewGroup, view, z7);
        Iterator<w> it = this.f19137c.iterator();
        while (it.hasNext()) {
            b(arrayList, it.next(), viewGroup, view, z7);
        }
        m(viewGroup.getContext(), z7);
        com.google.android.material.animation.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private void m(@m0 Context context, boolean z7) {
        v.t(this, context, i(z7));
        v.u(this, context, j(z7), h(z7));
    }

    public void a(@m0 w wVar) {
        this.f19137c.add(wVar);
    }

    public void e() {
        this.f19137c.clear();
    }

    @m0
    TimeInterpolator h(boolean z7) {
        return com.google.android.material.animation.a.f16847b;
    }

    @c.f
    int i(boolean z7) {
        return 0;
    }

    @c.f
    int j(boolean z7) {
        return 0;
    }

    @m0
    public P k() {
        return this.f19135a;
    }

    @o0
    public w l() {
        return this.f19136b;
    }

    public boolean n(@m0 w wVar) {
        return this.f19137c.remove(wVar);
    }

    public void o(@o0 w wVar) {
        this.f19136b = wVar;
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return g(viewGroup, view, true);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return g(viewGroup, view, false);
    }
}
