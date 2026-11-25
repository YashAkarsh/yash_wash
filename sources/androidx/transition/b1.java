package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@c.t0(23)
class b1 extends z0 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static boolean f10663m = true;

    b1() {
    }

    @Override // androidx.transition.d1
    @SuppressLint({"NewApi"})
    public void h(@c.m0 View view, int i7) {
        if (Build.VERSION.SDK_INT == 28) {
            super.h(view, i7);
        } else if (f10663m) {
            try {
                view.setTransitionVisibility(i7);
            } catch (NoSuchMethodError unused) {
                f10663m = false;
            }
        }
    }
}
