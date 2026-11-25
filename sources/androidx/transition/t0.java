package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@c.t0(19)
class t0 extends d1 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static boolean f10773h = true;

    t0() {
    }

    @Override // androidx.transition.d1
    public void a(@c.m0 View view) {
    }

    @Override // androidx.transition.d1
    @SuppressLint({"NewApi"})
    public float c(@c.m0 View view) {
        if (f10773h) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f10773h = false;
            }
        }
        return view.getAlpha();
    }

    @Override // androidx.transition.d1
    public void d(@c.m0 View view) {
    }

    @Override // androidx.transition.d1
    @SuppressLint({"NewApi"})
    public void g(@c.m0 View view, float f8) {
        if (f10773h) {
            try {
                view.setTransitionAlpha(f8);
                return;
            } catch (NoSuchMethodError unused) {
                f10773h = false;
            }
        }
        view.setAlpha(f8);
    }
}
