package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* JADX INFO: loaded from: classes.dex */
@c.t0(18)
class h0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewGroupOverlay f10722a;

    h0(@c.m0 ViewGroup viewGroup) {
        this.f10722a = viewGroup.getOverlay();
    }

    @Override // androidx.transition.p0
    public void a(@c.m0 Drawable drawable) {
        this.f10722a.add(drawable);
    }

    @Override // androidx.transition.p0
    public void b(@c.m0 Drawable drawable) {
        this.f10722a.remove(drawable);
    }

    @Override // androidx.transition.i0
    public void c(@c.m0 View view) {
        this.f10722a.add(view);
    }

    @Override // androidx.transition.i0
    public void d(@c.m0 View view) {
        this.f10722a.remove(view);
    }
}
