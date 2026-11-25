package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@c.t0(29)
class c1 extends b1 {
    c1() {
    }

    @Override // androidx.transition.t0, androidx.transition.d1
    public float c(@c.m0 View view) {
        return view.getTransitionAlpha();
    }

    @Override // androidx.transition.x0, androidx.transition.d1
    public void e(@c.m0 View view, @c.o0 Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }

    @Override // androidx.transition.z0, androidx.transition.d1
    public void f(@c.m0 View view, int i7, int i8, int i9, int i10) {
        view.setLeftTopRightBottom(i7, i8, i9, i10);
    }

    @Override // androidx.transition.t0, androidx.transition.d1
    public void g(@c.m0 View view, float f8) {
        view.setTransitionAlpha(f8);
    }

    @Override // androidx.transition.b1, androidx.transition.d1
    public void h(@c.m0 View view, int i7) {
        view.setTransitionVisibility(i7);
    }

    @Override // androidx.transition.x0, androidx.transition.d1
    public void i(@c.m0 View view, @c.m0 Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // androidx.transition.x0, androidx.transition.d1
    public void j(@c.m0 View view, @c.m0 Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
