package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* JADX INFO: loaded from: classes.dex */
@c.t0(18)
class o0 implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewOverlay f10761a;

    o0(@c.m0 View view) {
        this.f10761a = view.getOverlay();
    }

    @Override // androidx.transition.p0
    public void a(@c.m0 Drawable drawable) {
        this.f10761a.add(drawable);
    }

    @Override // androidx.transition.p0
    public void b(@c.m0 Drawable drawable) {
        this.f10761a.remove(drawable);
    }
}
