package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.core.view.n2;
import androidx.recyclerview.R;

/* JADX INFO: loaded from: classes.dex */
class o implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final n f9670a = new o();

    o() {
    }

    private static float e(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f8 = 0.0f;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = recyclerView.getChildAt(i7);
            if (childAt != view) {
                float fR = n2.R(childAt);
                if (fR > f8) {
                    f8 = fR;
                }
            }
        }
        return f8;
    }

    @Override // androidx.recyclerview.widget.n
    public void a(View view) {
        Object tag = view.getTag(R.id.item_touch_helper_previous_elevation);
        if (tag instanceof Float) {
            n2.N1(view, ((Float) tag).floatValue());
        }
        view.setTag(R.id.item_touch_helper_previous_elevation, null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.n
    public void b(View view) {
    }

    @Override // androidx.recyclerview.widget.n
    public void c(Canvas canvas, RecyclerView recyclerView, View view, float f8, float f9, int i7, boolean z7) {
    }

    @Override // androidx.recyclerview.widget.n
    public void d(Canvas canvas, RecyclerView recyclerView, View view, float f8, float f9, int i7, boolean z7) {
        if (z7 && view.getTag(R.id.item_touch_helper_previous_elevation) == null) {
            Float fValueOf = Float.valueOf(n2.R(view));
            n2.N1(view, e(recyclerView, view) + 1.0f);
            view.setTag(R.id.item_touch_helper_previous_elevation, fValueOf);
        }
        view.setTranslationX(f8);
        view.setTranslationY(f9);
    }
}
