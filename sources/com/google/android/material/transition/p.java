package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.n0;
import androidx.transition.d0;
import c.m0;
import c.o0;
import c.x0;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class p extends q<v> {
    public static final int I0 = 0;
    public static final int J0 = 1;
    public static final int K0 = 2;

    @c.f
    private static final int L0 = R.attr.motionDurationLong1;

    @c.f
    private static final int M0 = R.attr.motionEasingStandard;
    private final int G0;
    private final boolean H0;

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public p(int i7, boolean z7) {
        super(Y0(i7, z7), Z0());
        this.G0 = i7;
        this.H0 = z7;
    }

    private static v Y0(int i7, boolean z7) {
        if (i7 == 0) {
            return new s(z7 ? n0.f6718c : n0.f6717b);
        }
        if (i7 == 1) {
            return new s(z7 ? 80 : 48);
        }
        if (i7 == 2) {
            return new r(z7);
        }
        throw new IllegalArgumentException("Invalid axis: " + i7);
    }

    private static v Z0() {
        return new e();
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
        return L0;
    }

    @Override // com.google.android.material.transition.q
    @c.f
    int S0(boolean z7) {
        return M0;
    }

    @Override // com.google.android.material.transition.q
    @m0
    public /* bridge */ /* synthetic */ v T0() {
        return super.T0();
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

    public int a1() {
        return this.G0;
    }

    public boolean b1() {
        return this.H0;
    }
}
