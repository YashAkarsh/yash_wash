package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
class l {
    private l() {
    }

    @c.o0
    static h a(@c.m0 View view, @c.m0 ViewGroup viewGroup, @c.o0 Matrix matrix) {
        return Build.VERSION.SDK_INT == 28 ? j.b(view, viewGroup, matrix) : k.b(view, viewGroup, matrix);
    }

    static void b(View view) {
        if (Build.VERSION.SDK_INT == 28) {
            j.f(view);
        } else {
            k.f(view);
        }
    }
}
