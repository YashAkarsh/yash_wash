package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.n0;
import c.m0;
import c.o0;
import c.t0;
import c.x0;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@t0(21)
public final class q extends r<w> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f19128f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f19129g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f19130h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @c.f
    private static final int f19131i = R.attr.motionDurationLong1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @c.f
    private static final int f19132j = R.attr.motionEasingStandard;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f19133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f19134e;

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public q(int i7, boolean z7) {
        super(p(i7, z7), q());
        this.f19133d = i7;
        this.f19134e = z7;
    }

    private static w p(int i7, boolean z7) {
        if (i7 == 0) {
            return new t(z7 ? n0.f6718c : n0.f6717b);
        }
        if (i7 == 1) {
            return new t(z7 ? 80 : 48);
        }
        if (i7 == 2) {
            return new s(z7);
        }
        throw new IllegalArgumentException("Invalid axis: " + i7);
    }

    private static w q() {
        return new e();
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
        return f19131i;
    }

    @Override // com.google.android.material.transition.platform.r
    @c.f
    int j(boolean z7) {
        return f19132j;
    }

    @Override // com.google.android.material.transition.platform.r
    @m0
    public /* bridge */ /* synthetic */ w k() {
        return super.k();
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

    public int r() {
        return this.f19133d;
    }

    public boolean s() {
        return this.f19134e;
    }
}
