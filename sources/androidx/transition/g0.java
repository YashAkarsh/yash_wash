package androidx.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
class g0 extends n0 implements i0 {
    g0(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    static g0 g(ViewGroup viewGroup) {
        return (g0) n0.e(viewGroup);
    }

    @Override // androidx.transition.i0
    public void c(@c.m0 View view) {
        this.f10753a.b(view);
    }

    @Override // androidx.transition.i0
    public void d(@c.m0 View view) {
        this.f10753a.h(view);
    }
}
