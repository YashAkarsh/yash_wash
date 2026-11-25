package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@c.t0(22)
class z0 extends x0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f10833l = true;

    z0() {
    }

    @Override // androidx.transition.d1
    @SuppressLint({"NewApi"})
    public void f(@c.m0 View view, int i7, int i8, int i9, int i10) {
        if (f10833l) {
            try {
                view.setLeftTopRightBottom(i7, i8, i9, i10);
            } catch (NoSuchMethodError unused) {
                f10833l = false;
            }
        }
    }
}
