package androidx.core.view;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public interface x1 {
    int getNestedScrollAxes();

    boolean onNestedFling(@c.m0 View view, float f8, float f9, boolean z7);

    boolean onNestedPreFling(@c.m0 View view, float f8, float f9);

    void onNestedPreScroll(@c.m0 View view, int i7, int i8, @c.m0 int[] iArr);

    void onNestedScroll(@c.m0 View view, int i7, int i8, int i9, int i10);

    void onNestedScrollAccepted(@c.m0 View view, @c.m0 View view2, int i7);

    boolean onStartNestedScroll(@c.m0 View view, @c.m0 View view2, int i7);

    void onStopNestedScroll(@c.m0 View view);
}
