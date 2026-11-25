package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
@c.t0(21)
class x0 extends t0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f10820i = true;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static boolean f10821j = true;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f10822k = true;

    x0() {
    }

    @Override // androidx.transition.d1
    @SuppressLint({"NewApi"})
    public void e(@c.m0 View view, @c.o0 Matrix matrix) {
        if (f10820i) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError unused) {
                f10820i = false;
            }
        }
    }

    @Override // androidx.transition.d1
    @SuppressLint({"NewApi"})
    public void i(@c.m0 View view, @c.m0 Matrix matrix) {
        if (f10821j) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f10821j = false;
            }
        }
    }

    @Override // androidx.transition.d1
    @SuppressLint({"NewApi"})
    public void j(@c.m0 View view, @c.m0 Matrix matrix) {
        if (f10822k) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f10822k = false;
            }
        }
    }
}
